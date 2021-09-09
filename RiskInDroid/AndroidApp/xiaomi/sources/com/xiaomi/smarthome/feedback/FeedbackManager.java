package com.xiaomi.smarthome.feedback;

import _m_j.fsi;
import _m_j.fsm;
import _m_j.fso;
import android.content.Context;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.DeviceFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public enum FeedbackManager {
    INSTANCE;
    
    public int currentPage = 0;
    public ArrayList<fsi.O000000o> feedbackLists = new ArrayList<>();
    public boolean isLoadingHistory = false;
    public final Byte[] obj = new Byte[0];
    public int pageCount = 0;

    public final List<fsi.O000000o> getFeedbackHistory() {
        return this.feedbackLists;
    }

    public final String getFeedbackDeviceName(Context context, String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        if (str.equalsIgnoreCase("exp")) {
            return context.getString(R.string.feedback_app_experience);
        }
        if (str.equalsIgnoreCase("shop")) {
            return context.getString(R.string.feedback_eshop);
        }
        if (str.equalsIgnoreCase("account")) {
            return context.getString(R.string.feedback_account);
        }
        if (str.equalsIgnoreCase("other")) {
            return context.getString(R.string.feedback_other);
        }
        if (str.equalsIgnoreCase("automation")) {
            return context.getString(R.string.feedback_auto_scene);
        }
        if (str.equalsIgnoreCase("blegateway")) {
            return context.getString(R.string.ble_gateway_switch_text);
        }
        return DeviceFactory.O0000OoO(str);
    }

    public final void loadFeedbackHistory(Context context, fsm<List<fsi.O000000o>, fso> fsm) {
        synchronized (this.obj) {
            this.isLoadingHistory = true;
            this.pageCount = 0;
            this.currentPage = 0;
            this.feedbackLists.clear();
        }
        loadMoreFeedbackHistory(context, fsm);
    }

    public final void loadMoreFeedbackHistory(Context context, final fsm<List<fsi.O000000o>, fso> fsm) {
        int i = this.currentPage + 1;
        synchronized (this.obj) {
            this.isLoadingHistory = true;
        }
        loadFeedbackHistory(context, i, 10, new fsm<fsi, fso>() {
            /* class com.xiaomi.smarthome.feedback.FeedbackManager.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                fsi fsi = (fsi) obj;
                synchronized (FeedbackManager.this.obj) {
                    FeedbackManager.this.currentPage = fsi.f17053O000000o;
                    FeedbackManager.this.pageCount = fsi.O00000Oo;
                    FeedbackManager.this.feedbackLists.addAll(fsi.O00000o0);
                    FeedbackManager.this.isLoadingHistory = false;
                }
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(FeedbackManager.this.feedbackLists);
                }
            }

            public final void onFailure(fso fso) {
                synchronized (FeedbackManager.this.obj) {
                    FeedbackManager.this.isLoadingHistory = false;
                }
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
    }

    public final boolean isLoadingHistory() {
        return this.isLoadingHistory;
    }

    public final boolean isAllLoaded() {
        return this.currentPage == this.pageCount;
    }

    public final fsi.O000000o getFeedbackItem(String str) {
        if (!(this.feedbackLists == null || str == null || str.isEmpty())) {
            Iterator<fsi.O000000o> it = this.feedbackLists.iterator();
            while (it.hasNext()) {
                fsi.O000000o next = it.next();
                if (next.f17054O000000o.equalsIgnoreCase(str)) {
                    return next;
                }
            }
        }
        return null;
    }

    private void loadFeedbackHistory(Context context, int i, int i2, fsm<fsi, fso> fsm) {
        FeedbackApi.INSTANCE.getFeedbackList(context, i, i2, fsm);
    }
}
