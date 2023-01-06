package OnlineShoping.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDAO {

    private Long id;

    private String addressName;
    private String country;
    private String city;
    private String region;
    private String postCode;
    private String street;
    private String streetNo;
    private String name;
    private String lastName;
    private String phoneNumber;
    private Long userID;
}
