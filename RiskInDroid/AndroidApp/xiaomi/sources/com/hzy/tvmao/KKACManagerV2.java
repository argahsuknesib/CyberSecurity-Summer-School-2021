package com.hzy.tvmao;

import android.util.SparseIntArray;
import com.hzy.tvmao.ir.encode.NormalCodeHelper;
import com.hzy.tvmao.utils.LogUtil;
import com.kookong.app.data.IrData;
import java.util.ArrayList;
import java.util.HashMap;

public class KKACManagerV2 extends BaseACManager {
    private NormalCodeHelper mCodeHelper;

    public void initIRData(int i, HashMap<Integer, String> hashMap, ArrayList<IrData.IrKey> arrayList) {
        super.initIRData(i, hashMap, arrayList);
        LogUtil.d("KKACManagerV2 initIRData");
        this.mAcStateV2 = null;
        onPause();
        this.mCodeHelper = new NormalCodeHelper(i, hashMap, createExpandKeyMap(arrayList));
    }

    public void onResume() {
        if (this.mCodeHelper == null && this.mExtMap != null) {
            this.mCodeHelper = new NormalCodeHelper(this.mRemoteId, this.mExtMap, createExpandKeyMap(this.mKeys));
        }
    }

    public void onPause() {
        NormalCodeHelper normalCodeHelper = this.mCodeHelper;
        if (normalCodeHelper != null) {
            normalCodeHelper.release();
            this.mCodeHelper = null;
        }
    }

    public String getACIRPattern() {
        int[][] iRPattern = getIRPattern();
        if (iRPattern == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iRPattern.length; i++) {
            for (int append : iRPattern[i]) {
                sb.append(append);
                sb.append(",");
            }
        }
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 1);
        }
        return null;
    }

    public int[] getACIRPatternIntArray() {
        int[][] iRPattern = getIRPattern();
        if (iRPattern == null || iRPattern.length <= 0) {
            return null;
        }
        return iRPattern[0];
    }

    private int[][] getIRPattern() {
        if (this.mCodeHelper == null) {
            return null;
        }
        SparseIntArray allExpandKeyState = getAllExpandKeyState();
        int[][] waveCodes = this.mCodeHelper.getWaveCodes(this.mAcStateV2.getCurPowerState(), this.mAcStateV2.getCurModelType(), this.mAcStateV2.getCurTemp(), this.mAcStateV2.getCurWindSpeed(), -1, this.mAcStateV2.getCurUDDirect(), functionId, null, allExpandKeyState);
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
        return waveCodes;
    }
}
