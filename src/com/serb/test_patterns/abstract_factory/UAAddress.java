package com.serb.test_patterns.abstract_factory;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 18.03.2008
 * Time: 14:41:51
 * To change this template use File | Settings | File Templates.
 */
public class UAAddress extends Address {
    private static final String COUNTRY = "URAINE";
    private static final String COMMA = ",";
    public String getCountry() {
        return COUNTRY;  
    }
}
