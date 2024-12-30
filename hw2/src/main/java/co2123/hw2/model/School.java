package co2123.hw2.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String location;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pupil> pupils;

    @ManyToOne
    private Pupil representative;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Pupil> getPupils() {
        return this.pupils;
    }

    public void setPupils(List<Pupil> pupils) {
        this.pupils = pupils;
    }

    public Pupil getRepresentative() {
        return this.representative;
    }

    public void setRepresentative(Pupil representative) {
        this.representative = representative;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + this.id +
                ", location='" + this.location + '\'' +
                ", pupils=" + this.pupils +
                ", representative=" + this.representative +
                '}';
    }
}
