/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casestudy2_order;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import model.Order;
import model.Orders;

/**
 *
 * @author Hoahanna
 */
public class Read {
    public void readXML(String src) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        File file = new File(src);
        Order order = (Order) jaxbUnmarshaller.unmarshal(file);
        Validate.showList(order);
//        System.out.println(order);
    }
    
    public void readOrderListXML(String src) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Orders.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        File file = new File(src);
        Orders orders = (Orders) jaxbUnmarshaller.unmarshal(file);
        System.out.println(orders);
    }
}
