package mn.first;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.reactivex.Single;
import mn.first.domain.User;

import javax.inject.Inject;
import java.util.List;

@Controller("/users")
public class UserController {

	@Inject
	UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Get(produces = MediaType.APPLICATION_JSON)
	public List<User> allUsers() {
		return userRepository.fetchAllUsers();
	}

	@Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public User getUser(@PathVariable("id") String id) {
		return userRepository.getUser(id);
	}

	@Put(consumes = MediaType.APPLICATION_JSON)
	public User putUser(@Body User user) {
		return userRepository.saveUser(user);
	}


	@Delete(value ="/{id}")
	public User deleteUser(@PathVariable("id") String id) {
		return userRepository.deleteUser(id);
	}

}
