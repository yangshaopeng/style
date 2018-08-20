package com.caesar.mystyle;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AnimtorActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animtor);
        button = findViewById(R.id.anim_btn);
    }

    public void scaleWidth(View view) {

        //1.多个动画  一起同时  执行
        /*PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("alpha", 1, 0.5f, 1f);
        PropertyValuesHolder holder2 = PropertyValuesHolder.ofFloat("scaleX", 1, 0.5f, 1f);
        PropertyValuesHolder holder3 = PropertyValuesHolder.ofFloat("scaleY", 1, 0.5f, 1f);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(button, holder1, holder2, holder3);
        objectAnimator.setDuration(1500);
        objectAnimator.start();*/

        /*ObjectAnimator animator1 = ObjectAnimator.ofFloat(view, "alpha", 1f, 0.3f, 1f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.3f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.3f, 1f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(animator1, animator2, animator3);
        animatorSet.playTogether(animator1, animator2, animator3);
        animatorSet.setDuration(2000);
        animatorSet.start();*/

        //抛物线效果
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setDuration(4000);
        valueAnimator.setObjectValues(new PointF(0, 0));
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            @Override
            public PointF evaluate(float v, PointF o, PointF t1) {
                PointF pointF = new PointF();
                pointF.x = 100 * (4 * v); //V * T
                pointF.y = 0.5f * 9.8f * (4 * v) * (4 * v);
                return pointF;
            }
        });

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                PointF pointF = (PointF) valueAnimator.getAnimatedValue();
                button.setX(pointF.x);
                button.setY(pointF.y);
            }
        });

        valueAnimator.start();

    }
}
