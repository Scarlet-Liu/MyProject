package poxyText;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicPoxy implements InvocationHandler {
	
	//�����������Ҫ	�������ʵ����This is the real object that we're going to represent
	private Object service;
	
	//���췽����������Ҫ�������ʵ���󸳳�ֵ
	//Constructor that gives an initial value to the real object that we want to proxy
	public DynamicPoxy(Object obj) {
		this.service = obj;
	}

	@Override
	public Object invoke(Object obj, Method method, Object[] args) throws Throwable {
		//�ڴ�����ʵ����ǰ���ǿ������һЩ�Լ��Ĳ���
		System.out.println("�ڴ�����ʵ����ǰ�Ĳ���");
		System.out.println("Method:" +method);
		//��������������ʵ����ķ���ʱ������Զ�����ת��������������handler�����invoke���������е���
		method.invoke(service, args);
		//�ڴ�����ʵ���������Ҳ�������һЩ�Լ��Ĳ���
        System.out.println("�ڴ�����ʵ�����Ĳ���");
		return null;
	}

}
