/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Hoahanna
 */
import java.util.List;
 
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "orders")
public class Orders 
{
  @XmlElement(name = "order")
  private List<Order> orders = null;
 
  public List<Order> getEmployees() {
    return orders;
  }
 
  public void setEmployees(List<Order> orders) {
    this.orders = orders;
  }
}
