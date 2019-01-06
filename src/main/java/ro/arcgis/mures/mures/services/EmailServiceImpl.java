package ro.arcgis.mures.mures.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import ro.arcgis.mures.mures.models.MailDto;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender emailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    public void sendMailToAdmin(MailDto mailDetails) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("arcgismailsendder@gmail.com");
        message.setSubject("New Incident");
        message.setText(
                "An incident was reported at "
                        + mailDetails.location
                        + " of type "
                        + mailDetails.incidentType
                        + "."
                        + "\nThe incident was reported by "
                        + mailDetails.sender
                        + " and has the following description "
                        + "\n\n \"" + mailDetails.description + "\"");
        emailSender.send(message);
    }
}