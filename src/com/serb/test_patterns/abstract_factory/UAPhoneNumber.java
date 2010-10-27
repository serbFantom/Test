package com.serb.test_patterns.abstract_factory;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 18.03.2008
 * Time: 16:26:04
 * To change this template use File | Settings | File Templates.
 */
public class UAPhoneNumber extends PhoneNumber {
    private static final String COUNTRY_CODE = "03";
    private static final int NUMBER_LENGTH = 7;

    public String getCountryCode() { 
        return COUNTRY_CODE;
    }
    //
    public void setPhoneNumber(String newNumber){
        if (newNumber.length() == NUMBER_LENGTH){
            super.setPhoneNumber(newNumber) ;
        }
    }
}
