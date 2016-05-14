package org.chzz.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * ============================================================
 * 版权 ：深圳市医友智能技术有限公司 版权所有 (c)   2016/5/14
 * 作者:copy   xiaoxinxing12@qq.com
 * 版本 ：1.0
 * 创建日期 ： 2016/5/14--17:03
 * 描述 ：
 * 修订历史 ：
 * ============================================================
 **/
public class CHZZScrollView extends ScrollView {

    private ScrollListener mListener;

    public static interface ScrollListener {
        public void scrollOritention(int oritention);

        boolean onTouch(View v, MotionEvent event);
    }

    /**
     * ScrollView正在向上滑动
     */
    public static final int SCROLL_UP = 0x01;

    /**
     * ScrollView正在向下滑动
     */
    public static final int SCROLL_DOWN = 0x10;

    /**
     * 最小的滑动距离
     */
    private static final int SCROLLLIMIT = 40;

    public CHZZScrollView(Context context) {
        super(context, null);
    }

    public CHZZScrollView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public CHZZScrollView(Context context, AttributeSet attrs,
                          int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        if (oldt > t && oldt - t > SCROLLLIMIT) {// 向下
            if (mListener != null)
                mListener.scrollOritention(SCROLL_DOWN);
        } else if (oldt < t && t - oldt > SCROLLLIMIT) {// 向上
            if (mListener != null)
                mListener.scrollOritention(SCROLL_UP);
        }
    }

    public void setScrollListener(ScrollListener l) {
        this.mListener = l;
    }
}
