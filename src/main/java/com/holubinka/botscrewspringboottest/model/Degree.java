package com.holubinka.botscrewspringboottest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEGREE")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DEGREE")
    private String degree;

    @OneToMany(mappedBy = "degree", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("degree")
    private List<Lector> lectors = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }
}
