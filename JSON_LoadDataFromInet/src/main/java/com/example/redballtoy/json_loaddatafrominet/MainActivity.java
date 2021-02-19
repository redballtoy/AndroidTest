package com.example.redballtoy.json_loaddatafrominet;

//В этом приложении код с сайта будет выводиться в логе на примере сайта mail.ru

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    private final String mailRu = "https://mail.ru/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //создание загрузки в новом потоке
        DownloadTask task = new DownloadTask();
        //запуск потока и получение из него данных
        try {
            String result = task.execute(mailRu).get();
            Log.i("myLog", "Результат запроса к сайту: " + result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //данный класс необходим для выполнения в отдельном потоке
    private static class DownloadTask extends AsyncTask<
            String, //данные которые будем отправлять через DownloadTask (наш URI)
            Void,   //данные которые будут передаваться в процессе загрузки например для прогресс бара
            String> //данные которые будут возвращаться с сайта, весь HTML код страницы mail.ru
    {
        public final String TAG = "myLog";
        @Override
        protected String doInBackground(String... strings) {
           //Log.i("myLog","Парамерт URI которвй мы передали: "+strings[0]); //элемент который мы передали
            //Будем формировать наш контент, строчку за строчкой копируя из интернета
            StringBuilder result = new StringBuilder();
            HttpsURLConnection urlConnection = null;
            //получить url из строки которую передпали
            URL url = null;
            try {
                url = new URL(strings[0]);
                //открыть соединение
                urlConnection = (HttpsURLConnection) url.openConnection();

                //чтение данных из интернета с использованием потока ввода
                //создание потока
                InputStream in = urlConnection.getInputStream();
                //создание рмдера
                InputStreamReader reader = new InputStreamReader(in);
                //для чтения данных строками используется BufferRearer
                BufferedReader bufferedReader = new BufferedReader(reader);
                String line = bufferedReader.readLine();
                while (line != null) {
                    result.append(line);
                    line = bufferedReader.readLine();
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //закрыть соединение при любом раскладе
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }

            }
            return result.toString();
        }
    }

}