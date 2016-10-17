package com.heihei.hehe.supertoast;

import android.app.Application;
import android.content.Context;

/**
 * Describe the function of the class
 *
 * @author zhujinlong@ichoice.com
 * @date 2016/10/17
 * @time 15:52
 * @description Describe the place where the class needs to pay attention.
 */
public class App extends Application {

    private static Context context;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        context = base;
    }

    public static Context getContext(){
        return context;
    }
}
