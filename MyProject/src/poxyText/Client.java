package poxyText;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {

	public static void main(String[] args) {		
		
		ServiceImpl serviceImpl = new ServiceImpl();
		//serviceImpl.help();//I want to buy some book
		//System.out.println("====================================");
		InvocationHandler h = new DynamicPoxy(serviceImpl);
		Item item = (Item)Proxy.newProxyInstance(
				serviceImpl.getClass().getClassLoader(), 
				serviceImpl.getClass().getInterfaces(), h);
		
		Service service = (Service)Proxy.newProxyInstance(
				serviceImpl.getClass().getClassLoader(), 
				serviceImpl.getClass().getInterfaces(), h);
		item.test();		
		
		service.help("aaa");
		

	}

}
