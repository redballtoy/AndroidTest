package com.example.redballtoy.resourcestest_gb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<AndroidVersionModelData> {
    public MyAdapter(Context context, ArrayList<AndroidVersionModelData> androidVersionModelData) {
        super(context, 0, androidVersionModelData);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //получаем данные из источника данных для определенной позиции
        AndroidVersionModelData androidVersionModelData = getItem(position);
        //если нет созданной вьюшки создаем новую
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_android_version, parent, false);
        }
        //convertview это вьюшка (одного) элемента через которые данные из источника конвертируются
        //в строку в listview, находим элементы в этой вьюшке
        TextView tvAndroidNameVersion = convertView.findViewById(R.id.tv_item_version_name);
        ImageView ivAndroidPic = convertView.findViewById(R.id.ivc_android_icon);
        //заполгяем их данными текущей позиции
        tvAndroidNameVersion.setText(androidVersionModelData.versionName);
        ivAndroidPic.setImageResource(androidVersionModelData.versionPicId);
        //возврат вьюшки элемента списка
        return convertView;
    }

}
