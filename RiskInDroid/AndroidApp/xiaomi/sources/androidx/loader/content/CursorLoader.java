package androidx.loader.content;

import _m_j.al;
import _m_j.f;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.core.os.OperationCanceledException;
import androidx.loader.content.Loader;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public class CursorLoader extends AsyncTaskLoader<Cursor> {

    /* renamed from: O000000o  reason: collision with root package name */
    final Loader<Cursor>.O000000o f2887O000000o = new Loader.O000000o();
    Uri O00000Oo;
    String O00000o;
    String[] O00000o0;
    String[] O00000oO;
    String O00000oo;
    Cursor O0000O0o;
    al O0000OOo;

    public /* synthetic */ void onCanceled(Object obj) {
        Cursor cursor = (Cursor) obj;
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public Cursor loadInBackground() {
        Cursor O000000o2;
        synchronized (this) {
            if (!isLoadInBackgroundCanceled()) {
                this.O0000OOo = new al();
            } else {
                throw new OperationCanceledException();
            }
        }
        try {
            O000000o2 = f.O000000o(getContext().getContentResolver(), this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, this.O00000oo, this.O0000OOo);
            if (O000000o2 != null) {
                O000000o2.getCount();
                O000000o2.registerContentObserver(this.f2887O000000o);
            }
            synchronized (this) {
                this.O0000OOo = null;
            }
            return O000000o2;
        } catch (RuntimeException e) {
            O000000o2.close();
            throw e;
        } catch (Throwable th) {
            synchronized (this) {
                this.O0000OOo = null;
                throw th;
            }
        }
    }

    public void cancelLoadInBackground() {
        super.cancelLoadInBackground();
        synchronized (this) {
            if (this.O0000OOo != null) {
                al alVar = this.O0000OOo;
                synchronized (alVar) {
                    if (!alVar.f12429O000000o) {
                        alVar.f12429O000000o = true;
                        alVar.O00000o0 = true;
                        Object obj = alVar.O00000Oo;
                        if (obj != null) {
                            try {
                                if (Build.VERSION.SDK_INT >= 16) {
                                    ((CancellationSignal) obj).cancel();
                                }
                            } catch (Throwable th) {
                                synchronized (alVar) {
                                    alVar.O00000o0 = false;
                                    alVar.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (alVar) {
                            alVar.O00000o0 = false;
                            alVar.notifyAll();
                        }
                    }
                }
            }
        }
        return;
    }

    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public void deliverResult(Cursor cursor) {
        if (!isReset()) {
            Cursor cursor2 = this.O0000O0o;
            this.O0000O0o = cursor;
            if (isStarted()) {
                super.deliverResult(cursor);
            }
            if (cursor2 != null && cursor2 != cursor && !cursor2.isClosed()) {
                cursor2.close();
            }
        } else if (cursor != null) {
            cursor.close();
        }
    }

    public CursorLoader(Context context) {
        super(context);
    }

    public CursorLoader(Context context, Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        super(context);
        this.O00000Oo = uri;
        this.O00000o0 = strArr;
        this.O00000o = str;
        this.O00000oO = strArr2;
        this.O00000oo = str2;
    }

    /* access modifiers changed from: protected */
    public void onStartLoading() {
        Cursor cursor = this.O0000O0o;
        if (cursor != null) {
            deliverResult(cursor);
        }
        if (takeContentChanged() || this.O0000O0o == null) {
            forceLoad();
        }
    }

    /* access modifiers changed from: protected */
    public void onStopLoading() {
        cancelLoad();
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        super.onReset();
        onStopLoading();
        Cursor cursor = this.O0000O0o;
        if (cursor != null && !cursor.isClosed()) {
            this.O0000O0o.close();
        }
        this.O0000O0o = null;
    }

    @Deprecated
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("mUri=");
        printWriter.println(this.O00000Oo);
        printWriter.print(str);
        printWriter.print("mProjection=");
        printWriter.println(Arrays.toString(this.O00000o0));
        printWriter.print(str);
        printWriter.print("mSelection=");
        printWriter.println(this.O00000o);
        printWriter.print(str);
        printWriter.print("mSelectionArgs=");
        printWriter.println(Arrays.toString(this.O00000oO));
        printWriter.print(str);
        printWriter.print("mSortOrder=");
        printWriter.println(this.O00000oo);
        printWriter.print(str);
        printWriter.print("mCursor=");
        printWriter.println(this.O0000O0o);
        printWriter.print(str);
        printWriter.print("mContentChanged=");
        printWriter.println(this.mContentChanged);
    }
}
