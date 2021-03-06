package com.switchfully.jan.order.instances;

import java.util.UUID;

public abstract class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private String phoneNumber;

    public Person(String id, String firstName, String lastName, String email, Address address, String phoneNumber) {
        if (id == null)
            this.id = UUID.randomUUID().toString();
        else
            this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
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
}
