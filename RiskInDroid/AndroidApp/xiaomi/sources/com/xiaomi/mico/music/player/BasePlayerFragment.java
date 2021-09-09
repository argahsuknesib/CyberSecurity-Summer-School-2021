package com.xiaomi.mico.music.player;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.xiaomi.mico.base.MicoBaseFragment;

public class BasePlayerFragment extends MicoBaseFragment {
    private OnViewCreatedCallback mOnViewCreatedCallback;

    interface OnViewCreatedCallback {
        void onViewCreated(Fragment fragment);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnViewCreatedCallback) {
            this.mOnViewCreatedCallback = (OnViewCreatedCallback) context;
            return;
        }
        throw new IllegalStateException("BasePlayerFragment's host activity must implement OnViewCreatedCallback.");
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.mOnViewCreatedCallback.onViewCreated(this);
    }
}
