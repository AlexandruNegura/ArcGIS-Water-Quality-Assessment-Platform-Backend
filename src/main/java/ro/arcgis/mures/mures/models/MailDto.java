package ro.arcgis.mures.mures.models;

import javax.validation.constraints.NotEmpty;

public class MailDto {
    @NotEmpty
    public String sender;
    @NotEmpty
    public String incidentType;
    @NotEmpty
    public String location;
    @NotEmpty
    public String description;
}
