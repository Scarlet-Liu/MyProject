package poxyText.staticPorxy;
/**
 * ��̬����
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
		System.out.println("ǰ");
		countImpl.queryCount();
		System.out.println("��");
		
	}

	@Override
	public void updateCount() {
		// TODO Auto-generated method stub
		System.out.println("ǰ");
		countImpl.updateCount();
		System.out.println("��");
	}

}
