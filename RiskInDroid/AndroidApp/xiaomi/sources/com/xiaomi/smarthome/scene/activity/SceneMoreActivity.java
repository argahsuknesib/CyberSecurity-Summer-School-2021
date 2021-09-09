package com.xiaomi.smarthome.scene.activity;

import _m_j.eys;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gnp;
import _m_j.gsy;
import _m_j.hah;
import _m_j.hnw;
import _m_j.hob;
import _m_j.hod;
import _m_j.hpq;
import _m_j.hpr;
import _m_j.hrg;
import _m_j.izb;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.utils.ClientRemarkInputView;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;
import com.xiaomi.smarthome.library.common.dialog.XQProgressDialog;
import com.xiaomi.smarthome.scene.api.SceneApi;
import java.util.Iterator;
import org.json.JSONObject;

public class SceneMoreActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final String f10837O000000o = "SceneMoreActivity";
    public boolean isFromPlugin;
    @BindView(5823)
    ImageView ivTitleMore;
    @BindView(5822)
    ImageView ivTitleReturn;
    public String mDid;
    public SceneApi.O000OOOo mScene;
    @BindView(5826)
    TextView tvTitle;
    @BindView(6562)
    View viewAddToHome;
    @BindView(6567)
    View viewDeleteScene;
    @BindView(6569)
    View viewExecuteLocation;
    @BindView(6570)
    View viewExecuteResultNotify;
    @BindView(6576)
    View viewRename;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_scene_more);
        ButterKnife.bind(this);
        String stringExtra = getIntent().getStringExtra("extra_scene_id");
        boolean z = true;
        if (getIntent().getIntExtra("from", 0) != 1) {
            z = false;
        }
        this.isFromPlugin = z;
        this.mDid = getIntent().getStringExtra("extra_device_id");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.equals("0", stringExtra)) {
            gsy.O000000o(6, f10837O000000o, "sceneId <= 0");
            finish();
            return;
        }
        if (getIntent().getBooleanExtra("extra_is_lite", false)) {
            this.mScene = hpr.O00000o0().O000000o(stringExtra);
        } else {
            this.mScene = hod.O0000OoO().O00000Oo(stringExtra);
        }
        if (this.mScene == null) {
            gsy.O000000o(6, f10837O000000o, "mScene is null");
            finish();
            return;
        }
        this.ivTitleReturn.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass1 */

            public final void onClick(View view) {
                SceneMoreActivity.this.finish();
            }
        });
        this.tvTitle.setText((int) R.string.scene2_more);
        this.ivTitleMore.setVisibility(8);
        ((TextView) this.viewRename.findViewById(R.id.tv_name)).setText((int) R.string.scene2_rename);
        ((TextView) this.viewRename.findViewById(R.id.tv_content)).setText(this.mScene.O00000Oo);
        this.viewRename.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass2 */

            public final void onClick(View view) {
                SceneMoreActivity sceneMoreActivity = SceneMoreActivity.this;
                sceneMoreActivity.showModifyBackNameView(sceneMoreActivity.mScene);
            }
        });
        ((TextView) this.viewExecuteResultNotify.findViewById(R.id.tv_name)).setText((int) R.string.scene2_execute_result_notify);
        ((TextView) this.viewExecuteResultNotify.findViewById(R.id.tv_content)).setText(this.mScene.O0000Oo ? R.string.scene2_open : R.string.scene2_close);
        this.viewExecuteResultNotify.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass4 */

            public final void onClick(View view) {
                SceneMoreActivity.this.showExecuteResultNotityMenu();
            }
        });
        ((TextView) this.viewExecuteLocation.findViewById(R.id.tv_name)).setText((int) R.string.scene_execute_location);
        TextView textView = (TextView) this.viewExecuteLocation.findViewById(R.id.tv_content);
        textView.setCompoundDrawables(null, null, null, null);
        textView.setText(this.mScene.O0000o == 0 ? R.string.scene_locale_cloud : R.string.scene_locale_local);
        TextView textView2 = (TextView) this.viewAddToHome.findViewById(R.id.tv_name);
        if (hnw.O00000Oo(this.mScene)) {
            this.viewAddToHome.setVisibility(0);
        } else {
            this.viewAddToHome.setVisibility(8);
        }
        textView2.setText((int) R.string.scene2_add_to_home);
        this.viewAddToHome.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass6 */

            public final void onClick(View view) {
                SceneMoreActivity sceneMoreActivity = SceneMoreActivity.this;
                hnw.O000000o(sceneMoreActivity, sceneMoreActivity.mScene, hnw.O00000Oo(SceneMoreActivity.this.mScene.O00000o));
            }
        });
        ((TextView) this.viewDeleteScene.findViewById(R.id.tv_name)).setText((int) R.string.scene2_delete);
        this.viewDeleteScene.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.$$Lambda$SceneMoreActivity$V3VVSMzUK9PyJn6JbwzDEkpzCk8 */

            public final void onClick(View view) {
                SceneMoreActivity.this.O000000o(view);
            }
        });
    }

    public void showModifyBackNameView(final SceneApi.O000OOOo o000OOOo) {
        String str = TextUtils.isEmpty(o000OOOo.O00000Oo) ? "" : o000OOOo.O00000Oo;
        hah.O000000o(this, -1, str, getString(R.string.scene2_rename), str, hpq.f480O000000o, new hah.O00000Oo() {
            /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass3 */

            public final void O000000o(String str) {
            }

            public final String O00000Oo(String str) {
                if (TextUtils.equals(o000OOOo.O00000Oo, str)) {
                    return SceneMoreActivity.this.getString(R.string.smarthome_scene_reset_name);
                }
                for (SceneApi.O000OOOo next : hod.O0000OoO().O00000o0) {
                    if (!TextUtils.equals(next.f11131O000000o, o000OOOo.f11131O000000o) && TextUtils.equals(next.O00000Oo, str)) {
                        return SceneMoreActivity.this.getString(R.string.scene_modify_name_error);
                    }
                }
                for (SceneApi.O000OOOo next2 : hpr.O00000o0().O0000O0o) {
                    if (!TextUtils.equals(next2.f11131O000000o, o000OOOo.f11131O000000o) && TextUtils.equals(next2.O00000Oo, str)) {
                        return SceneMoreActivity.this.getString(R.string.scene_modify_name_error);
                    }
                }
                return "";
            }

            public final void O000000o(ClientRemarkInputView clientRemarkInputView, String str) {
                final XQProgressDialog xQProgressDialog = new XQProgressDialog(SceneMoreActivity.this);
                xQProgressDialog.setMessage(SceneMoreActivity.this.getString(R.string.changeing_back_name));
                xQProgressDialog.setCancelable(false);
                xQProgressDialog.show();
                final String str2 = o000OOOo.O00000Oo;
                o000OOOo.O00000Oo = str;
                if (!TextUtils.isEmpty(str) && !o000OOOo.O00000oo.isEmpty()) {
                    Iterator<SceneApi.Action> it = o000OOOo.O00000oo.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        SceneApi.Action next = it.next();
                        if (next.O0000O0o != null && (next.O0000O0o instanceof SceneApi.O000OO)) {
                            ((SceneApi.O000OO) next.O0000O0o).O00000Oo = str;
                            break;
                        }
                    }
                }
                if (eys.f15955O000000o) {
                    hob.O000000o().O000000o(o000OOOo, new fsm<Void, fso>() {
                        /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass3.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                            if (SceneMoreActivity.this.isValid()) {
                                if (fso == null || fso.f17063O000000o != -1) {
                                    izb.O000000o(SceneMoreActivity.this, (int) R.string.change_back_name_fail, 0).show();
                                } else {
                                    izb.O000000o(SceneMoreActivity.this, (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                                }
                                xQProgressDialog.dismiss();
                                SceneApi.O000OOOo o000OOOo = o000OOOo;
                                String str = str2;
                                o000OOOo.O00000Oo = str;
                                if (!TextUtils.isEmpty(str) && !o000OOOo.O00000oo.isEmpty()) {
                                    for (SceneApi.Action next : o000OOOo.O00000oo) {
                                        if (next.O0000O0o != null && (next.O0000O0o instanceof SceneApi.O000OO)) {
                                            ((SceneApi.O000OO) next.O0000O0o).O00000Oo = str2;
                                            return;
                                        }
                                    }
                                }
                            }
                        }

                        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                         method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
                         arg types: [java.lang.String, int]
                         candidates:
                          ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
                          ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
                        public final /* synthetic */ void onSuccess(Object obj) {
                            if (SceneMoreActivity.this.isValid()) {
                                SmarthomeCreateAutoSceneActivity.notifyPlugin(SceneMoreActivity.this, SceneMoreActivity.this.isFromPlugin, SceneMoreActivity.this.mScene, SceneMoreActivity.this.mDid);
                                xQProgressDialog.dismiss();
                                ((TextView) SceneMoreActivity.this.viewRename.findViewById(R.id.tv_content)).setText(SceneMoreActivity.this.mScene.O00000Oo);
                                if (SceneMoreActivity.this.mScene.O0000oO0) {
                                    hpr.O00000o0().O00000Oo();
                                    hpr.O00000o0().O000000o(o000OOOo.f11131O000000o, o000OOOo);
                                } else {
                                    hod.O0000OoO().O00000o();
                                    hod.O0000OoO().O000000o(o000OOOo.f11131O000000o, o000OOOo);
                                }
                                Intent intent = new Intent();
                                intent.putExtra("scene_remaned", true);
                                SceneMoreActivity.this.setResult(-1, intent);
                            }
                        }
                    });
                }
            }
        });
    }

    public void showExecuteResultNotityMenu() {
        String[] strArr = {getString(R.string.scene2_open), getString(R.string.scene2_close)};
        final boolean z = this.mScene.O0000Oo;
        MLAlertDialog O00000o = new MLAlertDialog.Builder(this).O00000o0().O000000o(strArr, this.mScene.O0000Oo ^ true ? 1 : 0, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                SceneMoreActivity.this.mScene.O0000Oo = i == 0;
                dialogInterface.dismiss();
                final XQProgressDialog xQProgressDialog = new XQProgressDialog(SceneMoreActivity.this);
                xQProgressDialog.setMessage(SceneMoreActivity.this.getString(R.string.retrieving_data));
                xQProgressDialog.setCancelable(false);
                xQProgressDialog.show();
                hob.O000000o().O000000o(SceneMoreActivity.this.mScene, new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass5.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        if (fso == null || fso.f17063O000000o != -1) {
                            izb.O000000o(SceneMoreActivity.this, (int) R.string.upgrading_error, 0).show();
                        } else {
                            izb.O000000o(SceneMoreActivity.this, (int) R.string.smarthome_scene_has_deleted_device, 0).show();
                        }
                        xQProgressDialog.dismiss();
                        SceneMoreActivity.this.mScene.O0000Oo = z;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        xQProgressDialog.dismiss();
                        ((TextView) SceneMoreActivity.this.viewExecuteResultNotify.findViewById(R.id.tv_content)).setText(SceneMoreActivity.this.mScene.O0000Oo ? R.string.scene2_open : R.string.scene2_close);
                    }
                });
            }
        }).O00000o();
        O00000o.show();
        gnp.O000000o(O00000o.getContext(), O00000o);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        hrg.O000000o(this, getString(R.string.scene_confirm_delete), getString(R.string.sh_common_cancel), getString(R.string.confirm), new View.OnClickListener() {
            /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass7 */

            public final void onClick(View view) {
                hob O000000o2 = hob.O000000o();
                SceneMoreActivity sceneMoreActivity = SceneMoreActivity.this;
                O000000o2.O00000Oo(sceneMoreActivity, sceneMoreActivity.mScene.f11131O000000o, new fsm<JSONObject, fso>() {
                    /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass7.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                        if (SceneMoreActivity.this.isValid()) {
                            izb.O000000o(SceneMoreActivity.this, (int) R.string.smarthome_scene_delete_fail, 0).show();
                        }
                    }

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
                     arg types: [java.lang.String, int]
                     candidates:
                      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
                      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
                    public final /* synthetic */ void onSuccess(Object obj) {
                        if (SceneMoreActivity.this.mScene.O0000oO0) {
                            hpr.O00000o0().O00000Oo(SceneMoreActivity.this.mScene.f11131O000000o);
                            hpr.O00000o0().O000000o(new fsm() {
                                /* class com.xiaomi.smarthome.scene.activity.SceneMoreActivity.AnonymousClass7.AnonymousClass1.AnonymousClass1 */

                                public final void onFailure(fso fso) {
                                }

                                public final void onSuccess(Object obj) {
                                    hpr.O00000o0().O00000Oo();
                                    SmarthomeCreateAutoSceneActivity.notifyPlugin(SceneMoreActivity.this, SceneMoreActivity.this.isFromPlugin, SceneMoreActivity.this.mScene, SceneMoreActivity.this.mDid);
                                }
                            });
                        } else {
                            hod.O0000OoO().O00000o0(SceneMoreActivity.this.mScene.f11131O000000o);
                            hod.O0000OoO().O00000o();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("scene_deleted", true);
                        SceneMoreActivity.this.setResult(-1, intent);
                        SceneMoreActivity.this.finish();
                    }
                });
            }
        });
    }
}
