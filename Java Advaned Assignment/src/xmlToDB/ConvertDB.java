package xmlToDB;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

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
	    System.err.println("Driver not found: " + ex.getMessage());
	    }
		String connectionUrl = "jdbc:mysql:localhost:3306/";
//		String dbUrl = "jdbc:mysql://localhost:3306/";
//		String uname = "root";
//		String pwd = "root";
//		
		Properties properties = new Properties();
		properties.setProperty("user", "root");
		properties.setProperty("password", "root");
		properties.setProperty("useSSL", "false");
		properties.setProperty("autoReconnect", "true");

		Connection conn = (Connection)DriverManager
			    .getConnection( "jdbc:mysql://localhost:3306/" + "iacc" + "?useSSL=false", "root", "root");
		
		
		
		//Connection conn = (Connection) DriverManager.getConnection(dbUrl, uname, pwd);
		conn.createStatement()
	    .execute("CREATE TABLE books(\n" +
	         " id integer primary key auto_increment,\n" +
	         " book_id varchar(25) not null unique,\n" +
	         " author varchar(50) not null,\n" +
	         " title varchar(250) not null,\n" +
	         " genre varchar(25) not null,\n" +
	         " price float not null,\n" +
	         " publish_date date not null,\n" +
	         " description text not null\n" +
	         ")");
		File file = new File("C://Users//nishant.kaushik//eclipse-workspace//Java Advaned Assignment//src//xmlToDB//data.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document xmlDoc = builder.parse(file);
		
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		Object res = xpath.evaluate("/catalog/book",
		                 xmlDoc,
		                 XPathConstants.NODESET);
		
		PreparedStatement stmt = (PreparedStatement) conn
			    .prepareStatement("INSERT INTO books(\n" +
			              " book_id, author, title, genre, price,\n" +
			                 " publish_date, description)\n" +
			                  "VALUES(?, ?, ?, ?, ?,\n" +
			                  " str_to_date(?, '%Y-%m-%d'), ?)");
		
		
		NodeList nlist = (NodeList)res;
		for (int i = 0 ; i < nlist.getLength() ; i++) {
		    Node node = nlist.item(i);
		    List<String> columns = Arrays
		    .asList(getAttrValue(node, "id"),
		        getTextContent(node, "author"),
		        getTextContent(node, "title"),
		        getTextContent(node, "genre"),
		        getTextContent(node, "price"),
		        getTextContent(node, "publish_date"),
		        getTextContent(node, "description"));
		    for (int n = 0 ; n < columns.size() ; n++) {
		    stmt.setString(n+1, columns.get(n));
		    }
		    stmt.execute();
		}


	}
}
