package com.coolweather.android.util;
import android.text.TextUtils;

import com.coolweather.android.db.City;
import com.coolweather.android.db.County;
import com.coolweather.android.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    public static boolean handleProvinceResp(String jsonStr){
        if (!TextUtils.isEmpty(jsonStr)){
            try {
                JSONArray array=new JSONArray(jsonStr);
                for (int i = 0; i<array.length(); i++){
                    JSONObject jsonObject = array.getJSONObject(1);
                    Province province=new Province();
                    province.setProvinceCode(jsonObject.getInt("id"));
                    province.setProvinceName(jsonObject.getString("name"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCityResp(String jsonStr,int provinceId){
        if (!TextUtils.isEmpty(jsonStr)){
            try {
                JSONArray array=new JSONArray(jsonStr);
                for (int i = 0; i<array.length(); i++){
                    JSONObject jsonObject = array.getJSONObject(1);
                    City city =new City();
                    city.setCityCode(jsonObject.getInt("id"));
                    city.setCityName(jsonObject.getString("name"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCountyResp(String jsonStr,int cityId){
        if (!TextUtils.isEmpty(jsonStr)){
            try {
                JSONArray array=new JSONArray(jsonStr);
                for (int i = 0; i<array.length(); i++){
                    JSONObject jsonObject = array.getJSONObject(1);
                    County county=new County();
                    county.setCountyName(jsonObject.getString("name"));
                    county.setCityId(cityId);
                    county.setWeatherId(jsonObject.getString("weather_id"));
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
