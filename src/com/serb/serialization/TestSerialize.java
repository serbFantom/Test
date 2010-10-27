package com.serb.serialization;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Random;

import java.beans.XMLEncoder;

import com.serb.serialization.externalizable.*;

/**
 * Created by IntelliJ IDEA.
 * User: SBezugliy
 * Date: 09.06.2009
 */
public class TestSerialize {

    private static Logger log=Logger.getLogger(TestSerialize.class.getName());
    static {
        PropertyConfigurator.configure("./conf/logging.properties");
    }

    public static void main (String[] args) throws ClassNotFoundException, IOException {
        log.info("Test serialize");
        objectDogSerialization();
        /*objectWolfSerialization();
        //objectDuckSerialize();               
        testExternalizableVsSerializable(100000);
        testSimpleXMLSerialization(new Duck());// */
    }

    /**
     * Shows on example of object Wolf how you can work with
     * serialization of not serializable members of the class
     * used two private methods writeObject
     * and readObject (notice this methods SHOULD be private)
     */
    private static void objectDogSerialization() {
        log.info("----------------------------------------");
        log.info("----------------Object Dog test serialize/deserialize------------------------");        
        int collarSize=3;
        Collar collar1 = new Collar(collarSize);
        log.info("Object Collar created with size= "+collarSize);
        int dogSize=8;
        Dog dog1 = new Dog(collar1, dogSize);
        Dog dog2=null;
        log.info("dog1.hashCode()= "+dog1.hashCode());
        try {
            FileOutputStream fs = new FileOutputStream("./data/testDog.ser");
            dog1.dogsCount++;
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(dog1);
            os.close();
            log.info("--------------------------------------");
            log.info("Object Dog serialized");
            log.info("dog1.getDogLength()= "+dog1.getDogLength());
            log.info("dog1.getDogLength()= "+dog1.dogsCount);
            log.info("dog1.someObj= "+dog1.someObj);
            log.info("dog1.hashCode()= "+dog1.hashCode());
            log.info("--------------------------------------");
            //Deserialize
            FileInputStream fis = new FileInputStream("./data/testDog.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            dog2 = (Dog) ois.readObject();
            ois.close();
            log.info("--------------------------------------");
            log.info("Object Dog deserialized");
            log.info("dog2.getDogLength()= "+dog2.getDogLength());
            log.info("dog2.getDogLength()= "+dog2.dogsCount);
            log.info("dog1.someObj= "+dog2.someObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info("dog2.getDogSize()= "+dog2.getDogSize());
        log.info("dog2.hashCode()= "+dog2.hashCode());
        if (dog2.getCollar()!=null) {
            log.info("after: collar size is "
                + dog2.getCollar().getCollarSize());
        } else {
            log.info("dog2.getCollarSize() is null");
        }
        log.info("--------------------------------------");
        
        log.info("----------------END Object Dog test serialize/deserialize------------------------");
    }

    /**
     * Shows on example of object Wolf how serialization works with inheritance.
     *
     * The instance variables from the Dog's class will be serialized and deserialized
     *correctly, but the inherited variables from the non-serializable Animal superclass will
     *come back with their default/initially assigned values rather than the values they
     *had at the time of serialization.
     */
    private static void objectWolfSerialization() {
        System.out.println();
        log.info("----------------------------------------");
        log.info("----------------Object Wolf test serialize/deserialize------------------------");
        Wolf wolf1=new Wolf();
        try {
            FileOutputStream fs = new FileOutputStream("./data/testWolf.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(wolf1);
            os.close();
            log.info("--------------------------------------");
            log.info("Object Wolf serialized");
            log.info("wolf1.getName()= "+wolf1.getName());
            log.info("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Wolf wolf2=null;
        try {
            FileInputStream fis = new FileInputStream("./data/testWolf.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            wolf2 = (Wolf) ois.readObject();
            ois.close();
            log.info("--------------------------------------");
            log.info("Object Wolf deserialized");
            log.info("wolf2.getName()= "+wolf2.getName());
            log.info("--------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }        
        log.info("----------------END Object Wolf test serialize/deserialize------------------------");
    }

    /**
     * Serialization/deserialization of Object Duck using interface Externalizable
     */
    //todo:finish it
    private static void objectDuckSerialize() {
        System.out.println();
        log.info("----------------------------------------");
        log.info("----------------Object Duck test serialize/deserialize------------------------");
        Duck duck1=new Duck();
        FileOutputStream fs= null;
        try {
            fs = new FileOutputStream("./data/testWolf.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(duck1);
            os.flush();
            os.close();
        }  catch (IOException e) {
            e.printStackTrace();
        }

        log.info("----------------END Object Duck test serialize/deserialize------------------------");
    }

    /**
     * Compare Serialisable and Externalizable intearfaces for perfomance
     *
     * @param counter counts of object to generate for test
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void testExternalizableVsSerializable(int counter) throws IOException, ClassNotFoundException {
        log.info("----------------------------------------");
        log.info("---------------Externalizable Vs Serialisable serialize/deserialize------------------------");
        ContainerSer cs = new ContainerSer();
        ContainerExt1 ce1 = new ContainerExt1();
        ContainerExt2 ce2 = new ContainerExt2();
        ContainerExt3 ce3 = new ContainerExt3();
        int fieldInt;
        boolean fieldBoolean;
        long fieldLong;
        float fieldFloat;
        double fieldDouble;
        String fieldString;
        Random r = new Random();
        r.setSeed(System.currentTimeMillis());
        log.info("Creating "+counter+" objects");

        for(int i=0; i < counter; i++){
            fieldInt = r.nextInt();
            fieldBoolean = r.nextBoolean();
            fieldLong = r.nextLong();
            fieldFloat = r.nextFloat();
            fieldDouble = r.nextDouble();
            fieldString = "" + (fieldLong * fieldFloat / (fieldDouble == 0.0 ? 0.3 : fieldDouble));
            ItemExt ext = new ItemExt(fieldInt, fieldBoolean, fieldLong, fieldFloat, fieldDouble, fieldString);
            ItemSer ser = new ItemSer(fieldInt, fieldBoolean, fieldLong, fieldFloat, fieldDouble, fieldString);
            cs.addItem(ser);
            ce1.addItem(ext);
            ce2.addItem(ext);
            ce3.addItem(ext);
        }
        ObjectOutputStream oosSer = new ObjectOutputStream(new FileOutputStream("./data/cont.ser"));
        ObjectOutputStream oosExt1 = new ObjectOutputStream(new FileOutputStream("./data/contExt1.ser"));
        ObjectOutputStream oosExt2 = new ObjectOutputStream(new FileOutputStream("./data/contExt2.ser"));
        ObjectOutputStream oosExt3 = new ObjectOutputStream(new FileOutputStream("./data/contExt3.ser"));
        long serStart = System.currentTimeMillis();
        oosSer.writeObject(cs);
        oosSer.flush();
        long serEnd = System.currentTimeMillis();
        long ext1Start = System.currentTimeMillis();
        oosExt1.writeObject(ce1);
        oosExt1.flush();
        long ext1End = System.currentTimeMillis();
        long ext2Start = System.currentTimeMillis();
        oosExt2.writeObject(ce2);
        oosExt2.flush();
        long ext2End = System.currentTimeMillis();
        long ext3Start = System.currentTimeMillis();
        oosExt3.writeObject(ce3);
        oosExt3.flush();
        long ext3End = System.currentTimeMillis();
        oosSer.close();
        oosExt1.close();
        ObjectInputStream oisSer = new ObjectInputStream(new FileInputStream("./data/cont.ser"));
        ObjectInputStream oisExt1 = new ObjectInputStream(new FileInputStream("./data/contExt1.ser"));
        ObjectInputStream oisExt2 = new ObjectInputStream(new FileInputStream("./data/contExt2.ser"));
        ObjectInputStream oisExt3 = new ObjectInputStream(new FileInputStream("./data/contExt3.ser"));
        //
        long r_serStart = System.currentTimeMillis();
        ContainerSer r_cs = (ContainerSer)oisSer.readObject();
        long r_serEnd = System.currentTimeMillis();
        long r_ext1Start = System.currentTimeMillis();
        ContainerExt1 r_ce1 = (ContainerExt1)oisExt1.readObject();
        long r_ext1End = System.currentTimeMillis();
        long r_ext2Start = System.currentTimeMillis();
        ContainerExt2 r_ce2 = (ContainerExt2)oisExt2.readObject();
        long r_ext2End = System.currentTimeMillis();
        long r_ext3Start = System.currentTimeMillis();
        ContainerExt3 r_ce3 = (ContainerExt3)oisExt3.readObject();
        long r_ext3End = System.currentTimeMillis();
        log.info("Serializable: written in "+(serEnd - serStart)+
                           "ms, readed in "+(r_serEnd-r_serStart));
        log.info("Externalizable1: written in "+(ext1End - ext1Start)+
                           "ms, readed in "+(r_ext1End-r_ext1Start));
        log.info("Externalizable2: written in "+(ext2End - ext2Start)+
                           "ms, readed in "+(r_ext2End-r_ext2Start));
        log.info("Externalizable3: written in "+(ext3End - ext3Start)+
                           "ms, readed in "+(r_ext3End-r_ext3Start));
        log.info("---------------END Externalizable Vs Serialisable------------------------");
    }

    private static void testSimpleXMLSerialization(Object objToSave) throws FileNotFoundException {
        log.info("----------------------------------------");
        log.info("----------------testSimpleXMLSerialization------------------------");
        String fileName="./data/SimpleTest"+objToSave.getClass().getSimpleName()+".xml";
        XMLEncoder e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fileName)));
        e.writeObject(objToSave);
        e.close();

        log.info("---------------END testSimpleXMLSerialization------------------------");
    }
}
