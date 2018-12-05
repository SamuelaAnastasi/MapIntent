package com.example.android.mapintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mAddressView;
    Button mMapButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAddressView = (EditText) findViewById(R.id.ed_location);
        mMapButton = (Button) findViewById(R.id.btn_open_map);

        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInMap();
            }
        });
    }

    private void showInMap() {
        String address = mAddressView.getText().toString();

        Uri.Builder builder = new Uri.Builder();
        builder.scheme("geo");
        builder.path("0.0");
        builder.query(address);

        Uri addressUri = builder.build();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(addressUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
