package androidx.loader.content;

import _m_j.bb;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D> {
    boolean mAbandoned = false;
    boolean mContentChanged = false;
    Context mContext;
    int mId;
    O00000o0<D> mListener;
    O00000Oo<D> mOnLoadCanceledListener;
    boolean mProcessingChange = false;
    boolean mReset = true;
    boolean mStarted = false;

    public interface O00000Oo<D> {
    }

    public interface O00000o0<D> {
        void O000000o(D d);
    }

    public void deliverCancellation() {
    }

    /* access modifiers changed from: protected */
    public void onAbandon() {
    }

    /* access modifiers changed from: protected */
    public boolean onCancelLoad() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onForceLoad() {
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
    }

    public final class O000000o extends ContentObserver {
        public final boolean deliverSelfNotifications() {
            return true;
        }

        public O000000o() {
            super(new Handler());
        }

        public final void onChange(boolean z) {
            Loader.this.onContentChanged();
        }
    }

    public Loader(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public void deliverResult(D d) {
        O00000o0<D> o00000o0 = this.mListener;
        if (o00000o0 != null) {
            o00000o0.O000000o(d);
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public int getId() {
        return this.mId;
    }

    public void registerListener(int i, O00000o0<D> o00000o0) {
        if (this.mListener == null) {
            this.mListener = o00000o0;
            this.mId = i;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void unregisterListener(O00000o0<D> o00000o0) {
        O00000o0<D> o00000o02 = this.mListener;
        if (o00000o02 == null) {
            throw new IllegalStateException("No listener register");
        } else if (o00000o02 == o00000o0) {
            this.mListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public void registerOnLoadCanceledListener(O00000Oo<D> o00000Oo) {
        if (this.mOnLoadCanceledListener == null) {
            this.mOnLoadCanceledListener = o00000Oo;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void unregisterOnLoadCanceledListener(O00000Oo<D> o00000Oo) {
        O00000Oo<D> o00000Oo2 = this.mOnLoadCanceledListener;
        if (o00000Oo2 == null) {
            throw new IllegalStateException("No listener register");
        } else if (o00000Oo2 == o00000Oo) {
            this.mOnLoadCanceledListener = null;
        } else {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public boolean isAbandoned() {
        return this.mAbandoned;
    }

    public boolean isReset() {
        return this.mReset;
    }

    public final void startLoading() {
        this.mStarted = true;
        this.mReset = false;
        this.mAbandoned = false;
        onStartLoading();
    }

    public boolean cancelLoad() {
        return onCancelLoad();
    }

    public void forceLoad() {
        onForceLoad();
    }

    public void stopLoading() {
        this.mStarted = false;
        onStopLoading();
    }

    public void abandon() {
        this.mAbandoned = true;
        onAbandon();
    }

    public void reset() {
        onReset();
        this.mReset = true;
        this.mStarted = false;
        this.mAbandoned = false;
        this.mContentChanged = false;
        this.mProcessingChange = false;
    }

    public boolean takeContentChanged() {
        boolean z = this.mContentChanged;
        this.mContentChanged = false;
        this.mProcessingChange |= z;
        return z;
    }

    public void commitContentChanged() {
        this.mProcessingChange = false;
    }

    public void rollbackContentChanged() {
        if (this.mProcessingChange) {
            onContentChanged();
        }
    }

    public void onContentChanged() {
        if (this.mStarted) {
            forceLoad();
        } else {
            this.mContentChanged = true;
        }
    }

    public String dataToString(D d) {
        StringBuilder sb = new StringBuilder(64);
        bb.O000000o(d, sb);
        sb.append("}");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        bb.O000000o(this, sb);
        sb.append(" id=");
        sb.append(this.mId);
        sb.append("}");
        return sb.toString();
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mListener=");
        printWriter.println(this.mListener);
        if (this.mStarted || this.mContentChanged || this.mProcessingChange) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.mStarted);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.mContentChanged);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.mProcessingChange);
        }
        if (this.mAbandoned || this.mReset) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.mAbandoned);
            printWriter.print(" mReset=");
            printWriter.println(this.mReset);
        }
    }
}
