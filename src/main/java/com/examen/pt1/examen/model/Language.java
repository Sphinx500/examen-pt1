package com.examen.pt1.examen.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "language")
public class Language {
    @ManyToMany(mappedBy = "likedLanguages", cascade = CascadeType.PERSIST)
    private List<Employee> likes;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long languaje_id;

    @Column(name="code")
    private long code;

    @Column(name="name")
    private String name;

    @ManyToOne(targetEntity=Employee.class)
    private List empl;


    public long getId() {
        return languaje_id;
    }

    public void setId(long languaje_id) {
        this.languaje_id = languaje_id;
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
