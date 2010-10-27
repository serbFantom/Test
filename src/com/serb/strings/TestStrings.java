package com.serb.strings;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class showing some aspects for working with String class
 * <p/>
 * User: SBezugliy
 * Date: 24.03.2009 17:32:11
 */
public class TestStrings {

    private static Logger log = Logger.getLogger(TestStrings.class.getName());

    static {
        PropertyConfigurator.configure("./conf/logging.properties");
    }

    public static void main(String[] args) throws IOException {
        /*String x = "    big surprise      ";
        System.out.print(x.trim());
        System.out.print("|");
        testStringBuilder();
        String str=capitalize("some string not in capital ksdhj dfjkl iewuriouwe weurfuew");
        System.out.println("str= "+str);

        //Play with Regex
        regexSmall(".", "abaa1aba");

        String dirList="proj3.txt,proj1sched.pdf,proj1,proj2,proj1.java";
        regexSmall("proj1([^,])*", dirList);*/
        //Play with Scanner
        //simpleScanner();

        //play with NumberFormat
        //numberFormatTest();
        //play with Locale
        testLocale();
    }

    /**
     * Method for as example how to work with StringBuilder
     */
    public static void testStringBuilder() {
        System.out.println("--------------------------------");
        System.out.println("testStringBuilder()");
        System.out.println("--------------------------------");
        //
        StringBuilder sb = new StringBuilder("abc");

        sb.append("def").reverse().insert(4, "---");
        System.out.println(sb.toString()); // output is "fed---cba"
    }

    /**
     * Capitalize words (derived with space) in string
     *
     * @param strOrig string to capitalize
     * @return capitalized string by words
     */
    public static String capitalize(String strOrig) {
        String strRes = String.format(strOrig.replaceAll("\\b(\\S)", "%S"),
                (Object[]) strOrig.replaceAll("\\b(\\S)\\S*", "$1").split("\\s+"));
        System.out.println("strOrig= " + strOrig);
        System.out.println("strRes= " + strRes);
        return strRes;
    }

    public static void regexSmall(String exprStr, String sourceStr) {
        log.info("-------------------regexSmall------------------------");
        log.info("Source string: " + sourceStr);
        log.info("Pattern: " + exprStr);
        Pattern p = Pattern.compile(exprStr); // the expression
        Matcher m = p.matcher(sourceStr); // the source
        boolean b;
        while (b = m.find()) {
            log.debug(m.start() + " " + m.group());
        }
        log.info("------------------END regexSmall------------------------- \n");
    }

    public static void simpleScanner() throws IOException {
        log.info("-------------------simpleScanner------------------------");
        System.out.print("input: ");
        System.out.flush();

        Scanner s = new Scanner(System.in);
        //
        String token = null;
        do {
            token = s.findInLine(Pattern.compile("in"));
            //System.out.println("found " + token);
            log.info("found: " + token);
        } while (token != null);
        //log.info("-------------------EMD simpleScanner------------------------ \n");
    }

    public static void numberFormatTest() {
        float f1 = 123.45678f;
        NumberFormat nf = NumberFormat.getInstance();
        System.out.print(nf.getMaximumFractionDigits() + " ");
        System.out.print(nf.format(f1) + " ");
        nf.setMaximumFractionDigits(5);
        System.out.println(nf.format(f1) + " ");
        try {
            System.out.println(nf.parse("1234.567"));
            nf.setParseIntegerOnly(true);
            System.out.println(nf.parse("1234.567"));
        } catch (ParseException pe) {
            System.out.println("parse exc");
        }

        log.info("Currency Code: " + nf.getCurrency().getCurrencyCode());
        log.info("Currency Symbol: " + nf.getCurrency().getSymbol());
    }

    public static void testLocale() {
        Calendar c = Calendar.getInstance();
        c.set(2010, 11, 14); // December 14, 2010
        // (month is 0-based
        Date d2 = c.getTime();
        Locale locIT = new Locale("it", "IT"); // Italy
        Locale locPT = new Locale("pt"); // Portugal
        Locale locBR = new Locale("pt", "BR"); // Brazil
        Locale locIN = new Locale("hi", "IN"); // India
        Locale locJA = new Locale("ja"); // Japan
        Locale locDK = new Locale("da", "DK"); // Denmark
        Locale locUA = new Locale("ua", "UA"); // Ukraine

        DateFormat dfUS = DateFormat.getInstance();
        System.out.println("US " + dfUS.format(d2));
        DateFormat dfUSfull = DateFormat.getDateInstance(
                DateFormat.FULL);
        System.out.println("US full " + dfUSfull.format(d2));
        DateFormat dfIT = DateFormat.getDateInstance(
                DateFormat.FULL, locIT);
        System.out.println("Italy " + dfIT.format(d2));
        DateFormat dfPT = DateFormat.getDateInstance(
                DateFormat.FULL, locPT);
        System.out.println("Portugal " + dfPT.format(d2));
        DateFormat dfBR = DateFormat.getDateInstance(
                DateFormat.FULL, locBR);
        System.out.println("Brazil " + dfBR.format(d2));
        DateFormat dfIN = DateFormat.getDateInstance(
                DateFormat.FULL, locIN);
        System.out.println("India " + dfIN.format(d2));
        DateFormat dfJA = DateFormat.getDateInstance(
                DateFormat.FULL, locJA);
        System.out.println("Japan " + dfJA.format(d2));

        //

        System.out.println("def " + locBR.getDisplayCountry());
        System.out.println("loc " + locBR.getDisplayCountry(locBR));
        System.out.println("def " + locDK.getDisplayLanguage());
        System.out.println("loc " + locDK.getDisplayLanguage(locDK));
        System.out.println("D>I " + locDK.getDisplayLanguage(locIT));

        //Ukraine
        System.out.println("Ukraine language " + locUA.getDisplayLanguage());
        System.out.println("Ukraine country " + locUA.getDisplayCountry());

        //
        Locale locHUI = new Locale("--", "---"); //test
        System.out.println("Hui language " + locHUI.getDisplayLanguage());
        System.out.println("Hui country " + locHUI.getDisplayCountry());
    }
}
