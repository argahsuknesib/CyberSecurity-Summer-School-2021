package com.xiaomi.mico.setting;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.mico.common.widget.TitleBar;
import com.xiaomi.smarthome.R;

public class TransactionRecordActivity_ViewBinding implements Unbinder {
    private TransactionRecordActivity target;

    public TransactionRecordActivity_ViewBinding(TransactionRecordActivity transactionRecordActivity) {
        this(transactionRecordActivity, transactionRecordActivity.getWindow().getDecorView());
    }

    public TransactionRecordActivity_ViewBinding(TransactionRecordActivity transactionRecordActivity, View view) {
        this.target = transactionRecordActivity;
        transactionRecordActivity.titleBar = (TitleBar) Utils.findRequiredViewAsType(view, R.id.title_bar, "field 'titleBar'", TitleBar.class);
        transactionRecordActivity.rlRecord = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.rlRecord, "field 'rlRecord'", RecyclerView.class);
        transactionRecordActivity.refreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'refreshLayout'", SmartRefreshLayout.class);
    }

    public void unbind() {
        TransactionRecordActivity transactionRecordActivity = this.target;
        if (transactionRecordActivity != null) {
            this.target = null;
            transactionRecordActivity.titleBar = null;
            transactionRecordActivity.rlRecord = null;
            transactionRecordActivity.refreshLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
