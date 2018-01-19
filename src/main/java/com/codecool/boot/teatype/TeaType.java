package com.codecool.boot.teatype;

import com.codecool.boot.tea.Tea;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TYPES")
public class TeaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private String type;
    @NotEmpty
    private String origin;
    @OneToMany(mappedBy="teaType", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnoreProperties("teaType")
    private List<Tea> teas = new ArrayList<>();
    @JsonIgnore
    private boolean isArchived = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public List<Tea> getTeas() {
        return teas;
    }

    public void setTeas(List<Tea> teas) {
        this.teas = teas;
    }

    public String toString() {
        String str = String.format("Object TeaType with attributes:\n'type': %s, 'origin': %s", this.type, this.origin);
        return str;
    }
}
