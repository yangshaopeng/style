package com.caesar.mystyle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button shapeBtn;
    private Button selectorBtn;
    private Button layerListBtn;
    private Button drawableBtn;
    private Button viewAnimBtn;
    private Button proteryAnimBtn;
    private Button styleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setClickListener();
    }

    private void initView() {
        shapeBtn = findViewById(R.id.shape);
        selectorBtn = findViewById(R.id.selector);
        layerListBtn = findViewById(R.id.layout_list);
        drawableBtn = findViewById(R.id.drawable);
        viewAnimBtn = findViewById(R.id.view_anim);
        proteryAnimBtn = findViewById(R.id.property_anim);
        styleBtn = findViewById(R.id.style);
    }

    private void setClickListener() {
        shapeBtn.setOnClickListener(this);
        selectorBtn.setOnClickListener(this);
        layerListBtn.setOnClickListener(this);
        drawableBtn.setOnClickListener(this);
        viewAnimBtn.setOnClickListener(this);
        proteryAnimBtn.setOnClickListener(this);
        styleBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shape:
                startActivity(new Intent(this, ShapeActivity.class));
                break;
            case R.id.property_anim:
                startActivity(new Intent(this, AnimtorActivity.class));
                break;
        }
    }
}
