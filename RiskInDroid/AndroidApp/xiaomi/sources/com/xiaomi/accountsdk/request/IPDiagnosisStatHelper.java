package com.xiaomi.accountsdk.request;

import android.text.TextUtils;
import com.xiaomi.accountsdk.account.PassportCAConstants;
import java.util.ArrayList;

class IPDiagnosisStatHelper extends RequestWithIPStatHelper {
    private ArrayList<String> usedIps = new ArrayList<>();
    private ArrayList<String> usedNets = new ArrayList<>();

    public void onBackupIpSucceeded(int i) {
    }

    public void onCachedIpSucceed() {
    }

    IPDiagnosisStatHelper() {
    }

    public void onIpRequestStarted() {
        statCountEvent("Ip", "IpRequestStarted");
    }

    public void onIpRequest200Succeed() {
        statCountEvent("Ip", "IpRequestSucceed");
        statAllIps(true);
    }

    public void onIpRequestIOSucceed() {
        statCountEvent("Ip", "IpRequestIOSucceeded");
        statAllIps(true);
    }

    public void onIpRequestFailed() {
        statCountEvent("Ip", "IpRequestFailed");
        statAllIps(false);
    }

    public void onCachedIpStarted(String str) {
        this.usedIps.add(str);
        this.usedNets.add(getNetworkName());
    }

    public void onCachedIpFailed() {
        statCountEvent("Ip", "cachedIpFailed");
    }

    public void onDnsip0Started(String str) {
        this.usedIps.add(str);
        this.usedNets.add(getNetworkName());
    }

    public void onDnsIp0Succeed() {
        statDummyUrl(String.format("http://dummyurl/cachedIpDiagonose?_ver=%s&cacheipnet=%s&cachedip=%s&dnsipnet=%s&dnsip=%s&finalnet=%s", PassportCAConstants.IMPL_VERSION, this.usedNets.get(0), this.usedIps.get(0), this.usedNets.get(1), this.usedIps.get(1), getNetworkName()));
    }

    public void onDnsIp0Failed() {
        statCountEvent("Ip", "dnsIp0Failed");
    }

    public void onBackupIpStarted(int i, String str) {
        this.usedIps.add(str);
        this.usedNets.add(getNetworkName());
    }

    public void onBackupIpFailed(int i) {
        statCountEvent("Ip", "backupIpFailed".concat(String.valueOf(i)));
    }

    /* access modifiers changed from: package-private */
    public void statAllIps(boolean z) {
        statDummyUrl(String.format("http://dummyurl/IpDiagonose?_ver=%s&_ips=%s&_nets=%s&_ipResult=%s", PassportCAConstants.IMPL_VERSION, TextUtils.join(",", this.usedIps), TextUtils.join(",", this.usedNets), Boolean.valueOf(z)));
    }
}
