package sphinx.com.service;

import java.util.List;

import com.sphinx.exception.AppException;

import sphinx.com.entity.User;

public interface UserService {

	public User addUser(User user) throws AppException ;
	
	public User updateUser(User user) throws AppException ;

	public List<User> getUserAll() throws AppException ;

	public List<User> getUserByUserId(Integer id) throws AppException ;

}
