package com.xiaomi.mico.music.detail;

import android.os.Bundle;
import android.view.View;
import com.xiaomi.mico.api.ApiRequest;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.application.AppCapability;
import com.xiaomi.mico.music.MusicHelper;
import com.xiaomi.mico.music.adapter.LovableAdapter;
import java.io.Serializable;

public abstract class SongListActivity extends BaseDetailActivity<Music.Song> implements LovableAdapter.Lovable {
    protected ApiRequest apiRequest;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        loadQQVIPStatus();
    }

    public void onDestroy() {
        super.onDestroy();
        ApiRequest apiRequest2 = this.apiRequest;
        if (apiRequest2 != null) {
            apiRequest2.cancel();
            this.apiRequest = null;
        }
    }

    /* access modifiers changed from: protected */
    public LovableAdapter.Lovable getLovable() {
        if (!AppCapability.hasCapabilitySongCollection()) {
            return null;
        }
        return this;
    }

    public void onLove(View view, Serializable serializable) {
        if (serializable instanceof Music.Song) {
            MusicHelper.addToChannel(getContext(), (Music.Song) serializable);
        }
    }

    /* access modifiers changed from: protected */
    public void loadQQVIPStatus() {
        if (this.tabView != null) {
            this.tabView.updateOpenVipViewVisibility();
        }
    }
}
