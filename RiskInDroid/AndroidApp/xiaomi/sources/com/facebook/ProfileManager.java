package com.facebook;

import _m_j.ft;
import android.content.Intent;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;

public final class ProfileManager {
    private static volatile ProfileManager instance;
    private Profile currentProfile;
    private final ft localBroadcastManager;
    private final ProfileCache profileCache;

    ProfileManager(ft ftVar, ProfileCache profileCache2) {
        Validate.notNull(ftVar, "localBroadcastManager");
        Validate.notNull(profileCache2, "profileCache");
        this.localBroadcastManager = ftVar;
        this.profileCache = profileCache2;
    }

    static ProfileManager getInstance() {
        if (instance == null) {
            synchronized (ProfileManager.class) {
                if (instance == null) {
                    instance = new ProfileManager(ft.O000000o(FacebookSdk.getApplicationContext()), new ProfileCache());
                }
            }
        }
        return instance;
    }

    /* access modifiers changed from: package-private */
    public final Profile getCurrentProfile() {
        return this.currentProfile;
    }

    /* access modifiers changed from: package-private */
    public final boolean loadCurrentProfile() {
        Profile load = this.profileCache.load();
        if (load == null) {
            return false;
        }
        setCurrentProfile(load, false);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void setCurrentProfile(Profile profile) {
        setCurrentProfile(profile, true);
    }

    private void setCurrentProfile(Profile profile, boolean z) {
        Profile profile2 = this.currentProfile;
        this.currentProfile = profile;
        if (z) {
            if (profile != null) {
                this.profileCache.save(profile);
            } else {
                this.profileCache.clear();
            }
        }
        if (!Utility.areObjectsEqual(profile2, profile)) {
            sendCurrentProfileChangedBroadcast(profile2, profile);
        }
    }

    private void sendCurrentProfileChangedBroadcast(Profile profile, Profile profile2) {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile2);
        this.localBroadcastManager.O000000o(intent);
    }
}
