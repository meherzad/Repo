package Repo.model;

import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Admin
 */
public class sendMail {
   
    public static boolean SendEmail(String toAddress, String subject, String msgBody) {
	boolean result;
        
        try {
            SimpleEmail email = new SimpleEmail();
            email.setAuthentication("mscitcodewala@gmail.com", "pirates2011");
            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(465);
            email.setSSL(true);
            email.addTo(toAddress, "");
            email.setFrom("mscitcodewala@gmail.com", "noreply");
            email.setSubject(subject);
            email.setMsg(msgBody);
            email.send();
		result=true;
        } catch (Exception e) {
            e.printStackTrace();
		result=false;
        }
	return result;
    }
    

}