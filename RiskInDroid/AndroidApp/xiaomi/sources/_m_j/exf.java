package _m_j;

import android.os.Handler;
import android.os.Message;
import com.xiaomi.shopviews.model.HomeSectionItem;

public final class exf {

    /* renamed from: O000000o  reason: collision with root package name */
    private Handler f15915O000000o = new Handler() {
        /* class _m_j.exf.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                exf.this.O000000o((HomeSectionItem) message.obj, true);
            }
        }
    };
    private O000000o O00000Oo;

    public interface O000000o {
    }

    private static Message O000000o(HomeSectionItem homeSectionItem) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = homeSectionItem;
        return obtain;
    }

    public final void O000000o() {
        this.f15915O000000o.removeCallbacksAndMessages(null);
    }

    public final void O000000o(HomeSectionItem homeSectionItem, boolean z) {
        long O000000o2 = dur.O000000o(homeSectionItem.mServerTime * 1000);
        long j = homeSectionItem.mStartTime * 1000;
        long j2 = homeSectionItem.mEndTime * 1000;
        long O000000o3 = (long) dur.O000000o(j, O000000o2);
        if (O000000o3 > 1) {
            if (z) {
                this.f15915O000000o.sendMessageDelayed(O000000o(homeSectionItem), dur.O00000Oo(O000000o2));
            }
            O000000o o000000o = this.O00000Oo;
        } else if (O000000o3 == 1 && z) {
            this.f15915O000000o.sendMessageDelayed(O000000o(homeSectionItem), dur.O00000Oo(O000000o2));
        }
        long j3 = j - 1800000;
        if (O000000o2 >= j3) {
            if (O000000o2 >= j3) {
                long j4 = j - 900000;
                if (O000000o2 < j4) {
                    if (z) {
                        this.f15915O000000o.sendMessageDelayed(O000000o(homeSectionItem), j4 - O000000o2);
                        return;
                    }
                    return;
                }
            }
            if (O000000o2 >= j || O000000o2 < j - 900000) {
                if (O000000o2 >= j && O000000o2 < j2 && z) {
                    this.f15915O000000o.sendMessageDelayed(O000000o(homeSectionItem), j2 - O000000o2);
                }
            } else if (z) {
                this.f15915O000000o.sendMessageDelayed(O000000o(homeSectionItem), j - O000000o2);
            }
        } else if (z) {
            this.f15915O000000o.sendMessageDelayed(O000000o(homeSectionItem), j3 - O000000o2);
        }
    }
}
