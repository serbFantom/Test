package com.serb.test_patterns.abstract_factory;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 18.03.2008
 * Time: 16:24:38
 * To change this template use File | Settings | File Templates.
 */
public class UAAddressFactory implements AddressFactory{
    public Address createAddress() {
        return new UAAddress();
    }

    public PhoneNumber createPhoneNumber() {
        return new UAPhoneNumber();
    }
}
