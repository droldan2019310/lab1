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
public class Dog {
    String name;
    double courage;
    double rank;
    Random random = new Random();
    public Dog(String name) {
        this.name = name;
        this.courage = -5+random.nextInt(10);
        this.rank = -20+random.nextInt(20);
    }

    public String getName() {
        return name;
    }

    public double getCourage() {
        return courage;
    }

    public double getRank() {
        return rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourage(double courage) {
        this.courage = courage;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Dog{" + "name=" + name + ", courage=" + courage + ", rank=" + rank + '}';
    }
    
    public boolean bite(){
        if(courage<rank){
            //te muerde el perro
            return true;
        }else return false;
    }
    
    public boolean bark(){
        if(courage<0  && rank<courage) return true;
        else return false;
    }
    
    public boolean happy(){
        if(courage>=0) return true;
        else return false;
               
    }
}
