package com.ljx.spring.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ljx.spring.entity.Person;
public class SpringTest {
	@Test
	public void test1() {
		//ApplicationContext是一IOC容器接口
		//它所创建的对象都称作是bean，也就是xml文件里的<bean id=" " class=" "></bean>这行配置信息
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//getBean方法就是从IoC容器里取得这个对象（根据标识id 和类名class），然后我们就可以调用该类的方法
		Person person = context.getBean("person", Person.class);
		System.out.println(person.toString());
	}
}
