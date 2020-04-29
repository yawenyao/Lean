package com.example.lean.volley;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.AnyThread;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lean.MainActivity;
import com.example.lean.pixabay.PhotoItem;
import com.example.lean.pixabay.Pictureforurl;
import com.example.lean.ui.memory.DetailActivity;
import com.google.gson.Gson;

public class GetPhotoUrl {

    public GetPhotoUrl() {
    }

    public static String getPhotoUrl() {
        return photoUrl;
    }

    private static String photoUrl;

    public static void setUrl(String url) {
        GetPhotoUrl.url = url;
    }

    private static String url;

@AnyThread
    public  void volleyStringRequestGet() {
        url = DetailActivity.getWebUrl();
    System.out.println(DetailActivity.getWebUrl()+"6666666666666666666666666666666666666666666666666666666666666666666666");
        // 这是StringRequest的请求方式
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    // 请求成功的回调
                    @Override
                    public void onResponse(String arg0) {


                        Gson gson = new Gson();
                        Pictureforurl pictureforurl = gson.fromJson(arg0, Pictureforurl.class);
                        if(!pictureforurl.getHits().isEmpty()){
                            PhotoItem photoItem = pictureforurl.getHits().get(1);
                            photoUrl = photoItem.getWebformatURL();
                        }
                        else {

                        }
                        Log.e("TAGSuccess", arg0);
                    }
                }, new Response.ErrorListener() {
            // 请求失败的回调
            @Override
            public void onErrorResponse(VolleyError arg0) {
                Log.e("TAG", arg0.toString());
            }
        });
        // 将请求添加到请求队列中
        MyApplication.getHttpQueues().add(request);
    }

}
