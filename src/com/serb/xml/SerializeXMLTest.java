package com.serb.xml;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: S.Bezuglyi
 * Date: Sep 3, 2010
 * Time: 4:49:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class SerializeXMLTest {

    String fileName = "/transponders.xml";

    //fileName=ResourceUtil.getPath(fileName);

    /*System.out.println("Start serialization of transponders fileName= "+fileName);
    File transpondersFile = new File(fileName);
    int transpondersCount = 0;
    OutputStream outputStream = null;
    try

    {
        if (transpondersFile.exists() == false) {
            transpondersFile.createNewFile();
            System.out.println("Serialization of transponders file was not exists and it was created " + fileName);
        }
        System.out.println("Serialization of transponders create outputStream ");
        outputStream = new DataOutputStream(new FileOutputStream(transpondersFile));
        System.out.println("outputStream created");
        StreamResult streamResult = new StreamResult(outputStream);
        SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        // SAX2.0 ContentHandler.
        TransformerHandler hd = tf.newTransformerHandler();
        Transformer serializer = hd.getTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        //
        hd.setResult(streamResult);
        hd.startDocument();
        AttributesImpl atts = new AttributesImpl();
        // TRANSPONDERS tag.
        hd.startElement("", "", TRANSPONDERS_ROOT_ELEMENT, atts);
        SatelliteTuneConf[] satelliteTransponders = HotbirdSatelliteTuneTable.HOTBIRD_CONFIGURATION;
        System.out.println("Transponders serialisation satelliteTransponders= " + satelliteTranspondersString fileName = "/transponders.xml";

        );
        transpondersCount = satelliteTransponders.length;
        for (int i = 0; i < satelliteTransponders.length; i++) {
            System.out.println("Transponders serialisation loop (" + i + ")" + satelliteTransponders[i]);
            atts.clear();
            //atts.addAttribute("","","ID","CDATA",id[i]);
            //atts.addAttribute("","","TYPE","CDATA",type[i]);

            atts.addAttribute("", "", "FEC", "CDATA", satelliteTransponders[i].getFec().getFecString());

            hd.startElement("", "", TRANSPONDER_ELEMENT, atts);
            //hd.characters(desc[i].toCharArray(),0,desc[i].length());
            hd.characters(satelliteTransponders[i].toDeviceString().toCharArray(), 0, satelliteTransponders[i].toDeviceString().length());
            hd.endElement("", "", TRANSPONDER_ELEMENT);
        }

        hd.endElement("", "", "TRANSPONDERS_ROOT_ELEMENT");
        hd.endDocument();
        System.out.println("Transponders serialisation END_DOCUMENT");
    }

    catch(
    FileNotFoundException e
    )

    {
        System.out.println("FileNotFoundException" + e);
    }

    catch(
    TransformerConfigurationException e
    )

    {
        //System.out.println(e);
        System.out.println("TransformerConfigurationException " + e);
    }

    catch(
    SAXException e
    )

    {
        //System.out.println(e);
        System.out.println("SAXException" + e);
    }

    catch(
    IOException e
    )

    {
        System.out.println("IOException" + e);
    }

    catch(
    Throwable e
    )

    {
        System.out.println("!!!!!!!!!!!!!!Exception occured!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!Exception occured" + e);
    }

    finally

    {
        System.out.println("Transponders serialisation finally block");
        if (outputStream != null) {
            try {
                outputStream.close();
            }
            catch (IOException e) {
                System.out.println("Closing stream exception: " + e);
            }
        }

    }

    System.out.println("Transponders serialisation finished. Was added "+transpondersCount+" transponders to file.");
}*/
}
