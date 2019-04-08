package mn.first;

import mn.first.domain.User;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Singleton
public class UserRepositoryImpl implements UserRepository {

	Map<String, User> userMap = new HashMap<>();

	@Inject
	UserFactory userFactory;

	@PostConstruct
	void initialize()
	{
		userMap.put("1", userFactory.create("1","nogami_1", "nogami_1@example.com"));
		userMap.put("2", userFactory.create("2","nogami_2", "nogami_2@example.com"));
		userMap.put("3", userFactory.create("3","nogami_3", "nogami_3@example.com"));
	}

	public UserRepositoryImpl(UserFactory userFactory) {
		this.userFactory = userFactory;
	}

	public User getUser(String id) {
		return userMap.get(id);
	}

	public User saveUser(User user) {
		return userMap.put(user.getId(), user);
	}

	public User deleteUser(String id) {
		return userMap.remove(id);
	}

	public List<User> fetchAllUsers() {
		return userMap.values()
				.stream()
				.collect(Collectors.toList());
	}
}
