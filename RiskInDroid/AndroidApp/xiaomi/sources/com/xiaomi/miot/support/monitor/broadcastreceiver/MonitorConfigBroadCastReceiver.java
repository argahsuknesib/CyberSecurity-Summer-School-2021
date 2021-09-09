package com.xiaomi.miot.support.monitor.broadcastreceiver;

import _m_j.dxq;
import _m_j.dxr;
import _m_j.dxz;
import _m_j.dya;
import _m_j.dyg;
import _m_j.dyp;
import _m_j.dyq;
import _m_j.dyt;
import _m_j.dzg;
import _m_j.dzh;
import _m_j.dzi;
import _m_j.dzj;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Debug;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import org.json.JSONObject;

public class MonitorConfigBroadCastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            final String stringExtra = intent.getStringExtra("type");
            if (!TextUtils.isEmpty(stringExtra)) {
                dzg.O000000o(new Runnable() {
                    /* class com.xiaomi.miot.support.monitor.broadcastreceiver.MonitorConfigBroadCastReceiver.AnonymousClass1 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    public final void run() {
                        char c;
                        dyp O000000o2;
                        String str = stringExtra;
                        switch (str.hashCode()) {
                            case -2122407040:
                                if (str.equals("exit_app")) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1938339299:
                                if (str.equals("stop_monitor")) {
                                    c = 4;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -1806924936:
                                if (str.equals("update_config")) {
                                    c = 1;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -857701318:
                                if (str.equals("enter_app")) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case -637950339:
                                if (str.equals("start_monitor")) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1931703314:
                                if (str.equals("report_net")) {
                                    c = 5;
                                    break;
                                }
                                c = 65535;
                                break;
                            default:
                                c = 65535;
                                break;
                        }
                        if (c == 0 || c == 1) {
                            dxr dxr = dxr.O000000o.f15041O000000o;
                            try {
                                String O000000o3 = dzi.O000000o(dxr.O00000Oo.getApplicationContext()).O000000o("key_monitor_config");
                                if (!TextUtils.isEmpty(O000000o3)) {
                                    dxz.O000000o.f15051O000000o.O000000o(O000000o3);
                                    if (dxr.O00000oO != null) {
                                        dyt.O000000o().f15080O000000o = dxr.O00000oO.O0000Oo0.http_dns_priority;
                                        if (dxr.O00000Oo == null) {
                                            return;
                                        }
                                        if (dxr.O00000o0) {
                                            dxr.O000000o(dxr.O00000Oo, true);
                                            dxr.O000000o("block", dxr.O00000oO.O00000o0.switchFlag, true);
                                            dxr.O000000o("activity", dxr.O00000oO.O00000o.switchFlag, true);
                                            dxr.O000000o("fps", dxr.O00000oO.O00000oO.switchFlag, true);
                                            dxr.O000000o("appstart", dxr.O00000oO.O00000oo.switchFlag, true);
                                            dxr.O000000o("memory", dxr.O00000oO.O0000O0o.switchFlag, false);
                                            dxr.O000000o("net", dxr.O00000oO.O0000OOo.switchFlag, false);
                                        } else if (dxr.O00000o != null) {
                                            dxr.O00000o.post(new Runnable() {
                                                /* class _m_j.dxr.AnonymousClass1 */

                                                public final void run() {
                                                    dxr dxr = dxr.this;
                                                    dxr.O00000o0 = true;
                                                    dyq dyq = dyq.O000000o.f15075O000000o;
                                                    if (Looper.myLooper() == Looper.getMainLooper() && !dyq.O00000o0) {
                                                        if (O000000o.f15041O000000o.O000000o().O0000Oo) {
                                                            dyf dyf = new dyf();
                                                            dyf.O000000o(O000000o.f15041O000000o.O000000o().O00000o0.switchFlag);
                                                            dyq.f15074O000000o.put("block", dyf);
                                                            dye dye = new dye();
                                                            dye.O000000o(O000000o.f15041O000000o.O000000o().O00000oo.switchFlag);
                                                            dyq.f15074O000000o.put("appstart", dye);
                                                        }
                                                        dyc dyc = new dyc();
                                                        dyc.O000000o(O000000o.f15041O000000o.O000000o().O00000o.switchFlag);
                                                        dyq.f15074O000000o.put("activity", dyc);
                                                        dyg dyg = new dyg();
                                                        dyg.O000000o(O000000o.f15041O000000o.O000000o().O00000oO.switchFlag);
                                                        dyq.f15074O000000o.put("fps", dyg);
                                                        dyh dyh = new dyh();
                                                        dyh.O000000o(O000000o.f15041O000000o.O000000o().O0000O0o.switchFlag);
                                                        dyq.f15074O000000o.put("memory", dyh);
                                                        dyi dyi = new dyi();
                                                        dyi.O000000o(O000000o.f15041O000000o.O000000o().O0000OOo.switchFlag);
                                                        dyq.f15074O000000o.put("net", dyi);
                                                        dyq.O00000o0 = true;
                                                    }
                                                    if (!dxr.f15037O000000o && dxr.O00000oO != null) {
                                                        if (Looper.myLooper() == Looper.getMainLooper()) {
                                                            dxr.f15037O000000o = true;
                                                            dyq.O000000o.f15075O000000o.O000000o();
                                                            return;
                                                        }
                                                        throw new RuntimeException("startWork is must run in MainThread");
                                                    }
                                                }
                                            });
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } else if (c == 2) {
                            dya dya = dya.O000000o.f15057O000000o;
                            try {
                                dyq.O000000o.f15075O000000o.O00000Oo = true;
                                dyg dyg = (dyg) dyq.O000000o.f15075O000000o.O000000o("fps");
                                if (dyg != null) {
                                    dyg.O00000o = true;
                                }
                                dya.O00000oo = System.currentTimeMillis();
                                new dzh();
                                String[] O000000o4 = dzh.O000000o(Process.myPid());
                                dya.O0000O0o = Long.parseLong(O000000o4[1]);
                                dya.O0000OOo = Long.parseLong(O000000o4[2]);
                                if (dya.O0000Oo0 == 0 && (O000000o2 = dyq.O000000o.f15075O000000o.O000000o("memory")) != null && O000000o2.O00000o0()) {
                                    O000000o2.O000000o();
                                }
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            dxq.O00000Oo();
                        } else if (c == 3) {
                            dya dya2 = dya.O000000o.f15057O000000o;
                            dya2.O000000o();
                            try {
                                if (!dyq.O000000o.f15075O000000o.O00000Oo("memory")) {
                                    dya2.O0000Oo0 = 0;
                                } else {
                                    new dzh();
                                    String[] O000000o5 = dzh.O000000o(Process.myPid());
                                    long parseLong = Long.parseLong(O000000o5[1]);
                                    long parseLong2 = Long.parseLong(O000000o5[2]);
                                    long currentTimeMillis = System.currentTimeMillis() - dya2.O00000oo;
                                    long j = parseLong - dya2.O0000O0o;
                                    long j2 = parseLong2 - dya2.O0000OOo;
                                    if (dya2.O0000Oo0 == 0) {
                                        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                                        Debug.getMemoryInfo(memoryInfo);
                                        dya2.O0000Oo0 = memoryInfo.getTotalPss();
                                    }
                                    dxr.O000000o.f15041O000000o.O000000o().f15049O000000o.O000000o(106, dxr.O000000o.f15041O000000o.O000000o().O0000O0o.report_type, new JSONObject().put("mdt", dya2.O0000Oo0).put("cut", j).put("cst", j2).put("rt", currentTimeMillis).put("pn", dzj.O000000o()));
                                    dya2.O0000Oo0 = 0;
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                            dxq.O000000o();
                            dxr.O000000o.f15041O000000o.O000000o().O0000OoO = true;
                        } else if (c == 4) {
                            dxq.O00000o0();
                        } else if (c == 5) {
                            dya.O000000o.f15057O000000o.O000000o();
                        }
                    }
                });
            }
        }
    }
}
