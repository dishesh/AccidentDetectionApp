package jd.myapplication;

/**
 * Created by Dishesh on 02-03-2018.
 */

public class VehicleDTO {


    String owner,location,contact,registration;

    public VehicleDTO() {
        this.owner = "owner";
        this.location = "location";
        this.contact = "contact";
        this.registration = "registration";
    }

    public VehicleDTO(String registration,String owner, String location, String contact) {
        this.owner = owner;
        this.location = location;
        this.contact = contact;
        this.registration = registration;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}
