package reflectTest.StaticTest;
/**
 * ί����
 * @author Administrator
 *
 */
public class RealObject implements Interface {

	@Override
	public void doSomeThing() {
		System.out.println("doSomeThing.");
	}

	@Override
	public void doSomeThingElse(String arg) {
		System.out.println("doSomeThingElse."+arg);
	}

}
