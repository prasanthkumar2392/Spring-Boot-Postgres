package Spring.Bill;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Component
@Table(name="Billing")
@Entity
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private  String name ;
    private String metrics;
}
