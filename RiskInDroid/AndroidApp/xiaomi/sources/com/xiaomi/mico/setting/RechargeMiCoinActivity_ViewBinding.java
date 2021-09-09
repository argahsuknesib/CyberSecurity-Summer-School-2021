package com.xiaomi.mico.setting;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;

public class RechargeMiCoinActivity_ViewBinding implements Unbinder {
    private RechargeMiCoinActivity target;
    private View view1c7a;

    public RechargeMiCoinActivity_ViewBinding(RechargeMiCoinActivity rechargeMiCoinActivity) {
        this(rechargeMiCoinActivity, rechargeMiCoinActivity.getWindow().getDecorView());
    }

    public RechargeMiCoinActivity_ViewBinding(final RechargeMiCoinActivity rechargeMiCoinActivity, View view) {
        this.target = rechargeMiCoinActivity;
        rechargeMiCoinActivity.titleBar = (TitleBar) Utils.findRequiredViewAsType(view, R.id.title_bar, "field 'titleBar'", TitleBar.class);
        rechargeMiCoinActivity.rlPrice = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rlPrice, "field 'rlPrice'", RecyclerView.class);
        rechargeMiCoinActivity.tvBalance = (TextView) Utils.findRequiredViewAsType(view, R.id.tvBalance, "field 'tvBalance'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, R.id.tvConfirmPayment, "method 'onClick'");
        this.view1c7a = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.setting.RechargeMiCoinActivity_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                rechargeMiCoinActivity.onClick(view);
            }
        });
    }

    public void unbind() {
        RechargeMiCoinActivity rechargeMiCoinActivity = this.target;
        if (rechargeMiCoinActivity != null) {
            this.target = null;
            rechargeMiCoinActivity.titleBar = null;
            rechargeMiCoinActivity.rlPrice = null;
            rechargeMiCoinActivity.tvBalance = null;
            this.view1c7a.setOnClickListener(null);
            this.view1c7a = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
