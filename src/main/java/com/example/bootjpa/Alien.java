package com.example.bootjpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity //means.. create table of this name
public class Alien {
    @Id // means add these instances as db col
    private int aid;
    private String aname;
    private String tech;

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

}
