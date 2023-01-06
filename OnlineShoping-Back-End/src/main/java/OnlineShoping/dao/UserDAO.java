package OnlineShoping.dao;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {

    private Long userId;
    private String username;
    @JsonIgnore
    private String password;
    private String lastName;
    private String firstName;
    private String email;
    private Boolean isAdmin;
    private Set<AddressDAO> addressDAOS;
}
