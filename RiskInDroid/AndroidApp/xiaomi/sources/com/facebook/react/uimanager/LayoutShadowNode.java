package com.facebook.react.uimanager;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.annotations.ReactPropGroup;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaDisplay;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaOverflow;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaUnit;
import com.facebook.yoga.YogaWrap;

public class LayoutShadowNode extends ReactShadowNodeImpl {
    boolean mCollapsable;
    private final MutableYogaValue mTempYogaValue = new MutableYogaValue((AnonymousClass1) null);

    static class MutableYogaValue {
        YogaUnit unit;
        float value;

        /* synthetic */ MutableYogaValue(AnonymousClass1 r1) {
            this();
        }

        private MutableYogaValue() {
        }

        private MutableYogaValue(MutableYogaValue mutableYogaValue) {
            this.value = mutableYogaValue.value;
            this.unit = mutableYogaValue.unit;
        }

        /* access modifiers changed from: package-private */
        public void setFromDynamic(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.unit = YogaUnit.UNDEFINED;
                this.value = Float.NaN;
            } else if (dynamic.getType() == ReadableType.String) {
                String asString = dynamic.asString();
                if (asString.equals("auto")) {
                    this.unit = YogaUnit.AUTO;
                    this.value = Float.NaN;
                } else if (asString.endsWith("%")) {
                    this.unit = YogaUnit.PERCENT;
                    this.value = Float.parseFloat(asString.substring(0, asString.length() - 1));
                } else {
                    throw new IllegalArgumentException("Unknown value: ".concat(String.valueOf(asString)));
                }
            } else {
                this.unit = YogaUnit.POINT;
                this.value = PixelUtil.toPixelFromDIP(dynamic.asDouble());
            }
        }
    }

    @ReactProp(name = "width")
    public void setWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleWidth(this.mTempYogaValue.value);
            } else if (i == 3) {
                setStyleWidthAuto();
            } else if (i == 4) {
                setStyleWidthPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    /* renamed from: com.facebook.react.uimanager.LayoutShadowNode$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$yoga$YogaUnit = new int[YogaUnit.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.POINT.ordinal()] = 1;
            $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.UNDEFINED.ordinal()] = 2;
            $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.AUTO.ordinal()] = 3;
            try {
                $SwitchMap$com$facebook$yoga$YogaUnit[YogaUnit.PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @ReactProp(name = "minWidth")
    public void setMinWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleMinWidth(this.mTempYogaValue.value);
            } else if (i == 4) {
                setStyleMinWidthPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "collapsable")
    public void setCollapsable(boolean z) {
        this.mCollapsable = z;
    }

    @ReactProp(name = "maxWidth")
    public void setMaxWidth(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleMaxWidth(this.mTempYogaValue.value);
            } else if (i == 4) {
                setStyleMaxWidthPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "height")
    public void setHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleHeight(this.mTempYogaValue.value);
            } else if (i == 3) {
                setStyleHeightAuto();
            } else if (i == 4) {
                setStyleHeightPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "minHeight")
    public void setMinHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleMinHeight(this.mTempYogaValue.value);
            } else if (i == 4) {
                setStyleMinHeightPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(name = "maxHeight")
    public void setMaxHeight(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setStyleMaxHeight(this.mTempYogaValue.value);
            } else if (i == 4) {
                setStyleMaxHeightPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flex")
    public void setFlex(float f) {
        if (!isVirtual()) {
            super.setFlex(f);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexGrow")
    public void setFlexGrow(float f) {
        if (!isVirtual()) {
            super.setFlexGrow(f);
        }
    }

    @ReactProp(defaultFloat = 0.0f, name = "flexShrink")
    public void setFlexShrink(float f) {
        if (!isVirtual()) {
            super.setFlexShrink(f);
        }
    }

    @ReactProp(name = "flexBasis")
    public void setFlexBasis(Dynamic dynamic) {
        if (!isVirtual()) {
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i == 1 || i == 2) {
                setFlexBasis(this.mTempYogaValue.value);
            } else if (i == 3) {
                setFlexBasisAuto();
            } else if (i == 4) {
                setFlexBasisPercent(this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactProp(defaultFloat = Float.NaN, name = "aspectRatio")
    public void setAspectRatio(float f) {
        setStyleAspectRatio(f);
    }

    @ReactProp(name = "flexDirection")
    public void setFlexDirection(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setFlexDirection(YogaFlexDirection.COLUMN);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1448970769:
                    if (str.equals("row-reverse")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1354837162:
                    if (str.equals("column")) {
                        c = 0;
                        break;
                    }
                    break;
                case 113114:
                    if (str.equals("row")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1272730475:
                    if (str.equals("column-reverse")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                setFlexDirection(YogaFlexDirection.COLUMN);
            } else if (c == 1) {
                setFlexDirection(YogaFlexDirection.COLUMN_REVERSE);
            } else if (c == 2) {
                setFlexDirection(YogaFlexDirection.ROW);
            } else if (c == 3) {
                setFlexDirection(YogaFlexDirection.ROW_REVERSE);
            } else {
                throw new JSApplicationIllegalArgumentException("invalid value for flexDirection: ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactProp(name = "flexWrap")
    public void setFlexWrap(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setFlexWrap(YogaWrap.NO_WRAP);
                return;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1039592053) {
                if (hashCode != -749527969) {
                    if (hashCode == 3657802 && str.equals("wrap")) {
                        c = 1;
                    }
                } else if (str.equals("wrap-reverse")) {
                    c = 2;
                }
            } else if (str.equals("nowrap")) {
                c = 0;
            }
            if (c == 0) {
                setFlexWrap(YogaWrap.NO_WRAP);
            } else if (c == 1) {
                setFlexWrap(YogaWrap.WRAP);
            } else if (c == 2) {
                setFlexWrap(YogaWrap.WRAP_REVERSE);
            } else {
                throw new JSApplicationIllegalArgumentException("invalid value for flexWrap: ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactProp(name = "alignSelf")
    public void setAlignSelf(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignSelf(YogaAlign.AUTO);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setAlignSelf(YogaAlign.AUTO);
                    return;
                case 1:
                    setAlignSelf(YogaAlign.FLEX_START);
                    return;
                case 2:
                    setAlignSelf(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignSelf(YogaAlign.FLEX_END);
                    return;
                case 4:
                    setAlignSelf(YogaAlign.STRETCH);
                    return;
                case 5:
                    setAlignSelf(YogaAlign.BASELINE);
                    return;
                case 6:
                    setAlignSelf(YogaAlign.SPACE_BETWEEN);
                    return;
                case 7:
                    setAlignSelf(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for alignSelf: ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactProp(name = "alignItems")
    public void setAlignItems(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignItems(YogaAlign.STRETCH);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setAlignItems(YogaAlign.AUTO);
                    return;
                case 1:
                    setAlignItems(YogaAlign.FLEX_START);
                    return;
                case 2:
                    setAlignItems(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignItems(YogaAlign.FLEX_END);
                    return;
                case 4:
                    setAlignItems(YogaAlign.STRETCH);
                    return;
                case 5:
                    setAlignItems(YogaAlign.BASELINE);
                    return;
                case 6:
                    setAlignItems(YogaAlign.SPACE_BETWEEN);
                    return;
                case 7:
                    setAlignItems(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for alignItems: ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactProp(name = "alignContent")
    public void setAlignContent(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setAlignContent(YogaAlign.FLEX_START);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1881872635:
                    if (str.equals("stretch")) {
                        c = 4;
                        break;
                    }
                    break;
                case -1720785339:
                    if (str.equals("baseline")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1364013995:
                    if (str.equals("center")) {
                        c = 2;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3005871:
                    if (str.equals("auto")) {
                        c = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 7;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    setAlignContent(YogaAlign.AUTO);
                    return;
                case 1:
                    setAlignContent(YogaAlign.FLEX_START);
                    return;
                case 2:
                    setAlignContent(YogaAlign.CENTER);
                    return;
                case 3:
                    setAlignContent(YogaAlign.FLEX_END);
                    return;
                case 4:
                    setAlignContent(YogaAlign.STRETCH);
                    return;
                case 5:
                    setAlignContent(YogaAlign.BASELINE);
                    return;
                case 6:
                    setAlignContent(YogaAlign.SPACE_BETWEEN);
                    return;
                case 7:
                    setAlignContent(YogaAlign.SPACE_AROUND);
                    return;
                default:
                    throw new JSApplicationIllegalArgumentException("invalid value for alignContent: ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactProp(name = "justifyContent")
    public void setJustifyContent(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setJustifyContent(YogaJustify.FLEX_START);
                return;
            }
            char c = 65535;
            switch (str.hashCode()) {
                case -1364013995:
                    if (str.equals("center")) {
                        c = 1;
                        break;
                    }
                    break;
                case -46581362:
                    if (str.equals("flex-start")) {
                        c = 0;
                        break;
                    }
                    break;
                case 441309761:
                    if (str.equals("space-between")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1742952711:
                    if (str.equals("flex-end")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1937124468:
                    if (str.equals("space-around")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2055030478:
                    if (str.equals("space-evenly")) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                setJustifyContent(YogaJustify.FLEX_START);
            } else if (c == 1) {
                setJustifyContent(YogaJustify.CENTER);
            } else if (c == 2) {
                setJustifyContent(YogaJustify.FLEX_END);
            } else if (c == 3) {
                setJustifyContent(YogaJustify.SPACE_BETWEEN);
            } else if (c == 4) {
                setJustifyContent(YogaJustify.SPACE_AROUND);
            } else if (c == 5) {
                setJustifyContent(YogaJustify.SPACE_EVENLY);
            } else {
                throw new JSApplicationIllegalArgumentException("invalid value for justifyContent: ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactProp(name = "overflow")
    public void setOverflow(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setOverflow(YogaOverflow.VISIBLE);
                return;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1217487446) {
                if (hashCode != -907680051) {
                    if (hashCode == 466743410 && str.equals("visible")) {
                        c = 0;
                    }
                } else if (str.equals("scroll")) {
                    c = 2;
                }
            } else if (str.equals("hidden")) {
                c = 1;
            }
            if (c == 0) {
                setOverflow(YogaOverflow.VISIBLE);
            } else if (c == 1) {
                setOverflow(YogaOverflow.HIDDEN);
            } else if (c == 2) {
                setOverflow(YogaOverflow.SCROLL);
            } else {
                throw new JSApplicationIllegalArgumentException("invalid value for overflow: ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactProp(name = "display")
    public void setDisplay(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setDisplay(YogaDisplay.FLEX);
                return;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 3145721) {
                if (hashCode == 3387192 && str.equals("none")) {
                    c = 1;
                }
            } else if (str.equals("flex")) {
                c = 0;
            }
            if (c == 0) {
                setDisplay(YogaDisplay.FLEX);
            } else if (c == 1) {
                setDisplay(YogaDisplay.NONE);
            } else {
                throw new JSApplicationIllegalArgumentException("invalid value for display: ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactPropGroup(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i2 == 1 || i2 == 2) {
                setMargin(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (i2 == 3) {
                setMarginAuto(maybeTransformLeftRightToStartEnd);
            } else if (i2 == 4) {
                setMarginPercent(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactPropGroup(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(ViewProps.PADDING_MARGIN_SPACING_TYPES[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i2 == 1 || i2 == 2) {
                setPadding(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (i2 == 4) {
                setPaddingPercent(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    @ReactPropGroup(defaultFloat = Float.NaN, names = {"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
    public void setBorderWidths(int i, float f) {
        if (!isVirtual()) {
            setBorder(maybeTransformLeftRightToStartEnd(ViewProps.BORDER_SPACING_TYPES[i]), PixelUtil.toPixelFromDIP(f));
        }
    }

    @ReactPropGroup(names = {"start", "end", "left", "right", "top", "bottom"})
    public void setPositionValues(int i, Dynamic dynamic) {
        if (!isVirtual()) {
            int maybeTransformLeftRightToStartEnd = maybeTransformLeftRightToStartEnd(new int[]{4, 5, 0, 2, 1, 3}[i]);
            this.mTempYogaValue.setFromDynamic(dynamic);
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$yoga$YogaUnit[this.mTempYogaValue.unit.ordinal()];
            if (i2 == 1 || i2 == 2) {
                setPosition(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            } else if (i2 == 4) {
                setPositionPercent(maybeTransformLeftRightToStartEnd, this.mTempYogaValue.value);
            }
            dynamic.recycle();
        }
    }

    private int maybeTransformLeftRightToStartEnd(int i) {
        if (!I18nUtil.getInstance().doLeftAndRightSwapInRTL(getThemedContext())) {
            return i;
        }
        if (i == 0) {
            return 4;
        }
        if (i != 2) {
            return i;
        }
        return 5;
    }

    @ReactProp(name = "position")
    public void setPosition(String str) {
        if (!isVirtual()) {
            if (str == null) {
                setPositionType(YogaPositionType.RELATIVE);
                return;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -554435892) {
                if (hashCode == 1728122231 && str.equals("absolute")) {
                    c = 1;
                }
            } else if (str.equals("relative")) {
                c = 0;
            }
            if (c == 0) {
                setPositionType(YogaPositionType.RELATIVE);
            } else if (c == 1) {
                setPositionType(YogaPositionType.ABSOLUTE);
            } else {
                throw new JSApplicationIllegalArgumentException("invalid value for position: ".concat(String.valueOf(str)));
            }
        }
    }

    @ReactProp(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z) {
        super.setShouldNotifyOnLayout(z);
    }
}
