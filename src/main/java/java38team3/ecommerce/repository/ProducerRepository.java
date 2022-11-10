package java38team3.ecommerce.repository;


       import com.funtastic4.buymystuff.model.Producer;
       import java38team3.ecommerce.entities.Producer;
       import org.springframework.data.jpa.repository.JpaRepository;
       import org.springframework.stereotype.Repository;

        import java.util.Optional;
@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {

    Optional<Producer> findProducerByName(String name);

}
