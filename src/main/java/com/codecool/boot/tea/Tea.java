package com.codecool.boot.tea;

import com.codecool.boot.teatype.TeaType;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
public class Tea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private TeaType teaType;

    public Tea(String name, Integer price, TeaType teaType) {
        this.name = name;
        this.price = price;
        this.teaType = teaType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public TeaType getTeaType() {
        return teaType;
    }

    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }
}
