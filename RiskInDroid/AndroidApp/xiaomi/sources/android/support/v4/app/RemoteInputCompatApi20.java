package android.support.v4.app;

import android.annotation.TargetApi;
import android.app.RemoteInput;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.RemoteInputCompatBase;

@TargetApi(20)
@RequiresApi(20)
class RemoteInputCompatApi20 {
    RemoteInputCompatApi20() {
    }

    static RemoteInputCompatBase.RemoteInput[] toCompat(RemoteInput[] remoteInputArr, RemoteInputCompatBase.RemoteInput.Factory factory) {
        if (remoteInputArr == null) {
            return null;
        }
        RemoteInputCompatBase.RemoteInput[] newArray = factory.newArray(remoteInputArr.length);
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInput remoteInput = remoteInputArr[i];
            newArray[i] = factory.build(remoteInput.getResultKey(), remoteInput.getLabel(), remoteInput.getChoices(), remoteInput.getAllowFreeFormInput(), remoteInput.getExtras());
        }
        return newArray;
    }

    static RemoteInput[] fromCompat(RemoteInputCompatBase.RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr2 = new RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            RemoteInputCompatBase.RemoteInput remoteInput = remoteInputArr[i];
            remoteInputArr2[i] = new RemoteInput.Builder(remoteInput.getResultKey()).setLabel(remoteInput.getLabel()).setChoices(remoteInput.getChoices()).setAllowFreeFormInput(remoteInput.getAllowFreeFormInput()).addExtras(remoteInput.getExtras()).build();
        }
        return remoteInputArr2;
    }

    static Bundle getResultsFromIntent(Intent intent) {
        return RemoteInput.getResultsFromIntent(intent);
    }

    static void addResultsToIntent(RemoteInputCompatBase.RemoteInput[] remoteInputArr, Intent intent, Bundle bundle) {
        RemoteInput.addResultsToIntent(fromCompat(remoteInputArr), intent, bundle);
    }
}
