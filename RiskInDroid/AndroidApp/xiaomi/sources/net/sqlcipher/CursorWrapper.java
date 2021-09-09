package net.sqlcipher;

public class CursorWrapper extends android.database.CursorWrapper implements Cursor {
    private final Cursor mCursor;

    public CursorWrapper(Cursor cursor) {
        super(cursor);
        this.mCursor = cursor;
    }

    public int getType(int i) {
        return this.mCursor.getType(i);
    }

    public Cursor getWrappedCursor() {
        return this.mCursor;
    }
}
