package com.grid.meena.griddynamic;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class GridActivity extends AppCompatActivity {
    GridLayout gl;
    ImageView[] img;
    int rows;
    int cols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            rows = extras.getInt("ROWNUM");
            cols = extras.getInt("COLNUM");
        } else {

            //handle null string
            //prompt the user to input the question

        }

        gl = new GridLayout(GridActivity.this);
        gl.setOrientation(GridLayout.HORIZONTAL);
        gl.setLayoutParams(new LayoutParams
                (GridLayout.spec(GridLayout.UNDEFINED, 1f),
                        GridLayout.spec(GridLayout.UNDEFINED, 1f)));
        gl.setColumnCount(cols);
        gl.setRowCount(rows);
        img = new ImageView[cols*rows];

       for (int i = 0; i < cols*rows; i++) {
            img[i] = new ImageView(GridActivity.this);
            img[i].setLayoutParams(new LayoutParams
                    (GridLayout.spec(GridLayout.UNDEFINED, 1f),
                            GridLayout.spec(GridLayout.UNDEFINED, 1f)));
           img[i].setImageResource(R.mipmap.cornucopia);
           img[i].setScaleType(ScaleType.FIT_XY);
           img[i].setAdjustViewBounds(true);


            img[i].setPadding(10, 15, 10, 15);
            gl.addView(img[i]);
        }

        setContentView(gl);


    }
}