package com.serb.strings;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;
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

    static Integer i;

    private static final String[] charTable = new String[81];

    private static final char START_CHAR = 'Ё';

    static {
        charTable['А' - START_CHAR] = "A";
        charTable['Б' - START_CHAR] = "B";
        charTable['В' - START_CHAR] = "V";
        charTable['Г' - START_CHAR] = "G";
        charTable['Д' - START_CHAR] = "D";
        charTable['Е' - START_CHAR] = "E";
        charTable['Ё' - START_CHAR] = "E";
        charTable['Ж' - START_CHAR] = "ZH";
        charTable['З' - START_CHAR] = "Z";
        charTable['И' - START_CHAR] = "I";
        charTable['Й' - START_CHAR] = "I";
        charTable['К' - START_CHAR] = "K";
        charTable['Л' - START_CHAR] = "L";
        charTable['М' - START_CHAR] = "M";
        charTable['Н' - START_CHAR] = "N";
        charTable['О' - START_CHAR] = "O";
        charTable['П' - START_CHAR] = "P";
        charTable['Р' - START_CHAR] = "R";
        charTable['С' - START_CHAR] = "S";
        charTable['Т' - START_CHAR] = "T";
        charTable['У' - START_CHAR] = "U";
        charTable['Ф' - START_CHAR] = "F";
        charTable['Х' - START_CHAR] = "H";
        charTable['Ц' - START_CHAR] = "C";
        charTable['Ч' - START_CHAR] = "CH";
        charTable['Ш' - START_CHAR] = "SH";
        charTable['Щ' - START_CHAR] = "SH";
        charTable['Ъ' - START_CHAR] = "'";
        charTable['Ы' - START_CHAR] = "Y";
        charTable['Ь' - START_CHAR] = "'";
        charTable['Э' - START_CHAR] = "E";
        charTable['Ю' - START_CHAR] = "U";
        charTable['Я' - START_CHAR] = "YA";

        for (int i = 0; i < charTable.length; i++) {
            char idx = (char) ((char) i + START_CHAR);
            char lower = new String(new char[]{idx}).toLowerCase().charAt(0);
            if (charTable[i] != null) {
                charTable[lower - START_CHAR] = charTable[i].toLowerCase();
            }
        }
    }

    static {
        PropertyConfigurator.configure("./conf/logging.properties");
    }


    public void method(Object o) {
        System.out.println("Object");
    }

    public void method(java.io.FileNotFoundException f) {
        System.out.println("FileNotFoundException");
    }

    public void method(java.io.IOException i) {
        System.out.println("IOException");
    }

    static String name = "Himalaya";

    static TestStrings getTestStrings() {
        System.out.println("Getting Name ");
        return null;
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
        //testLocale();

        //tmp tests
        /*TestStrings test= new TestStrings();
        test.method(null);*/
        //System.out.println(getTestStrings().name); //.name

        /*SingletonTst2 singleton = SingletonTst2.INSTANCE;

        singleton.printSomething();

        SingletonTst2 singleton2 = SingletonTst2.INSTANCE;

        singleton2.printSomething();*/
        /*String defaultString = "Это дефолтная строка";

        System.out.println("defaultString= "+defaultString);

        String strInOtherCoding = new String(defaultString.getBytes(), "koi8_r");//"cp1250"

        System.out.println("strInOtherCoding= "+strInOtherCoding);*/

        /*if (i == 0) {
        //NullPointerException
            System.out.println("interesting");
        } */

        final String test = "Привет, Мир. Это Длинная Строка с Разными символами русского алфавита.";
        System.out.println("toTranslit(test) = " + toTranslit(test));

        int MAX_ITERATION = 1000000;
        System.out.println("Test speed");
        long time = System.currentTimeMillis();
        for (int i = 0; i < MAX_ITERATION; i++) {
            toTranslit(test);
        }
        System.out.println((System.currentTimeMillis() - time));

        Runtime runTime = Runtime.getRuntime();
        long startMemory = runTime.freeMemory();
        //System.out.println("Runtime.getRuntime().freeMemory()= "+);
        Comparator<Integer> naturalOrder = new Comparator<Integer>() {
            public int compare(Integer first, Integer second) {
                return first < second ? -1 : (first == second ? 0 : 1);
            }
        };
        Random rand = new Random();

        int[] someArray = new int[100000];
        for (int i=0; i < someArray.length; i++)
        {
            someArray[i] = rand.nextInt(); 
        }
        long endMemory = runTime.freeMemory();

        TestStrings test1 = new TestStrings();
        TestStrings test2 = new TestStrings();
        TestStrings test3 = new TestStrings();
        TestStrings test4 = new TestStrings();
        TestStrings test5 = test1;
        System.out.println("System.identityHashCode(test1): "+System.identityHashCode(test1));
        System.out.println("System.identityHashCode(test2): "+System.identityHashCode(test2));
        System.out.println("System.identityHashCode(test3): "+System.identityHashCode(test3));

        test1.toString();

        Map testMap = new HashMap();
        testMap.put(1, test1);
        testMap.put(2, test2);
        testMap.put(3, test3);

        testMap.containsValue(test1);
        System.out.println("testMap.containsValue(test1): "+testMap.containsValue(test1));
        System.out.println("testMap.containsValue(test2): "+testMap.containsValue(test2));
        System.out.println("testMap.containsValue(test3): "+testMap.containsValue(test3));
        System.out.println("testMap.containsValue(test4): "+testMap.containsValue(test4));
        System.out.println("testMap.containsValue(test5): "+testMap.containsValue(test5));

        System.out.println("startMemory: "+ startMemory/1024);
        System.out.println("endMemory: "+ endMemory/1024);
        System.out.println("Used memory: "+ (startMemory-endMemory));

        //printAllAvailableCharsets();

        //Thread.dumpStack();
        final String semicolon =";";
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {

             strBuilder.append(rand.nextInt()).append(semicolon);
        }
        String strResult = strBuilder.toString();
        System.out.println("strResult.length= "+strResult.length());

    }


    /**
     * Переводит русский текст в транслит. В результирующей строке
     * каждая русская буква будет заменена на соответствующую английскую.
     * Не русские символы останутся прежними.
     *
     * @param text исходный текст с русскими символами
     * @return результат
     */
    public static String toTranslit(String text) {
        char charBuffer[] = text.toCharArray();
        StringBuilder sb = new StringBuilder(text.length());
        for (char symbol : charBuffer) {
            int i = symbol - START_CHAR;
            if (i >= 0 && i < charTable.length) {
                String replace = charTable[i];
                sb.append(replace == null ? symbol : replace);
            } else {
                sb.append(symbol);
            }
        }
        return sb.toString();
    }


    public void test() {
        //super.singleX=140;
    }

    public static void printAllAvailableCharsets() {
        SortedMap<String, Charset> charsetsMap = Charset.availableCharsets();
        System.out.println("Charsets available: " + charsetsMap.size());
        for (String name : charsetsMap.keySet()) {
            Charset charset = charsetsMap.get(name);
            StringBuffer sb = new StringBuffer();
            sb.append(name);
            sb.append(" (");
            for (Iterator<String> aliases = charset.aliases().iterator(); aliases.hasNext();) {
                sb.append(aliases.next());
                if (aliases.hasNext())
                    sb.append(",");
            }
            sb.append(")");
            System.out.println(sb.toString());
        }
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
