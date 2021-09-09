package com.facebook.react.uimanager;

import java.util.Comparator;

public class ViewAtIndex {
    public static Comparator<ViewAtIndex> COMPARATOR = new Comparator<ViewAtIndex>() {
        /* class com.facebook.react.uimanager.ViewAtIndex.AnonymousClass1 */

        public final int compare(ViewAtIndex viewAtIndex, ViewAtIndex viewAtIndex2) {
            return viewAtIndex.mIndex - viewAtIndex2.mIndex;
        }
    };
    public final int mIndex;
    public final int mTag;

    public ViewAtIndex(int i, int i2) {
        this.mTag = i;
        this.mIndex = i2;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            ViewAtIndex viewAtIndex = (ViewAtIndex) obj;
            if (this.mIndex == viewAtIndex.mIndex && this.mTag == viewAtIndex.mTag) {
                return true;
            }
            return false;
        }
        return false;
    }

    public String toString() {
        return "[" + this.mTag + ", " + this.mIndex + "]";
    }
}
