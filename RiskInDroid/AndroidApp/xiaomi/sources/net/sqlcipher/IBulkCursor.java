package net.sqlcipher;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.Map;

public interface IBulkCursor extends IInterface {
    public static final String descriptor = "android.content.IBulkCursor";

    void close() throws RemoteException;

    int count() throws RemoteException;

    void deactivate() throws RemoteException;

    boolean deleteRow(int i) throws RemoteException;

    String[] getColumnNames() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    boolean getWantsAllOnMoveCalls() throws RemoteException;

    CursorWindow getWindow(int i) throws RemoteException;

    void onMove(int i) throws RemoteException;

    int requery(IContentObserver iContentObserver, CursorWindow cursorWindow) throws RemoteException;

    Bundle respond(Bundle bundle) throws RemoteException;

    boolean updateRows(Map<? extends Long, ? extends Map<String, Object>> map) throws RemoteException;
}
