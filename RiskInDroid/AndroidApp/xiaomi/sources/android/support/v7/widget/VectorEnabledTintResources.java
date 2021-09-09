package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.v7.app.AppCompatDelegate;
import java.lang.ref.WeakReference;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class VectorEnabledTintResources extends Resources {
    private final WeakReference<Context> mContextRef;

    public static boolean shouldBeUsed() {
        return AppCompatDelegate.isCompatVectorFromResourcesEnabled() && Build.VERSION.SDK_INT <= 20;
    }

    public VectorEnabledTintResources(@NonNull Context context, @NonNull Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.mContextRef = new WeakReference<>(context);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        Context context = this.mContextRef.get();
        if (context != null) {
            return AppCompatDrawableManager.get().onDrawableLoadedFromResources(context, this, i);
        }
        return super.getDrawable(i);
    }

    /* access modifiers changed from: package-private */
    public final Drawable superGetDrawable(int i) {
        return super.getDrawable(i);
    }
}
