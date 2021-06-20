package com.naveenkc.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HotelDetails extends AppCompatActivity {
    String Name,Number,Causines,Web,Price,Range,Res_id,Address,State,Postal,Street;

    TextView name,number,web,causine;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        name=findViewById(R.id.name);
        number=findViewById(R.id.phone);
        web=findViewById(R.id.web);
        causine=findViewById(R.id.causine);

        Intent intent = getIntent();
        Name = intent.getStringExtra("name");
        Number = intent.getStringExtra("number");
        Causines = intent.getStringExtra("causines");
        Web = intent.getStringExtra("web");
      /*  Price = intent.getStringExtra("price");
        Range = intent.getStringExtra("range");
        Res_id = intent.getStringExtra("res");
        Address = intent.getStringExtra("address");
        State = intent.getStringExtra("state");
        Postal = intent.getStringExtra("postal");
        Street = intent.getStringExtra("street");


       */

        name.setText(Name);
        number.setText("Telephone\n"+ Number);
        web.setText("Website\n"+Web);
        causine.setText(Causines);

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser= new Intent(Intent.ACTION_VIEW, Uri.parse(Web));
                startActivity(browser);
            }
        });

    }
}