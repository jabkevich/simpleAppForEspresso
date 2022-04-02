package ru.kkuzmichev.simpleappforespresso.matchers;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;

public class ItemVisibleMatcher extends BoundedMatcher<View, RecyclerView> {
    private final int pos;

    public ItemVisibleMatcher(Class<? extends RecyclerView> expectedType, int pos) {
        super(expectedType);
        this.pos = pos;
    }

    @Override
    protected boolean matchesSafely(RecyclerView item) {
        RecyclerView.ViewHolder viewHolder = item.findViewHolderForAdapterPosition(pos);
        if (viewHolder == null) {
            return false;
        }
        return viewHolder.itemView.getVisibility() == View.VISIBLE;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("has item at position " + pos + ": ");
    }
}