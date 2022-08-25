package giorgosathanasopoulos.com.github.employee_management_system.Employee;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_generator")
    @SequenceGenerator(name = "employee_id_generator", sequenceName = "employee_id_sequence")
    private long id;
    @Setter
    @NonNull
    private String name;
    @Setter
    @NonNull
    private String email;
    @Setter
    @NonNull
    private String jobPosition;
    @Setter
    @NonNull
    private String imgurl;

    @Override
    public String toString() {
        return String.format("Employee: {\n\tId: %d,\n\tName: %s,\n\tEmail: %s,\n\tJob Position: %s,\n\tImage URL: %s\n}", id, name, email, jobPosition, imgurl);
    }
}
