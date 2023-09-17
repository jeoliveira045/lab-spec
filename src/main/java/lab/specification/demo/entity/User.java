package lab.specification.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="CUSTOMUSER")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_USER")
    @SequenceGenerator(initialValue = 1,allocationSize = 1, name = "SEQ_USER")
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private int age;
}
