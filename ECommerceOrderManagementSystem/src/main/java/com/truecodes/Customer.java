package com.truecodes;

public class Customer {
    private String name;
    private String email;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer(String name, String email, String address) {
            this.name = name;
            this.email = email;
            this.address = address;
        }

        public String get_contact_info(){
            return "Name: "+getName()+"\nEmail: "+getEmail()+"\nAddress: "+getAddress();
        }

}
