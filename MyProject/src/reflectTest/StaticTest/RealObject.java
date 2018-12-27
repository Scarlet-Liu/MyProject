package reflectTest.StaticTest;
/**
 * Î¯ÍÐÀà
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
