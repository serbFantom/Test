package com.serb.test_patterns.abstract_factory;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 18.03.2008
 * Time: 14:18:31
 * To change this template use File | Settings | File Templates.
 */
public class USAddressFactory implements AddressFactory {
    public Address createAddress() {
        return new USAddress();
    }

    public PhoneNumber createPhoneNumber() {
        return new USPhoneNumber();
    }
}