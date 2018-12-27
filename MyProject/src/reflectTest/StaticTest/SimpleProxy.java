package reflectTest.StaticTest;
/**
 *静态代理类
 * @author Administrator
 *
 */
public class SimpleProxy implements Interface {

	//保存委托类
	private Interface proxyed;
	//传入委托类的对象用于初始化
	public SimpleProxy(Interface proxy){
		this.proxyed = proxy;
	}
	
	//两个同名方法还实现其他功能
	@Override
	public void doSomeThing() {
		System.out.println("SimpleProxy.doSomeThing");
		//proxyed.doSomeThing();
	}

	@Override
	public void doSomeThingElse(String arg) {
		System.out.println("SimpleProxy.doSomeThingElse"+arg);
		//proxyed.doSomeThingElse(arg);
	}

}
