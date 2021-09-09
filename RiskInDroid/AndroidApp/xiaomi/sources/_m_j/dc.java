package _m_j;

import _m_j.dd;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class dc extends BaseAdapter implements dd.O000000o, Filterable {
    protected boolean O00000Oo = false;
    protected Cursor O00000o = null;
    protected boolean O00000o0 = true;
    protected Context O00000oO;
    protected int O00000oo;
    protected O000000o O0000O0o;
    protected DataSetObserver O0000OOo;
    protected FilterQueryProvider O0000Oo;
    protected dd O0000Oo0;

    public abstract View O000000o(Context context, Cursor cursor, ViewGroup viewGroup);

    public abstract void O000000o(View view, Cursor cursor);

    public boolean hasStableIds() {
        return true;
    }

    public dc(Context context, Cursor cursor, boolean z) {
        this.O00000oO = context;
        this.O00000oo = -1;
        this.O0000O0o = new O000000o();
        this.O0000OOo = new O00000Oo();
    }

    public final Cursor O000000o() {
        return this.O00000o;
    }

    public int getCount() {
        Cursor cursor;
        if (!this.O00000Oo || (cursor = this.O00000o) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public Object getItem(int i) {
        Cursor cursor;
        if (!this.O00000Oo || (cursor = this.O00000o) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.O00000o;
    }

    public long getItemId(int i) {
        Cursor cursor;
        if (!this.O00000Oo || (cursor = this.O00000o) == null || !cursor.moveToPosition(i)) {
            return 0;
        }
        return this.O00000o.getLong(this.O00000oo);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.O00000Oo) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.O00000o.moveToPosition(i)) {
            if (view == null) {
                view = O000000o(this.O00000oO, this.O00000o, viewGroup);
            }
            O000000o(view, this.O00000o);
            return view;
        } else {
            throw new IllegalStateException("couldn't move cursor to position ".concat(String.valueOf(i)));
        }
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.O00000Oo) {
            return null;
        }
        this.O00000o.moveToPosition(i);
        if (view == null) {
            view = O00000Oo(this.O00000oO, this.O00000o, viewGroup);
        }
        O000000o(view, this.O00000o);
        return view;
    }

    public View O00000Oo(Context context, Cursor cursor, ViewGroup viewGroup) {
        return O000000o(context, cursor, viewGroup);
    }

    public CharSequence O00000Oo(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    public Cursor O000000o(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.O0000Oo;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.O00000o;
    }

    public Filter getFilter() {
        if (this.O0000Oo0 == null) {
            this.O0000Oo0 = new dd(this);
        }
        return this.O0000Oo0;
    }

    /* access modifiers changed from: protected */
    public final void O00000Oo() {
        Cursor cursor;
        if (this.O00000o0 && (cursor = this.O00000o) != null && !cursor.isClosed()) {
            this.O00000Oo = this.O00000o.requery();
        }
    }

    class O000000o extends ContentObserver {
        public final boolean deliverSelfNotifications() {
            return true;
        }

        O000000o() {
            super(new Handler());
        }

        public final void onChange(boolean z) {
            dc.this.O00000Oo();
        }
    }

    class O00000Oo extends DataSetObserver {
        O00000Oo() {
        }

        public final void onChanged() {
            dc dcVar = dc.this;
            dcVar.O00000Oo = true;
            dcVar.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            dc dcVar = dc.this;
            dcVar.O00000Oo = false;
            dcVar.notifyDataSetInvalidated();
        }
    }

    public void O000000o(Cursor cursor) {
        Cursor cursor2 = this.O00000o;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                O000000o o000000o = this.O0000O0o;
                if (o000000o != null) {
                    cursor2.unregisterContentObserver(o000000o);
                }
                DataSetObserver dataSetObserver = this.O0000OOo;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.O00000o = cursor;
            if (cursor != null) {
                O000000o o000000o2 = this.O0000O0o;
                if (o000000o2 != null) {
                    cursor.registerContentObserver(o000000o2);
                }
                DataSetObserver dataSetObserver2 = this.O0000OOo;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.O00000oo = cursor.getColumnIndexOrThrow("_id");
                this.O00000Oo = true;
                notifyDataSetChanged();
            } else {
                this.O00000oo = -1;
                this.O00000Oo = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }
}
