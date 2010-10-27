package com.serb.test_patterns.abstract_factory;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 18.03.2008
 * Time: 14:09:09
 * To change this template use File | Settings | File Templates.
 */
public abstract class Address {
    private String street;
    private String city;
    private String region;
    private String postalCode;

    public static final String EOL_STRING = System.getProperty("line.separator");
    public static final String SPACE = " ";

    public String getStreet(){
        return street; }
    public String getCity() {
        return city;
    }
    public String getPostalCode(){
        return postalCode;
    }
    public String getRegion() {
        return region;
    }
    public abstract String getCountry();

    public String getFullAddress(){
        return street + EOL_STRING +city + SPACE + postalCode + EOL_STRING;
    }

    public void setStreet(String newStreet) {
        street = newStreet;
    }
    public void setCity(String newCity) {
        city = newCity;
    }
    public void setRegion(String newRegion) {
        region = newRegion;
    }
    public void setPostalCode(String newPostalCode) {
        postalCode =newPostalCode;
    }
}
