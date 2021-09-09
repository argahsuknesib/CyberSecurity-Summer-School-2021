package com.xiaomi.mico.music.patchwall.group;

import _m_j.axs;
import _m_j.axz;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.mico.api.model.IntelligentModel;
import com.xiaomi.mico.application.MicoApplication;
import com.xiaomi.mico.common.util.DisplayUtils;
import java.util.List;

public abstract class IntelligentBaseViewHolder extends axz implements axs {
    public final int borderRadius = DisplayUtils.dip2px(this.mRootView.getContext(), 12.0f);
    private int mExpandStateFlags;
    public onItemClickListener mItemClickListener;
    View mRootView;

    public interface onItemClickListener {
        void onItemClicked(int i);
    }

    public abstract void bindView(List<IntelligentModel.ListBean.CardsBean> list, RecyclerView.O000000o o000000o);

    public IntelligentBaseViewHolder(View view) {
        super(view);
        this.mRootView = view;
    }

    public int getExpandStateFlags() {
        return this.mExpandStateFlags;
    }

    public void setExpandStateFlags(int i) {
        this.mExpandStateFlags = i;
    }

    public View getSwipeableContainerView() {
        return this.mRootView;
    }

    public void onClickView(String str) {
        MicoApplication.getInstance().getMicoHelperListener().jumpSmartHome(str, "");
    }

    public void setOnItemClickListener(onItemClickListener onitemclicklistener) {
        this.mItemClickListener = onitemclicklistener;
    }
}
