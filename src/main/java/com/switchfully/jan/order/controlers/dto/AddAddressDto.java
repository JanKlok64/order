package com.switchfully.jan.order.controlers.dto;

public class AddAddressDto {
    private String street;
    private String houseNumber;
    private String postalCode;
    private String cityName;

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

    public AddAddressDto setStreet(String street) {
        this.street = street;
        return this;
    }

    public AddAddressDto setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public AddAddressDto setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public AddAddressDto setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }
}
