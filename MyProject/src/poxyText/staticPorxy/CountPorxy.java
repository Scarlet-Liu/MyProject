package poxyText.staticPorxy;
/**
 * 静态代理
 * @author Administrator
 *
 */
public class CountPorxy implements Count{

	private CountImpl countImpl;
	public CountPorxy(CountImpl countImpl) {
		this.countImpl = countImpl;
	}
	@Override
	public void queryCount() {
		System.out.println("前");
		countImpl.queryCount();
		System.out.println("后");
		
	}

	@Override
	public void updateCount() {
		// TODO Auto-generated method stub
		System.out.println("前");
		countImpl.updateCount();
		System.out.println("后");
	}

}
