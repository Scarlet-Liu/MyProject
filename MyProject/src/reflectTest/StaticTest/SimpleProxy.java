package reflectTest.StaticTest;
/**
 *��̬������
 * @author Administrator
 *
 */
public class SimpleProxy implements Interface {

	//����ί����
	private Interface proxyed;
	//����ί����Ķ������ڳ�ʼ��
	public SimpleProxy(Interface proxy){
		this.proxyed = proxy;
	}
	
	//����ͬ��������ʵ����������
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
