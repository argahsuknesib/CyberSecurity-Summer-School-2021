package com.xiaomi.aiot.mibeacon.distance;

import android.content.Context;
import com.xiaomi.aiot.mibeacon.logging.LogManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ModelSpecificDistanceCalculator implements DistanceCalculator {
    private Context mContext;
    private AndroidModel mDefaultModel;
    private DistanceCalculator mDistanceCalculator;
    private final ReentrantLock mLock;
    private AndroidModel mModel;
    Map<AndroidModel, DistanceCalculator> mModelMap;
    private String mRemoteUpdateUrlString;
    private AndroidModel mRequestedModel;

    private void requestModelMapFromWeb() {
    }

    public ModelSpecificDistanceCalculator(Context context, String str) {
        this(context, str, AndroidModel.forThisDevice());
    }

    public ModelSpecificDistanceCalculator(Context context, String str, AndroidModel androidModel) {
        this.mRemoteUpdateUrlString = null;
        this.mLock = new ReentrantLock();
        this.mRequestedModel = androidModel;
        this.mRemoteUpdateUrlString = str;
        this.mContext = context;
        loadModelMap();
        this.mDistanceCalculator = findCalculatorForModelWithLock(androidModel);
    }

    public AndroidModel getModel() {
        return this.mModel;
    }

    public AndroidModel getRequestedModel() {
        return this.mRequestedModel;
    }

    public double calculateDistance(int i, double d) {
        DistanceCalculator distanceCalculator = this.mDistanceCalculator;
        if (distanceCalculator != null) {
            return distanceCalculator.calculateDistance(i, d);
        }
        LogManager.w("ModelSpecificCalculator", "distance calculator has not been set", new Object[0]);
        return -1.0d;
    }

    /* access modifiers changed from: package-private */
    public DistanceCalculator findCalculatorForModelWithLock(AndroidModel androidModel) {
        this.mLock.lock();
        try {
            return findCalculatorForModel(androidModel);
        } finally {
            this.mLock.unlock();
        }
    }

    private DistanceCalculator findCalculatorForModel(AndroidModel androidModel) {
        Map<AndroidModel, DistanceCalculator> map = this.mModelMap;
        AndroidModel androidModel2 = null;
        if (map == null) {
            LogManager.d("ModelSpecificCalculator", "Cannot get distance calculator because modelMap was never initialized", new Object[0]);
            return null;
        }
        int i = 0;
        for (AndroidModel next : map.keySet()) {
            if (next.matchScore(androidModel) > i) {
                i = next.matchScore(androidModel);
                androidModel2 = next;
            }
        }
        if (androidModel2 != null) {
            LogManager.d("ModelSpecificCalculator", "found a match with score %s", Integer.valueOf(i));
            LogManager.d("ModelSpecificCalculator", "Finding best distance calculator for %s, %s, %s, %s", androidModel2.getVersion(), androidModel2.getBuildNumber(), androidModel2.getModel(), androidModel2.getManufacturer());
            this.mModel = androidModel2;
        } else {
            this.mModel = this.mDefaultModel;
            LogManager.w("ModelSpecificCalculator", "Cannot find match for this device.  Using default", new Object[0]);
        }
        return this.mModelMap.get(this.mModel);
    }

    private void loadModelMap() {
        loadModelMapFromFile();
        this.mDistanceCalculator = findCalculatorForModelWithLock(this.mRequestedModel);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:7|8|9|10|11) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003f, code lost:
        com.xiaomi.aiot.mibeacon.logging.LogManager.e(r4, "ModelSpecificCalculator", "Cannot update distance models from online database at %s with JSON: %s", r8.mRemoteUpdateUrlString, r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0051, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069 A[SYNTHETIC, Splitter:B:27:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f A[SYNTHETIC, Splitter:B:36:0x007f] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0085 A[SYNTHETIC, Splitter:B:41:0x0085] */
    private boolean loadModelMapFromFile() {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(this.mContext.getResources().getAssets().open("model-distance-calculations.json")));
            while (true) {
                try {
                    String readLine = bufferedReader2.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append("\n");
                    } else {
                        bufferedReader2.close();
                        buildModelMapWithLock(sb.toString());
                        return true;
                    }
                } catch (FileNotFoundException e) {
                    e = e;
                    bufferedReader = bufferedReader2;
                    LogManager.d("ModelSpecificCalculator", "loadModelMapFromAsstes ".concat(String.valueOf(e)), new Object[0]);
                    if (bufferedReader != null) {
                    }
                    return false;
                } catch (IOException e2) {
                    e = e2;
                    bufferedReader = bufferedReader2;
                    try {
                        LogManager.e("ModelSpecificCalculator", "Cannot open distance model file", e);
                        if (bufferedReader != null) {
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedReader != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            }
        } catch (FileNotFoundException e3) {
            e = e3;
            LogManager.d("ModelSpecificCalculator", "loadModelMapFromAsstes ".concat(String.valueOf(e)), new Object[0]);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
            return false;
        } catch (IOException e4) {
            e = e4;
            LogManager.e("ModelSpecificCalculator", "Cannot open distance model file", e);
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused3) {
                }
            }
            return false;
        }
    }

    private boolean saveJson(String str) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = this.mContext.openFileOutput("model-distance-calculations.json", 0);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            if (fileOutputStream == null) {
                return true;
            }
            try {
                fileOutputStream.close();
                return true;
            } catch (Exception unused) {
                return true;
            }
        } catch (Exception unused2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused3) {
                }
            }
            return false;
        } catch (Throwable th) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Exception unused4) {
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public void buildModelMapWithLock(String str) throws JSONException {
        this.mLock.lock();
        try {
            buildModelMap(str);
        } finally {
            this.mLock.unlock();
        }
    }

    private void buildModelMap(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        JSONArray jSONArray = new JSONObject(str).getJSONArray("models");
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            boolean z = jSONObject.has("default") ? jSONObject.getBoolean("default") : false;
            Double valueOf = Double.valueOf(jSONObject.getDouble("coefficient1"));
            Double valueOf2 = Double.valueOf(jSONObject.getDouble("coefficient2"));
            Double valueOf3 = Double.valueOf(jSONObject.getDouble("coefficient3"));
            String string = jSONObject.getString("version");
            String string2 = jSONObject.getString("build_number");
            String string3 = jSONObject.getString("model");
            String string4 = jSONObject.getString("manufacturer");
            double doubleValue = valueOf.doubleValue();
            double doubleValue2 = valueOf2.doubleValue();
            double doubleValue3 = valueOf3.doubleValue();
            CurveFittedDistanceCalculator curveFittedDistanceCalculator = r13;
            CurveFittedDistanceCalculator curveFittedDistanceCalculator2 = new CurveFittedDistanceCalculator(doubleValue, doubleValue2, doubleValue3);
            AndroidModel androidModel = new AndroidModel(string, string2, string3, string4);
            hashMap.put(androidModel, curveFittedDistanceCalculator);
            if (z) {
                this.mDefaultModel = androidModel;
            }
        }
        this.mModelMap = hashMap;
    }

    private void loadDefaultModelMap() {
        try {
            buildModelMap(stringFromFilePath("model-distance-calculations.json"));
        } catch (Exception unused) {
            this.mModelMap = new HashMap();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007e  */
    private String stringFromFilePath(String str) throws IOException {
        InputStream inputStream;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream resourceAsStream = ModelSpecificDistanceCalculator.class.getResourceAsStream("/".concat(String.valueOf(str)));
            if (resourceAsStream == null) {
                try {
                    inputStream = getClass().getClassLoader().getResourceAsStream("/".concat(String.valueOf(str)));
                } catch (Throwable th) {
                    th = th;
                    inputStream = resourceAsStream;
                    if (bufferedReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } else {
                inputStream = resourceAsStream;
            }
            if (inputStream != null) {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                    try {
                        for (String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                            sb.append(readLine);
                            sb.append(10);
                        }
                        bufferedReader2.close();
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return sb.toString();
                    } catch (Throwable th2) {
                        bufferedReader = bufferedReader2;
                        th = th2;
                        if (bufferedReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th;
                }
            } else {
                throw new RuntimeException("Cannot load resource at ".concat(String.valueOf(str)));
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            if (bufferedReader != null) {
            }
            if (inputStream != null) {
            }
            throw th;
        }
    }
}
