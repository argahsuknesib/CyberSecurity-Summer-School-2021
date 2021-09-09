package com.google.android.material.datepicker;

public abstract class OnSelectionChangedListener<S> {
    public void onIncompleteSelectionChanged() {
    }

    public abstract void onSelectionChanged(S s);
}
