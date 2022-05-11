package com.example.intentpartie2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i = findViewById(R.id.im);
    }

    public void acceder1(View view) {

        String num = "tel:037878";
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse(num));
        startActivity(i);
    }

    public void acceder2(View view) {

        String num = "tel:037878";
        Intent i = new Intent(Intent.ACTION_CALL, Uri.parse(num));
        startActivity(i);
    }

    public void acceder3(View view) {

        String num = "smsto:037878";
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse(num));
        i.putExtra("sms_body","Mon message ....");
        startActivity(i);
    }

    public void acceder4(View view) {
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap image = (Bitmap) data.getExtras().get("data");

        i.setImageBitmap(image);
    }
}