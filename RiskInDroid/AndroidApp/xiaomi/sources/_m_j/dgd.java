package _m_j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

final class dgd {
    static File O000000o(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        if (!file.getParentFile().exists()) {
            O000000o(file.getParentFile().getAbsolutePath());
        }
        file.mkdir();
        return file;
    }

    static List<String> O000000o(File file) {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine.trim());
            } else {
                fileReader.close();
                bufferedReader.close();
                return arrayList;
            }
        }
    }
}
