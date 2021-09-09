package com.zhy.view.flowlayout;

import _m_j.iqd;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.smarthome.R;
import java.util.HashSet;
import java.util.Set;

public class TagFlowLayout extends FlowLayout implements iqd.O000000o {
    int O00000o;
    Set<Integer> O00000oO;
    O000000o O00000oo;
    public O00000Oo O0000O0o;
    private iqd O0000OOo;

    public interface O000000o {
    }

    public interface O00000Oo {
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000o = -1;
        this.O00000oO = new HashSet();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.max_select, R.attr.tag_gravity});
        this.O00000o = obtainStyledAttributes.getInt(0, -1);
        obtainStyledAttributes.recycle();
    }

    public TagFlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TagFlowLayout(Context context) {
        this(context, null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            TagView tagView = (TagView) getChildAt(i3);
            if (tagView.getVisibility() != 8 && tagView.getTagView().getVisibility() == 8) {
                tagView.setVisibility(8);
            }
        }
        super.onMeasure(i, i2);
    }

    public void setOnSelectListener(O000000o o000000o) {
        this.O00000oo = o000000o;
    }

    public void setOnTagClickListener(O00000Oo o00000Oo) {
        this.O0000O0o = o00000Oo;
    }

    public void setAdapter(iqd iqd) {
        this.O0000OOo = iqd;
        this.O0000OOo.O00000Oo = this;
        this.O00000oO.clear();
        removeAllViews();
        iqd iqd2 = this.O0000OOo;
        HashSet<Integer> hashSet = iqd2.O00000o0;
        final int i = 0;
        while (true) {
            if (i < (iqd2.f1552O000000o == null ? 0 : iqd2.f1552O000000o.size())) {
                iqd2.O000000o(i);
                View O000000o2 = iqd2.O000000o();
                final TagView tagView = new TagView(getContext());
                O000000o2.setDuplicateParentStateEnabled(true);
                if (O000000o2.getLayoutParams() != null) {
                    tagView.setLayoutParams(O000000o2.getLayoutParams());
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
                    marginLayoutParams.setMargins(O000000o(getContext()), O000000o(getContext()), O000000o(getContext()), O000000o(getContext()));
                    tagView.setLayoutParams(marginLayoutParams);
                }
                O000000o2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                tagView.addView(O000000o2);
                addView(tagView);
                if (hashSet.contains(Integer.valueOf(i))) {
                    O000000o(i, tagView);
                }
                iqd2.O000000o(i);
                O000000o2.setClickable(false);
                tagView.setOnClickListener(new View.OnClickListener() {
                    /* class com.zhy.view.flowlayout.TagFlowLayout.AnonymousClass1 */

                    public final void onClick(View view) {
                        TagFlowLayout tagFlowLayout = TagFlowLayout.this;
                        TagView tagView = tagView;
                        int i = i;
                        if (tagView.isChecked()) {
                            TagFlowLayout.O00000Oo(i, tagView);
                            tagFlowLayout.O00000oO.remove(Integer.valueOf(i));
                        } else if (tagFlowLayout.O00000o == 1 && tagFlowLayout.O00000oO.size() == 1) {
                            Integer next = tagFlowLayout.O00000oO.iterator().next();
                            TagFlowLayout.O00000Oo(next.intValue(), (TagView) tagFlowLayout.getChildAt(next.intValue()));
                            TagFlowLayout.O000000o(i, tagView);
                            tagFlowLayout.O00000oO.remove(next);
                            tagFlowLayout.O00000oO.add(Integer.valueOf(i));
                        } else if (tagFlowLayout.O00000o <= 0 || tagFlowLayout.O00000oO.size() < tagFlowLayout.O00000o) {
                            TagFlowLayout.O000000o(i, tagView);
                            tagFlowLayout.O00000oO.add(Integer.valueOf(i));
                        } else {
                            return;
                        }
                        if (tagFlowLayout.O00000oo != null) {
                            new HashSet(tagFlowLayout.O00000oO);
                        }
                    }
                });
                i++;
            } else {
                this.O00000oO.addAll(hashSet);
                return;
            }
        }
    }

    public void setMaxSelectCount(int i) {
        if (this.O00000oO.size() > i) {
            Log.w("TagFlowLayout", "you has already select more than " + i + " views , so it will be clear .");
            this.O00000oO.clear();
        }
        this.O00000o = i;
    }

    public Set<Integer> getSelectedList() {
        return new HashSet(this.O00000oO);
    }

    static void O000000o(int i, TagView tagView) {
        tagView.setChecked(true);
        tagView.getTagView();
        iqd.O00000Oo(i);
    }

    static void O00000Oo(int i, TagView tagView) {
        tagView.setChecked(false);
        tagView.getTagView();
        Log.d("zhy", "unSelected ".concat(String.valueOf(i)));
    }

    public iqd getAdapter() {
        return this.O0000OOo;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_default", super.onSaveInstanceState());
        String str = "";
        if (this.O00000oO.size() > 0) {
            for (Integer intValue : this.O00000oO) {
                str = str + intValue.intValue() + "|";
            }
            str = str.substring(0, str.length() - 1);
        }
        bundle.putString("key_choose_pos", str);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            String string = bundle.getString("key_choose_pos");
            if (!TextUtils.isEmpty(string)) {
                for (String parseInt : string.split("\\|")) {
                    int parseInt2 = Integer.parseInt(parseInt);
                    this.O00000oO.add(Integer.valueOf(parseInt2));
                    TagView tagView = (TagView) getChildAt(parseInt2);
                    if (tagView != null) {
                        O000000o(parseInt2, tagView);
                    }
                }
            }
            super.onRestoreInstanceState(bundle.getParcelable("key_default"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    private static int O000000o(Context context) {
        return (int) ((context.getResources().getDisplayMetrics().density * 5.0f) + 0.5f);
    }
}
