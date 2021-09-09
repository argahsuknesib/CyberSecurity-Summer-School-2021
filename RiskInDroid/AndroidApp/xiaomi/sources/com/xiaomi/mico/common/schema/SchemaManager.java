package com.xiaomi.mico.common.schema;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.xiaomi.mico.common.schema.handler.DeviceSwitchSchemaHandler;
import com.xiaomi.mico.common.schema.handler.HomepageSchemaHandler;
import com.xiaomi.mico.common.schema.handler.MinaDomainSchemaHandler;
import com.xiaomi.mico.common.schema.handler.NonMicoSchemaHandler;
import com.xiaomi.mico.common.schema.handler.OAuthSchemaHandler;
import com.xiaomi.mico.common.schema.handler.SettingSchemaHandler;
import com.xiaomi.mico.common.schema.handler.ShareSchemaHandler;
import com.xiaomi.mico.common.schema.handler.SkillSchemaHandler;
import com.xiaomi.mico.common.schema.handler.SmartHomeSchemaHandler;
import com.xiaomi.mico.common.schema.handler.StoreSchemaHandler;
import com.xiaomi.mico.common.schema.handler.WebSchemaHandler;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.Iterator;

public class SchemaManager {
    private static SchemaManager sInstance;
    private ArrayList<SchemaHandler> mSchemaHandlers = new ArrayList<>();

    public static synchronized SchemaManager get() {
        SchemaManager schemaManager;
        synchronized (SchemaManager.class) {
            if (sInstance == null) {
                sInstance = new SchemaManager();
            }
            schemaManager = sInstance;
        }
        return schemaManager;
    }

    private SchemaManager() {
        registerHandler(new HomepageSchemaHandler());
        registerHandler(new SmartHomeSchemaHandler());
        registerHandler(new SkillSchemaHandler());
        registerHandler(new SettingSchemaHandler());
        registerHandler(new WebSchemaHandler());
        registerHandler(new StoreSchemaHandler());
        registerHandler(new OAuthSchemaHandler());
        registerHandler(new DeviceSwitchSchemaHandler());
        registerHandler(new MinaDomainSchemaHandler());
        registerHandler(new ShareSchemaHandler());
        registerHandler(new NonMicoSchemaHandler());
    }

    private void registerHandler(SchemaHandler schemaHandler) {
        this.mSchemaHandlers.add(schemaHandler);
    }

    public SchemaHandler queryHandler(Uri uri) {
        Iterator<SchemaHandler> it = this.mSchemaHandlers.iterator();
        while (it.hasNext()) {
            SchemaHandler next = it.next();
            if (next.canHandle(uri)) {
                return next;
            }
        }
        return null;
    }

    public boolean canHandle(String str) {
        Uri parse = !TextUtils.isEmpty(str) ? Uri.parse(str) : null;
        return (parse == null || queryHandler(parse) == null) ? false : true;
    }

    public static void doOnlyHomepageHandleSchema(Context context, String str) {
        Uri uri;
        SchemaHandler schemaHandler;
        if (!TextUtils.isEmpty(str)) {
            uri = Uri.parse(str);
            schemaHandler = get().queryHandler(uri);
        } else {
            uri = null;
            schemaHandler = null;
        }
        if (uri == null) {
            return;
        }
        if (schemaHandler != null && (schemaHandler instanceof HomepageSchemaHandler)) {
            schemaHandler.process(context, uri, null);
        } else if (!"mico".equals(uri.getScheme()) || !"do_nothing".equals(uri.getHost())) {
            Toast.makeText(context, (int) R.string.mico_tool_open_not_support, 0).show();
        }
    }

    public static void handleSchema(Context context, String str) {
        Uri uri;
        SchemaHandler schemaHandler;
        if (!TextUtils.isEmpty(str)) {
            uri = Uri.parse(str);
            schemaHandler = get().queryHandler(uri);
        } else {
            uri = null;
            schemaHandler = null;
        }
        if (uri == null) {
            return;
        }
        if (schemaHandler != null) {
            schemaHandler.process(context, uri, null);
        } else if (!"mico".equals(uri.getScheme()) || !"do_nothing".equals(uri.getHost())) {
            Toast.makeText(context, (int) R.string.mico_tool_open_not_support, 0).show();
        }
    }
}
