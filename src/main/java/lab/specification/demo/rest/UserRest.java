package lab.specification.demo.rest;

import lab.specification.demo.entity.User;
import lab.specification.demo.repository.UserRepository;
import lab.specification.demo.repository.specification.UserSpecification;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value="/user")
public class UserRest {

    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/encontrar-usuario")
    public ResponseEntity<List<User>> emailExists(@RequestParam String firstName, @RequestParam String lastName){
        Specification<User> spec = Specification.where(UserSpecification.byFirstName(firstName)).and(UserSpecification.byLastName(lastName));

        return ResponseEntity.ok(userRepository.findAll(spec));
    }
}
