package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
 
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
 
public class ReadXMLExample 
{
  public studentList read() throws FileNotFoundException, XMLStreamException 
  {
    //All read employees objects will be added to this list
       studentList stlist = new studentList();
         
        //Create Employee object. It will get all the data using setter methods.
        //And at last, it will stored in above 'employeeList' 
        student st = null;
      
        File file = new File("data.xml");
      XMLInputFactory factory = XMLInputFactory.newInstance();
      XMLStreamReader streamReader = factory.createXMLStreamReader(new FileReader(file));
       
       
      while(streamReader.hasNext())
      {
        //Move to next event
          streamReader.next();
           
          //Check if its 'START_ELEMENT'
          if(streamReader.getEventType() == XMLStreamReader.START_ELEMENT)
          {
            //employee tag - opened
              if(streamReader.getLocalName().equalsIgnoreCase("stlist")) {
                 
                //Create new employee object asap tag is open
                st = new student();  
                 
                //Read attributes within employee tag
                if(streamReader.getAttributeCount() > 0) {
                  String id = streamReader.getAttributeValue(null,"id");
                  st.setId(Integer.valueOf(id));
                }
              }
               
              //Read name data
              if(streamReader.getLocalName().equalsIgnoreCase("name")) {
                st.setName(streamReader.getElementText());
              }
               
            //Read title data
              if(streamReader.getLocalName().equalsIgnoreCase("age")) {
                st.setAge(streamReader.getElementText());
              }
          }
           
          //If employee tag is closed then add the employee object to list
          if(streamReader.getEventType() == XMLStreamReader.END_ELEMENT)
          {
            if(streamReader.getLocalName().equalsIgnoreCase("stlist")) {
              stlist.add(st);
            }
          }
      }
        //Verify read data
        return stlist;
  }
}
