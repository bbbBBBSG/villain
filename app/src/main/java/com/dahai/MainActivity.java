package com.dahai;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.villain.Villain;

/**
 * 描述：
 * 时间：2020/6/20/020
 * 作者：xjh
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Villain.init(this);
    }
}
