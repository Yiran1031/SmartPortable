

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
@WebServlet("/XWrite")
public class XWrite extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            createXML(request,response);
        }
        catch (Exception e){

        }
    }

    public void createXML(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String TOMCAT_HOME = System.getProperty("catalina.home");
        WearableTechnology wt = new WearableTechnology();
        Phone p = new Phone();
        Laptops l = new Laptops();
        VoiceAssistant va = new VoiceAssistant();
        String id = request.getParameter("id");
        String na = request.getParameter("name");
        String pr = request.getParameter("price");
        String im = request.getParameter("image");
        String ty = request.getParameter("type");
        String co = request.getParameter("condition");
        String di = request.getParameter("discount");
        ArrayList<WearableTechnology> wts = new ArrayList<WearableTechnology>();
        ArrayList<Phone> ps = new ArrayList<Phone>();
        ArrayList<Laptops> ls = new ArrayList<Laptops>();
        ArrayList<VoiceAssistant> vas = new ArrayList<VoiceAssistant>();
        wts.add(wt);
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory
                .newDocumentBuilder();
        Document document = documentBuilder.parse(TOMCAT_HOME+"\\webapps\\csj\\ProductCatalog.xml");
        Element root = document.getDocumentElement();
        Element rootElement = document.getDocumentElement();

       Collection<WearableTechnology> svr = new ArrayList<WearableTechnology>();
        svr.add(wt);
        if(ty.equals("SmartWatches") || ty.equals("FitnessWatches") || ty.equals("Headphones") || ty.equals("VirtualReality")||ty.equals("PetTracker"))
        {
            wt.setId(id);
            wt.setName(na);
            wt.setPrice(Double.parseDouble(pr));
            wt.setImage(im);
            wt.setType(ty);
            wt.setCondition(co);
            wt.setDiscount(Double.parseDouble(di));

            wts.add(wt);
            for (WearableTechnology i : wts) {
              MySqlDataStoreUtilities.insertWT(i.getId(),i.getName(),i.getPrice(),i.getImage(),i.getType(),i.getCondition(),i.getDiscount());
                // Element w = document.createElement("WearableTechnology");
                // w.setAttribute("id",i.getId());
                // rootElement.appendChild(w);
                //
                // Element name = document.createElement("name");
                // name.appendChild(document.createTextNode(i.getName()));
                // w.appendChild(name);
                //
                // Element price = document.createElement("price");
                // price.appendChild(document.createTextNode(Double.toString(i.getPrice())));
                // w.appendChild(price);
                //
                // Element image = document.createElement("image");
                // image.appendChild(document.createTextNode(i.getImage()));
                // w.appendChild(image);
                //
                // Element type = document.createElement("type");
                // type.appendChild(document.createTextNode(i.getType()));
                // w.appendChild(type);
                // Element condition = document.createElement("condition");
                // condition.appendChild(document.createTextNode(i.getCondition()));
                // w.appendChild(condition);
                //
                // Element discount = document.createElement("discount");
                // discount.appendChild(document.createTextNode(Double.toString(i.getDiscount())));
                // w.appendChild(discount);
                //
                // root.appendChild(w);

            }

        }
        else if(ty.equals("Phone"))
        {
            p.setId(id);
            p.setName(na);
            p.setPrice(Double.parseDouble(pr));
            p.setImage(im);
            p.setType(ty);
            p.setCondition(co);
            p.setDiscount(Double.parseDouble(di));

            ps.add( p);
            for (Phone i : ps) {
                //
                // Element w = document.createElement("Phone");
                // w.setAttribute("id",i.getId());
                // rootElement.appendChild(w);
                //
                // Element name = document.createElement("name");
                // name.appendChild(document.createTextNode(i.getName()));
                // w.appendChild(name);
                //
                // Element price = document.createElement("price");
                // price.appendChild(document.createTextNode(Double.toString(i.getPrice())));
                // w.appendChild(price);
                //
                // Element image = document.createElement("image");
                // image.appendChild(document.createTextNode(i.getImage()));
                // w.appendChild(image);
                //
                // Element type = document.createElement("type");
                // type.appendChild(document.createTextNode(i.getType()));
                // w.appendChild(type);
                // Element condition = document.createElement("condition");
                // condition.appendChild(document.createTextNode(i.getCondition()));
                // w.appendChild(condition);
                //
                // Element discount = document.createElement("discount");
                // discount.appendChild(document.createTextNode(Double.toString(i.getDiscount())));
                // w.appendChild(discount);
                //
                // root.appendChild(w);
                  MySqlDataStoreUtilities.insertPhone(i.getId(),i.getName(),i.getPrice(),i.getImage(),i.getType(),i.getCondition(),i.getDiscount());
            }
        }
        else if(ty.equals("Laptops"))
        {
            l.setId(id);
            l.setName(na);
            l.setPrice(Double.parseDouble(pr));
            l.setImage(im);
            l.setType(ty);
            l.setCondition(co);
            l.setDiscount(Double.parseDouble(di));

            ls.add( l);
            for (Laptops i : ls) {
                //
                // Element w = document.createElement("Laptops ");
                // w.setAttribute("id",i.getId());
                // rootElement.appendChild(w);
                //
                // Element name = document.createElement("name");
                // name.appendChild(document.createTextNode(i.getName()));
                // w.appendChild(name);
                //
                // Element price = document.createElement("price");
                // price.appendChild(document.createTextNode(Double.toString(i.getPrice())));
                // w.appendChild(price);
                //
                // Element image = document.createElement("image");
                // image.appendChild(document.createTextNode(i.getImage()));
                // w.appendChild(image);
                //
                // Element type = document.createElement("type");
                // type.appendChild(document.createTextNode(i.getType()));
                // w.appendChild(type);
                // Element condition = document.createElement("condition");
                // condition.appendChild(document.createTextNode(i.getCondition()));
                // w.appendChild(condition);
                //
                // Element discount = document.createElement("discount");
                // discount.appendChild(document.createTextNode(Double.toString(i.getDiscount())));
                // w.appendChild(discount);
                //
                // root.appendChild(w);
                  MySqlDataStoreUtilities.insertLaptops(i.getId(),i.getName(),i.getPrice(),i.getImage(),i.getType(),i.getCondition(),i.getDiscount());
            }
        }
        else if(ty.equals("VoiceAssistant"))
        {

            va.setId(id);
            va.setName(na);
            va.setPrice(Double.parseDouble(pr));
            va.setImage(im);
            va.setType(ty);
            va.setCondition(co);
            va.setDiscount(Double.parseDouble(di));

            vas.add( va);
            for (VoiceAssistant i : vas) {
                //
                // Element w = document.createElement("<VoiceAssistant  ");
                // w.setAttribute("id",i.getId());
                // rootElement.appendChild(w);
                //
                // Element name = document.createElement("name");
                // name.appendChild(document.createTextNode(i.getName()));
                // w.appendChild(name);
                //
                // Element price = document.createElement("price");
                // price.appendChild(document.createTextNode(Double.toString(i.getPrice())));
                // w.appendChild(price);
                //
                // Element image = document.createElement("image");
                // image.appendChild(document.createTextNode(i.getImage()));
                // w.appendChild(image);
                //
                // Element type = document.createElement("type");
                // type.appendChild(document.createTextNode(i.getType()));
                // w.appendChild(type);
                // Element condition = document.createElement("condition");
                // condition.appendChild(document.createTextNode(i.getCondition()));
                // w.appendChild(condition);
                //
                // Element discount = document.createElement("discount");
                // discount.appendChild(document.createTextNode(Double.toString(i.getDiscount())));
                // w.appendChild(discount);
                //
                // root.appendChild(w);
                  MySqlDataStoreUtilities.insertVA(i.getId(),i.getName(),i.getPrice(),i.getImage(),i.getType(),i.getCondition(),i.getDiscount());
            }
        }

        DOMSource source = new DOMSource(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");
        StreamResult result = new StreamResult(TOMCAT_HOME+"\\webapps\\csj\\ProductCatalog.xml");
        transformer.transform(source, result);
        SaxParserDataStore.addHashmap();
    }
    }
