package org.chzz.adapter;

import android.view.ViewGroup;
import android.widget.CompoundButton;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/10/7 下午8:35
 * 描述:AdapterView和RecyclerView的item中子控件选中状态变化事件监听器
 */
public interface CHZZOnItemChildCheckedChangeListener {
    void onItemChildCheckedChanged(ViewGroup parent, CompoundButton childView, int position, boolean isChecked);
}