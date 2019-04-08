package mn.first;

import io.micronaut.context.annotation.Factory;
import mn.first.domain.User;

import javax.inject.Singleton;

@Singleton
public class UserFactory {

	User create(String id, String name, String email) {
		return new User(id, name, email);
	}
}
