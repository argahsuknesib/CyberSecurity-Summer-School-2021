package com.smarthome.uwb.ui.manager;

import _m_j.iuh;
import _m_j.iwc;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "updatePermit", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class UwbPermissionDialog$showUwbPermissionDialog$showDialog$4 extends Lambda implements iwc<Integer, iuh> {
    final /* synthetic */ View $permitAllView;
    final /* synthetic */ View $permitHomeView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UwbPermissionDialog$showUwbPermissionDialog$showDialog$4(View view, View view2) {
        super(1);
        this.$permitHomeView = view;
        this.$permitAllView = view2;
    }

    public final /* synthetic */ Object invoke(Object obj) {
        if (((Number) obj).intValue() == 1) {
            this.$permitHomeView.performClick();
        } else {
            this.$permitAllView.performClick();
        }
        return iuh.f1631O000000o;
    }
}
