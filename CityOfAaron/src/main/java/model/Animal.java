/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
/**
 *
 * @author dapon
 */
public class Animal extends InventoryItem implements Serializable{
    
    //attributes
    private int age;
    
    //default constructor
    public Animal(){    
    }
    
    // overloaded constructor
    public Animal(String name, ItemType itemType, Condition condition, int quantity, int age){
        this.name = name;
        this.itemType = itemType;
        this.condition = condition;
        this.quantity = quantity;
        this.age = age;
    }
    
    //getter and setter
    public int getAge(){
        return age;
    }
    
    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" 
                + super.toString()
                + "\n age=" + age 
                + '}';
    }
    
}
