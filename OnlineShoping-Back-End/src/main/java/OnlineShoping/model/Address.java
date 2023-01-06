package OnlineShoping.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
