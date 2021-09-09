package _m_j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class jnt {

    /* renamed from: O000000o  reason: collision with root package name */
    private static jnt f1980O000000o;
    private jns O00000Oo;
    private jns O00000o;
    private jns O00000o0;
    private jnf O00000oO;

    private jnt(jnf jnf) {
        this.O00000oO = jnf;
        O00000Oo();
        O00000o();
        O00000oO();
    }

    public static jnt O000000o(jnf jnf) {
        if (f1980O000000o == null) {
            synchronized (jnt.class) {
                if (f1980O000000o == null) {
                    jnt jnt = new jnt(jnf);
                    f1980O000000o = jnt;
                    return jnt;
                }
            }
        }
        return f1980O000000o;
    }

    public static jnt O000000o() {
        jnt jnt = f1980O000000o;
        if (jnt != null) {
            return jnt;
        }
        throw new IllegalStateException("词典尚未初始化，请先调用initial方法");
    }

    public static jnu O000000o(char[] cArr, int i) {
        return f1980O000000o.O00000Oo.O000000o(cArr, i, 1);
    }

    public static jnu O00000Oo(char[] cArr, int i) {
        return f1980O000000o.O00000o.O000000o(cArr, i, 1);
    }

    public static boolean O000000o(char[] cArr, int i, int i2) {
        return f1980O000000o.O00000o0.O000000o(cArr, i, i2).O000000o();
    }

    private void O00000Oo() {
        String readLine;
        this.O00000Oo = new jns(0);
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(this.O00000oO.O00000Oo());
        if (resourceAsStream != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"), 512);
                do {
                    readLine = bufferedReader.readLine();
                    if (readLine != null && !"".equals(readLine.trim())) {
                        this.O00000Oo.O000000o(readLine.trim().toLowerCase().toCharArray());
                        continue;
                    }
                } while (readLine != null);
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                System.err.println("Main Dictionary loading exception.");
                e2.printStackTrace();
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
            O00000o0();
            return;
        }
        throw new RuntimeException("Main Dictionary not found!!!");
    }

    private void O00000o0() {
        String readLine;
        for (String next : this.O00000oO.O00000o()) {
            System.out.println("加载扩展词典：".concat(String.valueOf(next)));
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(next);
            if (resourceAsStream != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"), 512);
                    do {
                        readLine = bufferedReader.readLine();
                        if (readLine != null && !"".equals(readLine.trim())) {
                            this.O00000Oo.O000000o(readLine.trim().toLowerCase().toCharArray());
                            continue;
                        }
                    } while (readLine != null);
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    System.err.println("Extension Dictionary loading exception.");
                    e2.printStackTrace();
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                } catch (Throwable th) {
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    private void O00000o() {
        String readLine;
        this.O00000o0 = new jns(0);
        for (String next : this.O00000oO.O00000oO()) {
            System.out.println("加载扩展停止词典：".concat(String.valueOf(next)));
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(next);
            if (resourceAsStream != null) {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"), 512);
                    do {
                        readLine = bufferedReader.readLine();
                        if (readLine != null && !"".equals(readLine.trim())) {
                            this.O00000o0.O000000o(readLine.trim().toLowerCase().toCharArray());
                            continue;
                        }
                    } while (readLine != null);
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e2) {
                    System.err.println("Extension Stop word Dictionary loading exception.");
                    e2.printStackTrace();
                    if (resourceAsStream != null) {
                        resourceAsStream.close();
                    }
                } catch (Throwable th) {
                    if (resourceAsStream != null) {
                        try {
                            resourceAsStream.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        }
    }

    private void O00000oO() {
        String readLine;
        this.O00000o = new jns(0);
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(this.O00000oO.O00000o0());
        if (resourceAsStream != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream, "UTF-8"), 512);
                do {
                    readLine = bufferedReader.readLine();
                    if (readLine != null && !"".equals(readLine.trim())) {
                        this.O00000o.O000000o(readLine.trim().toLowerCase().toCharArray());
                        continue;
                    }
                } while (readLine != null);
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                System.err.println("Quantifier Dictionary loading exception.");
                e2.printStackTrace();
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (Throwable th) {
                if (resourceAsStream != null) {
                    try {
                        resourceAsStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
        } else {
            throw new RuntimeException("Quantifier Dictionary not found!!!");
        }
    }

    public static jnu O000000o(char[] cArr, int i, jnu jnu) {
        return jnu.O00000Oo.O000000o(cArr, i, 1, jnu);
    }
}
