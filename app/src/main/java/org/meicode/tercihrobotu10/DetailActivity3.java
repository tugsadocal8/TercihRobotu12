package org.meicode.tercihrobotu10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        ListView listView = findViewById(R.id.listView);
        final ArrayList<String> landmarkNames = new ArrayList<>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(DetailActivity3.this ,android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);

        Intent intent = getIntent();
        String unisim = intent.getStringExtra("name");
        landmarkNames.clear();
        landmarkNames.add(unisim + "  Bölüm  Puan  Sıralama");
        String landmarkName = landmarkNames.get(0);
        if( landmarkName == "Ağaç İşleri Mühendisliği"); {
            landmarkNames.clear();
            landmarkNames.add("Gazi Üniversitesi   Örgün  256,447  316172");
            landmarkNames.add("Sıtkı Koçman Üni.  Örgün  241,341  383407");
            landmarkNames.add("Düzce Üniversitesi Örgün  215,309  477270");

        }
    }
}