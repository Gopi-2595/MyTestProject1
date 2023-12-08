package Email;

import java.io.File;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.testng.annotations.Test;

public class ReportSendByEmail {
	

		 

		@Test
		public void sendMail() throws EmailException {
			// TODO Auto-generated method stub

	 

			System.out.println("mail Start to Prepare");

	 

//			Take the latest Generated Report
			File dir = new File(System.getProperty("user.dir") + "\\report\\");
			File[] files = dir.listFiles();
			File fileAttachName = files[files.length - 1];
			System.out.println(fileAttachName);

	 

			// Create the attachment
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(fileAttachName.toString());
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("My Report");
			attachment.setName("MyTestCase");
			
	 

			// Create the email message
			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);

	 

			email.setAuthenticator(new DefaultAuthenticator("aakibqureshi313@gmail.com", "qgjf bcvs hjvh fubb"));
			email.setSSLOnConnect(true);
			email.addTo("aakib.qureshi@fourcolorstech.com", "Aakib Qureshi");
			email.setFrom("aakibqureshi313@gmail.com", "akiii Kumar");
			email.setSubject("My report  is attached");
			email.setMsg("Here is the report you wanted");

	 

			// add the attachment
			email.attach(attachment);
			email.send();

	 

			System.out.println("mail sent");
		}

	 

	}

