package com.hzy.tvmao;

import android.text.TextUtils;
import android.util.SparseIntArray;
import com.hzy.tvmao.ir.ac.ACExpandKey;
import com.hzy.tvmao.ir.ac.ACModelV2;
import com.hzy.tvmao.ir.ac.ACStateV2;
import com.hzy.tvmao.ir.ac.ACTimeKey;
import com.hzy.tvmao.utils.LogUtil;
import com.hzy.tvmao.utils.a;
import com.kookong.app.data.IrData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class BaseACManager {
    public static int functionId;
    public static List<Integer> upgradeList;
    protected ACStateV2 mAcStateV2;
    protected HashMap<Integer, String> mExtMap;
    protected ArrayList<IrData.IrKey> mKeys;
    protected int mRemoteId;

    public void initIRData(int i, HashMap<Integer, String> hashMap, ArrayList<IrData.IrKey> arrayList) {
        this.mRemoteId = i;
        this.mExtMap = hashMap;
        this.mKeys = arrayList;
    }

    /* access modifiers changed from: protected */
    public Map<Integer, Map<Integer, String>> createExpandKeyMap(ArrayList<IrData.IrKey> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<IrData.IrKey> it = arrayList.iterator();
        while (it.hasNext()) {
            IrData.IrKey next = it.next();
            hashMap.put(Integer.valueOf(next.fid), next.exts);
        }
        if (hashMap.size() == 0) {
            return null;
        }
        return hashMap;
    }

    public String getACStateV2InString() {
        return a.a(this.mAcStateV2);
    }

    public void setACStateV2FromString(String str) {
        if (!TextUtils.isEmpty(str)) {
            LogUtil.d("ACManagerV2: reading acstate!");
            try {
                this.mAcStateV2 = (ACStateV2) a.a(ACStateV2.class, str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mAcStateV2 == null) {
            LogUtil.d("ACManagerV2: initizalizing acstate!");
            this.mAcStateV2 = new ACStateV2(this.mExtMap);
        }
    }

    public boolean stateIsEmpty() {
        return this.mAcStateV2 == null;
    }

    public void changePowerState() {
        this.mAcStateV2.changePowerState();
    }

    public int getPowerState() {
        return this.mAcStateV2.getCurPowerState();
    }

    public ACModelV2 getACCurModel() {
        return this.mAcStateV2.getACCurModel();
    }

    public int getCurModelType() {
        return this.mAcStateV2.getCurModelType();
    }

    public void changeACModel() {
        this.mAcStateV2.changeModel();
    }

    public boolean changeACTargetModel(int i) {
        return this.mAcStateV2.changeToTargetModel(i);
    }

    public boolean isContainsTargetModel(int i) {
        return this.mAcStateV2.isContainsTargerModel(i);
    }

    public ACStateV2.UDWindDirectType getCurUDDirectType() {
        return this.mAcStateV2.getCurUDDirectType();
    }

    public int getCurUDDirect() {
        return this.mAcStateV2.getCurUDDirect();
    }

    public void changeUDWindDirect(ACStateV2.UDWindDirectKey uDWindDirectKey) {
        this.mAcStateV2.changeUDWindDirect(uDWindDirectKey);
    }

    public boolean setTargetUDWindDirect(int i) {
        return this.mAcStateV2.setTargetUDWindDirect(i);
    }

    public List<Integer> getUDWindDirectList() {
        return this.mAcStateV2.getUdWindDirectList();
    }

    public boolean isTempCanControl() {
        return this.mAcStateV2.tempIsCanControl();
    }

    public int getCurTemp() {
        return this.mAcStateV2.getCurTemp();
    }

    public int increaseTmp() {
        return this.mAcStateV2.increaseTmp();
    }

    public int decreaseTmp() {
        return this.mAcStateV2.decreaseTmp();
    }

    public boolean setTargetTemp(int i) {
        return this.mAcStateV2.setTemperature(i);
    }

    public int getMinTemp() {
        return this.mAcStateV2.modelMinTemp();
    }

    public int getMaxTemp() {
        return this.mAcStateV2.modelMaxTemp();
    }

    public boolean isWindSpeedCanControl() {
        return this.mAcStateV2.windSpeedIsCanControl();
    }

    public int getCurWindSpeed() {
        return this.mAcStateV2.getCurWindSpeed();
    }

    public int changeWindSpeed() {
        return this.mAcStateV2.changeWindSpeed();
    }

    public int setWindSpeedLevel(int i) {
        return this.mAcStateV2.setWindSpeedLevel(i);
    }

    public int windSpeedLevelUp() {
        return this.mAcStateV2.windSpeedLevelUp();
    }

    public int windSpeedLevelDown() {
        return this.mAcStateV2.windSpeedLevelDown();
    }

    public int getCurrentWindSpeedLevel() {
        return this.mAcStateV2.getCurrentWindSpeedLevel();
    }

    public int getMaxWindSpeedLevel() {
        return this.mAcStateV2.getMaxWindSpeedLevel();
    }

    public boolean setTargetWindSpeed(int i) {
        return this.mAcStateV2.setTargetWindSpeed(i);
    }

    public ArrayList<IrData.IrKey> getExpandKeys(ArrayList<IrData.IrKey> arrayList) {
        ACExpandKey aCExpandKey;
        ArrayList<IrData.IrKey> arrayList2 = new ArrayList<>();
        Map<Integer, ACExpandKey> expandKeyMap = getACCurModel().getExpandKeyMap();
        if (arrayList != null && arrayList.size() > 0 && expandKeyMap.size() > 0) {
            arrayList2 = new ArrayList<>();
            Iterator<IrData.IrKey> it = arrayList.iterator();
            while (it.hasNext()) {
                IrData.IrKey next = it.next();
                if (!(next.fid == 22 || next.fid == 9 || next.fid == 10 || (aCExpandKey = expandKeyMap.get(Integer.valueOf(next.fid))) == null || aCExpandKey.getSupportModelList().size() == 0)) {
                    arrayList2.add(next);
                }
            }
        }
        return arrayList2;
    }

    public ArrayList<IrData.IrKey> getExpandKeys() {
        ArrayList<IrData.IrKey> arrayList = new ArrayList<>();
        Map<Integer, ACExpandKey> expandKeyMap = getACCurModel().getExpandKeyMap();
        ArrayList<IrData.IrKey> arrayList2 = this.mKeys;
        if (arrayList2 != null && arrayList2.size() > 0 && expandKeyMap.size() > 0) {
            arrayList = new ArrayList<>();
            Iterator<IrData.IrKey> it = this.mKeys.iterator();
            while (it.hasNext()) {
                IrData.IrKey next = it.next();
                ACExpandKey aCExpandKey = expandKeyMap.get(Integer.valueOf(next.fid));
                if (!(aCExpandKey == null || aCExpandKey.getSupportModelList().size() == 0)) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public boolean isExpandCanUse(int i) {
        timeingCheck();
        if (i == 10 || i == 9) {
            return this.mAcStateV2.timingOnOrOffCanUse(i);
        }
        return this.mAcStateV2.isExpandKeyCanUse(i);
    }

    public boolean isUsedAtCurPower(int i) {
        return this.mAcStateV2.isUsedAtCurPower(i);
    }

    public boolean isUsedAcCurModel(int i) {
        return this.mAcStateV2.isUsedAtCurModel(i);
    }

    public List<Integer> getExpandKeyAllStates(int i) {
        return this.mAcStateV2.getExpandKeyAllStates(i);
    }

    public int getExpandKeyState(int i) {
        return this.mAcStateV2.getExpandKeyState(i);
    }

    public void changeExpandKeyState(int i) {
        this.mAcStateV2.changeExpandKeyState(i);
    }

    public boolean isExpandKeyCanClose(int i) {
        return this.mAcStateV2.isExpandKeyClosed(i);
    }

    public boolean isSingleStateKey(int i) {
        return this.mAcStateV2.isSingleStateKey(i);
    }

    public boolean isMoreTwoStateKey(int i) {
        return this.mAcStateV2.isMoreTwoStateKey(i);
    }

    public List<Integer> getExpandKeySupportModel(int i) {
        return this.mAcStateV2.getExpandKeySupportModel(i);
    }

    public boolean isTimeingCanUse() {
        return this.mAcStateV2.timeingIsCanUse();
    }

    public boolean isTimingBeenSet() {
        return this.mAcStateV2.timeIsHsBeenSet();
    }

    public void operateTimeing(int i) {
        this.mAcStateV2.operateTimeing(i);
    }

    public int getDisplayTime(int i) {
        return this.mAcStateV2.getDisplayTime(i);
    }

    public int increaseTime(int i) {
        return this.mAcStateV2.increaseTime(i);
    }

    public int decreaseTime(int i) {
        return this.mAcStateV2.decreaseTime(i);
    }

    public long getTimeingEndTime(int i) {
        return this.mAcStateV2.getTimeingEndTime(i);
    }

    public void timeingCheck() {
        this.mAcStateV2.timeingCheck();
    }

    /* access modifiers changed from: protected */
    public SparseIntArray getAllExpandKeyState() {
        int expandKeyState;
        SparseIntArray sparseIntArray = new SparseIntArray();
        for (Map.Entry<Integer, ACExpandKey> value : this.mAcStateV2.getExpandKeysMap().entrySet()) {
            ACExpandKey aCExpandKey = (ACExpandKey) value.getValue();
            if ((!aCExpandKey.keyIsSingleState() || functionId == aCExpandKey.getFid()) && (expandKeyState = aCExpandKey.getExpandKeyState(getPowerState(), this.mAcStateV2.getCurModelType())) != -1) {
                sparseIntArray.append(aCExpandKey.getFid(), expandKeyState);
            }
        }
        if (this.mAcStateV2.timeingIsCanUse()) {
            ACTimeKey curTimeKey = this.mAcStateV2.getCurTimeKey();
            int curSetTime = curTimeKey.getCurSetTime();
            int i = functionId;
            if (!(i == 10 || i == 9)) {
                curSetTime = this.mAcStateV2.cutTimeing();
            }
            sparseIntArray.append(curTimeKey.getFid(), curSetTime);
        }
        return sparseIntArray;
    }

    /* access modifiers changed from: protected */
    public String getStringByExpandKey(SparseIntArray sparseIntArray) {
        if (sparseIntArray == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < sparseIntArray.size(); i++) {
            int keyAt = sparseIntArray.keyAt(i);
            int i2 = sparseIntArray.get(keyAt);
            stringBuffer.append(keyAt);
            stringBuffer.append("=");
            stringBuffer.append(i2);
            stringBuffer.append("\n");
        }
        return stringBuffer.toString();
    }

    public boolean isUpgradeIR(IrData irData) {
        return upgradeList.contains(Integer.valueOf(irData.rid)) && irData.exts.containsKey(1511) && !irData.exts.containsKey(1518);
    }

    static {
        ArrayList arrayList = new ArrayList();
        upgradeList = arrayList;
        arrayList.add(2);
        upgradeList.add(2607);
        upgradeList.add(2877);
        upgradeList.add(6502);
        upgradeList.add(10727);
        upgradeList.add(10737);
        upgradeList.add(11672);
        upgradeList.add(11707);
        upgradeList.add(11717);
        upgradeList.add(11772);
        upgradeList.add(11862);
        upgradeList.add(11867);
        upgradeList.add(12250);
    }
}
