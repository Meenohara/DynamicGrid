package com.grid.meena.griddynamic;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.grid.meena.griddynamic.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText rownum = (EditText) findViewById(R.id.nrows);
        final EditText colnum = (EditText) findViewById(R.id.ncols);
        Button go       = (Button) findViewById(R.id.btn);



        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nro = Integer.parseInt(rownum.getText().toString());
                int nco = Integer.parseInt(colnum.getText().toString());
                Log.i("NROWS", " is "+nro);
                Log.i("NCOLS", " is "+nco);

            if(nro<1 || nco<1)
            {
                Toast.makeText(getBaseContext(), "Less than one row or column does not generate a grid",Toast.LENGTH_LONG).show();

            }
            else if(nro>8)
            {
                Toast.makeText(getBaseContext(), "More than 8 rows will affect the clarity of the image",Toast.LENGTH_LONG).show();
            }
            else if(nco>6)
            {
                Toast.makeText(getBaseContext(), "More than 6 columns will affect the clarity of the image",Toast.LENGTH_LONG).show();
            }
            else {
                Intent intent = new Intent(MainActivity.this, GridActivity.class);
                intent.putExtra("ROWNUM", nro);
                intent.putExtra("COLNUM", nco);
                startActivity(intent);
            }


            }
        });
    }
}
