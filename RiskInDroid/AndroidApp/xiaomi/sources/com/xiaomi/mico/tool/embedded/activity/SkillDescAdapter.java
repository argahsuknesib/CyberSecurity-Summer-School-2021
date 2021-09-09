package com.xiaomi.mico.tool.embedded.activity;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.github.ornolfr.ratingview.RatingView;
import com.xiaomi.mico.api.model.SkillStore;
import com.xiaomi.mico.tool.embedded.activity.SkillDescAdapter;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;

public class SkillDescAdapter extends RecyclerView.O000000o<RecyclerView.O000OOo0> {
    static String skillID;
    private final Context mContext;
    private ArrayList<SkillStore.SkillDetailSection> mSectionData;

    public SkillDescAdapter(Context context) {
        this.mContext = context;
    }

    public void setSkillID(String str) {
        skillID = str;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [?, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public RecyclerView.O000OOo0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == "tips".hashCode()) {
            return new SectionTipsViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate((int) R.layout.skill_section_tips, viewGroup, false));
        } else if (i == "intro".hashCode()) {
            return new SectionIntroViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate((int) R.layout.skill_section_intro, viewGroup, false));
        } else if (i != "rating".hashCode()) {
            return null;
        } else {
            return new SectionRatingViewHolder(this.mContext, LayoutInflater.from(this.mContext).inflate((int) R.layout.skill_section_rating, viewGroup, false));
        }
    }

    public void onBindViewHolder(RecyclerView.O000OOo0 o000OOo0, int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType == "tips".hashCode()) {
            ((SectionTipsViewHolder) o000OOo0).refreshUI((SkillStore.SkillDetailSectionTips) this.mSectionData.get(i));
        } else if (itemViewType == "intro".hashCode()) {
            ((SectionIntroViewHolder) o000OOo0).refreshUI((SkillStore.SkillDetailSectionIntro) this.mSectionData.get(i));
        } else if (itemViewType == "rating".hashCode()) {
            ((SectionRatingViewHolder) o000OOo0).refreshUI((SkillStore.SkillDetailSectionRating) this.mSectionData.get(i));
        }
    }

    public int getItemCount() {
        ArrayList<SkillStore.SkillDetailSection> arrayList = this.mSectionData;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getItemViewType(int i) {
        return this.mSectionData.get(i).type.hashCode();
    }

    public void refreshData(ArrayList<SkillStore.SkillDetailSection> arrayList) {
        this.mSectionData = arrayList;
        notifyDataSetChanged();
    }

    public static class SectionIntroViewHolder extends RecyclerView.O000OOo0 {
        TextView intro;
        public final Context mContext;
        TextView name;

        public SectionIntroViewHolder(Context context, View view) {
            super(view);
            this.mContext = context;
            this.name = (TextView) view.findViewById(R.id.name);
            this.intro = (TextView) view.findViewById(R.id.intro);
        }

        public void refreshUI(SkillStore.SkillDetailSectionIntro skillDetailSectionIntro) {
            if (skillDetailSectionIntro.type == "tips") {
                this.name.setText(this.mContext.getString(R.string.skill_detail_intro));
            } else if (skillDetailSectionIntro.type == "intro") {
                this.name.setText(this.mContext.getString(R.string.skill_detail_func_desc));
            } else if (skillDetailSectionIntro.type == "rating") {
                this.name.setText(this.mContext.getString(R.string.skill_detail_func_desc));
            } else {
                this.name.setText(skillDetailSectionIntro.name);
            }
            this.intro.setText(skillDetailSectionIntro.intro);
            if (SkillDescAdapter.skillID == null || TextUtils.isEmpty(skillDetailSectionIntro.intro) || !"227104325158047771".equals(SkillDescAdapter.skillID)) {
                this.intro.setText(skillDetailSectionIntro.intro);
                return;
            }
            String str = skillDetailSectionIntro.intro + " " + this.mContext.getString(R.string.skill_mi_music_intro);
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ClickableSpan() {
                /* class com.xiaomi.mico.tool.embedded.activity.SkillDescAdapter.SectionIntroViewHolder.AnonymousClass1 */

                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setColor(SectionIntroViewHolder.this.mContext.getResources().getColor(R.color.mj_color_green_normal));
                    textPaint.setUnderlineText(true);
                }

                public void onClick(View view) {
                    SectionIntroViewHolder.this.mContext.startActivity(new Intent(SectionIntroViewHolder.this.mContext, MusicSkillVIPIntroActivity.class));
                }
            }, skillDetailSectionIntro.intro.length() + 1, str.length(), 33);
            this.intro.setHighlightColor(0);
            this.intro.setText(spannableString);
            this.intro.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static class SectionTipsViewHolder extends RecyclerView.O000OOo0 {
        private final Context mContext;
        TextView name;
        LinearLayout viewContainer;

        public SectionTipsViewHolder(Context context, View view) {
            super(view);
            this.mContext = context;
            this.name = (TextView) view.findViewById(R.id.name);
            this.viewContainer = (LinearLayout) view.findViewById(R.id.view_container);
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
         arg types: [?, android.widget.LinearLayout, int]
         candidates:
          ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
          ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
        public void refreshUI(SkillStore.SkillDetailSectionTips skillDetailSectionTips) {
            this.name.setText(skillDetailSectionTips.name);
            this.viewContainer.removeAllViews();
            for (int i = 0; i < skillDetailSectionTips.tipsList.size(); i++) {
                View inflate = LayoutInflater.from(this.mContext).inflate((int) R.layout.skill_section_tips_item, (ViewGroup) this.viewContainer, false);
                new SectionTipsItemViewHolder(inflate).refreshUI(i, skillDetailSectionTips.tipsList.get(i));
                this.viewContainer.addView(inflate);
            }
        }
    }

    public static class SectionTipsItemViewHolder {
        TextView desc1;
        TextView desc2;
        TextView title;

        public SectionTipsItemViewHolder(View view) {
            this.title = (TextView) view.findViewById(R.id.title);
            this.desc1 = (TextView) view.findViewById(R.id.desc1);
            this.desc2 = (TextView) view.findViewById(R.id.desc2);
        }

        public void refreshUI(int i, SkillStore.SkillTip skillTip) {
            this.title.setText(skillTip.title);
            if (skillTip.tips.size() > 0) {
                this.desc1.setText(skillTip.tips.get(0));
                if (skillTip.tips.size() > 1) {
                    this.desc2.setText(skillTip.tips.get(1));
                }
            }
            int i2 = R.drawable.tool_list_4;
            if (i == 0) {
                i2 = R.drawable.tool_list_1;
            } else if (i == 1) {
                i2 = R.drawable.tool_list_2;
            } else if (i == 2) {
                i2 = R.drawable.tool_list_3;
            }
            this.title.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
        }
    }

    public static class SectionRatingViewHolder extends RecyclerView.O000OOo0 {
        private final Context mContext;
        private SkillStore.SkillDetailSectionRating mData;
        TextView ratingInfo;
        RatingView ratingView;

        public SectionRatingViewHolder(Context context, View view) {
            super(view);
            this.mContext = context;
            this.ratingView = (RatingView) view.findViewById(R.id.rating_view);
            this.ratingInfo = (TextView) view.findViewById(R.id.rating_info);
            view.findViewById(R.id.setting_item_text).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$SkillDescAdapter$SectionRatingViewHolder$IX3Szkhjbg62rKExhlF4qdGsz6g */

                public final void onClick(View view) {
                    SkillDescAdapter.SectionRatingViewHolder.this.lambda$new$0$SkillDescAdapter$SectionRatingViewHolder(view);
                }
            });
            view.findViewById(R.id.setting_item_more).setOnClickListener(new View.OnClickListener() {
                /* class com.xiaomi.mico.tool.embedded.activity.$$Lambda$SkillDescAdapter$SectionRatingViewHolder$AgruelMHdxN6fLVBKZbVbnj49I */

                public final void onClick(View view) {
                    SkillDescAdapter.SectionRatingViewHolder.this.lambda$new$1$SkillDescAdapter$SectionRatingViewHolder(view);
                }
            });
        }

        public /* synthetic */ void lambda$new$0$SkillDescAdapter$SectionRatingViewHolder(View view) {
            onViewClicked();
        }

        public /* synthetic */ void lambda$new$1$SkillDescAdapter$SectionRatingViewHolder(View view) {
            onViewClicked();
        }

        public void refreshUI(SkillStore.SkillDetailSectionRating skillDetailSectionRating) {
            this.mData = skillDetailSectionRating;
            this.ratingView.setRating(skillDetailSectionRating.getUserAvgRating());
            this.ratingInfo.setText(this.mContext.getString(R.string.skill_intro_section_rating_info, Float.valueOf(skillDetailSectionRating.getUserAvgRating()), Long.valueOf(skillDetailSectionRating.getUserRatingCount())));
        }

        public void onViewClicked() {
            Intent intent = new Intent(this.mContext, SkillRatingActivity.class);
            intent.putExtra("skill_id", this.mData.getSkillId());
            this.mContext.startActivity(intent);
        }
    }
}
