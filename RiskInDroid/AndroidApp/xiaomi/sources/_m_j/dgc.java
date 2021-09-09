package _m_j;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.Map;

public final class dgc extends Fragment {

    /* renamed from: O000000o  reason: collision with root package name */
    Map<String, PublishSubject<dga>> f14599O000000o = new HashMap();
    private boolean O00000Oo;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @TargetApi(23)
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 42) {
            boolean[] zArr = new boolean[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                zArr[i2] = shouldShowRequestPermissionRationale(strArr[i2]);
            }
            int length = strArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                O000000o("onRequestPermissionsResult  " + strArr[i3]);
                PublishSubject publishSubject = this.f14599O000000o.get(strArr[i3]);
                if (publishSubject == null) {
                    Log.e("RxPermissions", "RxPermissions.onRequestPermissionsResult invoked but didn't find the corresponding permission request.");
                    return;
                }
                this.f14599O000000o.remove(strArr[i3]);
                publishSubject.onNext(new dga(strArr[i3], iArr[i3] == 0, zArr[i3]));
                publishSubject.onComplete();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        if (this.O00000Oo) {
            Log.d("RxPermissions", str);
        }
    }
}
