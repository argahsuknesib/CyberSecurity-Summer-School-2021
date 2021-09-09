package com.xiaomi.smarthome.nfctag.ui;

import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class NFCKuailianWriteTestActivity_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private NFCKuailianWriteTestActivity f10425O000000o;
    private View O00000Oo;

    public NFCKuailianWriteTestActivity_ViewBinding(final NFCKuailianWriteTestActivity nFCKuailianWriteTestActivity, View view) {
        this.f10425O000000o = nFCKuailianWriteTestActivity;
        View findRequiredView = Utils.findRequiredView(view, R.id.btn_write, "method 'onClick'");
        this.O00000Oo = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCKuailianWriteTestActivity_ViewBinding.AnonymousClass1 */

            public final void doClick(View view) {
                nFCKuailianWriteTestActivity.onClick(view);
            }
        });
    }

    public void unbind() {
        if (this.f10425O000000o != null) {
            this.f10425O000000o = null;
            this.O00000Oo.setOnClickListener(null);
            this.O00000Oo = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
