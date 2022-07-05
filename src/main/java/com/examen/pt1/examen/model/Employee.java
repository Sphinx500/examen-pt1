package com.examen.pt1.examen.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="surname")
    private String surname;

    @Column(name="firstname")
    private String firstname;

    @ManyToOne(targetEntity=Language.class)
    private List lang;

    @OneToOne(targetEntity=Country.class)
    private List coun;

    @OneToMany(targetEntity=Airports.class)
    private List air;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
