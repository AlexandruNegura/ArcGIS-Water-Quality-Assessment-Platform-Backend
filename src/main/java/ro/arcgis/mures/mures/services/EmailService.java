package ro.arcgis.mures.mures.services;

import ro.arcgis.mures.mures.models.MailDto;

public interface EmailService {
    void sendMailToAdmin(MailDto mailDetails);
}
