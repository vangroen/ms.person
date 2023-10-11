package com.owner.ms.person.dto;

public class PersonDTO {

    private String perId;
    private String perUUID;
    private String perNombre;
    private String perApellido;
    private String perDocumento;
    private String perEmail;
    private String perCelular;

    public PersonDTO() {
    }

    public PersonDTO(String perId, String perUUID, String perNombre, String perApellido, String perDocumento, String perEmail, String perCelular) {
        this.perId = perId;
        this.perUUID = perUUID;
        this.perNombre = perNombre;
        this.perApellido = perApellido;
        this.perDocumento = perDocumento;
        this.perEmail = perEmail;
        this.perCelular = perCelular;
    }

    public String getPerId() {
        return perId;
    }

    public void setPerId(String perId) {
        this.perId = perId;
    }

    public String getPerUUID() {
        return perUUID;
    }

    public void setPerUUID(String perUUID) {
        this.perUUID = perUUID;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public String getPerDocumento() {
        return perDocumento;
    }

    public void setPerDocumento(String perDocumento) {
        this.perDocumento = perDocumento;
    }

    public String getPerEmail() {
        return perEmail;
    }

    public void setPerEmail(String perEmail) {
        this.perEmail = perEmail;
    }

    public String getPerCelular() {
        return perCelular;
    }

    public void setPerCelular(String perCelular) {
        this.perCelular = perCelular;
    }
}
