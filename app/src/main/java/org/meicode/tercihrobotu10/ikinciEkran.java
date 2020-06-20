package org.meicode.tercihrobotu10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class ikinciEkran extends Activity {
    ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ikinci_ekran);

        final ListView listView = findViewById(R.id.listView);
        final ArrayList<String> landmarkNames = new ArrayList<>();
        landmarkNames.add("Acil Durum ve Afet Yönetimi");
        landmarkNames.add("Adalet");
        landmarkNames.add("Adli Bilimler");
        landmarkNames.add("Adli Bilişim Mühendisliği");
        landmarkNames.add("Ağaç İşleri Endüstri Mühendisliği");
        landmarkNames.add("Ağız ve Diş Sağlığı");
        landmarkNames.add("Aile ve Tüketici Bilimleri");
        landmarkNames.add("Aktüerya");
        landmarkNames.add("Alman Dili ve Edebiyatı");


        final ArrayAdapter arrayAdapter = new ArrayAdapter(ikinciEkran.this ,android.R.layout.simple_list_item_1,landmarkNames);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if (i == 2){
                    Intent intent = new Intent(getApplicationContext(),DetailActivity.class);
                    intent.putExtra("name",landmarkNames.get(i));
                    startActivity(intent);}
                if (i == 3){
                    Intent intent = new Intent(getApplicationContext(),DetailActivity2.class);
                    intent.putExtra("name",landmarkNames.get(i));
                    startActivity(intent);}
                if (i == 4){
                    Intent intent = new Intent(getApplicationContext(),DetailActivity3.class);
                    intent.putExtra("name",landmarkNames.get(i));
                    startActivity(intent);}


            }
        });
    }

}

