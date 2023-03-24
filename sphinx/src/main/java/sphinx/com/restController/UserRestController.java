package sphinx.com.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sphinx.exception.AppException;

import com.sphinx.exception.AppException;

import sphinx.com.entity.User;
import sphinx.com.service.UserService;

@RequestMapping("sphinx/user")
@RestController
public class UserRestController {

	@Autowired
	private UserService userService;

	@PostMapping("/regester")
	public ResponseEntity<User> regesterUser(@RequestBody User user) throws AppException{
		User u = userService.addUser(user);	
	   return new ResponseEntity<User>(u, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws AppException {
		User u = userService.updateUser(user);
		return new ResponseEntity<User>(u,HttpStatus.OK);
	}

	
	@GetMapping("/findUserByUserId/{id}")
	public ResponseEntity<List<User>> getUserByUserName(@PathVariable Integer id) throws AppException {
		List<User> user = userService.getUserByUserId(id);
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> checkOrders() throws AppException {
		List<User> usersList = userService.getUserAll();
		return new ResponseEntity<List<User>>(usersList, HttpStatus.OK);
	}

}
