package com.mycompany.casestudy2_order;

import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import model.Order;

public class UpdateXML {
    public void updateXML(String src, Order orderUpdate) throws JAXBException, XMLStreamException, FileNotFoundException{
        JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        File file = new File(src);
        Order order = (Order) jaxbUnmarshaller.unmarshal(file);
        Write write = new Write();
        write.writeXML(src, orderUpdate);
    }
}
