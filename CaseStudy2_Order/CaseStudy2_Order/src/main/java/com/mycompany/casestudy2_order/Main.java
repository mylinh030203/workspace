/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.casestudy2_order;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import model.Item;
import model.Order;
import model.Price;

/**
 *
 * @author 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JAXBException, XMLStreamException, FileNotFoundException {
        // TODO code application logic here
        while (true) {
            int choice = Validate.menu();
            String number, name, order_date, customer, email, phone, address, itemName, itemQuantity, itemPrice, priceCurrency;

            switch (choice) {
                case 1:
                    Read read = new Read();
                    read.readXML("src/main/java/xml/order.xml");
                    break;
                case 2:
//                    System.out.println("Enter number:");
//                    number = Validate.checkInputString();
//                    System.out.println("Enter date:");
//                    order_date = Validate.checkInputString();
//                    System.out.println("Enter dcustomer:");
//                    customer = Validate.checkInputString();
//                    System.out.println("Enter email:");
//                    email = Validate.checkInputString();
//                    System.out.println("Enter phone:");
//                    phone = Validate.checkInputString();
//                    System.out.println("Enter address:");
//                    address = Validate.checkInputString();
//                    System.out.println("Enter item name:");
//                    itemName = Validate.checkInputString();
//                    System.out.println("Enter item quantity:");
//                    itemQuantity = Validate.checkInputString();
//                    System.out.println("Enter item price:");
//                    itemPrice = Validate.checkInputString();
//                    addItemXML("src/main/java/xml/newemployee.xml",
//                            new Employee(id, name, dateOfbith, salary, new Department(depName, depPosition)), employees);
                    break;
                case 3:
                    System.out.println("\nEnter new number:");
                    number = Validate.checkInputString();
                    System.out.println("Enter new date:");
                    order_date = Validate.checkInputString();
                    System.out.println("Enter new dcustomer:");
                    customer = Validate.checkInputString();
                    System.out.println("Enter new email:");
                    email = Validate.checkInputString();
                    System.out.println("Enter new phone:");
                    phone = Validate.checkInputString();
                    System.out.println("Enter new address:");
                    address = Validate.checkInputString();
                    System.out.println("Enter new item name:");
                    itemName = Validate.checkInputString();
                    System.out.println("Enter new item quantity:");
                    itemQuantity = Validate.checkInputString();
                    System.out.println("Enter new item price:");
                    itemPrice = Validate.checkInputString();
                    System.out.println("Enter new item price currency:");
                    priceCurrency = Validate.checkInputString();

                    UpdateXML updateXML = new UpdateXML();
                    List<Item> itemList = new ArrayList();
                    itemList.add(new Item(itemName, itemQuantity, new Price(priceCurrency,itemPrice)));
                    updateXML.updateXML("src/main/java/xml/order.xml", new Order(number, order_date, customer, itemList, email, phone, address));
                    break;
                case 4:
//                    System.out.println("Enter index: ");
//                    index = checkInputInt();
//                    RemoveXML("src/main/java/xml/newemployee.xml", index, employees);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Does not exist with the entered ID");
                    System.out.println("Try again");
                    break;
            }
        }
    }

}
