package pl.droidsonroids.gif;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Locale;

public class GifAnimationMetaData implements Parcelable, Serializable {
    public static final Parcelable.Creator<GifAnimationMetaData> CREATOR = new Parcelable.Creator<GifAnimationMetaData>() {
        /* class pl.droidsonroids.gif.GifAnimationMetaData.AnonymousClass1 */

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GifAnimationMetaData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GifAnimationMetaData(parcel, (byte) 0);
        }
    };
    private static final long serialVersionUID = 5692363926580237325L;
    private final int mDuration;
    private final int mHeight;
    private final int mImageCount;
    private final int mLoopCount;
    private final long mMetadataBytesCount;
    private final long mPixelsBytesCount;
    private final int mWidth;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ GifAnimationMetaData(Parcel parcel, byte b) {
        this(parcel);
    }

    public String toString() {
        int i = this.mLoopCount;
        boolean z = false;
        String format = String.format(Locale.ENGLISH, "GIF: size: %dx%d, frames: %d, loops: %s, duration: %d", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), Integer.valueOf(this.mImageCount), i == 0 ? "Infinity" : Integer.toString(i), Integer.valueOf(this.mDuration));
        if (this.mImageCount > 1 && this.mDuration > 0) {
            z = true;
        }
        return z ? "Animated ".concat(String.valueOf(format)) : format;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mLoopCount);
        parcel.writeInt(this.mDuration);
        parcel.writeInt(this.mHeight);
        parcel.writeInt(this.mWidth);
        parcel.writeInt(this.mImageCount);
        parcel.writeLong(this.mMetadataBytesCount);
        parcel.writeLong(this.mPixelsBytesCount);
    }

    private GifAnimationMetaData(Parcel parcel) {
        this.mLoopCount = parcel.readInt();
        this.mDuration = parcel.readInt();
        this.mHeight = parcel.readInt();
        this.mWidth = parcel.readInt();
        this.mImageCount = parcel.readInt();
        this.mMetadataBytesCount = parcel.readLong();
        this.mPixelsBytesCount = parcel.readLong();
    }
}
