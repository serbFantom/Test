package com.serb.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

/**
 * User: SBezugliy
 * Date: 27.10.2008 15:06:56
 */
public class XMLHelper {

    public Document generateXml() throws ParserConfigurationException {
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance( );
        DocumentBuilder parser = fact.newDocumentBuilder();
        Document doc = parser.newDocument( );
        Node root = doc.createElement("Poem");
        doc.appendChild(root);
        Node stanza = doc.createElement("Stanza");
        root.appendChild(stanza);
        Node line = doc.createElement("Line");
        stanza.appendChild(line);
        line.appendChild(doc.createTextNode("Once, upon a midnight dreary"));
        line = doc.createElement("Line");
        stanza.appendChild(line);
        line.appendChild(doc.createTextNode("While I pondered, weak and weary"));
        
        return doc;

    }

    public static void main (String[] args) {
        XMLHelper xmlHelper = new XMLHelper();
        try {
            Document docXml=xmlHelper.generateXml();
            //docXml.normalizeDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
