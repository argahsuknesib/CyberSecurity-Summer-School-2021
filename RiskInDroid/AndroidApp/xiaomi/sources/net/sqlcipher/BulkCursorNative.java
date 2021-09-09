package net.sqlcipher;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.exoplayer2.C;
import net.sqlcipher.IContentObserver;
import no.nordicsemi.android.dfu.DfuSettingsConstants;

public abstract class BulkCursorNative extends Binder implements IBulkCursor {
    public IBinder asBinder() {
        return this;
    }

    public BulkCursorNative() {
        attachInterface(this, IBulkCursor.descriptor);
    }

    public static IBulkCursor asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IBulkCursor iBulkCursor = (IBulkCursor) iBinder.queryLocalInterface(IBulkCursor.descriptor);
        if (iBulkCursor != null) {
            return iBulkCursor;
        }
        return new BulkCursorProxy(iBinder);
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        int i3 = 0;
        switch (i) {
            case 1:
                parcel.enforceInterface(IBulkCursor.descriptor);
                CursorWindow window = getWindow(parcel.readInt());
                if (window == null) {
                    parcel2.writeInt(0);
                    return true;
                }
                parcel2.writeNoException();
                parcel2.writeInt(1);
                window.writeToParcel(parcel2, 0);
                return true;
            case 2:
                parcel.enforceInterface(IBulkCursor.descriptor);
                int count = count();
                parcel2.writeNoException();
                parcel2.writeInt(count);
                return true;
            case 3:
                parcel.enforceInterface(IBulkCursor.descriptor);
                String[] columnNames = getColumnNames();
                parcel2.writeNoException();
                parcel2.writeInt(columnNames.length);
                int length = columnNames.length;
                while (i3 < length) {
                    parcel2.writeString(columnNames[i3]);
                    i3++;
                }
                return true;
            case 4:
                parcel.enforceInterface(IBulkCursor.descriptor);
                boolean updateRows = updateRows(parcel.readHashMap(null));
                parcel2.writeNoException();
                if (updateRows) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface(IBulkCursor.descriptor);
                boolean deleteRow = deleteRow(parcel.readInt());
                parcel2.writeNoException();
                if (deleteRow) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 6:
                parcel.enforceInterface(IBulkCursor.descriptor);
                deactivate();
                parcel2.writeNoException();
                return true;
            case 7:
                parcel.enforceInterface(IBulkCursor.descriptor);
                int requery = requery(IContentObserver.Stub.asInterface(parcel.readStrongBinder()), CursorWindow.CREATOR.createFromParcel(parcel));
                parcel2.writeNoException();
                parcel2.writeInt(requery);
                parcel2.writeBundle(getExtras());
                return true;
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                parcel.enforceInterface(IBulkCursor.descriptor);
                onMove(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 9:
                parcel.enforceInterface(IBulkCursor.descriptor);
                boolean wantsAllOnMoveCalls = getWantsAllOnMoveCalls();
                parcel2.writeNoException();
                if (wantsAllOnMoveCalls) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 10:
                parcel.enforceInterface(IBulkCursor.descriptor);
                Bundle extras = getExtras();
                parcel2.writeNoException();
                parcel2.writeBundle(extras);
                return true;
            case 11:
                parcel.enforceInterface(IBulkCursor.descriptor);
                Bundle respond = respond(parcel.readBundle(getClass().getClassLoader()));
                parcel2.writeNoException();
                parcel2.writeBundle(respond);
                return true;
            case DfuSettingsConstants.SETTINGS_NUMBER_OF_PACKETS_DEFAULT /*12*/:
                try {
                    parcel.enforceInterface(IBulkCursor.descriptor);
                    close();
                    parcel2.writeNoException();
                    return true;
                } catch (Exception e) {
                    DatabaseUtils.writeExceptionToParcel(parcel2, e);
                    return true;
                }
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
