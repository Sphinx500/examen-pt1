package com.examen.pt1.examen.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "languages_like",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<Language> likedLanguages;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employee_id;

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
        return employee_id;
    }

    public void setId(long employee_id) {
        this.employee_id = employee_id;
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
