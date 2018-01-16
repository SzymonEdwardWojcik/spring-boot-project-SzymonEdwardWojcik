package com.codecool.boot.tea;

import com.codecool.boot.teatype.TeaType;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name="TEAS")
public class Tea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price;
    @ManyToOne
    @JoinColumn(name="type_id")
    private TeaType teaType;

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
