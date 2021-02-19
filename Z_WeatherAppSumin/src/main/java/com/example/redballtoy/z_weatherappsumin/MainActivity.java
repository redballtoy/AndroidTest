package com.example.redballtoy.z_weatherappsumin;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etInputCity;
    private TextView tvShowWeather;
    private Button btGetWeather;

    private final String WEATHER_QUERY = "https://api.openweathermap.org/data/2.5/weather?q=%s&APPID=4ad090ac8a2241ed0d8ee837042e0a8a&lang=ru&units=metric";
    /*Test Query
    * api.openweathermap.org/data/2.5/weather?q=Moscow&APPID=4ad090ac8a2241ed0d8ee837042e0a8a&lang=ru&units=metric
            private static final String MY_API = "4ad090ac8a2241ed0d8ee837042e0a8a";
            private static final String QUERY = "api.openweathermap.org/data/2.5/weather?q=";
            public static final String QUERY_FOR_RUSSIA = "&lang=ru&units=metric";
    */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etInputCity = findViewById(R.id.et_input_city);
        tvShowWeather = findViewById(R.id.tv_show_weather_forecast);
        btGetWeather = findViewById(R.id.bt_get_data);
        btGetWeather.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
       //Получаем город который ввел пользователь
        String city = etInputCity.getText().toString();
        if (city.equals("")){
            Toast.makeText(this, getString(R.string.hint_enter_city),Toast.LENGTH_SHORT).show();
            return;
        }
        //запускаем выполнение задачи
        String query = String.format(WEATHER_QUERY, city);
        //Log.i("myLog", query);
        DownloadTask downloadTask = new DownloadTask();
        downloadTask.execute(query);
    }
    private class DownloadTask extends AsyncTask<String, Void, String> {
        String weather;

        @Override
        protected String doInBackground(String... strings) {
            URL url=null;
            HttpURLConnection urlConnection = null;
            StringBuilder result = new StringBuilder();
            try {
                //Log.i("myLog", "strings[0]"+strings[0]);
                url = new URL(strings[0]);
                //Log.i("myLog", "url"+url.toString());
                //открываем соединение
                urlConnection = (HttpURLConnection) url.openConnection();
                //Log.i("myLog", "urlConnection"+urlConnection.toString());
                //получить входящий поток
                InputStream in = urlConnection.getInputStream();
                //ридер для чтения данных из потока
                InputStreamReader inputStreamReader = new InputStreamReader(in);
                //для возможности чтения строками преобразовать в BufferReader
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                //начинаем читать данные
                String line = bufferedReader.readLine();
                //и пока данные не пустые вставляем в стрингбилдер
                while (line != null) {
                    result.append(line);
                    //читаем следующую строку
                    line = bufferedReader.readLine();
                }
                //по окончании возвращаем билдер приведенный к строке
                return result.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "-2";
            } catch (IOException e) {
                e.printStackTrace();
            }catch (NullPointerException e) {
                e.printStackTrace();
            } finally {
                //закрыть соединение если оно открыто
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return "-1";
        }

        //в данный метод передается результат doInBackground
        @Override
        protected void onPostExecute(String s) {
            //Log.i("myLog", "s: "+ s);
            super.onPostExecute(s);

            //необходимо получить объект JSON
            try {
                JSONObject jsonObject = new JSONObject(s);
                //из JSONObject получить данные
                String nameCity = jsonObject.getString("name");
                Log.i("myLog", "nameCity: " + nameCity);
                //температуры находятся в объекте JSON с именем maim
                String currentTemp = jsonObject.getJSONObject("main").getString("temp");
                Log.i("myLog", "currentTemp: " + currentTemp);
                String currentTempLike = jsonObject.getJSONObject("main").getString("feels_like");
                String minTemp = jsonObject.getJSONObject("main").getString("temp_min");
                String maxTemp = jsonObject.getJSONObject("main").getString("temp_max");
                //описание погоды находится в weather[] что означает что это массив
                //получить JSON array weather[], потом JSON object [0]
                String descriptions = jsonObject.getJSONArray("weather")
                        .getJSONObject(0).getString("description");
                //Результирующая строка прогноза погоды
                weather = String.format("Город : %s\nТемпература: %s\nОщущается как: %s" +
                                "\nТемпература min: %s\nТемпература max: %s\nНа улице: %s"
                        , nameCity, currentTemp, currentTempLike, minTemp, maxTemp, descriptions);
                tvShowWeather.setText(weather);

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
}
