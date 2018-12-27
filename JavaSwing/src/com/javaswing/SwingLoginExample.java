package com.javaswing;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SwingLoginExample {

	public static void main(String[] args) {
		//����JFrameʵ��
		JFrame jframe = new JFrame("Login");
		jframe.setSize(320,400);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		// ������
		jframe.add(panel);
		//�����û�����ķ����������������
		placeComponents(panel);
		// ���ý���ɼ�
        jframe.setVisible(true);
	}
	public static void placeComponents(JPanel panel) {
		panel.setLayout(null);
		// ���� JLabel
        JLabel userLabel = new JLabel("User:");
        /* ������������������λ�á�
         * setBounds(x, y, width, height)
         * x �� y ָ�����Ͻǵ���λ�ã��� width �� height ָ���µĴ�С��
         */
        userLabel.setBounds(10,20,80,25);
        panel.add(userLabel);

        /* 
         * �����ı��������û�����
         */
        JTextField userText = new JTextField(20);
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        // ����������ı���
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10,50,80,25);
        panel.add(passwordLabel);

        /* 
         *�����������������ı���
         * �����������Ϣ���Ե�Ŵ��棬���ڰ�������İ�ȫ��
         */
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100,50,165,25);
        panel.add(passwordText);

        // ������¼��ť
        JButton loginButton = new JButton("login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
	}

}
