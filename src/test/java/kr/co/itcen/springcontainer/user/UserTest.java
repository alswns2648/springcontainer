package kr.co.itcen.springcontainer.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.user.UserConfig01;

@RunWith(SpringJUnit4ClassRunner.class) // @Test의 메소드를 실행(thread로 >> Test는 병렬로 실행한다) >> method 이름을 알바펫 순으로 하면 순서대로 됨
@ContextConfiguration(classes = {UserConfig01.class})

//Test Case
public class UserTest {
	
	@Autowired
	private User user;
	
	@Autowired
	private Friend friend;
	
	@Test
	//Container 안에 'user' 라는 bean이 생성되었는가 확인
	public void testUserNull() {
		//assert(user != null); // user는 null이 아니라고 단언한다
		assertNotNull(user);
	}
	
	@Test
	public void testFriendNull() {
		assertNotNull(friend);
	}
	
	@Test
	public void testFriendBabo() {
		assertEquals(friend.getName(), "바보");
		assertNotEquals(friend.getName(), "김민준");
	}
	

}