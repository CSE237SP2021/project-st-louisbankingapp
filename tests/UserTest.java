import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserTest {
	
	@Test
	void EmptyList() {
		assertTrue(User.users.isEmpty());
	}
	
	@Test
	void createUser() {
		User user = new User("ayoub", "pass5236");
		User.addUser(user);
		assertTrue(User.users.contains(user));
		User.users.clear();
	}
	
	@Test
	void getUserByUsername() {
		User user = new User("ayoub", "pass5236");
		User.addUser(user);
		assertEquals(user, User.getUserByUsername("ayoub"));
		User.users.clear();
	}
	
	@Test
	void isUsernameUnique() {
		User user1 = new User("ayoub", "pass5236");
		User user2 = new User("benzzine", "pass8966");
		User.addUser(user1);
		User.addUser(user2);
		assertTrue(User.isUsernameUnique("andrew"));
		assertFalse(User.isUsernameUnique("ayoub"));
		User.users.clear();
	}
	
	@Test
	void authentication() {
		User user1 = new User("ayoub", "pass5236");
		User user2 = new User("benzzine", "pass8966");
		User.addUser(user1);
		User.addUser(user2);
		assertTrue(User.authentication("ayoub", "pass5236"));
		assertFalse(User.authentication("benzzine", "pass5236"));
		assertFalse(User.authentication("andrew", "pass5236"));
		assertFalse(User.authentication("andrew", "newpass"));
		User.users.clear();
	}
}
