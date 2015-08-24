package fsail.jp.qiita.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import fsail.jp.qiita.R;

/**
 * Created by kakizaki_shoichi on 2015/08/24.
 * ProjectName Qiita
 */

public class Header extends Fragment {

    @InjectView(R.id.backMain)
    TextView mBackMain;

    /*interfaceを設定してActivityで呼べるようにする*/
    public interface OnClickListener {
        public void backBrowserTransaction();
    }

    private View mV;
    private Activity mActivity;
    private OnClickListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mV = inflater.inflate(R.layout.fragment_header, container, false);
        ButterKnife.inject(this, mV);
        return mV;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
        if (activity instanceof OnClickListener == false) {
            throw new ClassCastException("activity が OnOkBtnClickListener を実装していません.");
        }
        mListener = ((OnClickListener) activity);
    }

    @Override
    public void onStart() {
        super.onStart();
        // ボタンの設定
        mBackMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.backBrowserTransaction();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}