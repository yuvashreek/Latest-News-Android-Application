package com.android.latestnewsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    //change key to general value so that if not selected general value will be given as input
    //for example if no keyword given make keyword general or make null

    public  static final String KEYWORDS_KEY = "KEYWORDS",LOCATION_KEY = "COUNTRY";
    private String selectedLocation;
    private String givenKeyWords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //getting extras
        Intent myIntent = getIntent();
        Bundle myExtras = myIntent.getExtras();

        selectedLocation = myExtras.getString(LOCATION_KEY).toString();
        givenKeyWords = myExtras.getString(KEYWORDS_KEY).toString();

        //getting UI elemnts
        Button btnCategory = (Button)findViewById(R.id.btnCategory);

        View.OnClickListener btnCategoryListener = new View.OnClickListener(){

            //UI reference for radio button
            final RadioButton radBtnGeneral = (RadioButton)findViewById(R.id.radBtnGeneral);
            final RadioButton radBtnBusiness = (RadioButton)findViewById(R.id.radBtnBusiness);
            final RadioButton radBtnEntertainment = (RadioButton)findViewById(R.id.radBtnEntertainment);
            final RadioButton radBtnHealth = (RadioButton)findViewById(R.id.radBtnHealth);
            final RadioButton radBtnScience = (RadioButton)findViewById(R.id.radBtnScience);
            final RadioButton radBtnSports = (RadioButton)findViewById(R.id.radBtnSports);
            final RadioButton radBtnTechnology = (RadioButton)findViewById(R.id.radBtnTecgnology);



            @Override
            public void onClick(View v) {

                Intent categoryPageIntent = new Intent();


                //checking which radio button is checked
                if(radBtnGeneral.isChecked()){
                    //get from request api and send data to news list

                }


            }//end of onclick
        };
    }//end of on create
}//end of CategoryActivity class
