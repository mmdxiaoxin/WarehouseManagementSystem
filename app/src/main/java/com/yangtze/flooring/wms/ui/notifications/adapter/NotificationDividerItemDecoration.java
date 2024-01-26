package com.yangtze.flooring.wms.ui.notifications.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.ColorInt;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationDividerItemDecoration extends RecyclerView.ItemDecoration {

    private final int dividerHeight;
    private final Paint paint;

    public NotificationDividerItemDecoration(Context context, int dividerHeight, @ColorInt int dividerColor) {
        this.dividerHeight = dividerHeight;
        paint = new Paint();
        paint.setColor(dividerColor);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        // 设置每个 item 底部的偏移，即分隔线的高度
        outRect.bottom = dividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);
            int top = child.getBottom();
            int bottom = top + dividerHeight;
            c.drawRect(left, top, right, bottom, paint);
        }
    }
}

