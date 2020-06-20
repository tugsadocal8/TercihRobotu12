package org.meicode.tercihrobotu10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        ListView listView = findViewById(R.id.listView);
        final ArrayList<String> landmarkNames = new ArrayList<>();
        ArrayAdapter arrayAdapter = new ArrayAdapter(DetailActivity2.this ,android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);

        Intent intent = getIntent();
        String unisim = intent.getStringExtra("name");
        landmarkNames.clear();
        landmarkNames.add(unisim + "  Bölüm   Puan   Sıralama");
        String landmarkName = landmarkNames.get(0);
        if( landmarkName == "Adli Bilişim Mühendisliği"); {
            landmarkNames.clear();
            landmarkNames.add("Fırat Üniversitesi      Örgün 284,022  226637");
            landmarkNames.add("Fırat Üniversitesi      İÖ       268,341  272805");
            landmarkNames.add("Fırat Üniversitesi      KKTC  261,818  295482");
            landmarkNames.add("Fırat Üniversitesi      MTOK  260,765  299422");


        }
    }
}
