package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.SpinnerAdapter;

public interface ThemedSpinnerAdapter extends SpinnerAdapter {
    @Nullable
    Resources.Theme getDropDownViewTheme();

    void setDropDownViewTheme(@Nullable Resources.Theme theme);

    public static final class Helper {
        private final Context mContext;
        private LayoutInflater mDropDownInflater;
        private final LayoutInflater mInflater;

        public Helper(@NonNull Context context) {
            this.mContext = context;
            this.mInflater = LayoutInflater.from(context);
        }

        public final void setDropDownViewTheme(@Nullable Resources.Theme theme) {
            if (theme == null) {
                this.mDropDownInflater = null;
            } else if (theme == this.mContext.getTheme()) {
                this.mDropDownInflater = this.mInflater;
            } else {
                this.mDropDownInflater = LayoutInflater.from(new ContextThemeWrapper(this.mContext, theme));
            }
        }

        @Nullable
        public final Resources.Theme getDropDownViewTheme() {
            LayoutInflater layoutInflater = this.mDropDownInflater;
            if (layoutInflater == null) {
                return null;
            }
            return layoutInflater.getContext().getTheme();
        }

        @NonNull
        public final LayoutInflater getDropDownViewInflater() {
            LayoutInflater layoutInflater = this.mDropDownInflater;
            return layoutInflater != null ? layoutInflater : this.mInflater;
        }
    }
}
