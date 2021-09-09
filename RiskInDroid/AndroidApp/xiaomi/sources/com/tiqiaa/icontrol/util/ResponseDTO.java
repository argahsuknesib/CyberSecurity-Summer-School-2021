package com.tiqiaa.icontrol.util;

import _m_j.bdf;
import _m_j.bdi;
import _m_j.bdk;
import _m_j.bdl;
import com.imi.fastjson.parser.Feature;
import com.tiqiaa.common.IJsonable;
import java.util.HashMap;
import java.util.Map;

@bdl(O000000o = {"responseType", "data"})
public class ResponseDTO extends DTO implements IJsonable {
    @bdk(O000000o = "data")
    private ReponseParams data;
    @bdk(O000000o = "responseType")
    private int responseType;

    public int getResponseType() {
        return this.responseType;
    }

    public void setResponseType(int i) {
        this.responseType = i;
    }

    public ReponseParams getData() {
        return this.data;
    }

    public void setData(ReponseParams reponseParams) {
        this.data = reponseParams;
    }

    public static ResponseDTO getDTO(String str) {
        ResponseDTO responseDTO = (ResponseDTO) bdf.O000000o(str, ResponseDTO.class);
        LogUtil.d("RESPONSEDTO", "rsDto=".concat(String.valueOf(responseDTO)));
        return responseDTO;
    }

    @bdl(O000000o = {"resultType", "extraParams", "concernObj"})
    public static class ReponseParams implements IJsonable {
        @bdk(O000000o = "concernObj")
        private Object concernObj;
        @bdk(O000000o = "extraParams")
        private Map<String, Object> extraParams;
        @bdk(O000000o = "resultType")
        private int resultType;

        public int getResultType() {
            return this.resultType;
        }

        public void setResultType(int i) {
            this.resultType = i;
        }

        public Object getConcernObj() {
            return this.concernObj;
        }

        public void setConcernObj(Object obj) {
            this.concernObj = obj;
        }

        public <T> T getConcernObj(Class cls) {
            Object obj = this.concernObj;
            if (obj != null && !obj.equals("")) {
                return bdf.O000000o(this.concernObj.toString(), cls);
            }
            LogUtil.e("RESPONSEDTO", "getConcernObj.........this.concernObj==null");
            return null;
        }

        public <T> T getConcernObj(bdi bdi) {
            Object obj = this.concernObj;
            if (obj != null && !obj.equals("")) {
                return bdf.O000000o(this.concernObj.toString(), bdi, new Feature[0]);
            }
            LogUtil.e("RESPONSEDTO", "getConcernObj.........this.concernObj==null");
            return null;
        }

        public Map<String, Object> getExtraParams() {
            return this.extraParams;
        }

        public void setExtraParams(Map<String, Object> map) {
            this.extraParams = map;
        }

        public void putExtraString(String str, String str2) {
            if (this.extraParams == null) {
                this.extraParams = new HashMap();
            }
            this.extraParams.put(str, str2);
        }

        public void putExtraChar(String str, String str2) {
            if (this.extraParams == null) {
                this.extraParams = new HashMap();
            }
            this.extraParams.put(str, str2);
        }

        public void putExtraByte(String str, byte b) {
            if (this.extraParams == null) {
                this.extraParams = new HashMap();
            }
            this.extraParams.put(str, Byte.valueOf(b));
        }

        public void putExtraInt(String str, int i) {
            if (this.extraParams == null) {
                this.extraParams = new HashMap();
            }
            this.extraParams.put(str, Integer.valueOf(i));
        }

        public void putExtraLong(String str, long j) {
            if (this.extraParams == null) {
                this.extraParams = new HashMap();
            }
            this.extraParams.put(str, Long.valueOf(j));
        }

        public void putExtraBoolean(String str, boolean z) {
            if (this.extraParams == null) {
                this.extraParams = new HashMap();
            }
            this.extraParams.put(str, Boolean.valueOf(z));
        }

        public void putExtraObj(String str, Object obj) {
            if (this.extraParams == null) {
                this.extraParams = new HashMap();
            }
            this.extraParams.put(str, obj);
        }

        public String getExtraString(String str) {
            Map<String, Object> map = this.extraParams;
            if (map == null || map.get(str) == null) {
                return null;
            }
            return (String) this.extraParams.get(str);
        }

        public byte getExtraByte(String str) {
            Map<String, Object> map = this.extraParams;
            if (map == null || map.get(str) == null) {
                return -1;
            }
            return ((Byte) this.extraParams.get(str)).byteValue();
        }

        public int getExtraInt(String str) {
            Map<String, Object> map = this.extraParams;
            if (map == null || map.get(str) == null) {
                return -1;
            }
            return ((Integer) this.extraParams.get(str)).intValue();
        }

        public long getExtraLong(String str) {
            Map<String, Object> map = this.extraParams;
            if (map == null || map.get(str) == null) {
                return -1;
            }
            return ((Long) this.extraParams.get(str)).longValue();
        }

        public boolean getExtraBoolean(String str) throws NullPointerException {
            Map<String, Object> map = this.extraParams;
            if (map != null && map.get(str) != null) {
                return ((Boolean) this.extraParams.get(str)).booleanValue();
            }
            LogUtil.e("RESPONSEDTO", "getExtraBoolean..............没有 参数名 为 " + str + " 的Boolean类型参数");
            return false;
        }

        public Object getExtraObj(String str) {
            Map<String, Object> map = this.extraParams;
            if (map == null) {
                return null;
            }
            return map.get(str);
        }
    }
}
