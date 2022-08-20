/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Random;

/**
 *
 * @author Davis
 */
public class Person {
    String name;
    double reliability;
    boolean isCookie;
    Random random = new Random();
    
    public Person(String name, boolean isCookie) {
        this.name = name;
        this.reliability = 1+random.nextInt(10);
        this.isCookie = isCookie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getReliability() {
        return reliability;
    }

    public void setReliability(double reliability) {
        this.reliability = reliability;
    }

    public boolean isIsCookie() {
        return isCookie;
    }

    public void setIsCookie(boolean isCookie) {
        this.isCookie = isCookie;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", reliability=" + reliability + ", isCookie=" + isCookie + '}';
    }
    
    public String reaction(Dog dog){
        String reactionMessage="";
        if(dog.bark()){
            reactionMessage = "ME ESTAS ASUSTANDO, PARECE QUE ESTAS ENOJADO";
        }else if(dog.bite()){
            reactionMessage = "RAYOS, ESO ME DOLIÓ";
        }else if(dog.happy()){
            reactionMessage = "INCREIBLE, ESTAS FELIZ COMO YO TAMBIÉN";
        }
        
        return reactionMessage;
        
    }
    
    
    
}
