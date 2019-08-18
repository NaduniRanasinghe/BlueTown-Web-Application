package blueLite.com.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class HR_SendMail {

	    public static boolean send(String from, String username, String password, String to, String subject, final String message) {
	  
	    try {	
		Properties props = System.getProperties();
		
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.debug", "true");
		
		Session session = Session.getDefaultInstance(props, null);
		session.setDebug(true);
		
		Message msg = new MimeMessage(session);
		
		msg.setFrom(new InternetAddress(from));
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
		msg.setText(message);
		msg.setSubject(subject);
		
		Transport transport = session.getTransport("smtp");
		transport.connect("smtp.gmail.com", username, password);
		
		transport.sendMessage(msg, msg.getAllRecipients());
		return true;
			
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
		return false;   
		}
	    
}
