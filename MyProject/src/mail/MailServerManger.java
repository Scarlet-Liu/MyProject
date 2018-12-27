package mail;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailServerManger {
	public static String senderAddress = "xxxx@163.com";
	public static String recipientAddress = "xxxx@163.com";
	public static String senderAccount = "xxxx@163.com";
	public static String senderPassword = "abc123";
	public MailServerManger() {
		
	}
	public static void main(String[] args) throws AddressException, MessagingException {
		new MailServerManger().sendMail();

	}
	public void sendMail() throws AddressException, MessagingException {
		Session session = createSession("true","smtp","smtp.163.com");
		Message msg = getMimeMessage(session);
		msg.addRecipient(Message.RecipientType.CC, new InternetAddress(senderAddress));
		Transport transport = session.getTransport();
		transport.connect(senderAccount, senderPassword);
		transport.sendMessage(msg, msg.getAllRecipients());

		transport.close();
	}
	
	public Session createSession(String auth,String protocol,String address) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", "smtp.163.com");
		Session session = Session.getInstance(props);
		session.setDebug(true);
		return session;
	}
	public MimeMessage getMimeMessage(Session session) throws AddressException, MessagingException {
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(senderAddress));
		msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recipientAddress));
		//msg.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(senderAddress));
		msg.setSubject("mail subject","UTF-8");
        msg.setContent("mail test from java....", "text/html;charset=UTF-8");
        msg.setSentDate(new Date());
		return msg;
	}

}
