package fsail.jp.qiita;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by kakizaki_shoichi on 2015/05/06.
 */
public class AsyncEvent {

    private boolean mSuccess;
    private JSONArray mResponseAry;
    private JSONObject mResponseObj;

    // JSONArray用のコンストラクタ
    public AsyncEvent(boolean success, JSONArray response) {
        mSuccess = success;
        mResponseAry = response;
    }

    // JSONObject用のコンストラクタ
    public AsyncEvent(boolean success, JSONObject response) {
        mSuccess = success;
        mResponseObj = response;
    }

    public boolean isSuccess(){
        return mSuccess;
    }

    public JSONArray qiita() {
        return mResponseAry;
    }

}
