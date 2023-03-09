package com.trevorjmoore.randleague.models;


import javax.persistence.*;


@Entity
@Table(name = "champions")
public class Champion {
    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    private String championName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return championName;
    }

    public void setName(String name) {
        this.championName = name;
    }

}
