package com.hzy.tvmao.model.legacy.api.data;

import com.kookong.app.data.SerializableEx;
import java.util.List;

public class ManualMatchData {
    private String lid;
    private List<Ch> list;
    private String result;
    private int resultCode;

    public String getLid() {
        return this.lid;
    }

    public void setLid(String str) {
        this.lid = str;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public List<Ch> getList() {
        return this.list;
    }

    public void setList(List<Ch> list2) {
        this.list = list2;
    }

    public static class Ch implements SerializableEx {
        private static final long serialVersionUID = 6335634594583494015L;
        public int cid;
        public String ctrid;
        public short fee;
        public short hd;
        public short hidden;
        public String llogo;
        public String logo;
        public String name;
        public int num;
        public String pulse;
        public short type;

        public String toString() {
            return "Ch{cid=" + this.cid + ", num=" + this.num + ", ctrid='" + this.ctrid + '\'' + ", name='" + this.name + '\'' + ", logo='" + this.logo + '\'' + ", llogo='" + this.llogo + '\'' + ", hd=" + ((int) this.hd) + ", fee=" + ((int) this.fee) + ", hidden=" + ((int) this.hidden) + ", type=" + ((int) this.type) + ", pulse='" + this.pulse + '\'' + '}';
        }
    }

    public String toString() {
        return "ManualMatchData{resultCode=" + this.resultCode + ", result='" + this.result + '\'' + ", list=" + this.list + '}';
    }
}
