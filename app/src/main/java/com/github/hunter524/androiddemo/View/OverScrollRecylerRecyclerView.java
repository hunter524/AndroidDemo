package com.github.hunter524.androiddemo.View;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by hunter on 2016/9/21.
 */

public class OverScrollRecylerRecyclerView extends RecyclerView {
    public OverScrollRecylerRecyclerView(Context context) {
        super(context);
    }

    public OverScrollRecylerRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public OverScrollRecylerRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        return super.onTouchEvent(e);
    }
}
