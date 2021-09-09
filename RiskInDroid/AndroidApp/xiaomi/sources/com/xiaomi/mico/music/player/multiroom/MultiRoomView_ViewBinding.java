package com.xiaomi.mico.music.player.multiroom;

import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xiaomi.smarthome.R;
import com.xiasuhuei321.loadingdialog.view.LoadCircleView;

public class MultiRoomView_ViewBinding implements Unbinder {
    private MultiRoomView target;
    private View view1747;
    private View view1a49;

    public MultiRoomView_ViewBinding(MultiRoomView multiRoomView) {
        this(multiRoomView, multiRoomView);
    }

    public MultiRoomView_ViewBinding(final MultiRoomView multiRoomView, View view) {
        this.target = multiRoomView;
        View findRequiredView = Utils.findRequiredView(view, R.id.ok_btn, "field 'okBtn' and method 'onClick'");
        multiRoomView.okBtn = (Button) Utils.castView(findRequiredView, R.id.ok_btn, "field 'okBtn'", Button.class);
        this.view1a49 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.multiroom.MultiRoomView_ViewBinding.AnonymousClass1 */

            public void doClick(View view) {
                multiRoomView.onClick(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, R.id.cancel_btn, "field 'cancelBtn' and method 'onClick'");
        multiRoomView.cancelBtn = (Button) Utils.castView(findRequiredView2, R.id.cancel_btn, "field 'cancelBtn'", Button.class);
        this.view1747 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            /* class com.xiaomi.mico.music.player.multiroom.MultiRoomView_ViewBinding.AnonymousClass2 */

            public void doClick(View view) {
                multiRoomView.onClick(view);
            }
        });
        multiRoomView.mRecyclerView = (RecyclerView) Utils.findRequiredViewAsType(view, R.id.multi_room_device_rv, "field 'mRecyclerView'", RecyclerView.class);
        multiRoomView.mLoading = (LoadCircleView) Utils.findRequiredViewAsType(view, R.id.multi_room_loading_iv, "field 'mLoading'", LoadCircleView.class);
    }

    public void unbind() {
        MultiRoomView multiRoomView = this.target;
        if (multiRoomView != null) {
            this.target = null;
            multiRoomView.okBtn = null;
            multiRoomView.cancelBtn = null;
            multiRoomView.mRecyclerView = null;
            multiRoomView.mLoading = null;
            this.view1a49.setOnClickListener(null);
            this.view1a49 = null;
            this.view1747.setOnClickListener(null);
            this.view1747 = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
