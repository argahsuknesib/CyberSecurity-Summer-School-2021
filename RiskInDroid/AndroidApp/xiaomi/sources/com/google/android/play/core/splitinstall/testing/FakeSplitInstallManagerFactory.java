package com.google.android.play.core.splitinstall.testing;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitcompat.q;
import java.io.File;

public class FakeSplitInstallManagerFactory {

    /* renamed from: a  reason: collision with root package name */
    private static FakeSplitInstallManager f3830a;

    public static File a(Context context) {
        String string;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), NotificationCompat.FLAG_HIGH_PRIORITY).metaData;
            if (!(bundle == null || (string = bundle.getString("local_testing_dir")) == null)) {
                return new File(context.getExternalFilesDir(null), string);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    public static FakeSplitInstallManager create(Context context) {
        try {
            File a2 = a(context);
            if (a2 == null) {
                throw new LocalTestingException("Failed to retrieve local testing directory path");
            } else if (a2.exists()) {
                return create(context, a2);
            } else {
                throw new LocalTestingException(String.format("Local testing directory not found: %s", a2));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized FakeSplitInstallManager create(Context context, File file) {
        FakeSplitInstallManager fakeSplitInstallManager;
        synchronized (FakeSplitInstallManagerFactory.class) {
            if (f3830a == null) {
                f3830a = createNewInstance(context, file);
            } else if (!f3830a.a().getAbsolutePath().equals(file.getAbsolutePath())) {
                throw new RuntimeException(String.format("Different module directories used to initialize FakeSplitInstallManager: '%s' and '%s'", f3830a.a().getAbsolutePath(), file.getAbsolutePath()));
            }
            fakeSplitInstallManager = f3830a;
        }
        return fakeSplitInstallManager;
    }

    public static FakeSplitInstallManager createNewInstance(Context context, File file) {
        SplitCompat.install(context);
        return new FakeSplitInstallManager(context, file, q.a());
    }
}
