package poxyText.staticPorxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountImpl countImpl = new CountImpl();  
        CountPorxy countProxy = new CountPorxy(countImpl);  
        countProxy.updateCount();  
        countProxy.queryCount();  
	}

}
