package com.serb.test_patterns.abstract_factory;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 18.03.2008
 * Time: 14:22:16
 * To change this template use File | Settings | File Templates.
 */
public class USAddress extends Address {
    private static final String COUNTRY = "UNITED STATES";
    private static final String COMMA = ",";
    public String getCountry() {
        return COUNTRY;
    }
    public String getFullAddress(){
        return getStreet() + EOL_STRING +getCity() + COMMA + SPACE +
            getRegion() +SPACE + getPostalCode() + EOL_STRING +COUNTRY + EOL_STRING;
    }
}
