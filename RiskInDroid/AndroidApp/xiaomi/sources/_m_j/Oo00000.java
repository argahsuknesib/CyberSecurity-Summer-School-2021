package _m_j;

import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
public final class Oo00000 extends de implements View.OnClickListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f12344O000000o = 1;
    private final SearchView O0000OoO;
    private final SearchableInfo O0000Ooo;
    private ColorStateList O0000o;
    private final WeakHashMap<String, Drawable.ConstantState> O0000o0;
    private final Context O0000o00;
    private final int O0000o0O;
    private boolean O0000o0o = false;
    private int O0000oO = -1;
    private int O0000oO0 = -1;
    private int O0000oOO = -1;
    private int O0000oOo = -1;
    private int O0000oo = -1;
    private int O0000oo0 = -1;

    public final boolean hasStableIds() {
        return false;
    }

    public Oo00000(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout());
        this.O0000OoO = searchView;
        this.O0000Ooo = searchableInfo;
        this.O0000o0O = searchView.getSuggestionCommitIconResId();
        this.O0000o00 = context;
        this.O0000o0 = weakHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079 A[Catch:{ RuntimeException -> 0x007d }] */
    public final Cursor O000000o(CharSequence charSequence) {
        Cursor cursor;
        String[] strArr;
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.O0000OoO.getVisibility() == 0 && this.O0000OoO.getWindowVisibility() == 0) {
            try {
                SearchableInfo searchableInfo = this.O0000Ooo;
                if (searchableInfo != null) {
                    String suggestAuthority = searchableInfo.getSuggestAuthority();
                    if (suggestAuthority != null) {
                        Uri.Builder fragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
                        String suggestPath = searchableInfo.getSuggestPath();
                        if (suggestPath != null) {
                            fragment.appendEncodedPath(suggestPath);
                        }
                        fragment.appendPath("search_suggest_query");
                        String suggestSelection = searchableInfo.getSuggestSelection();
                        if (suggestSelection != null) {
                            strArr = new String[]{charSequence2};
                        } else {
                            fragment.appendPath(charSequence2);
                            strArr = null;
                        }
                        fragment.appendQueryParameter("limit", "50");
                        cursor = this.O00000oO.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
                        if (cursor != null) {
                            cursor.getCount();
                            return cursor;
                        }
                    }
                }
                cursor = null;
                if (cursor != null) {
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        O00000o0(O000000o());
    }

    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        O00000o0(O000000o());
    }

    private static void O00000o0(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    public final void O000000o(Cursor cursor) {
        if (this.O0000o0o) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.O000000o(cursor);
            if (cursor != null) {
                this.O0000oO0 = cursor.getColumnIndex("suggest_text_1");
                this.O0000oO = cursor.getColumnIndex("suggest_text_2");
                this.O0000oOO = cursor.getColumnIndex("suggest_text_2_url");
                this.O0000oOo = cursor.getColumnIndex("suggest_icon_1");
                this.O0000oo0 = cursor.getColumnIndex("suggest_icon_2");
                this.O0000oo = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public final View O000000o(Context context, Cursor cursor, ViewGroup viewGroup) {
        View O000000o2 = super.O000000o(context, cursor, viewGroup);
        O000000o2.setTag(new O000000o(O000000o2));
        ((ImageView) O000000o2.findViewById(R.id.edit_query)).setImageResource(this.O0000o0O);
        return O000000o2;
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final TextView f12345O000000o;
        public final TextView O00000Oo;
        public final ImageView O00000o;
        public final ImageView O00000o0;
        public final ImageView O00000oO;

        public O000000o(View view) {
            this.f12345O000000o = (TextView) view.findViewById(16908308);
            this.O00000Oo = (TextView) view.findViewById(16908309);
            this.O00000o0 = (ImageView) view.findViewById(16908295);
            this.O00000o = (ImageView) view.findViewById(16908296);
            this.O00000oO = (ImageView) view.findViewById(R.id.edit_query);
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v21, resolved type: android.text.SpannableString} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v25, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v26, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    public final void O000000o(View view, Cursor cursor) {
        Drawable drawable;
        Drawable.ConstantState constantState;
        String str;
        Cursor cursor2 = cursor;
        O000000o o000000o = (O000000o) view.getTag();
        int i = this.O0000oo;
        int i2 = i != -1 ? cursor2.getInt(i) : 0;
        if (o000000o.f12345O000000o != null) {
            O000000o(o000000o.f12345O000000o, O000000o(cursor2, this.O0000oO0));
        }
        if (o000000o.O00000Oo != null) {
            String O000000o2 = O000000o(cursor2, this.O0000oOO);
            if (O000000o2 != null) {
                if (this.O0000o == null) {
                    TypedValue typedValue = new TypedValue();
                    this.O00000oO.getTheme().resolveAttribute(R.attr.textColorSearchUrl, typedValue, true);
                    this.O0000o = this.O00000oO.getResources().getColorStateList(typedValue.resourceId);
                }
                SpannableString spannableString = new SpannableString(O000000o2);
                TextAppearanceSpan textAppearanceSpan = r10;
                TextAppearanceSpan textAppearanceSpan2 = new TextAppearanceSpan(null, 0, 0, this.O0000o, null);
                spannableString.setSpan(textAppearanceSpan, 0, O000000o2.length(), 33);
                str = spannableString;
            } else {
                str = O000000o(cursor2, this.O0000oO);
            }
            if (TextUtils.isEmpty(str)) {
                if (o000000o.f12345O000000o != null) {
                    o000000o.f12345O000000o.setSingleLine(false);
                    o000000o.f12345O000000o.setMaxLines(2);
                }
            } else if (o000000o.f12345O000000o != null) {
                o000000o.f12345O000000o.setSingleLine(true);
                o000000o.f12345O000000o.setMaxLines(1);
            }
            O000000o(o000000o.O00000Oo, str);
        }
        Drawable drawable2 = null;
        if (o000000o.O00000o0 != null) {
            ImageView imageView = o000000o.O00000o0;
            int i3 = this.O0000oOo;
            if (i3 == -1) {
                drawable = null;
            } else {
                drawable = O000000o(cursor2.getString(i3));
                if (drawable == null) {
                    ComponentName searchActivity = this.O0000Ooo.getSearchActivity();
                    String flattenToShortString = searchActivity.flattenToShortString();
                    if (this.O0000o0.containsKey(flattenToShortString)) {
                        Drawable.ConstantState constantState2 = this.O0000o0.get(flattenToShortString);
                        if (constantState2 == null) {
                            drawable = null;
                        } else {
                            drawable = constantState2.newDrawable(this.O0000o00.getResources());
                        }
                    } else {
                        drawable = O000000o(searchActivity);
                        if (drawable == null) {
                            constantState = null;
                        } else {
                            constantState = drawable.getConstantState();
                        }
                        this.O0000o0.put(flattenToShortString, constantState);
                    }
                    if (drawable == null) {
                        drawable = this.O00000oO.getPackageManager().getDefaultActivityIcon();
                    }
                }
            }
            O000000o(imageView, drawable, 4);
        }
        if (o000000o.O00000o != null) {
            ImageView imageView2 = o000000o.O00000o;
            int i4 = this.O0000oo0;
            if (i4 != -1) {
                drawable2 = O000000o(cursor2.getString(i4));
            }
            O000000o(imageView2, drawable2, 8);
        }
        int i5 = this.f12344O000000o;
        if (i5 == 2 || (i5 == 1 && (i2 & 1) != 0)) {
            o000000o.O00000oO.setVisibility(0);
            o000000o.O00000oO.setTag(o000000o.f12345O000000o.getText());
            o000000o.O00000oO.setOnClickListener(this);
            return;
        }
        o000000o.O00000oO.setVisibility(8);
    }

    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.O0000OoO.setQuery((CharSequence) tag);
        }
    }

    private static void O000000o(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private static void O000000o(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final CharSequence O00000Oo(Cursor cursor) {
        String O000000o2;
        String O000000o3;
        if (cursor == null) {
            return null;
        }
        String O000000o4 = O000000o(cursor, "suggest_intent_query");
        if (O000000o4 != null) {
            return O000000o4;
        }
        if (this.O0000Ooo.shouldRewriteQueryFromData() && (O000000o3 = O000000o(cursor, "suggest_intent_data")) != null) {
            return O000000o3;
        }
        if (!this.O0000Ooo.shouldRewriteQueryFromText() || (O000000o2 = O000000o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return O000000o2;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View O000000o2 = O000000o(this.O00000oO, this.O00000o, viewGroup);
            if (O000000o2 != null) {
                ((O000000o) O000000o2.getTag()).f12345O000000o.setText(e.toString());
            }
            return O000000o2;
        }
    }

    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View O00000Oo = O00000Oo(this.O00000oO, this.O00000o, viewGroup);
            if (O00000Oo != null) {
                ((O000000o) O00000Oo.getTag()).f12345O000000o.setText(e.toString());
            }
            return O00000Oo;
        }
    }

    private Drawable O000000o(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.O0000o00.getPackageName() + "/" + parseInt;
            Drawable O00000Oo = O00000Oo(str2);
            if (O00000Oo != null) {
                return O00000Oo;
            }
            Drawable O000000o2 = ContextCompat.O000000o(this.O0000o00, parseInt);
            O000000o(str2, O000000o2);
            return O000000o2;
        } catch (NumberFormatException unused) {
            Drawable O00000Oo2 = O00000Oo(str);
            if (O00000Oo2 != null) {
                return O00000Oo2;
            }
            Drawable O000000o3 = O000000o(Uri.parse(str));
            O000000o(str, O000000o3);
            return O000000o3;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: ".concat(String.valueOf(str)));
            return null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: ".concat(java.lang.String.valueOf(r7)));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
    private Drawable O000000o(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return O00000Oo(uri);
            }
            openInputStream = this.O0000o00.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
                try {
                    openInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for ".concat(String.valueOf(uri)), e);
                }
                return createFromStream;
            }
            throw new FileNotFoundException("Failed to open ".concat(String.valueOf(uri)));
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (IOException e3) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for ".concat(String.valueOf(uri)), e3);
            }
            throw th;
        }
    }

    private Drawable O00000Oo(String str) {
        Drawable.ConstantState constantState = this.O0000o0.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void O000000o(String str, Drawable drawable) {
        if (drawable != null) {
            this.O0000o0.put(str, drawable.getConstantState());
        }
    }

    private Drawable O000000o(ComponentName componentName) {
        PackageManager packageManager = this.O00000oO.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, NotificationCompat.FLAG_HIGH_PRIORITY);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String O000000o(Cursor cursor, String str) {
        return O000000o(cursor, cursor.getColumnIndex(str));
    }

    private static String O000000o(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    private Drawable O00000Oo(Uri uri) throws FileNotFoundException {
        int i;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.O00000oO.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: ".concat(String.valueOf(uri)));
                        }
                    } else if (size == 2) {
                        i = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: ".concat(String.valueOf(uri)));
                    }
                    if (i != 0) {
                        return resourcesForApplication.getDrawable(i);
                    }
                    throw new FileNotFoundException("No resource found for: ".concat(String.valueOf(uri)));
                }
                throw new FileNotFoundException("No path: ".concat(String.valueOf(uri)));
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: ".concat(String.valueOf(uri)));
            }
        } else {
            throw new FileNotFoundException("No authority: ".concat(String.valueOf(uri)));
        }
    }
}
