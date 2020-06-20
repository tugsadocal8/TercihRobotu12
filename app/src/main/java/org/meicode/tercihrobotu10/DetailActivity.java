package org.meicode.tercihrobotu10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ArrayList landmarkNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ListView listView = findViewById(R.id.listView);
        final ArrayList<String> landmarkNames = new ArrayList<>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(DetailActivity.this ,android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);
        Intent intent = getIntent();
        String unisim = intent.getStringExtra("name");
        landmarkNames.add(unisim + "         Bölüm   Puan  Sıralama");
        String landmarkName = landmarkNames.get(0);

        if( landmarkName == "Adli Bilimler"); {
            landmarkNames.clear();
            landmarkNames.add("Üsküdar Üniversitesi  Burslu             402.445  62787");
            landmarkNames.add("Üsküdar Üniversitesi  %75 İndirimli  295.61    198565");
            landmarkNames.add("Üsküdar Üniversitesi  %50 İndirimli  232.295  433372");
        }


    }

}
