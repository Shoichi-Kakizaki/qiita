package fsail.jp.qiita.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import fsail.jp.qiita.R;

/**
 * Created by kakizaki_shoichi on 2015/08/24.
 * ProjectName Qiita
 */

public class Content extends Fragment {

    @InjectView(R.id.webView1)
    WebView mWebView;

    private View mV;
    private Activity mActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mV = inflater.inflate(R.layout.fragment_content, container, false);
        ButterKnife.inject(this, mV);
        return mV;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }

    @Override
    public void onStart() {
        super.onStart();
        Intent intent = mActivity.getIntent();
        mWebView.loadUrl(intent.getStringExtra("uri"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}