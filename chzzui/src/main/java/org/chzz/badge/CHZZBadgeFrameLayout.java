/**
 * Copyright 2015 bingoogolapple
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.chzz.badge;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * 作者:copy 邮件:2499551993@qq.com
 * 创建时间:15/7/7 14:07
 * 描述:
 */
public class CHZZBadgeFrameLayout extends FrameLayout implements CHZZBadgeable {
    private CHZZBadgeViewHelper mBadgeViewHeler;

    public CHZZBadgeFrameLayout(Context context) {
        this(context, null);
    }

    public CHZZBadgeFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CHZZBadgeFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mBadgeViewHeler = new CHZZBadgeViewHelper(this, context, attrs, CHZZBadgeViewHelper.BadgeGravity.RightCenter);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mBadgeViewHeler.onTouchEvent(event);
    }

    @Override
    public boolean callSuperOnTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mBadgeViewHeler.drawBadge(canvas);
    }

    @Override
    public void showCirclePointBadge() {
        mBadgeViewHeler.showCirclePointBadge();
    }

    @Override
    public void showTextBadge(String badgeText) {
        mBadgeViewHeler.showTextBadge(badgeText);
    }

    @Override
    public void hiddenBadge() {
        mBadgeViewHeler.hiddenBadge();
    }

    @Override
    public void showDrawableBadge(Bitmap bitmap) {
        mBadgeViewHeler.showDrawable(bitmap);
    }

    @Override
    public void setDragDismissDelegage(CHZZDragDismissDelegate delegate) {
        mBadgeViewHeler.setDragDismissDelegage(delegate);
    }

    @Override
    public boolean isShowBadge() {
        return mBadgeViewHeler.isShowBadge();
    }

    @Override
    public CHZZBadgeViewHelper getBadgeViewHelper() {
        return mBadgeViewHeler;
    }
}