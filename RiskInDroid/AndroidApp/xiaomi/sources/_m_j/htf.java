package _m_j;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.library.log.LogType;

public class htf extends jz {
    private static final String O00000Oo = "htf";

    /* renamed from: O000000o  reason: collision with root package name */
    public jz f618O000000o;

    public static int O00000Oo(int i) {
        return i + 1;
    }

    public htf(jz jzVar) {
        this.f618O000000o = jzVar;
    }

    public int getCount() {
        return this.f618O000000o.getCount() + 2;
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        int O000000o2 = O000000o(i);
        gsy.O000000o(LogType.GENERAL, O00000Oo, "instantiateItem pos: ".concat(String.valueOf(O000000o2)));
        return this.f618O000000o.instantiateItem(viewGroup, O000000o2);
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        int O000000o2 = O000000o(i);
        gsy.O000000o(LogType.GENERAL, O00000Oo, "destroyItem pos: ".concat(String.valueOf(O000000o2)));
        this.f618O000000o.destroyItem(viewGroup, O000000o2, obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        this.f618O000000o.finishUpdate(viewGroup);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return this.f618O000000o.isViewFromObject(view, obj);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.f618O000000o.restoreState(parcelable, classLoader);
    }

    public Parcelable saveState() {
        return this.f618O000000o.saveState();
    }

    public void startUpdate(ViewGroup viewGroup) {
        this.f618O000000o.startUpdate(viewGroup);
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.f618O000000o.setPrimaryItem(viewGroup, i, obj);
    }

    public int getItemPosition(Object obj) {
        return this.f618O000000o.getItemPosition(obj);
    }

    public void notifyDataSetChanged() {
        this.f618O000000o.notifyDataSetChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f618O000000o.registerDataSetObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f618O000000o.unregisterDataSetObserver(dataSetObserver);
    }

    public CharSequence getPageTitle(int i) {
        return this.f618O000000o.getPageTitle(i);
    }

    public float getPageWidth(int i) {
        return this.f618O000000o.getPageWidth(i);
    }

    public final int O000000o(int i) {
        int count = this.f618O000000o.getCount();
        if (count == 0) {
            return 0;
        }
        int i2 = (i - 1) % count;
        return i2 < 0 ? i2 + count : i2;
    }
}
