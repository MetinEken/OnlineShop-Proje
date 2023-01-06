package OnlineShoping.payload.response;

import OnlineShoping.dao.UserDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {
    private UserDAO user;
    private String jwt;
}
