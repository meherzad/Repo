package Repo.model;

import org.apache.commons.mail.SimpleEmail;

//package EntityClass;
/**
 *
 * @author Meherzad
 */
public class EmailSample {

    public static void main(String args[]) {
        try {
            SimpleEmail email = new SimpleEmail();
            email.setAuthentication("meherzad.lahewala", "meherzadbca");
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setSSL(true);
            email.addTo("meherzad4u@gmail.com", "John Doe");
            email.setFrom("meherzad.lahewala@hotmail.com", "noreply");
            email.setSubject("Test message");
            email.setMsg("This is a simple test of commons-email");
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
