import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MailProcesser {

    String to, from, host, username;
    Properties properties;
    Session session;
    MimeMessage message;
    MimeBodyPart messageBodyPart;
    Multipart multipart;
    DataSource fileSource;
    static FileHandler fh;

    protected MailProcesser(){
        to = "havard@alacho.no";
        from = "havard@alacho.no";
        host = "localhost";
        username = properties.getProperty("user.name");
        properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        session = Session.getDefaultInstance(properties);
    }

    protected void sendEmail(){
        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(username + "'s hourly update");
            messageBodyPart.setText(username + "'s hourly logging update. Treat it with care");
            multipart.addBodyPart(messageBodyPart);
            messageBodyPart = new MimeBodyPart();
            fileSource = new FileDataSource(fh.givePath());
            messageBodyPart.setDataHandler(new DataHandler(fileSource));

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
