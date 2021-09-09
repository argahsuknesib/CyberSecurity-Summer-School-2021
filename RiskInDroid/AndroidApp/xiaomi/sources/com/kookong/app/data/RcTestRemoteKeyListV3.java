package com.kookong.app.data;

import java.util.ArrayList;
import java.util.List;

public class RcTestRemoteKeyListV3 implements SerializableEx {
    private static final long serialVersionUID = -8492508236373366249L;
    public int defaultRemoteId = 0;
    public List<RcTestRemoteKeyV3> remoteKeyList = new ArrayList();
}
