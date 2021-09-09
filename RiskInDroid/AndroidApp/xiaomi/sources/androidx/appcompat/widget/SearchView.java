package androidx.appcompat.widget;

import _m_j.OO00O;
import _m_j.Oo;
import _m_j.Oo00000;
import _m_j.cb;
import _m_j.dc;
import _m_j.o00;
import _m_j.o000000;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.customview.view.AbsSavedState;
import com.xiaomi.smarthome.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends LinearLayoutCompat implements OO00O {
    static final O00000o O0000o0o = (Build.VERSION.SDK_INT < 29 ? new O00000o() : null);

    /* renamed from: O000000o  reason: collision with root package name */
    final SearchAutoComplete f2733O000000o;
    final View O00000Oo;
    final ImageView O00000o;
    final ImageView O00000o0;
    final ImageView O00000oO;
    final ImageView O00000oo;
    final View O0000O0o;
    final Intent O0000OOo;
    View.OnFocusChangeListener O0000Oo;
    final Intent O0000Oo0;
    O00000o0 O0000OoO;
    boolean O0000Ooo;
    View.OnKeyListener O0000o;
    SearchableInfo O0000o0;
    dc O0000o00;
    Bundle O0000o0O;
    private final View O0000oO;
    private final View O0000oO0;
    private O0000O0o O0000oOO;
    private Rect O0000oOo;
    private int[] O0000oo;
    private Rect O0000oo0;
    private int[] O0000ooO;
    private final ImageView O0000ooo;
    private final int O000O00o;
    private final CharSequence O000O0OO;
    private O00000Oo O000O0Oo;
    private boolean O000O0o;
    private View.OnClickListener O000O0o0;
    private boolean O000O0oO;
    private CharSequence O000O0oo;
    private int O000OO;
    private boolean O000OO00;
    private boolean O000OO0o;
    private boolean O000OOOo;
    private CharSequence O000OOo;
    private CharSequence O000OOo0;
    private boolean O000OOoO;
    private int O000OOoo;
    private Runnable O000Oo0;
    private final Runnable O000Oo00;
    private final WeakHashMap<String, Drawable.ConstantState> O000Oo0O;
    private final View.OnClickListener O000Oo0o;
    private final AdapterView.OnItemSelectedListener O000OoO;
    private final TextView.OnEditorActionListener O000OoO0;
    private TextWatcher O000OoOO;
    private final AdapterView.OnItemClickListener O00O0Oo;
    private O000000o O00oOoOo;
    private final Drawable O00oOooO;
    private final int O00oOooo;

    public interface O000000o {
        boolean O000000o();
    }

    public interface O00000Oo {
        boolean O000000o();
    }

    public interface O00000o0 {
        boolean O000000o();

        boolean O00000Oo();
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, androidx.appcompat.widget.SearchView, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.Oo.O000000o(int, boolean):boolean
     arg types: [int, int]
     candidates:
      _m_j.Oo.O000000o(int, int):int
      _m_j.Oo.O000000o(int, boolean):boolean */
    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O0000oOo = new Rect();
        this.O0000oo0 = new Rect();
        this.O0000oo = new int[2];
        this.O0000ooO = new int[2];
        this.O000Oo00 = new Runnable() {
            /* class androidx.appcompat.widget.SearchView.AnonymousClass1 */

            public final void run() {
                SearchView.this.O00000o0();
            }
        };
        this.O000Oo0 = new Runnable() {
            /* class androidx.appcompat.widget.SearchView.AnonymousClass3 */

            public final void run() {
                if (SearchView.this.O0000o00 instanceof Oo00000) {
                    SearchView.this.O0000o00.O000000o((Cursor) null);
                }
            }
        };
        this.O000Oo0O = new WeakHashMap<>();
        this.O000Oo0o = new View.OnClickListener() {
            /* class androidx.appcompat.widget.SearchView.AnonymousClass6 */

            public final void onClick(View view) {
                if (view == SearchView.this.O00000o0) {
                    SearchView.this.O00000oo();
                } else if (view == SearchView.this.O00000oO) {
                    SearchView.this.O00000oO();
                } else if (view == SearchView.this.O00000o) {
                    SearchView.this.O00000o();
                } else if (view == SearchView.this.O00000oo) {
                    SearchView searchView = SearchView.this;
                    if (searchView.O0000o0 != null) {
                        SearchableInfo searchableInfo = searchView.O0000o0;
                        try {
                            String str = null;
                            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                                Intent intent = new Intent(searchView.O0000OOo);
                                ComponentName searchActivity = searchableInfo.getSearchActivity();
                                if (searchActivity != null) {
                                    str = searchActivity.flattenToShortString();
                                }
                                intent.putExtra("calling_package", str);
                                searchView.getContext().startActivity(intent);
                            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                                Intent intent2 = searchView.O0000Oo0;
                                ComponentName searchActivity2 = searchableInfo.getSearchActivity();
                                Intent intent3 = new Intent("android.intent.action.SEARCH");
                                intent3.setComponent(searchActivity2);
                                PendingIntent activity = PendingIntent.getActivity(searchView.getContext(), 0, intent3, 1073741824);
                                Bundle bundle = new Bundle();
                                if (searchView.O0000o0O != null) {
                                    bundle.putParcelable("app_data", searchView.O0000o0O);
                                }
                                Intent intent4 = new Intent(intent2);
                                String str2 = "free_form";
                                int i = 1;
                                Resources resources = searchView.getResources();
                                if (searchableInfo.getVoiceLanguageModeId() != 0) {
                                    str2 = resources.getString(searchableInfo.getVoiceLanguageModeId());
                                }
                                String string = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
                                String string2 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
                                if (searchableInfo.getVoiceMaxResults() != 0) {
                                    i = searchableInfo.getVoiceMaxResults();
                                }
                                intent4.putExtra("android.speech.extra.LANGUAGE_MODEL", str2);
                                intent4.putExtra("android.speech.extra.PROMPT", string);
                                intent4.putExtra("android.speech.extra.LANGUAGE", string2);
                                intent4.putExtra("android.speech.extra.MAX_RESULTS", i);
                                if (searchActivity2 != null) {
                                    str = searchActivity2.flattenToShortString();
                                }
                                intent4.putExtra("calling_package", str);
                                intent4.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
                                intent4.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
                                searchView.getContext().startActivity(intent4);
                            }
                        } catch (ActivityNotFoundException unused) {
                            Log.w("SearchView", "Could not find voice search activity");
                        }
                    }
                } else if (view == SearchView.this.f2733O000000o) {
                    SearchView.this.O0000OOo();
                }
            }
        };
        this.O0000o = new View.OnKeyListener() {
            /* class androidx.appcompat.widget.SearchView.AnonymousClass7 */

            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (SearchView.this.O0000o0 == null) {
                    return false;
                }
                if (SearchView.this.f2733O000000o.isPopupShowing() && SearchView.this.f2733O000000o.getListSelection() != -1) {
                    SearchView searchView = SearchView.this;
                    if (searchView.O0000o0 != null && searchView.O0000o00 != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
                        if (i == 66 || i == 84 || i == 61) {
                            return searchView.O000000o(searchView.f2733O000000o.getListSelection());
                        }
                        if (i == 21 || i == 22) {
                            searchView.f2733O000000o.setSelection(i == 21 ? 0 : searchView.f2733O000000o.length());
                            searchView.f2733O000000o.setListSelection(0);
                            searchView.f2733O000000o.clearListSelection();
                            searchView.f2733O000000o.ensureImeVisible();
                            return true;
                        } else if (i == 19) {
                            searchView.f2733O000000o.getListSelection();
                        }
                    }
                    return false;
                } else if (SearchView.this.f2733O000000o.isEmpty() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
                    return false;
                } else {
                    view.cancelLongPress();
                    SearchView searchView2 = SearchView.this;
                    searchView2.O000000o(searchView2.f2733O000000o.getText().toString());
                    return true;
                }
            }
        };
        this.O000OoO0 = new TextView.OnEditorActionListener() {
            /* class androidx.appcompat.widget.SearchView.AnonymousClass8 */

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                SearchView.this.O00000o();
                return true;
            }
        };
        this.O00O0Oo = new AdapterView.OnItemClickListener() {
            /* class androidx.appcompat.widget.SearchView.AnonymousClass9 */

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView.this.O000000o(i);
            }
        };
        this.O000OoO = new AdapterView.OnItemSelectedListener() {
            /* class androidx.appcompat.widget.SearchView.AnonymousClass10 */

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                SearchView searchView = SearchView.this;
                if (searchView.O0000OoO == null || !searchView.O0000OoO.O000000o()) {
                    Editable text = searchView.f2733O000000o.getText();
                    Cursor O000000o2 = searchView.O0000o00.O000000o();
                    if (O000000o2 == null) {
                        return;
                    }
                    if (O000000o2.moveToPosition(i)) {
                        CharSequence O00000Oo = searchView.O0000o00.O00000Oo(O000000o2);
                        if (O00000Oo != null) {
                            searchView.setQuery(O00000Oo);
                        } else {
                            searchView.setQuery(text);
                        }
                    } else {
                        searchView.setQuery(text);
                    }
                }
            }
        };
        this.O000OoOO = new TextWatcher() {
            /* class androidx.appcompat.widget.SearchView.AnonymousClass2 */

            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                SearchView.this.O000000o(charSequence);
            }
        };
        Oo O000000o2 = Oo.O000000o(context, attributeSet, new int[]{16842970, 16843039, 16843296, 16843364, R.attr.closeIcon, R.attr.commitIcon, R.attr.defaultQueryHint, R.attr.goIcon, R.attr.iconifiedByDefault, R.attr.layout, R.attr.queryBackground, R.attr.queryHint, R.attr.searchHintIcon, R.attr.searchIcon, R.attr.submitBackground, R.attr.suggestionRowLayout, R.attr.voiceIcon}, i, 0);
        LayoutInflater.from(context).inflate(O000000o2.O0000O0o(9, R.layout.abc_search_view), (ViewGroup) this, true);
        this.f2733O000000o = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f2733O000000o.setSearchView(this);
        this.O0000oO0 = findViewById(R.id.search_edit_frame);
        this.O00000Oo = findViewById(R.id.search_plate);
        this.O0000oO = findViewById(R.id.submit_area);
        this.O00000o0 = (ImageView) findViewById(R.id.search_button);
        this.O00000o = (ImageView) findViewById(R.id.search_go_btn);
        this.O00000oO = (ImageView) findViewById(R.id.search_close_btn);
        this.O00000oo = (ImageView) findViewById(R.id.search_voice_btn);
        this.O0000ooo = (ImageView) findViewById(R.id.search_mag_icon);
        cb.O000000o(this.O00000Oo, O000000o2.O000000o(10));
        cb.O000000o(this.O0000oO, O000000o2.O000000o(14));
        this.O00000o0.setImageDrawable(O000000o2.O000000o(13));
        this.O00000o.setImageDrawable(O000000o2.O000000o(7));
        this.O00000oO.setImageDrawable(O000000o2.O000000o(4));
        this.O00000oo.setImageDrawable(O000000o2.O000000o(16));
        this.O0000ooo.setImageDrawable(O000000o2.O000000o(13));
        this.O00oOooO = O000000o2.O000000o(12);
        o000000.O000000o(this.O00000o0, getResources().getString(R.string.abc_searchview_description_search));
        this.O00oOooo = O000000o2.O0000O0o(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.O000O00o = O000000o2.O0000O0o(5, 0);
        this.O00000o0.setOnClickListener(this.O000Oo0o);
        this.O00000oO.setOnClickListener(this.O000Oo0o);
        this.O00000o.setOnClickListener(this.O000Oo0o);
        this.O00000oo.setOnClickListener(this.O000Oo0o);
        this.f2733O000000o.setOnClickListener(this.O000Oo0o);
        this.f2733O000000o.addTextChangedListener(this.O000OoOO);
        this.f2733O000000o.setOnEditorActionListener(this.O000OoO0);
        this.f2733O000000o.setOnItemClickListener(this.O00O0Oo);
        this.f2733O000000o.setOnItemSelectedListener(this.O000OoO);
        this.f2733O000000o.setOnKeyListener(this.O0000o);
        this.f2733O000000o.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            /* class androidx.appcompat.widget.SearchView.AnonymousClass4 */

            public final void onFocusChange(View view, boolean z) {
                if (SearchView.this.O0000Oo != null) {
                    SearchView.this.O0000Oo.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(O000000o2.O000000o(8, true));
        int O00000oO2 = O000000o2.O00000oO(1, -1);
        if (O00000oO2 != -1) {
            setMaxWidth(O00000oO2);
        }
        this.O000O0OO = O000000o2.O00000o0(6);
        this.O000O0oo = O000000o2.O00000o0(11);
        int O000000o3 = O000000o2.O000000o(3, -1);
        if (O000000o3 != -1) {
            setImeOptions(O000000o3);
        }
        int O000000o4 = O000000o2.O000000o(2, -1);
        if (O000000o4 != -1) {
            setInputType(O000000o4);
        }
        setFocusable(O000000o2.O000000o(0, true));
        O000000o2.f12340O000000o.recycle();
        this.O0000OOo = new Intent("android.speech.action.WEB_SEARCH");
        this.O0000OOo.addFlags(268435456);
        this.O0000OOo.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.O0000Oo0 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.O0000Oo0.addFlags(268435456);
        this.O0000O0o = findViewById(this.f2733O000000o.getDropDownAnchor());
        View view = this.O0000O0o;
        if (view != null) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                /* class androidx.appcompat.widget.SearchView.AnonymousClass5 */

                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int i9;
                    SearchView searchView = SearchView.this;
                    if (searchView.O0000O0o.getWidth() > 1) {
                        Resources resources = searchView.getContext().getResources();
                        int paddingLeft = searchView.O00000Oo.getPaddingLeft();
                        Rect rect = new Rect();
                        boolean O000000o2 = o00.O000000o(searchView);
                        int dimensionPixelSize = searchView.O0000Ooo ? resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(R.dimen.abc_dropdownitem_text_padding_left) : 0;
                        searchView.f2733O000000o.getDropDownBackground().getPadding(rect);
                        if (O000000o2) {
                            i9 = -rect.left;
                        } else {
                            i9 = paddingLeft - (rect.left + dimensionPixelSize);
                        }
                        searchView.f2733O000000o.setDropDownHorizontalOffset(i9);
                        searchView.f2733O000000o.setDropDownWidth((((searchView.O0000O0o.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
                    }
                }
            });
        }
        O000000o(this.O0000Ooo);
        O0000o00();
    }

    public int getSuggestionRowLayout() {
        return this.O00oOooo;
    }

    public int getSuggestionCommitIconResId() {
        return this.O000O00o;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.O0000o0 = searchableInfo;
        SearchableInfo searchableInfo2 = this.O0000o0;
        Intent intent = null;
        if (searchableInfo2 != null) {
            this.f2733O000000o.setThreshold(searchableInfo2.getSuggestThreshold());
            this.f2733O000000o.setImeOptions(this.O0000o0.getImeOptions());
            int inputType = this.O0000o0.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.O0000o0.getSuggestAuthority() != null) {
                    inputType = inputType | 65536 | 524288;
                }
            }
            this.f2733O000000o.setInputType(inputType);
            dc dcVar = this.O0000o00;
            if (dcVar != null) {
                dcVar.O000000o((Cursor) null);
            }
            if (this.O0000o0.getSuggestAuthority() != null) {
                this.O0000o00 = new Oo00000(getContext(), this, this.O0000o0, this.O000Oo0O);
                this.f2733O000000o.setAdapter(this.O0000o00);
                ((Oo00000) this.O0000o00).f12344O000000o = this.O000OO00 ? 2 : 1;
            }
            O0000o00();
        }
        SearchableInfo searchableInfo3 = this.O0000o0;
        boolean z = false;
        if (searchableInfo3 != null && searchableInfo3.getVoiceSearchEnabled()) {
            if (this.O0000o0.getVoiceSearchLaunchWebSearch()) {
                intent = this.O0000OOo;
            } else if (this.O0000o0.getVoiceSearchLaunchRecognizer()) {
                intent = this.O0000Oo0;
            }
            if (!(intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null)) {
                z = true;
            }
        }
        this.O000OOOo = z;
        if (this.O000OOOo) {
            this.f2733O000000o.setPrivateImeOptions("nm");
        }
        O000000o(this.O000O0o);
    }

    public void setAppSearchData(Bundle bundle) {
        this.O0000o0O = bundle;
    }

    public void setImeOptions(int i) {
        this.f2733O000000o.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.f2733O000000o.getImeOptions();
    }

    public void setInputType(int i) {
        this.f2733O000000o.setInputType(i);
    }

    public int getInputType() {
        return this.f2733O000000o.getInputType();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.O000OO0o || !isFocusable()) {
            return false;
        }
        if (this.O000O0o) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f2733O000000o.requestFocus(i, rect);
        if (requestFocus) {
            O000000o(false);
        }
        return requestFocus;
    }

    public void clearFocus() {
        this.O000OO0o = true;
        super.clearFocus();
        this.f2733O000000o.clearFocus();
        this.f2733O000000o.setImeVisibility(false);
        this.O000OO0o = false;
    }

    public void setOnQueryTextListener(O00000Oo o00000Oo) {
        this.O000O0Oo = o00000Oo;
    }

    public void setOnCloseListener(O000000o o000000o) {
        this.O00oOoOo = o000000o;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.O0000Oo = onFocusChangeListener;
    }

    public void setOnSuggestionListener(O00000o0 o00000o0) {
        this.O0000OoO = o00000o0;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.O000O0o0 = onClickListener;
    }

    public CharSequence getQuery() {
        return this.f2733O000000o.getText();
    }

    public void setQueryHint(CharSequence charSequence) {
        this.O000O0oo = charSequence;
        O0000o00();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.O000O0oo;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.O0000o0;
        if (searchableInfo == null || searchableInfo.getHintId() == 0) {
            return this.O000O0OO;
        }
        return getContext().getText(this.O0000o0.getHintId());
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.O0000Ooo != z) {
            this.O0000Ooo = z;
            O000000o(z);
            O0000o00();
        }
    }

    public void setIconified(boolean z) {
        if (z) {
            O00000oO();
        } else {
            O00000oo();
        }
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.O000O0oO = z;
        O000000o(this.O000O0o);
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.O000OO00 = z;
        dc dcVar = this.O0000o00;
        if (dcVar instanceof Oo00000) {
            ((Oo00000) dcVar).f12344O000000o = z ? 2 : 1;
        }
    }

    public void setSuggestionsAdapter(dc dcVar) {
        this.O0000o00 = dcVar;
        this.f2733O000000o.setAdapter(this.O0000o00);
    }

    public dc getSuggestionsAdapter() {
        return this.O0000o00;
    }

    public void setMaxWidth(int i) {
        this.O000OO = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.O000OO;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            SearchAutoComplete searchAutoComplete = this.f2733O000000o;
            Rect rect = this.O0000oOo;
            searchAutoComplete.getLocationInWindow(this.O0000oo);
            getLocationInWindow(this.O0000ooO);
            int[] iArr = this.O0000oo;
            int i5 = iArr[1];
            int[] iArr2 = this.O0000ooO;
            int i6 = i5 - iArr2[1];
            int i7 = iArr[0] - iArr2[0];
            rect.set(i7, i6, searchAutoComplete.getWidth() + i7, searchAutoComplete.getHeight() + i6);
            this.O0000oo0.set(this.O0000oOo.left, 0, this.O0000oOo.right, i4 - i2);
            O0000O0o o0000O0o = this.O0000oOO;
            if (o0000O0o == null) {
                this.O0000oOO = new O0000O0o(this.O0000oo0, this.O0000oOo, this.f2733O000000o);
                setTouchDelegate(this.O0000oOO);
                return;
            }
            o0000O0o.O000000o(this.O0000oo0, this.O0000oOo);
        }
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private void O000000o(boolean z) {
        this.O000O0o = z;
        int i = 8;
        boolean z2 = false;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f2733O000000o.getText());
        this.O00000o0.setVisibility(i2);
        O00000Oo(z3);
        this.O0000oO0.setVisibility(z ? 8 : 0);
        if (this.O0000ooo.getDrawable() != null && !this.O0000Ooo) {
            i = 0;
        }
        this.O0000ooo.setVisibility(i);
        O0000OoO();
        if (!z3) {
            z2 = true;
        }
        O00000o0(z2);
        O0000Oo();
    }

    private boolean O0000Oo0() {
        return (this.O000O0oO || this.O000OOOo) && !this.O000O0o;
    }

    private void O00000Oo(boolean z) {
        this.O00000o.setVisibility((!this.O000O0oO || !O0000Oo0() || !hasFocus() || (!z && this.O000OOOo)) ? 8 : 0);
    }

    private void O0000Oo() {
        this.O0000oO.setVisibility((!O0000Oo0() || !(this.O00000o.getVisibility() == 0 || this.O00000oo.getVisibility() == 0)) ? 8 : 0);
    }

    private void O0000OoO() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f2733O000000o.getText());
        int i = 0;
        if (!z2 && (!this.O0000Ooo || this.O000OOoO)) {
            z = false;
        }
        ImageView imageView = this.O00000oO;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        Drawable drawable = this.O00000oO.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void O0000Ooo() {
        post(this.O000Oo00);
    }

    /* access modifiers changed from: package-private */
    public final void O00000o0() {
        int[] iArr = this.f2733O000000o.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.O00000Oo.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.O0000oO.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        removeCallbacks(this.O000Oo00);
        post(this.O000Oo0);
        super.onDetachedFromWindow();
    }

    private CharSequence O00000Oo(CharSequence charSequence) {
        if (!this.O0000Ooo || this.O00oOooO == null) {
            return charSequence;
        }
        double textSize = (double) this.f2733O000000o.getTextSize();
        Double.isNaN(textSize);
        int i = (int) (textSize * 1.25d);
        this.O00oOooO.setBounds(0, 0, i, i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.O00oOooO), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void O0000o00() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f2733O000000o;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(O00000Oo(queryHint));
    }

    private void O00000o0(boolean z) {
        int i;
        if (!this.O000OOOo || this.O000O0o || !z) {
            i = 8;
        } else {
            i = 0;
            this.O00000o.setVisibility(8);
        }
        this.O00000oo.setVisibility(i);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(CharSequence charSequence) {
        Editable text = this.f2733O000000o.getText();
        this.O000OOo = text;
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(text);
        O00000Oo(z2);
        if (z2) {
            z = false;
        }
        O00000o0(z);
        O0000OoO();
        O0000Oo();
        if (this.O000O0Oo != null && !TextUtils.equals(charSequence, this.O000OOo0)) {
            charSequence.toString();
        }
        this.O000OOo0 = charSequence.toString();
    }

    /* access modifiers changed from: package-private */
    public final void O00000o() {
        Editable text = this.f2733O000000o.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            O00000Oo o00000Oo = this.O000O0Oo;
            if (o00000Oo != null) {
                text.toString();
                if (o00000Oo.O000000o()) {
                    return;
                }
            }
            if (this.O0000o0 != null) {
                O000000o(text.toString());
            }
            this.f2733O000000o.setImeVisibility(false);
            this.f2733O000000o.dismissDropDown();
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oO() {
        if (!TextUtils.isEmpty(this.f2733O000000o.getText())) {
            this.f2733O000000o.setText("");
            this.f2733O000000o.requestFocus();
            this.f2733O000000o.setImeVisibility(true);
        } else if (this.O0000Ooo) {
            O000000o o000000o = this.O00oOoOo;
            if (o000000o == null || !o000000o.O000000o()) {
                clearFocus();
                O000000o(true);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void O00000oo() {
        O000000o(false);
        this.f2733O000000o.requestFocus();
        this.f2733O000000o.setImeVisibility(true);
        View.OnClickListener onClickListener = this.O000O0o0;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        O0000Ooo();
    }

    public final void O000000o() {
        if (!this.O000OOoO) {
            this.O000OOoO = true;
            this.O000OOoo = this.f2733O000000o.getImeOptions();
            this.f2733O000000o.setImeOptions(this.O000OOoo | 33554432);
            this.f2733O000000o.setText("");
            setIconified(false);
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* class androidx.appcompat.widget.SearchView.SavedState.AnonymousClass1 */

            public final /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SavedState[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        };

        /* renamed from: O000000o  reason: collision with root package name */
        boolean f2746O000000o;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2746O000000o = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f2746O000000o));
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f2746O000000o + "}";
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2746O000000o = this.O000O0o;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        O000000o(savedState.f2746O000000o);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(int i) {
        O00000o0 o00000o0 = this.O0000OoO;
        if (o00000o0 != null && o00000o0.O00000Oo()) {
            return false;
        }
        Cursor O000000o2 = this.O0000o00.O000000o();
        if (O000000o2 != null && O000000o2.moveToPosition(i)) {
            O000000o(O000000o(O000000o2, 0, null));
        }
        this.f2733O000000o.setImeVisibility(false);
        this.f2733O000000o.dismissDropDown();
        return true;
    }

    private void O000000o(Intent intent) {
        if (intent != null) {
            try {
                getContext().startActivity(intent);
            } catch (RuntimeException e) {
                Log.e("SearchView", "Failed launch activity: ".concat(String.valueOf(intent)), e);
            }
        }
    }

    public void setQuery(CharSequence charSequence) {
        this.f2733O000000o.setText(charSequence);
        this.f2733O000000o.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(String str) {
        getContext().startActivity(O000000o("android.intent.action.SEARCH", null, null, str, 0, null));
    }

    private Intent O000000o(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.O000OOo);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.O0000o0O;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.O0000o0.getSearchActivity());
        return intent;
    }

    private Intent O000000o(Cursor cursor, int i, String str) {
        int i2;
        Uri uri;
        String O000000o2;
        try {
            String O000000o3 = Oo00000.O000000o(cursor, "suggest_intent_action");
            if (O000000o3 == null) {
                O000000o3 = this.O0000o0.getSuggestIntentAction();
            }
            if (O000000o3 == null) {
                O000000o3 = "android.intent.action.SEARCH";
            }
            String str2 = O000000o3;
            String O000000o4 = Oo00000.O000000o(cursor, "suggest_intent_data");
            if (O000000o4 == null) {
                O000000o4 = this.O0000o0.getSuggestIntentData();
            }
            if (!(O000000o4 == null || (O000000o2 = Oo00000.O000000o(cursor, "suggest_intent_data_id")) == null)) {
                O000000o4 = O000000o4 + "/" + Uri.encode(O000000o2);
            }
            if (O000000o4 == null) {
                uri = null;
            } else {
                uri = Uri.parse(O000000o4);
            }
            return O000000o(str2, uri, Oo00000.O000000o(cursor, "suggest_intent_extra_data"), Oo00000.O000000o(cursor, "suggest_intent_query"), 0, null);
        } catch (RuntimeException e) {
            try {
                i2 = cursor.getPosition();
            } catch (RuntimeException unused) {
                i2 = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + i2 + " returned exception.", e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void O0000OOo() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f2733O000000o.refreshAutoCompleteResults();
            return;
        }
        O0000o0o.O000000o(this.f2733O000000o);
        O0000o0o.O00000Oo(this.f2733O000000o);
    }

    static boolean O000000o(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    static class O0000O0o extends TouchDelegate {

        /* renamed from: O000000o  reason: collision with root package name */
        private final View f2745O000000o;
        private final Rect O00000Oo = new Rect();
        private final Rect O00000o = new Rect();
        private final Rect O00000o0 = new Rect();
        private final int O00000oO;
        private boolean O00000oo;

        public O0000O0o(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.O00000oO = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            O000000o(rect, rect2);
            this.f2745O000000o = view;
        }

        public final void O000000o(Rect rect, Rect rect2) {
            this.O00000Oo.set(rect);
            this.O00000o.set(rect);
            Rect rect3 = this.O00000o;
            int i = this.O00000oO;
            rect3.inset(-i, -i);
            this.O00000o0.set(rect2);
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z2 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z = this.O00000oo;
                    if (z && !this.O00000o.contains(x, y)) {
                        z2 = false;
                    }
                    if (z) {
                        return false;
                    }
                    if (!z2 || this.O00000o0.contains(x, y)) {
                        motionEvent.setLocation((float) (x - this.O00000o0.left), (float) (y - this.O00000o0.top));
                    } else {
                        motionEvent.setLocation((float) (this.f2745O000000o.getWidth() / 2), (float) (this.f2745O000000o.getHeight() / 2));
                    }
                    return this.f2745O000000o.dispatchTouchEvent(motionEvent);
                } else if (action == 3) {
                    z = this.O00000oo;
                    this.O00000oo = false;
                    if (z) {
                    }
                }
            } else if (this.O00000Oo.contains(x, y)) {
                this.O00000oo = true;
                z = true;
                if (z) {
                }
            }
            z = false;
            if (z) {
            }
        }
    }

    public static class SearchAutoComplete extends AppCompatAutoCompleteTextView {
        private boolean mHasPendingShowSoftInputRequest;
        final Runnable mRunShowSoftInputIfNecessary;
        private SearchView mSearchView;
        private int mThreshold;

        public void performCompletion() {
        }

        /* access modifiers changed from: protected */
        public void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.mRunShowSoftInputIfNecessary = new Runnable() {
                /* class androidx.appcompat.widget.SearchView.SearchAutoComplete.AnonymousClass1 */

                public final void run() {
                    SearchAutoComplete.this.showSoftInputIfNecessary();
                }
            };
            this.mThreshold = getThreshold();
        }

        /* access modifiers changed from: protected */
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        /* access modifiers changed from: package-private */
        public void setSearchView(SearchView searchView) {
            this.mSearchView = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.mThreshold = i;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.mSearchView.hasFocus() && getVisibility() == 0) {
                this.mHasPendingShowSoftInputRequest = true;
                if (SearchView.O000000o(getContext())) {
                    ensureImeVisible();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.mSearchView.O0000O0o();
        }

        public boolean enoughToFilter() {
            return this.mThreshold <= 0 || super.enoughToFilter();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.mSearchView.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.mHasPendingShowSoftInputRequest) {
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                post(this.mRunShowSoftInputIfNecessary);
            }
            return onCreateInputConnection;
        }

        /* access modifiers changed from: package-private */
        public void showSoftInputIfNecessary() {
            if (this.mHasPendingShowSoftInputRequest) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.mHasPendingShowSoftInputRequest = false;
            }
        }

        /* access modifiers changed from: package-private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.mHasPendingShowSoftInputRequest = false;
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else if (inputMethodManager.isActive(this)) {
                this.mHasPendingShowSoftInputRequest = false;
                removeCallbacks(this.mRunShowSoftInputIfNecessary);
                inputMethodManager.showSoftInput(this, 0);
            } else {
                this.mHasPendingShowSoftInputRequest = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void ensureImeVisible() {
            if (Build.VERSION.SDK_INT >= 29) {
                setInputMethodMode(1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            O00000o o00000o = SearchView.O0000o0o;
            O00000o.O000000o();
            if (o00000o.f2744O000000o != null) {
                try {
                    o00000o.f2744O000000o.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        Method f2744O000000o = null;
        private Method O00000Oo = null;
        private Method O00000o0 = null;

        @SuppressLint({"DiscouragedPrivateApi", "SoonBlockedPrivateApi"})
        O00000o() {
            O000000o();
            try {
                this.O00000Oo = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.O00000Oo.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.O00000o0 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.O00000o0.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            Class<AutoCompleteTextView> cls = AutoCompleteTextView.class;
            try {
                this.f2744O000000o = cls.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f2744O000000o.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(AutoCompleteTextView autoCompleteTextView) {
            O000000o();
            Method method = this.O00000Oo;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo(AutoCompleteTextView autoCompleteTextView) {
            O000000o();
            Method method = this.O00000o0;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        static void O000000o() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        if (this.O000O0o) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.O000OO;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.O000OO;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.O000OO) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    /* access modifiers changed from: package-private */
    public final void O0000O0o() {
        O000000o(this.O000O0o);
        O0000Ooo();
        if (this.f2733O000000o.hasFocus()) {
            O0000OOo();
        }
    }

    public final void O00000Oo() {
        this.f2733O000000o.setText("");
        SearchAutoComplete searchAutoComplete = this.f2733O000000o;
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.O000OOo = "";
        clearFocus();
        O000000o(true);
        this.f2733O000000o.setImeOptions(this.O000OOoo);
        this.O000OOoO = false;
    }
}
