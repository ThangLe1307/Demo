package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.api.ApiService;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;





public class MainActivity extends AppCompatActivity {

    private Button btnGet;
    private TextView viewName;
    private TextView viewLevel;
    private TextView viewSignature;

    public EditText getUID;


    public String uuid;

    public void show(){
        Toast.makeText(this, "unexpected UID", Toast.LENGTH_SHORT).show();
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        viewName=(TextView) findViewById(R.id.viewName);
        viewLevel=(TextView) findViewById(R.id.viewlevel);
        viewSignature=(TextView) findViewById(R.id.viewsignature);

        getUID=(EditText)findViewById(R.id.getUID);





        btnGet= (Button)findViewById(R.id.GetInfor);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                uuid=getUID.getText().toString();
                //https://enka.network/u/700378769/__data.json
                String uid="https://enka.network/u/"+uuid+"/__data.json";


                ApiService.api.infor(uid).enqueue(new Callback<myChar>() {
                    @Override
                    public void onResponse(Call<myChar> call, Response<myChar> response) {
                        System.out.println("call thanh cong");
                        myChar thangLe=response.body();




                        if (thangLe!=null) {
                            viewName.setText("Name: " + thangLe.getPlayerInfo().getNickname());
                            viewLevel.setText("AR: " + thangLe.getPlayerInfo().getLevel().toString());
                            viewSignature.setText("Signature: " + thangLe.getPlayerInfo().getSignature());
                        }
                        else
                        {
                            viewName.setText("Name: " + "Unknown");
                            viewLevel.setText("AR: " + "Unknown");
                            viewSignature.setText("Signature: "+"Unknown");
                            show();



                        }


                    }

                    @Override
                    public void onFailure(Call<myChar> call, Throwable t) {

                    }
                });

            }
        });








    }
}


