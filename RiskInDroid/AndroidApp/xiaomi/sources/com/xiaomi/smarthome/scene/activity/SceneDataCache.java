package com.xiaomi.smarthome.scene.activity;

import com.xiaomi.smarthome.scene.api.SceneApi;

public enum SceneDataCache {
    INSTANCE;
    
    private SceneApi.O000OOOo cachedScene;

    public final void setCachedScene(SceneApi.O000OOOo o000OOOo) {
        this.cachedScene = o000OOOo;
    }

    public final SceneApi.O000OOOo getCahcedScene() {
        return this.cachedScene;
    }
}
