package android.support.v4.util;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:608)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:241)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:122)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:43)
    */
public final class CircularArray<E> {
    private int mCapacityBitmask;
    private E[] mElements;
    private int mHead;
    private int mTail;

    /*  JADX ERROR: Method load error
        jadx.core.utils.exceptions.DecodeException: Load method exception: Method info already added: java.lang.Integer.highestOneBit(int):int in method: android.support.v4.util.CircularArray.<init>(int):void, dex: classes.dex
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:154)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:306)
        	at jadx.core.ProcessClass.process(ProcessClass.java:36)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:58)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:297)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:276)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Method info already added: java.lang.Integer.highestOneBit(int):int
        	at jadx.core.dex.info.InfoStorage.putMethod(InfoStorage.java:42)
        	at jadx.core.dex.info.MethodInfo.fromDex(MethodInfo.java:50)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:678)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:528)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:139)
        	... 5 more
        */
    public CircularArray(int r1) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 <= 0) goto L_0x002a
            r0 = 1073741824(0x40000000, float:2.0)
            if (r3 > r0) goto L_0x0022
            int r0 = java.lang.Integer.bitCount(r3)
            r1 = 1
            if (r0 == r1) goto L_0x0017
            int r3 = r3 + -1
            int r3 = java.lang.Integer.highestOneBit(r3)
            int r3 = r3 << r1
        L_0x0017:
            int r0 = r3 + -1
            r2.mCapacityBitmask = r0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Object[] r3 = (java.lang.Object[]) r3
            r2.mElements = r3
            return
        L_0x0022:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "capacity must be <= 2^30"
            r3.<init>(r0)
            throw r3
        L_0x002a:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "capacity must be >= 1"
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.CircularArray.<init>(int):void");
    }

    private void doubleCapacity() {
        E[] eArr = this.mElements;
        int length = eArr.length;
        int i = this.mHead;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 >= 0) {
            E[] eArr2 = new Object[i3];
            System.arraycopy(eArr, i, eArr2, 0, i2);
            System.arraycopy(this.mElements, 0, eArr2, i2, this.mHead);
            this.mElements = (Object[]) eArr2;
            this.mHead = 0;
            this.mTail = length;
            this.mCapacityBitmask = i3 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public CircularArray() {
        this(8);
    }

    public final void addFirst(E e) {
        this.mHead = (this.mHead - 1) & this.mCapacityBitmask;
        E[] eArr = this.mElements;
        int i = this.mHead;
        eArr[i] = e;
        if (i == this.mTail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e) {
        E[] eArr = this.mElements;
        int i = this.mTail;
        eArr[i] = e;
        this.mTail = this.mCapacityBitmask & (i + 1);
        if (this.mTail == this.mHead) {
            doubleCapacity();
        }
    }

    public final E popFirst() {
        int i = this.mHead;
        if (i != this.mTail) {
            E[] eArr = this.mElements;
            E e = eArr[i];
            eArr[i] = null;
            this.mHead = (i + 1) & this.mCapacityBitmask;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E popLast() {
        int i = this.mHead;
        int i2 = this.mTail;
        if (i != i2) {
            int i3 = this.mCapacityBitmask & (i2 - 1);
            E[] eArr = this.mElements;
            E e = eArr[i3];
            eArr[i3] = null;
            this.mTail = i3;
            return e;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final void removeFromStart(int i) {
        if (i > 0) {
            if (i <= size()) {
                int length = this.mElements.length;
                int i2 = this.mHead;
                if (i < length - i2) {
                    length = i2 + i;
                }
                for (int i3 = this.mHead; i3 < length; i3++) {
                    this.mElements[i3] = null;
                }
                int i4 = this.mHead;
                int i5 = length - i4;
                int i6 = i - i5;
                this.mHead = this.mCapacityBitmask & (i4 + i5);
                if (i6 > 0) {
                    for (int i7 = 0; i7 < i6; i7++) {
                        this.mElements[i7] = null;
                    }
                    this.mHead = i6;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final void removeFromEnd(int i) {
        int i2;
        if (i > 0) {
            if (i <= size()) {
                int i3 = 0;
                int i4 = this.mTail;
                if (i < i4) {
                    i3 = i4 - i;
                }
                int i5 = i3;
                while (true) {
                    i2 = this.mTail;
                    if (i5 >= i2) {
                        break;
                    }
                    this.mElements[i5] = null;
                    i5++;
                }
                int i6 = i2 - i3;
                int i7 = i - i6;
                this.mTail = i2 - i6;
                if (i7 > 0) {
                    this.mTail = this.mElements.length;
                    int i8 = this.mTail - i7;
                    for (int i9 = i8; i9 < this.mTail; i9++) {
                        this.mElements[i9] = null;
                    }
                    this.mTail = i8;
                    return;
                }
                return;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final E getFirst() {
        int i = this.mHead;
        if (i != this.mTail) {
            return this.mElements[i];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E getLast() {
        int i = this.mHead;
        int i2 = this.mTail;
        if (i != i2) {
            return this.mElements[(i2 - 1) & this.mCapacityBitmask];
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E get(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.mElements[this.mCapacityBitmask & (this.mHead + i)];
    }

    public final int size() {
        return (this.mTail - this.mHead) & this.mCapacityBitmask;
    }

    public final boolean isEmpty() {
        return this.mHead == this.mTail;
    }
}
