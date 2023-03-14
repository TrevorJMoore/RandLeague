package com.trevorjmoore.randleague.models;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    //Item has name, description, cost, and isMythic
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String itemName;

    @Column
    private Integer itemCost;

    @Column
    private Boolean isMythic;

    @Column
    private Boolean isBoot;


    //Getters / Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getItemCost() {
        return itemCost;
    }

    public void setItemCost(Integer itemCost) {
        this.itemCost = itemCost;
    }

    public Boolean getMythic() {
        return isMythic;
    }

    public void setMythic(Boolean mythic) {
        isMythic = mythic;
    }

    public Boolean getBoot() { return isBoot; }

    public void setBoot(Boolean boot) { isBoot = boot; }
}
