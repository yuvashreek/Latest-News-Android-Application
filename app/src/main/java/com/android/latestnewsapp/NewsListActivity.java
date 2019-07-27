package com.android.latestnewsapp;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.android.latestnewsapp.CategoryActivity.dataSize;

public class NewsListActivity extends AppCompatActivity {
    public static final String SIZE_KEY = "SIZE";
    public static int dataSize;
    //public static TextView data;
    public static  ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
    String[] titleArray  ;
    String[] imgUrlArray ;
    String[] descriptionArray ;
    String[] authorArray ;
    String[] timeArray ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);

        NewsData newsData=new NewsData();
        newsData.execute();






    }//end of on create

    public class NewsData extends AsyncTask<Void,Void,Void> {
        //whole json file
        ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();
        static final String KEY_AUTHOR = "author";
        static final String KEY_TITLE = "title";
        static final String KEY_DESCRIPTION = "description";
        static final String KEY_URL = "url";
        static final String KEY_URLTOIMAGE = "urlToImage";
        static final String KEY_PUBLISHEDAT = "publishedAt";


        //backgroud thread
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                HttpHandler sh = new HttpHandler();
                // Making a request to url and getting response
                String url = CategoryActivity.url;
                String jsonStr = sh.makeServiceCall(url);
                Log.e("error", "Response from url: " + jsonStr);


                if (jsonStr != null) {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    // Getting JSON Array node
                    JSONArray articles = jsonObj.getJSONArray("articles");
                    for (int i = 0; i < articles.length(); i++) {
                        JSONObject c = articles.getJSONObject(i);
                    /*title = c.getString("title");
                    author = c.getString("author");
                    Log.d("title", title);
                    Log.d("author", author);*/
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put(KEY_AUTHOR, c.getString(KEY_AUTHOR));
                        map.put(KEY_TITLE, c.getString(KEY_TITLE));
                        map.put(KEY_DESCRIPTION, c.getString(KEY_DESCRIPTION));
                        map.put(KEY_URL, c.getString(KEY_URL));
                        map.put(KEY_URLTOIMAGE, c.getString(KEY_URLTOIMAGE));
                        map.put(KEY_PUBLISHEDAT, c.getString(KEY_PUBLISHEDAT));
                        dataList.add(map);

                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        //UI thread
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            //ui reference
            ListView listNews = (ListView)findViewById(R.id.listNews);

            CustomAdapter cus = new CustomAdapter(NewsListActivity.this, dataList);
            listNews.setAdapter(cus);




            //NewsListActivity.data = dataList;

        }
    }//end of news data class


}//end of class news list activity


