package model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class readwritexml {
	public studentList read() throws JAXBException {
		
		studentList stlistread = new studentList();
		JAXBContext context = JAXBContext.newInstance(studentList.class);
		Unmarshaller unmar = context.createUnmarshaller();
		stlistread =(studentList) unmar.unmarshal(new File("data.xml"));
		return stlistread;
	}
	public void write(studentList stlistwrite) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(studentList.class);
		Marshaller mar = context.createMarshaller();
		mar.marshal(stlistwrite, new File("data.xml"));
	}
}
