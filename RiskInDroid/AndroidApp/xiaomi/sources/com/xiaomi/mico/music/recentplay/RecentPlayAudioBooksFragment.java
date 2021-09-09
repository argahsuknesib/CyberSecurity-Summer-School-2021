package com.xiaomi.mico.music.recentplay;

import _m_j.gsy;
import android.os.Bundle;
import com.xiaomi.mico.api.RecentPlayApiHelper;
import com.xiaomi.mico.api.model.Music;
import com.xiaomi.mico.common.editorbar.ActionMenu;
import com.xiaomi.mico.music.favourite.BasePersonalFragment;
import java.util.List;
import rx.Observable;

public class RecentPlayAudioBooksFragment extends BasePersonalFragment<Music.Station> {
    private String pageType;

    public int getFavType() {
        return 4;
    }

    public ActionMenu.MenuCallback getMenuCallback() {
        return null;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            this.pageType = (String) getArguments().get("PAGE_TYPE");
        }
    }

    public Observable<List<Music.Station>> getListObservable() {
        return RecentPlayApiHelper.getRecentPlayAudioBookObservable("all");
    }

    public String getStationType() {
        return this.pageType;
    }

    public void handleFetchFailed() {
        super.handleFetchFailed();
        gsy.O00000Oo(12000, "12000.4.2", "remote audio fail");
    }
}
