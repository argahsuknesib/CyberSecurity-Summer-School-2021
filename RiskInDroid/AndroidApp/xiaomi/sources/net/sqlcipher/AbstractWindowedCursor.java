package net.sqlcipher;

import android.database.CharArrayBuffer;

public abstract class AbstractWindowedCursor extends AbstractCursor {
    public CursorWindow mWindow;

    public byte[] getBlob(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.getBlob(this.mPos, i);
            }
            byte[] bArr = (byte[]) getUpdatedField(i);
            return bArr;
        }
    }

    public String getString(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.getString(this.mPos, i);
            }
            String str = (String) getUpdatedField(i);
            return str;
        }
    }

    public void copyStringToBuffer(int i, CharArrayBuffer charArrayBuffer) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (isFieldUpdated(i)) {
                super.copyStringToBuffer(i, charArrayBuffer);
            }
        }
        this.mWindow.copyStringToBuffer(this.mPos, i, charArrayBuffer);
    }

    public short getShort(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.getShort(this.mPos, i);
            }
            short shortValue = ((Number) getUpdatedField(i)).shortValue();
            return shortValue;
        }
    }

    public int getInt(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.getInt(this.mPos, i);
            }
            int intValue = ((Number) getUpdatedField(i)).intValue();
            return intValue;
        }
    }

    public long getLong(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.getLong(this.mPos, i);
            }
            long longValue = ((Number) getUpdatedField(i)).longValue();
            return longValue;
        }
    }

    public float getFloat(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.getFloat(this.mPos, i);
            }
            float floatValue = ((Number) getUpdatedField(i)).floatValue();
            return floatValue;
        }
    }

    public double getDouble(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.getDouble(this.mPos, i);
            }
            double doubleValue = ((Number) getUpdatedField(i)).doubleValue();
            return doubleValue;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        return r3;
     */
    public boolean isNull(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.isNull(this.mPos, i);
            }
            boolean z = getUpdatedField(i) == null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        return r3;
     */
    public boolean isBlob(int i) {
        boolean z;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.isBlob(this.mPos, i);
            }
            Object updatedField = getUpdatedField(i);
            if (updatedField != null) {
                if (!(updatedField instanceof byte[])) {
                    z = false;
                }
            }
            z = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        return r3;
     */
    public boolean isString(int i) {
        boolean z;
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.isString(this.mPos, i);
            }
            Object updatedField = getUpdatedField(i);
            if (updatedField != null) {
                if (!(updatedField instanceof String)) {
                    z = false;
                }
            }
            z = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        return r3;
     */
    public boolean isLong(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.isLong(this.mPos, i);
            }
            Object updatedField = getUpdatedField(i);
            boolean z = updatedField != null && ((updatedField instanceof Integer) || (updatedField instanceof Long));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        return r3;
     */
    public boolean isFloat(int i) {
        checkPosition();
        synchronized (this.mUpdatedRows) {
            if (!isFieldUpdated(i)) {
                return this.mWindow.isFloat(this.mPos, i);
            }
            Object updatedField = getUpdatedField(i);
            boolean z = updatedField != null && ((updatedField instanceof Float) || (updatedField instanceof Double));
        }
    }

    public int getType(int i) {
        checkPosition();
        return this.mWindow.getType(this.mPos, i);
    }

    /* access modifiers changed from: protected */
    public void checkPosition() {
        super.checkPosition();
        if (this.mWindow == null) {
            throw new StaleDataException("Access closed cursor");
        }
    }

    public CursorWindow getWindow() {
        return this.mWindow;
    }

    public void setWindow(CursorWindow cursorWindow) {
        CursorWindow cursorWindow2 = this.mWindow;
        if (cursorWindow2 != null) {
            cursorWindow2.close();
        }
        this.mWindow = cursorWindow;
    }

    public boolean hasWindow() {
        return this.mWindow != null;
    }
}
