package com.xiaomi.infra.galaxy.fds;

public enum SubResource {
    ACL("acl"),
    QUOTA("quota"),
    UPLOADS("uploads"),
    PART_NUMBER("partNumber"),
    UPLOAD_ID("uploadId"),
    STORAGE_ACCESS_TOKEN("storageAccessToken"),
    COMPRESSION("compression"),
    METADATA("metadata");
    
    private final String name;

    private SubResource(String str) {
        this.name = str;
    }

    public final String getName() {
        return this.name;
    }
}
