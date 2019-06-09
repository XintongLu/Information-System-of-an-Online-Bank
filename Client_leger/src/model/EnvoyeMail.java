package model;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnvoyeMail {
	
	public void EnvoyerMail(String email) throws AddressException, MessagingException{
	 Properties props = new Properties();
	 
	 //get l'address smtp ( @163.com )
     props.setProperty("mail.host", "smtp.163.com");
     //verifier l'authentification
     props.setProperty("mail.smtp.auth", "true");
     
     
    //assurer l'authentification
     Authenticator authenticator = new Authenticator() {
         @Override
         public PasswordAuthentication getPasswordAuthentication() {
             //id et code d'authen de l'emmeteur
             return new PasswordAuthentication("de_via_tion@163.com","projets8");
         }
     };


     
     Session session = Session.getDefaultInstance(props, authenticator);

     

     Message message = new MimeMessage(session);
     // emmeteur
     message.setFrom(new InternetAddress("de_via_tion@163.com"));
 
     
     message.setRecipient(RecipientType.TO, new InternetAddress(email));
     
     //titre
     message.setSubject("Confirmation Mail");
     //contenu
     String str = "Bonjour£º <br/>" +
             "<br/>" +
             "Merci d'avoir inscit sur notre E-Bank !<br/>" 
            ;
     message.setContent(str, "text/html;charset=UTF-8");
     
     
     //envoyer mail
     Transport.send(message);
   
    
     // si on a une erreur:com.sun.mail.smtp.SMTPSendFailedException: 554
     // -> est confirm¨¦ comme spam
 }
}

