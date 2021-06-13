package com.example.book;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button but;
    EditText  ed1,ed2;
    private String email_id,pass,device_id;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=findViewById(R.id.editTextTextEmailAddress);
        ed2=findViewById(R.id.editTextTextPassword);

        but=findViewById(R.id.button);

        context = this;

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email_id=ed1.getText().toString();
                pass=ed2.getText().toString();
                device_id= Settings.Secure.getString(getApplicationContext().getContentResolver(),Settings.Secure.ANDROID_ID);

                Logindetails logindetails=new Logindetails(email_id,pass,device_id);
                Retrofit retroft = new Retrofit.Builder()
                        .baseUrl("https://bmkauth.herokuapp.com/api/v1/user/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                retrofitInterface retrofitRequest=retroft.create(retrofitInterface.class);
                Call<LoginRecieve> call=retrofitRequest.getpo(logindetails);

                call.enqueue(new Callback<LoginRecieve>() {
                    @Override
                    public void onResponse(Call<LoginRecieve> call, Response<LoginRecieve> response) {
                        if(response.code()==200){
                            Toast.makeText(MainActivity.this,"Logged in Succesfully",Toast.LENGTH_LONG).show();
                            LoginRecieve loginRecieve=response.body();
                            Log.d("Login message:",loginRecieve.toprint());
                        }
                        else {

                            Toast.makeText(MainActivity.this,"Some error",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginRecieve> call, Throwable t) {

                    }
                });

            }
        });
    }
}