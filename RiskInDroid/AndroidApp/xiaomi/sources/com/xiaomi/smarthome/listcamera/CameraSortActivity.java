package com.xiaomi.smarthome.listcamera;

import _m_j.awq;
import _m_j.axc;
import _m_j.axl;
import _m_j.axx;
import _m_j.aye;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gkv;
import _m_j.gti;
import _m_j.gtl;
import _m_j.izb;
import android.content.DialogInterface;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.framework.page.BaseActivity;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public class CameraSortActivity extends BaseActivity {

    /* renamed from: O000000o  reason: collision with root package name */
    ImageView f9406O000000o;
    ImageView O00000Oo;
    private RecyclerView.O000000o O00000o;
    RecyclerView O00000o0;
    private axl O00000oO;
    private axx O00000oo;
    private LinearLayoutManager O0000O0o;
    public gtl mAdapter;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.client_all_device_sort);
        ((TextView) findViewById(R.id.module_a_4_return_more_title)).setText((int) R.string.menu_edit_sort);
        this.O00000Oo = (ImageView) findViewById(R.id.module_a_4_return_more_btn);
        this.O00000Oo.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.listcamera.CameraSortActivity.AnonymousClass1 */

            public final void onClick(View view) {
                CameraSortActivity.this.finish();
                CameraSortActivity.this.overridePendingTransition(0, 0);
            }
        });
        this.f9406O000000o = (ImageView) findViewById(R.id.module_a_4_return_finish_btn);
        this.f9406O000000o.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.listcamera.CameraSortActivity.AnonymousClass2 */

            public final void onClick(View view) {
                gti.O000000o().O000000o(CameraSortActivity.this.mAdapter.O00000Oo);
                gti.O000000o().O000000o(new fsm<Void, fso>() {
                    /* class com.xiaomi.smarthome.listcamera.CameraSortActivity.AnonymousClass2.AnonymousClass1 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        izb.O000000o(gkv.f17949O000000o, (int) R.string.toast_sort_succeed, 1).show();
                        CameraSortActivity.this.finish();
                    }
                });
            }
        });
        this.O00000o0 = (RecyclerView) findViewById(R.id.device_grid_view);
        this.O00000o0.setOverScrollMode(2);
    }

    public void onResume() {
        super.onResume();
        if (this.O00000o == null) {
            resetAdapter();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onBackPressed() {
        if (!this.f9406O000000o.isEnabled()) {
            super.onBackPressed();
            return;
        }
        MLAlertDialog.Builder builder = new MLAlertDialog.Builder(this);
        builder.O000000o((int) R.string.dialog_title_save_sort);
        builder.O000000o((int) R.string.quit, new DialogInterface.OnClickListener() {
            /* class com.xiaomi.smarthome.listcamera.CameraSortActivity.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i) {
                CameraSortActivity.this.finish();
            }
        });
        builder.O00000Oo((int) R.string.sh_common_cancel, (DialogInterface.OnClickListener) null);
        builder.O00000o().show();
    }

    public void onDestroy() {
        super.onDestroy();
        clearAdapter();
    }

    public void clearAdapter() {
        axl axl = this.O00000oO;
        if (axl != null) {
            axl.O000000o(true);
            if (axl.O0000ooo != null) {
                axl.O000000o o000000o = axl.O0000ooo;
                o000000o.removeCallbacks(null);
                o000000o.f12686O000000o = null;
                axl.O0000ooo = null;
            }
            if (axl.O0000OOo != null) {
                axc axc = axl.O0000OOo;
                if (axc.O00000o) {
                    axc.f12677O000000o.removeItemDecoration(axc);
                }
                axc.O00000Oo();
                axc.f12677O000000o = null;
                axc.O00000o = false;
                axl.O0000OOo = null;
            }
            if (!(axl.O00000o0 == null || axl.O00000oo == null)) {
                axl.O00000o0.removeOnItemTouchListener(axl.O00000oo);
            }
            axl.O00000oo = null;
            if (!(axl.O00000o0 == null || axl.O0000O0o == null)) {
                axl.O00000o0.removeOnScrollListener(axl.O0000O0o);
            }
            axl.O0000O0o = null;
            if (axl.O00000oO != null) {
                axl.O00000o0 o00000o0 = axl.O00000oO;
                o00000o0.f12688O000000o.clear();
                o00000o0.O00000Oo = false;
                axl.O00000oO = null;
            }
            axl.O0000oOO = null;
            axl.O00000o0 = null;
            axl.O00000o = null;
            this.O00000oO = null;
        }
        axx axx = this.O00000oo;
        if (axx != null) {
            if (!(axx.O00000Oo == null || axx.f12691O000000o == null)) {
                axx.O00000Oo.removeOnItemTouchListener(axx.f12691O000000o);
            }
            axx.f12691O000000o = null;
            axx.O00000Oo = null;
            this.O00000oo = null;
        }
        RecyclerView recyclerView = this.O00000o0;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(null);
            this.O00000o0.setAdapter(null);
        }
        RecyclerView.O000000o o000000o2 = this.O00000o;
        if (o000000o2 != null) {
            aye.O000000o(o000000o2);
            this.O00000o = null;
        }
        gtl gtl = this.mAdapter;
        if (gtl != null) {
            aye.O000000o(gtl);
            this.mAdapter = null;
        }
    }

    public void resetAdapter() {
        this.O0000O0o = new LinearLayoutManager(getContext());
        this.O00000oo = new axx();
        axx axx = this.O00000oo;
        axx.O0000OOo = true;
        axx.O00000Oo();
        this.O00000oO = new axl();
        this.O00000oO.O0000Oo0 = (NinePatchDrawable) getContext().getResources().getDrawable(R.drawable.std_list_item_drag_shadow);
        this.mAdapter = new gtl(this);
        this.O00000o = this.O00000oO.O000000o(this.mAdapter);
        awq awq = new awq();
        awq.O0000o00 = false;
        this.O00000o0.setLayoutManager(this.O0000O0o);
        this.O00000o0.setAdapter(this.O00000o);
        this.O00000o0.setItemAnimator(awq);
        this.O00000o0.setHasFixedSize(false);
        this.O00000oo.O000000o(this.O00000o0);
        this.O00000oO.O000000o(this.O00000o0);
        axl axl = this.O00000oO;
        axl.O0000o00 = false;
        axl.O0000o0 = true;
        axl.O0000o0O = (int) (((float) ViewConfiguration.getLongPressTimeout()) * 1.5f);
        this.O00000oO.O00oOooO = new axl.O00000Oo() {
            /* class com.xiaomi.smarthome.listcamera.CameraSortActivity.AnonymousClass4 */
        };
    }

    public void orderChanged() {
        this.f9406O000000o.setEnabled(true);
    }
}
