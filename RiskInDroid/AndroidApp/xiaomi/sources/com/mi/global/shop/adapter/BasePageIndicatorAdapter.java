package com.mi.global.shop.adapter;

import android.content.Context;
import android.view.View;

public abstract class BasePageIndicatorAdapter<T> extends BasePageAdapter<T> {
    public BasePageIndicatorAdapter(Context context) {
        super(context);
    }

    public int getCount() {
        if (this.f4732O000000o.size() == 1) {
            return 1;
        }
        return this.f4732O000000o.size() == 0 ? 0 : 500;
    }

    public final T O000000o(int i) {
        if (i < 0 || i >= O000000o()) {
            return this.f4732O000000o.get(i % O000000o());
        }
        return this.f4732O000000o.get(i);
    }

    public final int O000000o() {
        if (this.f4732O000000o != null) {
            return this.f4732O000000o.size();
        }
        return 0;
    }

    public int getItemPosition(Object obj) {
        if (O000000o() > 0) {
            return this.f4732O000000o.contains(((View) obj).getTag()) ? -1 : -2;
        }
        return super.getItemPosition(obj);
    }
}
