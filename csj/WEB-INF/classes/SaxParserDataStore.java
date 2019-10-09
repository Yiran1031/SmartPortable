
/*********


 http://www.saxproject.org/

 SAX is the Simple API for XML, originally a Java-only API.
 SAX was the first widely adopted API for XML in Java, and is a �de facto� standard.
 The current version is SAX 2.0.1, and there are versions for several programming language environments other than Java.

 The following URL from Oracle is the JAVA documentation for the API

 https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html


 *********/
import org.xml.sax.InputSource;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import  java.io.StringReader;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


////////////////////////////////////////////////////////////

/**************

 SAX parser use callback function  to notify client object of the XML document structure.
 You should extend DefaultHandler and override the method when parsin the XML document

 ***************/

////////////////////////////////////////////////////////////

public class SaxParserDataStore extends DefaultHandler {
    WearableTechnology wt;
    Phone phone;
    Laptops laptop;
    VoiceAssistant va;

    static HashMap<String,WearableTechnology> wts;
    static HashMap<String,Phone> phones;
    static HashMap<String,Laptops> laptops;
    static HashMap<String, VoiceAssistant> vas;
    String consoleXmlFileName;
    HashMap<String,String> accessoryHashMap;
    String elementValueRead;
    String currentElement="";
    public SaxParserDataStore()
    {
    }
    public SaxParserDataStore(String consoleXmlFileName) {
        this.consoleXmlFileName = consoleXmlFileName;
        wts = new HashMap<String, WearableTechnology>();
        phones = new HashMap<String,Phone>();
        laptops = new HashMap<String,Laptops>();
        vas = new HashMap<String,VoiceAssistant>();
        accessoryHashMap=new HashMap<String,String>();
        parseDocument();
    }

    //parse the xml using sax parser to get the data
    private void parseDocument()
    {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try
        {
            SAXParser parser = factory.newSAXParser();
            parser.parse(consoleXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }



////////////////////////////////////////////////////////////

    /*************

     There are a number of methods to override in SAX handler  when parsing your XML document :

     Group 1. startDocument() and endDocument() :  Methods that are called at the start and end of an XML document.
     Group 2. startElement() and endElement() :  Methods that are called  at the start and end of a document element.
     Group 3. characters() : Method that is called with the text content in between the start and end tags of an XML document element.


     There are few other methods that you could use for notification for different purposes, check the API at the following URL:

     https://docs.oracle.com/javase/7/docs/api/org/xml/sax/helpers/DefaultHandler.html

     ***************/

////////////////////////////////////////////////////////////

    // when xml start element is parsed store the id into respective hashmap for console,games etc
    @Override
    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {

        if (elementName.equalsIgnoreCase("WearableTechnology"))
        {
            currentElement="WearableTechnology";
            wt = new WearableTechnology();
            wt.setId(attributes.getValue("id"));
        }else if (elementName.equalsIgnoreCase("Phone"))
        {
            currentElement="Phone";
            phone = new Phone();
            phone.setId(attributes.getValue("id"));
        }else if(elementName.equalsIgnoreCase("Laptops"))
        {
            currentElement = "Laptops";
            laptop = new Laptops();
            laptop.setId(attributes.getValue("id"));
        }else if(elementName.equalsIgnoreCase("VoiceAssistant")){
            currentElement = "VoiceAssistant";
            va = new VoiceAssistant();
            va.setId(attributes.getValue("id"));
        }


    }
    // when xml end element is parsed store the data into respective hashmap for console,games etc respectively
    @Override
    public void endElement(String str1, String str2, String element) throws SAXException {

        if (element.equals("WearableTechnology")) {
            wts.put(wt.getId(),wt);
            return;
        }else if(element.equals("Phone")){
            phones.put(phone.getId(),phone);
            return;
        }else if(element.equals("Laptops")){
            laptops.put(laptop.getId(),laptop);
            return;
        }else if(element.equals("VoiceAssistant")){
            vas.put(va.getId(),va);
            return;
        }

        if (element.equalsIgnoreCase("image")) {
            if(currentElement.equals("WearableTechnology"))
                wt.setImage(elementValueRead);
            if(currentElement.equals("Phone"))
                phone.setImage(elementValueRead);
            if(currentElement.equals("Laptops"))
                laptop.setImage(elementValueRead);
            if(currentElement.equals("VoiceAssistant"))
                va.setImage(elementValueRead);
            return;
        }


        if (element.equalsIgnoreCase("discount")) {
            if(currentElement.equals("WearableTechnology"))
                wt.setDiscount(Double.parseDouble(elementValueRead));
            if(currentElement.equals("Phone"))
                phone.setDiscount(Double.parseDouble(elementValueRead));
            if(currentElement.equals("Laptops"))
                laptop.setDiscount(Double.parseDouble(elementValueRead));
            if(currentElement.equals("VoiceAssistant"))
                va.setDiscount(Double.parseDouble(elementValueRead));
            return;
        }


        if (element.equalsIgnoreCase("condition")) {
            if(currentElement.equals("WearableTechnology"))
                wt.setCondition(elementValueRead);
            if(currentElement.equals("Phone"))
                phone.setCondition(elementValueRead);
            if(currentElement.equals("Laptops"))
                laptop.setCondition(elementValueRead);
            if(currentElement.equals("VoiceAssistant"))
                va.setCondition(elementValueRead);
            return;
        }

        if (element.equalsIgnoreCase("type")) {
            if(currentElement.equals("WearableTechnology"))
                wt.setType(elementValueRead);
            if(currentElement.equals("Phone"))
                phone.setType(elementValueRead);
            if(currentElement.equals("Laptops"))
                laptop.setType(elementValueRead);
            if(currentElement.equals("VoiceAssistant"))
                va.setType(elementValueRead);
            return;
        }

        if (element.equalsIgnoreCase("name")) {
            if(currentElement.equals("WearableTechnology"))
                wt.setName(elementValueRead);
            if(currentElement.equals("Phone"))
                phone.setName(elementValueRead);
            if(currentElement.equals("Laptops"))
                laptop.setName(elementValueRead);
            if(currentElement.equals("VoiceAssistant"))
                va.setName(elementValueRead);
            return;
        }

        if(element.equalsIgnoreCase("price")){
            if(currentElement.equals("WearableTechnology"))
                wt.setPrice(Double.parseDouble(elementValueRead));
            if(currentElement.equals("Phone"))
                phone.setPrice(Double.parseDouble(elementValueRead));
            if(currentElement.equals("Laptops"))
                laptop.setPrice(Double.parseDouble(elementValueRead));
            if(currentElement.equals("VoiceAssistant"))
                va.setPrice(Double.parseDouble(elementValueRead));
            return;
        }
        if(element.equalsIgnoreCase("num")){
            if(currentElement.equals("WearableTechnology"))
                wt.setNum(Integer.parseInt(elementValueRead));
            if(currentElement.equals("Phone"))
                phone.setP_number(Integer.parseInt(elementValueRead));
            if(currentElement.equals("Laptops"))
                laptop.setNum(Integer.parseInt(elementValueRead));
            if(currentElement.equals("VoiceAssistant"))
                va.setNum(Integer.parseInt(elementValueRead));
            return;
        }

    }
    //get each element in xml tag
    @Override
    public void characters(char[] content, int begin, int end) throws SAXException {
        elementValueRead = new String(content, begin, end);
    }


    /////////////////////////////////////////
    // 	     Kick-Start SAX in main       //
    ////////////////////////////////////////

    //call the constructor to parse the xml and get product details
    public static void addHashmap() {
        String TOMCAT_HOME = System.getProperty("catalina.home");
        new SaxParserDataStore(TOMCAT_HOME+"\\webapps\\csj\\ProductCatalog.xml");
    }
}
