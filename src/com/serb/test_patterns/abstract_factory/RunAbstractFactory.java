package com.serb.test_patterns.abstract_factory;

/**
 * Created by IntelliJ IDEA.
 * User: sbezugliy
 * Date: 18.03.2008
 * Time: 15:40:12
 */
public class RunAbstractFactory {
    public static void main(String [] arguments) {
        System.out.println ("Example for the Abstract Factory pattern");
        System.out.println ();
        System.out.println(" (take a look in the RunPattern code. Notice that you can");
        System.out.println(" use the Address and PhoneNumber classes when writing");
        System.out.println(" almost all of the code. This allows you to write a very");
        System.out.println(" generic framework, and plug in Concrete Factories") ;
        System.out.println(" and Products to specialize the behavior of your code)");
        System.out.println();

        System.out.println("Creating U.S. Address and Phone Number:");
        /*
        AddressFactory USAddressFactory = new USAddressFactory();
        Address usAddress = USAddressFactory.createAddress();
        PhoneNumber usPhone = USAddressFactory.createPhoneNumber();
         */
        AddressFactory usAddressFactory = new USAddressFactory();
        Address usAddress = usAddressFactory.createAddress();
        PhoneNumber usPhone = usAddressFactory.createPhoneNumber();

        usAddress.setStreet("142 Lois Lane");
        usAddress.setCity("Metropolis");
        usAddress.setRegion("WY");
        usAddress.setPostalCode("54321");
        usPhone.setPhoneNumber("7039214722");

        System.out.println("U.S. address:");
        System.out.println(usAddress.getFullAddress() ) ;
        System.out.println("U.S. phone number:");
        System.out.println(usPhone.getPhoneNumber() ) ;
        System.out.println();
        System.out.println() ;
        //todo:realize french addresses
        System.out.println("Creating Ukraine Address and Phone Number:");
        AddressFactory uaAddressFactory = new UAAddressFactory();
        Address uaAddress = uaAddressFactory.createAddress();
        PhoneNumber uaPhone = uaAddressFactory.createPhoneNumber();

        uaAddress.setStreet("21 Chkalova");
        uaAddress.setCity("Kharkov");
        uaAddress.setPostalCode("61070");
        uaPhone.setPhoneNumber("7524133");

        System.out.println("Ukraine address:");
        System.out.println(uaAddress.getFullAddress());
        System.out.println("Ukraine phone number:");
        System.out.println(uaPhone.getPhoneNumber());
    }
}
