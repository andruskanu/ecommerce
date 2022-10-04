package java38team3.ecommerce.entities;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

public class Producer {
    @OneToMany
    List<Product> products;

    @ManyToMany
    List<ProductCategory> productCategories;

}
