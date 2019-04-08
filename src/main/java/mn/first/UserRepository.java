package mn.first;


import mn.first.domain.User;

import java.util.List;

public interface UserRepository {
	User getUser(String id);
	User saveUser(User user);
	User deleteUser(String id);
	List<User> fetchAllUsers();
}
