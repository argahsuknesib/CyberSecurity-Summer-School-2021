package com.google.android.play.core.splitinstall;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SplitInstallRequest {

    /* renamed from: a  reason: collision with root package name */
    private final List<String> f3792a;
    private final List<Locale> b;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f3793a = new ArrayList();
        /* access modifiers changed from: private */
        public final List<Locale> b = new ArrayList();

        private Builder() {
        }

        /* synthetic */ Builder(byte[] bArr) {
        }

        public Builder addLanguage(Locale locale) {
            this.b.add(locale);
            return this;
        }

        public Builder addModule(String str) {
            this.f3793a.add(str);
            return this;
        }

        public SplitInstallRequest build() {
            return new SplitInstallRequest(this);
        }
    }

    /* synthetic */ SplitInstallRequest(Builder builder) {
        this.f3792a = new ArrayList(builder.f3793a);
        this.b = new ArrayList(builder.b);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public List<Locale> getLanguages() {
        return this.b;
    }

    public List<String> getModuleNames() {
        return this.f3792a;
    }

    public String toString() {
        return String.format("SplitInstallRequest{modulesNames=%s,languages=%s}", this.f3792a, this.b);
    }
}
