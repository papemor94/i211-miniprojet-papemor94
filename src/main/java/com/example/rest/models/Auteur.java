package com.example.rest.models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@Table
@XmlRootElement
public class Auteur implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @XmlAttribute
    private double id ;
    private String firstname ;
    private String lastname ;

    public Auteur(){
        this.id = Math.random()*Math.random();

    }
    public double getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public Auteur(String firstname, String lastname) {
        this.id =Math.random()*Math.random() ;

        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }




}
