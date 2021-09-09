package com.mi.global.shop.widget;

import _m_j.cad;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.mi.global.shop.newmodel.cart.NewCartItem;
import com.mi.global.shop.newmodel.home.NewHomeBlockInfoItem;
import com.xiaomi.smarthome.R;

public class EasyTextView extends CustomTextView {
    public EasyTextView(Context context) {
        super(context);
    }

    public EasyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EasyTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (TextUtils.isEmpty(charSequence)) {
            super.setText("", bufferType);
        } else {
            super.setText(charSequence, bufferType);
        }
    }

    public void setPrize(NewHomeBlockInfoItem newHomeBlockInfoItem) {
        String str;
        String str2;
        String str3;
        if (newHomeBlockInfoItem.mProductPrice == null || newHomeBlockInfoItem.mFullPrice == null || newHomeBlockInfoItem.mProductPrice.endsWith(newHomeBlockInfoItem.mFullPrice)) {
            if (TextUtils.isEmpty(newHomeBlockInfoItem.mTProductPrice)) {
                str = cad.O00000o0() + newHomeBlockInfoItem.mProductPrice;
            } else {
                str = newHomeBlockInfoItem.mTProductPrice;
            }
            setText(str);
            return;
        }
        if (TextUtils.isEmpty(newHomeBlockInfoItem.mTProductPrice)) {
            str2 = cad.O00000o0() + newHomeBlockInfoItem.mProductPrice;
        } else {
            str2 = newHomeBlockInfoItem.mTProductPrice;
        }
        if (TextUtils.isEmpty(newHomeBlockInfoItem.mTFullPrice)) {
            str3 = cad.O00000o0() + newHomeBlockInfoItem.mFullPrice;
        } else {
            str3 = newHomeBlockInfoItem.mTFullPrice;
        }
        SpannableString spannableString = new SpannableString(str2 + " " + str3);
        spannableString.setSpan(new StrikethroughSpan(), str2.length() + 1, spannableString.length(), 17);
        spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.product_detail_qna_second_text_color)), str2.length() + 1, spannableString.length(), 17);
        setText(spannableString);
    }

    public void setPrize(NewCartItem newCartItem) {
        if (TextUtils.isEmpty(newCartItem.marketPrice_txt) || newCartItem.marketPrice_txt.equals(newCartItem.salePrice_txt)) {
            setText(cad.O00000o0() + newCartItem.salePrice_txt);
            return;
        }
        String str = cad.O00000o0() + newCartItem.marketPrice_txt;
        String str2 = cad.O00000o0() + newCartItem.salePrice_txt;
        SpannableString spannableString = new SpannableString(str2 + " " + str);
        spannableString.setSpan(new StrikethroughSpan(), str2.length() + 1, spannableString.length(), 17);
        spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.product_detail_qna_second_text_color)), str2.length() + 1, spannableString.length(), 17);
        setText(spannableString);
    }
}
