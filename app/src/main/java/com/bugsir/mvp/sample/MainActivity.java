package com.bugsir.mvp.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.bugsir.mvp.R;
import com.bugsir.mvp.sample.okgo.OkgoTestPresenter;

public class MainActivity extends AppCompatActivity implements ITestView , View.OnClickListener {
    private OkgoTestPresenter mOkgoPresenter;
    private Button mBtnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mOkgoPresenter = new OkgoTestPresenter();
        mOkgoPresenter.onAttach(this);
    }

    private void initView() {

        mBtnTest = findViewById(R.id.btn_test);
    }

    @Override
    public void requestSuccess() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mOkgoPresenter.stopRequest();
        mOkgoPresenter.onDettach();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.btn_test:
                mOkgoPresenter.getData();
                break;
            default:
                break;
        }
    }
}
