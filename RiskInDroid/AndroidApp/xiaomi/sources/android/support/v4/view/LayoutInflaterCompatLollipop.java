package android.support.v4.view;

import android.annotation.TargetApi;
import android.support.annotation.RequiresApi;
import android.support.v4.view.LayoutInflaterCompatHC;
import android.view.LayoutInflater;

@TargetApi(21)
@RequiresApi(21)
class LayoutInflaterCompatLollipop {
    LayoutInflaterCompatLollipop() {
    }

    static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        layoutInflater.setFactory2(layoutInflaterFactory != null ? new LayoutInflaterCompatHC.FactoryWrapperHC(layoutInflaterFactory) : null);
    }
}
