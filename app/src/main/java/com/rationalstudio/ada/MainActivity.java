package com.rationalstudio.ada;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.rationalstudio.ada.Models.Tren;
import com.rationalstudio.ada.Models.VagonlarItem;

import org.json.JSONException;
import org.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private  EditText trenadi,vagon1kap,vagon2kap,vagon3kap,vagon1kol,vagon2kol,vagon3kol,kisisayisi;
    private Button post;
    private CheckBox check;
    private boolean status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String url = "https://adasunucu.herokuapp.com/response/";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        com.rationalstudio.ada.Models.Response response = new com.rationalstudio.ada.Models.Response();
        trenadi =  findViewById(R.id.trenadi);
        vagon1kap = findViewById(R.id.vagon1kap);
        vagon2kap = findViewById(R.id.vagon2kap);
        vagon3kap = findViewById(R.id.vagon3kap);
        vagon1kol =  findViewById(R.id.vagon1kol);
        vagon2kol = findViewById(R.id.vagon2kol);
        vagon3kol = findViewById(R.id.vagon3kol);
        kisisayisi = findViewById(R.id.kisisayisi);
        post = findViewById(R.id.btnpost);
        check = findViewById(R.id.check);
        List<VagonlarItem> Vagonlar = new ArrayList<>();

        post.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Tren tren = new Tren();

                if(vagon2kol.getText().toString().matches("") || vagon2kap.getText().toString().matches("") ){

                }else{
                    VagonlarItem  vagon1 = new VagonlarItem();
                    vagon1.setAd("Vagon1");
                    vagon1.setDoluKoltukAdet(Integer.parseInt(vagon1kol.getText().toString()));
                    vagon1.setKapasite(Integer.parseInt(vagon1kap.getText().toString()));
                    Vagonlar.add(vagon1);
                }



                if(vagon2kol.getText().toString().matches("") || vagon2kap.getText().toString().matches("") ){

                }else{
                    VagonlarItem  vagon2 = new VagonlarItem();
                    vagon2.setAd("Vagon2");
                    vagon2.setDoluKoltukAdet(Integer.parseInt(vagon2kol.getText().toString()));
                    vagon2.setKapasite(Integer.parseInt(vagon2kap.getText().toString()));
                    Vagonlar.add(vagon2);
                }


                if(vagon3kol.getText().toString().matches("") || vagon3kap.getText().toString().matches("") ){

                }else{
                    VagonlarItem  vagon3= new VagonlarItem();
                    vagon3.setAd("Vagon3");
                    vagon3.setDoluKoltukAdet(Integer.parseInt(vagon3kol.getText().toString()));
                    vagon3.setKapasite(Integer.parseInt(vagon3kap.getText().toString()));
                    Vagonlar.add(vagon3);
                }

                tren.setVagonlar(Vagonlar);
                JSONObject jsonobj; // declared locally so that it destroys after serving its purpose
                jsonobj = new JSONObject();
                try {
                    jsonobj.put("Tren", response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                tren.setAd(trenadi.getText().toString());
                response.setRezervasyonYapilacakKisiSayisi(Integer.parseInt(kisisayisi.getText().toString()));
                response.setTren(tren);

                if(check.isChecked()){
                    status = true;
                }else{
                    status = false;
                }
                response.setKisilerFarkliVagonlaraYerlestirilebilir(status);

                 String a= new Gson().toJson(response);
                JSONObject jObject = null;
                try {
                    jObject = new JSONObject(a);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                //Log.d("deneme",jObject.toString());
                JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, url, jObject, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                        //Log.d("deneme",response.toString());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("idid", "onErrorResponse: "+error);
                    }
                });
                RequestQueue requestQueue2 = Volley.newRequestQueue(MainActivity.this);
                requestQueue2.add(jsObjRequest );
            }
        });




















    }



}