package me.ljnic.tomes;

import com.atherys.core.views.View;
import com.atherys.core.views.Viewable;
import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ConfigSerializable
public class Tome implements Viewable {
    // Should be unique
    @Setting(value = "id")
    private String id;
    @Setting(value = "pages")
    private List<Page> pages;

    public Tome() {
        this.id = "DEFAULT_TOME";
        pages= new ArrayList<>();
    }

    public Tome(String id, Page... pages) {
        this.id = id;
        this.pages = Arrays.asList(pages);
    }

    public String getId() {
        return id;
    }

    public List<Page> getPages() {
        return pages;
    }

    public int length() {
        return pages.size();
    }

    @Override
    public View createView() {
        return new TomeView(getPages());
    }
}
