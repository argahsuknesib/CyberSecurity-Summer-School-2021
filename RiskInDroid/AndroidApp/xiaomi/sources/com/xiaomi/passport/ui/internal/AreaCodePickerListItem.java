package com.xiaomi.passport.ui.internal;

import _m_j.ixe;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xiaomi.passport.ui.R$id;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0013\u001a\u00020\u000eH\u0014R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/xiaomi/passport/ui/internal/AreaCodePickerListItem;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mAreaCodeView", "Landroid/widget/TextView;", "mAreaView", "mHeaderLayout", "Landroid/view/View;", "mSectionHeader", "bind", "", "data", "Lcom/xiaomi/passport/ui/internal/PhoneNumUtil$CountryPhoneNumData;", "sectionHeaderText", "", "onFinishInflate", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class AreaCodePickerListItem extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    TextView f6238O000000o;
    TextView O00000Oo;
    View O00000o;
    TextView O00000o0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AreaCodePickerListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ixe.O00000o0(context, "context");
        ixe.O00000o0(attributeSet, "attrs");
    }

    /* access modifiers changed from: protected */
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f6238O000000o = (TextView) findViewById(R$id.area);
        this.O00000Oo = (TextView) findViewById(R$id.area_code);
        this.O00000o0 = (TextView) findViewById(R$id.section_header);
        this.O00000o = findViewById(R$id.section_header_layout);
    }
}
