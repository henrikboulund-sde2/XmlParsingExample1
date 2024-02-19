import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class XmlDocumentParser
{
    public void Parse() throws ParserConfigurationException, IOException, SAXException {
        File xmlFile = new File("cars.xml");
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = builderFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("car");

        for (int i = 0; i < nList.getLength(); i++)
        {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("Make: " + eElement.getAttribute("make"));
                System.out.println("Model: " + eElement.getElementsByTagName("model").item(0).getTextContent());
                System.out.println("Year: " + eElement.getElementsByTagName("year").item(0).getTextContent());
                System.out.println("Color: " + eElement.getElementsByTagName("color").item(0).getTextContent());
            }
        }
    }
}
