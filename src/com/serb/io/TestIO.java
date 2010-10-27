package com.serb.io;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;

/**
 * User: SBezugliy
 * Date: 24.03.2009 17:59:45
 */
public class TestIO {

    private static Logger log=Logger.getLogger(TestIO.class.getName());
    static {
        PropertyConfigurator.configure("D:\\Projects\\common_training\\conf\\logging.properties");
    }
    public static void main (String[] args) throws IOException {
        testFileObj();
    }

    public static void testFileObj() throws IOException {
        log.debug("------------------------");
        log.debug("testFileObj()");
        log.debug("------------------------");
        //System.out.println("------------------------");
        //
        //Create new file and wrote it on disk
        //
        File file=new File("c:\\tmp\\new");

        //using some filter
        File[] files=new File("c:\\tmp\\1\\testDir\\tt").listFiles();
        log.debug("Files in direcory= "+"c:\\tmp\\1\\testDir\\tt");
        for (int i=0;i<files.length;i++) {
            log.debug(i+1+")"+files[i].getName());
        }
        log.debug("File exists= "+file.exists());
        log.debug("File is writable= "+file.canWrite());

        file.createNewFile();
        //FileWriter fw=new FileWriter(file);
        BufferedWriter bfw=new BufferedWriter(new FileWriter(file));
        bfw.newLine();
        bfw.newLine();
        bfw.write("this is first string \n");
        bfw.write("this is second string \n");
        bfw.write("this is third string \n");
        bfw.newLine();
        bfw.write("-----terminate string---------");
        bfw.flush();
        bfw.close();
        //
        // create a FileReader
        //
        File file2=new File("c:\\tmp\\new2");
        PrintWriter pw = new PrintWriter(file);

        pw.println("PrintWriter test");
        pw.println("PrintWriter test 2");
        pw.flush();
        pw.close();

        int size = 0;
        char[] in = new char[43]; // to store input
        //FileReader fr =new FileReader(file);
        BufferedReader bfr=new BufferedReader(new FileReader(file));
        /*for (String str=null;(str=bfr.readLine())!=null;) {
            log.debug("file line= "+str);
        }*/
        String str=null;
        while ((str=bfr.readLine())!=null) {
            log.debug("file line= "+str);
        }
        //size = fr.read(in); // read the whole file!
        //System.out.println("size= "+size + " "); // how many bytes read
        //for(char c : in) // print the array
        //    System.out.print(c);
        //fr.close();
    }
}
