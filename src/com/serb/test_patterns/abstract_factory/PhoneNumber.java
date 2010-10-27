package com.serb.test_patterns.abstract_factory;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 18.03.2008
 * Time: 14:15:09
 * To change this template use File | Settings | File Templates.
 */
public abstract class PhoneNumber{
    private String phoneNumber;
    public abstract String getCountryCode();

    public String getPhoneNumber() { 
        return phoneNumber;
    }

    public void setPhoneNumber(String newNumber){
        try{
            Long.parseLong(newNumber) ;
            phoneNumber = newNumber;
        }
        catch (NumberFormatException exc){
        }
    }
}