package com.trevorjmoore.randleague.models;

import javax.persistence.*;

@Entity
@Table(name="runes")
public class Rune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String runeName;

    @Column
    private String runeFamily;

    @Column
    private Integer runeTier;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuneName() {
        return runeName;
    }

    public void setRuneName(String runeName) {
        this.runeName = runeName;
    }

    public String getRuneFamily() {
        return runeFamily;
    }

    public void setRuneFamily(String runeFamily) {
        this.runeFamily = runeFamily;
    }

    public Integer getRuneTier() {
        return runeTier;
    }

    public void setRuneTier(Integer runeTier) {
        this.runeTier = runeTier;
    }



}
