package android.support.v4.app;

import android.annotation.TargetApi;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.RemoteInputCompatBase;

@TargetApi(16)
@RequiresApi(16)
class RemoteInputCompatJellybean {
    RemoteInputCompatJellybean() {
    }

    static RemoteInputCompatBase.RemoteInput fromBundle(Bundle bundle, RemoteInputCompatBase.RemoteInput.Factory factory) {
        return factory.build(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), bundle.getBundle("extras"));
    }

    static Bundle toBundle(RemoteInputCompatBase.RemoteInput remoteInput) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", remoteInput.getResultKey());
        bundle.putCharSequence("label", remoteInput.getLabel());
        bundle.putCharSequenceArray("choices", remoteInput.getChoices());
        bundle.putBoolean("allowFreeFormInput", remoteInput.getAllowFreeFormInput());
        bundle.putBundle("extras", remoteInput.getExtras());
        return bundle;
    }

    static RemoteInputCompatBase.RemoteInput[] fromBundleArray(Bundle[] bundleArr, RemoteInputCompatBase.RemoteInput.Factory factory) {
        if (bundleArr == null) {
            return null;
        }
        RemoteInputCompatBase.RemoteInput[] newArray = factory.newArray(bundleArr.length);
        for (int i = 0; i < bundleArr.length; i++) {
            newArray[i] = fromBundle(bundleArr[i], factory);
        }
        return newArray;
    }

    static Bundle[] toBundleArray(RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            bundleArr[i] = toBundle(remoteInputArr[i]);
        }
        return bundleArr;
    }

    static Bundle getResultsFromIntent(Intent intent) {
        ClipData clipData = intent.getClipData();
        if (clipData == null) {
            return null;
        }
        ClipDescription description = clipData.getDescription();
        if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals("android.remoteinput.results")) {
            return (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
        }
        return null;
    }

    static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        for (RemoteInputCompatBase.RemoteInput remoteInput : remoteInputArr) {
            Object obj = bundle.get(remoteInput.getResultKey());
            if (obj instanceof CharSequence) {
                bundle2.putCharSequence(remoteInput.getResultKey(), (CharSequence) obj);
            }
        }
        Intent intent2 = new Intent();
        intent2.putExtra("android.remoteinput.resultsData", bundle2);
        intent.setClipData(ClipData.newIntent("android.remoteinput.results", intent2));
    }
}
