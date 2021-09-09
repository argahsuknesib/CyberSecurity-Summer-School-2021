package net.sqlcipher;

import android.database.CrossProcessCursor;
import android.database.CursorWindow;

public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    public CursorWindow getWindow() {
        return null;
    }

    public boolean onMove(int i, int i2) {
        return true;
    }

    public CrossProcessCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public void fillWindow(int i, CursorWindow cursorWindow) {
        DatabaseUtils.cursorFillWindow(this, i, cursorWindow);
    }
}
