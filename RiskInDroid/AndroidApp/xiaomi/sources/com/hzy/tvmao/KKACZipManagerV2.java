package com.hzy.tvmao;

import android.util.SparseIntArray;
import com.hzy.tvmao.ir.encode.ZipCodeHelper;
import com.hzy.tvmao.utils.LogUtil;
import com.hzy.tvmao.utils.StringUtil;
import com.kookong.app.data.IrData;
import java.util.ArrayList;
import java.util.HashMap;

public class KKACZipManagerV2 extends BaseACManager {
    private ZipCodeHelper mCodeHelper;
    private int mFrequency;
    private byte[] params = null;

    public void initIRData(IrData irData) {
        initIRData(irData.rid, irData.fre, irData.exts, irData.keys);
    }

    public void initIRData(int i, int i2, HashMap<Integer, String> hashMap, ArrayList<IrData.IrKey> arrayList) {
        super.initIRData(i, hashMap, arrayList);
        LogUtil.d("KKACCpManagerV2 initIRData");
        this.mFrequency = i2;
        this.mAcStateV2 = null;
        this.params = null;
        onPause();
        this.mCodeHelper = new ZipCodeHelper(i, i2, hashMap, createExpandKeyMap(arrayList));
    }

    public int getRemoteId() {
        return this.mRemoteId;
    }

    public void onResume() {
        if (this.mCodeHelper == null && this.mExtMap != null) {
            this.mCodeHelper = new ZipCodeHelper(this.mRemoteId, this.mFrequency, this.mExtMap, createExpandKeyMap(this.mKeys));
        }
    }

    public void onPause() {
        ZipCodeHelper zipCodeHelper = this.mCodeHelper;
        if (zipCodeHelper != null) {
            zipCodeHelper.release();
            this.mCodeHelper = null;
        }
    }

    public byte[] getACKeyIr() {
        if (this.mCodeHelper == null) {
            return null;
        }
        SparseIntArray allExpandKeyState = getAllExpandKeyState();
        byte[] keyIr = this.mCodeHelper.getKeyIr(this.mAcStateV2.getCurPowerState(), this.mAcStateV2.getCurModelType(), this.mAcStateV2.getCurTemp(), this.mAcStateV2.getCurWindSpeed(), -1, this.mAcStateV2.getCurUDDirect(), functionId, null, allExpandKeyState);
        StringBuilder sb = new StringBuilder("power：");
        sb.append(this.mAcStateV2.getCurPowerState() == 1 ? "关" : "开");
        sb.append("\n模式：");
        sb.append(this.mAcStateV2.getCurModelType());
        sb.append("\n温度：");
        sb.append(this.mAcStateV2.getCurTemp());
        sb.append("\n风速：");
        sb.append(this.mAcStateV2.getCurWindSpeed());
        sb.append("\n风向：");
        sb.append(this.mAcStateV2.getCurUDDirect());
        sb.append("\n");
        sb.append(getStringByExpandKey(allExpandKeyState));
        sb.append("function：");
        sb.append(functionId);
        LogUtil.d(sb.toString());
        functionId = -1;
        return keyIr;
    }

    public byte[] getAcParams() {
        if (this.params == null) {
            this.params = StringUtil.hex2Bytes((String) this.mExtMap.get(99999));
        }
        return this.params;
    }
}
