package kr.co.itcen.springcontainer.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.user.UserConfig01;
import kr.co.itcen.springcontainer.user.User;

public class JavaConfigTest {

	public static void main(String[] args) {
		testUser01();
		testUser02();

	}
	
	//명시적(explicit) [Java Config Class] : Jaca Config Class를 명시한다. (xplicit Configuration)
	public static void testUser01() {
		ApplicationContext appCntx = new AnnotationConfigApplicationContext(UserConfig01.class); //explicit
		
		User user = appCntx.getBean(User.class);
		System.out.println(user);
		
		//ConfigurableApplicationContext 인터페이스에 close 함수 포함
		((ConfigurableApplicationContext)appCntx).close();
	}
	
	
	//2. 자동으로 Jaca Config Class를 Scan한다.(auto-scan)
	public static void testUser02() {
		ApplicationContext appCntx = new AnnotationConfigApplicationContext("config.user"); //explicit

		User user = appCntx.getBean(User.class);
		System.out.println(user);

		//ConfigurableApplicationContext 인터페이스에 close 함수 포함
		((ConfigurableApplicationContext)appCntx).close();
	}

}
