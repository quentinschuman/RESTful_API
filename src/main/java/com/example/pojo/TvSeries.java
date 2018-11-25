package com.example.pojo;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * ProjectName: RESTful API
 * User: quent
 * Date: 2018/11/21
 * Time: 15:42
 */
public class TvSeries {

    private int id;
    private String name;
    private int seasonCount;
    private Date originRelease;

    public TvSeries() {

    }

    public TvSeries(int id, String name, int seasonCount, Date originRelease) {
        this.id = id;
        this.name = name;
        this.seasonCount = seasonCount;
        this.originRelease = originRelease;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSeasonCount() {
        return seasonCount;
    }

    public Date getOriginRelease() {
        return originRelease;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeasonCount(int seasonCount) {
        this.seasonCount = seasonCount;
    }

    public void setOriginRelease(Date originRelease) {
        this.originRelease = originRelease;
    }

    public String toString(){
        return this.getClass().getName() + "{id=" + id + ";name=" + name + "}";
    }
}
