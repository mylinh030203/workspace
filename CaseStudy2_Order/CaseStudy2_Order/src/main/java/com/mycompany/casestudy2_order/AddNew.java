/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.casestudy2_order;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import model.Order;

/**
 *
 * 
 */
public class AddNew {
    public void addXML(String src, Order newOrder) throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(Order.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        File file = new File(src);
//        Order order = (Order) jaxbUnmarshaller.unmarshal(file);
        ArrayList<Order> orderList = (ArrayList<Order>) jaxbUnmarshaller.unmarshal(file);
    }
}
