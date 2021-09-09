package _m_j;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserException;

class OOo0000 extends Resources {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Resources f12339O000000o;

    public OOo0000(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f12339O000000o = resources;
    }

    public CharSequence getText(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getText(i);
    }

    public CharSequence getQuantityText(int i, int i2) throws Resources.NotFoundException {
        return this.f12339O000000o.getQuantityText(i, i2);
    }

    public String getString(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getString(i);
    }

    public String getString(int i, Object... objArr) throws Resources.NotFoundException {
        return this.f12339O000000o.getString(i, objArr);
    }

    public String getQuantityString(int i, int i2, Object... objArr) throws Resources.NotFoundException {
        return this.f12339O000000o.getQuantityString(i, i2, objArr);
    }

    public String getQuantityString(int i, int i2) throws Resources.NotFoundException {
        return this.f12339O000000o.getQuantityString(i, i2);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.f12339O000000o.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getTextArray(i);
    }

    public String[] getStringArray(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getStringArray(i);
    }

    public int[] getIntArray(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getIntArray(i);
    }

    public TypedArray obtainTypedArray(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.obtainTypedArray(i);
    }

    public float getDimension(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getDimensionPixelSize(i);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.f12339O000000o.getFraction(i, i2, i3);
    }

    public Drawable getDrawable(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getDrawable(i);
    }

    public Drawable getDrawable(int i, Resources.Theme theme) throws Resources.NotFoundException {
        return this.f12339O000000o.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) throws Resources.NotFoundException {
        return this.f12339O000000o.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme theme) {
        return this.f12339O000000o.getDrawableForDensity(i, i2, theme);
    }

    public Movie getMovie(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getMovie(i);
    }

    public int getColor(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getColor(i);
    }

    public ColorStateList getColorStateList(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getColorStateList(i);
    }

    public boolean getBoolean(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getBoolean(i);
    }

    public int getInteger(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getLayout(i);
    }

    public XmlResourceParser getAnimation(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getAnimation(i);
    }

    public XmlResourceParser getXml(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getXml(i);
    }

    public InputStream openRawResource(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) throws Resources.NotFoundException {
        return this.f12339O000000o.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.openRawResourceFd(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f12339O000000o.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f12339O000000o.getValueForDensity(i, i2, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) throws Resources.NotFoundException {
        this.f12339O000000o.getValue(str, typedValue, z);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.f12339O000000o.obtainAttributes(attributeSet, iArr);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.f12339O000000o;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.f12339O000000o.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.f12339O000000o.getConfiguration();
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.f12339O000000o.getIdentifier(str, str2, str3);
    }

    public String getResourceName(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getResourceName(i);
    }

    public String getResourcePackageName(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getResourceTypeName(i);
    }

    public String getResourceEntryName(int i) throws Resources.NotFoundException {
        return this.f12339O000000o.getResourceEntryName(i);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) throws XmlPullParserException, IOException {
        this.f12339O000000o.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) throws XmlPullParserException {
        this.f12339O000000o.parseBundleExtra(str, attributeSet, bundle);
    }
}
