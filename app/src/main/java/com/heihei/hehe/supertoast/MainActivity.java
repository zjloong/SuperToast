package com.heihei.hehe.supertoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toast(View v){
        if(i % 3 == 0){
            SuperToast.init().textNormal("a");
        }else if(i % 3 == 1){
            SuperToast.init().textSuccess("呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵呵");
        }else {
            SuperToast.init().textError("addafhsdhshashsdhsgahshsh");
        }
        i++;
    }
}
