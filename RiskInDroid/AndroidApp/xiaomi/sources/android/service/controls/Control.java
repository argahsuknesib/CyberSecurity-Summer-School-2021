package android.service.controls;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Icon;
import android.os.Parcel;
import android.os.Parcelable;
import android.service.controls.templates.ControlTemplate;
import android.service.controls.templates.ControlTemplateWrapper;
import android.text.TextUtils;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

public final class Control implements Parcelable {
    public static final Parcelable.Creator<Control> CREATOR = new Parcelable.Creator<Control>() {
        /* class android.service.controls.Control.AnonymousClass1 */

        public final Control createFromParcel(Parcel parcel) {
            return new Control(parcel);
        }

        public final Control[] newArray(int i) {
            return new Control[i];
        }
    };
    public final PendingIntent mAppIntent;
    public final String mControlId;
    public final ControlTemplate mControlTemplate;
    public final ColorStateList mCustomColor;
    public final Icon mCustomIcon;
    public final int mDeviceType;
    public final int mStatus;
    public final CharSequence mStatusText;
    public final CharSequence mStructure;
    public final CharSequence mSubtitle;
    public final CharSequence mTitle;
    public final CharSequence mZone;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    public final int describeContents() {
        return 0;
    }

    Control(String str, int i, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, PendingIntent pendingIntent, Icon icon, ColorStateList colorStateList, int i2, ControlTemplate controlTemplate, CharSequence charSequence5) {
        Objects.requireNonNull(str);
        Objects.requireNonNull(charSequence);
        Objects.requireNonNull(charSequence2);
        Objects.requireNonNull(pendingIntent);
        Objects.requireNonNull(controlTemplate);
        Objects.requireNonNull(charSequence5);
        this.mControlId = str;
        if (!DeviceTypes.validDeviceType(i)) {
            Log.e("Control", "Invalid device type:".concat(String.valueOf(i)));
            this.mDeviceType = 0;
        } else {
            this.mDeviceType = i;
        }
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mStructure = charSequence3;
        this.mZone = charSequence4;
        this.mAppIntent = pendingIntent;
        this.mCustomColor = colorStateList;
        this.mCustomIcon = icon;
        if (i2 < 0 || i2 >= 5) {
            this.mStatus = 0;
            Log.e("Control", "Status unknown:".concat(String.valueOf(i2)));
        } else {
            this.mStatus = i2;
        }
        this.mControlTemplate = controlTemplate;
        this.mStatusText = charSequence5;
    }

    Control(Parcel parcel) {
        this.mControlId = parcel.readString();
        this.mDeviceType = parcel.readInt();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        if (parcel.readByte() == 1) {
            this.mStructure = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        } else {
            this.mStructure = null;
        }
        if (parcel.readByte() == 1) {
            this.mZone = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        } else {
            this.mZone = null;
        }
        this.mAppIntent = (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcel);
        if (parcel.readByte() == 1) {
            this.mCustomIcon = (Icon) Icon.CREATOR.createFromParcel(parcel);
        } else {
            this.mCustomIcon = null;
        }
        if (parcel.readByte() == 1) {
            this.mCustomColor = (ColorStateList) ColorStateList.CREATOR.createFromParcel(parcel);
        } else {
            this.mCustomColor = null;
        }
        this.mStatus = parcel.readInt();
        this.mControlTemplate = ControlTemplateWrapper.CREATOR.createFromParcel(parcel).getWrappedTemplate();
        this.mStatusText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }

    public final String getControlId() {
        return this.mControlId;
    }

    public final int getDeviceType() {
        return this.mDeviceType;
    }

    public final CharSequence getTitle() {
        return this.mTitle;
    }

    public final CharSequence getSubtitle() {
        return this.mSubtitle;
    }

    public final CharSequence getStructure() {
        return this.mStructure;
    }

    public final CharSequence getZone() {
        return this.mZone;
    }

    public final PendingIntent getAppIntent() {
        return this.mAppIntent;
    }

    public final Icon getCustomIcon() {
        return this.mCustomIcon;
    }

    public final ColorStateList getCustomColor() {
        return this.mCustomColor;
    }

    public final int getStatus() {
        return this.mStatus;
    }

    public final ControlTemplate getControlTemplate() {
        return this.mControlTemplate;
    }

    public final CharSequence getStatusText() {
        return this.mStatusText;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mControlId);
        parcel.writeInt(this.mDeviceType);
        TextUtils.writeToParcel(this.mTitle, parcel, 0);
        TextUtils.writeToParcel(this.mSubtitle, parcel, 0);
        if (this.mStructure != null) {
            parcel.writeByte((byte) 1);
            TextUtils.writeToParcel(this.mStructure, parcel, 0);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mZone != null) {
            parcel.writeByte((byte) 1);
            TextUtils.writeToParcel(this.mZone, parcel, 0);
        } else {
            parcel.writeByte((byte) 0);
        }
        this.mAppIntent.writeToParcel(parcel, i);
        if (this.mCustomIcon != null) {
            parcel.writeByte((byte) 1);
            this.mCustomIcon.writeToParcel(parcel, i);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mCustomColor != null) {
            parcel.writeByte((byte) 1);
            this.mCustomColor.writeToParcel(parcel, i);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeInt(this.mStatus);
        new ControlTemplateWrapper(this.mControlTemplate).writeToParcel(parcel, i);
        TextUtils.writeToParcel(this.mStatusText, parcel, 0);
    }

    @SuppressLint({"MutableBareField"})
    public static final class StatelessBuilder {
        private PendingIntent mAppIntent;
        private String mControlId;
        private ColorStateList mCustomColor;
        private Icon mCustomIcon;
        private int mDeviceType = 0;
        private CharSequence mStructure;
        private CharSequence mSubtitle = "";
        private CharSequence mTitle = "";
        private CharSequence mZone;

        public StatelessBuilder(String str, PendingIntent pendingIntent) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(pendingIntent);
            this.mControlId = str;
            this.mAppIntent = pendingIntent;
        }

        public StatelessBuilder(Control control) {
            Objects.requireNonNull(control);
            this.mControlId = control.mControlId;
            this.mDeviceType = control.mDeviceType;
            this.mTitle = control.mTitle;
            this.mSubtitle = control.mSubtitle;
            this.mStructure = control.mStructure;
            this.mZone = control.mZone;
            this.mAppIntent = control.mAppIntent;
            this.mCustomIcon = control.mCustomIcon;
            this.mCustomColor = control.mCustomColor;
        }

        public final StatelessBuilder setControlId(String str) {
            Objects.requireNonNull(str);
            this.mControlId = str;
            return this;
        }

        public final StatelessBuilder setDeviceType(int i) {
            if (!DeviceTypes.validDeviceType(i)) {
                Log.e("StatelessBuilder", "Invalid device type:".concat(String.valueOf(i)));
                this.mDeviceType = 0;
            } else {
                this.mDeviceType = i;
            }
            return this;
        }

        public final StatelessBuilder setTitle(CharSequence charSequence) {
            Objects.requireNonNull(charSequence);
            this.mTitle = charSequence;
            return this;
        }

        public final StatelessBuilder setSubtitle(CharSequence charSequence) {
            Objects.requireNonNull(charSequence);
            this.mSubtitle = charSequence;
            return this;
        }

        public final StatelessBuilder setStructure(CharSequence charSequence) {
            this.mStructure = charSequence;
            return this;
        }

        public final StatelessBuilder setZone(CharSequence charSequence) {
            this.mZone = charSequence;
            return this;
        }

        public final StatelessBuilder setAppIntent(PendingIntent pendingIntent) {
            Objects.requireNonNull(pendingIntent);
            this.mAppIntent = pendingIntent;
            return this;
        }

        public final StatelessBuilder setCustomIcon(Icon icon) {
            this.mCustomIcon = icon;
            return this;
        }

        public final StatelessBuilder setCustomColor(ColorStateList colorStateList) {
            this.mCustomColor = colorStateList;
            return this;
        }

        public final Control build() {
            return new Control(this.mControlId, this.mDeviceType, this.mTitle, this.mSubtitle, this.mStructure, this.mZone, this.mAppIntent, this.mCustomIcon, this.mCustomColor, 0, ControlTemplate.NO_TEMPLATE, "");
        }
    }

    public static final class StatefulBuilder {
        private PendingIntent mAppIntent;
        private String mControlId;
        private ControlTemplate mControlTemplate = ControlTemplate.NO_TEMPLATE;
        private ColorStateList mCustomColor;
        private Icon mCustomIcon;
        private int mDeviceType = 0;
        private int mStatus = 0;
        private CharSequence mStatusText = "";
        private CharSequence mStructure;
        private CharSequence mSubtitle = "";
        private CharSequence mTitle = "";
        private CharSequence mZone;

        public StatefulBuilder(String str, PendingIntent pendingIntent) {
            Objects.requireNonNull(str);
            Objects.requireNonNull(pendingIntent);
            this.mControlId = str;
            this.mAppIntent = pendingIntent;
        }

        public StatefulBuilder(Control control) {
            Objects.requireNonNull(control);
            this.mControlId = control.mControlId;
            this.mDeviceType = control.mDeviceType;
            this.mTitle = control.mTitle;
            this.mSubtitle = control.mSubtitle;
            this.mStructure = control.mStructure;
            this.mZone = control.mZone;
            this.mAppIntent = control.mAppIntent;
            this.mCustomIcon = control.mCustomIcon;
            this.mCustomColor = control.mCustomColor;
            this.mStatus = control.mStatus;
            this.mControlTemplate = control.mControlTemplate;
            this.mStatusText = control.mStatusText;
        }

        public final StatefulBuilder setControlId(String str) {
            Objects.requireNonNull(str);
            this.mControlId = str;
            return this;
        }

        public final StatefulBuilder setDeviceType(int i) {
            if (!DeviceTypes.validDeviceType(i)) {
                Log.e("StatefulBuilder", "Invalid device type:".concat(String.valueOf(i)));
                this.mDeviceType = 0;
            } else {
                this.mDeviceType = i;
            }
            return this;
        }

        public final StatefulBuilder setTitle(CharSequence charSequence) {
            Objects.requireNonNull(charSequence);
            this.mTitle = charSequence;
            return this;
        }

        public final StatefulBuilder setSubtitle(CharSequence charSequence) {
            Objects.requireNonNull(charSequence);
            this.mSubtitle = charSequence;
            return this;
        }

        public final StatefulBuilder setStructure(CharSequence charSequence) {
            this.mStructure = charSequence;
            return this;
        }

        public final StatefulBuilder setZone(CharSequence charSequence) {
            this.mZone = charSequence;
            return this;
        }

        public final StatefulBuilder setAppIntent(PendingIntent pendingIntent) {
            Objects.requireNonNull(pendingIntent);
            this.mAppIntent = pendingIntent;
            return this;
        }

        public final StatefulBuilder setCustomIcon(Icon icon) {
            this.mCustomIcon = icon;
            return this;
        }

        public final StatefulBuilder setCustomColor(ColorStateList colorStateList) {
            this.mCustomColor = colorStateList;
            return this;
        }

        public final StatefulBuilder setStatus(int i) {
            if (i < 0 || i >= 5) {
                this.mStatus = 0;
                Log.e("StatefulBuilder", "Status unknown:".concat(String.valueOf(i)));
            } else {
                this.mStatus = i;
            }
            return this;
        }

        public final StatefulBuilder setControlTemplate(ControlTemplate controlTemplate) {
            Objects.requireNonNull(controlTemplate);
            this.mControlTemplate = controlTemplate;
            return this;
        }

        public final StatefulBuilder setStatusText(CharSequence charSequence) {
            Objects.requireNonNull(charSequence);
            this.mStatusText = charSequence;
            return this;
        }

        public final Control build() {
            return new Control(this.mControlId, this.mDeviceType, this.mTitle, this.mSubtitle, this.mStructure, this.mZone, this.mAppIntent, this.mCustomIcon, this.mCustomColor, this.mStatus, this.mControlTemplate, this.mStatusText);
        }
    }
}
