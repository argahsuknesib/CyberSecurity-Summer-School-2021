package com.xiaomi.idm.tap.dispatcher.impl;

import _m_j.dws;
import _m_j.dwt;
import _m_j.dwu;
import _m_j.dwv;
import _m_j.dww;
import android.content.Context;
import com.google.android.exoplayer2.C;
import com.xiaomi.idm.tap.dispatcher.ActionDispatcher;
import com.xiaomi.idm.tap.dispatcher.ActionExecutor;
import com.xiaomi.idm.tap.dispatcher.ConditionVerifier;
import com.xiaomi.idm.tap.dispatcher.ConditionVerifierFactory;
import com.xiaomi.idm.tap.dispatcher.DispatcherContext;
import com.xiaomi.idm.tap.dispatcher.ExecutorFactory;
import com.xiaomi.idm.tap.dispatcher.utils.IDMTapLogger;
import com.xiaomi.mi_connect.nfc.exception.NfcTagDataCorruptException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NfcV1ActionDispatcher implements ActionDispatcher {
    private static final String TAG = "NfcV1ActionDispatcher";
    private dwu advDataCoder = new dwu();
    private Context context;
    private ExecutorFactory executorFactory = new DefaultExecutorFactory();
    private List<Short> limitedActions = null;

    private int mapProtocolConditionToDispatchCondition(int i) {
        return i;
    }

    public void setExecutorFactory(ExecutorFactory executorFactory2) {
        this.executorFactory = executorFactory2;
    }

    public NfcV1ActionDispatcher(Context context2) {
        this.context = context2;
    }

    private boolean dispatchScreenCasting(dww dww) {
        IDMTapLogger.v(TAG, "dispatch screen casting action", new Object[0]);
        ActionExecutor createExecutor = this.executorFactory.createExecutor(this.context, 5, dww);
        if (createExecutor == null || !createExecutor.execute()) {
            return false;
        }
        return true;
    }

    private boolean dispatchEmptyNfcTag() {
        IDMTapLogger.v(TAG, "dispatch empty action", new Object[0]);
        return this.executorFactory.createExecutor(this.context, 12, null).execute();
    }

    private boolean dispatchAutoAction(dww dww) {
        IDMTapLogger.v(TAG, "dispatch auto action", new Object[0]);
        ActionExecutor createExecutor = this.executorFactory.createExecutor(this.context, 32767, dww);
        if (createExecutor == null || !createExecutor.execute()) {
            return false;
        }
        return true;
    }

    private boolean dispatchIOTAction(dww dww) {
        IDMTapLogger.v(TAG, "dispatch iot action", new Object[0]);
        ActionExecutor createExecutor = this.executorFactory.createExecutor(this.context, 1, dww);
        if (createExecutor == null || !createExecutor.execute()) {
            return false;
        }
        return true;
    }

    private boolean dispatchIOTEnvAction(dww dww) {
        IDMTapLogger.v(TAG, "dispatch iot env action", new Object[0]);
        ActionExecutor createExecutor = this.executorFactory.createExecutor(this.context, 9, dww);
        if (createExecutor == null || !createExecutor.execute()) {
            return false;
        }
        return true;
    }

    private boolean dispatchMusicRelayAction(dww dww) {
        IDMTapLogger.v(TAG, "dispatch music relay action", new Object[0]);
        ActionExecutor createExecutor = this.executorFactory.createExecutor(this.context, 2, dww);
        if (createExecutor == null || !createExecutor.execute()) {
            return false;
        }
        return true;
    }

    private boolean dispatchLaptop(dww dww) {
        IDMTapLogger.v(TAG, "dispatch music relay action", new Object[0]);
        ActionExecutor createExecutor = this.executorFactory.createExecutor(this.context, 6, dww);
        if (createExecutor == null || !createExecutor.execute()) {
            return false;
        }
        return true;
    }

    private boolean dispatchConnectRouter(dww dww) {
        IDMTapLogger.v(TAG, "dispatch connect router action", new Object[0]);
        ActionExecutor createExecutor = this.executorFactory.createExecutor(this.context, 11, dww);
        if (createExecutor == null || !createExecutor.execute()) {
            return false;
        }
        return true;
    }

    private boolean dispatchVideoRelay(dww dww) {
        IDMTapLogger.v(TAG, "dispatch connect router action", new Object[0]);
        ActionExecutor createExecutor = this.executorFactory.createExecutor(this.context, 7, dww);
        if (createExecutor == null || !createExecutor.execute()) {
            return false;
        }
        return true;
    }

    private boolean dispatchVoIPRelay(dww dww) {
        IDMTapLogger.v(TAG, "dispatch connect router action", new Object[0]);
        ActionExecutor createExecutor = this.executorFactory.createExecutor(this.context, 8, dww);
        if (createExecutor == null || !createExecutor.execute()) {
            return false;
        }
        return true;
    }

    private void dispatchNormalNfcTag(dwv dwv) {
        List<dws> O000000o2 = dwv.O000000o((byte) 1);
        List<dws> O000000o3 = dwv.O000000o((byte) 2);
        HashMap hashMap = new HashMap();
        HashSet hashSet = new HashSet();
        if (O000000o2 != null && O000000o2.size() > 0) {
            for (dws O000000o4 : O000000o2) {
                dww dww = (dww) O000000o4.O000000o(dww.class);
                if (dww != null) {
                    hashMap.put(Byte.valueOf(dww.O00000Oo), dww);
                }
            }
        }
        if (hashMap.size() == 0) {
            IDMTapLogger.e(TAG, "device record is empty", new Object[0]);
        } else if (O000000o3 == null || O000000o3.size() == 0) {
            IDMTapLogger.v(TAG, "no action record", new Object[0]);
            if (hashMap.size() == 1 && this.limitedActions == null) {
                IDMTapLogger.v(TAG, "one device without action, dispatch to auto action", new Object[0]);
                dispatchAutoAction(((dww[]) hashMap.values().toArray(new dww[0]))[0]);
            }
        } else {
            for (dws O000000o5 : O000000o3) {
                dwt dwt = (dwt) O000000o5.O000000o(dwt.class);
                if (dwt != null) {
                    byte b = dwt.O00000o0;
                    if (!hashSet.contains(Byte.valueOf(b))) {
                        dww dww2 = (dww) hashMap.get(Byte.valueOf(dwt.O00000o0));
                        if (dww2 == null) {
                            IDMTapLogger.e(TAG, "can not find device info in tag data", new Object[0]);
                        } else {
                            List<Short> list = this.limitedActions;
                            if ((list == null || list.contains(Short.valueOf((short) dwt.f15007O000000o))) && dispatchAction(dww2, dwt)) {
                                hashSet.add(Byte.valueOf(b));
                            }
                        }
                    }
                }
            }
        }
    }

    public void dispatchRawData(byte[] bArr, DispatcherContext dispatcherContext) {
        try {
            dispatchAppData(dwu.O000000o(bArr));
        } catch (NfcTagDataCorruptException e) {
            String str = TAG;
            IDMTapLogger.e(str, "decode miconnect adv data failed, msg is " + e.getMessage(), new Object[0]);
        }
    }

    public void dispatchRawAppData(byte[] bArr, DispatcherContext dispatcherContext) {
        try {
            dispatchAppData(dwv.O000000o(bArr));
        } catch (NfcTagDataCorruptException e) {
            String str = TAG;
            IDMTapLogger.e(str, "decode app data failed msg is " + e.getMessage(), new Object[0]);
        }
    }

    public void filterActions(ActionDispatcher.ActionFilter actionFilter) {
        ArrayList arrayList = new ArrayList();
        for (short s = 1; s < 13; s = (short) (s + 1)) {
            arrayList.add(Short.valueOf(s));
        }
        this.limitedActions = actionFilter.filterActions(arrayList);
        if (this.limitedActions == null) {
            this.limitedActions = new ArrayList();
        }
    }

    private boolean dispatchAction(dww dww, dwt dwt) {
        int i = dwt.f15007O000000o;
        int i2 = dwt.O00000Oo;
        if (i2 != 127) {
            if (i2 <= 0 || i2 >= 3) {
                IDMTapLogger.e(TAG, "unsupported condition", new Object[0]);
                return false;
            }
            ConditionVerifier createConditionVerifier = ConditionVerifierFactory.getDefault().createConditionVerifier(mapProtocolConditionToDispatchCondition(i2));
            createConditionVerifier.setParameter(dwt.O00000o);
            if (!createConditionVerifier.isConditionSatisfied()) {
                return false;
            }
        }
        if (i == 1) {
            return dispatchIOTAction(dww);
        }
        if (i == 2 || i == 3) {
            return dispatchMusicRelayAction(dww);
        }
        if (i == 11) {
            return dispatchConnectRouter(dww);
        }
        if (i == 12) {
            return dispatchEmptyNfcTag();
        }
        if (i == 32767) {
            return dispatchAutoAction(dww);
        }
        switch (i) {
            case 5:
                return dispatchScreenCasting(dww);
            case 6:
                return dispatchLaptop(dww);
            case 7:
                return dispatchVideoRelay(dww);
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER:
                return dispatchVoIPRelay(dww);
            case 9:
                return dispatchIOTEnvAction(dww);
            default:
                IDMTapLogger.e(TAG, "unsupported action", new Object[0]);
                return false;
        }
    }

    private void dispatchAppData(dwv dwv) {
        if (dwv.f15009O000000o <= 0) {
            IDMTapLogger.v(TAG, "detect empty nfc tag, dispatch to mijia or install mijia", new Object[0]);
            dispatchEmptyNfcTag();
            return;
        }
        dispatchNormalNfcTag(dwv);
    }
}
