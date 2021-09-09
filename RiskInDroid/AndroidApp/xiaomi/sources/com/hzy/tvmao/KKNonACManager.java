package com.hzy.tvmao;

import android.util.SparseArray;
import com.hzy.tvmao.utils.StringUtil;
import com.kookong.app.data.IrData;
import java.util.ArrayList;
import java.util.Iterator;

public class KKNonACManager {
    private ArrayList<IrData.IrKey> keyList;
    private SparseArray<IrData.IrKey> keyMap;
    private int mFrequency;
    private int mRemoteId;
    private byte[] params = null;
    private boolean toggle = true;

    public KKNonACManager(IrData irData) {
        this.mRemoteId = irData.rid;
        this.mFrequency = irData.fre / 10;
        this.mFrequency *= 10;
        this.params = StringUtil.hex2Bytes(irData.exts.get(99999));
        this.keyList = irData.keys;
        this.keyMap = new SparseArray<>();
        Iterator<IrData.IrKey> it = irData.keys.iterator();
        while (it.hasNext()) {
            IrData.IrKey next = it.next();
            this.keyMap.put(next.fid, next);
        }
    }

    public ArrayList<IrData.IrKey> getAllKeys() {
        return this.keyList;
    }

    public int getRemoteId() {
        return this.mRemoteId;
    }

    public byte[] getParams() {
        return this.params;
    }

    public byte[] getKeyIr(int i) {
        IrData.IrKey irKey = this.keyMap.get(i);
        if (irKey == null) {
            return null;
        }
        String[] split = irKey.pulse.split("&");
        String str = split[0];
        if (split.length > 1) {
            if (!this.toggle) {
                str = split[1];
            }
            this.toggle = !this.toggle;
        }
        if (!str.contains(",")) {
            return StringUtil.hex2Bytes(str);
        }
        int i2 = 1000000 / this.mFrequency;
        int[] parseIntArray = StringUtil.parseIntArray(str);
        byte[] bArr = new byte[((parseIntArray.length * 2) + 1)];
        bArr[0] = 0;
        for (int i3 = 0; i3 < parseIntArray.length; i3++) {
            int i4 = parseIntArray[i3] / i2;
            int i5 = (i3 * 2) + 1;
            bArr[i5] = (byte) (i4 >> 8);
            bArr[i5 + 1] = (byte) (i4 & 255);
        }
        return bArr;
    }
}
