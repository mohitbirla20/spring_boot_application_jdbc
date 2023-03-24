package sphinx.com.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sphinx.com.entity.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Integer userid;
	private String userName;
	private String address;
	private Integer age;
	private String contactNumber;
	
}
