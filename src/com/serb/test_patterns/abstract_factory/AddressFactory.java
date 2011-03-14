package com.serb.test_patterns.abstract_factory;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 18.03.2008
 * Time: 14:08:18
 */

public interface AddressFactory {
    public Address createAddress();
    public PhoneNumber createPhoneNumber();
}
