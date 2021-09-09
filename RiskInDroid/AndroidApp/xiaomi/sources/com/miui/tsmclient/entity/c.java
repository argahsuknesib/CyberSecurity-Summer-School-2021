package com.miui.tsmclient.entity;

import com.google.gson.annotations.SerializedName;
import com.miui.tsmclient.common.data.CommonResponseInfo;
import java.util.Collections;
import java.util.List;

public class c extends CommonResponseInfo {
    @SerializedName("data")

    /* renamed from: a  reason: collision with root package name */
    private List<a> f3860a;

    public static class a {
        @SerializedName("id")

        /* renamed from: a  reason: collision with root package name */
        private int f3861a;
        @SerializedName("imageUrl")
        private String b;
        @SerializedName("valid")
        private boolean c;

        public int a() {
            return this.f3861a;
        }

        public String b() {
            return this.b;
        }

        public boolean c() {
            return this.c;
        }
    }

    public List<a> a() {
        List<a> list = this.f3860a;
        return list == null ? Collections.emptyList() : list;
    }
}
