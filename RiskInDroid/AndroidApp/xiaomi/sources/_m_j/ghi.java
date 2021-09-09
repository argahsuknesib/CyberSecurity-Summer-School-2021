package _m_j;

import _m_j.ghh;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.homeroom.MultiHomeManagerActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import org.json.JSONObject;

public final class ghi extends ghd {
    public View O00000Oo;
    View.OnClickListener O00000o;
    View O00000o0;
    private View O00000oO;
    private TextView O00000oo;
    private TextView O0000O0o;
    private ghh.O000000o O0000OOo;
    private TextView O0000Oo;
    private TextView O0000Oo0;
    private SimpleDraweeView O0000OoO;

    public ghi(View view, ghh.O000000o o000000o) {
        super(view);
        this.O00000oO = view;
        this.O00000oo = (TextView) view.findViewById(R.id.name);
        this.O00000Oo = view.findViewById(R.id.sort_icon);
        this.O00000o0 = view.findViewById(R.id.divider_item);
        this.O0000O0o = (TextView) view.findViewById(R.id.desc);
        this.O0000Oo0 = (TextView) view.findViewById(R.id.tv_accept_btn);
        this.O0000Oo = (TextView) view.findViewById(R.id.tv_expire);
        this.O0000OoO = (SimpleDraweeView) view.findViewById(R.id.icon);
        this.O0000OOo = o000000o;
    }

    public final void O000000o(final ghh ghh, final gha gha) {
        String str;
        boolean z = ghh.O00000oo;
        boolean z2 = ghh.O0000O0o;
        if (gha != null) {
            if (!z) {
                this.O00000Oo.setVisibility(4);
            } else if (z2) {
                this.O00000Oo.setVisibility(0);
            } else {
                this.O00000Oo.setVisibility(4);
            }
            this.O0000O0o.setText(gou.O00000o0(gha.O0000OOo * 1000));
            String string = ghh.f17772O000000o.getResources().getString(R.string.home_member_new_invite_item_title);
            UserInfo O000000o2 = ggg.O000000o().O000000o(gha.O00000oO);
            boolean z3 = true;
            if (O000000o2 != null) {
                gyl.O000000o();
                gyl.O00000Oo(O000000o2.O00000o0, this.O0000OoO, null);
                str = String.format(string, O000000o2.O00000oO, gha.O0000Oo);
            } else {
                gyl.O000000o();
                gyl.O00000Oo(null, this.O0000OoO, null);
                str = String.format(string, String.valueOf(gha.O00000oO), gha.O0000Oo);
            }
            this.O00000oo.setText(str);
            if (System.currentTimeMillis() - (gha.O0000Oo0 * 1000) <= 0) {
                z3 = false;
            }
            int i = 8;
            this.O0000Oo.setVisibility(z3 ? 0 : 8);
            TextView textView = this.O0000Oo0;
            if (!z3) {
                i = 0;
            }
            textView.setVisibility(i);
            this.O0000Oo0.setOnClickListener(new View.OnClickListener() {
                /* class _m_j.ghi.AnonymousClass1 */

                public final void onClick(View view) {
                    if (ghh.f17772O000000o instanceof MultiHomeManagerActivity) {
                        ((MultiHomeManagerActivity) ghh.f17772O000000o).showProgressDialog((String) null);
                    }
                    hxk hxk = hxi.O00000o;
                    long j = gha.O00000oo;
                    hxk.f952O000000o.O000000o("home_management_accept", "home_id", Long.valueOf(j));
                    ggc.O000000o().O000000o(gha, 1, new fsm<JSONObject, fso>() {
                        /* class _m_j.ghi.AnonymousClass1.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                            if (ghh.f17772O000000o instanceof MultiHomeManagerActivity) {
                                ((MultiHomeManagerActivity) ghh.f17772O000000o).contrlProgreassDialog(false, false, 500);
                            }
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (ghh.f17772O000000o instanceof MultiHomeManagerActivity) {
                                ((MultiHomeManagerActivity) ghh.f17772O000000o).setLatestAcceptHomeId(String.valueOf(gha.O00000oo));
                            }
                        }
                    });
                }
            });
            this.O00000oO.setOnLongClickListener(new View.OnLongClickListener(ghh, gha) {
                /* class _m_j.$$Lambda$ghi$VEvkfZm_pM9G8Bj0rreffZvvoo0 */
                private final /* synthetic */ ghh f$1;
                private final /* synthetic */ gha f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final boolean onLongClick(View view) {
                    return ghi.this.O000000o(this.f$1, this.f$2, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean O000000o(final ghh ghh, final gha gha, View view) {
        if (ghh == null || ghh.f17772O000000o == null) {
            return false;
        }
        new MLAlertDialog.Builder(ghh.f17772O000000o).O00000Oo(ghh.f17772O000000o.getString(R.string.home_member_new_invite_reject)).O000000o((int) R.string.tag_remove, new DialogInterface.OnClickListener() {
            /* class _m_j.ghi.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                ggc.O000000o().O000000o(gha, 2, new fsm<JSONObject, fso>() {
                    /* class _m_j.ghi.AnonymousClass2.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        gqg.O00000Oo((int) R.string.toast_failed_retry);
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        ghh.O00000Oo();
                    }
                });
            }
        }).O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null).O00000oo();
        return false;
    }
}
