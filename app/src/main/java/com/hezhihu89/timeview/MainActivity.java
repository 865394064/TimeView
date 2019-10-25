package com.hezhihu89.timeview;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ToggleButton;

import com.hezhihu89.timeview.view.TimeView;

public class MainActivity extends AppCompatActivity {
    private TimeView timeView;
    ToggleButton t1,t2;
    Object a=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /// t1=(ToggleButton)this.findViewById(R.id.to1);
        //t2=(ToggleButton)this.findViewById(R.id.to2);
       // t1.setChecked(true);
        //timeView = (TimeView) findViewById(R.id.time_demo);
       // timeView.setTime(60);
      //  if("".equals("")){
//
        creatdialog();
        }
    public void update(View view) {
        timeView.reStart(0);
    }


    public void update1(View view) {
        //回到设置的事件
       timeView.reStart();
        timeView.stop();
    }
    AlertDialog dialog;
    public void creatdialog(){
        if(dialog==null){
            View view = View.inflate(this, R.layout.layouttes, null);
            //view.setBackground(new ColorDrawable(Color.TRANSPARENT));
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            dialog = builder.setView(view).create();
            //dialog.setIcon(new ColorDrawable(Color.TRANSPARENT));
        }
        dialog.show();

    }

}
