package com.systemintegration.utils;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.mail.*;
 
public class smtpTest extends Authenticator{
 
  public static void sendMail (String msg,String pass) throws AddressException, MessagingException  {
	  
	  
 
    String smtpHost ="smtp.gmail.com";
    String from = "watouyayo@gmail.com";
    String to = "olafho2009@yahoo.fr";//"si@thomas-preuss.de";
 //   String username = "dino watou";
    String password = pass;
// password="pepedino";
    Properties props = new Properties();
  //  Properties props = System.getProperties();
    //
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", smtpHost);
    
    //
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", password);
    props.put("mail.smtp.port", 587/*465*/);
    
    props.put("mail.smtp.auth", "true");
    
    //
    props.put("mail.smtp.socketFactory.port", 587/*465*/);
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.socketFactory.fallback", "false");
 
    //
    smtpTest auth = new smtpTest();
    Session session = Session.getDefaultInstance(props,auth);
    session.setDebug(true);
 
   MimeMessage message = new MimeMessage(session);   
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
    message.setSubject("Semesterprojekt bei Olaf Oumbe");
    message.setText(msg+": Hilfe! Hilfe!");
 
    Transport tr = session.getTransport("smtp");
    tr.connect(smtpHost,465,from, password);
   // message.saveChanges();
 
   //  tr.send(message);
    /** Genere l'erreur. Avec l authentification, oblige d utiliser sendMessage meme pour une seule adresse... */
    System.out.println("Mail envoyé");
   tr.sendMessage(message,message.getAllRecipients());
   tr.close();
 
  }
}