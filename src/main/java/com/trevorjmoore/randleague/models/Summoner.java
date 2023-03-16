package com.trevorjmoore.randleague.models;


import javax.persistence.*;

@Entity
@Table(name="summoners")
public class Summoner {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String summonerName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

}
