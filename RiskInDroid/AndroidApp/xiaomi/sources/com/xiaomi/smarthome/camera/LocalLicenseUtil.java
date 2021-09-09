package com.xiaomi.smarthome.camera;

import _m_j.cin;
import _m_j.ftl;
import _m_j.gpg;
import _m_j.gpy;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.Spanned;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.camera.activity.utils.CameraJumpUtils;
import java.util.Locale;

public class LocalLicenseUtil {
    public static LocalLicense getV3LocalLicense(Resources resources) {
        return null;
    }

    public static class LocalLicense {
        public int mLicense;
        public Spanned mLicenseSpanned;
        public String mPlan;
        public int mPrivacy;
        public Spanned mPrivacySpanned;

        public LocalLicense(int i, int i2, String str, Spanned spanned, Spanned spanned2) {
            this.mLicense = i2;
            this.mPlan = str;
            this.mPrivacy = i;
            this.mPrivacySpanned = spanned;
            this.mLicenseSpanned = spanned2;
        }

        public LocalLicense(int i, int i2, String str) {
            this.mLicense = i2;
            this.mPlan = str;
            this.mPrivacy = i;
        }
    }

    public static class UrlLicense {
        public String mLicense;
        public String mPlan;
        public String mPrivacy;

        public UrlLicense(String str, String str2, String str3) {
            this.mLicense = str2;
            this.mPlan = str3;
            this.mPrivacy = str;
        }
    }

    public static LocalLicense getV4LocalLicense(Resources resources) {
        return getV4LocalLicense(resources, null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean
     arg types: [android.content.Context, java.lang.String, java.lang.String, int]
     candidates:
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, java.lang.String):java.lang.String
      _m_j.gpy.O00000o0(android.content.Context, java.lang.String, java.lang.String, boolean):boolean */
    public static LocalLicense getV4LocalLicense(Resources resources, String str) {
        int O000000o2;
        Locale locale;
        Resources resources2 = resources;
        String str2 = str;
        String O000000o3 = ftl.O000000o();
        String language = resources.getConfiguration().locale.getLanguage();
        if (gpy.O00000o0(CommonApplication.getAppContext(), "language_setting", "is_default", false)) {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            language = locale.getLanguage();
        }
        int licenseByModel = getLicenseByModel(resources, str);
        int privacyByModel = getPrivacyByModel(resources, str);
        if ("AE".equalsIgnoreCase(O000000o3) || "EG".equalsIgnoreCase(O000000o3) || "MA".equalsIgnoreCase(O000000o3) || "IQ".equalsIgnoreCase(O000000o3) || "LB".equalsIgnoreCase(O000000o3) || "BH".equalsIgnoreCase(O000000o3) || "KW".equalsIgnoreCase(O000000o3)) {
            if ("en".equalsIgnoreCase(language)) {
                if ("chuangmi.camera.026c02".equals(str2)) {
                    licenseByModel = getLicenseByModel_International(resources, str);
                    privacyByModel = getPrivacyByModel_International(resources, str);
                } else {
                    licenseByModel = getLicenseByModel(resources, str);
                    privacyByModel = getPrivacyByModel(resources, str);
                }
            } else if ("chuangmi.camera.021a04".equals(str2)) {
                licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_ar);
                privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_ar);
            } else if ("chuangmi.camera.029a02".equals(str2)) {
                licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_ar);
                privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_ar);
            } else if ("chuangmi.camera.026c02".equals(str2)) {
                licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_ar_only);
                privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_ar_only);
            } else {
                licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_ar);
                privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_ar);
            }
        } else if ("SA".equalsIgnoreCase(O000000o3) || "QA".equalsIgnoreCase(O000000o3) || "OM".equalsIgnoreCase(O000000o3) || "JO".equalsIgnoreCase(O000000o3)) {
            if ("chuangmi.camera.026c02".equals(str2)) {
                if ("en".equalsIgnoreCase(language)) {
                    licenseByModel = getLicenseByModel_International(resources, str);
                    privacyByModel = getPrivacyByModel_International(resources, str);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_ar_only);
                    privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_ar_only);
                }
            } else if ("en".equalsIgnoreCase(language)) {
                licenseByModel = getLicenseByModel(resources, str);
                privacyByModel = getPrivacyByModel(resources, str);
            } else if ("chuangmi.camera.021a04".equals(str2)) {
                licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_ar);
                privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_ar);
            } else if ("chuangmi.camera.029a02".equals(str2)) {
                licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_ar);
                privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_ar);
            } else {
                licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_ar);
                privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_ar);
            }
        } else if ("PK".equalsIgnoreCase(O000000o3) || "ZA".equalsIgnoreCase(O000000o3) || "KE".equalsIgnoreCase(O000000o3) || "PH".equalsIgnoreCase(O000000o3) || "LA".equalsIgnoreCase(O000000o3) || "KH".equalsIgnoreCase(O000000o3) || "AU".equalsIgnoreCase(O000000o3) || "NZ".equalsIgnoreCase(O000000o3)) {
            licenseByModel = getLicenseByModel_International(resources, str);
            privacyByModel = getPrivacyByModel_International(resources, str);
        } else if ("SG".equalsIgnoreCase(O000000o3)) {
            if ("chuangmi.camera.026c02".equals(str2)) {
                licenseByModel = getLicenseByModel_International(resources, str);
                privacyByModel = getPrivacyByModel_International(resources, str);
            } else {
                licenseByModel = getLicenseByModel(resources, str);
                privacyByModel = getPrivacyByModel(resources, str);
            }
        } else if (!"BY".equalsIgnoreCase(O000000o3)) {
            if ("DE".equalsIgnoreCase(O000000o3) || "AT".equalsIgnoreCase(O000000o3) || "LI".equalsIgnoreCase(O000000o3)) {
                if (!"en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_de);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_de);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_de);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_de);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_de);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_de);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_de);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_de);
                    }
                }
            } else if ("GR".equalsIgnoreCase(O000000o3)) {
                if ("chuangmi.camera.026c02".equals(str2)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_el);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_el);
                    }
                } else if (!"en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_el);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_el);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_el);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_el);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_el);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_el);
                    }
                }
            } else if ("ES".equalsIgnoreCase(O000000o3)) {
                if (!"en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_es);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_es);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_es);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_es);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_es);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_es);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_es);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_es);
                    }
                }
            } else if ("FR".equalsIgnoreCase(O000000o3)) {
                if (!"en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_gdpr_fr);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_gdpr_fr);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_fr);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_privacy_fr);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_fr);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_fr);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_fr);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_fr);
                    }
                }
            } else if ("NG".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel_International(resources, str);
                        privacyByModel = getPrivacyByModel_International(resources, str);
                    } else {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = getPrivacyByModel(resources, str);
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_fr);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_fr);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_license_fr);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_fr);
                } else if ("chuangmi.camera.026c02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_fr);
                    privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_fr);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_fr);
                    privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_fr);
                }
            } else if ("IL".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel_International(resources, str);
                        privacyByModel = getPrivacyByModel_International(resources, str);
                    } else {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = getPrivacyByModel(resources, str);
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_il);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_il);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_license_il);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_il);
                } else if ("chuangmi.camera.026c02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_ar_only);
                    privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_ar_only);
                }
            } else if ("HK".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if (!"chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = getPrivacyByModel(resources, str);
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_021a04_license_hk);
                    privacyByModel = cin.O000000o((int) R.raw.camera_021a04_privacy_hk);
                } else if ("chuangmi.camera.ipc021".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_hk);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_hk);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_zh_hk);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_zh_hk);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_hk);
                    privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_hk);
                }
            } else if ("ID".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if (!"chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = getPrivacyByModel(resources, str);
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_id);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_id);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_id);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_id);
                } else if ("chuangmi.camera.026c02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_id);
                    privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_id);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_id);
                    privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_id);
                }
            } else if ("IT".equalsIgnoreCase(O000000o3)) {
                if (!"en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_it);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_it);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_it);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_it);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_it);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_it);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_it);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_it);
                    }
                }
            } else if ("KR".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if (!"chuangmi.camera.026c02".equals(str2)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_gdpr_license_en);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_en_ko);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_license_en_ko);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_en_ko);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_en);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_en);
                        }
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_ko);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_ko);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_ko);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_ko);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_ko);
                    privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_ko);
                }
            } else if ("PL".equalsIgnoreCase(O000000o3)) {
                if (!"en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_pl);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_pl);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_pl);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_pl);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_pl);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_pl);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_pl);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_pl);
                    }
                }
            } else if ("PT".equalsIgnoreCase(O000000o3)) {
                if (!"en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_pt);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_pt);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_pt);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_pt);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_pt);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_pt);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_pt);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_pt);
                    }
                }
            } else if ("RU".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel_International(resources, str);
                        privacyByModel = getPrivacyByModel_International(resources, str);
                    } else {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = getPrivacyByModel(resources, str);
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_ru);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_ru);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_ru);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_ru);
                } else if ("chuangmi.camera.026c02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_ru);
                    privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_ru);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_ru);
                    privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_ru);
                }
            } else if ("TH".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel_International(resources, str);
                        privacyByModel = getPrivacyByModel_International(resources, str);
                    } else {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = getPrivacyByModel(resources, str);
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_th);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_th);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_th);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_th);
                } else if ("chuangmi.camera.026c02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_th);
                    privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_th);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_th);
                    privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_th);
                }
            } else if ("TR".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel_International(resources, str);
                        privacyByModel = getPrivacyByModel_International(resources, str);
                    } else {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = getPrivacyByModel(resources, str);
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_tr);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_tr);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_tr);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_tr);
                } else if ("chuangmi.camera.026c02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_tr);
                    privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_tr);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_tr);
                    privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_tr);
                }
            } else if ("TW".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if (!"chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = getPrivacyByModel(resources, str);
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_tw);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_tw);
                } else if ("chuangmi.camera.ipc021".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_tw);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_tw);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_zh_tw);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_zh_tw);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_tw);
                    privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_tw);
                }
            } else if ("UA".equalsIgnoreCase(O000000o3)) {
                if ("en".equalsIgnoreCase(language)) {
                    if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel_International(resources, str);
                        privacyByModel = getPrivacyByModel_International(resources, str);
                    } else {
                        licenseByModel = getGDPRLicenseByModel(resources, str);
                        privacyByModel = getGDPRPrivacyByModel(resources, str);
                    }
                } else if ("chuangmi.camera.021a04".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_uk);
                    privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_uk);
                } else if ("chuangmi.camera.029a02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_uk);
                    privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_uk);
                } else if ("chuangmi.camera.026c02".equals(str2)) {
                    licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_uk);
                    privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_uk);
                } else {
                    licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_uk);
                    privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_uk);
                }
            } else if (!"US".equalsIgnoreCase(O000000o3)) {
                if ("CN".equalsIgnoreCase(O000000o3)) {
                    if ("en".equalsIgnoreCase(language)) {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = getPrivacyByModel(resources, str);
                    } else {
                        if ("chuangmi.camera.ipc021".equals(str2)) {
                            O000000o2 = cin.O000000o((int) R.raw.camera_v4_license_cn_021);
                        } else if ("chuangmi.camera.021a04".equals(str2)) {
                            O000000o2 = cin.O000000o((int) R.raw.camera_v4_license_cn_021);
                        } else if ("chuangmi.camera.ip026c".equals(str2)) {
                            O000000o2 = cin.O000000o((int) R.raw.camera_v4_license_cn_026);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            O000000o2 = cin.O000000o((int) R.raw.camera_v4_license_cn_026c02);
                        } else if ("chuangmi.camera.ip029a".equals(str2)) {
                            O000000o2 = cin.O000000o((int) R.raw.camera_v4_license_cn_029);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            O000000o2 = cin.O000000o((int) R.raw.camera_v4_license_cn_029);
                        } else if ("chuangmi.camera.ipc022".equals(str2)) {
                            O000000o2 = cin.O000000o((int) R.raw.camera_v4_license_cn_022);
                        } else {
                            O000000o2 = cin.O000000o((int) R.raw.camera_v4_license_cn);
                        }
                        licenseByModel = O000000o2;
                        privacyByModel = "chuangmi.camera.ipc021".equals(str2) ? cin.O000000o((int) R.raw.camera_v4_privacy_cn_021) : "chuangmi.camera.021a04".equals(str2) ? cin.O000000o((int) R.raw.camera_v4_privacy_cn_021) : "chuangmi.camera.ip026c".equals(str2) ? cin.O000000o((int) R.raw.camera_v4_privacy_cn_026) : "chuangmi.camera.026c02".equals(str2) ? cin.O000000o((int) R.raw.camera_v4_privacy_cn_026c02) : "chuangmi.camera.ip029a".equals(str2) ? cin.O000000o((int) R.raw.camera_v4_privacy_cn_029) : "chuangmi.camera.029a02".equals(str2) ? cin.O000000o((int) R.raw.camera_v4_privacy_cn_029) : "chuangmi.camera.ipc022".equals(str2) ? cin.O000000o((int) R.raw.camera_v4_privacy_cn_022) : cin.O000000o((int) R.raw.camera_v4_privacy_cn);
                    }
                } else if ("NL".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_nl);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_nl);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_nl);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_nl);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_nl);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_nl);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_nl);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_nl);
                        }
                    }
                } else if ("CZ".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_cs);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_cs);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_cs);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_cs);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_cz);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_cz);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_cz);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_cz);
                        }
                    }
                } else if ("SK".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_sk);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_sk);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_sk);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_sk);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_sk);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_sk);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_sk);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_sk);
                        }
                    }
                } else if ("MM".equalsIgnoreCase(O000000o3)) {
                    if ("en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = getLicenseByModel_International(resources, str);
                            privacyByModel = getPrivacyByModel_International(resources, str);
                        } else {
                            licenseByModel = getLicenseByModel(resources, str);
                            privacyByModel = getPrivacyByModel(resources, str);
                        }
                    } else if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_my);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_my);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_my);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_my);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_my);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_my);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_my);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_my);
                    }
                } else if ("VN".equalsIgnoreCase(O000000o3)) {
                    if ("en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = getLicenseByModel_International(resources, str);
                            privacyByModel = getPrivacyByModel_International(resources, str);
                        } else {
                            licenseByModel = getLicenseByModel(resources, str);
                            privacyByModel = getPrivacyByModel(resources, str);
                        }
                    } else if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_vi);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_vi);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_vi);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_vi);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_vi);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_vi);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_vi);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_vi);
                    }
                } else if ("HR".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_en);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_en);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_hr);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_hr);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_hr);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_hr);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_hr);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_hr);
                        }
                    }
                } else if ("CH".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_ch);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_ch);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_license_ch);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_ch);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_ch);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_ch);
                        }
                    }
                } else if ("BE".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_belgium);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_belgium);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_license_belgium);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_belgium);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_belgium);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_belgium);
                        }
                    }
                } else if ("lu".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_lu);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_lu);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_license_lu);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_lu);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_lu);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_lu);
                        }
                    }
                } else if ("EE".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_et);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_et);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_et);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_et);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_et);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_et);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_ee);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_ee);
                        }
                    }
                } else if ("LV".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_lv);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_lv);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_lv);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_lv);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_lv);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_lv);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_lv);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_lv);
                        }
                    }
                } else if ("LT".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_lt);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_lt);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_lt);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_lt);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_lt);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_lt);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_lt);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_lt);
                        }
                    }
                } else if ("SI".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_sl);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_sl);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_sl);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_sl);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_sl);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_sl);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_si);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_si);
                        }
                    }
                } else if ("HU".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_hu);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_hu);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_hu);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_hu);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_hu);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_hu);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_009_license_hu);
                            privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_hu);
                        }
                    }
                } else if ("BG".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_bg);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_bg);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_bg);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_bg);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_bg);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_bg);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_009_license_bg);
                            privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_bg);
                        }
                    }
                } else if ("NO".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_no);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_no);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_no);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_no);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_no);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_no);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_009_license_no);
                            privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_no);
                        }
                    }
                } else if ("FI".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_fi);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_fi);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_fi);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_fi);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_fi);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_fi);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_009_license_fi);
                            privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_fi);
                        }
                    }
                } else if ("SE".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_sv);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_sv);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_sv);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_sv);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_sv);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_sv);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_009_license_sv);
                            privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_sv);
                        }
                    }
                } else if ("DK".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_da);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_da);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_da);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_da);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_da);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_da);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_009_license_da);
                            privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_da);
                        }
                    }
                } else if ("JP".equalsIgnoreCase(O000000o3)) {
                    if ("en".equalsIgnoreCase(language)) {
                        if (!"chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = getLicenseByModel(resources, str);
                            privacyByModel = getPrivacyByModel(resources, str);
                        }
                    } else if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_jp);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_jp);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_ja);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_ja);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_ja);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_ja);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_009_license_jp);
                        privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_jp);
                    }
                } else if ("BR".equalsIgnoreCase(O000000o3)) {
                    if ("en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = getLicenseByModel_International(resources, str);
                            privacyByModel = getPrivacyByModel_International(resources, str);
                        } else {
                            licenseByModel = getLicenseByModel(resources, str);
                            privacyByModel = getPrivacyByModel(resources, str);
                        }
                    } else if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_pt_br);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_pt_br);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_pt_br);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_pt_br);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_pt_br);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_pt_br);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_009_license_pt_br);
                        privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_pt_br);
                    }
                } else if ("IN".equalsIgnoreCase(O000000o3)) {
                    if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021a04_license_gdpr_in);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021a04_privacy_in);
                    } else if (!"en".equalsIgnoreCase(language)) {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_in);
                    } else if (!"chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = getLicenseByModel(resources, str);
                        privacyByModel = cin.O000000o((int) R.raw.camera_009_privacy_in);
                    }
                } else if ("RO".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_ro);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_ro);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_ro);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_ro);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_ro);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_ro);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_en);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_en);
                        }
                    }
                } else if ("IS".equalsIgnoreCase(O000000o3)) {
                    if (!"en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.021a04".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_is);
                            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_is);
                        } else if ("chuangmi.camera.029a02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_license_is);
                            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_is);
                        } else if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_is);
                            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_is);
                        } else {
                            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_en);
                            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_en);
                        }
                    }
                } else if ("MY".equalsIgnoreCase(O000000o3)) {
                    if ("en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = getLicenseByModel_International(resources, str);
                            privacyByModel = getPrivacyByModel_International(resources, str);
                        } else {
                            licenseByModel = getLicenseByModel(resources, str);
                            privacyByModel = getPrivacyByModel(resources, str);
                        }
                    } else if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_ms);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_ms);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_ms);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_ms);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_ms);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_ms);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_en);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_en);
                    }
                } else if ("MX".equalsIgnoreCase(O000000o3) || "PE".equalsIgnoreCase(O000000o3) || "CL".equalsIgnoreCase(O000000o3) || "AR".equalsIgnoreCase(O000000o3) || "CO".equalsIgnoreCase(O000000o3) || "PA".equalsIgnoreCase(O000000o3) || "SV".equalsIgnoreCase(O000000o3)) {
                    if ("en".equalsIgnoreCase(language)) {
                        if ("chuangmi.camera.026c02".equals(str2)) {
                            licenseByModel = getLicenseByModel_International(resources, str);
                            privacyByModel = getPrivacyByModel_International(resources, str);
                        } else {
                            licenseByModel = getLicenseByModel(resources, str);
                            privacyByModel = getPrivacyByModel(resources, str);
                        }
                    } else if ("chuangmi.camera.021a04".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_es_la);
                        privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_es_la);
                    } else if ("chuangmi.camera.029a02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_029a02_license_es_la);
                        privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_es_la);
                    } else if ("chuangmi.camera.026c02".equals(str2)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_es_la);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_es_la);
                    } else {
                        licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_en);
                        privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_en);
                    }
                } else if ("GB".equalsIgnoreCase(O000000o3) || "IE".equalsIgnoreCase(O000000o3) || "MT".equalsIgnoreCase(O000000o3)) {
                    licenseByModel = getGDPRLicenseByModel(resources, str);
                    privacyByModel = getGDPRPrivacyByModel(resources, str);
                } else if ("CY".equalsIgnoreCase(O000000o3)) {
                    if ("chuangmi.camera.026c02".equals(str2) && !TextUtils.equals("en", language)) {
                        licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_gdpr_el);
                        privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_el);
                    }
                }
            }
            licenseByModel = getGDPRLicenseByModel(resources, str);
            privacyByModel = getGDPRPrivacyByModel(resources, str);
        } else if ("en".equalsIgnoreCase(language)) {
            if ("chuangmi.camera.026c02".equals(str2)) {
                licenseByModel = getLicenseByModel_International(resources, str);
                privacyByModel = getPrivacyByModel_International(resources, str);
            } else {
                licenseByModel = getGDPRLicenseByModel(resources, str);
                privacyByModel = getGDPRPrivacyByModel(resources, str);
            }
        } else if ("chuangmi.camera.021a04".equals(str2)) {
            licenseByModel = cin.O000000o((int) R.raw.camera_ipc021_license_be);
            privacyByModel = cin.O000000o((int) R.raw.camera_ipc021_privacy_be);
        } else if ("chuangmi.camera.029a02".equals(str2)) {
            licenseByModel = cin.O000000o((int) R.raw.camera_029a02_gdpr_license_be_by);
            privacyByModel = cin.O000000o((int) R.raw.camera_029a02_privacy_be_by);
        } else if ("chuangmi.camera.026c02".equals(str2)) {
            licenseByModel = cin.O000000o((int) R.raw.camera_026c02_license_be_by);
            privacyByModel = cin.O000000o((int) R.raw.camera_026c02_privacy_be_by);
        } else {
            licenseByModel = cin.O000000o((int) R.raw.camera_v4_license_be);
            privacyByModel = cin.O000000o((int) R.raw.camera_v4_privacy_be);
        }
        LocalLicense localLicense = new LocalLicense(privacyByModel, licenseByModel, null);
        if ("CN".equalsIgnoreCase(O000000o3)) {
            if ("chuangmi.camera.ipc021".equals(str2)) {
                localLicense.mPlan = gpg.O000000o(resources2, (int) R.raw.camera_v4_plan_021);
            } else if ("chuangmi.camera.021a04".equals(str2)) {
                localLicense.mPlan = gpg.O000000o(resources2, (int) R.raw.camera_v4_plan_021);
            } else if ("chuangmi.camera.ip026c".equals(str2)) {
                localLicense.mPlan = gpg.O000000o(resources2, (int) R.raw.camera_v4_plan_026);
            } else if ("chuangmi.camera.026c02".equals(str2)) {
                localLicense.mPlan = gpg.O000000o(resources2, (int) R.raw.camera_v4_plan_026c02);
            } else if ("chuangmi.camera.ip029a".equals(str2)) {
                localLicense.mPlan = gpg.O000000o(resources2, (int) R.raw.camera_v4_plan_029);
            } else if ("chuangmi.camera.029a02".equals(str2)) {
                localLicense.mPlan = gpg.O000000o(resources2, (int) R.raw.camera_v4_plan_029);
            } else if ("chuangmi.camera.ipc022".equals(str2)) {
                localLicense.mPlan = gpg.O000000o(resources2, (int) R.raw.camera_v4_plan_022);
            } else {
                localLicense.mPlan = gpg.O000000o(resources2, (int) R.raw.camera_v4_plan);
            }
        }
        return localLicense;
    }

    private static int getLicenseByModel(Resources resources, String str) {
        if ("chuangmi.camera.ipc021".equals(str)) {
            return cin.O000000o((int) R.raw.camera_ipc021_license_en);
        }
        if ("chuangmi.camera.021a04".equals(str)) {
            return cin.O000000o((int) R.raw.camera_ipc021_license_en);
        }
        if ("chuangmi.camera.ip026c".equals(str)) {
            return cin.O000000o((int) R.raw.camera_v4_license_en_026);
        }
        if ("chuangmi.camera.026c02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_v4_license_en_026c02);
        }
        if ("chuangmi.camera.ip029a".equals(str)) {
            return cin.O000000o((int) R.raw.camera_v4_license_en_029);
        }
        if ("chuangmi.camera.029a02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_029a02_license_en);
        }
        if ("chuangmi.camera.ipc022".equals(str)) {
            return cin.O000000o((int) R.raw.camera_022_license_en);
        }
        return cin.O000000o((int) R.raw.camera_v4_license_en);
    }

    private static int getPrivacyByModel(Resources resources, String str) {
        if ("chuangmi.camera.ipc021".equals(str)) {
            return cin.O000000o((int) R.raw.camera_ipc021_privacy_en);
        }
        if ("chuangmi.camera.021a04".equals(str)) {
            return cin.O000000o((int) R.raw.camera_ipc021_privacy_en);
        }
        if ("chuangmi.camera.ip026c".equals(str)) {
            return cin.O000000o((int) R.raw.camera_v4_privacy_en_026);
        }
        if ("chuangmi.camera.026c02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_v4_privacy_en_026c02);
        }
        if ("chuangmi.camera.ip029a".equals(str)) {
            return cin.O000000o((int) R.raw.camera_v4_privacy_en_029);
        }
        if ("chuangmi.camera.029a02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_029a02_privacy_en);
        }
        if ("chuangmi.camera.ipc022".equals(str)) {
            return cin.O000000o((int) R.raw.camera_022_privacy_en);
        }
        return cin.O000000o((int) R.raw.camera_v4_privacy_en);
    }

    private static int getLicenseByModel_International(Resources resources, String str) {
        if ("chuangmi.camera.026c02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_026c02_license_en);
        }
        return cin.O000000o((int) R.raw.camera_v4_license_en);
    }

    private static int getPrivacyByModel_International(Resources resources, String str) {
        if ("chuangmi.camera.026c02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_026c02_privacy_en);
        }
        return cin.O000000o((int) R.raw.camera_v4_privacy_en);
    }

    private static int getGDPRLicenseByModel(Resources resources, String str) {
        if ("chuangmi.camera.021a04".equals(str)) {
            return cin.O000000o((int) R.raw.camera_ipc021_gdpr_license_en);
        }
        if ("chuangmi.camera.029a02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_029a02_gdpr_license_en);
        }
        if ("chuangmi.camera.026c02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_026c02_license_gdpr_en);
        }
        return cin.O000000o((int) R.raw.camera_v4_license_en);
    }

    private static int getGDPRPrivacyByModel(Resources resources, String str) {
        if ("chuangmi.camera.021a04".equals(str)) {
            return cin.O000000o((int) R.raw.camera_ipc021_gdpr_privacy_en);
        }
        if ("chuangmi.camera.029a02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_029a02_gdpr_privacy_en);
        }
        if ("chuangmi.camera.026c02".equals(str)) {
            return cin.O000000o((int) R.raw.camera_026c02_privacy_gdpr_en);
        }
        return cin.O000000o((int) R.raw.camera_v4_privacy_en);
    }

    public static void jumpToV3PrivacyPage(Context context, boolean z) {
        if (z) {
            CameraJumpUtils.openPluginLicenseActivity(context, context.getString(R.string.privacy_title), (z ? getV4LocalLicense(context.getResources()) : getV3LocalLicense(context.getResources())).mPrivacy);
        }
    }

    public static void jumpToV3UpgradePrivacyPage(Context context) {
        CameraJumpUtils.openPluginLicenseActivity(context, context.getString(R.string.privacy_title), getV3UpgradeLicense(context.getResources()).mPrivacy);
    }

    public static LocalLicense getV3UpgradeLicense(Resources resources) {
        Spanned spanned;
        Spanned spanned2;
        int i;
        int i2;
        String O000000o2 = ftl.O000000o();
        String language = resources.getConfiguration().locale.getLanguage();
        int O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
        int O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
        String O000000o5 = gpg.O000000o(resources, (int) R.raw.camera_v3_upgrade_plan);
        if ("CN".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_cn);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_cn);
            }
        } else if ("KR".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_ko_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_ko_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_ko);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_ko);
            }
        } else if ("GB".equalsIgnoreCase(O000000o2) || "IE".equalsIgnoreCase(O000000o2)) {
            O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
            O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
        } else if ("DE".equalsIgnoreCase(O000000o2) || "AT".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_de);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_de);
            }
        } else if ("ES".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_es);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_es);
            }
        } else if ("IT".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_it);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_it);
            }
        } else if ("FR".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_fr);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_fr);
            }
        } else if ("PL".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_pl);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_pl);
            }
        } else if ("BG".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_bg);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_bg);
            }
        } else if ("GR".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_el);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_el);
            }
        } else if ("FI".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_fi);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_fi);
            }
        } else if ("SE".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_sv);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_sv);
            }
        } else if ("DK".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_da);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_da);
            }
        } else if ("LT".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_lt);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_lt);
            }
        } else if ("EE".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_et);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_et);
            }
        } else if ("LV".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_lv);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_lv);
            }
        } else if ("PT".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_pt);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_pt);
            }
        } else if ("CZ".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_cs);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_cs);
            }
        } else if ("HU".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_hu);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_hu);
            }
        } else if ("SK".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_sk);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_sk);
            }
        } else if ("SI".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_sl);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_sl);
            }
        } else if ("NL".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_nl);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_nl);
            }
        } else if ("NO".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_no);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_no);
            }
        } else if ("UA".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_uk);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_uk);
            }
        } else if ("BY".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_be_by);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_be_by);
            }
        } else if ("BE".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_be);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_be);
            }
        } else if ("LU".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_lu);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_lu);
            }
        } else if ("CH".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_gdpr_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_gdpr_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_ch);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_ch);
            }
        } else if ("RU".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_ru);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_ru);
            }
        } else if ("TR".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_tr);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_tr);
            }
        } else if ("PK".equalsIgnoreCase(O000000o2) || "KE".equalsIgnoreCase(O000000o2) || "PH".equalsIgnoreCase(O000000o2) || "SG".equalsIgnoreCase(O000000o2) || "AU".equalsIgnoreCase(O000000o2) || "NZ".equalsIgnoreCase(O000000o2)) {
            O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
            O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
        } else if ("AE".equalsIgnoreCase(O000000o2) || "SA".equalsIgnoreCase(O000000o2) || "QA".equalsIgnoreCase(O000000o2) || "OM".equalsIgnoreCase(O000000o2) || "IQ".equalsIgnoreCase(O000000o2) || ("EG".equalsIgnoreCase(O000000o2) || "MA".equalsIgnoreCase(O000000o2))) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                Spanned O00000oO = cin.O00000oO(resources, R.raw.camera_v3_upgrade_license_ar);
                spanned2 = cin.O00000oO(resources, R.raw.camera_v3_upgrade_privacy_ar);
                spanned = O00000oO;
                i2 = 0;
                i = 0;
                return new LocalLicense(i2, i, O000000o5, spanned2, spanned);
            }
        } else if ("NG".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_fr);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_fr);
            }
        } else if ("BR".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_pt_br);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_pt_br);
            }
        } else if ("MX".equalsIgnoreCase(O000000o2) || "PE".equalsIgnoreCase(O000000o2) || "CL".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_es_la);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_es_la);
            }
        } else if ("TH".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_th);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_th);
            }
        } else if ("MM".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_my);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_my);
            }
        } else if ("VN".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_vi);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_vi);
            }
        } else if ("ID".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_id);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_id);
            }
        } else if ("MY".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_ms);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_ms);
            }
        } else if ("IL".equalsIgnoreCase(O000000o2)) {
            if ("en".equalsIgnoreCase(language)) {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_currency_en);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_currency_en);
            } else {
                O000000o3 = cin.O000000o((int) R.raw.camera_v3_upgrade_license_il);
                O000000o4 = cin.O000000o((int) R.raw.camera_v3_upgrade_privacy_il);
            }
        }
        i = O000000o3;
        spanned2 = null;
        spanned = null;
        i2 = O000000o4;
        return new LocalLicense(i2, i, O000000o5, spanned2, spanned);
    }
}
