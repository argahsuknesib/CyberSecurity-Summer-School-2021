package androidx.appcompat.view.menu;

import _m_j.OO0OOOO;
import _m_j.OO0o00;
import _m_j.Oo;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.MenuBuilder;

public final class ExpandedMenuView extends ListView implements OO0o00, AdapterView.OnItemClickListener, MenuBuilder.O00000Oo {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final int[] f2678O000000o = {16842964, 16843049};
    private MenuBuilder O00000Oo;
    private int O00000o0;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        Oo O000000o2 = Oo.O000000o(context, attributeSet, f2678O000000o, i, 0);
        if (O000000o2.O0000O0o(0)) {
            setBackgroundDrawable(O000000o2.O000000o(0));
        }
        if (O000000o2.O0000O0o(1)) {
            setDivider(O000000o2.O000000o(1));
        }
        O000000o2.f12340O000000o.recycle();
    }

    public final void initialize(MenuBuilder menuBuilder) {
        this.O00000Oo = menuBuilder;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final boolean O000000o(OO0OOOO oo0oooo) {
        return this.O00000Oo.performItemAction(oo0oooo, 0);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        O000000o((OO0OOOO) getAdapter().getItem(i));
    }

    public final int getWindowAnimations() {
        return this.O00000o0;
    }
}
