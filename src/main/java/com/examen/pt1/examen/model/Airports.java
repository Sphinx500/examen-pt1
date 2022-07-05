package com.examen.pt1.examen.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airports {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="name")
    private String name;

    @OneToMany(targetEntity=Employee.class)
    private List empl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
