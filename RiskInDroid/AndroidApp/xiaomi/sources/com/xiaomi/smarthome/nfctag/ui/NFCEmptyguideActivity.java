package com.xiaomi.smarthome.nfctag.ui;

import _m_j.dcp;
import _m_j.ezq;
import _m_j.ezt;
import _m_j.ftn;
import _m_j.gtx;
import _m_j.gty;
import _m_j.hif;
import _m_j.hig;
import _m_j.hor;
import _m_j.hte;
import _m_j.hxi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.framework.page.BaseActivity;

public class NFCEmptyguideActivity extends BaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ezt.O000000o().startCheck(new ezq() {
            /* class com.xiaomi.smarthome.nfctag.ui.NFCEmptyguideActivity.AnonymousClass1 */

            public final void O000000o() {
                NFCEmptyguideActivity.this.finish();
            }

            public final void O00000Oo() {
                NFCEmptyguideActivity.this.finish();
            }

            public final void O00000o0() {
                hif.O000000o();
                if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                    gty.O000000o().startLogin(NFCEmptyguideActivity.this, 1, new gtx.O000000o() {
                        /* class com.xiaomi.smarthome.nfctag.ui.NFCEmptyguideActivity.AnonymousClass1.AnonymousClass1 */

                        public final void O000000o() {
                            if (ServiceApplication.getStateNotifier().f15923O000000o != 4) {
                                hte.O000000o(NFCEmptyguideActivity.this, (int) R.string.login_fail);
                                NFCEmptyguideActivity.this.finish();
                                return;
                            }
                            NFCEmptyguideActivity.this.doWork();
                        }
                    });
                } else {
                    NFCEmptyguideActivity.this.doWork();
                }
            }
        });
    }

    public void doWork() {
        if (ftn.O00000oO(ServiceApplication.getAppContext()) || !hig.O00000oo()) {
            finish();
            return;
        }
        setContentView((int) R.layout.activity_nfc_empty);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCEmptyguideActivity$J95sraA_qqjmt7bfw768DMo7tk */

            public final void onClick(View view) {
                NFCEmptyguideActivity.this.O00000Oo(view);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.nfctag.ui.$$Lambda$NFCEmptyguideActivity$cuzV6I5gphxgdmQ0MpLWTE21Qg */

            public final void onClick(View view) {
                NFCEmptyguideActivity.this.O000000o(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(View view) {
        hxi.O00000o.f952O000000o.O000000o("NFC_blank_setting", new Object[0]);
        startActivity(new Intent(this, NFCActionListActivity.class));
        hor.O000000o().clearCreateSceneManager();
        dcp.O000000o().O000000o(ServiceApplication.getAppContext());
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(View view) {
        finish();
    }
}
