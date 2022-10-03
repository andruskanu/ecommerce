package java38team3.ecommerce.entities;

import javax.persistence.ManyToOne;

public class Specification {
    @ManyToOne
    Product product;
    String key;
    String value;
}
