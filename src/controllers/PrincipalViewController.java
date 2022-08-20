/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import models.Dog;
import models.Person;

/**
 *
 * @author Davis
 */
public class PrincipalViewController implements Initializable {
    
    @FXML
    private TextField textNameDog;
    @FXML
    private TextField textCourageDog;
    @FXML
    private TextField textRankDog;
    @FXML
    private TextField textActionDog;
    @FXML
    private Button btnSaveDog;
    @FXML
    private TextField reactionPerson;
    @FXML
    private Button btnInteract;
    @FXML
    private Button btngiveCookie;
    @FXML
    private TextField namePerson;
    @FXML
    private TextField reliabilityPerson;
    @FXML
    private TextField isCookiePerson;
    @FXML
    private Button btnSavePerson;
    
    private Person person;
    private Dog dog;
    
    
    private Random random = new Random();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void SaveDog(ActionEvent event) {
        if(textNameDog.getText() != null && !textNameDog.getText().equals("")){
            
            dog = new Dog(textNameDog.getText());
            
            textCourageDog.setText(String.valueOf(dog.getCourage()));
            textRankDog.setText(String.valueOf(dog.getRank()));
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CAMPOS FALTANTES");
            alert.setHeaderText("TE HACE FALTA RELLENAR EL NOMBRE DEL PERRO");
            alert.show();
        }
    }

    @FXML
    private void interactDog(ActionEvent event) {
        if(!textCourageDog.getText().isEmpty() && !textRankDog.getText().isEmpty() && !reliabilityPerson.getText().isEmpty()){
            if(dog.bark()){
                textActionDog.setText("WAO WAO! TE ESTOY LADRANDO ME CAES MAL");
            }else if(dog.bite()){
                textActionDog.setText("NO TE SOPORTO, TE ESTOY MORDIENDO");
            }else if(dog.happy()){
                textActionDog.setText("MUEVO LA COLA, ME CAES SUPER BIEN, TE QUIERO");
            }
            
            String mensajePersona = person.reaction(dog);
            
            reactionPerson.setText(mensajePersona);
            
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("PERRO O PERSONA FALTANTE");
            alert.setHeaderText("crea un perro o una persona para poder interactuar");
            alert.show();
        }
    }

    @FXML
    private void giveCookie(ActionEvent event) {
        double animo = (1.0/person.getReliability())*(random.nextFloat()-0.5)*10+dog.getCourage();
        
        if(person.isIsCookie()){
            person.setIsCookie(false);
            animo +=(1.0/person.getReliability())*(random.nextInt(2));
            dog.setCourage(animo);
            isCookiePerson.setText(String.valueOf(person.isIsCookie()));
            textCourageDog.setText(String.valueOf(dog.getCourage()));
            
            
            if(dog.bark()){
                textActionDog.setText("WAO WAO! TE ESTOY LADRANDO ME CAES MAL");
            }else if(dog.bite()){
                textActionDog.setText("NO TE SOPORTO, TE ESTOY MORDIENDO");
            }else if(dog.happy()){
                textActionDog.setText("MUEVO LA COLA, ME CAES SUPER BIEN, TE QUIERO");
            }
            
            
            String mensajePersona = person.reaction(dog);
            
            reactionPerson.setText(mensajePersona);
            
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("UPS");
            alert.setHeaderText("YA NO TIENES GALLETAS");
            alert.show();
        }
        
    }

    @FXML
    private void savePerson(ActionEvent event) {
        
        if(!namePerson.getText().equals("") && !isCookiePerson.getText().equals("")){
              person = new Person(namePerson.getText(), Boolean.parseBoolean(isCookiePerson.getText()));
              reliabilityPerson.setText(String.valueOf(person.getReliability()));
        }else{
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("CAMPOS FALTANTES");
            alert.setHeaderText("TE HACE FALTA RELLENAR EL NOMBRE DE LA PERSONA O SI QUIERES TENER GALLETA O NO");
            alert.show();
        }
        
    }
    
}
