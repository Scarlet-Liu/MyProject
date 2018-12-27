package poxyText;

public class ServiceImpl implements Service, Item {

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("Test dynamic proxy.");
	}

	@Override
	public void help() {
		// TODO Auto-generated method stub
		System.out.println("I want to buy some book");
	}

	@Override
	public void help(String str) {
		// TODO Auto-generated method stub
		System.out.println("hello: " + str);
	}

}
