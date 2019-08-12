package com.android.latestnewsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class CategoryActivity extends AppCompatActivity {


    //initialization
    public  static final String KEYWORDS_KEY = "KEYWORDS",LOCATION_KEY = "COUNTRY";
    private String selectedLocation;
    private String givenKeyWords;
    private String selectedCategory;
    public static String url;


    // creating que queue object
    private RequestQueue queue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        // initializing the queue object
        queue = Volley.newRequestQueue(this);

        //getting extras
        Intent myIntent = getIntent();
        Bundle myExtras = myIntent.getExtras();

        selectedLocation = myExtras.getString(LOCATION_KEY).toString();
        givenKeyWords = myExtras.getString(KEYWORDS_KEY).toString();

        //getting UI elemnts
        final Button btnCategory = (Button)findViewById(R.id.btnCategory);

        View.OnClickListener btnCategoryListener = new View.OnClickListener(){

            //UI reference for radio buttons
            final RadioButton radBtnGeneral = (RadioButton)findViewById(R.id.radBtnGeneral);
            final RadioButton radBtnBusiness = (RadioButton)findViewById(R.id.radBtnBusiness);
            final RadioButton radBtnEntertainment = (RadioButton)findViewById(R.id.radBtnEntertainment);
            final RadioButton radBtnHealth = (RadioButton)findViewById(R.id.radBtnHealth);
            final RadioButton radBtnScience = (RadioButton)findViewById(R.id.radBtnScience);
            final RadioButton radBtnSports = (RadioButton)findViewById(R.id.radBtnSports);
            final RadioButton radBtnTechnology = (RadioButton)findViewById(R.id.radBtnTecgnology);


            @Override
            public void onClick(View v) {

                //checking which radio button is checked
                if(radBtnGeneral.isChecked()){
                    selectedCategory = "general";
                } else if(radBtnBusiness.isChecked()){
                    selectedCategory = "business";
                } else if(radBtnEntertainment.isChecked()){
                    selectedCategory = "entertainment";
                } else if(radBtnHealth.isChecked()){
                    selectedCategory = "health";
                } else if(radBtnScience.isChecked()){
                    selectedCategory = "science";
                } else if(radBtnSports.isChecked()){
                    selectedCategory = "sports";
                } else if(radBtnTechnology.isChecked()){
                    selectedCategory = "technology";
                }

                //creating the endpoint(URL) for fetching data
                final String API = "&apiKey=9220d9a452ce4cdf9f7ad25b91fb20da";
                final String KEYWORD_SEARCH = "q="+givenKeyWords;
                final String LOCATION = "&country="+selectedLocation;
                final String CATEGORY = "&category="+selectedCategory;
                final String URL_PREFIX = "  https://newsapi.org/v2/top-headlines?";

                url = URL_PREFIX + KEYWORD_SEARCH + LOCATION + CATEGORY + API;

                Intent categoryPageIntent = new Intent(CategoryActivity.this,NewsListActivity.class);

                startActivity(categoryPageIntent);

            }//end of onclick
        };
        btnCategory.setOnClickListener(btnCategoryListener);
    }//end of on create



}//end of CategoryActivity class