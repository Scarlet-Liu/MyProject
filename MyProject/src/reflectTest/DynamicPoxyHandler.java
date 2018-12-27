package reflectTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 中介类（调用处理器）
 * @author Administrator
 *
 */
public class DynamicPoxyHandler implements InvocationHandler{

	// 保存一个委托类的对象
	private Object proxyed;
	
	public DynamicPoxyHandler(Object proxyed) {
		this.proxyed = proxyed;
	}
	
	// 三个参数：代理类的引用，方法名和方法的参数列表
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("代理工作了.");
		// 实现对委托类方法的调用，参数表示委托类对象和参数
		return method.invoke(proxyed, args);
	}

}
