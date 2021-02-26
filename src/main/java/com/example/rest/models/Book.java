package com.example.rest.models;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table
@XmlRootElement
public class Book {

    @XmlAttribute
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id  ;
    private String name ;
    private String title  ;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)

    private Auteur auteur ;      // Add Wrapper


   public Book(){}
    public Book(String name, String title, Auteur auteur) {
       this.name = name ;
        this.title = title;
        this.auteur = auteur;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*public Long getId() {
        return id;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    @Override
    public String toString() {
        return "Book{" +
                //"id=" + id +//
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", auteur=" + auteur +
                '}';
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }
}
