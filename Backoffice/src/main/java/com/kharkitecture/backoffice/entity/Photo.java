package com.kharkitecture.backoffice.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "photo")
public class Photo {
    private static long nextId;
    @Id
    private long id;
    private String url;
    @ManyToOne(targetEntity = Building.class)
    private Building building;

    public Photo(String url) {
        this.url = url;
    }

    public Photo(String url, Building building) {
        this.id = ++nextId;
        this.url = url;
        this.building = building;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Photo)) return false;
        Photo photo = (Photo) o;
        return id == photo.id &&
                Objects.equals(url, photo.url);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, url);
    }
}