package com.xiaomi.mico.music.patchwall;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xiaomi.smarthome.R;

public class IntelligentMoreActivity_ViewBinding implements Unbinder {
    private IntelligentMoreActivity target;

    public IntelligentMoreActivity_ViewBinding(IntelligentMoreActivity intelligentMoreActivity) {
        this(intelligentMoreActivity, intelligentMoreActivity.getWindow().getDecorView());
    }

    public IntelligentMoreActivity_ViewBinding(IntelligentMoreActivity intelligentMoreActivity, View view) {
        this.target = intelligentMoreActivity;
        intelligentMoreActivity.titleBarLeftIcon = (ImageView) Utils.findRequiredViewAsType(view, R.id.title_bar_left_icon, "field 'titleBarLeftIcon'", ImageView.class);
        intelligentMoreActivity.titleBarTitle = (TextView) Utils.findRequiredViewAsType(view, R.id.title_bar_title, "field 'titleBarTitle'", TextView.class);
        intelligentMoreActivity.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.linear_recycle_view, "field 'mRecyclerView'", RecyclerView.class);
        intelligentMoreActivity.refreshLayout = (SmartRefreshLayout) Utils.findRequiredViewAsType(view, R.id.refresh_layout, "field 'refreshLayout'", SmartRefreshLayout.class);
    }

    public void unbind() {
        IntelligentMoreActivity intelligentMoreActivity = this.target;
        if (intelligentMoreActivity != null) {
            this.target = null;
            intelligentMoreActivity.titleBarLeftIcon = null;
            intelligentMoreActivity.titleBarTitle = null;
            intelligentMoreActivity.mRecyclerView = null;
            intelligentMoreActivity.refreshLayout = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
