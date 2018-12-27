package poxyText.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 * @author Administrator
 *
 */
public class BookFacadeProxy implements InvocationHandler {

	private Object target;
	
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before");
		method.invoke(target, args);
		System.out.println("after");
		return null;
	}

}
