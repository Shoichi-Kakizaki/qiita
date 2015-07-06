package fsail.jp.qiita;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * Created by kakizaki_shoichi on 2015/05/06.
 */
public class Qiita {
    private Context mContext;
    private JSONArray mQiita;
    private ArrayList<String> mTitle = new ArrayList<String>();
    private ArrayList<String> mUrl = new ArrayList<String>();

    private final EventBus eventBus = EventBus.getDefault();



    public void createStatus(Context context) {
        mContext = context;
        CommunicationManager qiitaResponse = new CommunicationManager();
        qiitaResponse.getQiita(context);

    }

    public void onEvent(AsyncEvent event) {
        if (event.isSuccess()) {
            JSONArray response = event.qiita();
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject qiita = (JSONObject) response.get(i);
                    mTitle.add(qiita.getString("title"));
                    mUrl.add(qiita.getString("url"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Log.d("qiita", "My model async task is failure");
        }
    }




    public ArrayList title() {
        return mTitle;
    }

    public ArrayList uri() {
        return mUrl;
    }

}
