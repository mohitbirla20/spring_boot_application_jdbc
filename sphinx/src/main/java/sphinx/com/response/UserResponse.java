package sphinx.com.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserResponse {

	private Integer userId;
	private String userName;
	private Integer age;
	
}
