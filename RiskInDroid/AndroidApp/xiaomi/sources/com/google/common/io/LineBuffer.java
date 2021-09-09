package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@GwtIncompatible
abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    /* access modifiers changed from: protected */
    public abstract void handleLine(String str, String str2) throws IOException;

    LineBuffer() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
    public void add(char[] cArr, int i, int i2) throws IOException {
        int i3;
        int i4;
        if (this.sawReturn && i2 > 0) {
            if (finishLine(cArr[i] == 10)) {
                i3 = i + 1;
                i4 = i + i2;
                int i5 = i3;
                while (i3 < i4) {
                    char c = cArr[i3];
                    if (c == 10) {
                        this.line.append(cArr, i5, i3 - i5);
                        finishLine(true);
                    } else if (c != 13) {
                        i3++;
                    } else {
                        this.line.append(cArr, i5, i3 - i5);
                        this.sawReturn = true;
                        int i6 = i3 + 1;
                        if (i6 < i4) {
                            if (finishLine(cArr[i6] == 10)) {
                                i3 = i6;
                            }
                        }
                    }
                    i5 = i3 + 1;
                    i3++;
                }
                this.line.append(cArr, i5, i4 - i5);
            }
        }
        i3 = i;
        i4 = i + i2;
        int i52 = i3;
        while (i3 < i4) {
        }
        this.line.append(cArr, i52, i4 - i52);
    }

    @CanIgnoreReturnValue
    private boolean finishLine(boolean z) throws IOException {
        handleLine(this.line.toString(), this.sawReturn ? z ? "\r\n" : "\r" : z ? "\n" : "");
        this.line = new StringBuilder();
        this.sawReturn = false;
        return z;
    }

    /* access modifiers changed from: protected */
    public void finish() throws IOException {
        if (this.sawReturn || this.line.length() > 0) {
            finishLine(false);
        }
    }
}
