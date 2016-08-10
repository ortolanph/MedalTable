package org.medal.entity;

public class MedalShelf {
    private String country;
    private Integer gold;
    private Integer silver;
    private Integer bronze;

    public MedalShelf() {
    }

    public MedalShelf(String country) {
        this.country = country;
        this.gold = 0;
        this.silver = 0;
        this.bronze = 0;
    }

    public MedalShelf(String country, Integer gold, Integer silver, Integer bronze) {
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Integer getSilver() {
        return silver;
    }

    public void setSilver(Integer silver) {
        this.silver = silver;
    }

    public Integer getBronze() {
        return bronze;
    }

    public void setBronze(Integer bronze) {
        this.bronze = bronze;
    }

    @Override
    public String toString() {
        return String.format("%-20s\t%03d\t%03d\t%03d\t%03d",
                country,
                gold,
                silver,
                bronze,
                gold + silver + bronze
        );
    }
}
