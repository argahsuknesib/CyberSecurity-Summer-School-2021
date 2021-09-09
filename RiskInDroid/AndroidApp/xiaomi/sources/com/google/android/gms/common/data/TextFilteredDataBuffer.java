package com.google.android.gms.common.data;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.TextFilterable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Locale;

public final class TextFilteredDataBuffer<T> extends FilteredDataBuffer<T> implements TextFilterable {
    private final ArrayList<Integer> zzob = new ArrayList<>();
    private AbstractDataBuffer<T> zzoc;
    private final String zzoo;
    private String zzop;
    private TextFilterable.StringFilter zzoq;
    private Locale zzor;

    public TextFilteredDataBuffer(AbstractDataBuffer<T> abstractDataBuffer, String str) {
        super(abstractDataBuffer);
        this.zzoc = abstractDataBuffer;
        this.zzoo = str;
    }

    private final String zzh(String str) {
        String lowerCase = str.toLowerCase(this.zzor);
        StringBuilder sb = new StringBuilder();
        int length = lowerCase.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isIdentifierIgnorable(lowerCase.charAt(i))) {
                sb.append(lowerCase.charAt(i));
            }
        }
        return sb.toString();
    }

    public final int computeRealPosition(int i) {
        if (TextUtils.isEmpty(this.zzop)) {
            return i;
        }
        if (i >= 0 && i < this.zzob.size()) {
            return this.zzob.get(i).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }

    public final int getCount() {
        return TextUtils.isEmpty(this.zzop) ? this.mDataBuffer.getCount() : this.zzob.size();
    }

    public final void setFilterTerm(Context context, TextFilterable.StringFilter stringFilter, String str) {
        Preconditions.checkNotNull(stringFilter);
        this.zzop = str;
        this.zzoq = stringFilter;
        if (!TextUtils.isEmpty(this.zzop)) {
            this.zzor = context.getResources().getConfiguration().locale;
            this.zzop = zzh(this.zzop);
            this.zzob.clear();
            DataHolder dataHolder = this.zzoc.mDataHolder;
            String str2 = this.zzoo;
            AbstractDataBuffer<T> abstractDataBuffer = this.zzoc;
            boolean z = abstractDataBuffer instanceof EntityBuffer;
            int count = abstractDataBuffer.getCount();
            for (int i = 0; i < count; i++) {
                int zzi = z ? ((EntityBuffer) this.zzoc).zzi(i) : i;
                String string = dataHolder.getString(str2, zzi, dataHolder.getWindowIndex(zzi));
                if (!TextUtils.isEmpty(string) && this.zzoq.matches(zzh(string), this.zzop)) {
                    this.zzob.add(Integer.valueOf(i));
                }
            }
            return;
        }
        this.zzob.clear();
    }

    @VisibleForTesting
    public final void setFilterTerm(Context context, String str) {
        setFilterTerm(context, CONTAINS, str);
    }
}
