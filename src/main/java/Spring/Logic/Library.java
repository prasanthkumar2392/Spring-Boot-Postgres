
package Spring.Logic;

import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Library extends ResourceSupport {

    @JsonCreator
    public Library(String libraryName, int quantity, double price) {
        
        this.libraryName = libraryName;
        this.quantity = quantity;
        this.price = price;
    }
    @NotBlank
    private String libraryName;
    private int quantity;
    private double price;

}
