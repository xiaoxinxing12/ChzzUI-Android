package org.chzz.demo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/8/10
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/8/10--12:44
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class CheckBoxAdapter extends BaseAdapter{

    private Context mContext;
    private List<String> mList=new ArrayList<>();

    public CheckBoxAdapter(Context context) {
        mContext = context;
        mList.add("1");
        mList.add("3");
        mList.add("4");
        mList.add("5");
        mList.add("5");
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 5;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return new CheckBox(mContext);
    }
}
