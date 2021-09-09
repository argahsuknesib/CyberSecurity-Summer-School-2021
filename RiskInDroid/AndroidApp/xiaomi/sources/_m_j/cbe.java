package _m_j;

import _m_j.ccy;
import android.app.Application;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.mi.blockcanary.BlockAppContext;
import com.mi.mistatistic.sdk.controller.MiStatOptions;
import com.mi.multimonitor.CrashReport;
import java.util.Calendar;

public abstract class cbe {

    /* renamed from: O000000o  reason: collision with root package name */
    private static String f13587O000000o = "";

    public static final void O000000o() {
    }

    public static void O000000o(String str) {
        f13587O000000o = str;
    }

    public static final void O00000Oo(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(f13587O000000o);
        sb.append(str);
    }

    public static final void O000000o(String str, String str2) {
        ccv.O000000o(str, f13587O000000o + str2, null, null);
    }

    public static final void O000000o(String str, String str2, String str3, String str4) {
        ccv.O000000o(str, f13587O000000o + str2, str3, str4);
    }

    public static final void O000000o(String str, String str2, String str3, String str4, String str5) {
        ccv.O00000Oo(str, f13587O000000o + str2, str3, str4, str5);
    }

    public static final void O00000Oo(String str, String str2) {
        ccv.O000000o(str, f13587O000000o + str2, null);
    }

    public static final void O000000o(String str, String str2, String str3) {
        ccv.O000000o(str, f13587O000000o + str2, str3);
    }

    public static final void O00000o0(String str, String str2) {
        ccv.O00000Oo(str, f13587O000000o + str2, "");
    }

    public static final void O00000Oo(String str, String str2, String str3) {
        ccv.O00000Oo(str, f13587O000000o + str2, str3);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long
     arg types: [android.content.Context, java.lang.String, int]
     candidates:
      _m_j.cde.O000000o(android.content.Context, java.lang.String, java.lang.String):java.lang.String
      _m_j.cde.O000000o(android.content.Context, java.lang.String, int):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, boolean):void
      _m_j.cde.O000000o(android.content.Context, java.lang.String, long):long */
    public static final void O000000o(Application application, MiStatOptions miStatOptions) {
        StringBuilder sb;
        if (miStatOptions == null) {
            miStatOptions = new MiStatOptions.O000000o().f5062O000000o;
        }
        ccv.f13641O000000o = miStatOptions;
        if (miStatOptions.disableStat) {
            return;
        }
        if (!TextUtils.isEmpty(miStatOptions.appId)) {
            Context applicationContext = application.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = application;
            }
            ccs.O000000o(miStatOptions.test);
            ccs.O00000o(miStatOptions.serverCn);
            ccs.O00000Oo(miStatOptions.serverIndia);
            ccs.O00000o0(miStatOptions.serverRussia);
            if (miStatOptions.needUploadPackageNameList != null && miStatOptions.needUploadPackageNameList.size() > 0) {
                ccx.O000000o(miStatOptions.needUploadPackageNameList);
            }
            ccx.O000000o(application, miStatOptions.appId, TextUtils.isEmpty(miStatOptions.channel) ? "mistats_default" : miStatOptions.channel);
            cdi O000000o2 = cdi.O000000o();
            O000000o2.f13662O000000o = cde.O000000o(ccx.O000000o(), "upload_policy");
            if (O000000o2.f13662O000000o == 4) {
                O000000o2.O00000Oo = cde.O000000o(ccx.O000000o(), "upload_interval", 60000L);
            } else {
                O000000o2.O00000Oo = cde.O000000o(ccx.O000000o(), "upload_delay", 60000L);
            }
            int i = miStatOptions.uploadPolicy;
            long j = (long) miStatOptions.uploadInteval;
            if (i != 4 || (j >= 60000 && j <= 86400000)) {
                cdi O000000o3 = cdi.O000000o();
                O000000o3.f13662O000000o = i;
                if (O000000o3.f13662O000000o == 4) {
                    O000000o3.O00000Oo = j;
                } else {
                    O000000o3.O00000Oo = cde.O000000o(ccx.O000000o(), "upload_delay", 60000L);
                }
                cde.O000000o(ccx.O000000o(), "upload_policy", O000000o3.f13662O000000o);
                if (O000000o3.f13662O000000o == 4) {
                    cde.O00000Oo(ccx.O000000o(), "upload_interval", O000000o3.O00000Oo);
                    ccy.O000000o().O000000o(new ccy.O000000o() {
                        /* class _m_j.cdi.AnonymousClass2 */

                        public final void O000000o() {
                            if (cdi.this.O00000o0()) {
                                new cdf().O000000o(true);
                            }
                        }
                    }, O000000o3.O00000Oo);
                }
                ccx.O000000o(miStatOptions.userId);
                ccx.O00000Oo(miStatOptions.gaId);
                ccy.O000000o().O000000o(new cdk());
                cda.O000000o();
                CrashReport.setSingletonInstance(new CrashReport.Builder(applicationContext).appId(miStatOptions.appId).version(miStatOptions.versionSpan).isForSdk(miStatOptions.isForSdk).build());
                int i2 = Calendar.getInstance().get(6);
                if (i2 != cde.O000000o(applicationContext, "last_day")) {
                    cde.O000000o(applicationContext, "last_day", i2);
                    cdp cdp = new cdp();
                    DisplayMetrics displayMetrics = applicationContext.getResources().getDisplayMetrics();
                    if (displayMetrics != null) {
                        int i3 = displayMetrics.widthPixels;
                        int i4 = displayMetrics.heightPixels;
                        if (i3 < i4) {
                            sb = new StringBuilder();
                            sb.append(i3);
                            sb.append("x");
                            sb.append(i4);
                        } else {
                            sb = new StringBuilder();
                            sb.append(i4);
                            sb.append("x");
                            sb.append(i3);
                        }
                        cdp.O00000oO = sb.toString();
                    }
                    cdh.O000000o();
                    cdp.O00000oo = cdh.O00000Oo();
                    cdp.O0000O0o = cdd.O00000Oo(applicationContext.getApplicationContext());
                    cdb.O000000o(cdp);
                }
                if (miStatOptions.enableLog) {
                    cdc.O000000o();
                }
                if (miStatOptions.openBlockCanary) {
                    bxu O000000o4 = bxu.O000000o(applicationContext, new BlockAppContext(applicationContext));
                    if (!O000000o4.O00000Oo) {
                        O000000o4.O00000Oo = true;
                        Looper.getMainLooper().setMessageLogging(O000000o4.f13391O000000o.f13394O000000o);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("interval should be set between 1 minutes and 1 day");
        }
        throw new IllegalArgumentException("appID  is empty.");
    }

    public static final String O000000o(Context context) {
        return ccz.O000000o(context);
    }
}
