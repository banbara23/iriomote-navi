
package com.ikmr.banbara23.iriomote_navi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void foodClick(View view) {
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
    }

    public void hotelClick(View view) {
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
    }

    public void photoClick(View view) {
        Intent intent = new Intent(this, FullscreenActivity.class);
        startActivity(intent);
    }
}
