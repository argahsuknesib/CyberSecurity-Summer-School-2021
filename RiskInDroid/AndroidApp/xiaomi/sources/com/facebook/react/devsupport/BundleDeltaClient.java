package com.facebook.react.devsupport;

import _m_j.jaz;
import android.util.JsonReader;
import android.util.Pair;
import com.facebook.react.bridge.NativeDeltaClient;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import okhttp3.Headers;

public abstract class BundleDeltaClient {
    private String mRevisionId;

    public enum ClientType {
        NONE,
        DEV_SUPPORT,
        NATIVE
    }

    public abstract boolean canHandle(ClientType clientType);

    /* access modifiers changed from: protected */
    public abstract Pair<Boolean, NativeDeltaClient> processDelta(jaz jaz, File file) throws IOException;

    static boolean isDeltaUrl(String str) {
        return str.indexOf(".delta?") != -1;
    }

    /* renamed from: com.facebook.react.devsupport.BundleDeltaClient$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType = new int[ClientType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType[ClientType.DEV_SUPPORT.ordinal()] = 1;
            $SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType[ClientType.NATIVE.ordinal()] = 2;
        }
    }

    static BundleDeltaClient create(ClientType clientType) {
        int i = AnonymousClass1.$SwitchMap$com$facebook$react$devsupport$BundleDeltaClient$ClientType[clientType.ordinal()];
        if (i == 1) {
            return new BundleDeltaJavaClient(null);
        }
        if (i != 2) {
            return null;
        }
        return new BundleDeltaNativeClient(null);
    }

    public final synchronized String extendUrlForDelta(String str) {
        if (this.mRevisionId == null) {
            return str;
        }
        return str + "&revisionId=" + this.mRevisionId;
    }

    public synchronized void reset() {
        this.mRevisionId = null;
    }

    public synchronized Pair<Boolean, NativeDeltaClient> processDelta(Headers headers, jaz jaz, File file) throws IOException {
        this.mRevisionId = headers.get("X-Metro-Delta-ID");
        return processDelta(jaz, file);
    }

    static class BundleDeltaJavaClient extends BundleDeltaClient {
        final TreeMap<Number, byte[]> mModules;
        byte[] mPostCode;
        byte[] mPreCode;

        private BundleDeltaJavaClient() {
            this.mModules = new TreeMap<>();
        }

        /* synthetic */ BundleDeltaJavaClient(AnonymousClass1 r1) {
            this();
        }

        public boolean canHandle(ClientType clientType) {
            return clientType == ClientType.DEV_SUPPORT;
        }

        public synchronized void reset() {
            BundleDeltaClient.super.reset();
            this.mPreCode = null;
            this.mPostCode = null;
            this.mModules.clear();
        }

        /* JADX INFO: finally extract failed */
        public synchronized Pair<Boolean, NativeDeltaClient> processDelta(jaz jaz, File file) throws IOException {
            int removeModules;
            JsonReader jsonReader = new JsonReader(new InputStreamReader(jaz.O00000oO()));
            jsonReader.beginObject();
            int i = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (nextName.equals("pre")) {
                    this.mPreCode = jsonReader.nextString().getBytes();
                } else if (nextName.equals("post")) {
                    this.mPostCode = jsonReader.nextString().getBytes();
                } else {
                    if (nextName.equals("modules")) {
                        removeModules = setModules(jsonReader, this.mModules);
                    } else if (nextName.equals("added")) {
                        removeModules = setModules(jsonReader, this.mModules);
                    } else if (nextName.equals("modified")) {
                        removeModules = setModules(jsonReader, this.mModules);
                    } else if (nextName.equals("deleted")) {
                        removeModules = removeModules(jsonReader, this.mModules);
                    } else {
                        jsonReader.skipValue();
                    }
                    i += removeModules;
                }
            }
            jsonReader.endObject();
            jsonReader.close();
            if (i == 0) {
                return Pair.create(Boolean.FALSE, null);
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(this.mPreCode);
                fileOutputStream.write(10);
                for (byte[] write : this.mModules.values()) {
                    fileOutputStream.write(write);
                    fileOutputStream.write(10);
                }
                fileOutputStream.write(this.mPostCode);
                fileOutputStream.write(10);
                fileOutputStream.flush();
                fileOutputStream.close();
                return Pair.create(Boolean.TRUE, null);
            } catch (Throwable th) {
                fileOutputStream.flush();
                fileOutputStream.close();
                throw th;
            }
        }

        private static int setModules(JsonReader jsonReader, TreeMap<Number, byte[]> treeMap) throws IOException {
            jsonReader.beginArray();
            int i = 0;
            while (jsonReader.hasNext()) {
                jsonReader.beginArray();
                treeMap.put(Integer.valueOf(jsonReader.nextInt()), jsonReader.nextString().getBytes());
                jsonReader.endArray();
                i++;
            }
            jsonReader.endArray();
            return i;
        }

        private static int removeModules(JsonReader jsonReader, TreeMap<Number, byte[]> treeMap) throws IOException {
            jsonReader.beginArray();
            int i = 0;
            while (jsonReader.hasNext()) {
                treeMap.remove(Integer.valueOf(jsonReader.nextInt()));
                i++;
            }
            jsonReader.endArray();
            return i;
        }
    }

    static class BundleDeltaNativeClient extends BundleDeltaClient {
        private final NativeDeltaClient nativeClient;

        private BundleDeltaNativeClient() {
            this.nativeClient = new NativeDeltaClient();
        }

        /* synthetic */ BundleDeltaNativeClient(AnonymousClass1 r1) {
            this();
        }

        public boolean canHandle(ClientType clientType) {
            return clientType == ClientType.NATIVE;
        }

        /* access modifiers changed from: protected */
        public Pair<Boolean, NativeDeltaClient> processDelta(jaz jaz, File file) throws IOException {
            this.nativeClient.processDelta(jaz);
            return Pair.create(Boolean.FALSE, this.nativeClient);
        }

        public void reset() {
            BundleDeltaClient.super.reset();
            this.nativeClient.reset();
        }
    }
}
