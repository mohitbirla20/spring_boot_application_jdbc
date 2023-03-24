package sphinx.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sphinx.com.dto.UserDTO;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	private String userName;
	private String address;
	private Integer age;
	private String contactNumber;

}
