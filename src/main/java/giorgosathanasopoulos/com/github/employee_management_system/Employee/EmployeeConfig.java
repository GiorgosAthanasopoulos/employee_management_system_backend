package giorgosathanasopoulos.com.github.employee_management_system.Employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {
    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> {
          Employee employee1 = new Employee("George Athans", "george.athans@gmail.com", "Senior Software Engineer", "https://avatars.githubusercontent.com/u/90207655?s=100&u=d43818a6af00781088677dd3098b4538841fc0fc&v=4￥");
          Employee employee2 = new Employee("Steve Tzeve", "steve.tzeve@gmail.com", "UI/UX Designer", "https://tse4.mm.bing.net/th?id=OIP.9OLanwqz0biqN8b9QijRqwHaHV&pid=Api&P=0");

          List<Employee> employeeList = List.of(employee1, employee2);

          employeeRepository.saveAll(employeeList);
        };
    }
}
