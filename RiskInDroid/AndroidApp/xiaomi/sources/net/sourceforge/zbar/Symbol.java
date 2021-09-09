package net.sourceforge.zbar;

public class Symbol {
    private long peer;
    private int type;

    private native void destroy(long j);

    private native long getComponents(long j);

    private native int getLocationSize(long j);

    private native int getLocationX(long j, int i);

    private native int getLocationY(long j, int i);

    private native int getType(long j);

    private static native void init();

    public native int getConfigMask();

    public native int getCount();

    public native String getData();

    public native byte[] getDataBytes();

    public native int getModifierMask();

    public native int getOrientation();

    public native int getQuality();

    /* access modifiers changed from: package-private */
    public native long next();

    static {
        System.loadLibrary("ZBarDecoder");
        init();
    }

    Symbol(long j) {
        this.peer = j;
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        destroy();
    }

    public synchronized void destroy() {
        if (this.peer != 0) {
            destroy(this.peer);
            this.peer = 0;
        }
    }

    public int getType() {
        if (this.type == 0) {
            this.type = getType(this.peer);
        }
        return this.type;
    }

    public int[] getBounds() {
        int locationSize = getLocationSize(this.peer);
        if (locationSize <= 0) {
            return null;
        }
        int[] iArr = new int[4];
        int i = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < locationSize; i5++) {
            int locationX = getLocationX(this.peer, i5);
            if (i > locationX) {
                i = locationX;
            }
            if (i3 < locationX) {
                i3 = locationX;
            }
            int locationY = getLocationY(this.peer, i5);
            if (i2 > locationY) {
                i2 = locationY;
            }
            if (i4 < locationY) {
                i4 = locationY;
            }
        }
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3 - i;
        iArr[3] = i4 - i2;
        return iArr;
    }

    public int[] getLocationPoint(int i) {
        return new int[]{getLocationX(this.peer, i), getLocationY(this.peer, i)};
    }

    public SymbolSet getComponents() {
        return new SymbolSet(getComponents(this.peer));
    }
}
