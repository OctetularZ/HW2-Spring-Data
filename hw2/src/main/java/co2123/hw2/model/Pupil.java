package co2123.hw2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class Pupil {
    @Id
    private String name;

    @ManyToMany(mappedBy = "pupils")
    private List<School> schools;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn
    private List<Grade> grades;

    @OneToOne
    private Grade best;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<School> getSchools() {
        return this.schools;
    }

    public void setSchools(List<School> schools) {
        this.schools = schools;
    }

    public List<Grade> getGrades() {
        return this.grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Grade getBest() {
        return this.best;
    }

    public void setBest(Grade best) {
        this.best = best;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "name='" + this.name + '\'' +
                ", grades=" + this.grades +
                ", best=" + this.best +
                '}';
    }
}
