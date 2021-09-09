package com.alibaba.android.arouter.facade;

import _m_j.ny;
import _m_j.oOOO0oOO;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.service.SerializationService;
import com.alibaba.android.arouter.facade.template.IProvider;
import java.io.Serializable;
import java.util.ArrayList;

public final class Postcard extends RouteMeta {
    private String action;
    private int enterAnim;
    private int exitAnim;
    private int flags;
    private boolean greenChannel;
    private Bundle mBundle;
    private Bundle optionsCompat;
    private IProvider provider;
    private SerializationService serializationService;
    private Object tag;
    private int timeout;
    private Uri uri;

    public final Bundle getOptionsBundle() {
        return this.optionsCompat;
    }

    public final int getEnterAnim() {
        return this.enterAnim;
    }

    public final int getExitAnim() {
        return this.exitAnim;
    }

    public final IProvider getProvider() {
        return this.provider;
    }

    public final Postcard setProvider(IProvider iProvider) {
        this.provider = iProvider;
        return this;
    }

    public Postcard() {
        this(null, null);
    }

    public Postcard(String str, String str2) {
        this(str, str2, null, null);
    }

    public Postcard(String str, String str2, Uri uri2, Bundle bundle) {
        this.flags = -1;
        this.timeout = 300;
        this.enterAnim = -1;
        this.exitAnim = -1;
        setPath(str);
        setGroup(str2);
        setUri(uri2);
        this.mBundle = bundle == null ? new Bundle() : bundle;
    }

    public final boolean isGreenChannel() {
        return this.greenChannel;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final Postcard setTag(Object obj) {
        this.tag = obj;
        return this;
    }

    public final Bundle getExtras() {
        return this.mBundle;
    }

    public final int getTimeout() {
        return this.timeout;
    }

    public final Postcard setTimeout(int i) {
        this.timeout = i;
        return this;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final Postcard setUri(Uri uri2) {
        this.uri = uri2;
        return this;
    }

    public final Object navigation() {
        return navigation(null);
    }

    public final Object navigation(Context context) {
        return navigation(context, (NavigationCallback) null);
    }

    public final Object navigation(Context context, NavigationCallback navigationCallback) {
        ny.O000000o();
        return ny.O000000o(context, this, -1, navigationCallback);
    }

    public final void navigation(Activity activity, int i) {
        navigation(activity, i, null);
    }

    public final void navigation(Activity activity, int i, NavigationCallback navigationCallback) {
        ny.O000000o();
        ny.O000000o(activity, this, i, navigationCallback);
    }

    public final Postcard greenChannel() {
        this.greenChannel = true;
        return this;
    }

    public final Postcard with(Bundle bundle) {
        if (bundle != null) {
            this.mBundle = bundle;
        }
        return this;
    }

    public final Postcard withFlags(int i) {
        this.flags = i;
        return this;
    }

    public final Postcard addFlags(int i) {
        this.flags = i | this.flags;
        return this;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final Postcard withObject(String str, Object obj) {
        ny.O000000o();
        this.serializationService = (SerializationService) ny.O000000o(SerializationService.class);
        this.mBundle.putString(str, this.serializationService.object2Json(obj));
        return this;
    }

    public final Postcard withString(String str, String str2) {
        this.mBundle.putString(str, str2);
        return this;
    }

    public final Postcard withBoolean(String str, boolean z) {
        this.mBundle.putBoolean(str, z);
        return this;
    }

    public final Postcard withShort(String str, short s) {
        this.mBundle.putShort(str, s);
        return this;
    }

    public final Postcard withInt(String str, int i) {
        this.mBundle.putInt(str, i);
        return this;
    }

    public final Postcard withLong(String str, long j) {
        this.mBundle.putLong(str, j);
        return this;
    }

    public final Postcard withDouble(String str, double d) {
        this.mBundle.putDouble(str, d);
        return this;
    }

    public final Postcard withByte(String str, byte b) {
        this.mBundle.putByte(str, b);
        return this;
    }

    public final Postcard withChar(String str, char c) {
        this.mBundle.putChar(str, c);
        return this;
    }

    public final Postcard withFloat(String str, float f) {
        this.mBundle.putFloat(str, f);
        return this;
    }

    public final Postcard withCharSequence(String str, CharSequence charSequence) {
        this.mBundle.putCharSequence(str, charSequence);
        return this;
    }

    public final Postcard withParcelable(String str, Parcelable parcelable) {
        this.mBundle.putParcelable(str, parcelable);
        return this;
    }

    public final Postcard withParcelableArray(String str, Parcelable[] parcelableArr) {
        this.mBundle.putParcelableArray(str, parcelableArr);
        return this;
    }

    public final Postcard withParcelableArrayList(String str, ArrayList<? extends Parcelable> arrayList) {
        this.mBundle.putParcelableArrayList(str, arrayList);
        return this;
    }

    public final Postcard withSparseParcelableArray(String str, SparseArray<? extends Parcelable> sparseArray) {
        this.mBundle.putSparseParcelableArray(str, sparseArray);
        return this;
    }

    public final Postcard withIntegerArrayList(String str, ArrayList<Integer> arrayList) {
        this.mBundle.putIntegerArrayList(str, arrayList);
        return this;
    }

    public final Postcard withStringArrayList(String str, ArrayList<String> arrayList) {
        this.mBundle.putStringArrayList(str, arrayList);
        return this;
    }

    public final Postcard withCharSequenceArrayList(String str, ArrayList<CharSequence> arrayList) {
        this.mBundle.putCharSequenceArrayList(str, arrayList);
        return this;
    }

    public final Postcard withSerializable(String str, Serializable serializable) {
        this.mBundle.putSerializable(str, serializable);
        return this;
    }

    public final Postcard withByteArray(String str, byte[] bArr) {
        this.mBundle.putByteArray(str, bArr);
        return this;
    }

    public final Postcard withShortArray(String str, short[] sArr) {
        this.mBundle.putShortArray(str, sArr);
        return this;
    }

    public final Postcard withCharArray(String str, char[] cArr) {
        this.mBundle.putCharArray(str, cArr);
        return this;
    }

    public final Postcard withFloatArray(String str, float[] fArr) {
        this.mBundle.putFloatArray(str, fArr);
        return this;
    }

    public final Postcard withCharSequenceArray(String str, CharSequence[] charSequenceArr) {
        this.mBundle.putCharSequenceArray(str, charSequenceArr);
        return this;
    }

    public final Postcard withBundle(String str, Bundle bundle) {
        this.mBundle.putBundle(str, bundle);
        return this;
    }

    public final Postcard withTransition(int i, int i2) {
        this.enterAnim = i;
        this.exitAnim = i2;
        return this;
    }

    public final Postcard withOptionsCompat(oOOO0oOO oooo0ooo) {
        if (oooo0ooo != null) {
            this.optionsCompat = oooo0ooo.O000000o();
        }
        return this;
    }

    public final String toString() {
        return "Postcard{uri=" + this.uri + ", tag=" + this.tag + ", mBundle=" + this.mBundle + ", flags=" + this.flags + ", timeout=" + this.timeout + ", provider=" + this.provider + ", greenChannel=" + this.greenChannel + ", optionsCompat=" + this.optionsCompat + ", enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + "}\n" + super.toString();
    }

    public final String getAction() {
        return this.action;
    }

    public final Postcard withAction(String str) {
        this.action = str;
        return this;
    }
}
