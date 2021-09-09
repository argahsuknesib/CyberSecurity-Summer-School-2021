package com.ogaclejapan.smarttablayout.utils;

import android.content.Context;
import java.util.ArrayList;

public abstract class PagerItems<T> extends ArrayList<T> {
    private final Context context;

    protected PagerItems(Context context2) {
        this.context = context2;
    }
}
