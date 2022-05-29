package model;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class WritewithJaxb {
	public void write(news news) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(news.class);
		Marshaller mar = context.createMarshaller();
		mar.marshal(news, new File("F:\\eclipse\\GKbt1\\xml\\news.xml"));
	}
	

}
