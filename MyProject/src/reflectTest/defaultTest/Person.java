package reflectTest.defaultTest;

public class Person {

	private String name;
	private int age;
	
	public Person() {
		
	}
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	 void eat(String food){
		 System.out.println("eat "+food);
	 }
	 protected void drink(String drink){
		 System.out.println("drink "+drink);
	 }
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	} 
	
}
