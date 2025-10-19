package utils;

import java.io.File;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Multipart;

public class Mailer {
	
	public static boolean sendMail(String from, String to, String subject, String body, File file) {
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.host","smtp.gmail.com");
		props.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.setProperty("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				String username = "gaudomun@gmail.com";
				String password = "rbvb ugna zyqs jfmf";
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(body, "UTF-8", "html");
			message.setReplyTo(message.getFrom());
			
			//Attach file
			Multipart multipart = new MimeMultipart();
			
			MimeBodyPart textPart = new MimeBodyPart();
			textPart.setContent(body, "text/html; charset=UTF-8");
			multipart.addBodyPart(textPart);
			
			if(file != null && file.exists()) {
				MimeBodyPart filePart = new MimeBodyPart();
				filePart.setDataHandler(new DataHandler(new FileDataSource(file)));
				filePart.setFileName(file.getName());
				multipart.addBodyPart(filePart);
			}
			
			message.setContent(multipart);
			Transport.send(message);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
