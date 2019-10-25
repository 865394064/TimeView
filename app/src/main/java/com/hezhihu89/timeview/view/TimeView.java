package com.hezhihu89.timeview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hezhihu89.timeview.R;


public class TimeView extends TextView {

    private long hours;
    private long minutes;
    private long seconds;
    private long diff;
    private long days;
    private long time = 0;
    public TimeView(Context context) {
        this(context, null);
    }
    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TimeView);
        diff = a.getInteger(R.styleable.TimeView_time, 0) * 1000;
        onCreate();
    }
    private void onCreate() {
        //start();
        setText(0 + ":" + 0 + ":" + 0 + ":" + 00);
    }
    private void start() {
        handler.removeMessages(1);
        getTime();
        Message message = handler.obtainMessage(1);
        handler.sendMessageDelayed(message, 1000);
    }

    public void log() {
    }
    public void setTime(long time) {
        this.time = time * 1000;
    }

    final Handler handler = new Handler(Looper.getMainLooper()) {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    setVisibility(View.VISIBLE);
                    diff = diff + 1000;
                    getShowTime();
                  //  if (diff > 0) {
                        Message message = handler.obtainMessage(1);
                        handler.sendMessageDelayed(message, 1000);
                    //} else {
                    //    setVisibility(View.GONE);
                   // }
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };
    public void stop() {
        handler.removeMessages(1);
    }
    /**
     * 得到时间差
     */
    private void getTime() {
        try {
            days = diff / (1000 * 60 * 60 * 24);
            hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            seconds = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60) - minutes * (1000 * 60)) / (1000);
            setText(days + ":" + hours + ":" + minutes + ":" + seconds);
        } catch (Exception e) {
        }
    }
    private void getShowTime() {
        days = diff / (1000 * 60 * 60 * 24);
        hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
        seconds = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60) - minutes * (1000 * 60)) / (1000);
        setText(days + ":" + hours + ":" + minutes + ":" + seconds);
    }
    public void reStart() {
        this.diff = this.time;
        start();
    }
    public void reStart(long time) {
        if (time > 0) {
            this.diff = time * 1000;
            Log.d("TAG", "+=========================" + diff);
        }
        start();
    }

}
