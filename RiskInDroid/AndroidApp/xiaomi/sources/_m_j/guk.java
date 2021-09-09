package _m_j;

import _m_j.ggb;
import _m_j.ggg;
import android.app.Activity;
import android.text.TextUtils;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.framework.redpoint.ServerTimerManager;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.miio.db.record.MessageRecord;
import java.util.HashSet;
import org.json.JSONObject;

public final class guk extends gum {

    public static class O000000o extends gul {

        /* renamed from: O000000o  reason: collision with root package name */
        public long f18300O000000o;
        long O00000Oo;
        private long O00000o;
        private long O00000o0;
        private String O00000oO;
        private int O0000OOo;

        public O000000o(MessageRecord messageRecord, long j, long j2, long j3, long j4, String str, int i) {
            this.O00000oo = messageRecord;
            this.f18300O000000o = j;
            this.O00000Oo = j2;
            this.O00000o0 = j3;
            this.O00000o = j4;
            this.O00000oO = str;
            this.O0000OOo = i;
        }

        public final long O000000o() {
            return this.O00000oo.receiveTime;
        }

        public final void O000000o(SimpleDraweeView simpleDraweeView) {
            if (!TextUtils.isEmpty(this.O00000oo.img_url)) {
                gyl.O000000o();
                gyl.O00000Oo(this.O00000oo.img_url, simpleDraweeView, new gnz(simpleDraweeView.getResources().getColor(R.color.mj_color_black_30_transparent)));
                return;
            }
            final long O00000oO2 = O00000oO();
            if (O00000oO2 == 0) {
                gsy.O00000Oo("HomeShareMessage", "setMainIcon not valid uid:0");
                return;
            }
            final UserInfo O000000o2 = ggg.O000000o().O000000o(O00000oO2);
            if (O000000o2 != null) {
                gyl.O000000o();
                gyl.O00000Oo(O000000o2.O00000o0, simpleDraweeView, new gnz(simpleDraweeView.getResources().getColor(R.color.mj_color_black_30_transparent)));
                return;
            }
            simpleDraweeView.setTag(R.id.cb_item_tag, Long.valueOf(O00000oO2));
            HashSet hashSet = new HashSet();
            hashSet.add(Long.valueOf(O00000oO2));
            final SimpleDraweeView simpleDraweeView2 = simpleDraweeView;
            ggg.O000000o().O000000o(hashSet, new ggg.O000000o() {
                /* class _m_j.guk.O000000o.AnonymousClass1 */

                public final void O000000o() {
                    Object tag = simpleDraweeView2.getTag(R.id.cb_item_tag);
                    if (tag != null && (tag instanceof Long) && tag.equals(Long.valueOf(O00000oO2))) {
                        gyl.O000000o();
                        String str = O000000o2.O00000o0;
                        SimpleDraweeView simpleDraweeView = simpleDraweeView2;
                        gyl.O00000Oo(str, simpleDraweeView, new gnz(simpleDraweeView.getResources().getColor(R.color.mj_color_black_30_transparent)));
                    }
                }
            });
        }

        public final long O00000oO() {
            if (TextUtils.equals(this.O00000oO, "invite_request")) {
                return this.O00000Oo;
            }
            if (TextUtils.equals(this.O00000oO, "invite_tips")) {
                return this.O00000o0;
            }
            return 0;
        }

        public final void O000000o(TextView textView) {
            if (!O00000o(textView)) {
                textView.setText(this.O00000oo.title);
            }
        }

        public final void O00000oO(TextView textView) {
            textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000) + " " + this.O00000oo.title);
        }

        public final void O00000Oo(TextView textView) {
            textView.setText(gou.O000000o(this.O00000oo.receiveTime * 1000));
        }

        public final void O00000o0(TextView textView) {
            int i;
            if (O00000Oo() || !TextUtils.equals(this.O00000oO, "invite_request")) {
                if (!O00000Oo()) {
                    TextUtils.equals(this.O00000oO, "invite_tips");
                }
                textView.setVisibility(8);
                return;
            }
            int i2 = this.O0000OOo;
            if (i2 == 1) {
                i = R.string.smarthome_share_accepted;
            } else if (i2 == 2) {
                i = R.string.smarthome_share_rejected;
            } else if (i2 != 0) {
                i = 0;
            } else if (O00000oo()) {
                i = R.string.smarthome_share_expired;
            } else {
                i = R.string.smarthome_to_user_status_waiting;
                textView.setTextColor(textView.getResources().getColor(R.color.mj_color_class_text_36));
            }
            textView.setText(i);
        }

        public final boolean O00000Oo() {
            if (TextUtils.equals(this.O00000oO, "invite_request") && this.O0000OOo == 0 && !O00000oo()) {
                return true;
            }
            return false;
        }

        public final boolean O00000oo() {
            return this.O00000o * 1000 < System.currentTimeMillis() + ServerTimerManager.O000000o(ServiceApplication.getAppContext()).O00000Oo();
        }

        public final void O000000o(final XQProgressDialog xQProgressDialog) {
            hxi.O00000o.f952O000000o.O000000o("messagecenter_homeshare_accept", new Object[0]);
            fru.O000000o().O000000o(this.O00000Oo, this.f18300O000000o, 1, new fsm<JSONObject, fso>() {
                /* class _m_j.guk.O000000o.AnonymousClass2 */

                public final void onFailure(fso fso) {
                    xQProgressDialog.dismiss();
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    ggb.O00000Oo().O000000o(new ggb.O0000OOo() {
                        /* class _m_j.guk.O000000o.AnonymousClass2.AnonymousClass1 */

                        public final void O000000o() {
                            ServiceApplication.getGlobalHandler().postDelayed(new Runnable() {
                                /* class _m_j.guk.O000000o.AnonymousClass2.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    xQProgressDialog.dismiss();
                                }
                            }, 3000);
                        }
                    });
                }
            });
        }

        public final void O000000o(Activity activity) {
            guq.O000000o(O00000o0());
        }

        public final String O00000o0() {
            if (this.O00000oo == null) {
                return null;
            }
            return this.O00000oo.msgId;
        }
    }

    public final gul O000000o(MessageRecord messageRecord) {
        try {
            JSONObject jSONObject = new JSONObject(messageRecord.params);
            return new O000000o(messageRecord, jSONObject.optLong("home_id", 0), jSONObject.optLong("home_owner", 0), jSONObject.optLong("share_to", 0), jSONObject.optLong("expire", 0), jSONObject.optString("type", ""), jSONObject.optInt("status", 0));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
