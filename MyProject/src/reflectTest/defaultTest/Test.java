package reflectTest.defaultTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

	public static void main(String[] args) {
		Class class01 = getClass01();
		Class class02 = getClass02();
		Class class03 = getClass03();
		System.out.println((class01 == class02) && (class02 == class03));
		try {
			function(class01);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * ͨ��Person�Ķ������getClass()�������
	 */
	public static Class getClass01() {
		Person person = new Person();
		return person.getClass();
	}

	/*
	 * ͨ��Person��ĳ���class()ֱ�ӻ��
	 */
	public static Class getClass02() {
		return Person.class;
	}

	/*
	 * ͨ��Class���е�forName(String className)������ע�����ַ�������Ҫ�������ȫ��������.�����������һ��׳��쳣��
	 */
	public static Class getClass03() {
		Class classresult = null;
		try {
			classresult = Class.forName("reflectTest.defaultTest.Person");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		return classresult;
	}

	public static void function(Class clazz) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		// ��ȡ�����෽��֮������з���
		Method[] declaredMethods = clazz.getDeclaredMethods();
		// ��ȡ���е�public�����������̳еķ���
		Method[] publicMethods = clazz.getMethods();
		// ��ȡһ�������෽��֮��ķ���
		//Method read = clazz.getDeclaredMethod("read", String.class);
		// ��ȡһ�������е�public�����������̳еķ���
		Method toString = clazz.getMethod("toString", null);
		// �������һ���޲ζ���
		Object obj1 = clazz.newInstance();
		// �������һ�����ζ���
		// ��Ҫ���ȵõ������һ�����ι�������getConstructor����Ĳ�������ù�������Ҫ����������
		// Ȼ��ͨ����������������һ������
		Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
		Object obj2 = constructor.newInstance("Sara", 14);
		// ��ʾ��������
		System.out.println(obj1);
		System.out.println(obj2);
		// �������е�һ��public����
		// ��Ҫ�ȵõ��÷�����pay��
		//Method pay = clazz.getMethod("pay", double.class);
		//pay.invoke(obj2, 5.4);
		// �������е�һ��protect����
		Method drink = clazz.getDeclaredMethod("drink", String.class);
		drink.invoke(obj2, "water");
		// �������е�һ��default����
		Method eat = clazz.getDeclaredMethod("eat", String.class);
		eat.invoke(obj2, "noodles");
		// �������е�һ��private����,read����֮ǰ�ѵõ�
		// ��Ҫ�Ƚ�read�����ķ���Ȩ������Ϊ�ɼ�
		//read.setAccessible(true);
		//read.invoke(obj2, "Thinking in Java");

		for (Method method : declaredMethods) {
			System.out.println(method);
		}

		System.out.println("---------------");

		for (Method method : publicMethods) {
			System.out.println(method);
		}

	}
}
