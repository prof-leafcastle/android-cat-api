package dk.au.orbitlab.android.catapi;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class CatFetcher {

    private static final String randomCatsUrl = "https://aws.random.cat/meow";

    RequestQueue queue;
    ICatApp catApp;

    public CatFetcher(ICatApp catApp) {
        this.catApp = catApp;
    }

    public void getRandomCat(){
        sendRequest(randomCatsUrl);
    }

    private void sendRequest(String url){
        if(queue==null){
            queue = Volley.newRequestQueue(catApp.getContext());
        }

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        parseCatJson(response);
                    }
                }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("MAIN", "That did not work!", error);
                }
        });

        queue.add(stringRequest);
    }

    private void parseCatJson(String json){
        Gson gson = new GsonBuilder().create();
        Cat cat =  gson.fromJson(json, Cat.CatResponse.class).getCat();
        if(cat!=null){
            catApp.onCatFetched(cat);
        }
    }
}
