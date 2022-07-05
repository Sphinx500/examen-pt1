package com.examen.pt1.examen.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "airport_id")
    private List<Airports> airports;

    @OneToOne(mappedBy = "country", cascade = CascadeType.ALL)
    private Employee employee;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long country_id;

    @Column(name="code")
    private long code;

    @Column(name="name")
    private String name;

    @OneToOne(targetEntity=Employee.class)
    private List emp;

    public long getId() {
        return country_id;
    }

    public void setId(long country_id) {
        this.country_id = country_id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
