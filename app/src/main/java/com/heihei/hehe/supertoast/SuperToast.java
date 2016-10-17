package com.heihei.hehe.supertoast;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 自定义toast(单利模式，支持3种状态)
 *
 * @author zhujinlong@ichoice.com
 * @date 2016/10/16
 * @time 7:40
 * @description Describe the place where the class needs to pay attention.
 */
public class SuperToast extends Toast {

    private TextView message;
    private ImageView image;

    private SuperToast(Context context) {
        super(context);
        setDuration(Toast.LENGTH_SHORT);
    }

    volatile static SuperToast toast;

    public synchronized static SuperToast init() {
        if (toast == null) {
            synchronized (SuperToast.class) {
                if (toast == null) {
                    toast = new SuperToast(App.getContext());
                }
            }
        }
        return toast;
    }

    public SuperToast duration(int duration) {
        super.setDuration(duration);
        return this;
    }

    public void textNormal(CharSequence s){
        text(s,0);
    }

    public void textSuccess(CharSequence s){
        text(s,1);
    }

    public void textError(CharSequence s){
        text(s,2);
    }

    private void text(CharSequence s, int type){
        if(getView() == null){
            View v = View.inflate(App.getContext(),R.layout.default_toast, null);
            image = (ImageView) v.findViewById(R.id.image);
            message = (TextView)v.findViewById(R.id.message);
            setView(v);
        }
        if(type == 0 && image.getVisibility() != View.GONE){
            image.setVisibility(View.GONE);
        }else if(type == 1){
            if(image.getVisibility() != View.VISIBLE){
                image.setVisibility(View.VISIBLE);
            }
            image.setImageResource(android.R.drawable.stat_notify_chat);
        }else if(type == 2){
            if(image.getVisibility() != View.VISIBLE){
                image.setVisibility(View.VISIBLE);
            }
            image.setImageResource(android.R.drawable.stat_notify_error);
        }
        message.setText(s);
        show();
    }
}