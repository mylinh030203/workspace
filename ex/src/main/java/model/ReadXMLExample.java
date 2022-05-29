package model;
//cursor

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
 
public class ReadXMLExample 
{
  public studentList read() throws FileNotFoundException, XMLStreamException 
  {
     File file = new File("data.xml");
      
    // Instance of the class which helps on reading tags
      XMLInputFactory factory = XMLInputFactory.newInstance();
    
        // Initializing the handler to access the tags in the XML file
        XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(file));
         
        //All read employees objects will be added to this list
        studentList stlist = new studentList();
         
        //Create Employee object. It will get all the data using setter methods.
        //And at last, it will stored in above 'employeeList' 
        student st = null;
         
        // Checking the availability of the next tag
        while (eventReader.hasNext())
        {
          XMLEvent xmlEvent = eventReader.nextEvent();
           
          if (xmlEvent.isStartElement())
          {
            StartElement startElement = xmlEvent.asStartElement();
             
            //As soo as stlist tag is opened, create new student object
            if("stlist".equalsIgnoreCase(startElement.getName().getLocalPart())) {
              st = new student();  
            }
             
            //Read all attributes when start tag is being read
            @SuppressWarnings("unchecked")
        Iterator<Attribute> iterator = startElement.getAttributes();
             
                while (iterator.hasNext())
                {
                    Attribute attribute = iterator.next();
                    QName name = attribute.getName();
                    if("id".equalsIgnoreCase(name.getLocalPart())) {
                      st.setId(Integer.valueOf(attribute.getValue()));
                    }
                }
             
                //Now everytime content tags are found; 
                //Move the iterator and read data
            switch (startElement.getName().getLocalPart()) 
            {
              case "name":
            	  //namedataevent là một đối tượng trung gian để đọc giá trị của 1 thẻ khi eventreader truy cập vào thẻ đó
                Characters nameDataEvent = (Characters) eventReader.nextEvent();
                st.setName(nameDataEvent.getData());
                break;
                 
              case "age":
                Characters titleDataEvent = (Characters) eventReader.nextEvent();
                st.setAge(titleDataEvent.getData());
                break;
            }
          }
           
          if (xmlEvent.isEndElement())
          {
            EndElement endElement = xmlEvent.asEndElement();
             
            //If employee tag is closed then add the employee object to list; 
            //and be ready to read next employee data
            if("stlist".equalsIgnoreCase(endElement.getName().getLocalPart())) {
              stlist.add(st);
            }
          }
        }
         
        return stlist; //Verify read data
         
  }
}