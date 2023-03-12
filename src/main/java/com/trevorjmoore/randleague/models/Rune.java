package com.trevorjmoore.randleague.models;

import javax.persistence.*;

@Entity
@Table(name="runes")
public class Rune {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String runeName;

    @Column
    private String runeDescription;

    @Column
    private String runeFamily;

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

    public String getRuneDescription() {
        return runeDescription;
    }

    public void setRuneDescription(String runeDescription) {
        this.runeDescription = runeDescription;
    }

    public String getRuneFamily() {
        return runeFamily;
    }

    public void setRuneFamily(String runeFamily) {
        this.runeFamily = runeFamily;
    }



}
