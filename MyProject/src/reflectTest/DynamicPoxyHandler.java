package reflectTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * �н��ࣨ���ô�������
 * @author Administrator
 *
 */
public class DynamicPoxyHandler implements InvocationHandler{

	// ����һ��ί����Ķ���
	private Object proxyed;
	
	public DynamicPoxyHandler(Object proxyed) {
		this.proxyed = proxyed;
	}
	
	// ��������������������ã��������ͷ����Ĳ����б�
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("��������.");
		// ʵ�ֶ�ί���෽���ĵ��ã�������ʾί�������Ͳ���
		return method.invoke(proxyed, args);
	}

}
