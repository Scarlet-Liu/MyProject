package reflectTest;

public class RealObject implements Interface {

	@Override
	public void doSomeThing() {
		
		System.out.println("doSomeThing.");
	}

	@Override
	public void someThingElse(String arg) {
		
		System.out.println("someThingElse."+arg);
	}

}
