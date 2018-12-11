package me.ljnic.tomes;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.serializer.TextSerializers;

@ConfigSerializable
public class Page {
    @Setting(value = "content")
    private String formattedContent;

    private Text content;

    @Setting(value = "id")
    private int id;

    public Page() {
        formattedContent = "";
        content = Text.EMPTY;
    }

    public Page(Text content) {
        this.content = content;
        this.formattedContent = TextSerializers.FORMATTING_CODE.serialize(content);
    }

    public Page(String formattedText) {
        content = TextSerializers.FORMATTING_CODE.deserialize(formattedText);
        Tomes.getLogger().info(content.toString());
        Tomes.getLogger().info(formattedText);
        formattedContent = formattedText;
    }

    public Text getContent() {
        return content;
    }
}
