package me.ljnic.tomes;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import org.spongepowered.api.text.Text;

@ConfigSerializable
public class Page {
    @Setting
    private Text content;

    public Page() {
        content = Text.of();
    }

    public Text getContent() {
        return content;
    }
}
