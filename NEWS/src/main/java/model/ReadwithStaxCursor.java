package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class ReadwithStaxCursor {
	 public news read() throws FileNotFoundException, XMLStreamException 
	  {
	    //All read news objects will be added to this list
	       news news = new news();
	     
	        
	        //Create item and content object. It will get all the data using setter methods.
	        //And at last, it will stored in above 'employeeList' 
	        item Item = null;
	        content cont = null;
	        
	        
	      
	        File file = new File("F:\\eclipse\\GKbt1\\xml\\news.xml");
	      XMLInputFactory factory = XMLInputFactory.newInstance();
	      XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader(file));
	       
	       
	      while(streamReader.hasNext())
	      {
	        //Move to next event
	          streamReader.next();
	           
	          //Check if its 'START_ELEMENT'
	          if(streamReader.getEventType() == XMLStreamReader.START_ELEMENT)
	          {
	            //item tag - opened
	              if(streamReader.getLocalName().equalsIgnoreCase("item")) {
	                 
	                //Create new item object asap tag is open
	            	  Item = new item();  
	                
	                 
	                //Read attributes within employee tag
	                if(streamReader.getAttributeCount() > 0) {
	                  String date = streamReader.getAttributeValue(null,"date");
	                  Item.setDate(date);
	                }
	              }
	               
	              //Read name data
	              if(streamReader.getLocalName().equalsIgnoreCase("title")) {
	            	  Item.setTitle(streamReader.getElementText());
	              }
	               
	            //Read content data
	              if(streamReader.getLocalName().equalsIgnoreCase("content")) {
	            	  cont = new content();  
	              }
	              if(streamReader.getLocalName().equalsIgnoreCase("description")) {
	            	  cont.setDescription(streamReader.getElementText());
	              }
	              if(streamReader.getLocalName().equalsIgnoreCase("image")) {
	            	  cont.setImage(streamReader.getElementText());
		              }
	              if(streamReader.getLocalName().equalsIgnoreCase("link")) {
	            	  cont.setLink(streamReader.getElementText());
		              }
	              
	              if(streamReader.getLocalName().equalsIgnoreCase("author")) {
	            	  Item.setAuthor(streamReader.getElementText());
		              }
	          }
	           
	          //If employee tag is closed then add the employee object to list
	          if(streamReader.getEventType() == XMLStreamReader.END_ELEMENT)
	          {	
	        	
	        	  if(streamReader.getLocalName().equalsIgnoreCase("content")) {
	        		 Item.setContent(cont);
	        	  }
	          
	        		if(streamReader.getLocalName().equalsIgnoreCase("item")) {
	  	              news.add(Item);
	  	            }
	        	
	          }
	      }
	        //Verify read data
	       return news;
	  }
	
}
