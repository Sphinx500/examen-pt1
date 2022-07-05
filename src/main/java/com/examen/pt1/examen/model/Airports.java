package com.examen.pt1.examen.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")

public class Airports {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private Country country;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long airport_id;

    @Column(name="name")
    private String name;

    @OneToMany(targetEntity=Employee.class)
    private List empl;

    public Airports(Country country) {
        this.country = country;
    }

    public long getId() {
        return airport_id;
    }

    public void setId(long airport_id) {
        this.airport_id = airport_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
