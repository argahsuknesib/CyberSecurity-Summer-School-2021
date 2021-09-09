package _m_j;

import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class fvu {
    public static List<JSONObject> O000000o(Context context) {
        ArrayList arrayList = new ArrayList();
        String O00000Oo = O00000Oo(context);
        File file = new File(O00000Oo);
        if (!file.exists()) {
            LogType logType = LogType.PLUGIN;
            gsy.O00000o0(logType, "RnDebugFileUtil", O00000Oo + " is not exist!");
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                arrayList2.add(readLine);
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            gsy.O00000o0(LogType.PLUGIN, "RnDebugFileUtil", e.toString());
        } catch (IOException e2) {
            gsy.O00000o0(LogType.PLUGIN, "RnDebugFileUtil", e2.toString());
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            gsy.O00000o0(LogType.PLUGIN, "RnDebugFileUtil", (String) arrayList2.get(i));
            try {
                arrayList.add(new JSONObject((String) arrayList2.get(i)));
            } catch (JSONException e3) {
                gsy.O00000o0(LogType.PLUGIN, "RnDebugFileUtil", e3.toString());
            }
        }
        return arrayList;
    }

    public static void O000000o(Context context, List<JSONObject> list) {
        if (list == null) {
            gsy.O00000o0(LogType.PLUGIN, "RnDebugFileUtil", "rn debug list data is null");
            return;
        }
        File file = new File(O00000Oo(context));
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            gsy.O00000o0(LogType.PLUGIN, "RnDebugFileUtil", e.toString());
        }
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (int i = 0; i < list.size(); i++) {
                bufferedWriter.write(list.get(i).toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            outputStreamWriter.close();
        } catch (FileNotFoundException e2) {
            gsy.O00000o0(LogType.PLUGIN, "RnDebugFileUtil", e2.toString());
        } catch (IOException e3) {
            gsy.O00000o0(LogType.PLUGIN, "RnDebugFileUtil", e3.toString());
        }
    }

    private static String O00000Oo(Context context) {
        return context.getFilesDir() + File.separator + "rn_debug_list_data.txt";
    }

    public static JSONObject O000000o(String str) {
        for (JSONObject next : O000000o(CommonApplication.getAppContext())) {
            String optString = next.optString(fvt.O00000Oo);
            boolean optBoolean = next.optBoolean(fvt.O00000o0);
            if (str.equals(optString) && optBoolean) {
                return next;
            }
        }
        return null;
    }
}
