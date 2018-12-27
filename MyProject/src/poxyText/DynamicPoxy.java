package poxyText;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicPoxy implements InvocationHandler {
	
	//这个就是我们要	代理的真实对象This is the real object that we're going to represent
	private Object service;
	
	//构造方法，给我们要代理的真实对象赋初值
	//Constructor that gives an initial value to the real object that we want to proxy
	public DynamicPoxy(Object obj) {
		this.service = obj;
	}

	@Override
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		//在代理真实对象前我们可以添加一些自己的操作
		System.out.println("在代理真实对象前的操作");
		System.out.println("Method:" +method);
		//当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		method.invoke(service, args);
		//在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("在代理真实对象后的操作");
		return null;
	}

}
