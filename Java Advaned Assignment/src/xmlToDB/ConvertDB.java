package xmlToDB;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ConvertDB {
	
	static private String getAttrValue (Node node,String attrName) {
	    if ( ! node.hasAttributes() )
	    	return "";
	    NamedNodeMap nmap = node.getAttributes();
	    if ( nmap == null ) 
	    	return "";
	    Node n = nmap.getNamedItem(attrName);
	    if ( n == null ) 
	    	return "";
	    
	    return n.getNodeValue();
	}
	
	static private String getTextContent(Node parentNode,String childName) {
	    NodeList nlist = parentNode.getChildNodes();
	    for (int i = 0 ; i < nlist.getLength() ; i++) {
	    Node n = nlist.item(i);
	    String name = n.getNodeName();
	    if ( name != null && name.equals(childName) )
	        return n.getTextContent();
	    }
	    return "";
	}
	
	public static void main(String[] args) throws SQLException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		
		try { Class.forName("com.mysql.jdbc.Driver"); }
	    catch(ClassNotFoundException ex) {
	    	ex.printStackTrace();
	    }

		Connection conn = (Connection)DriverManager.getConnection( "jdbc:mysql://localhost:3306/" + "iacc" + "?useSSL=false", "root", "root");
		
		conn.createStatement()
	    .execute("create table foodstock (id integer primary key auto_increment, name varchar(25) not null, price int(4) not null, quantity int(3) not null);");
		File file = new File("C://Users//nishant.kaushik//eclipse-workspace//Java Advaned Assignment//src//xmlToDB//data.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xmlDoc = builder.parse(file);
		
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		Object res = xpath.evaluate("/foodstock/item", xmlDoc, XPathConstants.NODESET);
		
		PreparedStatement stmt = (PreparedStatement) conn
			    .prepareStatement("insert into foodstock(id, name, price, quantity) values(?, ?, ?, ?)");
		
		
		NodeList nlist = (NodeList)res;
		for (int i = 0 ; i < nlist.getLength() ; i++) {
		    Node node = nlist.item(i);
		    List<String> columns = Arrays.asList(getAttrValue(node, "id"),getTextContent(node, "name"),getTextContent(node, "price"),getTextContent(node, "quantity"));
		    for (int n = 0; n < columns.size() ; n++) {
		    	System.out.println(columns.get(n));
		    	stmt.setString(n+1, columns.get(n));
		    }
		    stmt.execute();
		}


	}
}
