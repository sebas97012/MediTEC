package org.tec.ce.MediTEC;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
            session.setDebug(true); // QUITAR

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