package _m_j;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class jz {
    private final DataSetObservable mObservable = new DataSetObservable();
    private DataSetObserver mViewPagerObserver;

    @Deprecated
    public void finishUpdate(View view) {
    }

    public abstract int getCount();

    public int getItemPosition(Object obj) {
        return -1;
    }

    public CharSequence getPageTitle(int i) {
        return null;
    }

    public float getPageWidth(int i) {
        return 1.0f;
    }

    public abstract boolean isViewFromObject(View view, Object obj);

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public void setPrimaryItem(View view, int i, Object obj) {
    }

    @Deprecated
    public void startUpdate(View view) {
    }

    public void startUpdate(ViewGroup viewGroup) {
        startUpdate((View) viewGroup);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.instantiateItem(android.view.View, int):java.lang.Object
     arg types: [android.view.ViewGroup, int]
     candidates:
      _m_j.jz.instantiateItem(android.view.ViewGroup, int):java.lang.Object
      _m_j.jz.instantiateItem(android.view.View, int):java.lang.Object */
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return instantiateItem((View) viewGroup, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.destroyItem(android.view.View, int, java.lang.Object):void
     arg types: [android.view.ViewGroup, int, java.lang.Object]
     candidates:
      _m_j.jz.destroyItem(android.view.ViewGroup, int, java.lang.Object):void
      _m_j.jz.destroyItem(android.view.View, int, java.lang.Object):void */
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        destroyItem((View) viewGroup, i, obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.jz.setPrimaryItem(android.view.View, int, java.lang.Object):void
     arg types: [android.view.ViewGroup, int, java.lang.Object]
     candidates:
      _m_j.jz.setPrimaryItem(android.view.ViewGroup, int, java.lang.Object):void
      _m_j.jz.setPrimaryItem(android.view.View, int, java.lang.Object):void */
    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        setPrimaryItem((View) viewGroup, i, obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        finishUpdate((View) viewGroup);
    }

    @Deprecated
    public Object instantiateItem(View view, int i) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    @Deprecated
    public void destroyItem(View view, int i, Object obj) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void notifyDataSetChanged() {
        synchronized (this) {
            if (this.mViewPagerObserver != null) {
                this.mViewPagerObserver.onChanged();
            }
        }
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.registerObserver(dataSetObserver);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.mObservable.unregisterObserver(dataSetObserver);
    }

    public void setViewPagerObserver(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.mViewPagerObserver = dataSetObserver;
        }
    }
}
