package com.antouela.postrquestapi;

public class Doctor {

    private Integer id;
    private String fName;
    private String lName;
    private String proff;

    public Doctor(String fName, String lName, String proff) {
        this.fName = fName;
        this.lName = lName;
        this.proff = proff;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getProff() {
        return proff;
    }

    public void setProff(String proff) {
        this.proff = proff;
    }
}
