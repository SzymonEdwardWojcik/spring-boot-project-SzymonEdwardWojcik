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
}
