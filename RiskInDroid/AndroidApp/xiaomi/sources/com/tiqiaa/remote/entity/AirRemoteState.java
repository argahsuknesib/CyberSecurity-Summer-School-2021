package com.tiqiaa.remote.entity;

import _m_j.bdk;
import _m_j.bdl;
import com.tiqiaa.common.IJsonable;

@bdl(O000000o = {"remote_id", "protocol", "current_key", "last_key", "power", "mode", "temp", "wind_amount", "wind_direction", "wind_hoz", "wind_ver", "super_mode", "sleep", "hot", "time", "temp_display", "power_saving", "anion", "comfort", "flash_air", "light", "wet", "mute", "time_limit", "caculate_number"}, O00000Oo = {"caculate_number", "time_limit", "time"})
public class AirRemoteState implements IJsonable {
    @bdk(O000000o = "anion")
    AirAnion anion;
    @bdk(O000000o = "caculate_number")
    int caculate_number;
    @bdk(O000000o = "comfort")
    AirComfort comfort;
    @bdk(O000000o = "current_key")
    int current_key;
    @bdk(O000000o = "flash_air")
    AirFlashAir flash_air;
    @bdk(O000000o = "hot")
    AirAidHot hot;
    @bdk(O000000o = "last_key")
    int last_key;
    @bdk(O000000o = "light")
    AirLight light;
    @bdk(O000000o = "mode")
    AirMode mode;
    @bdk(O000000o = "mute")
    AirMute mute;
    @bdk(O000000o = "power")
    AirPower power;
    @bdk(O000000o = "power_saving")
    AirPowerSaving power_saving;
    @bdk(O000000o = "protocol")
    int protocol;
    @bdk(O000000o = "remote_id")
    String remote_id;
    @bdk(O000000o = "sleep")
    AirSleep sleep;
    @bdk(O000000o = "super_mode")
    AirSuper super_mode;
    @bdk(O000000o = "temp")
    AirTemp temp;
    @bdk(O000000o = "temp_display")
    AirTempDisplay temp_display;
    @bdk(O000000o = "time")
    AirTime time;
    @bdk(O000000o = "time_limit")
    int time_limit;
    @bdk(O000000o = "wet")
    AirWet wet;
    @bdk(O000000o = "wind_amount")
    AirWindAmount wind_amount;
    @bdk(O000000o = "wind_direction")
    AirWindDirection wind_direction;
    @bdk(O000000o = "wind_hoz")
    AirWindHoz wind_hoz;
    @bdk(O000000o = "wind_ver")
    AirWindVer wind_ver;

    AirRemoteState() {
    }

    public AirRemoteState(String str) {
        if (str != null) {
            this.remote_id = str;
            this.power = AirPower.POWER_OFF;
            this.mode = AirMode.AUTO;
            this.temp = AirTemp.T26;
            this.wind_amount = AirWindAmount.AUTO;
            this.wind_direction = AirWindDirection.AUTO;
            this.wind_hoz = AirWindHoz.HOZ_OFF;
            this.wind_ver = AirWindVer.VER_OFF;
            this.super_mode = AirSuper.SUPER_OFF;
            this.sleep = AirSleep.SLEEP_OFF;
            this.hot = AirAidHot.AIDHOT_OFF;
            this.time = AirTime.TIME_OFF;
            this.temp_display = AirTempDisplay.DISPLAY_NONE;
            this.power_saving = AirPowerSaving.POWER_SAVING_OFF;
            this.anion = AirAnion.ANION_OFF;
            this.comfort = AirComfort.COMFORT_OFF;
            this.flash_air = AirFlashAir.FLASH_OFF;
            this.light = AirLight.LIGHT_ON;
            this.wet = AirWet.WET_OFF;
            this.mute = AirMute.MUTE_OFF;
            this.caculate_number = 0;
            return;
        }
        throw new NullPointerException("the string param 'remote_id' can not be null");
    }

    public int getProtocol() {
        return this.protocol;
    }

    public void setProtocol(int i) {
        this.protocol = i;
    }

    public AirPower getPower() {
        return this.power;
    }

    public void setPower(AirPower airPower) {
        this.power = airPower;
    }

    public AirMute getMute() {
        return this.mute;
    }

    public void setMute(AirMute airMute) {
        this.mute = airMute;
    }

    public int getCaculate_number() {
        return this.caculate_number;
    }

    public void setCaculate_number(int i) {
        this.caculate_number = i;
    }

    public AirMode getMode() {
        return this.mode;
    }

    public void setMode(AirMode airMode) {
        this.mode = airMode;
    }

    public AirTemp getTemp() {
        return this.temp;
    }

    public void setTemp(AirTemp airTemp) {
        this.temp = airTemp;
    }

    public String getRemote_id() {
        return this.remote_id;
    }

    public void setRemote_id(String str) {
        this.remote_id = str;
    }

    public AirTempDisplay getTemp_display() {
        return this.temp_display;
    }

    public void setTemp_display(AirTempDisplay airTempDisplay) {
        this.temp_display = airTempDisplay;
    }

    public AirWindAmount getWind_amount() {
        return this.wind_amount;
    }

    public void setWind_amount(AirWindAmount airWindAmount) {
        this.wind_amount = airWindAmount;
    }

    public AirWindDirection getWind_direction() {
        return this.wind_direction;
    }

    public void setWind_direction(AirWindDirection airWindDirection) {
        this.wind_direction = airWindDirection;
    }

    public AirWindHoz getWind_hoz() {
        return this.wind_hoz;
    }

    public void setWind_hoz(AirWindHoz airWindHoz) {
        this.wind_hoz = airWindHoz;
    }

    public AirWindVer getWind_ver() {
        return this.wind_ver;
    }

    public void setWind_ver(AirWindVer airWindVer) {
        this.wind_ver = airWindVer;
    }

    public AirTime getTime() {
        if (this.time == null) {
            this.time = AirTime.TIME_OFF;
        }
        return this.time;
    }

    public void setTime(AirTime airTime) {
        this.time = airTime;
    }

    public AirSuper getSuper_mode() {
        return this.super_mode;
    }

    public void setSuper_mode(AirSuper airSuper) {
        this.super_mode = airSuper;
    }

    public AirSleep getSleep() {
        return this.sleep;
    }

    public void setSleep(AirSleep airSleep) {
        this.sleep = airSleep;
    }

    public AirAidHot getHot() {
        return this.hot;
    }

    public void setHot(AirAidHot airAidHot) {
        this.hot = airAidHot;
    }

    public AirPowerSaving getPower_saving() {
        return this.power_saving;
    }

    public void setPower_saving(AirPowerSaving airPowerSaving) {
        this.power_saving = airPowerSaving;
    }

    public AirAnion getAnion() {
        return this.anion;
    }

    public void setAnion(AirAnion airAnion) {
        this.anion = airAnion;
    }

    public AirComfort getComfort() {
        return this.comfort;
    }

    public void setComfort(AirComfort airComfort) {
        this.comfort = airComfort;
    }

    public AirFlashAir getFlash_air() {
        return this.flash_air;
    }

    public void setFlash_air(AirFlashAir airFlashAir) {
        this.flash_air = airFlashAir;
    }

    public AirLight getLight() {
        return this.light;
    }

    public void setLight(AirLight airLight) {
        this.light = airLight;
    }

    public AirWet getWet() {
        return this.wet;
    }

    public void setWet(AirWet airWet) {
        this.wet = airWet;
    }

    public int getCurrent_key() {
        return this.current_key;
    }

    public void setCurrent_key(int i) {
        this.current_key = i;
    }

    public int getLast_key() {
        return this.last_key;
    }

    public void setLast_key(int i) {
        this.last_key = i;
    }

    public int getTime_limit() {
        return this.time_limit;
    }

    public void setTime_limit(int i) {
        this.time_limit = i;
    }
}
