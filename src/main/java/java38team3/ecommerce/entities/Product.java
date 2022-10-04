package java38team3.ecommerce.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    ProductCategory productCategory;
    @OneToMany(fetch =FetchType.LAZY,mappedBy = "product")
    List<Specification> specifications;

    @ManyToOne(fetch = FetchType.LAZY)
    Producer producer;
    @Id
    @GeneratedValue
    Long id;


}
