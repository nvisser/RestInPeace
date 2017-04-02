package nl.bcome.iac.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class District {
    private float id;
    private String name;
    private int year;
    private int amount;

    public District(float id, String name, int year, int amount) {

        this.id = id;
        this.name = name;
        this.year = year;
        this.amount = amount;
    }

    public District(String name, int year, int amount) {

        this.name = name;
        this.year = year;
        this.amount = amount;
    }

    public District() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
