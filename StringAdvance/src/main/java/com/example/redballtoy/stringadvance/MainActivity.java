package com.example.redballtoy.stringadvance;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Углубленная работа со строками как подготовка к парсингу сайтов
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nameString = "Андрей, Алексей, Роман, Павел, Михаил";
        //создадим массив строк который будет содержать данные имена
        //split method
        String[] names = nameString.split(", ");
        for (String name : names) {
            Log.i("myLog", name);
        }

        //substring
        String geometry = "Геометрия";
        String meter = geometry.substring(3,7);//первый включается второй нет и начинаем с 0
        Log.i("myLog", meter);

        //использование регуляных выражений
        //Выделить строку между Mi и pi
        String river = "MissisipiMissisipi";
        //для этого создаем паттерн, шаблон
        Pattern pattern = Pattern.compile("Mi(.*?)pi");
        //для обрпаботки строки паттерном нужен объект Matcher
        Matcher matcher = pattern.matcher(river);
        //что бы пробегал по всей строке необходимо создать цикл
        //в условии находит первое вхождение
        while (matcher.find()) {
            Log.i("myLog", matcher.group(1));//matcher.group(1) получение первого совпадения
        }

        //выделить строку с сайта
        String url = " <a target=\"_blank\" href=\"/profile/387471-kafe-pushkin?from_rating=415485\">\n" +
                "                            <img src=\"https://cdn.forbes.ru/files/presets/100_100/profile/kafe-pushkin.jpg__1574163099__14811__vid822611e.jpg\" alt=\"Кафе Пушкинъ\" title=\"Кафе Пушкинъ\" height=\"100\" width=\"100\" />\n" +
                "                    </a>";
        Pattern patternImg = Pattern.compile("<img src=\"(.*?)\"");
        Pattern patternTitle = Pattern.compile("title=\"(.*?)\"");
        Matcher matcherImg = patternImg.matcher(url);
        Matcher matcherTitle = patternTitle.matcher(url);
        while (matcherImg.find()) {
            Log.i("myLogReg", matcherImg.group(1));
        }
        while (matcherTitle.find()) {
            Log.i("myLogReg", matcherTitle.group(1));
        }





    }
}