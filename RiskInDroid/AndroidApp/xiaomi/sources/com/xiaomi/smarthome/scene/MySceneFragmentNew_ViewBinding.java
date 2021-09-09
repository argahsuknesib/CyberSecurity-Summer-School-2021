package com.xiaomi.smarthome.scene;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;

public class MySceneFragmentNew_ViewBinding implements Unbinder {

    /* renamed from: O000000o  reason: collision with root package name */
    private MySceneFragmentNew f10586O000000o;

    public MySceneFragmentNew_ViewBinding(MySceneFragmentNew mySceneFragmentNew, View view) {
        this.f10586O000000o = mySceneFragmentNew;
        mySceneFragmentNew.mEmptyView = Utils.findRequiredView(view, R.id.common_white_empty_view, "field 'mEmptyView'");
        mySceneFragmentNew.mShareHomeView = Utils.findRequiredView(view, R.id.view_other_home, "field 'mShareHomeView'");
        mySceneFragmentNew.mSceneViewRV = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.scene_rv, "field 'mSceneViewRV'", RecyclerView.class);
        mySceneFragmentNew.mEmptyTV = (TextView) Utils.findRequiredViewAsType(view, R.id.common_white_empty_text, "field 'mEmptyTV'", TextView.class);
        mySceneFragmentNew.mPlaceHolderView = Utils.findRequiredView(view, R.id.place_holder, "field 'mPlaceHolderView'");
    }

    public void unbind() {
        MySceneFragmentNew mySceneFragmentNew = this.f10586O000000o;
        if (mySceneFragmentNew != null) {
            this.f10586O000000o = null;
            mySceneFragmentNew.mEmptyView = null;
            mySceneFragmentNew.mShareHomeView = null;
            mySceneFragmentNew.mSceneViewRV = null;
            mySceneFragmentNew.mEmptyTV = null;
            mySceneFragmentNew.mPlaceHolderView = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
