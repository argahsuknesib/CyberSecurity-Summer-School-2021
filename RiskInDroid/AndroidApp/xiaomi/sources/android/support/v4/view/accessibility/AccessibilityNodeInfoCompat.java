package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatApi21;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompatKitKat;
import android.view.View;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccessibilityNodeInfoCompat {
    static final AccessibilityNodeInfoImpl IMPL;
    private final Object mInfo;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int mParentVirtualDescendantId = -1;

    interface AccessibilityNodeInfoImpl {
        void addAction(Object obj, int i);

        void addAction(Object obj, Object obj2);

        void addChild(Object obj, View view);

        void addChild(Object obj, View view, int i);

        boolean canOpenPopup(Object obj);

        List<Object> findAccessibilityNodeInfosByText(Object obj, String str);

        List<Object> findAccessibilityNodeInfosByViewId(Object obj, String str);

        Object findFocus(Object obj, int i);

        Object focusSearch(Object obj, int i);

        int getAccessibilityActionId(Object obj);

        CharSequence getAccessibilityActionLabel(Object obj);

        Object getActionContextClick();

        List<Object> getActionList(Object obj);

        Object getActionScrollDown();

        Object getActionScrollLeft();

        Object getActionScrollRight();

        Object getActionScrollToPosition();

        Object getActionScrollUp();

        Object getActionSetProgress();

        Object getActionShowOnScreen();

        int getActions(Object obj);

        void getBoundsInParent(Object obj, Rect rect);

        void getBoundsInScreen(Object obj, Rect rect);

        Object getChild(Object obj, int i);

        int getChildCount(Object obj);

        CharSequence getClassName(Object obj);

        Object getCollectionInfo(Object obj);

        int getCollectionInfoColumnCount(Object obj);

        int getCollectionInfoRowCount(Object obj);

        int getCollectionInfoSelectionMode(Object obj);

        int getCollectionItemColumnIndex(Object obj);

        int getCollectionItemColumnSpan(Object obj);

        Object getCollectionItemInfo(Object obj);

        int getCollectionItemRowIndex(Object obj);

        int getCollectionItemRowSpan(Object obj);

        CharSequence getContentDescription(Object obj);

        int getDrawingOrder(Object obj);

        CharSequence getError(Object obj);

        Bundle getExtras(Object obj);

        int getInputType(Object obj);

        Object getLabelFor(Object obj);

        Object getLabeledBy(Object obj);

        int getLiveRegion(Object obj);

        int getMaxTextLength(Object obj);

        int getMovementGranularities(Object obj);

        CharSequence getPackageName(Object obj);

        Object getParent(Object obj);

        Object getRangeInfo(Object obj);

        CharSequence getRoleDescription(Object obj);

        CharSequence getText(Object obj);

        int getTextSelectionEnd(Object obj);

        int getTextSelectionStart(Object obj);

        Object getTraversalAfter(Object obj);

        Object getTraversalBefore(Object obj);

        String getViewIdResourceName(Object obj);

        Object getWindow(Object obj);

        int getWindowId(Object obj);

        boolean isAccessibilityFocused(Object obj);

        boolean isCheckable(Object obj);

        boolean isChecked(Object obj);

        boolean isClickable(Object obj);

        boolean isCollectionInfoHierarchical(Object obj);

        boolean isCollectionItemHeading(Object obj);

        boolean isCollectionItemSelected(Object obj);

        boolean isContentInvalid(Object obj);

        boolean isContextClickable(Object obj);

        boolean isDismissable(Object obj);

        boolean isEditable(Object obj);

        boolean isEnabled(Object obj);

        boolean isFocusable(Object obj);

        boolean isFocused(Object obj);

        boolean isImportantForAccessibility(Object obj);

        boolean isLongClickable(Object obj);

        boolean isMultiLine(Object obj);

        boolean isPassword(Object obj);

        boolean isScrollable(Object obj);

        boolean isSelected(Object obj);

        boolean isVisibleToUser(Object obj);

        Object newAccessibilityAction(int i, CharSequence charSequence);

        Object obtain();

        Object obtain(View view);

        Object obtain(View view, int i);

        Object obtain(Object obj);

        Object obtainCollectionInfo(int i, int i2, boolean z);

        Object obtainCollectionInfo(int i, int i2, boolean z, int i3);

        Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z);

        Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2);

        Object obtainRangeInfo(int i, float f, float f2, float f3);

        boolean performAction(Object obj, int i);

        boolean performAction(Object obj, int i, Bundle bundle);

        void recycle(Object obj);

        boolean refresh(Object obj);

        boolean removeAction(Object obj, Object obj2);

        boolean removeChild(Object obj, View view);

        boolean removeChild(Object obj, View view, int i);

        void setAccessibilityFocused(Object obj, boolean z);

        void setBoundsInParent(Object obj, Rect rect);

        void setBoundsInScreen(Object obj, Rect rect);

        void setCanOpenPopup(Object obj, boolean z);

        void setCheckable(Object obj, boolean z);

        void setChecked(Object obj, boolean z);

        void setClassName(Object obj, CharSequence charSequence);

        void setClickable(Object obj, boolean z);

        void setCollectionInfo(Object obj, Object obj2);

        void setCollectionItemInfo(Object obj, Object obj2);

        void setContentDescription(Object obj, CharSequence charSequence);

        void setContentInvalid(Object obj, boolean z);

        void setContextClickable(Object obj, boolean z);

        void setDismissable(Object obj, boolean z);

        void setDrawingOrder(Object obj, int i);

        void setEditable(Object obj, boolean z);

        void setEnabled(Object obj, boolean z);

        void setError(Object obj, CharSequence charSequence);

        void setFocusable(Object obj, boolean z);

        void setFocused(Object obj, boolean z);

        void setImportantForAccessibility(Object obj, boolean z);

        void setInputType(Object obj, int i);

        void setLabelFor(Object obj, View view);

        void setLabelFor(Object obj, View view, int i);

        void setLabeledBy(Object obj, View view);

        void setLabeledBy(Object obj, View view, int i);

        void setLiveRegion(Object obj, int i);

        void setLongClickable(Object obj, boolean z);

        void setMaxTextLength(Object obj, int i);

        void setMovementGranularities(Object obj, int i);

        void setMultiLine(Object obj, boolean z);

        void setPackageName(Object obj, CharSequence charSequence);

        void setParent(Object obj, View view);

        void setParent(Object obj, View view, int i);

        void setPassword(Object obj, boolean z);

        void setRangeInfo(Object obj, Object obj2);

        void setRoleDescription(Object obj, CharSequence charSequence);

        void setScrollable(Object obj, boolean z);

        void setSelected(Object obj, boolean z);

        void setSource(Object obj, View view);

        void setSource(Object obj, View view, int i);

        void setText(Object obj, CharSequence charSequence);

        void setTextSelection(Object obj, int i, int i2);

        void setTraversalAfter(Object obj, View view);

        void setTraversalAfter(Object obj, View view, int i);

        void setTraversalBefore(Object obj, View view);

        void setTraversalBefore(Object obj, View view, int i);

        void setViewIdResourceName(Object obj, String str);

        void setVisibleToUser(Object obj, boolean z);
    }

    private static String getActionSymbolicName(int i) {
        if (i == 1) {
            return "ACTION_FOCUS";
        }
        if (i == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i) {
            case 4:
                return "ACTION_SELECT";
            case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case NotificationCompat.FLAG_HIGH_PRIORITY:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(NotificationCompat.FLAG_HIGH_PRIORITY, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
        public static final AccessibilityActionCompat ACTION_CLICK = new AccessibilityActionCompat(16, null);
        public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionContextClick());
        public static final AccessibilityActionCompat ACTION_COPY = new AccessibilityActionCompat(16384, null);
        public static final AccessibilityActionCompat ACTION_CUT = new AccessibilityActionCompat(65536, null);
        public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(ExtractorMediaSource.DEFAULT_LOADING_CHECK_INTERVAL_BYTES, null);
        public static final AccessibilityActionCompat ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
        public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, null);
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null);
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null);
        public static final AccessibilityActionCompat ACTION_PASTE = new AccessibilityActionCompat(32768, null);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null);
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollDown());
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollLeft());
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollRight());
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollToPosition());
        public static final AccessibilityActionCompat ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionScrollUp());
        public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, null);
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionSetProgress());
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null);
        public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null);
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfoCompat.IMPL.getActionShowOnScreen());
        final Object mAction;

        public AccessibilityActionCompat(int i, CharSequence charSequence) {
            this(AccessibilityNodeInfoCompat.IMPL.newAccessibilityAction(i, charSequence));
        }

        AccessibilityActionCompat(Object obj) {
            this.mAction = obj;
        }

        public int getId() {
            return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionId(this.mAction);
        }

        public CharSequence getLabel() {
            return AccessibilityNodeInfoCompat.IMPL.getAccessibilityActionLabel(this.mAction);
        }
    }

    public static class CollectionInfoCompat {
        final Object mInfo;

        public static CollectionInfoCompat obtain(int i, int i2, boolean z, int i3) {
            return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(i, i2, z, i3));
        }

        public static CollectionInfoCompat obtain(int i, int i2, boolean z) {
            return new CollectionInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionInfo(i, i2, z));
        }

        CollectionInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        public int getColumnCount() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoColumnCount(this.mInfo);
        }

        public int getRowCount() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoRowCount(this.mInfo);
        }

        public boolean isHierarchical() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionInfoHierarchical(this.mInfo);
        }

        public int getSelectionMode() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionInfoSelectionMode(this.mInfo);
        }
    }

    public static class CollectionItemInfoCompat {
        final Object mInfo;

        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(i, i2, i3, i4, z, z2));
        }

        public static CollectionItemInfoCompat obtain(int i, int i2, int i3, int i4, boolean z) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainCollectionItemInfo(i, i2, i3, i4, z));
        }

        CollectionItemInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        public int getColumnIndex() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnIndex(this.mInfo);
        }

        public int getColumnSpan() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemColumnSpan(this.mInfo);
        }

        public int getRowIndex() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowIndex(this.mInfo);
        }

        public int getRowSpan() {
            return AccessibilityNodeInfoCompat.IMPL.getCollectionItemRowSpan(this.mInfo);
        }

        public boolean isHeading() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionItemHeading(this.mInfo);
        }

        public boolean isSelected() {
            return AccessibilityNodeInfoCompat.IMPL.isCollectionItemSelected(this.mInfo);
        }
    }

    public static class RangeInfoCompat {
        final Object mInfo;

        public static RangeInfoCompat obtain(int i, float f, float f2, float f3) {
            return new RangeInfoCompat(AccessibilityNodeInfoCompat.IMPL.obtainRangeInfo(i, f, f2, f3));
        }

        RangeInfoCompat(Object obj) {
            this.mInfo = obj;
        }

        public float getCurrent() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.getCurrent(this.mInfo);
        }

        public float getMax() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMax(this.mInfo);
        }

        public float getMin() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.getMin(this.mInfo);
        }

        public int getType() {
            return AccessibilityNodeInfoCompatKitKat.RangeInfo.getType(this.mInfo);
        }
    }

    static class AccessibilityNodeInfoStubImpl implements AccessibilityNodeInfoImpl {
        public void addAction(Object obj, int i) {
        }

        public void addAction(Object obj, Object obj2) {
        }

        public void addChild(Object obj, View view) {
        }

        public void addChild(Object obj, View view, int i) {
        }

        public boolean canOpenPopup(Object obj) {
            return false;
        }

        public Object findFocus(Object obj, int i) {
            return null;
        }

        public Object focusSearch(Object obj, int i) {
            return null;
        }

        public int getAccessibilityActionId(Object obj) {
            return 0;
        }

        public CharSequence getAccessibilityActionLabel(Object obj) {
            return null;
        }

        public Object getActionContextClick() {
            return null;
        }

        public List<Object> getActionList(Object obj) {
            return null;
        }

        public Object getActionScrollDown() {
            return null;
        }

        public Object getActionScrollLeft() {
            return null;
        }

        public Object getActionScrollRight() {
            return null;
        }

        public Object getActionScrollToPosition() {
            return null;
        }

        public Object getActionScrollUp() {
            return null;
        }

        public Object getActionSetProgress() {
            return null;
        }

        public Object getActionShowOnScreen() {
            return null;
        }

        public int getActions(Object obj) {
            return 0;
        }

        public void getBoundsInParent(Object obj, Rect rect) {
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
        }

        public Object getChild(Object obj, int i) {
            return null;
        }

        public int getChildCount(Object obj) {
            return 0;
        }

        public CharSequence getClassName(Object obj) {
            return null;
        }

        public Object getCollectionInfo(Object obj) {
            return null;
        }

        public int getCollectionInfoColumnCount(Object obj) {
            return 0;
        }

        public int getCollectionInfoRowCount(Object obj) {
            return 0;
        }

        public int getCollectionInfoSelectionMode(Object obj) {
            return 0;
        }

        public int getCollectionItemColumnIndex(Object obj) {
            return 0;
        }

        public int getCollectionItemColumnSpan(Object obj) {
            return 0;
        }

        public Object getCollectionItemInfo(Object obj) {
            return null;
        }

        public int getCollectionItemRowIndex(Object obj) {
            return 0;
        }

        public int getCollectionItemRowSpan(Object obj) {
            return 0;
        }

        public CharSequence getContentDescription(Object obj) {
            return null;
        }

        public int getDrawingOrder(Object obj) {
            return 0;
        }

        public CharSequence getError(Object obj) {
            return null;
        }

        public int getInputType(Object obj) {
            return 0;
        }

        public Object getLabelFor(Object obj) {
            return null;
        }

        public Object getLabeledBy(Object obj) {
            return null;
        }

        public int getLiveRegion(Object obj) {
            return 0;
        }

        public int getMaxTextLength(Object obj) {
            return -1;
        }

        public int getMovementGranularities(Object obj) {
            return 0;
        }

        public CharSequence getPackageName(Object obj) {
            return null;
        }

        public Object getParent(Object obj) {
            return null;
        }

        public Object getRangeInfo(Object obj) {
            return null;
        }

        public CharSequence getRoleDescription(Object obj) {
            return null;
        }

        public CharSequence getText(Object obj) {
            return null;
        }

        public int getTextSelectionEnd(Object obj) {
            return -1;
        }

        public int getTextSelectionStart(Object obj) {
            return -1;
        }

        public Object getTraversalAfter(Object obj) {
            return null;
        }

        public Object getTraversalBefore(Object obj) {
            return null;
        }

        public String getViewIdResourceName(Object obj) {
            return null;
        }

        public Object getWindow(Object obj) {
            return null;
        }

        public int getWindowId(Object obj) {
            return 0;
        }

        public boolean isAccessibilityFocused(Object obj) {
            return false;
        }

        public boolean isCheckable(Object obj) {
            return false;
        }

        public boolean isChecked(Object obj) {
            return false;
        }

        public boolean isClickable(Object obj) {
            return false;
        }

        public boolean isCollectionInfoHierarchical(Object obj) {
            return false;
        }

        public boolean isCollectionItemHeading(Object obj) {
            return false;
        }

        public boolean isCollectionItemSelected(Object obj) {
            return false;
        }

        public boolean isContentInvalid(Object obj) {
            return false;
        }

        public boolean isContextClickable(Object obj) {
            return false;
        }

        public boolean isDismissable(Object obj) {
            return false;
        }

        public boolean isEditable(Object obj) {
            return false;
        }

        public boolean isEnabled(Object obj) {
            return false;
        }

        public boolean isFocusable(Object obj) {
            return false;
        }

        public boolean isFocused(Object obj) {
            return false;
        }

        public boolean isImportantForAccessibility(Object obj) {
            return true;
        }

        public boolean isLongClickable(Object obj) {
            return false;
        }

        public boolean isMultiLine(Object obj) {
            return false;
        }

        public boolean isPassword(Object obj) {
            return false;
        }

        public boolean isScrollable(Object obj) {
            return false;
        }

        public boolean isSelected(Object obj) {
            return false;
        }

        public boolean isVisibleToUser(Object obj) {
            return false;
        }

        public Object newAccessibilityAction(int i, CharSequence charSequence) {
            return null;
        }

        public Object obtain() {
            return null;
        }

        public Object obtain(View view) {
            return null;
        }

        public Object obtain(View view, int i) {
            return null;
        }

        public Object obtain(Object obj) {
            return null;
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z) {
            return null;
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return null;
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z) {
            return null;
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return null;
        }

        public Object obtainRangeInfo(int i, float f, float f2, float f3) {
            return null;
        }

        public boolean performAction(Object obj, int i) {
            return false;
        }

        public boolean performAction(Object obj, int i, Bundle bundle) {
            return false;
        }

        public void recycle(Object obj) {
        }

        public boolean refresh(Object obj) {
            return false;
        }

        public boolean removeAction(Object obj, Object obj2) {
            return false;
        }

        public boolean removeChild(Object obj, View view) {
            return false;
        }

        public boolean removeChild(Object obj, View view, int i) {
            return false;
        }

        public void setAccessibilityFocused(Object obj, boolean z) {
        }

        public void setBoundsInParent(Object obj, Rect rect) {
        }

        public void setBoundsInScreen(Object obj, Rect rect) {
        }

        public void setCanOpenPopup(Object obj, boolean z) {
        }

        public void setCheckable(Object obj, boolean z) {
        }

        public void setChecked(Object obj, boolean z) {
        }

        public void setClassName(Object obj, CharSequence charSequence) {
        }

        public void setClickable(Object obj, boolean z) {
        }

        public void setCollectionInfo(Object obj, Object obj2) {
        }

        public void setCollectionItemInfo(Object obj, Object obj2) {
        }

        public void setContentDescription(Object obj, CharSequence charSequence) {
        }

        public void setContentInvalid(Object obj, boolean z) {
        }

        public void setContextClickable(Object obj, boolean z) {
        }

        public void setDismissable(Object obj, boolean z) {
        }

        public void setDrawingOrder(Object obj, int i) {
        }

        public void setEditable(Object obj, boolean z) {
        }

        public void setEnabled(Object obj, boolean z) {
        }

        public void setError(Object obj, CharSequence charSequence) {
        }

        public void setFocusable(Object obj, boolean z) {
        }

        public void setFocused(Object obj, boolean z) {
        }

        public void setImportantForAccessibility(Object obj, boolean z) {
        }

        public void setInputType(Object obj, int i) {
        }

        public void setLabelFor(Object obj, View view) {
        }

        public void setLabelFor(Object obj, View view, int i) {
        }

        public void setLabeledBy(Object obj, View view) {
        }

        public void setLabeledBy(Object obj, View view, int i) {
        }

        public void setLiveRegion(Object obj, int i) {
        }

        public void setLongClickable(Object obj, boolean z) {
        }

        public void setMaxTextLength(Object obj, int i) {
        }

        public void setMovementGranularities(Object obj, int i) {
        }

        public void setMultiLine(Object obj, boolean z) {
        }

        public void setPackageName(Object obj, CharSequence charSequence) {
        }

        public void setParent(Object obj, View view) {
        }

        public void setParent(Object obj, View view, int i) {
        }

        public void setPassword(Object obj, boolean z) {
        }

        public void setRangeInfo(Object obj, Object obj2) {
        }

        public void setRoleDescription(Object obj, CharSequence charSequence) {
        }

        public void setScrollable(Object obj, boolean z) {
        }

        public void setSelected(Object obj, boolean z) {
        }

        public void setSource(Object obj, View view) {
        }

        public void setSource(Object obj, View view, int i) {
        }

        public void setText(Object obj, CharSequence charSequence) {
        }

        public void setTextSelection(Object obj, int i, int i2) {
        }

        public void setTraversalAfter(Object obj, View view) {
        }

        public void setTraversalAfter(Object obj, View view, int i) {
        }

        public void setTraversalBefore(Object obj, View view) {
        }

        public void setTraversalBefore(Object obj, View view, int i) {
        }

        public void setViewIdResourceName(Object obj, String str) {
        }

        public void setVisibleToUser(Object obj, boolean z) {
        }

        AccessibilityNodeInfoStubImpl() {
        }

        public List<Object> findAccessibilityNodeInfosByText(Object obj, String str) {
            return Collections.emptyList();
        }

        public List<Object> findAccessibilityNodeInfosByViewId(Object obj, String str) {
            return Collections.emptyList();
        }

        public Bundle getExtras(Object obj) {
            return new Bundle();
        }
    }

    static class AccessibilityNodeInfoIcsImpl extends AccessibilityNodeInfoStubImpl {
        AccessibilityNodeInfoIcsImpl() {
        }

        public Object obtain() {
            return AccessibilityNodeInfoCompatIcs.obtain();
        }

        public Object obtain(View view) {
            return AccessibilityNodeInfoCompatIcs.obtain(view);
        }

        public Object obtain(Object obj) {
            return AccessibilityNodeInfoCompatIcs.obtain(obj);
        }

        public void addAction(Object obj, int i) {
            AccessibilityNodeInfoCompatIcs.addAction(obj, i);
        }

        public void addChild(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.addChild(obj, view);
        }

        public List<Object> findAccessibilityNodeInfosByText(Object obj, String str) {
            return AccessibilityNodeInfoCompatIcs.findAccessibilityNodeInfosByText(obj, str);
        }

        public int getActions(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getActions(obj);
        }

        public void getBoundsInParent(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.getBoundsInParent(obj, rect);
        }

        public void getBoundsInScreen(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.getBoundsInScreen(obj, rect);
        }

        public Object getChild(Object obj, int i) {
            return AccessibilityNodeInfoCompatIcs.getChild(obj, i);
        }

        public int getChildCount(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getChildCount(obj);
        }

        public CharSequence getClassName(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getClassName(obj);
        }

        public CharSequence getContentDescription(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getContentDescription(obj);
        }

        public CharSequence getPackageName(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getPackageName(obj);
        }

        public Object getParent(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getParent(obj);
        }

        public CharSequence getText(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getText(obj);
        }

        public int getWindowId(Object obj) {
            return AccessibilityNodeInfoCompatIcs.getWindowId(obj);
        }

        public boolean isCheckable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isCheckable(obj);
        }

        public boolean isChecked(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isChecked(obj);
        }

        public boolean isClickable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isClickable(obj);
        }

        public boolean isEnabled(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isEnabled(obj);
        }

        public boolean isFocusable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isFocusable(obj);
        }

        public boolean isFocused(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isFocused(obj);
        }

        public boolean isLongClickable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isLongClickable(obj);
        }

        public boolean isPassword(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isPassword(obj);
        }

        public boolean isScrollable(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isScrollable(obj);
        }

        public boolean isSelected(Object obj) {
            return AccessibilityNodeInfoCompatIcs.isSelected(obj);
        }

        public boolean performAction(Object obj, int i) {
            return AccessibilityNodeInfoCompatIcs.performAction(obj, i);
        }

        public void setBoundsInParent(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.setBoundsInParent(obj, rect);
        }

        public void setBoundsInScreen(Object obj, Rect rect) {
            AccessibilityNodeInfoCompatIcs.setBoundsInScreen(obj, rect);
        }

        public void setCheckable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setCheckable(obj, z);
        }

        public void setChecked(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setChecked(obj, z);
        }

        public void setClassName(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setClassName(obj, charSequence);
        }

        public void setClickable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setClickable(obj, z);
        }

        public void setContentDescription(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setContentDescription(obj, charSequence);
        }

        public void setEnabled(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setEnabled(obj, z);
        }

        public void setFocusable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setFocusable(obj, z);
        }

        public void setFocused(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setFocused(obj, z);
        }

        public void setLongClickable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setLongClickable(obj, z);
        }

        public void setPackageName(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setPackageName(obj, charSequence);
        }

        public void setParent(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.setParent(obj, view);
        }

        public void setPassword(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setPassword(obj, z);
        }

        public void setScrollable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setScrollable(obj, z);
        }

        public void setSelected(Object obj, boolean z) {
            AccessibilityNodeInfoCompatIcs.setSelected(obj, z);
        }

        public void setSource(Object obj, View view) {
            AccessibilityNodeInfoCompatIcs.setSource(obj, view);
        }

        public void setText(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatIcs.setText(obj, charSequence);
        }

        public void recycle(Object obj) {
            AccessibilityNodeInfoCompatIcs.recycle(obj);
        }
    }

    static class AccessibilityNodeInfoJellybeanImpl extends AccessibilityNodeInfoIcsImpl {
        AccessibilityNodeInfoJellybeanImpl() {
        }

        public Object obtain(View view, int i) {
            return AccessibilityNodeInfoCompatJellyBean.obtain(view, i);
        }

        public Object findFocus(Object obj, int i) {
            return AccessibilityNodeInfoCompatJellyBean.findFocus(obj, i);
        }

        public Object focusSearch(Object obj, int i) {
            return AccessibilityNodeInfoCompatJellyBean.focusSearch(obj, i);
        }

        public void addChild(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.addChild(obj, view, i);
        }

        public void setSource(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.setSource(obj, view, i);
        }

        public boolean isVisibleToUser(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.isVisibleToUser(obj);
        }

        public void setVisibleToUser(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.setVisibleToUser(obj, z);
        }

        public boolean isAccessibilityFocused(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.isAccessibilityFocused(obj);
        }

        public void setAccessibilityFocused(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellyBean.setAccesibilityFocused(obj, z);
        }

        public boolean performAction(Object obj, int i, Bundle bundle) {
            return AccessibilityNodeInfoCompatJellyBean.performAction(obj, i, bundle);
        }

        public void setMovementGranularities(Object obj, int i) {
            AccessibilityNodeInfoCompatJellyBean.setMovementGranularities(obj, i);
        }

        public int getMovementGranularities(Object obj) {
            return AccessibilityNodeInfoCompatJellyBean.getMovementGranularities(obj);
        }

        public void setParent(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellyBean.setParent(obj, view, i);
        }
    }

    static class AccessibilityNodeInfoJellybeanMr1Impl extends AccessibilityNodeInfoJellybeanImpl {
        AccessibilityNodeInfoJellybeanMr1Impl() {
        }

        public void setLabelFor(Object obj, View view) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(obj, view);
        }

        public void setLabelFor(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabelFor(obj, view, i);
        }

        public Object getLabelFor(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr1.getLabelFor(obj);
        }

        public void setLabeledBy(Object obj, View view) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(obj, view);
        }

        public void setLabeledBy(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatJellybeanMr1.setLabeledBy(obj, view, i);
        }

        public Object getLabeledBy(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr1.getLabeledBy(obj);
        }
    }

    static class AccessibilityNodeInfoJellybeanMr2Impl extends AccessibilityNodeInfoJellybeanMr1Impl {
        AccessibilityNodeInfoJellybeanMr2Impl() {
        }

        public String getViewIdResourceName(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getViewIdResourceName(obj);
        }

        public void setViewIdResourceName(Object obj, String str) {
            AccessibilityNodeInfoCompatJellybeanMr2.setViewIdResourceName(obj, str);
        }

        public List<Object> findAccessibilityNodeInfosByViewId(Object obj, String str) {
            return AccessibilityNodeInfoCompatJellybeanMr2.findAccessibilityNodeInfosByViewId(obj, str);
        }

        public void setTextSelection(Object obj, int i, int i2) {
            AccessibilityNodeInfoCompatJellybeanMr2.setTextSelection(obj, i, i2);
        }

        public int getTextSelectionStart(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionStart(obj);
        }

        public int getTextSelectionEnd(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.getTextSelectionEnd(obj);
        }

        public boolean isEditable(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.isEditable(obj);
        }

        public void setEditable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatJellybeanMr2.setEditable(obj, z);
        }

        public boolean refresh(Object obj) {
            return AccessibilityNodeInfoCompatJellybeanMr2.refresh(obj);
        }
    }

    static class AccessibilityNodeInfoKitKatImpl extends AccessibilityNodeInfoJellybeanMr2Impl {
        AccessibilityNodeInfoKitKatImpl() {
        }

        public int getLiveRegion(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getLiveRegion(obj);
        }

        public void setLiveRegion(Object obj, int i) {
            AccessibilityNodeInfoCompatKitKat.setLiveRegion(obj, i);
        }

        public Object getCollectionInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getCollectionInfo(obj);
        }

        public void setCollectionInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionInfo(obj, obj2);
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(i, i2, z, i3);
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionInfo(i, i2, z);
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(i, i2, i3, i4, z);
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z) {
            return AccessibilityNodeInfoCompatKitKat.obtainCollectionItemInfo(i, i2, i3, i4, z);
        }

        public int getCollectionInfoColumnCount(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getColumnCount(obj);
        }

        public int getCollectionInfoRowCount(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionInfo.getRowCount(obj);
        }

        public boolean isCollectionInfoHierarchical(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionInfo.isHierarchical(obj);
        }

        public Object getCollectionItemInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getCollectionItemInfo(obj);
        }

        public Object getRangeInfo(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getRangeInfo(obj);
        }

        public void setRangeInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setRangeInfo(obj, obj2);
        }

        public int getCollectionItemColumnIndex(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnIndex(obj);
        }

        public int getCollectionItemColumnSpan(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getColumnSpan(obj);
        }

        public int getCollectionItemRowIndex(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowIndex(obj);
        }

        public int getCollectionItemRowSpan(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.getRowSpan(obj);
        }

        public boolean isCollectionItemHeading(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.CollectionItemInfo.isHeading(obj);
        }

        public void setCollectionItemInfo(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatKitKat.setCollectionItemInfo(obj, obj2);
        }

        public Object obtainRangeInfo(int i, float f, float f2, float f3) {
            return AccessibilityNodeInfoCompatKitKat.obtainRangeInfo(i, f, f2, f3);
        }

        public void setContentInvalid(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setContentInvalid(obj, z);
        }

        public boolean isContentInvalid(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.isContentInvalid(obj);
        }

        public boolean canOpenPopup(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.canOpenPopup(obj);
        }

        public void setCanOpenPopup(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setCanOpenPopup(obj, z);
        }

        public Bundle getExtras(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getExtras(obj);
        }

        public int getInputType(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getInputType(obj);
        }

        public void setInputType(Object obj, int i) {
            AccessibilityNodeInfoCompatKitKat.setInputType(obj, i);
        }

        public boolean isDismissable(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.isDismissable(obj);
        }

        public void setDismissable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setDismissable(obj, z);
        }

        public boolean isMultiLine(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.isMultiLine(obj);
        }

        public void setMultiLine(Object obj, boolean z) {
            AccessibilityNodeInfoCompatKitKat.setMultiLine(obj, z);
        }

        public CharSequence getRoleDescription(Object obj) {
            return AccessibilityNodeInfoCompatKitKat.getRoleDescription(obj);
        }

        public void setRoleDescription(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatKitKat.setRoleDescription(obj, charSequence);
        }
    }

    static class AccessibilityNodeInfoApi21Impl extends AccessibilityNodeInfoKitKatImpl {
        AccessibilityNodeInfoApi21Impl() {
        }

        public Object newAccessibilityAction(int i, CharSequence charSequence) {
            return AccessibilityNodeInfoCompatApi21.newAccessibilityAction(i, charSequence);
        }

        public List<Object> getActionList(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getActionList(obj);
        }

        public Object obtainCollectionInfo(int i, int i2, boolean z, int i3) {
            return AccessibilityNodeInfoCompatApi21.obtainCollectionInfo(i, i2, z, i3);
        }

        public void addAction(Object obj, Object obj2) {
            AccessibilityNodeInfoCompatApi21.addAction(obj, obj2);
        }

        public boolean removeAction(Object obj, Object obj2) {
            return AccessibilityNodeInfoCompatApi21.removeAction(obj, obj2);
        }

        public int getAccessibilityActionId(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getAccessibilityActionId(obj);
        }

        public CharSequence getAccessibilityActionLabel(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getAccessibilityActionLabel(obj);
        }

        public Object obtainCollectionItemInfo(int i, int i2, int i3, int i4, boolean z, boolean z2) {
            return AccessibilityNodeInfoCompatApi21.obtainCollectionItemInfo(i, i2, i3, i4, z, z2);
        }

        public boolean isCollectionItemSelected(Object obj) {
            return AccessibilityNodeInfoCompatApi21.CollectionItemInfo.isSelected(obj);
        }

        public CharSequence getError(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getError(obj);
        }

        public void setError(Object obj, CharSequence charSequence) {
            AccessibilityNodeInfoCompatApi21.setError(obj, charSequence);
        }

        public void setMaxTextLength(Object obj, int i) {
            AccessibilityNodeInfoCompatApi21.setMaxTextLength(obj, i);
        }

        public int getMaxTextLength(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getMaxTextLength(obj);
        }

        public Object getWindow(Object obj) {
            return AccessibilityNodeInfoCompatApi21.getWindow(obj);
        }

        public boolean removeChild(Object obj, View view) {
            return AccessibilityNodeInfoCompatApi21.removeChild(obj, view);
        }

        public boolean removeChild(Object obj, View view, int i) {
            return AccessibilityNodeInfoCompatApi21.removeChild(obj, view, i);
        }

        public int getCollectionInfoSelectionMode(Object obj) {
            return AccessibilityNodeInfoCompatApi21.CollectionInfo.getSelectionMode(obj);
        }
    }

    static class AccessibilityNodeInfoApi22Impl extends AccessibilityNodeInfoApi21Impl {
        AccessibilityNodeInfoApi22Impl() {
        }

        public Object getTraversalBefore(Object obj) {
            return AccessibilityNodeInfoCompatApi22.getTraversalBefore(obj);
        }

        public void setTraversalBefore(Object obj, View view) {
            AccessibilityNodeInfoCompatApi22.setTraversalBefore(obj, view);
        }

        public void setTraversalBefore(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatApi22.setTraversalBefore(obj, view, i);
        }

        public Object getTraversalAfter(Object obj) {
            return AccessibilityNodeInfoCompatApi22.getTraversalAfter(obj);
        }

        public void setTraversalAfter(Object obj, View view) {
            AccessibilityNodeInfoCompatApi22.setTraversalAfter(obj, view);
        }

        public void setTraversalAfter(Object obj, View view, int i) {
            AccessibilityNodeInfoCompatApi22.setTraversalAfter(obj, view, i);
        }
    }

    static class AccessibilityNodeInfoApi23Impl extends AccessibilityNodeInfoApi22Impl {
        AccessibilityNodeInfoApi23Impl() {
        }

        public Object getActionScrollToPosition() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollToPosition();
        }

        public Object getActionShowOnScreen() {
            return AccessibilityNodeInfoCompatApi23.getActionShowOnScreen();
        }

        public Object getActionScrollUp() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollUp();
        }

        public Object getActionScrollDown() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollDown();
        }

        public Object getActionScrollLeft() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollLeft();
        }

        public Object getActionScrollRight() {
            return AccessibilityNodeInfoCompatApi23.getActionScrollRight();
        }

        public Object getActionContextClick() {
            return AccessibilityNodeInfoCompatApi23.getActionContextClick();
        }

        public boolean isContextClickable(Object obj) {
            return AccessibilityNodeInfoCompatApi23.isContextClickable(obj);
        }

        public void setContextClickable(Object obj, boolean z) {
            AccessibilityNodeInfoCompatApi23.setContextClickable(obj, z);
        }
    }

    static class AccessibilityNodeInfoApi24Impl extends AccessibilityNodeInfoApi23Impl {
        AccessibilityNodeInfoApi24Impl() {
        }

        public Object getActionSetProgress() {
            return AccessibilityNodeInfoCompatApi24.getActionSetProgress();
        }

        public int getDrawingOrder(Object obj) {
            return AccessibilityNodeInfoCompatApi24.getDrawingOrder(obj);
        }

        public void setDrawingOrder(Object obj, int i) {
            AccessibilityNodeInfoCompatApi24.setDrawingOrder(obj, i);
        }

        public boolean isImportantForAccessibility(Object obj) {
            return AccessibilityNodeInfoCompatApi24.isImportantForAccessibility(obj);
        }

        public void setImportantForAccessibility(Object obj, boolean z) {
            AccessibilityNodeInfoCompatApi24.setImportantForAccessibility(obj, z);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 24) {
            IMPL = new AccessibilityNodeInfoApi24Impl();
        } else if (Build.VERSION.SDK_INT >= 23) {
            IMPL = new AccessibilityNodeInfoApi23Impl();
        } else if (Build.VERSION.SDK_INT >= 22) {
            IMPL = new AccessibilityNodeInfoApi22Impl();
        } else if (Build.VERSION.SDK_INT >= 21) {
            IMPL = new AccessibilityNodeInfoApi21Impl();
        } else if (Build.VERSION.SDK_INT >= 19) {
            IMPL = new AccessibilityNodeInfoKitKatImpl();
        } else if (Build.VERSION.SDK_INT >= 18) {
            IMPL = new AccessibilityNodeInfoJellybeanMr2Impl();
        } else if (Build.VERSION.SDK_INT >= 17) {
            IMPL = new AccessibilityNodeInfoJellybeanMr1Impl();
        } else if (Build.VERSION.SDK_INT >= 16) {
            IMPL = new AccessibilityNodeInfoJellybeanImpl();
        } else if (Build.VERSION.SDK_INT >= 14) {
            IMPL = new AccessibilityNodeInfoIcsImpl();
        } else {
            IMPL = new AccessibilityNodeInfoStubImpl();
        }
    }

    static AccessibilityNodeInfoCompat wrapNonNullInstance(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    public AccessibilityNodeInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    public Object getInfo() {
        return this.mInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return wrapNonNullInstance(IMPL.obtain(view));
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i) {
        return wrapNonNullInstance(IMPL.obtain(view, i));
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrapNonNullInstance(IMPL.obtain());
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrapNonNullInstance(IMPL.obtain(accessibilityNodeInfoCompat.mInfo));
    }

    public void setSource(View view) {
        IMPL.setSource(this.mInfo, view);
    }

    public void setSource(View view, int i) {
        IMPL.setSource(this.mInfo, view, i);
    }

    public AccessibilityNodeInfoCompat findFocus(int i) {
        return wrapNonNullInstance(IMPL.findFocus(this.mInfo, i));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i) {
        return wrapNonNullInstance(IMPL.focusSearch(this.mInfo, i));
    }

    public int getWindowId() {
        return IMPL.getWindowId(this.mInfo);
    }

    public int getChildCount() {
        return IMPL.getChildCount(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getChild(int i) {
        return wrapNonNullInstance(IMPL.getChild(this.mInfo, i));
    }

    public void addChild(View view) {
        IMPL.addChild(this.mInfo, view);
    }

    public void addChild(View view, int i) {
        IMPL.addChild(this.mInfo, view, i);
    }

    public boolean removeChild(View view) {
        return IMPL.removeChild(this.mInfo, view);
    }

    public boolean removeChild(View view, int i) {
        return IMPL.removeChild(this.mInfo, view, i);
    }

    public int getActions() {
        return IMPL.getActions(this.mInfo);
    }

    public void addAction(int i) {
        IMPL.addAction(this.mInfo, i);
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        IMPL.addAction(this.mInfo, accessibilityActionCompat.mAction);
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return IMPL.removeAction(this.mInfo, accessibilityActionCompat.mAction);
    }

    public boolean performAction(int i) {
        return IMPL.performAction(this.mInfo, i);
    }

    public boolean performAction(int i, Bundle bundle) {
        return IMPL.performAction(this.mInfo, i, bundle);
    }

    public void setMovementGranularities(int i) {
        IMPL.setMovementGranularities(this.mInfo, i);
    }

    public int getMovementGranularities() {
        return IMPL.getMovementGranularities(this.mInfo);
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<Object> findAccessibilityNodeInfosByText = IMPL.findAccessibilityNodeInfosByText(this.mInfo, str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new AccessibilityNodeInfoCompat(findAccessibilityNodeInfosByText.get(i)));
        }
        return arrayList;
    }

    public AccessibilityNodeInfoCompat getParent() {
        return wrapNonNullInstance(IMPL.getParent(this.mInfo));
    }

    public void setParent(View view) {
        IMPL.setParent(this.mInfo, view);
    }

    public void setParent(View view, int i) {
        this.mParentVirtualDescendantId = i;
        IMPL.setParent(this.mInfo, view, i);
    }

    public void getBoundsInParent(Rect rect) {
        IMPL.getBoundsInParent(this.mInfo, rect);
    }

    public void setBoundsInParent(Rect rect) {
        IMPL.setBoundsInParent(this.mInfo, rect);
    }

    public void getBoundsInScreen(Rect rect) {
        IMPL.getBoundsInScreen(this.mInfo, rect);
    }

    public void setBoundsInScreen(Rect rect) {
        IMPL.setBoundsInScreen(this.mInfo, rect);
    }

    public boolean isCheckable() {
        return IMPL.isCheckable(this.mInfo);
    }

    public void setCheckable(boolean z) {
        IMPL.setCheckable(this.mInfo, z);
    }

    public boolean isChecked() {
        return IMPL.isChecked(this.mInfo);
    }

    public void setChecked(boolean z) {
        IMPL.setChecked(this.mInfo, z);
    }

    public boolean isFocusable() {
        return IMPL.isFocusable(this.mInfo);
    }

    public void setFocusable(boolean z) {
        IMPL.setFocusable(this.mInfo, z);
    }

    public boolean isFocused() {
        return IMPL.isFocused(this.mInfo);
    }

    public void setFocused(boolean z) {
        IMPL.setFocused(this.mInfo, z);
    }

    public boolean isVisibleToUser() {
        return IMPL.isVisibleToUser(this.mInfo);
    }

    public void setVisibleToUser(boolean z) {
        IMPL.setVisibleToUser(this.mInfo, z);
    }

    public boolean isAccessibilityFocused() {
        return IMPL.isAccessibilityFocused(this.mInfo);
    }

    public void setAccessibilityFocused(boolean z) {
        IMPL.setAccessibilityFocused(this.mInfo, z);
    }

    public boolean isSelected() {
        return IMPL.isSelected(this.mInfo);
    }

    public void setSelected(boolean z) {
        IMPL.setSelected(this.mInfo, z);
    }

    public boolean isClickable() {
        return IMPL.isClickable(this.mInfo);
    }

    public void setClickable(boolean z) {
        IMPL.setClickable(this.mInfo, z);
    }

    public boolean isLongClickable() {
        return IMPL.isLongClickable(this.mInfo);
    }

    public void setLongClickable(boolean z) {
        IMPL.setLongClickable(this.mInfo, z);
    }

    public boolean isEnabled() {
        return IMPL.isEnabled(this.mInfo);
    }

    public void setEnabled(boolean z) {
        IMPL.setEnabled(this.mInfo, z);
    }

    public boolean isPassword() {
        return IMPL.isPassword(this.mInfo);
    }

    public void setPassword(boolean z) {
        IMPL.setPassword(this.mInfo, z);
    }

    public boolean isScrollable() {
        return IMPL.isScrollable(this.mInfo);
    }

    public void setScrollable(boolean z) {
        IMPL.setScrollable(this.mInfo, z);
    }

    public boolean isImportantForAccessibility() {
        return IMPL.isImportantForAccessibility(this.mInfo);
    }

    public void setImportantForAccessibility(boolean z) {
        IMPL.setImportantForAccessibility(this.mInfo, z);
    }

    public CharSequence getPackageName() {
        return IMPL.getPackageName(this.mInfo);
    }

    public void setPackageName(CharSequence charSequence) {
        IMPL.setPackageName(this.mInfo, charSequence);
    }

    public CharSequence getClassName() {
        return IMPL.getClassName(this.mInfo);
    }

    public void setClassName(CharSequence charSequence) {
        IMPL.setClassName(this.mInfo, charSequence);
    }

    public CharSequence getText() {
        return IMPL.getText(this.mInfo);
    }

    public void setText(CharSequence charSequence) {
        IMPL.setText(this.mInfo, charSequence);
    }

    public CharSequence getContentDescription() {
        return IMPL.getContentDescription(this.mInfo);
    }

    public void setContentDescription(CharSequence charSequence) {
        IMPL.setContentDescription(this.mInfo, charSequence);
    }

    public void recycle() {
        IMPL.recycle(this.mInfo);
    }

    public void setViewIdResourceName(String str) {
        IMPL.setViewIdResourceName(this.mInfo, str);
    }

    public String getViewIdResourceName() {
        return IMPL.getViewIdResourceName(this.mInfo);
    }

    public int getLiveRegion() {
        return IMPL.getLiveRegion(this.mInfo);
    }

    public void setLiveRegion(int i) {
        IMPL.setLiveRegion(this.mInfo, i);
    }

    public int getDrawingOrder() {
        return IMPL.getDrawingOrder(this.mInfo);
    }

    public void setDrawingOrder(int i) {
        IMPL.setDrawingOrder(this.mInfo, i);
    }

    public CollectionInfoCompat getCollectionInfo() {
        Object collectionInfo = IMPL.getCollectionInfo(this.mInfo);
        if (collectionInfo == null) {
            return null;
        }
        return new CollectionInfoCompat(collectionInfo);
    }

    public void setCollectionInfo(Object obj) {
        IMPL.setCollectionInfo(this.mInfo, ((CollectionInfoCompat) obj).mInfo);
    }

    public void setCollectionItemInfo(Object obj) {
        IMPL.setCollectionItemInfo(this.mInfo, ((CollectionItemInfoCompat) obj).mInfo);
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        Object collectionItemInfo = IMPL.getCollectionItemInfo(this.mInfo);
        if (collectionItemInfo == null) {
            return null;
        }
        return new CollectionItemInfoCompat(collectionItemInfo);
    }

    public RangeInfoCompat getRangeInfo() {
        Object rangeInfo = IMPL.getRangeInfo(this.mInfo);
        if (rangeInfo == null) {
            return null;
        }
        return new RangeInfoCompat(rangeInfo);
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        IMPL.setRangeInfo(this.mInfo, rangeInfoCompat.mInfo);
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<Object> actionList = IMPL.getActionList(this.mInfo);
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i)));
        }
        return arrayList;
    }

    public void setContentInvalid(boolean z) {
        IMPL.setContentInvalid(this.mInfo, z);
    }

    public boolean isContentInvalid() {
        return IMPL.isContentInvalid(this.mInfo);
    }

    public boolean isContextClickable() {
        return IMPL.isContextClickable(this.mInfo);
    }

    public void setContextClickable(boolean z) {
        IMPL.setContextClickable(this.mInfo, z);
    }

    public void setError(CharSequence charSequence) {
        IMPL.setError(this.mInfo, charSequence);
    }

    public CharSequence getError() {
        return IMPL.getError(this.mInfo);
    }

    public void setLabelFor(View view) {
        IMPL.setLabelFor(this.mInfo, view);
    }

    public void setLabelFor(View view, int i) {
        IMPL.setLabelFor(this.mInfo, view, i);
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return wrapNonNullInstance(IMPL.getLabelFor(this.mInfo));
    }

    public void setLabeledBy(View view) {
        IMPL.setLabeledBy(this.mInfo, view);
    }

    public void setLabeledBy(View view, int i) {
        IMPL.setLabeledBy(this.mInfo, view, i);
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return wrapNonNullInstance(IMPL.getLabeledBy(this.mInfo));
    }

    public boolean canOpenPopup() {
        return IMPL.canOpenPopup(this.mInfo);
    }

    public void setCanOpenPopup(boolean z) {
        IMPL.setCanOpenPopup(this.mInfo, z);
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        List<Object> findAccessibilityNodeInfosByViewId = IMPL.findAccessibilityNodeInfosByViewId(this.mInfo, str);
        if (findAccessibilityNodeInfosByViewId == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object accessibilityNodeInfoCompat : findAccessibilityNodeInfosByViewId) {
            arrayList.add(new AccessibilityNodeInfoCompat(accessibilityNodeInfoCompat));
        }
        return arrayList;
    }

    public Bundle getExtras() {
        return IMPL.getExtras(this.mInfo);
    }

    public int getInputType() {
        return IMPL.getInputType(this.mInfo);
    }

    public void setInputType(int i) {
        IMPL.setInputType(this.mInfo, i);
    }

    public void setMaxTextLength(int i) {
        IMPL.setMaxTextLength(this.mInfo, i);
    }

    public int getMaxTextLength() {
        return IMPL.getMaxTextLength(this.mInfo);
    }

    public void setTextSelection(int i, int i2) {
        IMPL.setTextSelection(this.mInfo, i, i2);
    }

    public int getTextSelectionStart() {
        return IMPL.getTextSelectionStart(this.mInfo);
    }

    public int getTextSelectionEnd() {
        return IMPL.getTextSelectionEnd(this.mInfo);
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return wrapNonNullInstance(IMPL.getTraversalBefore(this.mInfo));
    }

    public void setTraversalBefore(View view) {
        IMPL.setTraversalBefore(this.mInfo, view);
    }

    public void setTraversalBefore(View view, int i) {
        IMPL.setTraversalBefore(this.mInfo, view, i);
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return wrapNonNullInstance(IMPL.getTraversalAfter(this.mInfo));
    }

    public void setTraversalAfter(View view) {
        IMPL.setTraversalAfter(this.mInfo, view);
    }

    public void setTraversalAfter(View view, int i) {
        IMPL.setTraversalAfter(this.mInfo, view, i);
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.wrapNonNullInstance(IMPL.getWindow(this.mInfo));
    }

    public boolean isDismissable() {
        return IMPL.isDismissable(this.mInfo);
    }

    public void setDismissable(boolean z) {
        IMPL.setDismissable(this.mInfo, z);
    }

    public boolean isEditable() {
        return IMPL.isEditable(this.mInfo);
    }

    public void setEditable(boolean z) {
        IMPL.setEditable(this.mInfo, z);
    }

    public boolean isMultiLine() {
        return IMPL.isMultiLine(this.mInfo);
    }

    public void setMultiLine(boolean z) {
        IMPL.setMultiLine(this.mInfo, z);
    }

    public boolean refresh() {
        return IMPL.refresh(this.mInfo);
    }

    @Nullable
    public CharSequence getRoleDescription() {
        return IMPL.getRoleDescription(this.mInfo);
    }

    public void setRoleDescription(@Nullable CharSequence charSequence) {
        IMPL.setRoleDescription(this.mInfo, charSequence);
    }

    public int hashCode() {
        Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        Object obj2 = this.mInfo;
        if (obj2 == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!obj2.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb.append("; boundsInParent: ".concat(String.valueOf(rect)));
        getBoundsInScreen(rect);
        sb.append("; boundsInScreen: ".concat(String.valueOf(rect)));
        sb.append("; packageName: ");
        sb.append(getPackageName());
        sb.append("; className: ");
        sb.append(getClassName());
        sb.append("; text: ");
        sb.append(getText());
        sb.append("; contentDescription: ");
        sb.append(getContentDescription());
        sb.append("; viewId: ");
        sb.append(getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(isCheckable());
        sb.append("; checked: ");
        sb.append(isChecked());
        sb.append("; focusable: ");
        sb.append(isFocusable());
        sb.append("; focused: ");
        sb.append(isFocused());
        sb.append("; selected: ");
        sb.append(isSelected());
        sb.append("; clickable: ");
        sb.append(isClickable());
        sb.append("; longClickable: ");
        sb.append(isLongClickable());
        sb.append("; enabled: ");
        sb.append(isEnabled());
        sb.append("; password: ");
        sb.append(isPassword());
        sb.append("; scrollable: " + isScrollable());
        sb.append("; [");
        int actions = getActions();
        while (actions != 0) {
            int numberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(actions);
            actions &= numberOfTrailingZeros ^ -1;
            sb.append(getActionSymbolicName(numberOfTrailingZeros));
            if (actions != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
