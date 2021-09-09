package com.xiaomi.mico.api.service;

import com.xiaomi.mico.api.ApiConstants;

public interface IAreaCodeService {
    int getCountryCode();

    String getHostApiMiwifi();

    String getHostFileService();

    String getHostIAiMi();

    String getHostLogMiwifi();

    String getMicoBaseUrl();

    String getMicoSid();

    ApiConstants.ServiceConfig[] getOfficeServices();
}
