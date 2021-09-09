package com.google.zxing.pdf417;

public final class PDF417ResultMetadata {
    private String addressee;
    private int checksum = -1;
    private String fileId;
    private String fileName;
    private long fileSize = -1;
    private boolean lastSegment;
    private int[] optionalData;
    private int segmentCount = -1;
    private int segmentIndex;
    private String sender;
    private long timestamp = -1;

    public final int getSegmentIndex() {
        return this.segmentIndex;
    }

    public final void setSegmentIndex(int i) {
        this.segmentIndex = i;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final void setFileId(String str) {
        this.fileId = str;
    }

    @Deprecated
    public final int[] getOptionalData() {
        return this.optionalData;
    }

    @Deprecated
    public final void setOptionalData(int[] iArr) {
        this.optionalData = iArr;
    }

    public final boolean isLastSegment() {
        return this.lastSegment;
    }

    public final void setLastSegment(boolean z) {
        this.lastSegment = z;
    }

    public final int getSegmentCount() {
        return this.segmentCount;
    }

    public final void setSegmentCount(int i) {
        this.segmentCount = i;
    }

    public final String getSender() {
        return this.sender;
    }

    public final void setSender(String str) {
        this.sender = str;
    }

    public final String getAddressee() {
        return this.addressee;
    }

    public final void setAddressee(String str) {
        this.addressee = str;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final void setFileName(String str) {
        this.fileName = str;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final void setFileSize(long j) {
        this.fileSize = j;
    }

    public final int getChecksum() {
        return this.checksum;
    }

    public final void setChecksum(int i) {
        this.checksum = i;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long j) {
        this.timestamp = j;
    }
}
