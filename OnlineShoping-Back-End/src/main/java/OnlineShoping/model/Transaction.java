package OnlineShoping.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    private String description;
    private Set<Products> products;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    private String state;



}
