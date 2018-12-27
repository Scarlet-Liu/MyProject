package reflectTest;

import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		RealObject real = new RealObject();
		
		Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(), 
				new Class[] {Interface.class}, new DynamicPoxyHandler((Object)real));
		proxy.doSomeThing();
		proxy.someThingElse("abc");
	}

}
