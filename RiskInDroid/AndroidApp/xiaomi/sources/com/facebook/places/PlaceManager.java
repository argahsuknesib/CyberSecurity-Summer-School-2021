package com.facebook.places;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.places.internal.BluetoothScanResult;
import com.facebook.places.internal.LocationPackage;
import com.facebook.places.internal.LocationPackageManager;
import com.facebook.places.internal.LocationPackageRequestParams;
import com.facebook.places.internal.ScannerException;
import com.facebook.places.internal.WifiScanResult;
import com.facebook.places.model.CurrentPlaceFeedbackRequestParams;
import com.facebook.places.model.CurrentPlaceRequestParams;
import com.facebook.places.model.PlaceInfoRequestParams;
import com.facebook.places.model.PlaceSearchRequestParams;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlaceManager {

    public enum LocationError {
        LOCATION_PERMISSION_DENIED,
        LOCATION_SERVICES_DISABLED,
        LOCATION_TIMEOUT,
        UNKNOWN_ERROR
    }

    public interface OnRequestReadyCallback {
        void onLocationError(LocationError locationError);

        void onRequestReady(GraphRequest graphRequest);
    }

    private PlaceManager() {
    }

    public static void newPlaceSearchRequest(final PlaceSearchRequestParams placeSearchRequestParams, final OnRequestReadyCallback onRequestReadyCallback) {
        LocationPackageRequestParams.Builder builder = new LocationPackageRequestParams.Builder();
        builder.setWifiScanEnabled(false);
        builder.setBluetoothScanEnabled(false);
        LocationPackageManager.requestLocationPackage(builder.build(), new LocationPackageManager.Listener() {
            /* class com.facebook.places.PlaceManager.AnonymousClass1 */

            public final void onLocationPackage(LocationPackage locationPackage) {
                if (locationPackage.locationError == null) {
                    onRequestReadyCallback.onRequestReady(PlaceManager.newPlaceSearchRequestForLocation(placeSearchRequestParams, locationPackage.location));
                    return;
                }
                onRequestReadyCallback.onLocationError(PlaceManager.getLocationError(locationPackage.locationError));
            }
        });
    }

    public static GraphRequest newPlaceSearchRequestForLocation(PlaceSearchRequestParams placeSearchRequestParams, Location location) {
        String searchText = placeSearchRequestParams.getSearchText();
        if (location == null && searchText == null) {
            throw new FacebookException("Either location or searchText must be specified.");
        }
        int limit = placeSearchRequestParams.getLimit();
        Set<String> fields = placeSearchRequestParams.getFields();
        Set<String> categories = placeSearchRequestParams.getCategories();
        Bundle bundle = new Bundle(7);
        bundle.putString("type", "place");
        if (location != null) {
            bundle.putString("center", String.format(Locale.US, "%f,%f", Double.valueOf(location.getLatitude()), Double.valueOf(location.getLongitude())));
            int distance = placeSearchRequestParams.getDistance();
            if (distance > 0) {
                bundle.putInt("distance", distance);
            }
        }
        if (limit > 0) {
            bundle.putInt("limit", limit);
        }
        if (!Utility.isNullOrEmpty(searchText)) {
            bundle.putString("q", searchText);
        }
        if (categories != null && !categories.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (String put : categories) {
                jSONArray.put(put);
            }
            bundle.putString("categories", jSONArray.toString());
        }
        if (fields != null && !fields.isEmpty()) {
            bundle.putString("fields", TextUtils.join(",", fields));
        }
        return new GraphRequest(AccessToken.getCurrentAccessToken(), "search", bundle, HttpMethod.GET);
    }

    public static GraphRequest newPlaceInfoRequest(PlaceInfoRequestParams placeInfoRequestParams) {
        String placeId = placeInfoRequestParams.getPlaceId();
        if (placeId != null) {
            Bundle bundle = new Bundle(1);
            Set<String> fields = placeInfoRequestParams.getFields();
            if (fields != null && !fields.isEmpty()) {
                bundle.putString("fields", TextUtils.join(",", fields));
            }
            return new GraphRequest(AccessToken.getCurrentAccessToken(), placeId, bundle, HttpMethod.GET);
        }
        throw new FacebookException("placeId must be specified.");
    }

    public static void newCurrentPlaceRequest(final CurrentPlaceRequestParams currentPlaceRequestParams, final OnRequestReadyCallback onRequestReadyCallback) {
        Location location = currentPlaceRequestParams.getLocation();
        CurrentPlaceRequestParams.ScanMode scanMode = currentPlaceRequestParams.getScanMode();
        LocationPackageRequestParams.Builder builder = new LocationPackageRequestParams.Builder();
        builder.setLocationScanEnabled(location == null);
        if (scanMode != null && scanMode == CurrentPlaceRequestParams.ScanMode.LOW_LATENCY) {
            builder.setWifiActiveScanAllowed(false);
        }
        LocationPackageManager.requestLocationPackage(builder.build(), new LocationPackageManager.Listener() {
            /* class com.facebook.places.PlaceManager.AnonymousClass2 */

            public final void onLocationPackage(LocationPackage locationPackage) {
                if (locationPackage.locationError != null) {
                    onRequestReadyCallback.onLocationError(PlaceManager.getLocationError(locationPackage.locationError));
                    return;
                }
                onRequestReadyCallback.onRequestReady(new GraphRequest(AccessToken.getCurrentAccessToken(), "current_place/results", PlaceManager.getCurrentPlaceParameters(currentPlaceRequestParams, locationPackage), HttpMethod.GET));
            }
        });
    }

    public static GraphRequest newCurrentPlaceFeedbackRequest(CurrentPlaceFeedbackRequestParams currentPlaceFeedbackRequestParams) {
        String placeId = currentPlaceFeedbackRequestParams.getPlaceId();
        String tracking = currentPlaceFeedbackRequestParams.getTracking();
        Boolean wasHere = currentPlaceFeedbackRequestParams.wasHere();
        if (tracking == null || placeId == null || wasHere == null) {
            throw new FacebookException("tracking, placeId and wasHere must be specified.");
        }
        Bundle bundle = new Bundle(3);
        bundle.putString("tracking", tracking);
        bundle.putString("place_id", placeId);
        bundle.putBoolean("was_here", wasHere.booleanValue());
        return new GraphRequest(AccessToken.getCurrentAccessToken(), "current_place/feedback", bundle, HttpMethod.POST);
    }

    public static Bundle getCurrentPlaceParameters(CurrentPlaceRequestParams currentPlaceRequestParams, LocationPackage locationPackage) throws FacebookException {
        if (currentPlaceRequestParams != null) {
            if (locationPackage == null) {
                locationPackage = new LocationPackage();
            }
            if (locationPackage.location == null) {
                locationPackage.location = currentPlaceRequestParams.getLocation();
            }
            if (locationPackage.location != null) {
                try {
                    Bundle bundle = new Bundle(6);
                    bundle.putString("summary", "tracking");
                    int limit = currentPlaceRequestParams.getLimit();
                    if (limit > 0) {
                        bundle.putInt("limit", limit);
                    }
                    Set<String> fields = currentPlaceRequestParams.getFields();
                    if (fields != null && !fields.isEmpty()) {
                        bundle.putString("fields", TextUtils.join(",", fields));
                    }
                    Location location = locationPackage.location;
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("latitude", location.getLatitude());
                    jSONObject.put("longitude", location.getLongitude());
                    if (location.hasAccuracy()) {
                        jSONObject.put("accuracy", (double) location.getAccuracy());
                    }
                    if (location.hasAltitude()) {
                        jSONObject.put("altitude", location.getAltitude());
                    }
                    if (location.hasBearing()) {
                        jSONObject.put("heading", (double) location.getBearing());
                    }
                    if (location.hasSpeed()) {
                        jSONObject.put("speed", (double) location.getSpeed());
                    }
                    bundle.putString("coordinates", jSONObject.toString());
                    CurrentPlaceRequestParams.ConfidenceLevel minConfidenceLevel = currentPlaceRequestParams.getMinConfidenceLevel();
                    if (minConfidenceLevel == CurrentPlaceRequestParams.ConfidenceLevel.LOW || minConfidenceLevel == CurrentPlaceRequestParams.ConfidenceLevel.MEDIUM || minConfidenceLevel == CurrentPlaceRequestParams.ConfidenceLevel.HIGH) {
                        bundle.putString("min_confidence_level", minConfidenceLevel.toString().toLowerCase(Locale.US));
                    }
                    if (locationPackage != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("enabled", locationPackage.isWifiScanningEnabled);
                        WifiScanResult wifiScanResult = locationPackage.connectedWifi;
                        if (wifiScanResult != null) {
                            jSONObject2.put("current_connection", getWifiScanJson(wifiScanResult));
                        }
                        List<WifiScanResult> list = locationPackage.ambientWifi;
                        if (list != null) {
                            JSONArray jSONArray = new JSONArray();
                            for (WifiScanResult wifiScanJson : list) {
                                jSONArray.put(getWifiScanJson(wifiScanJson));
                            }
                            jSONObject2.put("access_points", jSONArray);
                        }
                        bundle.putString("wifi", jSONObject2.toString());
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("enabled", locationPackage.isBluetoothScanningEnabled);
                        List<BluetoothScanResult> list2 = locationPackage.ambientBluetoothLe;
                        if (list2 != null) {
                            JSONArray jSONArray2 = new JSONArray();
                            for (BluetoothScanResult next : list2) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("payload", next.payload);
                                jSONObject4.put("rssi", next.rssi);
                                jSONArray2.put(jSONObject4);
                            }
                            jSONObject3.put("scans", jSONArray2);
                        }
                        bundle.putString("bluetooth", jSONObject3.toString());
                    }
                    return bundle;
                } catch (JSONException e) {
                    throw new FacebookException(e);
                }
            } else {
                throw new FacebookException("A location must be specified");
            }
        } else {
            throw new FacebookException("Request and location must be specified.");
        }
    }

    private static JSONObject getWifiScanJson(WifiScanResult wifiScanResult) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("mac_address", wifiScanResult.bssid);
        jSONObject.put("ssid", wifiScanResult.ssid);
        jSONObject.put("signal_strength", wifiScanResult.rssi);
        jSONObject.put("frequency", wifiScanResult.frequency);
        return jSONObject;
    }

    public static LocationError getLocationError(ScannerException.Type type) {
        if (type == ScannerException.Type.PERMISSION_DENIED) {
            return LocationError.LOCATION_PERMISSION_DENIED;
        }
        if (type == ScannerException.Type.DISABLED) {
            return LocationError.LOCATION_SERVICES_DISABLED;
        }
        if (type == ScannerException.Type.TIMEOUT) {
            return LocationError.LOCATION_TIMEOUT;
        }
        return LocationError.UNKNOWN_ERROR;
    }
}
