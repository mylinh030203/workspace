package model;

import javax.xml.stream.*;
import javax.xml.stream.events.XMLEvent;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteXmlStAXIterator {

    public static void main(String[] args) throws XMLStreamException {

        // send the output to a xml file
        try {
        	WriteXmlStAXIterator a = new WriteXmlStAXIterator();
        	studentList stlist = new studentList();
        	stlist.add(new student(1,"Linh","19"));
        	stlist.add(new student(2,"Hai","21"));
        	stlist.add(new student(3,"Hoa","19"));
            a.writeXml2(stlist);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // send the output to System.out
        // writeXml2(System.out);

    }
    
    
    
    public static void write(XMLEventWriter writer, XMLEventFactory eventFactory, student st) throws XMLStreamException {

        

        // write XML comment
       // writer.add(eventFactory.createComment("This is student 1"));
    	

        writer.add(eventFactory.createStartElement("", "", "stlist"));
        // write XML attribute
        writer.add(eventFactory.createAttribute("id", st.getId()+""));

        writer.add(eventFactory.createStartElement("", "", "name"));
        writer.add(eventFactory.createCharacters(st.getName()));
        writer.add(eventFactory.createEndElement("", "", "name"));

        writer.add(eventFactory.createStartElement("", "", "age"));
        
        writer.add(eventFactory.createCharacters(st.getAge()));
        writer.add(eventFactory.createEndElement("", "", "age"));

        

        // </staff>
        writer.add(eventFactory.createEndElement("", "", "stlist"));
    	
    }

    // StAX Iterator API
    public void writeXml2(studentList stlist) throws XMLStreamException, FileNotFoundException {
    	FileOutputStream out = new FileOutputStream("data.xml");
        XMLOutputFactory output = XMLOutputFactory.newInstance();
        XMLEventFactory eventFactory = XMLEventFactory.newInstance();

        // StAX Iterator API
        XMLEventWriter writer = output.createXMLEventWriter(out);

        XMLEvent event = eventFactory.createStartDocument();
        // default
        //event = eventFactory.createStartDocument("utf-8", "1.0");
        writer.add(event);
        writer.add(eventFactory.createStartElement("", "", "studentList"));
        for(student st: stlist.getStlist()) {
        	write(writer, eventFactory, st);
        }
        



        // next staff, tired to write more
        // writer.add(eventFactory.createStartElement("", "", "staff"));
        // writer.add(eventFactory.createAttribute("id", "1002"));
        // writer.add(eventFactory.createEndElement("", "", "staff"));

        // end here.
        writer.add(eventFactory.createEndDocument());
        writer.flush();
        writer.close();
    }

}
