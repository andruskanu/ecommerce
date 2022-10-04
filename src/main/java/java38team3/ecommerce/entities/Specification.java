package java38team3.ecommerce.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Specification {

    @Id
    @GeneratedValue
    Long id;
    @ManyToOne()
    Product product;
    String specificationKey;
    String value;
}
