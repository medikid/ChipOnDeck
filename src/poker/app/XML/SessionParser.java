package poker.app.XML;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SessionParser {
	File sessionFile = new File("D:\\wamp\\www\\ChipOnDeck\\Settings\\session29475724.xml");
	
	public SessionParser(){
		
	}

	public void Reader() throws FileNotFoundException{
		try {
			 
			File fXmlFile = this.sessionFile;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
			Element ROOT = doc.getDocumentElement();
			
			NodeList HISTORY_NODES = ROOT.getChildNodes();			
			Node HISTORY_NODE = ROOT.getChildNodes().item(1);
			NamedNodeMap HISTORY_NODE_ATTRIBUTES = HISTORY_NODE.getAttributes();
			
			NodeList PLAYER_NODES = HISTORY_NODE.getChildNodes();
			Node PLAYER_NODE = PLAYER_NODES.item(1);
			NamedNodeMap PLAYER_NODE_ATTRIBUTES = PLAYER_NODE.getAttributes();
			
			String HISTORY_NODE_ID = HISTORY_NODE_ATTRIBUTES.getNamedItem("ID").getNodeValue();
						
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			System.out.println("Session File is:" + PLAYER_NODE_ATTRIBUTES.getNamedItem("SEAT"));
		 
			//NodeList nList = doc.getElementsByTagName("History");
			NodeList nList = PLAYER_NODES;
		 
			System.out.println("----------------------------");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);
		 
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					Element eElement = (Element) nNode;
		 /*
					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
		 */
				}
			}
		    } catch (Exception e) {
			e.printStackTrace();
		    }
		  
	}
	
	
}
