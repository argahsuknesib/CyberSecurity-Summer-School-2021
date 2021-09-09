package _m_j;

import android.opengl.GLES20;
import android.util.Log;

public final class cjs {
    static int O000000o(String str, int i) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader));
        return 0;
    }
}
