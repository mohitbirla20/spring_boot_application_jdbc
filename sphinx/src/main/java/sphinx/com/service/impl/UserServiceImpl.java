package sphinx.com.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import sphinx.com.entity.User;
import sphinx.com.repository.UserRepository;
import sphinx.com.service.UserService;
import sphinx.com.utility.Enumeration.Status;

import com.sphinx.StringUtility;
import com.sphinx.exception.AppException;
import com.sphinx.localization.LocaleMessage;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User addUser(User request) throws AppException {
		if(StringUtility.isNullOrEmpty(request.getAddress())
        		|| StringUtility.isNullOrEmpty(request.getContactNumber())
        		|| StringUtility.isNullOrEmpty(request.getUserName())
        		|| StringUtility.isNullOrEmpty(request.getAge().toString())) 
        throw new AppException(LocaleMessage.getMessage("validation.parameter_missing", null), HttpStatus.BAD_REQUEST.value());	
        
		User user = new User();
		user.setAddress(request.getAddress());
		user.setAge(request.getAge());
		user.setContactNumber(request.getContactNumber());
		user.setUserName(request.getUserName());
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User request) throws AppException {
		// TODO Auto-generated method stub
		if (request.getUserid() == null) {
			throw new AppException(LocaleMessage.getMessage("validation.parameter_missing", null),
					HttpStatus.BAD_REQUEST.value());
		}
		
		User user = new User();
		Optional<User> userOPT = userRepository.findById(request.getUserid());
		if (!userOPT.isPresent()) {
			throw new AppException(LocaleMessage.getMessage("validation.compliance.not.found", null),
					HttpStatus.NOT_FOUND.value());
		}else {
			user = userOPT.get();
		}
		
		if (!StringUtility.isNullOrEmpty(request.getUserName())) {
			user.setUserName(request.getUserName());
		}
		
		if (!StringUtility.isNullOrEmpty(request.getUserName())) {
			user.setUserName(request.getUserName());
		}
		
		if (!StringUtility.isNullOrEmpty(request.getAddress())) {
			user.setAddress(request.getAddress());
		}
		
		if (!StringUtility.isNullOrEmpty(request.getAge().toString())) {
			user.setAge(request.getAge());
		}
		
		if (!StringUtility.isNullOrEmpty(request.getContactNumber())) {
			user.setContactNumber(request.getContactNumber());
		}
		
        if(StringUtility.isNullOrEmpty(request.getAddress())
        		|| StringUtility.isNullOrEmpty(request.getContactNumber())
        		|| StringUtility.isNullOrEmpty(request.getUserName())
        		|| StringUtility.isNullOrEmpty(request.getAge().toString()))
        throw new AppException(LocaleMessage.getMessage("validation.parameter_missing", null) , HttpStatus.BAD_REQUEST.value());
        
		return userRepository.save(user);
	}

	
	@Override
	public List<User> getUserAll() throws AppException  {
		// TODO Auto-generated method stub
		String sql = "SELECT userid, address, age, contact_number , user_name  FROM user";
		List<User> list = this.jdbcTemplate.query(sql , new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User response = new User();
				response.setUserid(rs.getInt("userid"));
                response.setAddress(rs.getString("address"));
                response.setAge(rs.getInt("age"));
                response.setContactNumber(rs.getString("contact_number"));
				return response;
			}
		},new Object[] {});    
		return list;
	}

	
	@Override
	public List<User> getUserByUserId(Integer id) throws AppException {
		// TODO Auto-generated method stub
		   StringBuilder sql = new StringBuilder();
	        
	       sql.append("SELECT userid , address , age, contact_number FROM user WHERE userid = "+id);
	        
	       List<User>  list= this.jdbcTemplate.query(sql.toString(), new RowMapper<User>()  {
	        @Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	User response = new User();
				response.setUserid(rs.getInt("userid"));
                response.setAddress(rs.getString("address"));
                response.setAge(rs.getInt("age"));
                response.setContactNumber(rs.getString("contact_number"));
				return response;
			}
	      }, new Object[] {});
	       			
		 return list;
	}

	
}
