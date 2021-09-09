package com.mibi.sdk.component.recharge;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RechargeManager {
    private static final RechargeManager sInstance = new RechargeManager();
    private HashMap<String, Recharge> mRechargeMap = new HashMap<>();
    private ArrayList<Recharge> mRecharges = new ArrayList<>();

    private RechargeManager() {
    }

    public static RechargeManager get() {
        return sInstance;
    }

    public void registRecharge(Recharge recharge) {
        if (this.mRechargeMap.get(recharge.getChannel()) == null) {
            this.mRecharges.add(recharge);
            this.mRechargeMap.put(recharge.getChannel(), recharge);
        }
    }

    public void removeRecharge(String str) {
        Recharge remove;
        if (this.mRechargeMap.containsKey(str) && (remove = this.mRechargeMap.remove(str)) != null) {
            this.mRecharges.remove(remove);
        }
    }

    public Recharge getRecharge(String str) {
        return this.mRechargeMap.get(str);
    }

    public String getChannels(Context context) {
        StringBuilder sb = new StringBuilder();
        Iterator<Recharge> it = this.mRecharges.iterator();
        while (it.hasNext()) {
            Recharge next = it.next();
            if (next.available(context)) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(next.getChannel());
            }
        }
        return sb.toString();
    }
}
