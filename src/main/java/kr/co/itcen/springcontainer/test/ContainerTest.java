package kr.co.itcen.springcontainer.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import kr.co.itcen.springcontainer.user.User;

public class ContainerTest {

	public static void main(String[] args) {
		//testBeanFactory();
		testApplicationContext();
	}
	
	public static void testApplicationContext() {
		ApplicationContext appCtxt = new ClassPathXmlApplicationContext("config/user/applicationContext01.xml");
		
		//error : 같은 타입의 빈이 1개 이상 있는 경우 --> 타입으로 가져오면 예외 발생
		//User user1 = appCtxt.getBean(User.class);
		
		
		//getBean("id")으로 가져오기
		User user1 = (User)appCtxt.getBean("user1");
		System.out.println(user1);
		
		//getBean("name")으로 가져오기
		User usr2 = (User)appCtxt.getBean("usr2");
		System.out.println(usr2);
		
		
		//singleton 확인
		User user2 = (User)appCtxt.getBean("user2");
		System.out.println(usr2 == user2); // id와 name으로 user2, usr2를 가져왔지 때문에 동일 --> true
		
		// User(Long, String)으로 생성된 bean 가져오기
		User user3 = (User)appCtxt.getBean("user3");
		System.out.println(user3);

		// User()으로  생성되고 property 세팅을 한(setter를 사용한) bean 가져오기
		User user4 = (User)appCtxt.getBean("user4");
		System.out.println(user4);
		
		// DI 설정한 bean 가져오기
		User user5 = (User)appCtxt.getBean("user5");
		System.out.println(user5);

		// DI 설정한 bean 가져오기2
		User user6 = (User)appCtxt.getBean("user6");
		System.out.println(user6);

		
		//ConfigurableApplicationContext 인터페이스에 close 함수 포함
		((ConfigurableApplicationContext)appCtxt).close();
		
	}
	
	
	//현장에서 사용 X
	public static void testBeanFactory() {
		BeanFactory bf1 = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext01.xml"));
		User user = bf1.getBean(User.class);
		System.out.println(user);
		
		BeanFactory bf2 = new XmlBeanFactory(new ClassPathResource("config/user/applicationContext02.xml"));
		user = bf2.getBean(User.class);
		System.out.println(user);
	}
}
