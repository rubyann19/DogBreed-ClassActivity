package com.example.dogscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Search extends AppCompatActivity {

    ArrayList<Dog> dogLst;
    animalAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        dogLst = new ArrayList<>();
        String link = "https://next.json-generator.com/api/json/get/E14trR2lD";

        try {

            String data = new Ayscdata().execute(link).get();
            System.out.println("Data From Main :"+data);

            JSONObject mainObj = new JSONObject(data);
            JSONArray dogArray = mainObj.getJSONArray("Pokemon");

            for (int i=0;i<dogArray.length();i++)
            {
                JSONObject child = dogArray.getJSONObject(i);


                String Message = child.getString("Message");

                dogLst.add(new Dog(Message));

            }

            adapter = new animalAdapter(dogLst,getApplication());
            initView();



        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void initView()
    {
        LinearLayoutManager linearLayout = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView = findViewById(R.id.recycle_animal);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListner(onItemClickpoke);
    }


    public View.OnClickListener onItemClickpoke = new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            RecyclerView.ViewHolder viewHolder= (RecyclerView.ViewHolder) v.getTag();
            int position = viewHolder.getAdapterPosition();

            Toast.makeText(getApplicationContext(),dogLst.get(position).getMessage(),Toast.LENGTH_LONG).show();

            Intent i  = new Intent(Search.this,Details.class);
            i.putExtra("data",dogLst.get(position));
            startActivity(i);


        }
    };
}
