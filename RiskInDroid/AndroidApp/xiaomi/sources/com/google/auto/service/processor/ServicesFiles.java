package com.google.auto.service.processor;

import com.google.common.base.Charsets;
import com.google.common.io.Closer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

final class ServicesFiles {
    private ServicesFiles() {
    }

    static String getPath(String str) {
        return "META-INF/services/".concat(String.valueOf(str));
    }

    static Set<String> readServiceFile(InputStream inputStream) throws IOException {
        HashSet hashSet = new HashSet();
        Closer create = Closer.create();
        try {
            BufferedReader bufferedReader = (BufferedReader) create.register(new BufferedReader(new InputStreamReader(inputStream, Charsets.UTF_8)));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    int indexOf = readLine.indexOf(35);
                    if (indexOf >= 0) {
                        readLine = readLine.substring(0, indexOf);
                    }
                    String trim = readLine.trim();
                    if (!trim.isEmpty()) {
                        hashSet.add(trim);
                    }
                } else {
                    create.close();
                    return hashSet;
                }
            }
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    static void writeServiceFile(Collection<String> collection, OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, Charsets.UTF_8));
        for (String write : collection) {
            bufferedWriter.write(write);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
}
