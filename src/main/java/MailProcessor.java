import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.time.LocalDateTime;
import java.util.Properties;

public class MailProcessor {

    String to, from, host, username;
    Properties properties;
    Session session;
    MimeMessage message;
    MimeBodyPart messageBodyPart;
    Multipart multipart;
    DataSource fileSource;
    static FileHandler fh;

    public MailProcessor(){
        to = "havard@alacho.no";
        from = "havard@alacho.no";
        host = "localhost";
        username = System.getProperty("user.name");
        properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        session = Session.getDefaultInstance(properties);
    }

    public void sendEmail(){
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(username + "'s hourly update");
            messageBodyPart.setText(username + "'s hourly logging update. Treat it with care");
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            fileSource = new FileDataSource(fh.getPathname());
            messageBodyPart.setDataHandler(new DataHandler(fileSource));
            messageBodyPart.setFileName(username + LocalDateTime.now());
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Mail sent");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
