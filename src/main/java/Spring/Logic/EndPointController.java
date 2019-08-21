package Spring.Logic;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/endpoint")
public class EndPointController {

    @GetMapping("/getallinput")
    public String getallInputs() {
        return "lists all inputs";
    }

    @GetMapping("/gethateoas")
    public HttpEntity<Library> getName() {

        Library lb = new Library("pras", 1, 1.0);
        lb.add(linkTo(methodOn(EndPointController.class).getName()).withSelfRel());

        return new ResponseEntity<>(lb, HttpStatus.OK);

    }

    @GetMapping("/api")
    public List<String> add(@RequestParam(defaultValue = "test") List<String> name) {

        return name;
    }

    @GetMapping("/api1/{name}")
    public List<String> add1(@PathVariable List<String> name) {
        return name;
    }

}
