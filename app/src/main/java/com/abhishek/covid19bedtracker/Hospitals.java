package com.abhishek.covid19bedtracker;

public class Hospitals {

    private String availbeds;
    private String totalbeds;
    private String availventi;
    private String totalventi;
    private String availoxi;
    private String totaloxi;
    private String hospname;
    private String contactno;
    private String address;

    public Hospitals() {}
    public Hospitals(String availbeds,String totalbeds,String availventi,String totalventi,String hospname,String availoxi,String totaloxi,String contactno,String address){
        this.availbeds = availbeds;
        this.totalbeds = totalbeds;
        this.availventi = availventi;
        this.totalventi = totalventi;
        this.availoxi = availoxi;
        this.totaloxi = totaloxi;
        this.hospname = hospname;
        this.contactno = contactno;
        this.address = address;
    }

    public String getAvailbeds() {
        return availbeds;
    }

    public void setAvailbeds(String availbeds) {
        this.availbeds = availbeds;
    }

    public String getTotalbeds() {
        return totalbeds;
    }

    public void setTotalbeds(String totalbeds) {
        this.totalbeds = totalbeds;
    }

    public String getAvailventi() {
        return availventi;
    }

    public void setAvailventi(String availventi) {
        this.availventi = availventi;
    }

    public String getTotalventi() {
        return totalventi;
    }

    public void setTotalventi(String totalventi) {
        this.totalventi = totalventi;
    }

    public String getHospname() {
        return hospname;
    }

    public void setHospname(String hospname) {
        this.hospname = hospname;
    }

    public String getAvailoxi() {
        return availoxi;
    }

    public void setAvailoxi(String availoxi) {
        this.availoxi = availoxi;
    }

    public String getTotaloxi() {
        return totaloxi;
    }

    public void setTotaloxi(String totaloxi) {
        this.totaloxi = totaloxi;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
