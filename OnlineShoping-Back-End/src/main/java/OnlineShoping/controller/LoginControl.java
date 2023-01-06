package OnlineShoping.controller;

import OnlineShoping.config.jwt.JwtUtil;
import OnlineShoping.dao.UserDAO;
import OnlineShoping.model.Role;
import OnlineShoping.model.User;
import OnlineShoping.model.UserRole;
import OnlineShoping.payload.request.LoginForm;
import OnlineShoping.payload.request.SignUpForm;
import OnlineShoping.payload.response.LoginResponse;
import OnlineShoping.payload.response.Response;
import OnlineShoping.repository.RoleRepo;
import OnlineShoping.repository.UserRepo;
import OnlineShoping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginControl {
    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder encoder; // burada bunu kullanmadan once securityconfigde bunu bean yapmaliyiz, obje olarak tanimlamaliyiz

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody SignUpForm signUpForm){

        Response response = new Response(); // verilecek cevabin olusturuldugu gecici class
        // eger kullanici adi daha once alinmissa ==========
        if(userRepo.existsByUsername(signUpForm.getUsername())){
            response.setMessage("Error: Username is already taken");
            response.setSucces(false);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        // eger email daha once kayit yapilmissa
        if(userRepo.existsByEmail(signUpForm.getEmail())){
            response.setMessage("Error: Email is already taken");
            response.setSucces(false);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }

        // username ve email gecerli ise database e useri kaydedelim. ============ !!!!!
       // registerdan gelen bilgiler signupformunun icinde, onlari user clasina aktarip save yapacagiz.
        // user clasindaki parametreli constructur ile yeni bir obje olusturuyoruz.
        // parametrelicont sirasina gore burada ekleme yapiyoruz
        User user= new User(signUpForm.getUsername(),
                encoder.encode(signUpForm.getPassword()),
                signUpForm.getFirstName(),
                signUpForm.getLastName(),
                signUpForm.getEmail()
                );
// yukarida sadece user tablosuna ekleme yapacagimiz formu doldurduk
        // asagida dda userrole tablosuna ekleme yapacagiz. hepsini user icerisine ekliyoruz
        Set <UserRole> userRoles = new HashSet<>(); // rolleri kaydedecegimiz role objesi olusturduk
        Set <String> stringRoles = signUpForm.getRole(); // registerdan gelen rolleri aldik

        stringRoles.forEach(roleName -> {
            Role role = roleRepo.findByName(roleName).
                    orElseThrow(() -> new RuntimeException("User Role Not Found"));
            userRoles.add(new UserRole(user, role));
                });
// aslinda dAO clasinda yazmamiz gerekiyordu, kestirmeden yazmis olduk,
        user.setUserRoles(userRoles);
        userRepo.save(user);
        response.setMessage("user Register successfuly");
        response.setSucces(true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginForm loginForm){

        Authentication authentication= authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(), loginForm.getPassword()));

        //==1==diger layerlardan okunablmesi icin burda global bir user olusturuyoruz.
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //==2==verileri asagida olusturdugumuz user objesine atadik. getprincipal verileri okumamizi sagliyor.
        User user = (User) authentication.getPrincipal();

        //==3==jwt olusturuyoruz
        // bizimverdigimiz authentication bilgileri ile bir jwt olusturuyorz
        String jwt =jwtUtil.generateToken(authentication);

        // database den cektigimiz verileri userDAO clasina kaydettik, artik islemleri userDAO clasindan devam edecegiz.
        UserDAO userDAO = userService.getUserDAO(user);


return ResponseEntity.ok(new LoginResponse(userDAO, jwt));
    }
}
