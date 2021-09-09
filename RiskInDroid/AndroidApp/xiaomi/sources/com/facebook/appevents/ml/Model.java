package com.facebook.appevents.ml;

import android.os.AsyncTask;
import android.support.v4.app.NotificationCompat;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Model {
    private static final List<String> SUGGESTED_EVENTS_PREDICTION = Arrays.asList("fb_mobile_add_to_cart", "fb_mobile_complete_registration", "other", AppEventsConstants.EVENT_NAME_PURCHASED);
    private static final Map<String, String> WEIGHTS_KEY_MAPPING = new HashMap<String, String>() {
        /* class com.facebook.appevents.ml.Model.AnonymousClass1 */

        {
            put("embedding.weight", "embed.weight");
            put("dense1.weight", "fc1.weight");
            put("dense2.weight", "fc2.weight");
            put("dense3.weight", "fc3.weight");
            put("dense1.bias", "fc1.bias");
            put("dense2.bias", "fc2.bias");
            put("dense3.bias", "fc3.bias");
        }
    };
    private Weight convs_1_bias;
    private Weight convs_1_weight;
    private Weight convs_2_bias;
    private Weight convs_2_weight;
    private Weight convs_3_bias;
    private Weight convs_3_weight;
    private File dir = new File(FacebookSdk.getApplicationContext().getFilesDir(), "facebook_ml/");
    private Weight embedding;
    private Weight fc1_bias;
    private Weight fc1_weight;
    private Weight fc2_bias;
    private Weight fc2_weight;
    private Weight fc3_bias;
    private Weight fc3_weight;
    private File modelFile;
    private String modelUri;
    private File ruleFile;
    private String ruleUri;
    private float[] thresholds;
    private String useCase;
    private int versionID;

    Model(String str, int i, String str2, String str3, float[] fArr) {
        this.useCase = str;
        this.versionID = i;
        this.thresholds = fArr;
        this.modelUri = str2;
        this.ruleUri = str3;
        if (!this.dir.exists()) {
            this.dir.mkdirs();
        }
        File file = this.dir;
        this.modelFile = new File(file, str + "_" + i);
        File file2 = this.dir;
        this.ruleFile = new File(file2, str + "_" + i + "_rule");
    }

    /* access modifiers changed from: package-private */
    public final void initialize(final Runnable runnable) {
        downloadModel(new Runnable() {
            /* class com.facebook.appevents.ml.Model.AnonymousClass2 */

            public void run() {
                if (Model.this.initializeWeights()) {
                    Model.this.downloadRule(runnable);
                }
            }
        });
        deleteOldFiles();
    }

    private void deleteOldFiles() {
        File[] listFiles = this.dir.listFiles();
        if (listFiles != null && listFiles.length != 0) {
            String str = this.useCase + "_" + this.versionID;
            for (File file : listFiles) {
                String name = file.getName();
                if (name.startsWith(this.useCase) && !name.startsWith(str)) {
                    file.delete();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final File getRuleFile() {
        return this.ruleFile;
    }

    private void downloadModel(Runnable runnable) {
        if (this.modelFile.exists()) {
            runnable.run();
            return;
        }
        String str = this.modelUri;
        if (str != null) {
            new FileDownloadTask(str, this.modelFile, runnable).execute(new String[0]);
        }
    }

    public final void downloadRule(Runnable runnable) {
        String str;
        if (this.ruleFile.exists() || (str = this.ruleUri) == null) {
            runnable.run();
        } else {
            new FileDownloadTask(str, this.ruleFile, runnable).execute(new String[0]);
        }
    }

    public final boolean initializeWeights() {
        try {
            FileInputStream fileInputStream = new FileInputStream(this.modelFile);
            int available = fileInputStream.available();
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            byte[] bArr = new byte[available];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            if (available < 4) {
                return false;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, 4);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int i = wrap.getInt();
            int i2 = i + 4;
            if (available < i2) {
                return false;
            }
            JSONObject jSONObject = new JSONObject(new String(bArr, 4, i));
            JSONArray names = jSONObject.names();
            String[] strArr = new String[names.length()];
            for (int i3 = 0; i3 < strArr.length; i3++) {
                strArr[i3] = names.getString(i3);
            }
            Arrays.sort(strArr);
            HashMap hashMap = new HashMap();
            int length = strArr.length;
            int i4 = i2;
            int i5 = 0;
            while (i5 < length) {
                String str = strArr[i5];
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int[] iArr = new int[jSONArray.length()];
                int i6 = 1;
                for (int i7 = 0; i7 < iArr.length; i7++) {
                    iArr[i7] = jSONArray.getInt(i7);
                    i6 *= iArr[i7];
                }
                int i8 = i6 * 4;
                int i9 = i4 + i8;
                if (i9 > available) {
                    return false;
                }
                ByteBuffer wrap2 = ByteBuffer.wrap(bArr, i4, i8);
                wrap2.order(ByteOrder.LITTLE_ENDIAN);
                float[] fArr = new float[i6];
                wrap2.asFloatBuffer().get(fArr, 0, i6);
                if (WEIGHTS_KEY_MAPPING.containsKey(str)) {
                    str = WEIGHTS_KEY_MAPPING.get(str);
                }
                hashMap.put(str, new Weight(iArr, fArr));
                i5++;
                i4 = i9;
            }
            this.embedding = (Weight) hashMap.get("embed.weight");
            this.convs_1_weight = (Weight) hashMap.get("convs.0.weight");
            this.convs_2_weight = (Weight) hashMap.get("convs.1.weight");
            this.convs_3_weight = (Weight) hashMap.get("convs.2.weight");
            this.convs_1_weight.data = Operator.transpose3D(this.convs_1_weight.data, this.convs_1_weight.shape[0], this.convs_1_weight.shape[1], this.convs_1_weight.shape[2]);
            this.convs_2_weight.data = Operator.transpose3D(this.convs_2_weight.data, this.convs_2_weight.shape[0], this.convs_2_weight.shape[1], this.convs_2_weight.shape[2]);
            this.convs_3_weight.data = Operator.transpose3D(this.convs_3_weight.data, this.convs_3_weight.shape[0], this.convs_3_weight.shape[1], this.convs_3_weight.shape[2]);
            this.convs_1_bias = (Weight) hashMap.get("convs.0.bias");
            this.convs_2_bias = (Weight) hashMap.get("convs.1.bias");
            this.convs_3_bias = (Weight) hashMap.get("convs.2.bias");
            this.fc1_weight = (Weight) hashMap.get("fc1.weight");
            this.fc2_weight = (Weight) hashMap.get("fc2.weight");
            this.fc3_weight = (Weight) hashMap.get("fc3.weight");
            this.fc1_weight.data = Operator.transpose2D(this.fc1_weight.data, this.fc1_weight.shape[0], this.fc1_weight.shape[1]);
            this.fc2_weight.data = Operator.transpose2D(this.fc2_weight.data, this.fc2_weight.shape[0], this.fc2_weight.shape[1]);
            this.fc3_weight.data = Operator.transpose2D(this.fc3_weight.data, this.fc3_weight.shape[0], this.fc3_weight.shape[1]);
            this.fc1_bias = (Weight) hashMap.get("fc1.bias");
            this.fc2_bias = (Weight) hashMap.get("fc2.bias");
            this.fc3_bias = (Weight) hashMap.get("fc3.bias");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final String predict(float[] fArr, String str) {
        float[] embedding2 = Operator.embedding(Utils.vectorize(str, NotificationCompat.FLAG_HIGH_PRIORITY), this.embedding.data, 1, NotificationCompat.FLAG_HIGH_PRIORITY, 64);
        float[] conv1D = Operator.conv1D(embedding2, this.convs_1_weight.data, 1, NotificationCompat.FLAG_HIGH_PRIORITY, 64, this.convs_1_weight.shape[2], this.convs_1_weight.shape[0]);
        float[] conv1D2 = Operator.conv1D(embedding2, this.convs_2_weight.data, 1, NotificationCompat.FLAG_HIGH_PRIORITY, 64, this.convs_2_weight.shape[2], this.convs_2_weight.shape[0]);
        float[] conv1D3 = Operator.conv1D(embedding2, this.convs_3_weight.data, 1, NotificationCompat.FLAG_HIGH_PRIORITY, 64, this.convs_3_weight.shape[2], this.convs_3_weight.shape[0]);
        Operator.add(conv1D, this.convs_1_bias.data, 1, (128 - this.convs_1_weight.shape[2]) + 1, this.convs_1_weight.shape[0]);
        Operator.add(conv1D2, this.convs_2_bias.data, 1, (128 - this.convs_2_weight.shape[2]) + 1, this.convs_2_weight.shape[0]);
        Operator.add(conv1D3, this.convs_3_bias.data, 1, (128 - this.convs_3_weight.shape[2]) + 1, this.convs_3_weight.shape[0]);
        Operator.relu(conv1D, ((128 - this.convs_1_weight.shape[2]) + 1) * this.convs_1_weight.shape[0]);
        Operator.relu(conv1D2, ((128 - this.convs_2_weight.shape[2]) + 1) * this.convs_2_weight.shape[0]);
        Operator.relu(conv1D3, ((128 - this.convs_3_weight.shape[2]) + 1) * this.convs_3_weight.shape[0]);
        float[] maxPool1D = Operator.maxPool1D(conv1D, (128 - this.convs_1_weight.shape[2]) + 1, this.convs_1_weight.shape[0], (128 - this.convs_1_weight.shape[2]) + 1);
        float[] maxPool1D2 = Operator.maxPool1D(conv1D2, (128 - this.convs_2_weight.shape[2]) + 1, this.convs_2_weight.shape[0], (128 - this.convs_2_weight.shape[2]) + 1);
        float[] dense = Operator.dense(Operator.concatenate(Operator.concatenate(Operator.concatenate(maxPool1D, maxPool1D2), Operator.maxPool1D(conv1D3, (128 - this.convs_3_weight.shape[2]) + 1, this.convs_3_weight.shape[0], (NotificationCompat.FLAG_HIGH_PRIORITY - this.convs_3_weight.shape[2]) + 1)), fArr), this.fc1_weight.data, this.fc1_bias.data, 1, this.fc1_weight.shape[1], this.fc1_weight.shape[0]);
        Operator.relu(dense, this.fc1_bias.shape[0]);
        float[] dense2 = Operator.dense(dense, this.fc2_weight.data, this.fc2_bias.data, 1, this.fc2_weight.shape[1], this.fc2_weight.shape[0]);
        Operator.relu(dense2, this.fc2_bias.shape[0]);
        float[] dense3 = Operator.dense(dense2, this.fc3_weight.data, this.fc3_bias.data, 1, this.fc3_weight.shape[1], this.fc3_weight.shape[0]);
        Operator.softmax(dense3, this.fc3_bias.shape[0]);
        return processPredictionResult(dense3);
    }

    /* access modifiers changed from: package-private */
    public final String processPredictionResult(float[] fArr) {
        if (!(fArr.length == 0 || this.thresholds.length == 0)) {
            if (this.useCase.equals("SUGGEST_EVENT")) {
                return processSuggestedEventResult(fArr);
            }
            if (this.useCase.equals("DATA_DETECTION_ADDRESS")) {
                return processAddressDetectionResult(fArr);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final String processSuggestedEventResult(float[] fArr) {
        if (this.thresholds.length != fArr.length) {
            return null;
        }
        int i = 0;
        while (true) {
            float[] fArr2 = this.thresholds;
            if (i >= fArr2.length) {
                return "other";
            }
            if (fArr[i] >= fArr2[i]) {
                return SUGGESTED_EVENTS_PREDICTION.get(i);
            }
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public final String processAddressDetectionResult(float[] fArr) {
        if (fArr[1] >= this.thresholds[0]) {
            return "SHOULD_FILTER";
        }
        return null;
    }

    static class FileDownloadTask extends AsyncTask<String, Void, Boolean> {
        File destFile;
        Runnable onSuccess;
        String uriStr;

        FileDownloadTask(String str, File file, Runnable runnable) {
            this.uriStr = str;
            this.destFile = file;
            this.onSuccess = runnable;
        }

        /* access modifiers changed from: protected */
        public Boolean doInBackground(String... strArr) {
            try {
                URL url = new URL(this.uriStr);
                int contentLength = url.openConnection().getContentLength();
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                byte[] bArr = new byte[contentLength];
                dataInputStream.readFully(bArr);
                dataInputStream.close();
                DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.destFile));
                dataOutputStream.write(bArr);
                dataOutputStream.flush();
                dataOutputStream.close();
                return Boolean.TRUE;
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                this.onSuccess.run();
            }
        }
    }

    static class Weight {
        public float[] data;
        public int[] shape;

        Weight(int[] iArr, float[] fArr) {
            this.shape = iArr;
            this.data = fArr;
        }
    }
}
