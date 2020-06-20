package org.meicode.tercihrobotu10;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int i;
    int k=0;
    Button sonucFiltreButton;
    RadioGroup radioPuanTur;
    RadioButton radioHepsi;
    RadioButton radioSayisal;
    RadioButton radioEsit;
    RadioButton radioSozel;
    RadioButton radioDil;

    private String[] bolumler={"Adli Bilimler","Adli Bilişim Mühendisliği","Yazılım Mühendisliği","Ağaç İşleri Mühendisliği"};
    private String[] uni0={"Üsküdar Üniversitesi"};
    private String[] uni1={"Fırat Üniversitesi"};
    private String[] uni2={"Fırat Üniversitesi","Bahçeşehir Üniversitesi","İzmir Ekonomi Üniversitesi"};
    private String[] uni3={"Gazi Üniversitesi","Sıtkı Koçman Üniversiesi"};

    private Spinner spinnerBolumler;
    private Spinner spinnerUniversiteler;
    private ArrayAdapter<String> dataAdapterForBolumler;
    private ArrayAdapter<String> dataAdapterForUniversiteler;

    CheckBox checkbox;
    CheckBox checkbox2;

    ArrayList<String> veriListesi;
    ArrayList<String> filtreliListe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioPuanTur= (RadioGroup) findViewById(R.id.radioPuanTur);
        radioPuanTur= (RadioGroup) findViewById(R.id.radioPuanTur);
        radioHepsi= (RadioButton) findViewById(R.id.radioHepsi);
        radioSayisal= (RadioButton) findViewById(R.id.radioSayisal);
        radioEsit= (RadioButton) findViewById(R.id.radioEsit);
        radioSozel= (RadioButton) findViewById(R.id.radioSozel);
        radioDil= (RadioButton) findViewById(R.id.radioDil);

        checkbox = findViewById((R.id.checkBox));
        checkbox2 = findViewById((R.id.checkBox2));

        sonucFiltreButton=(Button)findViewById(R.id.sonucFiltreButton);

        final ListView listView = findViewById(R.id.listView);
        final ArrayList<String> filtreliListe = new ArrayList<>();
        final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this ,android.R.layout.simple_list_item_1,filtreliListe);
        listView.setAdapter(arrayAdapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        veriListesi = new ArrayList<String>();
        veriListesi.add("Üsküdar Üniversitesi"); veriListesi.add("Adli Bilimler"); veriListesi.add("402");veriListesi.add("62787");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Vakıf - Tam Burslu");
        veriListesi.add("Üsküdar Üniversitesi");veriListesi.add("Adli Bilimler");veriListesi.add("295");veriListesi.add("198565");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Vakıf - %75 Burslu ");
        veriListesi.add("Üsküdar Üniversitesi");veriListesi.add("Adli Bilimler");veriListesi.add("232");veriListesi.add("433372");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Vakıf - %50 Burslu");
        veriListesi.add("Fırat Üniversitesi");veriListesi.add("Adli Bilişim Mühendisliği");veriListesi.add("284");veriListesi.add("226637");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Devlet");
        veriListesi.add("Fırat Üniversitesi");veriListesi.add("Adli Bilişim Mühendisliği");veriListesi.add("268");veriListesi.add("295482");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Devlet");
        veriListesi.add("Fırat Üniversitesi");veriListesi.add("Adli Bilişim Mühendisliği");veriListesi.add("261");veriListesi.add("299999");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Devlet");
        veriListesi.add("Fırat Üniversitesi");veriListesi.add("Yazılım Mühendisliği");veriListesi.add("308");veriListesi.add("1717372");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Devlet");
        veriListesi.add("Fırat Üniversitesi");veriListesi.add("Yazılım Mühendisliği");veriListesi.add("284");veriListesi.add("226085");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Devlet-İÖ");
        veriListesi.add("Fırat Üniversitesi");veriListesi.add("Yazılım Mühendisliği");veriListesi.add("261");veriListesi.add("289152");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Devlet-MTOK");
        veriListesi.add("Bahçeşehir Üniversitesi");veriListesi.add("Yazılım Mühendisliği");veriListesi.add("481");veriListesi.add("13811");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Vakıf - Tam Burslu");
        veriListesi.add("Bahçeşehir Üniversitesi");veriListesi.add("Yazılım Mühendisliği");veriListesi.add("387");veriListesi.add("74711");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Vakıf - %50 Burslu");
        veriListesi.add("Bahçeşehir Üniversitesi");veriListesi.add("Yazılım Mühendisliği");veriListesi.add("305");veriListesi.add("178664");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Vakıf - Ücretli");
        veriListesi.add("İzmir Ekonomi Üniversitesi");veriListesi.add("Yazılım Mühendisliği");veriListesi.add("462");veriListesi.add("23005");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Vakıf - Tam Burslu");
        veriListesi.add("İzmir Ekonomi Üniversitesi");veriListesi.add("Yazılım Mühendisliği");veriListesi.add("383");veriListesi.add("78102");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Vakıf - %50 Burslu");
        veriListesi.add("İzmir Ekonomi Üniversitesi");veriListesi.add("Yazılım Mühendisliği");veriListesi.add("336");veriListesi.add("128650");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Vakıf - %25 Burslu");
        veriListesi.add("Gazi Üniversitesi");veriListesi.add("Ağaç İşleri Mühendisliği");veriListesi.add("256");veriListesi.add("316172");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Devlet");
        veriListesi.add("Sıtkı Koçman Üniversitesi");veriListesi.add("Ağaç İşleri Mühendisliği");veriListesi.add("241");veriListesi.add("383407");veriListesi.add("Lisans");veriListesi.add("Sayısal");veriListesi.add("Devlet");

        checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkbox.isChecked())
                    Toast.makeText(getApplicationContext(), buttonView.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        checkbox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(checkbox2.isChecked())
                    Toast.makeText(getApplicationContext(), buttonView.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        radioHepsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioPuanTur.getCheckedRadioButtonId();
                radioHepsi= (RadioButton) findViewById(selectedId);
                Toast.makeText(MainActivity.this, radioHepsi.getText(), Toast.LENGTH_SHORT).show();

            } });

        radioSayisal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioPuanTur.getCheckedRadioButtonId();
                radioSayisal= (RadioButton) findViewById(selectedId);
                Toast.makeText(MainActivity.this, radioSayisal.getText(), Toast.LENGTH_SHORT).show();

            } });
        spinnerUniversiteler = (Spinner) findViewById(R.id.spinnerUniversiteler);
        spinnerBolumler = (Spinner) findViewById(R.id.spinnerBolumler);

        dataAdapterForBolumler= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, bolumler);
        dataAdapterForUniversiteler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,uni0);
        dataAdapterForUniversiteler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,uni1);
        dataAdapterForUniversiteler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,uni2);
        dataAdapterForUniversiteler = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,uni3);

        dataAdapterForBolumler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterForUniversiteler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerUniversiteler.setAdapter(dataAdapterForUniversiteler);
        spinnerBolumler.setAdapter(dataAdapterForBolumler);

        spinnerBolumler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                if(parent.getSelectedItem().toString().equals(bolumler[0]))
                    dataAdapterForUniversiteler= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,uni0);
                else if(parent.getSelectedItem().toString().equals(bolumler[1]))
                    dataAdapterForUniversiteler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,uni1);
                else if(parent.getSelectedItem().toString().equals(bolumler[2]))
                    dataAdapterForUniversiteler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,uni2);
                else if(parent.getSelectedItem().toString().equals(bolumler[3]))
                    dataAdapterForUniversiteler = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,uni3);


                dataAdapterForUniversiteler.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerUniversiteler.setAdapter(dataAdapterForUniversiteler);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerUniversiteler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Seçilen il ve ilçeyi ekranda gösteriyoruz.
                Toast.makeText(getBaseContext(), ""+spinnerUniversiteler.getSelectedItem().toString()+"n"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        final int uzunluk = veriListesi.size();
        sonucFiltreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String veriUni = spinnerUniversiteler.getSelectedItem().toString();
                final String veriBolum = spinnerBolumler.getSelectedItem().toString();
                filtreliListe.clear();
                for (i = 1; i < uzunluk; i = i + 7) {
                    String veriuniv = veriListesi.get(i-1);
                    String veriBolumv = veriListesi.get(i);
                    String veriSira = veriListesi.get(i+1);
                    String veriPuan = veriListesi.get(i+2);
                    String veriTur = veriListesi.get(i+3);
                    String veriPuanTur = veriListesi.get(i+4);
                    String veriUniTur = veriListesi.get(i+5);

                    if (veriBolumv.length() == veriBolum.length()) {
                        if(veriuniv.length() == veriUni.length()) {
                            if ( checkbox.isChecked()) {
                                if (veriTur == "Önlisans") {
                                    if(radioSayisal.isChecked()) {
                                        filtreliListe.add(veriuniv + "  " + veriSira + "  " + veriPuan + "  " + "Önlisans" + "  " + "Sayısal" + "  " + veriUniTur);
                                    }
                                    if(radioHepsi.isChecked()){
                                        filtreliListe.add(veriuniv + "  " + veriSira + "  " + veriPuan + "  " + "Önlisans" + "  " + "Sayısal" + "  " + veriUniTur);                                    }
                                }
                            }
                            if ( checkbox2.isChecked()) {
                                if (veriTur == "Lisans") {
                                    if(radioSayisal.isChecked()) {
                                        filtreliListe.add(veriuniv + "  " + veriSira + "  " + veriPuan + "  " + "Önlisans" + "  " + "Sayısal" + "  " + veriUniTur);
                                    }
                                    if(radioHepsi.isChecked()){
                                        filtreliListe.add(veriuniv + "  " + veriSira + "  " + veriPuan + "  " + "Önlisans" + "  " + "Sayısal" + "  " + veriUniTur);
                                    }
                                }
                            }

                        }

                    }
                }
                arrayAdapter.setNotifyOnChange(true);
                listView.setAdapter(arrayAdapter);            }
        });
    }

    public void Tiklandi(View v) {
        if (v.getId() == R.id.bolumsButton) {
            Intent intent = new Intent(getApplicationContext(), ikinciEkran.class);
            startActivity(intent);
        }

    }
}
