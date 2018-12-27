package com.ljx.spring.test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ljx.spring.entity.Person;
public class SpringTest {
	@Test
	public void test1() {
		//ApplicationContext��һIOC�����ӿ�
		//���������Ķ��󶼳�����bean��Ҳ����xml�ļ����<bean id=" " class=" "></bean>����������Ϣ
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		
		//getBean�������Ǵ�IoC������ȡ��������󣨸��ݱ�ʶid ������class����Ȼ�����ǾͿ��Ե��ø���ķ���
		Person person = context.getBean("person", Person.class);
		System.out.println(person.toString());
	}
}
