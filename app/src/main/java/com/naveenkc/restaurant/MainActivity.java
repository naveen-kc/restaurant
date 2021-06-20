package com.naveenkc.restaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<RestaurantList> list;
    RestaurantAdapter adapter;
    JSONArray users;

    TextView textView,number,web,menu;
    Button button;
    String text;
    String url ="https://api.documenu.com/v2/restaurant/4072702673999819?key=508ab21d1d779c46f1ac0e70d12df02e";
    private RequestQueue mQueue;
    CardView cardView;
    String Name,Number,Causines,Web,Price,Range,Res_id,Address,State,Postal,Street;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text);
        number=findViewById(R.id.phone);
        web=findViewById(R.id.web);
        menu=findViewById(R.id.menu);
        cardView=findViewById(R.id.card);
        button=findViewById(R.id.get);

        //recyclerView = findViewById(R.id.restaurantList);
        //list = new ArrayList<>();

        /*
        OkHttpClient client = new OkHttpClient();

         String url ="https://api.documenu.com/v2/restaurant/4072702673999819?key=508ab21d1d779c46f1ac0e70d12df02e";
        okhttp3.Request request= new okhttp3.Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull okhttp3.Response response) throws IOException {
                if(response.isSuccessful()){
                    text=response.body().string();
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                          //  textView.setText(text);
                        }
                    });
                }

            }
        });



         */


                jsonParse();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(),DetailedActivity.class);
                        startActivity(i);
                    }
                });
                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(),HotelDetails.class);
                        i.putExtra("name",Name);
                        i.putExtra("number",Number);
                        i.putExtra("causines",Causines);
                        i.putExtra("web",Web);
                        i.putExtra("price",Price);
                        i.putExtra("range",Range);
                        i.putExtra("res",Res_id);
                        i.putExtra("address",Address);
                        i.putExtra("state",State);
                        i.putExtra("postal",Postal);
                        i.putExtra("street",Street);


                        startActivity(i);
                    }
                });





    }

    private void jsonParse() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       // Toast.makeText(MainActivity.this,response,Toast.LENGTH_SHORT).show();
                        try {
                            String jsonString = response; //assign your JSON String here
                            JSONObject obj = new JSONObject(jsonString);
                             Name = obj.getJSONObject("result").getString("restaurant_name");
                            textView.setText(Name);
                             Number = obj.getJSONObject("result").getString("restaurant_phone");
                             Causines = obj.getJSONObject("result").getString("cuisines");
                            Web = obj.getJSONObject("result").getString("restaurant_website");
                            /*
                             Price = obj.getJSONObject("result").getString("price_range");
                             Range = obj.getJSONObject("result").getString("price_range_num");
                             Res_id = obj.getJSONObject("result").getString("restaurant_id");
                             Address = obj.getJSONObject("result").getString("address");
                             State = obj.getJSONObject("result").getString("state");
                             Postal = obj.getJSONObject("result").getString("postal_code");
                             Street = obj.getJSONObject("result").getString("street");

                             */



                            findViewById(R.id.loadingPanel).setVisibility(View.GONE);


                            /*

                            JSONArray arr = obj.getJSONArray("menus");
                            for (int i = 0; i < arr.length(); i++)
                            {
                                String menuName = arr.getJSONObject(i).getString("menu_name");
                                menu.setText(menuName);

                                Toast.makeText(MainActivity.this,menuName,Toast.LENGTH_SHORT).show();
                            }

                             */



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //error.printStackTrace();

               // Toast.makeText(MainActivity.this,error.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }

    @Override
    public void onBackPressed() {
     finishAffinity();
    }
}
