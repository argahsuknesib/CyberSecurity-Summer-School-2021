package com.xiaomi.smarthome.operation.js_sdk.lifecycle;

public enum LifeCycleEvent {
    PAGE_RESUME("pageResume"),
    PAGE_PAUSE("pagePause"),
    APP_RESUME("appResume"),
    APP_PAUSE("appPause");
    
    public String mActionName;

    private LifeCycleEvent(String str) {
        this.mActionName = str;
    }
}
