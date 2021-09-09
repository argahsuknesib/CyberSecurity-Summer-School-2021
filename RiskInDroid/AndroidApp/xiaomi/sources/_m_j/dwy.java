package _m_j;

import _m_j.dwz;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.device.BleDevice;
import com.xiaomi.smarthome.device.choosedevice.ScanDeviceProgressBar;
import com.xiaomi.smarthome.library.common.dialog.MLAlertDialog;

public final class dwy extends dcl implements ScanDeviceProgressBar.O000000o {
    public ScanDeviceProgressBar O00000o;
    public String O00000oO;
    public O000000o O00000oo;
    private dwz O0000O0o;

    public interface O000000o {
        void O000000o(BleDevice bleDevice);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate((int) R.layout.scan_uwb_bledevice_layout, (ViewGroup) null);
        this.O00000o = (ScanDeviceProgressBar) inflate.findViewById(R.id.progress_bar);
        this.O00000o.setTime(21000);
        ScanDeviceProgressBar scanDeviceProgressBar = this.O00000o;
        scanDeviceProgressBar.O00000o0 = this;
        scanDeviceProgressBar.O000000o();
        this.O0000O0o = new dwz();
        O00000Oo();
        return inflate;
    }

    private void O00000Oo() {
        if (this.O0000O0o.f15013O000000o) {
            this.O0000O0o.O000000o();
        }
        this.O0000O0o.O000000o(this.O00000oO, new dwz.O000000o() {
            /* class _m_j.dwy.AnonymousClass1 */

            public final void O000000o(BleDevice bleDevice) {
                if (dwy.this.O00000oo != null) {
                    dwy.this.O00000o.O00000Oo();
                    dwy.this.O00000oo.O000000o(bleDevice);
                }
            }
        });
    }

    public final void onTimeOut() {
        if (O000000o()) {
            new MLAlertDialog.Builder(getContext()).O00000Oo((int) R.string.scan_timeout_tips).O000000o((int) R.string.restart_scan, new DialogInterface.OnClickListener() {
                /* class _m_j.$$Lambda$dwy$f190Od06gsqSuryQaksU1QtsZ30 */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dwy.this.O00000Oo(dialogInterface, i);
                }
            }).O00000Oo((int) R.string.sh_common_cancel, new DialogInterface.OnClickListener() {
                /* class _m_j.$$Lambda$dwy$hj6y9ac2IPSt0D4sD0hW9HvyaGk */

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dwy.this.O000000o(dialogInterface, i);
                }
            }).O000000o(false).O00000o().show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O00000Oo(DialogInterface dialogInterface, int i) {
        this.O00000o.O00000o0();
        this.O00000o.O000000o();
        O00000Oo();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(DialogInterface dialogInterface, int i) {
        if (getActivity() != null) {
            getActivity().onBackPressed();
        }
    }
}
