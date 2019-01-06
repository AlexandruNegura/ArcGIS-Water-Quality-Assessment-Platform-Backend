package ro.arcgis.mures.mures.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.arcgis.mures.mures.Constants;
import ro.arcgis.mures.mures.models.MailDto;
import ro.arcgis.mures.mures.services.EmailService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = MailController.MAIL_CONTROLLER_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
public class MailController {
    static final String MAIL_CONTROLLER_PATH = Constants.API_PATH + "/mails";

    private final EmailService emailService;

    @Autowired
    public MailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/send")
    @ResponseBody
    ResponseEntity sendMail(@Valid @RequestBody MailDto mailDetails) {
        emailService.sendMailToAdmin(mailDetails);
        return new ResponseEntity(HttpStatus.OK);
    }
}
