package com.miui.tsmclientsdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.miui.tsmclientsdk.IMiTsmResponse;
import com.miui.tsmclientsdk.OnProgressUpdateListener;
import com.miui.tsmclientsdk.internal.AbstractServiceTask;
import java.util.List;

public abstract class ServiceTask<T extends IInterface> extends AbstractServiceTask<T, IMiTsmResponse> {
    protected ServiceTask(Context context) {
        this(context, false);
    }

    protected ServiceTask(Context context, boolean z) {
        this(context, z, null);
    }

    protected ServiceTask(Context context, boolean z, OnProgressUpdateListener onProgressUpdateListener) {
        this(context, null, z, onProgressUpdateListener, null);
    }

    protected ServiceTask(Context context, String str, boolean z, OnProgressUpdateListener onProgressUpdateListener, List<AbstractServiceTask> list) {
        super(context, str, z, onProgressUpdateListener, list);
    }

    /* access modifiers changed from: protected */
    public IMiTsmResponse getResponse() {
        return new IMiTsmResponseImpl(this.mId);
    }

    class IMiTsmResponseImpl extends IMiTsmResponse.Stub {
        private final AbstractServiceTask<T, IMiTsmResponse>.SimpleResponse mSimpleResponse;

        IMiTsmResponseImpl(ServiceTask serviceTask) {
            this(null);
        }

        IMiTsmResponseImpl(String str) {
            this.mSimpleResponse = new AbstractServiceTask.SimpleResponse(str);
        }

        public void onResult(Bundle bundle) throws RemoteException {
            this.mSimpleResponse.onResult(bundle);
        }

        public void onError(int i, String str) throws RemoteException {
            this.mSimpleResponse.onError(i, str);
        }

        public void onProgress(int i) throws RemoteException {
            this.mSimpleResponse.onProgress(i);
        }

        public String getId() throws RemoteException {
            return this.mSimpleResponse.getId();
        }
    }
}
