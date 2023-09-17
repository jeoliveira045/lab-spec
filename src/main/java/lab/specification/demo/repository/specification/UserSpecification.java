package lab.specification.demo.repository.specification;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import lab.specification.demo.entity.User;
import org.springframework.data.jpa.domain.Specification;

import java.util.function.Predicate;

public class UserSpecification{

    public static Specification<User> byFirstName(String firstname){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("firstName"), firstname)
        );
    }

    public static Specification<User> byLastName(String lastName){
        return ((root, cq, cb) -> cb.equal(root.get("lastName"), lastName));
    }

}
