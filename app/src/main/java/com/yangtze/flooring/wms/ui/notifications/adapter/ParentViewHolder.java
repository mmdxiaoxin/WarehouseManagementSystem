package com.yangtze.flooring.wms.ui.notifications.adapter;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.yangtze.flooring.wms.R;
import com.yangtze.flooring.wms.model.DataBean;


/**
 * 父布局ViewHolder
 */

public class ParentViewHolder extends BaseViewHolder {

    private Context mContext;
    private View view;
    private RelativeLayout containerLayout;
    private TextView parentLeftNameView;
    private TextView parentRightCategoryView;
    private TextView parentRightQuantityView;
    private ImageView expand;
    private View parentDashedView;

    public ParentViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        this.view = itemView;
    }

    public void bindView(final DataBean dataBean, final int pos, final ItemClickListener listener){
        //初始化控件
        containerLayout = (RelativeLayout) view.findViewById(R.id.container);
        parentLeftNameView = (TextView) view.findViewById(R.id.parent_left_text_name);
        parentRightCategoryView = (TextView) view.findViewById(R.id.parent_right_text_category);
        parentRightQuantityView = (TextView) view.findViewById(R.id.parent_right_text_quantity);

        expand = (ImageView) view.findViewById(R.id.expend);
        parentDashedView = view.findViewById(R.id.parent_dashed_view);
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) expand
                .getLayoutParams();
        expand.setLayoutParams(params);
        parentLeftNameView.setText(dataBean.getParentLeftTxtName());
        parentRightCategoryView.setText(dataBean.getParentRightTxtCategory());
        parentRightQuantityView.setText(dataBean.getParentRightTxtQuantity());

        if (dataBean.isExpand()) {
            expand.setRotation(90);
            parentDashedView.setVisibility(View.INVISIBLE);
        } else {
            expand.setRotation(0);
            parentDashedView.setVisibility(View.VISIBLE);
        }

        //父布局OnClick监听
        containerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    if (dataBean.isExpand()) {
                        listener.onHideChildren(dataBean);
                        parentDashedView.setVisibility(View.VISIBLE);
                        dataBean.setExpand(false);
                        rotationExpandIcon(90, 0);
                    } else {
                        listener.onExpandChildren(dataBean);
                        parentDashedView.setVisibility(View.INVISIBLE);
                        dataBean.setExpand(true);
                        rotationExpandIcon(0, 90);
                    }
                }
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void rotationExpandIcon(float from, float to) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            ValueAnimator valueAnimator = ValueAnimator.ofFloat(from, to);//属性动画
            valueAnimator.setDuration(500);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    expand.setRotation((Float) valueAnimator.getAnimatedValue());
                }
            });
            valueAnimator.start();
        }
    }
}
