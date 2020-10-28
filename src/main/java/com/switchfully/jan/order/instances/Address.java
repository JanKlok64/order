package com.switchfully.jan.order.instances;

public class Address {
    private String street;
    private String houseNumber;
    private String postalCode;
    private String cityName;

    public Address(String street, String houseNumber, String postalCode, String cityName) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.cityName = cityName;
    }

    public String getStreet() {
        return street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCityName() {
        return cityName;
    }
}
