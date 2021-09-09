package com.google.android.material.dialog;

import _m_j.cb;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.xiaomi.smarthome.R;

public class MaterialAlertDialogBuilder extends AlertDialog.Builder {
    private static final int DEF_STYLE_ATTR = 2131820599;
    private static final int DEF_STYLE_RES = 2132738412;
    private static final int MATERIAL_ALERT_DIALOG_THEME_OVERLAY = 2131821544;
    private Drawable background;
    private final Rect backgroundInsets;

    private static int getMaterialAlertDialogThemeOverlay(Context context) {
        TypedValue resolve = MaterialAttributes.resolve(context, MATERIAL_ALERT_DIALOG_THEME_OVERLAY);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private static Context createMaterialAlertDialogThemedContext(Context context) {
        int materialAlertDialogThemeOverlay = getMaterialAlertDialogThemeOverlay(context);
        Context wrap = MaterialThemeOverlay.wrap(context, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        if (materialAlertDialogThemeOverlay == 0) {
            return wrap;
        }
        return new ContextThemeWrapper(wrap, materialAlertDialogThemeOverlay);
    }

    private static int getOverridingThemeResId(Context context, int i) {
        return i == 0 ? getMaterialAlertDialogThemeOverlay(context) : i;
    }

    public MaterialAlertDialogBuilder(Context context) {
        this(context, 0);
    }

    public MaterialAlertDialogBuilder(Context context, int i) {
        super(createMaterialAlertDialogThemedContext(context), getOverridingThemeResId(context, i));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        this.backgroundInsets = MaterialDialogs.getDialogBackgroundInsets(context2, DEF_STYLE_ATTR, DEF_STYLE_RES);
        int color = MaterialColors.getColor(context2, (int) R.attr.colorSurface, getClass().getCanonicalName());
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context2, null, DEF_STYLE_ATTR, DEF_STYLE_RES);
        materialShapeDrawable.initializeElevationOverlay(context2);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(16844145, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                materialShapeDrawable.setCornerSize(dimension);
            }
        }
        this.background = materialShapeDrawable;
    }

    public AlertDialog create() {
        AlertDialog create = super.create();
        Window window = create.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.background;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).setElevation(cb.O0000oOO(decorView));
        }
        window.setBackgroundDrawable(MaterialDialogs.insetDrawable(this.background, this.backgroundInsets));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(create, this.backgroundInsets));
        return create;
    }

    public Drawable getBackground() {
        return this.background;
    }

    public MaterialAlertDialogBuilder setBackground(Drawable drawable) {
        this.background = drawable;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetStart(int i) {
        if (Build.VERSION.SDK_INT < 17 || getContext().getResources().getConfiguration().getLayoutDirection() != 1) {
            this.backgroundInsets.left = i;
        } else {
            this.backgroundInsets.right = i;
        }
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetTop(int i) {
        this.backgroundInsets.top = i;
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetEnd(int i) {
        if (Build.VERSION.SDK_INT < 17 || getContext().getResources().getConfiguration().getLayoutDirection() != 1) {
            this.backgroundInsets.right = i;
        } else {
            this.backgroundInsets.left = i;
        }
        return this;
    }

    public MaterialAlertDialogBuilder setBackgroundInsetBottom(int i) {
        this.backgroundInsets.bottom = i;
        return this;
    }

    public MaterialAlertDialogBuilder setTitle(int i) {
        return (MaterialAlertDialogBuilder) super.setTitle(i);
    }

    public MaterialAlertDialogBuilder setTitle(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setTitle(charSequence);
    }

    public MaterialAlertDialogBuilder setCustomTitle(View view) {
        return (MaterialAlertDialogBuilder) super.setCustomTitle(view);
    }

    public MaterialAlertDialogBuilder setMessage(int i) {
        return (MaterialAlertDialogBuilder) super.setMessage(i);
    }

    public MaterialAlertDialogBuilder setMessage(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.setMessage(charSequence);
    }

    public MaterialAlertDialogBuilder setIcon(int i) {
        return (MaterialAlertDialogBuilder) super.setIcon(i);
    }

    public MaterialAlertDialogBuilder setIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setIcon(drawable);
    }

    public MaterialAlertDialogBuilder setIconAttribute(int i) {
        return (MaterialAlertDialogBuilder) super.setIconAttribute(i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setPositiveButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [int, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setPositiveButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setPositiveButton(int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setPositiveButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setPositiveButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setPositiveButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(i, onClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setPositiveButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [java.lang.CharSequence, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setPositiveButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setPositiveButton(int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setPositiveButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setPositiveButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setPositiveButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setPositiveButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setPositiveButton(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder setPositiveButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setPositiveButtonIcon(drawable);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setNegativeButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [int, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNegativeButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNegativeButton(int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNegativeButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setNegativeButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setNegativeButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(i, onClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setNegativeButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [java.lang.CharSequence, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNegativeButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNegativeButton(int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNegativeButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setNegativeButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setNegativeButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setNegativeButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNegativeButton(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder setNegativeButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNegativeButtonIcon(drawable);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setNeutralButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [int, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNeutralButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNeutralButton(int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNeutralButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setNeutralButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setNeutralButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setNeutralButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(i, onClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setNeutralButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [java.lang.CharSequence, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNeutralButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNeutralButton(int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setNeutralButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setNeutralButton(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setNeutralButton(java.lang.CharSequence, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setNeutralButton(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setNeutralButton(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder setNeutralButtonIcon(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.setNeutralButtonIcon(drawable);
    }

    public MaterialAlertDialogBuilder setCancelable(boolean z) {
        return (MaterialAlertDialogBuilder) super.setCancelable(z);
    }

    public MaterialAlertDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.setOnCancelListener(onCancelListener);
    }

    public MaterialAlertDialogBuilder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return (MaterialAlertDialogBuilder) super.setOnDismissListener(onDismissListener);
    }

    public MaterialAlertDialogBuilder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.setOnKeyListener(onKeyListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setItems(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [int, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setItems(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setItems(int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setItems(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setItems(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setItems(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setItems(int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(i, onClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setItems(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [java.lang.CharSequence[], android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setItems(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setItems(int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setItems(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setItems(int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setItems(java.lang.CharSequence[], android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setItems(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setItems(charSequenceArr, onClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setAdapter(android.widget.ListAdapter, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [android.widget.ListAdapter, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setAdapter(android.widget.ListAdapter, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setAdapter(android.widget.ListAdapter, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setAdapter(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setAdapter(listAdapter, onClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setCursor(android.database.Cursor, android.content.DialogInterface$OnClickListener, java.lang.String):androidx.appcompat.app.AlertDialog$Builder
     arg types: [android.database.Cursor, android.content.DialogInterface$OnClickListener, java.lang.String]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setCursor(android.database.Cursor, android.content.DialogInterface$OnClickListener, java.lang.String):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setCursor(android.database.Cursor, android.content.DialogInterface$OnClickListener, java.lang.String):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setCursor(Cursor cursor, DialogInterface.OnClickListener onClickListener, String str) {
        return (MaterialAlertDialogBuilder) super.setCursor(cursor, onClickListener, str);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setMultiChoiceItems(int, boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [int, boolean[], android.content.DialogInterface$OnMultiChoiceClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setMultiChoiceItems(java.lang.CharSequence[], boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setMultiChoiceItems(int, boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setMultiChoiceItems(java.lang.CharSequence[], boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setMultiChoiceItems(java.lang.CharSequence[], boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setMultiChoiceItems(int, boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setMultiChoiceItems(int i, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(i, zArr, onMultiChoiceClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setMultiChoiceItems(java.lang.CharSequence[], boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [java.lang.CharSequence[], boolean[], android.content.DialogInterface$OnMultiChoiceClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setMultiChoiceItems(int, boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setMultiChoiceItems(int, boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setMultiChoiceItems(java.lang.CharSequence[], boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setMultiChoiceItems(int, boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setMultiChoiceItems(java.lang.CharSequence[], boolean[], android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setMultiChoiceItems(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setMultiChoiceItems(android.database.Cursor, java.lang.String, java.lang.String, android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [android.database.Cursor, java.lang.String, java.lang.String, android.content.DialogInterface$OnMultiChoiceClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setMultiChoiceItems(android.database.Cursor, java.lang.String, java.lang.String, android.content.DialogInterface$OnMultiChoiceClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setMultiChoiceItems(android.database.Cursor, java.lang.String, java.lang.String, android.content.DialogInterface$OnMultiChoiceClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setMultiChoiceItems(Cursor cursor, String str, String str2, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.setMultiChoiceItems(cursor, str, str2, onMultiChoiceClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(int, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [int, int, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(int, int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(int, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setSingleChoiceItems(int i, int i2, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(i, i2, onClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(android.database.Cursor, int, java.lang.String, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [android.database.Cursor, int, java.lang.String, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(android.database.Cursor, int, java.lang.String, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(android.database.Cursor, int, java.lang.String, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setSingleChoiceItems(Cursor cursor, int i, String str, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(cursor, i, str, onClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(int, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(int, int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(int, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setSingleChoiceItems(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(charSequenceArr, i, onClickListener);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
     arg types: [android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener]
     candidates:
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(int, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(int, int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      com.google.android.material.dialog.MaterialAlertDialogBuilder.setSingleChoiceItems(java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener):com.google.android.material.dialog.MaterialAlertDialogBuilder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(int, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(java.lang.CharSequence[], int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder
      androidx.appcompat.app.AlertDialog.Builder.setSingleChoiceItems(android.widget.ListAdapter, int, android.content.DialogInterface$OnClickListener):androidx.appcompat.app.AlertDialog$Builder */
    public MaterialAlertDialogBuilder setSingleChoiceItems(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.setSingleChoiceItems(listAdapter, i, onClickListener);
    }

    public MaterialAlertDialogBuilder setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        return (MaterialAlertDialogBuilder) super.setOnItemSelectedListener(onItemSelectedListener);
    }

    public MaterialAlertDialogBuilder setView(int i) {
        return (MaterialAlertDialogBuilder) super.setView(i);
    }

    public MaterialAlertDialogBuilder setView(View view) {
        return (MaterialAlertDialogBuilder) super.setView(view);
    }
}
