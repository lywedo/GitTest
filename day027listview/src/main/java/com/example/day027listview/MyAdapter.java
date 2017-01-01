package com.example.day027listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 16/11/15/0015.
 */
public class MyAdapter extends BaseAdapter{
    LayoutInflater inflater;
    List<MsgBean> data;

    public MyAdapter(List<MsgBean> data, Context context) {
        this.data = data;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        int type=data.get(position).type;
        switch (type){
            case 1:
                return 0;
            case 2:
                return 1;
        }
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MsgBean bean = data.get(position);
        int type = getItemViewType(position);
        switch (type){
            case 0:
                ViewHolderCome holderCome;
                if (convertView==null){
                    convertView=inflater.inflate(R.layout.come,parent,false);
                    holderCome=new ViewHolderCome(convertView);
                    convertView.setTag(holderCome);
                }else{
                    holderCome= (ViewHolderCome) convertView.getTag();
                }
                holderCome.tv_come.setText(bean.content);
                return convertView;
            case 1:
                ViewHolderTo holderTo;
                if (convertView==null){
                    convertView=inflater.inflate(R.layout.to,parent,false);
                    holderTo=new ViewHolderTo(convertView);
                    convertView.setTag(holderTo);
                }else{
                    holderTo= (ViewHolderTo) convertView.getTag();
                }
                holderTo.tv_go.setText(bean.content);
                return convertView;

        }
        return null;
    }
    class ViewHolderCome{
        TextView tv_come;
        public ViewHolderCome(View view) {
            tv_come= (TextView) view.findViewById(R.id.tv_come);
        }
    }
    class ViewHolderTo{
        TextView tv_go;
        public ViewHolderTo(View view) {
            tv_go= (TextView) view.findViewById(R.id.tv_to);
        }
    }
}
