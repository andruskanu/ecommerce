package java38team3.ecommerce.entities;

import javax.persistence.OneToMany;
import java.util.List;

public class Product {

    ProductCategory productCategory;
    @OneToMany
    List<Specification> specifications;
}
