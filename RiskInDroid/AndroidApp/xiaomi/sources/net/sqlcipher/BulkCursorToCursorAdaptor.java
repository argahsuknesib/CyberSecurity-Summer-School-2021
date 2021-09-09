package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import java.util.Map;
import net.sqlcipher.AbstractCursor;

public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private IBulkCursor mBulkCursor;
    private String[] mColumns;
    private int mCount;
    private AbstractCursor.SelfContentObserver mObserverBridge;
    private boolean mWantsAllOnMoveCalls;

    public final void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void set(IBulkCursor iBulkCursor) {
        this.mBulkCursor = iBulkCursor;
        try {
            this.mCount = this.mBulkCursor.count();
            this.mWantsAllOnMoveCalls = this.mBulkCursor.getWantsAllOnMoveCalls();
            this.mColumns = this.mBulkCursor.getColumnNames();
            this.mRowIdColumnIndex = findRowIdColumnIndex(this.mColumns);
        } catch (RemoteException unused) {
            Log.e("BulkCursor", "Setup failed because the remote process is dead");
        }
    }

    public final void set(IBulkCursor iBulkCursor, int i, int i2) {
        this.mBulkCursor = iBulkCursor;
        this.mColumns = null;
        this.mCount = i;
        this.mRowIdColumnIndex = i2;
    }

    public static int findRowIdColumnIndex(String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (strArr[i].equals("_id")) {
                return i;
            }
        }
        return -1;
    }

    public final synchronized IContentObserver getObserver() {
        if (this.mObserverBridge == null) {
            this.mObserverBridge = new AbstractCursor.SelfContentObserver(this);
        }
        return null;
    }

    public final int getCount() {
        return this.mCount;
    }

    public final boolean onMove(int i, int i2) {
        try {
            if (this.mWindow != null) {
                if (i2 >= this.mWindow.getStartPosition()) {
                    if (i2 < this.mWindow.getStartPosition() + this.mWindow.getNumRows()) {
                        if (this.mWantsAllOnMoveCalls) {
                            this.mBulkCursor.onMove(i2);
                        }
                    }
                }
                this.mWindow = this.mBulkCursor.getWindow(i2);
            } else {
                this.mWindow = this.mBulkCursor.getWindow(i2);
            }
            if (this.mWindow == null) {
                return false;
            }
            return true;
        } catch (RemoteException unused) {
            Log.e("BulkCursor", "Unable to get window because the remote process is dead");
            return false;
        }
    }

    public final void deactivate() {
        super.deactivate();
        try {
            this.mBulkCursor.deactivate();
        } catch (RemoteException unused) {
            Log.w("BulkCursor", "Remote process exception when deactivating");
        }
        this.mWindow = null;
    }

    public final void close() {
        super.close();
        try {
            this.mBulkCursor.close();
        } catch (RemoteException unused) {
            Log.w("BulkCursor", "Remote process exception when closing");
        }
        this.mWindow = null;
    }

    public final boolean requery() {
        try {
            this.mCount = this.mBulkCursor.requery(getObserver(), new CursorWindow(false));
            if (this.mCount != -1) {
                this.mPos = -1;
                this.mWindow = null;
                super.requery();
                return true;
            }
            deactivate();
            return false;
        } catch (Exception e) {
            Log.e("BulkCursor", "Unable to requery because the remote process exception " + e.getMessage());
            deactivate();
            return false;
        }
    }

    public final boolean deleteRow() {
        try {
            boolean deleteRow = this.mBulkCursor.deleteRow(this.mPos);
            if (deleteRow) {
                this.mWindow = null;
                this.mCount = this.mBulkCursor.count();
                if (this.mPos < this.mCount) {
                    int i = this.mPos;
                    this.mPos = -1;
                    moveToPosition(i);
                } else {
                    this.mPos = this.mCount;
                }
                onChange(true);
            }
            return deleteRow;
        } catch (RemoteException unused) {
            Log.e("BulkCursor", "Unable to delete row because the remote process is dead");
            return false;
        }
    }

    public final String[] getColumnNames() {
        if (this.mColumns == null) {
            try {
                this.mColumns = this.mBulkCursor.getColumnNames();
            } catch (RemoteException unused) {
                Log.e("BulkCursor", "Unable to fetch column names because the remote process is dead");
                return null;
            }
        }
        return this.mColumns;
    }

    public final boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> map) {
        if (!supportsUpdates()) {
            Log.e("BulkCursor", "commitUpdates not supported on this cursor, did you include the _id column?");
            return false;
        }
        synchronized (this.mUpdatedRows) {
            if (map != null) {
                this.mUpdatedRows.putAll(map);
            }
            if (this.mUpdatedRows.size() <= 0) {
                return false;
            }
            try {
                boolean updateRows = this.mBulkCursor.updateRows(this.mUpdatedRows);
                if (updateRows) {
                    this.mUpdatedRows.clear();
                    onChange(true);
                }
                return updateRows;
            } catch (RemoteException unused) {
                Log.e("BulkCursor", "Unable to commit updates because the remote process is dead");
                return false;
            }
        }
    }

    public final Bundle getExtras() {
        try {
            return this.mBulkCursor.getExtras();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public final Bundle respond(Bundle bundle) {
        try {
            return this.mBulkCursor.respond(bundle);
        } catch (RemoteException e) {
            Log.w("BulkCursor", "respond() threw RemoteException, returning an empty bundle.", e);
            return Bundle.EMPTY;
        }
    }
}
