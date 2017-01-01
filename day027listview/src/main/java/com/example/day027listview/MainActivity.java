package com.example.day027listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<MsgBean> data=new ArrayList<>();
    MyAdapter adapter;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lv);
        for (int i = 0; i < 100; i++) {
            MsgBean bean=new MsgBean();
            if (i%2==0){
                bean.type=MsgBean.COME;
                bean.content="fuck";
            }else{
                bean.type=MsgBean.TO;
                bean.content="shit";
            }
            data.add(bean);
        }
        adapter=new MyAdapter(data,this);
        lv.setAdapter(adapter);
    }
}
