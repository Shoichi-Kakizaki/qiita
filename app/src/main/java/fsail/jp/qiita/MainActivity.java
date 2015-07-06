package fsail.jp.qiita;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

import de.greenrobot.event.EventBus;


public class MainActivity extends Activity {

    private final EventBus eventBus = EventBus.getDefault();
    private ArrayList<String> mTitles = new ArrayList<String>();
    private ArrayList<String> mUris = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CommunicationManager qiita = new CommunicationManager();
        qiita.getQiita(this);

    }

    public void onEvent(AsyncQiita event) {
        mTitles = event.title();
        mUris = event.uri();
        showList();
    }

    public void showList(){
        // リストビューに表示するためのデータを設定
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        for (String title: mTitles) {
            adapter.add(title);
        }
        ListView qiitaList = (ListView)findViewById(R.id.listView1);
        qiitaList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        eventBus.register(this);
    }

    @Override
    protected void onPause() {
        eventBus.unregister(this);
        super.onPause();
    }



}