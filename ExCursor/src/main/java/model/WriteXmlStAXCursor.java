package model;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteXmlStAXCursor {

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
    	studentList stlist = new studentList();
    	stlist.add(new student(1,"Linh","21"));
    	stlist.add(new student(2,"Hai","21"));
    	stlist.add(new student(3,"Hoa","78"));
        // send the output to a xml file
        try{
            writeXml(stlist);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // send the output to System.out
        // writeXml(System.out);

    }
    public static void write(XMLStreamWriter writer, student st) throws XMLStreamException {
    	

    	writer.writeStartElement("stlist");
        writer.writeAttribute("id", st.getId()+"");

        writer.writeStartElement("name");
        writer.writeCharacters(st.getName());
        writer.writeEndElement();

        writer.writeStartElement("age");
       // writer.writeAttribute("currency", "USD");
        writer.writeCharacters(st.getAge());
        writer.writeEndElement();


        writer.writeEndElement();


    	
    }

    // StAX Cursor API
    public static void writeXml(studentList stlist) throws XMLStreamException, FileNotFoundException {
    	FileOutputStream out = new FileOutputStream("data.xml");
        XMLOutputFactory output = XMLOutputFactory.newInstance();

        XMLStreamWriter writer = output.createXMLStreamWriter(out,"UTF-8");

        writer.writeStartDocument("UTF-8", "1.0");

        // <company>
        writer.writeStartElement("studentList");
        for(student st: stlist.getStlist()) {
        	write(writer, st);
        }

        writer.writeEndElement();
        writer.writeEndDocument();
        // </company>

        writer.flush();
        writer.close();

    }

}
