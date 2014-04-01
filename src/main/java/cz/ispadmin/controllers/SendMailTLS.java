package cz.ispadmin.controllers;

import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author Maya
 */
public class SendMailTLS {
    public static void sendMail(String mail, String userName, String sendedPassword) {
 
		final String username = "zadat mail!! user@gmail.com";
		final String password = "zadat heslo!!";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(mail));
			message.setSubject("Zaslání hesla z teranet.cz");
			message.setText("Dobrý den,\nVaše přihlašovací jméno na portál teranet.cz je: "
                                + userName + ", a Vaše heslo je:"
				+ sendedPassword + ".\nDoporučujeme po přihlášení Vaše heslo změnit za nové.\n"
                                + "Děkujeme za pochopení. \n\nTato zpráva je generována systémem, proto na ni neodpovídejte.");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
