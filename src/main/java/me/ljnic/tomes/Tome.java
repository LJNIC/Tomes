package me.ljnic.tomes;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.util.ArrayList;
import java.util.List;

@ConfigSerializable
public class Tome {
    // Should be unique
    @Setting
    private String id;
    private List<Page> pages;

    public Tome() {
        this.id = "DEFAULT_TOME";
        pages= new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<Page> getPages() {
        return pages;
    }
}
