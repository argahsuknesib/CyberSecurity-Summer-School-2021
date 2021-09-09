package com.facebook.react.views.textinput;

import _m_j.cb;
import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.EditText;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.util.padcompat.PadCompatUtil;
import com.facebook.react.views.text.ReactBaseTextShadowNode;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.view.MeasureUtil;
import com.facebook.yoga.YogaMeasureFunction;
import com.facebook.yoga.YogaMeasureMode;
import com.facebook.yoga.YogaMeasureOutput;
import com.facebook.yoga.YogaNode;

@VisibleForTesting
@TargetApi(23)
public class ReactTextInputShadowNode extends ReactBaseTextShadowNode implements YogaMeasureFunction {
    private EditText mDummyEditText;
    private ReactTextInputLocalData mLocalData;
    private int mMostRecentEventCount = -1;
    private String mPlaceholder = null;
    private int mSelectionEnd = -1;
    private int mSelectionStart = -1;
    private String mText = null;

    public boolean isVirtualAnchor() {
        return true;
    }

    public boolean isYogaLeafNode() {
        return true;
    }

    public ReactTextInputShadowNode() {
        this.mTextBreakStrategy = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        initMeasureFunction();
    }

    private void initMeasureFunction() {
        setMeasureFunction(this);
    }

    public void setThemedContext(ThemedReactContext themedReactContext) {
        super.setThemedContext(themedReactContext);
        boolean isDialogThemePlugin = PadCompatUtil.getInstance().isDialogThemePlugin();
        float scaleFactor = PadCompatUtil.getInstance().getScaleFactor();
        EditText editText = new EditText(getThemedContext());
        setDefaultPadding(4, isDialogThemePlugin ? ((float) cb.O0000OoO(editText)) * scaleFactor : (float) cb.O0000OoO(editText));
        setDefaultPadding(1, isDialogThemePlugin ? ((float) editText.getPaddingTop()) * scaleFactor : (float) editText.getPaddingTop());
        setDefaultPadding(5, isDialogThemePlugin ? ((float) cb.O0000Ooo(editText)) * scaleFactor : (float) cb.O0000Ooo(editText));
        setDefaultPadding(3, isDialogThemePlugin ? ((float) editText.getPaddingBottom()) * scaleFactor : (float) editText.getPaddingBottom());
        this.mDummyEditText = editText;
        this.mDummyEditText.setPadding(0, 0, 0, 0);
        this.mDummyEditText.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    }

    public long measure(YogaNode yogaNode, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
        EditText editText = (EditText) Assertions.assertNotNull(this.mDummyEditText);
        ReactTextInputLocalData reactTextInputLocalData = this.mLocalData;
        if (reactTextInputLocalData != null) {
            reactTextInputLocalData.apply(editText);
        } else {
            editText.setTextSize(0, (float) this.mTextAttributes.getEffectiveFontSize());
            if (this.mNumberOfLines != -1) {
                editText.setLines(this.mNumberOfLines);
            }
            if (Build.VERSION.SDK_INT >= 23 && editText.getBreakStrategy() != this.mTextBreakStrategy) {
                editText.setBreakStrategy(this.mTextBreakStrategy);
            }
        }
        editText.setHint(getPlaceholder());
        editText.measure(MeasureUtil.getMeasureSpec(f, yogaMeasureMode), MeasureUtil.getMeasureSpec(f2, yogaMeasureMode2));
        return YogaMeasureOutput.make(editText.getMeasuredWidth(), editText.getMeasuredHeight());
    }

    public void setLocalData(Object obj) {
        Assertions.assertCondition(obj instanceof ReactTextInputLocalData);
        this.mLocalData = (ReactTextInputLocalData) obj;
        dirty();
    }

    @ReactProp(name = "mostRecentEventCount")
    public void setMostRecentEventCount(int i) {
        this.mMostRecentEventCount = i;
    }

    @ReactProp(name = "text")
    public void setText(String str) {
        this.mText = str;
        markUpdated();
    }

    public String getText() {
        return this.mText;
    }

    @ReactProp(name = "placeholder")
    public void setPlaceholder(String str) {
        this.mPlaceholder = str;
        markUpdated();
    }

    public String getPlaceholder() {
        return this.mPlaceholder;
    }

    @ReactProp(name = "selection")
    public void setSelection(ReadableMap readableMap) {
        this.mSelectionEnd = -1;
        this.mSelectionStart = -1;
        if (readableMap != null && readableMap.hasKey("start") && readableMap.hasKey("end")) {
            this.mSelectionStart = readableMap.getInt("start");
            this.mSelectionEnd = readableMap.getInt("end");
            markUpdated();
        }
    }

    public void setTextBreakStrategy(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (str == null || "simple".equals(str)) {
                this.mTextBreakStrategy = 0;
            } else if ("highQuality".equals(str)) {
                this.mTextBreakStrategy = 1;
            } else if ("balanced".equals(str)) {
                this.mTextBreakStrategy = 2;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textBreakStrategy: ".concat(String.valueOf(str)));
            }
        }
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        if (this.mMostRecentEventCount != -1) {
            UIViewOperationQueue uIViewOperationQueue2 = uIViewOperationQueue;
            uIViewOperationQueue2.enqueueUpdateExtraData(getReactTag(), new ReactTextUpdate(spannedFromShadowNode(this, getText(), false, null), this.mMostRecentEventCount, this.mContainsImages, getPadding(0), getPadding(1), getPadding(2), getPadding(3), this.mTextAlign, this.mTextBreakStrategy, this.mJustificationMode, this.mSelectionStart, this.mSelectionEnd));
        }
    }

    public void setPadding(int i, float f) {
        super.setPadding(i, f);
        markUpdated();
    }
}
