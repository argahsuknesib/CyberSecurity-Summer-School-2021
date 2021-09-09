package com.xiaomi.mico.music.player.lrc;

import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LrcParseImpl implements LrcParse {
    public List<LrcRow> getLrcRows(String str) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        ArrayList arrayList = new ArrayList();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                List<LrcRow> createRows = LrcRow.createRows(readLine);
                if (createRows != null && createRows.size() > 0) {
                    arrayList.addAll(createRows);
                }
            } catch (Exception e) {
                Object[] objArr = {"LrcParseImpl getLrcRows error ", e};
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return null;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                throw th;
            }
        }
        Collections.sort(arrayList);
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            int i3 = i2 + 1;
            ((LrcRow) arrayList.get(i2)).setTotalTime(((LrcRow) arrayList.get(i3)).getTimeMillis() - ((LrcRow) arrayList.get(i2)).getTimeMillis());
            i2 = i3;
        }
        if (size > 0) {
            ((LrcRow) arrayList.get(i)).setTotalTime(5000);
        }
        try {
            bufferedReader.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return arrayList;
    }
}
