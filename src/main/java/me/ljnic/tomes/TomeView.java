package me.ljnic.tomes;

import com.atherys.core.views.View;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.BookView;

import java.util.List;

public class TomeView implements View<Tome> {
    List<Page> pages;

    public TomeView(List<Page> pages) {
        this.pages = pages;
    }

    private BookView toBookView() {
        BookView.Builder bookView = BookView.builder();
        pages.forEach(page -> bookView.addPage(page.getContent()));
        return bookView.build();
    }

    @Override
    public void show(Player player) {
        player.sendBookView(toBookView());
    }
}
