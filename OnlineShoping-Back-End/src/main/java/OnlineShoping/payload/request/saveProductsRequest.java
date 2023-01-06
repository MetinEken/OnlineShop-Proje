package OnlineShoping.payload.request;

import OnlineShoping.model.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data

public class saveProductsRequest {

    private String specialId;
    private String name;
    private String type;
    private String model;
    private String trademark;
    private double price;
    private boolean isExist;
    private int stock;
    private String c1;
    private String c2;
    private String c3;
    private String c4;
    private String c5;
    private String c6;
    private String c7;
    private String c8;
    private String c9;
    private String c10;
    private String c11;
    private String c12;
    private String c13;
    private String c14;
    private String c15;
    private String c16;
    private String c17;
    private String c18;
    private String c19;
    private String c20;
    private String explanation;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String img5;
    private String img6;
    private String img7;
    private String img8;
    private String img9;
    private String img10;
    private Set<Category> category;

}
