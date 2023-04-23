package com.example.cspace.workers;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;

public class JokeWorker extends Worker {

    public JokeWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public Result doWork() {
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        String url = "https://v2.jokeapi.dev/joke/Programming?blacklistFlags=nsfw,religious,political,racist,sexist,explicit&type=single";
        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String joke = null;
                        try {
                            joke = response.getString("joke");
                            SharedPreferences prefs = getApplicationContext().getSharedPreferences("joke_prefs", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("joke_text", joke).apply();
                            editor.commit();
                        } catch (JSONException e) {
                            e.getMessage();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Result.retry();
                    }
                });
        queue.add(request);
        return Result.success();
    }

    @Override
    public void onStopped() {
        super.onStopped();
        // Retry the request if it fails
        Result.retry();
    }
}

