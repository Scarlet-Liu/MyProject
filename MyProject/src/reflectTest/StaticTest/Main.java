package reflectTest.StaticTest;

public class Main {

	public static void main(String[] args) {
		
		consumber(new RealObject());
		consumber(new SimpleProxy(new RealObject()));
		

	}
	public static void consumber(Interface obj){
		obj.doSomeThing();
		obj.doSomeThingElse("abc");
	}

}
