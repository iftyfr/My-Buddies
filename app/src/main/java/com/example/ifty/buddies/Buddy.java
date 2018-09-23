package com.example.ifty.buddies;

public class Buddy {
    int image;
    String name;
    String mobileNo;
    String email;
    String bloodGroup;
    String address;

    public Buddy(int image, String name, String mobileNo, String email, String bloodGroup, String address) {

        this.image = image;
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
        this.bloodGroup = bloodGroup;
        this.address = address;
    }
    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getAddress() {
        return address;
    }


}
