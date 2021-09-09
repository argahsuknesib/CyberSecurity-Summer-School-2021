package com.google.android.exoplayer2.video.spherical;

import com.google.android.exoplayer2.util.Assertions;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Projection {
    public final Mesh leftMesh;
    public final Mesh rightMesh;
    public final boolean singleMesh;
    public final int stereoMode;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface DrawMode {
    }

    public static Projection createEquirectangular(int i) {
        return createEquirectangular(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010c, code lost:
        if (r3 == 1) goto L_0x010e;
     */
    public static Projection createEquirectangular(float f, int i, int i2, float f2, float f3, int i3) {
        float f4;
        float f5;
        int i4;
        int i5;
        int i6;
        float f6 = f;
        int i7 = i;
        int i8 = i2;
        float f7 = f2;
        float f8 = f3;
        Assertions.checkArgument(f6 > 0.0f);
        Assertions.checkArgument(i7 > 0);
        Assertions.checkArgument(i8 > 0);
        Assertions.checkArgument(f7 > 0.0f && f7 <= 180.0f);
        Assertions.checkArgument(f8 > 0.0f && f8 <= 360.0f);
        float radians = (float) Math.toRadians((double) f7);
        float radians2 = (float) Math.toRadians((double) f8);
        float f9 = radians / ((float) i7);
        float f10 = radians2 / ((float) i8);
        int i9 = i8 + 1;
        int i10 = ((i9 * 2) + 2) * i7;
        float[] fArr = new float[(i10 * 3)];
        float[] fArr2 = new float[(i10 * 2)];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < i7) {
            float f11 = radians / 2.0f;
            float f12 = (((float) i11) * f9) - f11;
            int i14 = i11 + 1;
            float f13 = (((float) i14) * f9) - f11;
            int i15 = i13;
            int i16 = i12;
            int i17 = 0;
            while (i17 < i9) {
                int i18 = i15;
                int i19 = 2;
                int i20 = i16;
                int i21 = 0;
                while (i21 < i19) {
                    if (i21 == 0) {
                        f4 = f12;
                        f5 = f4;
                    } else {
                        f4 = f12;
                        f5 = f13;
                    }
                    float f14 = ((float) i17) * f10;
                    int i22 = i14;
                    int i23 = i20 + 1;
                    float f15 = f10;
                    int i24 = i9;
                    double d = (double) f6;
                    float f16 = radians;
                    double d2 = (double) ((f14 + 3.1415927f) - (radians2 / 2.0f));
                    double sin = Math.sin(d2);
                    Double.isNaN(d);
                    double d3 = (double) f5;
                    int i25 = i11;
                    int i26 = i17;
                    fArr[i20] = -((float) (sin * d * Math.cos(d3)));
                    int i27 = i23 + 1;
                    double sin2 = Math.sin(d3);
                    Double.isNaN(d);
                    int i28 = i21;
                    fArr[i23] = (float) (d * sin2);
                    int i29 = i27 + 1;
                    double cos = Math.cos(d2);
                    Double.isNaN(d);
                    fArr[i27] = (float) (d * cos * Math.cos(d3));
                    int i30 = i18 + 1;
                    fArr2[i18] = f14 / radians2;
                    int i31 = i30 + 1;
                    fArr2[i30] = (((float) (i25 + i28)) * f9) / f16;
                    if (i26 == 0 && i28 == 0) {
                        i6 = i2;
                        i4 = i28;
                        i5 = i26;
                    } else {
                        i6 = i2;
                        i5 = i26;
                        if (i5 == i6) {
                            i4 = i28;
                        } else {
                            i4 = i28;
                        }
                        i18 = i31;
                        i20 = i29;
                        i21 = i4 + 1;
                        f12 = f4;
                        i17 = i5;
                        i11 = i25;
                        f10 = f15;
                        i14 = i22;
                        i9 = i24;
                        radians = f16;
                        i19 = 2;
                        i8 = i6;
                        f6 = f;
                    }
                    System.arraycopy(fArr, i29 - 3, fArr, i29, 3);
                    i29 += 3;
                    System.arraycopy(fArr2, i31 - 2, fArr2, i31, 2);
                    i31 += 2;
                    i18 = i31;
                    i20 = i29;
                    i21 = i4 + 1;
                    f12 = f4;
                    i17 = i5;
                    i11 = i25;
                    f10 = f15;
                    i14 = i22;
                    i9 = i24;
                    radians = f16;
                    i19 = 2;
                    i8 = i6;
                    f6 = f;
                }
                i17++;
                i8 = i8;
                i16 = i20;
                i15 = i18;
                f10 = f10;
                i14 = i14;
                f6 = f;
            }
            f6 = f;
            i7 = i;
            i12 = i16;
            i13 = i15;
            i11 = i14;
        }
        return new Projection(new Mesh(new SubMesh(0, fArr, fArr2, 1)), i3);
    }

    public Projection(Mesh mesh, int i) {
        this(mesh, mesh, i);
    }

    public Projection(Mesh mesh, Mesh mesh2, int i) {
        this.leftMesh = mesh;
        this.rightMesh = mesh2;
        this.stereoMode = i;
        this.singleMesh = mesh == mesh2;
    }

    public static final class SubMesh {
        public final int mode;
        public final float[] textureCoords;
        public final int textureId;
        public final float[] vertices;

        public SubMesh(int i, float[] fArr, float[] fArr2, int i2) {
            this.textureId = i;
            Assertions.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.vertices = fArr;
            this.textureCoords = fArr2;
            this.mode = i2;
        }

        public final int getVertexCount() {
            return this.vertices.length / 3;
        }
    }

    public static final class Mesh {
        private final SubMesh[] subMeshes;

        public Mesh(SubMesh... subMeshArr) {
            this.subMeshes = subMeshArr;
        }

        public final int getSubMeshCount() {
            return this.subMeshes.length;
        }

        public final SubMesh getSubMesh(int i) {
            return this.subMeshes[i];
        }
    }
}
