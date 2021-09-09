package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class RcTestRemoteKeyV3 implements SerializableEx, Comparable<RcTestRemoteKeyV3> {
    private static final long serialVersionUID = -4648818445422729544L;
    public String displayName;
    public int frequency;
    public int functionId;
    public String functionName;
    public String pulseData;
    public int rank;
    public String remoteIds;
    public List<RcRemoteKeyExt> remoteKeyExtList = new ArrayList();

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("#com.kookong.app.data.RcTestRemoteKey\n");
        stringBuffer.append("remoteIds=" + this.remoteIds + "\n");
        stringBuffer.append("frequency=" + this.frequency + "\n");
        stringBuffer.append("functionId=" + this.functionId + "\n");
        stringBuffer.append("functionName=" + this.functionName + "\n");
        stringBuffer.append("displayName=" + this.displayName + "\n");
        stringBuffer.append("pulseData=" + this.pulseData + "\n");
        stringBuffer.append("rank=" + this.rank + "\n");
        stringBuffer.append("remoteKeyExtList=" + this.remoteKeyExtList + "\n");
        return stringBuffer.toString();
    }

    public int compareTo(RcTestRemoteKeyV3 rcTestRemoteKeyV3) {
        int length = rcTestRemoteKeyV3.remoteIds.split(",").length - this.remoteIds.split(",").length;
        int i = rcTestRemoteKeyV3.rank - this.rank;
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
