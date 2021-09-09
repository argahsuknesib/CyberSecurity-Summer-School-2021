package com.google.zxing.pdf417.decoder;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

final class BoundingBox {
    private final ResultPoint bottomLeft;
    private final ResultPoint bottomRight;
    private final BitMatrix image;
    private final int maxX;
    private final int maxY;
    private final int minX;
    private final int minY;
    private final ResultPoint topLeft;
    private final ResultPoint topRight;

    BoundingBox(BitMatrix bitMatrix, ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3, ResultPoint resultPoint4) throws NotFoundException {
        boolean z = false;
        boolean z2 = resultPoint == null || resultPoint2 == null;
        z = (resultPoint3 == null || resultPoint4 == null) ? true : z;
        if (!z2 || !z) {
            if (z2) {
                resultPoint = new ResultPoint(0.0f, resultPoint3.getY());
                resultPoint2 = new ResultPoint(0.0f, resultPoint4.getY());
            } else if (z) {
                resultPoint3 = new ResultPoint((float) (bitMatrix.getWidth() - 1), resultPoint.getY());
                resultPoint4 = new ResultPoint((float) (bitMatrix.getWidth() - 1), resultPoint2.getY());
            }
            this.image = bitMatrix;
            this.topLeft = resultPoint;
            this.bottomLeft = resultPoint2;
            this.topRight = resultPoint3;
            this.bottomRight = resultPoint4;
            this.minX = (int) Math.min(resultPoint.getX(), resultPoint2.getX());
            this.maxX = (int) Math.max(resultPoint3.getX(), resultPoint4.getX());
            this.minY = (int) Math.min(resultPoint.getY(), resultPoint3.getY());
            this.maxY = (int) Math.max(resultPoint2.getY(), resultPoint4.getY());
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    BoundingBox(BoundingBox boundingBox) {
        this.image = boundingBox.image;
        this.topLeft = boundingBox.getTopLeft();
        this.bottomLeft = boundingBox.getBottomLeft();
        this.topRight = boundingBox.getTopRight();
        this.bottomRight = boundingBox.getBottomRight();
        this.minX = boundingBox.getMinX();
        this.maxX = boundingBox.getMaxX();
        this.minY = boundingBox.getMinY();
        this.maxY = boundingBox.getMaxY();
    }

    static BoundingBox merge(BoundingBox boundingBox, BoundingBox boundingBox2) throws NotFoundException {
        if (boundingBox == null) {
            return boundingBox2;
        }
        return boundingBox2 == null ? boundingBox : new BoundingBox(boundingBox.image, boundingBox.topLeft, boundingBox.bottomLeft, boundingBox2.topRight, boundingBox2.bottomRight);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    public final BoundingBox addMissingRows(int i, int i2, boolean z) throws NotFoundException {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        ResultPoint resultPoint5 = this.topLeft;
        ResultPoint resultPoint6 = this.bottomLeft;
        ResultPoint resultPoint7 = this.topRight;
        ResultPoint resultPoint8 = this.bottomRight;
        if (i > 0) {
            ResultPoint resultPoint9 = z ? resultPoint5 : resultPoint7;
            int y = ((int) resultPoint9.getY()) - i;
            if (y < 0) {
                y = 0;
            }
            ResultPoint resultPoint10 = new ResultPoint(resultPoint9.getX(), (float) y);
            if (z) {
                resultPoint2 = resultPoint10;
            } else {
                resultPoint = resultPoint10;
                resultPoint2 = resultPoint5;
                if (i2 <= 0) {
                    ResultPoint resultPoint11 = z ? this.bottomLeft : this.bottomRight;
                    int y2 = ((int) resultPoint11.getY()) + i2;
                    if (y2 >= this.image.getHeight()) {
                        y2 = this.image.getHeight() - 1;
                    }
                    ResultPoint resultPoint12 = new ResultPoint(resultPoint11.getX(), (float) y2);
                    if (z) {
                        resultPoint4 = resultPoint12;
                    } else {
                        resultPoint3 = resultPoint12;
                        resultPoint4 = resultPoint6;
                        return new BoundingBox(this.image, resultPoint2, resultPoint4, resultPoint, resultPoint3);
                    }
                } else {
                    resultPoint4 = resultPoint6;
                }
                resultPoint3 = resultPoint8;
                return new BoundingBox(this.image, resultPoint2, resultPoint4, resultPoint, resultPoint3);
            }
        } else {
            resultPoint2 = resultPoint5;
        }
        resultPoint = resultPoint7;
        if (i2 <= 0) {
        }
        resultPoint3 = resultPoint8;
        return new BoundingBox(this.image, resultPoint2, resultPoint4, resultPoint, resultPoint3);
    }

    /* access modifiers changed from: package-private */
    public final int getMinX() {
        return this.minX;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxX() {
        return this.maxX;
    }

    /* access modifiers changed from: package-private */
    public final int getMinY() {
        return this.minY;
    }

    /* access modifiers changed from: package-private */
    public final int getMaxY() {
        return this.maxY;
    }

    /* access modifiers changed from: package-private */
    public final ResultPoint getTopLeft() {
        return this.topLeft;
    }

    /* access modifiers changed from: package-private */
    public final ResultPoint getTopRight() {
        return this.topRight;
    }

    /* access modifiers changed from: package-private */
    public final ResultPoint getBottomLeft() {
        return this.bottomLeft;
    }

    /* access modifiers changed from: package-private */
    public final ResultPoint getBottomRight() {
        return this.bottomRight;
    }
}
