package org.tec.ce.MediTEC;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSenderService {
    private static String correoRemitente = "meditec.webservice@gmail.com";
    private static String password = "wkgospp3";

    public static void sendEmail(String correoReceptor, String subject, String mensaje) {
        try {
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com"); //Nombre del host del correo
            props.setProperty("mail.smtp.starttls.enable", "true"); //TLS
            props.setProperty("mail.smtp.port", "587"); // Puerto de gmail para envio de correos
            props.setProperty("mail.smtp.user", correoRemitente); // Nombre del usuario
            props.setProperty("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente)); //Quien envia el correo

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor)); //A quien va dirigido

            message.setSubject(subject); //Se pone el subject del correo

            message.setText(mensaje); //Se pone el mensaje a enviar

            Transport t = session.getTransport("smtp");

            t.connect(correoRemitente, password);

            t.sendMessage(message, message.getAllRecipients()); //Se envia el mensaje

            t.close(); //Se cierra la conexion

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static void sendEmail(String correoReceptor, String subject, String mensaje, String nombreArchivo){
        try{
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com"); //Nombre del host del correo
            props.setProperty("mail.smtp.starttls.enable", "true"); //TLS
            props.setProperty("mail.smtp.port", "587"); // Puerto de gmail para envio de correos
            props.setProperty("mail.smtp.user", correoRemitente); // Nombre del usuario
            props.setProperty("mail.smtp.auth", "true");
            Session session = Session.getDefaultInstance(props);

            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(System.getProperty("user.dir") + "/" + nombreArchivo)));
            adjunto.setFileName(nombreArchivo);

            MimeMultipart multiParte = new MimeMultipart();

            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(correoRemitente)); //Quien envia el correo

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoReceptor)); //A quien va dirigido

            message.setSubject(subject); //Se pone el subject del correo

            message.setContent(multiParte); //Se pone el mensaje a enviar

            Transport t = session.getTransport("smtp");

            t.connect(correoRemitente, password);

            t.sendMessage(message, message.getAllRecipients()); //Se envia el mensaje

            t.close(); //Se cierra la conexion


        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    
}