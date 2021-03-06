package com.example.tigiahoidoai;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.adapter.TiGiaAdapter;
import com.example.tigia.TiGia;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTiGia;
    ArrayList<TiGia>dsTiGia;
    TiGiaAdapter tiGiaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addEvents() {

    }

    private void addControls() {
        lvTiGia= this.<ListView>findViewById(R.id.lvTiGia);
        dsTiGia= new ArrayList<>();
        tiGiaAdapter= new TiGiaAdapter(MainActivity.this, R.layout.item, dsTiGia);
        lvTiGia.setAdapter(tiGiaAdapter);

        TiGiaTask task= new TiGiaTask();
        task.execute();
    }

    class TiGiaTask extends AsyncTask<Void, Void, ArrayList<TiGia>>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tiGiaAdapter.clear();
        }

        @Override
        protected void onPostExecute(ArrayList<TiGia> tiGias) {
            super.onPostExecute(tiGias);
            tiGiaAdapter.clear();
            tiGiaAdapter.addAll(tiGias);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected ArrayList<TiGia> doInBackground(Void... voids) {
            ArrayList<TiGia> ds= new ArrayList<>();
            try{
                URL url=new URL("http://dongabank.com.vn/exchange/export");
                HttpURLConnection connection= (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-type", "application/json; charset=utf-8");
                connection.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
                connection.setRequestProperty("Accept", "*/*");

                //lấy dữ liệu mà server trả về
                InputStream is= connection.getInputStream();
                InputStreamReader isr=new InputStreamReader(is,"UTF-8");
                BufferedReader br=new BufferedReader(isr);
                String line=br.readLine();
                StringBuilder builder=new StringBuilder();
                while (line!=null){
                    builder.append(line);
                    line=br.readLine();
                }
                String json=builder.toString();
                json=json.replace("(", "");
                json=json.replace(")","");
                JSONObject jsonObject=new JSONObject(json);
                JSONArray jsonArray= jsonObject.getJSONArray("items");
                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject item=jsonArray.getJSONObject(i);
                    TiGia tiGia=new TiGia();
                    tiGia.setType(item.getString("type"));
                    if(item.has("imageurl")) {
                        tiGia.setImgUrl(item.getString("imageurl"));
                        url=new URL(tiGia.getImgUrl());
                        connection= (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("User-Agent","Mozilla/5.0 ( compatible ) ");
                        connection.setRequestProperty("Accept", "*/*");
                        Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                        tiGia.setBitmap(bitmap);
                    }
                    tiGia.setMuaTienMat(item.getString("muatienmat"));
                    tiGia.setMuack(item.getString("muack"));
                    tiGia.setBanTienMat(item.getString("bantienmat"));
                    tiGia.setBanck(item.getString("banck"));
                    ds.add(tiGia);
                }

            }catch(Exception ex){
                Log.e( "Loi", ex.toString());
            }
            return ds;
        }
    }
}
