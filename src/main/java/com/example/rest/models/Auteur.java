package com.example.rest.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Data
@Getter @Setter @Builder
@Entity
@Table
@XmlRootElement
public class Auteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @XmlElement
    private int id ;
    private String firstname ;
    private String lastname ;

    public Auteur(int id, String firstname, String lastname, List<Livre> livres) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.livres = livres;
    }

    public Auteur(){
    }
    @OneToMany (mappedBy = "auteur")
    List<Livre> livres ;

    @Override
    public String toString() {
        return "Auteur{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
    public Auteur(String firstname, String lastname) {

        this.firstname = firstname;
        this.lastname = lastname;
    }

}
