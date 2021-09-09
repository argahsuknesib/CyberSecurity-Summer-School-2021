package com.xiaomi.smarthome.core.entity.plugin;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.core.entity.Error;

public class PluginError extends Error {
    public static final Parcelable.Creator<PluginError> CREATOR = new Parcelable.Creator<PluginError>() {
        /* class com.xiaomi.smarthome.core.entity.plugin.PluginError.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PluginError[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PluginError(parcel);
        }
    };

    public int describeContents() {
        return 0;
    }

    public PluginError(int i, String str) {
        super(i, str);
    }

    protected PluginError(Parcel parcel) {
        super(parcel);
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public final String O000000o(Context context) {
        int i = this.f6718O000000o;
        switch (i) {
            case -712:
                return context.getString(R.string.installerror_dynamicfeature);
            case -711:
                return context.getString(R.string.installerror_typeinvaild);
            case -710:
                return context.getString(R.string.installerror_installed);
            case -709:
                return context.getString(R.string.installerror_modelvaild);
            case -708:
                return context.getString(R.string.installerror_platform);
            case -707:
                return context.getString(R.string.installerror_minlevel);
            case -706:
                return context.getString(R.string.installerror_developer);
            case -705:
                return context.getString(R.string.installerror_noexitinfo);
            case -704:
                return context.getString(R.string.installerror_install);
            case -703:
                return context.getString(R.string.installerror_infoerror);
            case -702:
                return context.getString(R.string.installerror_noinfo);
            case -701:
                return context.getString(R.string.installerror_nodown);
            default:
                switch (i) {
                    case -666:
                        return context.getString(R.string.downerror_appversion);
                    case -665:
                        return context.getString(R.string.downerror_downed);
                    case -664:
                        return context.getString(R.string.downerror_downing);
                    case -663:
                        return context.getString(R.string.downerror_downerror);
                    case -662:
                        return context.getString(R.string.downerror_infoerror);
                    case -661:
                        return context.getString(R.string.downerror_noplugin);
                    default:
                        return super.O000000o(context);
                }
        }
    }
}
