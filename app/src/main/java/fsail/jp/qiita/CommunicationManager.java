package fsail.jp.qiita;

import android.content.Context;
import android.util.Log;

import com.android.volley.*;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

/**
 * Created by kakizaki_shoichi on 2015/04/12.
 */
    public class CommunicationManager {
    private RequestQueue mQueue;
    private JSONArray mResponse;

    public JSONArray  getQiita(Context context) {
        // Volley でリクエスト
        mQueue = Volley.newRequestQueue(context);
        String url = "https://qiita.com/api/v2/items";
        mQueue.add(new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("Qiita","responzse : " + response.toString());
                        mResponse = response;
                    }
                }, null));
        return mResponse;
    }

}
