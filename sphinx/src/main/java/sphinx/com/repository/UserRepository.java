package sphinx.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sphinx.com.entity.User;
import sphinx.com.utility.Enumeration.Status;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//	User findByIdAndStatusNot(Integer id, Status deleted);
	
}
