package com.example.redballtoy.imagedownloadfrominet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button downloadButt;
    private ImageView showImage;
    private final String urlImage = "https://www.google.com/logos/doodles/2020/december-holidays-days-2-30-6753651837108830.3-law.gif";
    //"https://bizbi.ru/upload/iblock/8ae/8ae51ac9339ea6cfa3d05ace758a2b01.jpg";




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showImage = findViewById(R.id.iv_show_images);
        downloadButt = findViewById(R.id.bt_download);
        downloadButt.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_download:
                Toast.makeText(MainActivity.this,"Start downloading...",Toast.LENGTH_LONG).show();
                DownloadImageTask task = new DownloadImageTask();
                Bitmap bitmap = null;
                try {
                    bitmap = task.execute(urlImage).get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                showImage.setImageBitmap(bitmap);


                break;
        }

    }

    //создаем класс для загрузки картинки
    private class DownloadImageTask extends AsyncTask <String,Void, Bitmap>{
        @Override
        protected Bitmap doInBackground(String... strings) {
            URL url = null;
            HttpsURLConnection httpsURLConnection = null;
            try {
                url = new URL(strings[0]);
                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                InputStream inputStream = httpsURLConnection.getInputStream();
                return BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpsURLConnection != null) {
                    httpsURLConnection.disconnect();
                    //Toast.makeText(MainActivity.this,"Close connection",Toast.LENGTH_SHORT).show();
                }
            }

            return null;
        }
    }

}