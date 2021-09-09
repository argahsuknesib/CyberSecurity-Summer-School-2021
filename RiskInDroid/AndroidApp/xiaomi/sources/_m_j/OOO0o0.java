package _m_j;

import _m_j.o0OOoOoo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import com.xiaomi.smarthome.R;

public final class OOO0o0 {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final PorterDuff.Mode f12321O000000o = PorterDuff.Mode.SRC_IN;
    private static OOO0o0 O00000Oo;
    private o0OOoOoo O00000o0;

    public static synchronized void O000000o() {
        synchronized (OOO0o0.class) {
            if (O00000Oo == null) {
                OOO0o0 oOO0o0 = new OOO0o0();
                O00000Oo = oOO0o0;
                oOO0o0.O00000o0 = o0OOoOoo.O000000o();
                O00000Oo.O00000o0.O000000o(new o0OOoOoo.O0000O0o() {
                    /* class _m_j.OOO0o0.AnonymousClass1 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    private final int[] f12322O000000o = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                    private final int[] O00000Oo = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                    private final int[] O00000o = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                    private final int[] O00000o0 = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};
                    private final int[] O00000oO = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                    private final int[] O00000oo = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

                    private static ColorStateList O00000Oo(Context context, int i) {
                        int O000000o2 = Oo000.O000000o(context, (int) R.attr.colorControlHighlight);
                        int O00000o02 = Oo000.O00000o0(context, R.attr.colorButtonNormal);
                        return new ColorStateList(new int[][]{Oo000.f12343O000000o, Oo000.O00000o, Oo000.O00000Oo, Oo000.O0000OOo}, new int[]{O00000o02, q.O000000o(O000000o2, i), q.O000000o(O000000o2, i), i});
                    }

                    public final Drawable O000000o(o0OOoOoo o0oooooo, Context context, int i) {
                        if (i != R.drawable.abc_cab_background_top_material) {
                            return null;
                        }
                        return new LayerDrawable(new Drawable[]{o0oooooo.O000000o(context, (int) R.drawable.abc_cab_background_internal_bg), o0oooooo.O000000o(context, (int) R.drawable.abc_cab_background_top_mtrl_alpha)});
                    }

                    private static void O000000o(Drawable drawable, int i, PorterDuff.Mode mode) {
                        if (OOOOOo0.O00000o0(drawable)) {
                            drawable = drawable.mutate();
                        }
                        if (mode == null) {
                            mode = OOO0o0.f12321O000000o;
                        }
                        drawable.setColorFilter(OOO0o0.O000000o(i, mode));
                    }

                    public final boolean O000000o(Context context, int i, Drawable drawable) {
                        if (i == R.drawable.abc_seekbar_track_material) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            O000000o(layerDrawable.findDrawableByLayerId(16908288), Oo000.O000000o(context, (int) R.attr.colorControlNormal), OOO0o0.f12321O000000o);
                            O000000o(layerDrawable.findDrawableByLayerId(16908303), Oo000.O000000o(context, (int) R.attr.colorControlNormal), OOO0o0.f12321O000000o);
                            O000000o(layerDrawable.findDrawableByLayerId(16908301), Oo000.O000000o(context, (int) R.attr.colorControlActivated), OOO0o0.f12321O000000o);
                            return true;
                        } else if (i != R.drawable.abc_ratingbar_material && i != R.drawable.abc_ratingbar_indicator_material && i != R.drawable.abc_ratingbar_small_material) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            O000000o(layerDrawable2.findDrawableByLayerId(16908288), Oo000.O00000o0(context, R.attr.colorControlNormal), OOO0o0.f12321O000000o);
                            O000000o(layerDrawable2.findDrawableByLayerId(16908303), Oo000.O000000o(context, (int) R.attr.colorControlActivated), OOO0o0.f12321O000000o);
                            O000000o(layerDrawable2.findDrawableByLayerId(16908301), Oo000.O000000o(context, (int) R.attr.colorControlActivated), OOO0o0.f12321O000000o);
                            return true;
                        }
                    }

                    private static boolean O000000o(int[] iArr, int i) {
                        for (int i2 : iArr) {
                            if (i2 == i) {
                                return true;
                            }
                        }
                        return false;
                    }

                    public final ColorStateList O000000o(Context context, int i) {
                        if (i == R.drawable.abc_edit_text_material) {
                            return OO0000o.O000000o(context, R.color.abc_tint_edittext);
                        }
                        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
                            return OO0000o.O000000o(context, R.color.abc_tint_switch_track);
                        }
                        if (i == R.drawable.abc_switch_thumb_material) {
                            int[][] iArr = new int[3][];
                            int[] iArr2 = new int[3];
                            ColorStateList O00000Oo2 = Oo000.O00000Oo(context, R.attr.colorSwitchThumbNormal);
                            if (O00000Oo2 == null || !O00000Oo2.isStateful()) {
                                iArr[0] = Oo000.f12343O000000o;
                                iArr2[0] = Oo000.O00000o0(context, R.attr.colorSwitchThumbNormal);
                                iArr[1] = Oo000.O00000oO;
                                iArr2[1] = Oo000.O000000o(context, (int) R.attr.colorControlActivated);
                                iArr[2] = Oo000.O0000OOo;
                                iArr2[2] = Oo000.O000000o(context, (int) R.attr.colorSwitchThumbNormal);
                            } else {
                                iArr[0] = Oo000.f12343O000000o;
                                iArr2[0] = O00000Oo2.getColorForState(iArr[0], 0);
                                iArr[1] = Oo000.O00000oO;
                                iArr2[1] = Oo000.O000000o(context, (int) R.attr.colorControlActivated);
                                iArr[2] = Oo000.O0000OOo;
                                iArr2[2] = O00000Oo2.getDefaultColor();
                            }
                            return new ColorStateList(iArr, iArr2);
                        } else if (i == R.drawable.abc_btn_default_mtrl_shape) {
                            return O00000Oo(context, Oo000.O000000o(context, (int) R.attr.colorButtonNormal));
                        } else {
                            if (i == R.drawable.abc_btn_borderless_material) {
                                return O00000Oo(context, 0);
                            }
                            if (i == R.drawable.abc_btn_colored_material) {
                                return O00000Oo(context, Oo000.O000000o(context, (int) R.attr.colorAccent));
                            }
                            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                                return OO0000o.O000000o(context, R.color.abc_tint_spinner);
                            }
                            if (O000000o(this.O00000Oo, i)) {
                                return Oo000.O00000Oo(context, R.attr.colorControlNormal);
                            }
                            if (O000000o(this.O00000oO, i)) {
                                return OO0000o.O000000o(context, R.color.abc_tint_default);
                            }
                            if (O000000o(this.O00000oo, i)) {
                                return OO0000o.O000000o(context, R.color.abc_tint_btn_checkable);
                            }
                            if (i == R.drawable.abc_seekbar_thumb_material) {
                                return OO0000o.O000000o(context, R.color.abc_tint_seek_thumb);
                            }
                            return null;
                        }
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
                    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068 A[RETURN] */
                    public final boolean O00000Oo(Context context, int i, Drawable drawable) {
                        boolean z;
                        PorterDuff.Mode mode;
                        int i2;
                        PorterDuff.Mode mode2 = OOO0o0.f12321O000000o;
                        int i3 = 16842801;
                        if (O000000o(this.f12322O000000o, i)) {
                            i3 = R.attr.colorControlNormal;
                        } else if (O000000o(this.O00000o0, i)) {
                            i3 = R.attr.colorControlActivated;
                        } else if (O000000o(this.O00000o, i)) {
                            mode2 = PorterDuff.Mode.MULTIPLY;
                        } else {
                            if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                                i3 = 16842800;
                                mode = mode2;
                                i2 = Math.round(40.8f);
                                z = true;
                            } else if (i != R.drawable.abc_dialog_material_background) {
                                mode = mode2;
                                z = false;
                                i2 = -1;
                                i3 = 0;
                            }
                            if (z) {
                                return false;
                            }
                            if (OOOOOo0.O00000o0(drawable)) {
                                drawable = drawable.mutate();
                            }
                            drawable.setColorFilter(OOO0o0.O000000o(Oo000.O000000o(context, i3), mode));
                            if (i2 != -1) {
                                drawable.setAlpha(i2);
                            }
                            return true;
                        }
                        mode = mode2;
                        z = true;
                        i2 = -1;
                        if (z) {
                        }
                    }

                    public final PorterDuff.Mode O000000o(int i) {
                        if (i == R.drawable.abc_switch_thumb_material) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }
                });
            }
        }
    }

    public static synchronized OOO0o0 O00000Oo() {
        OOO0o0 oOO0o0;
        synchronized (OOO0o0.class) {
            if (O00000Oo == null) {
                O000000o();
            }
            oOO0o0 = O00000Oo;
        }
        return oOO0o0;
    }

    public final synchronized Drawable O000000o(Context context, int i) {
        return this.O00000o0.O000000o(context, i);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.o0OOoOoo.O000000o(android.content.Context, int, boolean):android.graphics.drawable.Drawable
     arg types: [android.content.Context, int, int]
     candidates:
      _m_j.o0OOoOoo.O000000o(android.graphics.drawable.Drawable, _m_j.Oo00, int[]):void
      _m_j.o0OOoOoo.O000000o(android.content.Context, long, android.graphics.drawable.Drawable):boolean
      _m_j.o0OOoOoo.O000000o(android.content.Context, _m_j.o000, int):android.graphics.drawable.Drawable
      _m_j.o0OOoOoo.O000000o(android.content.Context, int, android.graphics.drawable.Drawable):boolean
      _m_j.o0OOoOoo.O000000o(android.content.Context, int, boolean):android.graphics.drawable.Drawable */
    /* access modifiers changed from: package-private */
    public final synchronized Drawable O00000Oo(Context context, int i) {
        return this.O00000o0.O000000o(context, i, true);
    }

    public final synchronized void O000000o(Context context) {
        this.O00000o0.O000000o(context);
    }

    /* access modifiers changed from: package-private */
    public final synchronized ColorStateList O00000o0(Context context, int i) {
        return this.O00000o0.O00000Oo(context, i);
    }

    static void O000000o(Drawable drawable, Oo00 oo00, int[] iArr) {
        o0OOoOoo.O000000o(drawable, oo00, iArr);
    }

    public static synchronized PorterDuffColorFilter O000000o(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter O000000o2;
        synchronized (OOO0o0.class) {
            O000000o2 = o0OOoOoo.O000000o(i, mode);
        }
        return O000000o2;
    }
}
