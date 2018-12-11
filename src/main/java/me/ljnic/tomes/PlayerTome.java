package me.ljnic.tomes;

import com.atherys.core.views.View;
import com.atherys.core.views.Viewable;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Represents a Tome that can have missing pages.
 */
public class PlayerTome implements Viewable {
    private Tome tome;
    private Set<Integer> pages;

    public PlayerTome(Tome tome, List<Integer> pageIds) {
        this.tome = tome;

        pages = new HashSet<>();
        pages.addAll(pageIds);
    }

    @Override
    public View createView() {
        List<Page> viewPages = new ArrayList<>();
        int i = 0;
        for (Page page : tome.getPages()) {
            if (pages.contains(i)) {
                viewPages.add(page);
                Tomes.getLogger().info(page.getContent().toString());
            } else {
                viewPages.add(new Page(Text.EMPTY));
            }
            i++;
        }
        return new TomeView(viewPages);
    }

    public void addPages(List<Integer> newPages) {
        pages.addAll(newPages);
    }

    public Tome getTome() {
        return tome;
    }
}
