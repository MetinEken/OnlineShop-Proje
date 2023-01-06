package OnlineShoping.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long basketId;


   private Long productsId;

    private int piece;

    @ManyToOne
    @JoinColumn(name ="user_id" )
    private User user;

}
