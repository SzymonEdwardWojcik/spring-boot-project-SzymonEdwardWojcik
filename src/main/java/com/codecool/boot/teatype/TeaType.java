package com.codecool.boot.teatype;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TeaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    private String origin;

    public TeaType (String type, String origin) {
        this.type = type;
        this.origin = origin;
    }

}
