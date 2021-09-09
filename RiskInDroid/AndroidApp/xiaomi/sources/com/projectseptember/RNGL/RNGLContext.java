package com.projectseptember.RNGL;

import _m_j.csl;
import _m_j.csp;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name = "RNGLContext")
public class RNGLContext extends ReactContextBaseJavaModule {
    private static String STATIC_VERT = "attribute vec2 position;varying vec2 uv;void main() {gl_Position = vec4(position,0.0,1.0);uv = vec2(0.5, 0.5) * (position+vec2(1.0, 1.0));}";
    private Map<Integer, csl> fbos = new HashMap();
    private Map<Integer, Callback> onCompileCallbacks = new HashMap();
    private Map<Integer, csp> shaders = new HashMap();

    static String glTypeString(int i) {
        if (i == 5124) {
            return "int";
        }
        if (i == 5126) {
            return "float";
        }
        if (i == 35678) {
            return "sampler2D";
        }
        if (i == 35680) {
            return "samplerCube";
        }
        switch (i) {
            case 35664:
                return "vec2";
            case 35665:
                return "vec3";
            case 35666:
                return "vec4";
            case 35667:
                return "ivec2";
            case 35668:
                return "ivec3";
            case 35669:
                return "ivec4";
            case 35670:
                return "bool";
            case 35671:
                return "bvec2";
            case 35672:
                return "bvec3";
            case 35673:
                return "bvec4";
            case 35674:
                return "mat2";
            case 35675:
                return "mat3";
            case 35676:
                return "mat4";
            default:
                return "";
        }
    }

    public String getName() {
        return "RNGLContext";
    }

    public RNGLContext(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public csp getShader(Integer num) {
        csp csp;
        synchronized (this) {
            csp = this.shaders.get(num);
        }
        return csp;
    }

    @ReactMethod
    public void addShader(Integer num, ReadableMap readableMap, Callback callback) {
        String string = readableMap.getString("frag");
        String string2 = readableMap.getString("name");
        synchronized (this) {
            String str = STATIC_VERT;
            if (readableMap.hasKey("vert")) {
                str = readableMap.getString("vert");
            }
            this.shaders.put(num, new csp(string2, str, string));
            if (callback != null) {
                this.onCompileCallbacks.put(num, callback);
            }
        }
    }

    @ReactMethod
    public void removeShader(Integer num) {
        csp remove;
        synchronized (this) {
            remove = this.shaders.remove(num);
        }
        if (remove == null) {
            throw new Error("removeShader(" + num + "): shader does not exist");
        }
    }

    public void shaderFailedToCompile(Integer num, GLShaderCompilationFailed gLShaderCompilationFailed) {
        Callback callback;
        synchronized (this) {
            callback = this.onCompileCallbacks.get(num);
            this.onCompileCallbacks.remove(num);
        }
        if (callback == null) {
            Log.e("RNGLContext", gLShaderCompilationFailed.getMessage());
            return;
        }
        callback.invoke(gLShaderCompilationFailed.compileError);
    }

    public void shaderSucceedToCompile(Integer num, Map<String, Integer> map) {
        Callback callback;
        synchronized (this) {
            callback = this.onCompileCallbacks.get(num);
            this.onCompileCallbacks.remove(num);
        }
        if (callback != null) {
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            for (String next : map.keySet()) {
                createMap2.putString(next, glTypeString(map.get(next).intValue()));
            }
            createMap.putMap("uniforms", createMap2);
            callback.invoke(null, createMap);
        }
    }
}
