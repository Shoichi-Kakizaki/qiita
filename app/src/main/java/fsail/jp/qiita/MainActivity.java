package fsail.jp.qiita;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

//import de.greenrobot.event.EventBus;


public class MainActivity extends Activity {

//    private final EventBus eventBus = EventBus.getDefault();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CommunicationManager com = new CommunicationManager();
        com.getQiita(this);

//        Qiita qiita = new Qiita();
//        qiita.createStatus(this);
//        qiita.title();
//        Log.d("qiita", String.valueOf(qiita.title()));

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        eventBus.register(this);
//    }
//
//    @Override
//    protected void onPause() {
//        eventBus.unregister(this);
//        super.onPause();
//    }

//        // リストビューに表示するためのデータを設定
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
//        adapter.add("sample1");
//        adapter.add("sample2");
//        adapter.add("sample3");
//        ListView qiitaList = (ListView)findViewById(R.id.listView1);
//        qiitaList.setAdapter(adapter);
//
//        //リスト項目が選択された時のイベントを追加
//        qiitaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String msg = position + "番目のアイテムがクリックされました";
//                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
//            }
//        });

}