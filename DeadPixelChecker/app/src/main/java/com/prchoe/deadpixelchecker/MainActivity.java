
package com.prchoe.deadpixelchecker;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    ImageView mImageView = null;
    TransitionDrawable mTransitionDrawable = null;
    ColorDrawable[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FullScreen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Toast.makeText(getApplicationContext(), "터치하세요!", Toast.LENGTH_LONG);

        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setOnClickListener(this);

        initLayers();

    }

    @Override
    public void onClick(View v) {
        mTransitionDrawable = new TransitionDrawable(colors);

        mImageView.setImageDrawable(mTransitionDrawable);
        mTransitionDrawable.reverseTransition(1000);

        changeColors();
    }

    private void initLayers() {
        int[] colorCodes = new int[] {
                Color.WHITE, Color.BLACK, Color.GRAY, Color.RED, Color.GREEN, Color.BLUE,
                Color.YELLOW, Color.CYAN
        };

        colors = new ColorDrawable[8];

        for (int i = 0; i < 8; i++) {
            colors[i] = new ColorDrawable(colorCodes[i]);
        }

    }

    private void changeColors() {
        ColorDrawable[] temp = new ColorDrawable[1];

        temp[0] = colors[0];

        for (int i = 0; i < 7; i++) {
            colors[i] = colors[i + 1];

        }
        colors[7] = temp[0];

    }

}
