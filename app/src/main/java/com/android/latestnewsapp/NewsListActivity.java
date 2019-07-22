package com.android.latestnewsapp;

import android.app.ListActivity;
import android.os.Bundle;

public class NewsListActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
    }
}
