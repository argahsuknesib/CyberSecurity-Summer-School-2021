package _m_j;

import _m_j.fuy;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DevicelibApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.List;

public final class gwe {
    private static gwe O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Context f18402O000000o = CommonApplication.getAppContext();

    public static gwe O000000o() {
        if (O00000Oo == null) {
            O00000Oo = new gwe();
        }
        return O00000Oo;
    }

    private gwe() {
    }

    public static void O000000o(Device device, String str, fsm<Void, fso> fsm) {
        String trim = str.trim();
        if (trim.length() > 40) {
            trim = trim.substring(0, 40);
        }
        CoreApi.O000000o().O000000o(device.did, trim, fsm);
    }

    public final void O000000o(Device device) {
        if (ftn.O00000o0(CoreApi.O000000o().O0000ooO())) {
            gor.O000000o(new O000000o(this, (byte) 0), device);
        }
    }

    class O000000o extends AsyncTask<Object, Device, Void> {
        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        }

        private O000000o() {
        }

        /* synthetic */ O000000o(gwe gwe, byte b) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            fuy.O000000o().O000000o(new fuy.O000000o((Device) objArr[0]) {
                /* class _m_j.gwe.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ Device f18404O000000o;

                {
                    this.f18404O000000o = r2;
                }

                public final void O000000o(String str, final Location location) {
                    CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                        /* class _m_j.gwe.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            String str;
                            String str2;
                            String str3;
                            String str4;
                            String str5;
                            Location location = location;
                            if (location != null && AnonymousClass2.this.f18404O000000o != null && AnonymousClass2.this.f18404O000000o.did != null) {
                                Address address = null;
                                try {
                                    List<Address> fromLocation = new Geocoder(gwe.this.f18402O000000o).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                                    if (fromLocation != null && fromLocation.size() > 0) {
                                        address = fromLocation.get(0);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                if (address != null) {
                                    String adminArea = address.getAdminArea();
                                    String countryCode = address.getCountryCode();
                                    String locality = address.getLocality();
                                    String thoroughfare = address.getThoroughfare();
                                    str5 = adminArea;
                                    str = address.getSubLocality();
                                    str4 = countryCode;
                                    str3 = locality;
                                    str2 = thoroughfare;
                                } else {
                                    str5 = "";
                                    str4 = str5;
                                    str3 = str4;
                                    str2 = str3;
                                    str = str2;
                                }
                                DevicelibApi.reportGPSInfo(CommonApplication.getAppContext(), AnonymousClass2.this.f18404O000000o.did, location.getLongitude(), location.getLatitude(), str5, str4, str3, str2, str, null);
                            }
                        }
                    });
                }
            });
            return null;
        }
    }
}
