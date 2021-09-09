package com.facebook.share.widget;

import _m_j.ft;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookException;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.internal.LikeActionController;
import com.facebook.share.internal.LikeBoxCountView;
import com.facebook.share.internal.LikeButton;
import com.xiaomi.smarthome.R;

@Deprecated
public class LikeView extends FrameLayout {
    private AuxiliaryViewPosition auxiliaryViewPosition = AuxiliaryViewPosition.DEFAULT;
    private BroadcastReceiver broadcastReceiver;
    private LinearLayout containerView;
    public LikeActionControllerCreationCallback creationCallback;
    private int edgePadding;
    private boolean explicitlyDisabled = true;
    private int foregroundColor = -1;
    private HorizontalAlignment horizontalAlignment = HorizontalAlignment.DEFAULT;
    private int internalPadding;
    private LikeActionController likeActionController;
    private LikeBoxCountView likeBoxCountView;
    private LikeButton likeButton;
    private Style likeViewStyle = Style.DEFAULT;
    public String objectId;
    public ObjectType objectType;
    public OnErrorListener onErrorListener;
    private FragmentWrapper parentFragment;
    private TextView socialSentenceView;

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Deprecated
    public static final class ObjectType extends Enum<ObjectType> {
        private static final /* synthetic */ ObjectType[] $VALUES;
        public static ObjectType DEFAULT;
        public static final ObjectType OPEN_GRAPH = new ObjectType("OPEN_GRAPH", 1, "open_graph", 1);
        public static final ObjectType PAGE = new ObjectType("PAGE", 2, "page", 2);
        public static final ObjectType UNKNOWN = new ObjectType("UNKNOWN", 0, "unknown", 0);
        private int intValue;
        private String stringValue;

        public static ObjectType valueOf(String str) {
            return (ObjectType) Enum.valueOf(ObjectType.class, str);
        }

        public static ObjectType[] values() {
            return (ObjectType[]) $VALUES.clone();
        }

        static {
            ObjectType objectType = UNKNOWN;
            $VALUES = new ObjectType[]{objectType, OPEN_GRAPH, PAGE};
            DEFAULT = objectType;
        }

        public static ObjectType fromInt(int i) {
            for (ObjectType objectType : values()) {
                if (objectType.getValue() == i) {
                    return objectType;
                }
            }
            return null;
        }

        private ObjectType(String str, int i, String str2, int i2) {
            this.stringValue = str2;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        public final int getValue() {
            return this.intValue;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Deprecated
    public static final class Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES;
        public static final Style BOX_COUNT = new Style("BOX_COUNT", 2, "box_count", 2);
        public static final Style BUTTON = new Style("BUTTON", 1, "button", 1);
        static Style DEFAULT;
        public static final Style STANDARD = new Style("STANDARD", 0, "standard", 0);
        private int intValue;
        private String stringValue;

        public static Style valueOf(String str) {
            return (Style) Enum.valueOf(Style.class, str);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        static {
            Style style = STANDARD;
            $VALUES = new Style[]{style, BUTTON, BOX_COUNT};
            DEFAULT = style;
        }

        static Style fromInt(int i) {
            for (Style style : values()) {
                if (style.getValue() == i) {
                    return style;
                }
            }
            return null;
        }

        private Style(String str, int i, String str2, int i2) {
            this.stringValue = str2;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        public final int getValue() {
            return this.intValue;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Deprecated
    public static final class HorizontalAlignment extends Enum<HorizontalAlignment> {
        private static final /* synthetic */ HorizontalAlignment[] $VALUES;
        public static final HorizontalAlignment CENTER = new HorizontalAlignment("CENTER", 0, "center", 0);
        static HorizontalAlignment DEFAULT;
        public static final HorizontalAlignment LEFT = new HorizontalAlignment("LEFT", 1, "left", 1);
        public static final HorizontalAlignment RIGHT = new HorizontalAlignment("RIGHT", 2, "right", 2);
        private int intValue;
        private String stringValue;

        public static HorizontalAlignment valueOf(String str) {
            return (HorizontalAlignment) Enum.valueOf(HorizontalAlignment.class, str);
        }

        public static HorizontalAlignment[] values() {
            return (HorizontalAlignment[]) $VALUES.clone();
        }

        static {
            HorizontalAlignment horizontalAlignment = CENTER;
            $VALUES = new HorizontalAlignment[]{horizontalAlignment, LEFT, RIGHT};
            DEFAULT = horizontalAlignment;
        }

        static HorizontalAlignment fromInt(int i) {
            for (HorizontalAlignment horizontalAlignment : values()) {
                if (horizontalAlignment.getValue() == i) {
                    return horizontalAlignment;
                }
            }
            return null;
        }

        private HorizontalAlignment(String str, int i, String str2, int i2) {
            this.stringValue = str2;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        public final int getValue() {
            return this.intValue;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    @Deprecated
    public static final class AuxiliaryViewPosition extends Enum<AuxiliaryViewPosition> {
        private static final /* synthetic */ AuxiliaryViewPosition[] $VALUES;
        public static final AuxiliaryViewPosition BOTTOM = new AuxiliaryViewPosition("BOTTOM", 0, "bottom", 0);
        static AuxiliaryViewPosition DEFAULT;
        public static final AuxiliaryViewPosition INLINE = new AuxiliaryViewPosition("INLINE", 1, "inline", 1);
        public static final AuxiliaryViewPosition TOP = new AuxiliaryViewPosition("TOP", 2, "top", 2);
        private int intValue;
        private String stringValue;

        public static AuxiliaryViewPosition valueOf(String str) {
            return (AuxiliaryViewPosition) Enum.valueOf(AuxiliaryViewPosition.class, str);
        }

        public static AuxiliaryViewPosition[] values() {
            return (AuxiliaryViewPosition[]) $VALUES.clone();
        }

        static {
            AuxiliaryViewPosition auxiliaryViewPosition = BOTTOM;
            $VALUES = new AuxiliaryViewPosition[]{auxiliaryViewPosition, INLINE, TOP};
            DEFAULT = auxiliaryViewPosition;
        }

        static AuxiliaryViewPosition fromInt(int i) {
            for (AuxiliaryViewPosition auxiliaryViewPosition : values()) {
                if (auxiliaryViewPosition.getValue() == i) {
                    return auxiliaryViewPosition;
                }
            }
            return null;
        }

        private AuxiliaryViewPosition(String str, int i, String str2, int i2) {
            this.stringValue = str2;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        public final int getValue() {
            return this.intValue;
        }
    }

    @Deprecated
    public LikeView(Context context) {
        super(context);
        initialize(context);
    }

    @Deprecated
    public LikeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        parseAttributes(attributeSet);
        initialize(context);
    }

    @Deprecated
    public void setObjectIdAndType(String str, ObjectType objectType2) {
        String coerceValueIfNullOrEmpty = Utility.coerceValueIfNullOrEmpty(str, null);
        if (objectType2 == null) {
            objectType2 = ObjectType.DEFAULT;
        }
        if (!Utility.areObjectsEqual(coerceValueIfNullOrEmpty, this.objectId) || objectType2 != this.objectType) {
            setObjectIdAndTypeForced(coerceValueIfNullOrEmpty, objectType2);
            updateLikeStateAndLayout();
        }
    }

    @Deprecated
    public void setLikeViewStyle(Style style) {
        if (style == null) {
            style = Style.DEFAULT;
        }
        if (this.likeViewStyle != style) {
            this.likeViewStyle = style;
            updateLayout();
        }
    }

    @Deprecated
    public void setAuxiliaryViewPosition(AuxiliaryViewPosition auxiliaryViewPosition2) {
        if (auxiliaryViewPosition2 == null) {
            auxiliaryViewPosition2 = AuxiliaryViewPosition.DEFAULT;
        }
        if (this.auxiliaryViewPosition != auxiliaryViewPosition2) {
            this.auxiliaryViewPosition = auxiliaryViewPosition2;
            updateLayout();
        }
    }

    @Deprecated
    public void setHorizontalAlignment(HorizontalAlignment horizontalAlignment2) {
        if (horizontalAlignment2 == null) {
            horizontalAlignment2 = HorizontalAlignment.DEFAULT;
        }
        if (this.horizontalAlignment != horizontalAlignment2) {
            this.horizontalAlignment = horizontalAlignment2;
            updateLayout();
        }
    }

    @Deprecated
    public void setForegroundColor(int i) {
        if (this.foregroundColor != i) {
            this.socialSentenceView.setTextColor(i);
        }
    }

    @Deprecated
    public void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    @Deprecated
    public OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    @Deprecated
    public void setFragment(Fragment fragment) {
        this.parentFragment = new FragmentWrapper(fragment);
    }

    @Deprecated
    public void setFragment(android.app.Fragment fragment) {
        this.parentFragment = new FragmentWrapper(fragment);
    }

    @Deprecated
    public void setEnabled(boolean z) {
        this.explicitlyDisabled = true;
        updateLikeStateAndLayout();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        setObjectIdAndType(null, ObjectType.UNKNOWN);
        super.onDetachedFromWindow();
    }

    private void parseAttributes(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (attributeSet != null && getContext() != null && (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.com_facebook_auxiliary_view_position, R.attr.com_facebook_foreground_color, R.attr.com_facebook_horizontal_alignment, R.attr.com_facebook_object_id, R.attr.com_facebook_object_type, R.attr.com_facebook_style})) != null) {
            this.objectId = Utility.coerceValueIfNullOrEmpty(obtainStyledAttributes.getString(3), null);
            this.objectType = ObjectType.fromInt(obtainStyledAttributes.getInt(4, ObjectType.DEFAULT.getValue()));
            this.likeViewStyle = Style.fromInt(obtainStyledAttributes.getInt(5, Style.DEFAULT.getValue()));
            if (this.likeViewStyle != null) {
                this.auxiliaryViewPosition = AuxiliaryViewPosition.fromInt(obtainStyledAttributes.getInt(0, AuxiliaryViewPosition.DEFAULT.getValue()));
                if (this.auxiliaryViewPosition != null) {
                    this.horizontalAlignment = HorizontalAlignment.fromInt(obtainStyledAttributes.getInt(2, HorizontalAlignment.DEFAULT.getValue()));
                    if (this.horizontalAlignment != null) {
                        this.foregroundColor = obtainStyledAttributes.getColor(1, -1);
                        obtainStyledAttributes.recycle();
                        return;
                    }
                    throw new IllegalArgumentException("Unsupported value for LikeView 'horizontal_alignment'");
                }
                throw new IllegalArgumentException("Unsupported value for LikeView 'auxiliary_view_position'");
            }
            throw new IllegalArgumentException("Unsupported value for LikeView 'style'");
        }
    }

    private void initialize(Context context) {
        this.edgePadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_edge_padding);
        this.internalPadding = getResources().getDimensionPixelSize(R.dimen.com_facebook_likeview_internal_padding);
        if (this.foregroundColor == -1) {
            this.foregroundColor = getResources().getColor(R.color.com_facebook_likeview_text_color);
        }
        setBackgroundColor(0);
        this.containerView = new LinearLayout(context);
        this.containerView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        initializeLikeButton(context);
        initializeSocialSentenceView(context);
        initializeLikeCountView(context);
        this.containerView.addView(this.likeButton);
        this.containerView.addView(this.socialSentenceView);
        this.containerView.addView(this.likeBoxCountView);
        addView(this.containerView);
        setObjectIdAndTypeForced(this.objectId, this.objectType);
        updateLikeStateAndLayout();
    }

    private void initializeLikeButton(Context context) {
        LikeActionController likeActionController2 = this.likeActionController;
        this.likeButton = new LikeButton(context, likeActionController2 != null && likeActionController2.isObjectLiked());
        this.likeButton.setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.share.widget.LikeView.AnonymousClass1 */

            public void onClick(View view) {
                LikeView.this.toggleLike();
            }
        });
        this.likeButton.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }

    private void initializeSocialSentenceView(Context context) {
        this.socialSentenceView = new TextView(context);
        this.socialSentenceView.setTextSize(0, getResources().getDimension(R.dimen.com_facebook_likeview_text_size));
        this.socialSentenceView.setMaxLines(2);
        this.socialSentenceView.setTextColor(this.foregroundColor);
        this.socialSentenceView.setGravity(17);
        this.socialSentenceView.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
    }

    private void initializeLikeCountView(Context context) {
        this.likeBoxCountView = new LikeBoxCountView(context);
        this.likeBoxCountView.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    }

    public void toggleLike() {
        if (this.likeActionController != null) {
            Activity activity = null;
            if (this.parentFragment == null) {
                activity = getActivity();
            }
            this.likeActionController.toggleLike(activity, this.parentFragment, getAnalyticsParameters());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0018  */
    private Activity getActivity() {
        boolean z;
        Context context = getContext();
        while (true) {
            z = context instanceof Activity;
            if (!z && (context instanceof ContextWrapper)) {
                context = ((ContextWrapper) context).getBaseContext();
            } else if (!z) {
                return (Activity) context;
            } else {
                throw new FacebookException("Unable to get Activity.");
            }
        }
        if (!z) {
        }
    }

    private Bundle getAnalyticsParameters() {
        Bundle bundle = new Bundle();
        bundle.putString("style", this.likeViewStyle.toString());
        bundle.putString("auxiliary_position", this.auxiliaryViewPosition.toString());
        bundle.putString("horizontal_alignment", this.horizontalAlignment.toString());
        bundle.putString("object_id", Utility.coerceValueIfNullOrEmpty(this.objectId, ""));
        bundle.putString("object_type", this.objectType.toString());
        return bundle;
    }

    public void setObjectIdAndTypeForced(String str, ObjectType objectType2) {
        tearDownObjectAssociations();
        this.objectId = str;
        this.objectType = objectType2;
        if (!Utility.isNullOrEmpty(str)) {
            this.creationCallback = new LikeActionControllerCreationCallback();
            if (!isInEditMode()) {
                LikeActionController.getControllerForObjectId(str, objectType2, this.creationCallback);
            }
        }
    }

    public void associateWithLikeActionController(LikeActionController likeActionController2) {
        this.likeActionController = likeActionController2;
        this.broadcastReceiver = new LikeControllerBroadcastReceiver();
        ft O000000o2 = ft.O000000o(getContext());
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR);
        intentFilter.addAction(LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET);
        O000000o2.O000000o(this.broadcastReceiver, intentFilter);
    }

    private void tearDownObjectAssociations() {
        if (this.broadcastReceiver != null) {
            ft.O000000o(getContext()).O000000o(this.broadcastReceiver);
            this.broadcastReceiver = null;
        }
        LikeActionControllerCreationCallback likeActionControllerCreationCallback = this.creationCallback;
        if (likeActionControllerCreationCallback != null) {
            likeActionControllerCreationCallback.cancel();
            this.creationCallback = null;
        }
        this.likeActionController = null;
    }

    public void updateLikeStateAndLayout() {
        boolean z = !this.explicitlyDisabled;
        LikeActionController likeActionController2 = this.likeActionController;
        if (likeActionController2 == null) {
            this.likeButton.setSelected(false);
            this.socialSentenceView.setText((CharSequence) null);
            this.likeBoxCountView.setText(null);
        } else {
            this.likeButton.setSelected(likeActionController2.isObjectLiked());
            this.socialSentenceView.setText(this.likeActionController.getSocialSentence());
            this.likeBoxCountView.setText(this.likeActionController.getLikeCountString());
            z &= this.likeActionController.shouldEnableView();
        }
        super.setEnabled(z);
        this.likeButton.setEnabled(z);
        updateLayout();
    }

    private void updateLayout() {
        View view;
        LikeActionController likeActionController2;
        LikeActionController likeActionController3;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.containerView.getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.likeButton.getLayoutParams();
        int i = this.horizontalAlignment == HorizontalAlignment.LEFT ? 3 : this.horizontalAlignment == HorizontalAlignment.CENTER ? 1 : 5;
        layoutParams.gravity = i | 48;
        layoutParams2.gravity = i;
        this.socialSentenceView.setVisibility(8);
        this.likeBoxCountView.setVisibility(8);
        if (this.likeViewStyle == Style.STANDARD && (likeActionController3 = this.likeActionController) != null && !Utility.isNullOrEmpty(likeActionController3.getSocialSentence())) {
            view = this.socialSentenceView;
        } else if (this.likeViewStyle == Style.BOX_COUNT && (likeActionController2 = this.likeActionController) != null && !Utility.isNullOrEmpty(likeActionController2.getLikeCountString())) {
            updateBoxCountCaretPosition();
            view = this.likeBoxCountView;
        } else {
            return;
        }
        int i2 = 0;
        view.setVisibility(0);
        ((LinearLayout.LayoutParams) view.getLayoutParams()).gravity = i;
        LinearLayout linearLayout = this.containerView;
        if (this.auxiliaryViewPosition != AuxiliaryViewPosition.INLINE) {
            i2 = 1;
        }
        linearLayout.setOrientation(i2);
        if (this.auxiliaryViewPosition == AuxiliaryViewPosition.TOP || (this.auxiliaryViewPosition == AuxiliaryViewPosition.INLINE && this.horizontalAlignment == HorizontalAlignment.RIGHT)) {
            this.containerView.removeView(this.likeButton);
            this.containerView.addView(this.likeButton);
        } else {
            this.containerView.removeView(view);
            this.containerView.addView(view);
        }
        int i3 = AnonymousClass2.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()];
        if (i3 == 1) {
            int i4 = this.edgePadding;
            view.setPadding(i4, i4, i4, this.internalPadding);
        } else if (i3 == 2) {
            int i5 = this.edgePadding;
            view.setPadding(i5, this.internalPadding, i5, i5);
        } else if (i3 == 3) {
            if (this.horizontalAlignment == HorizontalAlignment.RIGHT) {
                int i6 = this.edgePadding;
                view.setPadding(i6, i6, this.internalPadding, i6);
                return;
            }
            int i7 = this.internalPadding;
            int i8 = this.edgePadding;
            view.setPadding(i7, i8, i8, i8);
        }
    }

    /* renamed from: com.facebook.share.widget.LikeView$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition = new int[AuxiliaryViewPosition.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[AuxiliaryViewPosition.TOP.ordinal()] = 1;
            $SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[AuxiliaryViewPosition.BOTTOM.ordinal()] = 2;
            try {
                $SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[AuxiliaryViewPosition.INLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void updateBoxCountCaretPosition() {
        LikeBoxCountView.LikeBoxCountViewCaretPosition likeBoxCountViewCaretPosition;
        LikeBoxCountView likeBoxCountView2;
        int i = AnonymousClass2.$SwitchMap$com$facebook$share$widget$LikeView$AuxiliaryViewPosition[this.auxiliaryViewPosition.ordinal()];
        if (i == 1) {
            likeBoxCountView2 = this.likeBoxCountView;
            likeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.BOTTOM;
        } else if (i == 2) {
            likeBoxCountView2 = this.likeBoxCountView;
            likeBoxCountViewCaretPosition = LikeBoxCountView.LikeBoxCountViewCaretPosition.TOP;
        } else if (i == 3) {
            likeBoxCountView2 = this.likeBoxCountView;
            likeBoxCountViewCaretPosition = this.horizontalAlignment == HorizontalAlignment.RIGHT ? LikeBoxCountView.LikeBoxCountViewCaretPosition.RIGHT : LikeBoxCountView.LikeBoxCountViewCaretPosition.LEFT;
        } else {
            return;
        }
        likeBoxCountView2.setCaretPosition(likeBoxCountViewCaretPosition);
    }

    class LikeControllerBroadcastReceiver extends BroadcastReceiver {
        private LikeControllerBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Bundle extras = intent.getExtras();
            boolean z = true;
            if (extras != null) {
                String string = extras.getString(LikeActionController.ACTION_OBJECT_ID_KEY);
                if (!Utility.isNullOrEmpty(string) && !Utility.areObjectsEqual(LikeView.this.objectId, string)) {
                    z = false;
                }
            }
            if (z) {
                if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_UPDATED.equals(action)) {
                    LikeView.this.updateLikeStateAndLayout();
                } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR.equals(action)) {
                    if (LikeView.this.onErrorListener != null) {
                        LikeView.this.onErrorListener.onError(NativeProtocol.getExceptionFromErrorData(extras));
                    }
                } else if (LikeActionController.ACTION_LIKE_ACTION_CONTROLLER_DID_RESET.equals(action)) {
                    LikeView likeView = LikeView.this;
                    likeView.setObjectIdAndTypeForced(likeView.objectId, LikeView.this.objectType);
                    LikeView.this.updateLikeStateAndLayout();
                }
            }
        }
    }

    class LikeActionControllerCreationCallback implements LikeActionController.CreationCallback {
        private boolean isCancelled;

        private LikeActionControllerCreationCallback() {
        }

        public void cancel() {
            this.isCancelled = true;
        }

        public void onComplete(LikeActionController likeActionController, FacebookException facebookException) {
            if (!this.isCancelled) {
                if (likeActionController != null) {
                    if (!likeActionController.shouldEnableView()) {
                        facebookException = new FacebookException("Cannot use LikeView. The device may not be supported.");
                    }
                    LikeView.this.associateWithLikeActionController(likeActionController);
                    LikeView.this.updateLikeStateAndLayout();
                }
                if (!(facebookException == null || LikeView.this.onErrorListener == null)) {
                    LikeView.this.onErrorListener.onError(facebookException);
                }
                LikeView.this.creationCallback = null;
            }
        }
    }
}
