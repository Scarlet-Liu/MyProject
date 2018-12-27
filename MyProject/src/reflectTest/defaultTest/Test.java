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
	 * 通过Person的对象调用getClass()方法获得
	 */
	public static Class getClass01() {
		Person person = new Person();
		return person.getClass();
	}

	/*
	 * 通过Person类的常量class()直接获得
	 */
	public static Class getClass02() {
		return Person.class;
	}

	/*
	 * 通过Class类中的forName(String className)方法。注意这种方法中需要传入类的全名（包名.类名），而且会抛出异常。
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

		// 获取除父类方法之外的所有方法
		Method[] declaredMethods = clazz.getDeclaredMethods();
		// 获取所有的public方法，包括继承的方法
		Method[] publicMethods = clazz.getMethods();
		// 获取一个除父类方法之外的方法
		//Method read = clazz.getDeclaredMethod("read", String.class);
		// 获取一个本类中的public方法，包括继承的方法
		Method toString = clazz.getMethod("toString", null);
		// 创建类的一个无参对象
		Object obj1 = clazz.newInstance();
		// 创建类的一个带参对象
		// 需要首先得到该类的一个带参构造器，getConstructor传入的参数代表该构造器需要的数据类型
		// 然后通过构造器构造该类的一个对象
		Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
		Object obj2 = constructor.newInstance("Sara", 14);
		// 显示两个对象
		System.out.println(obj1);
		System.out.println(obj2);
		// 运行类中的一个public方法
		// 需要先得到该方法（pay）
		//Method pay = clazz.getMethod("pay", double.class);
		//pay.invoke(obj2, 5.4);
		// 运行类中的一个protect方法
		Method drink = clazz.getDeclaredMethod("drink", String.class);
		drink.invoke(obj2, "water");
		// 运行类中的一个default方法
		Method eat = clazz.getDeclaredMethod("eat", String.class);
		eat.invoke(obj2, "noodles");
		// 运行类中的一个private方法,read方法之前已得到
		// 需要先将read方法的访问权限设置为可见
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
