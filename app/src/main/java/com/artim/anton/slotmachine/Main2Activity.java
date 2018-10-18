package com.artim.anton.slotmachine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class Main2Activity extends AppCompatActivity {

    private ImageSwitcher mImageSwitcher;

    // массив картинок
    private int[] mImageIds = {R.drawable.slot1, R.drawable.slot2, R.drawable.slot3,
            R.drawable.slot4, R.drawable.slot5};

    private int mCurIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mImageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        Animation slideInLeftAnimation = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        Animation slideOutRight = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);

        mImageSwitcher.setInAnimation(slideInLeftAnimation);
        mImageSwitcher.setOutAnimation(slideOutRight);

        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            @Override
            public View makeView() {

                ImageView imageView = new ImageView(Main2Activity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

                ViewGroup.LayoutParams params = new ImageSwitcher.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

                imageView.setLayoutParams(params);
                return imageView;
            }
        });

        mCurIndex = 0;
        mImageSwitcher.setImageResource(mImageIds[mCurIndex]);
    }

    public void onClick(View v) {
        if (mCurIndex == mImageIds.length - 1) {
            mCurIndex = 0;
            mImageSwitcher.setImageResource(mImageIds[mCurIndex]);
        } else {
            mImageSwitcher.setImageResource(mImageIds[++mCurIndex]);
        }
    }
}
