package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class RcTestRemoteKey implements SerializableEx, Comparable<RcTestRemoteKey> {
    protected String dataCode;
    protected String displayName;
    protected int formatId;
    protected int frequency;
    protected String fullCode;
    protected int functionId;
    protected String functionName;
    protected String pulseData;
    protected int rank;
    protected String remoteIds;
    protected List<RcRemoteKeyExt> remoteKeyExtList = new ArrayList();
    protected int remoteKeyId;
    protected int repeatCount;
    protected short repeatType;
    protected String systemCode;
    protected short type;

    public int getRemoteKeyId() {
        return this.remoteKeyId;
    }

    public void setRemoteKeyId(int i) {
        this.remoteKeyId = i;
    }

    public String getRemoteIds() {
        return this.remoteIds;
    }

    public void setRemoteIds(String str) {
        this.remoteIds = str;
    }

    public int getFunctionId() {
        return this.functionId;
    }

    public void setFunctionId(int i) {
        this.functionId = i;
    }

    public String getFunctionName() {
        return this.functionName;
    }

    public void setFunctionName(String str) {
        this.functionName = str;
    }

    public short getRepeatType() {
        return this.repeatType;
    }

    public void setRepeatType(short s) {
        this.repeatType = s;
    }

    public int getRepeatCount() {
        return this.repeatCount;
    }

    public void setRepeatCount(int i) {
        this.repeatCount = i;
    }

    public int getFormatId() {
        return this.formatId;
    }

    public void setFormatId(int i) {
        this.formatId = i;
    }

    public String getSystemCode() {
        return this.systemCode;
    }

    public void setSystemCode(String str) {
        this.systemCode = str;
    }

    public String getDataCode() {
        return this.dataCode;
    }

    public void setDataCode(String str) {
        this.dataCode = str;
    }

    public String getFullCode() {
        return this.fullCode;
    }

    public void setFullCode(String str) {
        this.fullCode = str;
    }

    public String getPulseData() {
        return this.pulseData;
    }

    public void setPulseData(String str) {
        this.pulseData = str;
    }

    public List<RcRemoteKeyExt> getRemoteKeyExtList() {
        return this.remoteKeyExtList;
    }

    public void setRemoteKeyExtList(List<RcRemoteKeyExt> list) {
        this.remoteKeyExtList = list;
    }

    public short getType() {
        return this.type;
    }

    public void setType(short s) {
        this.type = s;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int i) {
        this.frequency = i;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public int getRank() {
        return this.rank;
    }

    public void setRank(int i) {
        this.rank = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#com.kookong.app.data.RcTestRemoteKey\n");
        stringBuffer.append("frequency=" + this.frequency + "\n");
        stringBuffer.append("type=" + ((int) this.type) + "\n");
        stringBuffer.append("remoteKeyId=" + this.remoteKeyId + "\n");
        stringBuffer.append("remoteIds=" + this.remoteIds + "\n");
        stringBuffer.append("functionId=" + this.functionId + "\n");
        stringBuffer.append("functionName=" + this.functionName + "\n");
        stringBuffer.append("displayName=" + this.displayName + "\n");
        stringBuffer.append("repeatType=" + ((int) this.repeatType) + "\n");
        stringBuffer.append("repeatCount=" + this.repeatCount + "\n");
        stringBuffer.append("formatId=" + this.formatId + "\n");
        stringBuffer.append("systemCode=" + this.systemCode + "\n");
        stringBuffer.append("dataCode=" + this.dataCode + "\n");
        stringBuffer.append("fullCode=" + this.fullCode + "\n");
        stringBuffer.append("pulseData=" + this.pulseData + "\n");
        stringBuffer.append("rank=" + this.rank + "\n");
        stringBuffer.append("remoteKeyExtList=" + this.remoteKeyExtList + "\n");
        return stringBuffer.toString();
    }

    public int compareTo(RcTestRemoteKey rcTestRemoteKey) {
        int length = rcTestRemoteKey.getRemoteIds().split(",").length - getRemoteIds().split(",").length;
        int i = rcTestRemoteKey.rank - this.rank;
        if (i < 0) {
            return 1;
        }
        if (i == 0) {
            if (length > 0) {
                return 1;
            }
            if (length == 0) {
                return 0;
            }
        }
        return -1;
    }
}
