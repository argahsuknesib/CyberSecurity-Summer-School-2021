package _m_j;

import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeResult;
import java.util.Locale;

public final class hbt implements GeocodeSearch.OnGeocodeSearchListener {
    public static boolean O000000o(Locale locale, Locale locale2) {
        if (locale == locale2) {
            return true;
        }
        return locale != null && locale2 != null && locale.getLanguage().equalsIgnoreCase(locale2.getLanguage()) && locale.getCountry().equalsIgnoreCase(locale2.getCountry());
    }

    public final void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        if (i == 1000 && regeocodeResult != null && regeocodeResult.getRegeocodeAddress() != null) {
            RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
            String str = regeocodeAddress.getCity() + regeocodeAddress.getDistrict() + regeocodeAddress.getTownship() + regeocodeAddress.getStreetNumber().getStreet();
            if (regeocodeAddress.getAois().size() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(regeocodeAddress.getAois().get(0).getAoiName());
            }
        }
    }

    public final void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
        if (geocodeResult != null && geocodeResult.getGeocodeAddressList() != null && geocodeResult.getGeocodeAddressList().size() > 0) {
            new hpv(geocodeResult.getGeocodeAddressList().get(0).getLatLonPoint());
        }
    }
}
