package _m_j;

import android.database.Cursor;
import android.widget.Filter;

final class dd extends Filter {

    /* renamed from: O000000o  reason: collision with root package name */
    O000000o f14492O000000o;

    interface O000000o {
        Cursor O000000o();

        Cursor O000000o(CharSequence charSequence);

        void O000000o(Cursor cursor);

        CharSequence O00000Oo(Cursor cursor);
    }

    dd(O000000o o000000o) {
        this.f14492O000000o = o000000o;
    }

    public final CharSequence convertResultToString(Object obj) {
        return this.f14492O000000o.O00000Oo((Cursor) obj);
    }

    /* access modifiers changed from: protected */
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor O000000o2 = this.f14492O000000o.O000000o(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (O000000o2 != null) {
            filterResults.count = O000000o2.getCount();
            filterResults.values = O000000o2;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    /* access modifiers changed from: protected */
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor O000000o2 = this.f14492O000000o.O000000o();
        if (filterResults.values != null && filterResults.values != O000000o2) {
            this.f14492O000000o.O000000o((Cursor) filterResults.values);
        }
    }
}
