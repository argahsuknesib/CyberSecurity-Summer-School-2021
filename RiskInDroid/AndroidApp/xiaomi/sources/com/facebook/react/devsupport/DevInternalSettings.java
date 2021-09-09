package com.facebook.react.devsupport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;

@VisibleForTesting
public class DevInternalSettings implements SharedPreferences.OnSharedPreferenceChangeListener, DeveloperSettings {
    private final Listener mListener;
    private final PackagerConnectionSettings mPackagerConnectionSettings;
    private final SharedPreferences mPreferences;
    private final boolean mSupportsNativeDeltaClients;

    public interface Listener {
        void onInternalSettingsChanged();
    }

    public boolean isNuclideJSDebugEnabled() {
        return false;
    }

    public static DevInternalSettings withoutNativeDeltaClient(Context context, Listener listener) {
        return new DevInternalSettings(context, listener, false);
    }

    public DevInternalSettings(Context context, Listener listener) {
        this(context, listener, true);
    }

    private DevInternalSettings(Context context, Listener listener, boolean z) {
        this.mListener = listener;
        this.mPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.mPreferences.registerOnSharedPreferenceChangeListener(this);
        this.mPackagerConnectionSettings = new PackagerConnectionSettings(context);
        this.mSupportsNativeDeltaClients = z;
    }

    public PackagerConnectionSettings getPackagerConnectionSettings() {
        return this.mPackagerConnectionSettings;
    }

    public boolean isFpsDebugEnabled() {
        return this.mPreferences.getBoolean("fps_debug", false);
    }

    public void setFpsDebugEnabled(boolean z) {
        this.mPreferences.edit().putBoolean("fps_debug", z).apply();
    }

    public boolean isAnimationFpsDebugEnabled() {
        return this.mPreferences.getBoolean("animations_debug", false);
    }

    public boolean isJSDevModeEnabled() {
        return this.mPreferences.getBoolean("js_dev_mode_debug", true);
    }

    public void setJSDevModeEnabled(boolean z) {
        this.mPreferences.edit().putBoolean("js_dev_mode_debug", z).apply();
    }

    public boolean isJSMinifyEnabled() {
        return this.mPreferences.getBoolean("js_minify_debug", false);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (this.mListener == null) {
            return;
        }
        if ("fps_debug".equals(str) || "reload_on_js_change_LEGACY".equals(str) || "js_dev_mode_debug".equals(str) || "js_bundle_deltas".equals(str) || "js_bundle_deltas_cpp".equals(str) || "start_sampling_profiler_on_init".equals(str) || "js_minify_debug".equals(str)) {
            this.mListener.onInternalSettingsChanged();
        }
    }

    public boolean isHotModuleReplacementEnabled() {
        return this.mPreferences.getBoolean("hot_module_replacement", true);
    }

    public void setHotModuleReplacementEnabled(boolean z) {
        this.mPreferences.edit().putBoolean("hot_module_replacement", z).apply();
    }

    public boolean isReloadOnJSChangeEnabled() {
        return this.mPreferences.getBoolean("reload_on_js_change_LEGACY", false);
    }

    public void setReloadOnJSChangeEnabled(boolean z) {
        this.mPreferences.edit().putBoolean("reload_on_js_change_LEGACY", z).apply();
    }

    public boolean isElementInspectorEnabled() {
        return this.mPreferences.getBoolean("inspector_debug", false);
    }

    public void setElementInspectorEnabled(boolean z) {
        this.mPreferences.edit().putBoolean("inspector_debug", z).apply();
    }

    @SuppressLint({"SharedPreferencesUse"})
    public boolean isBundleDeltasEnabled() {
        return this.mPreferences.getBoolean("js_bundle_deltas", false);
    }

    @SuppressLint({"SharedPreferencesUse"})
    public void setBundleDeltasEnabled(boolean z) {
        this.mPreferences.edit().putBoolean("js_bundle_deltas", z).apply();
    }

    @SuppressLint({"SharedPreferencesUse"})
    public boolean isBundleDeltasCppEnabled() {
        if (!this.mSupportsNativeDeltaClients || !this.mPreferences.getBoolean("js_bundle_deltas_cpp", false)) {
            return false;
        }
        return true;
    }

    @SuppressLint({"SharedPreferencesUse"})
    public void setBundleDeltasCppEnabled(boolean z) {
        this.mPreferences.edit().putBoolean("js_bundle_deltas_cpp", z).apply();
    }

    public boolean isRemoteJSDebugEnabled() {
        return this.mPreferences.getBoolean("remote_js_debug", false);
    }

    public void setRemoteJSDebugEnabled(boolean z) {
        this.mPreferences.edit().putBoolean("remote_js_debug", z).apply();
    }

    public boolean isStartSamplingProfilerOnInit() {
        return this.mPreferences.getBoolean("start_sampling_profiler_on_init", false);
    }
}
