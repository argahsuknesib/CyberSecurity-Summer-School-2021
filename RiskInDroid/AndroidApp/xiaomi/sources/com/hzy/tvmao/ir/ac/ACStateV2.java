package com.hzy.tvmao.ir.ac;

import _m_j.ahr;
import android.text.TextUtils;
import com.hzy.tvmao.KKACManagerV2;
import com.hzy.tvmao.utils.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ACStateV2 implements Serializable {
    @ahr
    public static final int UDWINDDIRECT_AUTO = 0;
    private static final long serialVersionUID = 1;
    private List<ACAssociatedKey> configKeyList = new ArrayList();
    private int curIndex;
    private int curPowerState = 1;
    private int curUDDirect;
    private UDWindDirectType curUDDirectType;
    private List<ACModelV2> modelList = new ArrayList();
    private Map<Integer, ACTimeKey> timeingkeyMap = new HashMap();
    private List<Integer> udWindDirectList = new ArrayList();

    public enum UDWindDirectKey {
        UDDIRECT_KEY_SWING,
        UDDIRECT_KEY_FIX
    }

    public enum UDWindDirectType {
        UDDIRECT_ONLY_SWING,
        UDDIRECT_ONLY_FIX,
        UDDIRECT_FULL
    }

    public ACStateV2() {
    }

    public ACStateV2(Map<Integer, String> map) {
        initModel(map);
        initUDDirect(map.get(1506));
        initExpandKey(map.get(1515));
        initAssociationState(map.get(1517));
    }

    public ACStateV2(Map<Integer, String> map, int i) {
        this.curPowerState = i;
        initModel(map);
        initUDDirect(map.get(1506));
        initExpandKey(map.get(1515));
        initAssociationState(map.get(1517));
    }

    private void initModel(Map<Integer, String> map) {
        for (int i = 1501; i <= 1505; i++) {
            String str = map.get(Integer.valueOf(i));
            ACModelV2 aCModelV2 = new ACModelV2();
            if (TextUtils.isEmpty(str)) {
                aCModelV2.initMoel(i, "");
                this.modelList.add(aCModelV2);
            } else if (!str.contains("NA")) {
                aCModelV2.initMoel(i, str);
                this.modelList.add(aCModelV2);
            }
        }
        this.curIndex = 0;
    }

    private void initUDDirect(String str) {
        if (TextUtils.isEmpty(str)) {
            this.curUDDirectType = UDWindDirectType.UDDIRECT_FULL;
            this.udWindDirectList.add(1);
            this.curUDDirect = 0;
            return;
        }
        int[] parseIntArray = StringUtil.parseIntArray(str, ",");
        if (parseIntArray.length == 1) {
            if (parseIntArray[0] == 0) {
                this.curUDDirectType = UDWindDirectType.UDDIRECT_ONLY_SWING;
                this.curUDDirect = -1;
                return;
            }
            this.curUDDirectType = UDWindDirectType.UDDIRECT_ONLY_FIX;
            this.udWindDirectList.add(Integer.valueOf(parseIntArray[0]));
        } else if (parseIntArray.length <= 1) {
            return;
        } else {
            if (parseIntArray[0] == 0) {
                this.curUDDirectType = UDWindDirectType.UDDIRECT_FULL;
                this.curUDDirect = 0;
                for (int i = 1; i < parseIntArray.length; i++) {
                    this.udWindDirectList.add(Integer.valueOf(parseIntArray[i]));
                }
                return;
            }
            this.curUDDirectType = UDWindDirectType.UDDIRECT_ONLY_FIX;
            for (int valueOf : parseIntArray) {
                this.udWindDirectList.add(Integer.valueOf(valueOf));
            }
        }
        this.curUDDirect = this.udWindDirectList.get(0).intValue();
    }

    private void initExpandKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String split : str.split("@")) {
                String[] split2 = split.split("\\|");
                int parseInt = Integer.parseInt(split2[0]);
                if (parseInt == 9 || parseInt == 10) {
                    initTimeing(split2);
                } else {
                    initOtherKey(split2);
                }
            }
        }
    }

    private void initTimeing(String[] strArr) {
        ACTimeKey aCTimeKey = new ACTimeKey();
        aCTimeKey.setFid(Integer.parseInt(strArr[0]));
        String[] split = strArr[1].split("\\$");
        for (String split2 : split) {
            String[] split3 = split2.split("[-,]");
            int parseInt = Integer.parseInt(split3[0]);
            int parseInt2 = Integer.parseInt(split3[1]);
            if (split3.length == 3) {
                int parseInt3 = Integer.parseInt(split3[2]);
                if (parseInt == 0) {
                    parseInt = parseInt3;
                }
                addTimeRang(aCTimeKey, parseInt, parseInt2, parseInt3);
            } else {
                if (parseInt == 0) {
                    parseInt = 1;
                }
                addTimeRang(aCTimeKey, parseInt, parseInt2, 1);
            }
        }
        aCTimeKey.setCurSetTime(0);
        aCTimeKey.setTimeDisplayValue(aCTimeKey.getTimeRangeList().get(0).intValue());
        aCTimeKey.setTimeingEndTime(0);
        this.timeingkeyMap.put(Integer.valueOf(aCTimeKey.getFid()), aCTimeKey);
    }

    private void addTimeRang(ACTimeKey aCTimeKey, int i, int i2, int i3) {
        while (i <= i2) {
            aCTimeKey.getTimeRangeList().add(Integer.valueOf(i));
            i += i3;
        }
    }

    private void addStateRange(ACExpandKey aCExpandKey, int i, int i2, int i3) {
        while (i <= i2) {
            aCExpandKey.getStateRangeList().add(Integer.valueOf(i));
            i += i3;
        }
    }

    private void initOtherKey(String[] strArr) {
        for (ACModelV2 analyzeKey : this.modelList) {
            analyzeKey(strArr, analyzeKey);
        }
    }

    private void analyzeKey(String[] strArr, ACModelV2 aCModelV2) {
        if (Integer.parseInt(strArr[0]) > 7) {
            ACExpandKey aCExpandKey = new ACExpandKey();
            aCExpandKey.setFid(Integer.parseInt(strArr[0]));
            int i = 1;
            String[] split = strArr[1].split("[,-]");
            if (split.length > 2) {
                aCExpandKey.setMinState(Integer.parseInt(split[1]));
                aCExpandKey.setMaxState(Integer.parseInt(split[2]));
                aCExpandKey.setCurState(Integer.parseInt(split[0]));
                if (split.length > 3) {
                    i = Integer.parseInt(split[3]);
                }
            } else {
                aCExpandKey.setMinState(Integer.parseInt(split[0]));
                aCExpandKey.setMaxState(Integer.parseInt(split[1]));
                aCExpandKey.setCurState(Integer.parseInt(split[0]));
            }
            aCExpandKey.setSupportPower(Integer.parseInt(strArr[2]));
            addSupportModel(aCExpandKey, strArr[3]);
            aCModelV2.addExpandKey(aCExpandKey);
            addStateRange(aCExpandKey, aCExpandKey.getMinState(), aCExpandKey.getMaxState(), i);
        }
    }

    private void addSupportModel(ACExpandKey aCExpandKey, String str) {
        if (str.contains("C")) {
            aCExpandKey.getSupportModelList().add(0);
        }
        if (str.contains("H")) {
            aCExpandKey.getSupportModelList().add(1);
        }
        if (str.contains("A")) {
            aCExpandKey.getSupportModelList().add(2);
        }
        if (str.contains("F")) {
            aCExpandKey.getSupportModelList().add(3);
        }
        if (str.contains("D")) {
            aCExpandKey.getSupportModelList().add(4);
        }
    }

    private void initAssociationState(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("\\|")) {
                boolean contains = str2.contains("@");
                ACAssociatedKey aCAssociatedKey = new ACAssociatedKey();
                aCAssociatedKey.setContainsPrimary(contains);
                String[] split = str2.split("[\\$@]");
                for (String parseInt : split[0].split(",")) {
                    aCAssociatedKey.getPrimaryList().add(Integer.valueOf(Integer.parseInt(parseInt)));
                }
                String[] split2 = split[1].split("[&\\*]");
                aCAssociatedKey.setConfigId(Integer.parseInt(split2[0]));
                aCAssociatedKey.setTargetState(Integer.parseInt(split2[2]));
                String[] split3 = split2[1].split("-");
                aCAssociatedKey.setMinState(Integer.parseInt(split3[0]));
                aCAssociatedKey.setMaxState(Integer.parseInt(split3[1]));
                this.configKeyList.add(aCAssociatedKey);
            }
        }
    }

    public void changePowerState() {
        cancleKeyFunctionByPowerChange();
        int i = 1;
        KKACManagerV2.functionId = 1;
        changeKeyStateByFunction(1);
        if (this.curPowerState == 1) {
            i = 0;
        }
        this.curPowerState = i;
    }

    public void changeModel() {
        KKACManagerV2.functionId = 2;
        changeKeyStateByFunction(2);
        this.curIndex++;
        this.curIndex = this.curIndex < this.modelList.size() ? this.curIndex : 0;
    }

    public boolean changeToTargetModel(int i) {
        if (!isContainsTargerModel(i)) {
            return false;
        }
        KKACManagerV2.functionId = 2;
        changeKeyStateByFunction(2);
        for (int i2 = 0; i2 < this.modelList.size(); i2++) {
            if (i == this.modelList.get(i2).getModelType()) {
                this.curIndex = i2;
                return true;
            }
        }
        return true;
    }

    public boolean isContainsTargerModel(int i) {
        for (int i2 = 0; i2 < this.modelList.size(); i2++) {
            if (i == this.modelList.get(i2).getModelType()) {
                return true;
            }
        }
        return false;
    }

    @ahr
    public ACModelV2 getACCurModel() {
        return this.modelList.get(this.curIndex);
    }

    @ahr
    public int getCurModelType() {
        return getACCurModel().getModelType();
    }

    public boolean setTemperature(int i) {
        ACModelV2 aCCurModel = getACCurModel();
        if (!aCCurModel.isTempCanControl() || !aCCurModel.isContainsTmp(i)) {
            return false;
        }
        if (i > aCCurModel.getCurTmp()) {
            KKACManagerV2.functionId = 3;
            changeKeyStateByFunction(3);
        } else {
            KKACManagerV2.functionId = 4;
            changeKeyStateByFunction(4);
        }
        aCCurModel.setCurTmp(i);
        return true;
    }

    private void changeTemperatureToTarget(int i) {
        ACModelV2 aCCurModel = getACCurModel();
        if (aCCurModel.isTempCanControl() && aCCurModel.isContainsTmp(i)) {
            aCCurModel.setCurTmp(i);
        }
    }

    public int increaseTmp() {
        ACModelV2 aCCurModel = getACCurModel();
        if (!aCCurModel.isTempCanControl()) {
            return -1;
        }
        KKACManagerV2.functionId = 3;
        changeKeyStateByFunction(3);
        int curTmp = aCCurModel.getCurTmp() + 1;
        if (curTmp >= aCCurModel.getHighTmp()) {
            curTmp = aCCurModel.getHighTmp();
        }
        aCCurModel.setCurTmp(curTmp);
        return curTmp;
    }

    public int decreaseTmp() {
        ACModelV2 aCCurModel = getACCurModel();
        if (!aCCurModel.isTempCanControl()) {
            return -1;
        }
        KKACManagerV2.functionId = 4;
        changeKeyStateByFunction(4);
        int curTmp = aCCurModel.getCurTmp() - 1;
        if (curTmp <= aCCurModel.getLowTmp()) {
            curTmp = aCCurModel.getLowTmp();
        }
        aCCurModel.setCurTmp(curTmp);
        return curTmp;
    }

    public boolean tempIsCanControl() {
        return getACCurModel().isTempCanControl();
    }

    @ahr
    public int getCurTemp() {
        return getACCurModel().getCurTmp();
    }

    public int modelMinTemp() {
        ACModelV2 aCCurModel = getACCurModel();
        if (aCCurModel.isTempCanControl()) {
            return aCCurModel.getLowTmp();
        }
        return -1;
    }

    public int modelMaxTemp() {
        ACModelV2 aCCurModel = getACCurModel();
        if (aCCurModel.isTempCanControl()) {
            return aCCurModel.getHighTmp();
        }
        return -1;
    }

    public int changeWindSpeed() {
        ACModelV2 aCCurModel = getACCurModel();
        if (!aCCurModel.isWindSpeedCanControl()) {
            return -1;
        }
        KKACManagerV2.functionId = 5;
        changeKeyStateByFunction(5);
        int indexOf = aCCurModel.getWindSpeedList().indexOf(String.valueOf(aCCurModel.getCurWindSpeed())) + 1;
        List<String> windSpeedList = aCCurModel.getWindSpeedList();
        if (indexOf >= aCCurModel.getWindSpeedList().size()) {
            indexOf = 0;
        }
        int parseInt = Integer.parseInt(windSpeedList.get(indexOf));
        aCCurModel.setCurWindSpeed(parseInt);
        return parseInt;
    }

    @ahr
    public int getMaxWindSpeedLevel() {
        return getACCurModel().getWindSpeedList().size() - 1;
    }

    @ahr
    public int getCurrentWindSpeedLevel() {
        List<String> windSpeedList = getACCurModel().getWindSpeedList();
        StringBuilder sb = new StringBuilder();
        sb.append(getACCurModel().getCurWindSpeed());
        return windSpeedList.indexOf(sb.toString());
    }

    public int windSpeedLevelUp() {
        int currentWindSpeedLevel = getCurrentWindSpeedLevel();
        int maxWindSpeedLevel = getMaxWindSpeedLevel();
        if (currentWindSpeedLevel < maxWindSpeedLevel) {
            maxWindSpeedLevel = currentWindSpeedLevel + 1;
        }
        setWindSpeedLevel(maxWindSpeedLevel);
        return maxWindSpeedLevel;
    }

    public int windSpeedLevelDown() {
        int currentWindSpeedLevel = getCurrentWindSpeedLevel();
        int i = currentWindSpeedLevel > 0 ? currentWindSpeedLevel - 1 : 0;
        setWindSpeedLevel(i);
        return i;
    }

    public int setWindSpeedLevel(int i) {
        ACModelV2 aCCurModel = getACCurModel();
        if (!aCCurModel.isWindSpeedCanControl()) {
            return -1;
        }
        KKACManagerV2.functionId = 5;
        changeKeyStateByFunction(5);
        if (i < 0 || i > getMaxWindSpeedLevel()) {
            return -1;
        }
        int parseInt = Integer.parseInt(aCCurModel.getWindSpeedList().get(i));
        aCCurModel.setCurWindSpeed(parseInt);
        return parseInt;
    }

    public boolean windSpeedIsCanControl() {
        return getACCurModel().isWindSpeedCanControl();
    }

    public boolean setTargetWindSpeed(int i) {
        ACModelV2 aCCurModel = getACCurModel();
        if (!aCCurModel.isWindSpeedCanControl() || !aCCurModel.isContainsTargetWS(i)) {
            return false;
        }
        KKACManagerV2.functionId = 5;
        changeKeyStateByFunction(5);
        aCCurModel.setCurWindSpeed(i);
        return true;
    }

    private void setTargetWindSpeedNoSend(int i) {
        ACModelV2 aCCurModel = getACCurModel();
        if (aCCurModel.isWindSpeedCanControl() && aCCurModel.isContainsTargetWS(i)) {
            aCCurModel.setCurWindSpeed(i);
        }
    }

    @ahr
    public int getCurWindSpeed() {
        return getACCurModel().getCurWindSpeed();
    }

    /* renamed from: com.hzy.tvmao.ir.ac.ACStateV2$1  reason: invalid class name */
    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hzy$tvmao$ir$ac$ACStateV2$UDWindDirectType = new int[UDWindDirectType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$hzy$tvmao$ir$ac$ACStateV2$UDWindDirectType[UDWindDirectType.UDDIRECT_ONLY_SWING.ordinal()] = 1;
            $SwitchMap$com$hzy$tvmao$ir$ac$ACStateV2$UDWindDirectType[UDWindDirectType.UDDIRECT_ONLY_FIX.ordinal()] = 2;
            try {
                $SwitchMap$com$hzy$tvmao$ir$ac$ACStateV2$UDWindDirectType[UDWindDirectType.UDDIRECT_FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void changeUDWindDirect(UDWindDirectKey uDWindDirectKey) {
        int i = AnonymousClass1.$SwitchMap$com$hzy$tvmao$ir$ac$ACStateV2$UDWindDirectType[this.curUDDirectType.ordinal()];
        if (i == 1) {
            return;
        }
        if (i != 2) {
            if (i == 3) {
                udDirectFullChange(uDWindDirectKey);
            }
        } else if (uDWindDirectKey == UDWindDirectKey.UDDIRECT_KEY_FIX) {
            udDirectFixChange();
        }
    }

    public boolean setTargetUDWindDirect(int i) {
        if (this.curUDDirectType == UDWindDirectType.UDDIRECT_ONLY_SWING) {
            return false;
        }
        if (this.curUDDirectType == UDWindDirectType.UDDIRECT_ONLY_FIX) {
            setUdDirectFix(i);
            return true;
        }
        if (this.curUDDirectType == UDWindDirectType.UDDIRECT_FULL) {
            setUdDirectFix(i);
        }
        return true;
    }

    private void setUdDirectFix(int i) {
        if (i == 0) {
            this.curUDDirect = 0;
            KKACManagerV2.functionId = 6;
            return;
        }
        int indexOf = this.udWindDirectList.indexOf(Integer.valueOf(i));
        if (indexOf == -1) {
            indexOf = 0;
        }
        this.curUDDirect = this.udWindDirectList.get(indexOf).intValue();
        KKACManagerV2.functionId = 7;
    }

    private void udDirectFixChange() {
        KKACManagerV2.functionId = 7;
        changeKeyStateByFunction(7);
        int indexOf = this.udWindDirectList.indexOf(Integer.valueOf(this.curUDDirect)) + 1;
        List<Integer> list = this.udWindDirectList;
        if (indexOf >= list.size()) {
            indexOf = 0;
        }
        this.curUDDirect = list.get(indexOf).intValue();
    }

    private void udDirectFullChange(UDWindDirectKey uDWindDirectKey) {
        if (this.curUDDirect == 0) {
            KKACManagerV2.functionId = 7;
            changeKeyStateByFunction(7);
            this.curUDDirect = this.udWindDirectList.get(0).intValue();
        } else if (uDWindDirectKey == UDWindDirectKey.UDDIRECT_KEY_SWING) {
            KKACManagerV2.functionId = 6;
            changeKeyStateByFunction(6);
            this.curUDDirect = 0;
        } else {
            udDirectFixChange();
        }
    }

    private ACExpandKey getExpandKeyById(int i) {
        return getACCurModel().getExpandKeyByFid(i);
    }

    public void changeExpandKeyState(int i) {
        ACExpandKey expandKeyById = getExpandKeyById(i);
        if (expandKeyById != null) {
            KKACManagerV2.functionId = i;
            if (expandKeyById.keyIsSingleState() || !expandKeyById.keyIsSupportClose() || expandKeyById.getCurState() == 0) {
                changeKeyStateByFunction(i);
            }
            expandKeyById.changeState(this.curPowerState, getCurModelType());
        }
    }

    public boolean isUsedAtCurPower(int i) {
        ACExpandKey expandKeyById = getExpandKeyById(i);
        if (expandKeyById == null) {
            return false;
        }
        return expandKeyById.isUsedAtPower(this.curPowerState);
    }

    public boolean isExpandKeyCanUse(int i) {
        ACExpandKey expandKeyById = getExpandKeyById(i);
        if (expandKeyById == null) {
            return false;
        }
        return expandKeyById.isCanUsed(this.curPowerState, getCurModelType());
    }

    public boolean isUsedAtCurModel(int i) {
        ACExpandKey expandKeyById = getExpandKeyById(i);
        if (expandKeyById == null) {
            return false;
        }
        return expandKeyById.isSupportModel(getCurModelType());
    }

    public List<Integer> getExpandKeySupportModel(int i) {
        ACExpandKey expandKeyById = getExpandKeyById(i);
        if (expandKeyById == null) {
            return null;
        }
        return expandKeyById.getSupportModelList();
    }

    public int getExpandKeyState(int i) {
        ACExpandKey expandKeyById = getExpandKeyById(i);
        if (expandKeyById == null) {
            return -1;
        }
        return expandKeyById.getExpandKeyState(this.curPowerState, getCurModelType());
    }

    public boolean isExpandKeyClosed(int i) {
        ACExpandKey expandKeyById = getExpandKeyById(i);
        if (expandKeyById == null) {
            return true;
        }
        return expandKeyById.keyIsSupportClose();
    }

    public boolean isMoreTwoStateKey(int i) {
        ACExpandKey expandKeyById = getExpandKeyById(i);
        if (expandKeyById == null) {
            return false;
        }
        return expandKeyById.keyIsManyState();
    }

    public boolean isSingleStateKey(int i) {
        ACExpandKey expandKeyById = getExpandKeyById(i);
        if (expandKeyById == null) {
            return false;
        }
        return expandKeyById.keyIsSingleState();
    }

    @ahr
    public Map<Integer, ACExpandKey> getExpandKeysMap() {
        return getACCurModel().getExpandKeyMap();
    }

    @ahr
    public ACTimeKey getCurTimeKey() {
        if (this.curPowerState == 0) {
            return this.timeingkeyMap.get(10);
        }
        return this.timeingkeyMap.get(9);
    }

    public boolean timeingIsCanUse() {
        if (this.timeingkeyMap.size() == 0) {
            return false;
        }
        if (getCurPowerState() == 1) {
            return this.timeingkeyMap.containsKey(9);
        }
        if (getCurPowerState() == 0) {
            return this.timeingkeyMap.containsKey(10);
        }
        return false;
    }

    public boolean timingOnOrOffCanUse(int i) {
        if (this.timeingkeyMap.size() == 0) {
            return false;
        }
        if (i == 9) {
            if (getCurPowerState() == 0) {
                return false;
            }
            return this.timeingkeyMap.containsKey(9);
        } else if (i != 10 || getCurPowerState() == 1) {
            return false;
        } else {
            return this.timeingkeyMap.containsKey(10);
        }
    }

    public boolean timeIsHsBeenSet() {
        if (!timeingIsCanUse()) {
            return false;
        }
        return getCurTimeKey().timeIsHaveRegular();
    }

    public void operateTimeing(int i) {
        ACTimeKey aCTimeKey;
        if (i != -1) {
            if (timingOnOrOffCanUse(i)) {
                aCTimeKey = this.timeingkeyMap.get(Integer.valueOf(i));
            } else {
                return;
            }
        } else if (timeingIsCanUse()) {
            aCTimeKey = getCurTimeKey();
        } else {
            return;
        }
        KKACManagerV2.functionId = aCTimeKey.getFid();
        if (aCTimeKey.timeIsHaveRegular()) {
            aCTimeKey.cancleTimeing();
            return;
        }
        changeKeyStateByFunction(aCTimeKey.getFid());
        aCTimeKey.addTimeing();
    }

    private void cancleTimeing() {
        if (timeingIsCanUse()) {
            getCurTimeKey().cancleTimeing();
        }
    }

    @ahr
    public int getDisplayTime(int i) {
        ACTimeKey aCTimeKey;
        if (i != -1) {
            if (!timingOnOrOffCanUse(i)) {
                return -1;
            }
            aCTimeKey = this.timeingkeyMap.get(Integer.valueOf(i));
        } else if (!timeingIsCanUse()) {
            return -1;
        } else {
            aCTimeKey = getCurTimeKey();
        }
        return aCTimeKey.getTimeDisplayValue();
    }

    public synchronized int increaseTime(int i) {
        ACTimeKey aCTimeKey;
        if (i != -1) {
            if (!timingOnOrOffCanUse(i)) {
                return -1;
            }
            aCTimeKey = this.timeingkeyMap.get(Integer.valueOf(i));
        } else if (!timeingIsCanUse()) {
            return -1;
        } else {
            aCTimeKey = getCurTimeKey();
        }
        return aCTimeKey.increaseTime();
    }

    public synchronized int decreaseTime(int i) {
        ACTimeKey aCTimeKey;
        if (i != -1) {
            if (!timingOnOrOffCanUse(i)) {
                return -1;
            }
            aCTimeKey = this.timeingkeyMap.get(Integer.valueOf(i));
        } else if (!timeingIsCanUse()) {
            return -1;
        } else {
            aCTimeKey = getCurTimeKey();
        }
        return aCTimeKey.decreaseTime();
    }

    @ahr
    public long getTimeingEndTime(int i) {
        ACTimeKey aCTimeKey;
        if (i != -1) {
            if (!timingOnOrOffCanUse(i)) {
                return 0;
            }
            aCTimeKey = this.timeingkeyMap.get(Integer.valueOf(i));
        } else if (!timeingIsCanUse()) {
            return 0;
        } else {
            aCTimeKey = getCurTimeKey();
        }
        return aCTimeKey.getTimeingEndTime();
    }

    public int cutTimeing() {
        if (!timeingIsCanUse()) {
            return -1;
        }
        return getCurTimeKey().cutTimeing();
    }

    public void timeingCheck() {
        if (timeingIsCanUse()) {
            getCurTimeKey().timingCheck();
        }
    }

    private void cancleKeyFunctionByPowerChange() {
        cancleTimeing();
        ACExpandKey expandKeyById = getExpandKeyById(22);
        if (expandKeyById != null && expandKeyById.isCanUsed(this.curPowerState, getCurModelType())) {
            expandKeyById.changeToTargetState(0);
        }
    }

    private void changeKeyStateByFunction(int i) {
        if (this.configKeyList.size() != 0) {
            for (ACAssociatedKey next : this.configKeyList) {
                if (!next.isContainsPrimary() || !next.isWithinPryKeyScope(i) || i == next.getConfigId()) {
                    if (!next.isContainsPrimary() && !next.isWithinPryKeyScope(i) && i != next.getConfigId()) {
                        if (next.getConfigId() == 10 || next.getConfigId() == 9) {
                            ACTimeKey curTimeKey = getCurTimeKey();
                            if (curTimeKey != null && next.isWithinScope(curTimeKey.getCurSetTime())) {
                                curTimeKey.cancleTimeing();
                            }
                        } else if (next.getConfigId() == 5 && next.isWithinScope(getACCurModel().getCurWindSpeed())) {
                            setTargetWindSpeedNoSend(next.getTargetState());
                        } else if (next.getConfigId() != 3 || i == 4) {
                            ACExpandKey expandKeyByFid = getACCurModel().getExpandKeyByFid(next.getConfigId());
                            if (!(expandKeyByFid == null || expandKeyByFid == null || !next.isWithinScope(expandKeyByFid.getCurState()))) {
                                expandKeyByFid.changeToTargetState(next.getTargetState());
                            }
                        } else {
                            changeTemperatureToTarget(next.getTargetState());
                        }
                    }
                } else if (next.getConfigId() == 10 || next.getConfigId() == 9) {
                    ACTimeKey curTimeKey2 = getCurTimeKey();
                    if (curTimeKey2 != null && next.isWithinScope(curTimeKey2.getCurSetTime())) {
                        curTimeKey2.cancleTimeing();
                    }
                } else if (next.getConfigId() == 5 && next.isWithinScope(getACCurModel().getCurWindSpeed())) {
                    setTargetWindSpeedNoSend(next.getTargetState());
                } else if (next.getConfigId() == 3) {
                    changeTemperatureToTarget(next.getTargetState());
                } else {
                    ACExpandKey expandKeyByFid2 = getACCurModel().getExpandKeyByFid(next.getConfigId());
                    if (expandKeyByFid2 != null && next.isWithinScope(expandKeyByFid2.getCurState())) {
                        expandKeyByFid2.changeToTargetState(next.getTargetState());
                    }
                }
            }
        }
    }

    public List<Integer> getExpandKeyAllStates(int i) {
        ACExpandKey expandKeyById;
        if (i == 10 || i == 9 || (expandKeyById = getExpandKeyById(i)) == null) {
            return null;
        }
        return expandKeyById.getStateRangeList();
    }

    public Map<Integer, ACTimeKey> getTimeingkeyMap() {
        return this.timeingkeyMap;
    }

    public void setTimeingkeyMap(Map<Integer, ACTimeKey> map) {
        this.timeingkeyMap = map;
    }

    public int getCurPowerState() {
        return this.curPowerState;
    }

    public int getCurUDDirect() {
        return this.curUDDirect;
    }

    public UDWindDirectType getCurUDDirectType() {
        return this.curUDDirectType;
    }

    public List<ACModelV2> getModelList() {
        return this.modelList;
    }

    public void setModelList(List<ACModelV2> list) {
        this.modelList = list;
    }

    public List<Integer> getUdWindDirectList() {
        return this.udWindDirectList;
    }

    public void setUdWindDirectList(List<Integer> list) {
        this.udWindDirectList = list;
    }

    public void setCurPowerState(int i) {
        this.curPowerState = i;
    }

    public void setCurUDDirect(int i) {
        this.curUDDirect = i;
    }

    public void setCurUDDirectType(UDWindDirectType uDWindDirectType) {
        this.curUDDirectType = uDWindDirectType;
    }

    public List<ACAssociatedKey> getConfigKeyList() {
        return this.configKeyList;
    }

    public void setConfigKeyList(List<ACAssociatedKey> list) {
        this.configKeyList = list;
    }

    public int getCurIndex() {
        return this.curIndex;
    }

    public void setCurIndex(int i) {
        this.curIndex = i;
    }
}
