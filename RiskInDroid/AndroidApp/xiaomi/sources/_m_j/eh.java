package _m_j;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

public abstract class eh extends jz {
    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private final int mBehavior;
    private ei mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final ee mFragmentManager;

    public abstract Fragment getItem(int i);

    public long getItemId(int i) {
        return (long) i;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public eh(ee eeVar) {
        this(eeVar, 0);
    }

    public eh(ee eeVar, int i) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = eeVar;
        this.mBehavior = i;
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.O000000o();
        }
        long itemId = getItemId(i);
        Fragment O000000o2 = this.mFragmentManager.O000000o(makeFragmentName(viewGroup.getId(), itemId));
        if (O000000o2 != null) {
            this.mCurTransaction.O00000oo(O000000o2);
        } else {
            O000000o2 = getItem(i);
            this.mCurTransaction.O000000o(viewGroup.getId(), O000000o2, makeFragmentName(viewGroup.getId(), itemId));
        }
        if (O000000o2 != this.mCurrentPrimaryItem) {
            O000000o2.setMenuVisibility(false);
            if (this.mBehavior == 1) {
                this.mCurTransaction.O000000o(O000000o2, Lifecycle.State.STARTED);
            } else {
                O000000o2.setUserVisibleHint(false);
            }
        }
        return O000000o2;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.O000000o();
        }
        this.mCurTransaction.O00000o(fragment);
        if (fragment == this.mCurrentPrimaryItem) {
            this.mCurrentPrimaryItem = null;
        }
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.mCurrentPrimaryItem;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                if (this.mBehavior == 1) {
                    if (this.mCurTransaction == null) {
                        this.mCurTransaction = this.mFragmentManager.O000000o();
                    }
                    this.mCurTransaction.O000000o(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
                } else {
                    this.mCurrentPrimaryItem.setUserVisibleHint(false);
                }
            }
            fragment.setMenuVisibility(true);
            if (this.mBehavior == 1) {
                if (this.mCurTransaction == null) {
                    this.mCurTransaction = this.mFragmentManager.O000000o();
                }
                this.mCurTransaction.O000000o(fragment, Lifecycle.State.RESUMED);
            } else {
                fragment.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = fragment;
        }
    }

    public void finishUpdate(ViewGroup viewGroup) {
        ei eiVar = this.mCurTransaction;
        if (eiVar != null) {
            eiVar.O00000oO();
            this.mCurTransaction = null;
        }
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    private static String makeFragmentName(int i, long j) {
        return "android:switcher:" + i + ":" + j;
    }
}
