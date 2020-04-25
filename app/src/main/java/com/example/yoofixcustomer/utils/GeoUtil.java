package com.example.yoofixcustomer.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class GeoUtil {
    public static String getGeoAddress(Context context, Locale locale, double lat, double lng) {
        try {
            Geocoder geo = new Geocoder(context, locale);
            List<Address> addresses = geo.getFromLocation(lat, lng, 1);
            if (addresses.isEmpty()) {
                return "";
            } else {
                Address address = addresses.get(0);
                return address.getFeatureName() + ", " + address.getLocality() + ", " + address.getAdminArea() + " " + address.getPostalCode() + ", " + address.getCountryName();
            }
        } catch (Exception e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT);
        }

        return null;
    }
}
