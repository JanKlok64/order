package com.switchfully.jan.order.controlers.dto;

import com.switchfully.jan.order.instances.Address;

public class AddAdminDto {
    private String uuid;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;

    public String getUuid() {
        return uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AddAdminDto setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public AddAdminDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public AddAdminDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public AddAdminDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public AddAdminDto setAddress(Address address) {
        this.address = address;
        return this;
    }

    public AddAdminDto setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
