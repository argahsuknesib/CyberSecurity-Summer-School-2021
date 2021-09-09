package com.xiaomi.smarthome.framework.plugin.rn.viewmanager;

import _m_j.fyf;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.xiaomi.smarthome.R;
import java.util.Map;

public class MHNavigationBar extends SimpleViewManager {
    private static String REACT_CLASS = "MHNavigationBarAndroid";
    private String mStyle;
    private TextView sub_title_bar_title;
    private SimpleDraweeView title_bar_close;
    private SimpleDraweeView title_bar_more;
    private SimpleDraweeView title_bar_redpoint;
    private SimpleDraweeView title_bar_return;
    private SimpleDraweeView title_bar_share;
    private TextView title_bar_title;
    private View view;

    public String getName() {
        return REACT_CLASS;
    }

    public View createViewInstance(ThemedReactContext themedReactContext) {
        this.view = View.inflate(themedReactContext, R.layout.std_titlebar_rn, null);
        this.title_bar_return = (SimpleDraweeView) this.view.findViewById(R.id.title_bar_return);
        this.title_bar_title = (TextView) this.view.findViewById(R.id.title_bar_title);
        this.sub_title_bar_title = (TextView) this.view.findViewById(R.id.sub_title_bar_title);
        this.title_bar_redpoint = (SimpleDraweeView) this.view.findViewById(R.id.title_bar_redpoint);
        this.title_bar_more = (SimpleDraweeView) this.view.findViewById(R.id.title_bar_more);
        this.title_bar_share = (SimpleDraweeView) this.view.findViewById(R.id.title_bar_share);
        this.title_bar_close = (SimpleDraweeView) this.view.findViewById(R.id.title_bar_close);
        this.title_bar_redpoint.setVisibility(8);
        this.title_bar_share.setVisibility(8);
        this.title_bar_close.setVisibility(8);
        return this.view;
    }

    @ReactProp(name = "colorStyle")
    public void setColorStyle(View view2, String str) {
        this.mStyle = str;
    }

    @ReactProp(name = "title")
    public void setTitle(View view2, String str) {
        this.title_bar_title.setText(str);
    }

    @ReactProp(name = "subTitle")
    public void setSubTitle(View view2, String str) {
        if (TextUtils.isEmpty(str)) {
            this.sub_title_bar_title.setVisibility(8);
            return;
        }
        this.sub_title_bar_title.setVisibility(0);
        this.sub_title_bar_title.setText(str);
    }

    @ReactProp(name = "sourcePoint")
    public void setSourcePoint(View view2, ReadableArray readableArray) {
        if (readableArray != null) {
            setSource(this.title_bar_redpoint, readableArray);
        }
    }

    @ReactProp(name = "sourceLeft")
    public void setSourceLeft(View view2, ReadableArray readableArray) {
        if (readableArray != null) {
            setSource(this.title_bar_return, readableArray);
        }
    }

    @ReactProp(name = "sourceRight")
    public void setSourceRight(View view2, ReadableArray readableArray) {
        if (readableArray != null) {
            setSource(this.title_bar_more, readableArray);
        }
    }

    @ReactProp(name = "sourceRight2")
    public void setSourceRight2(View view2, ReadableArray readableArray) {
        if (readableArray != null) {
            setSource(this.title_bar_share, readableArray);
        }
    }

    @ReactProp(name = "sourceLeft2")
    public void setSourceLeft2(View view2, ReadableArray readableArray) {
        if (readableArray != null) {
            setSource(this.title_bar_close, readableArray);
        }
    }

    @ReactProp(defaultInt = 0, name = "visibilityPoint")
    public void setVisibilityPoint(View view2, int i) {
        if (i == 1) {
            this.title_bar_redpoint.setVisibility(0);
        } else {
            this.title_bar_redpoint.setVisibility(8);
        }
    }

    @ReactProp(defaultInt = 1, name = "visibilityLeft")
    public void setVisibilityLeft(View view2, int i) {
        if (i == 1) {
            this.title_bar_return.setVisibility(0);
        } else {
            this.title_bar_return.setVisibility(8);
        }
    }

    @ReactProp(defaultInt = 1, name = "visibilityRight")
    public void setVisibilityRight(View view2, int i) {
        if (i == 1) {
            this.title_bar_more.setVisibility(0);
        } else {
            this.title_bar_more.setVisibility(8);
        }
    }

    @ReactProp(defaultInt = 0, name = "visibilityRight2")
    public void setVisibilityRight2(View view2, int i) {
        if (i == 1) {
            this.title_bar_share.setVisibility(0);
        } else {
            this.title_bar_share.setVisibility(8);
        }
    }

    @ReactProp(defaultInt = 0, name = "visibilityLeft2")
    public void setVisibilityLeft2(View view2, int i) {
        if (i == 1) {
            this.title_bar_close.setVisibility(0);
        } else {
            this.title_bar_close.setVisibility(8);
        }
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onPressLeft", MapBuilder.of("registrationName", "onPressLeft")).put("onPressLeft2", MapBuilder.of("registrationName", "onPressLeft2")).put("onPressRight", MapBuilder.of("registrationName", "onPressRight")).put("onPressRight2", MapBuilder.of("registrationName", "onPressRight2")).put("onPressTitle", MapBuilder.of("registrationName", "onPressTitle")).build();
    }

    public void addEventEmitters(final ThemedReactContext themedReactContext, final View view2) {
        this.title_bar_return.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MHNavigationBar.AnonymousClass1 */

            public final void onClick(View view) {
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(view2.getId(), "onPressLeft", Arguments.createMap());
            }
        });
        this.title_bar_more.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MHNavigationBar.AnonymousClass2 */

            public final void onClick(View view) {
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(view2.getId(), "onPressRight", Arguments.createMap());
            }
        });
        this.title_bar_share.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MHNavigationBar.AnonymousClass3 */

            public final void onClick(View view) {
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(view2.getId(), "onPressRight2", Arguments.createMap());
            }
        });
        this.title_bar_close.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MHNavigationBar.AnonymousClass4 */

            public final void onClick(View view) {
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(view2.getId(), "onPressLeft2", Arguments.createMap());
            }
        });
        this.title_bar_title.setOnClickListener(new View.OnClickListener() {
            /* class com.xiaomi.smarthome.framework.plugin.rn.viewmanager.MHNavigationBar.AnonymousClass5 */

            public final void onClick(View view) {
                ((RCTEventEmitter) themedReactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(view2.getId(), "onPressTitle", Arguments.createMap());
            }
        });
    }

    public void onAfterUpdateTransaction(View view2) {
        if ("white".equals(this.mStyle)) {
            this.title_bar_title.setTextColor(view2.getContext().getResources().getColor(R.color.mj_color_white_80_transparent));
            this.sub_title_bar_title.setTextColor(view2.getContext().getResources().getColor(R.color.mj_color_white_50_transparent));
            setImageUri(this.title_bar_return, R.drawable.std_tittlebar_main_device_back_white);
            setImageUri(this.title_bar_more, R.drawable.std_tittlebar_main_device_more_white);
            setImageUri(this.title_bar_share, R.drawable.std_tittlebar_main_device_share_white);
            setImageUri(this.title_bar_close, R.drawable.selector_close);
        } else {
            this.title_bar_title.setTextColor(view2.getContext().getResources().getColor(R.color.mj_color_black_80_transparent));
            this.sub_title_bar_title.setTextColor(view2.getContext().getResources().getColor(R.color.mj_color_black_50_transparent));
            setImageUri(this.title_bar_return, R.drawable.std_tittlebar_main_device_back_black);
            setImageUri(this.title_bar_more, R.drawable.std_tittlebar_main_device_more);
            setImageUri(this.title_bar_share, R.drawable.std_tittlebar_main_shop_icon_share);
            setImageUri(this.title_bar_close, R.drawable.selector_close);
        }
        setImageUri(this.title_bar_redpoint, R.drawable.std_tittlebar_main_device_massage_point);
    }

    private void setImageUri(SimpleDraweeView simpleDraweeView, int i) {
        Object tag = simpleDraweeView.getTag();
        if (tag == null || !(tag instanceof String)) {
            simpleDraweeView.setImageResource(i);
        } else {
            simpleDraweeView.setImageURI((String) tag);
        }
    }

    private void setSource(SimpleDraweeView simpleDraweeView, ReadableArray readableArray) {
        String O000000o2 = fyf.O000000o(readableArray);
        if (O000000o2 != null) {
            simpleDraweeView.setTag(O000000o2);
            simpleDraweeView.setAspectRatio(1.0f);
            return;
        }
        simpleDraweeView.setTag(null);
        simpleDraweeView.setController(null);
    }
}
