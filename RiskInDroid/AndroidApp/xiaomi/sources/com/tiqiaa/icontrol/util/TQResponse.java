package com.tiqiaa.icontrol.util;

import _m_j.bdf;
import _m_j.bdi;
import _m_j.bdk;
import _m_j.bdl;
import com.imi.fastjson.parser.Feature;
import com.tiqiaa.common.IJsonable;

@bdl(O000000o = {"errcode", "data"})
public class TQResponse implements IJsonable {
    @bdk(O000000o = "data")
    Object data;
    @bdk(O000000o = "errcode")
    int errcode;

    public int getErrcode() {
        return this.errcode;
    }

    public void setErrcode(int i) {
        this.errcode = i;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public <T> T getData(Class cls) {
        Object obj = this.data;
        if (obj != null && !obj.equals("")) {
            try {
                return bdf.O000000o(this.data.toString(), cls);
            } catch (Exception e) {
                LogUtil.printException(e);
            }
        }
        return null;
    }

    public <T> T getData(bdi bdi) {
        Object obj = this.data;
        if (obj != null && !obj.equals("")) {
            try {
                return bdf.O000000o(this.data.toString(), bdi, new Feature[0]);
            } catch (Exception e) {
                LogUtil.printException(e);
            }
        }
        return null;
    }
}
