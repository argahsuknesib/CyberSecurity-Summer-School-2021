package com.projectseptember.RNGL;

public class GLShaderCompilationFailed extends RuntimeException {
    public final String compileError;
    public final String shaderName;

    public GLShaderCompilationFailed(String str, String str2) {
        super("Shader '" + str + "': " + str2);
        this.compileError = str2;
        this.shaderName = str;
    }
}
