package com.android.latestnewsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.HashMap;

class CustomAdapter extends BaseAdapter {

    //variable declaration
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    String[] titleArray;
    String[] imgUrlArray;
    String[] descriptionArray;
    String[] authorArray;
    String[] timeArray;
    int size;


    public CustomAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data = d;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        size = data.size();

        //adding datas of all articles in respective arrays
        titleArray = new String[size];
        imgUrlArray = new String[size];
        descriptionArray = new String[size];
        authorArray = new String[size];
        timeArray = new String[size];

        for (int i = 0; i < data.size(); i++) {
            HashMap<String, String> hashmap = data.get(i);
            String title = hashmap.get("title");
            String imgUrl = hashmap.get("urlToImage");
            String description = hashmap.get("description");
            String author = hashmap.get("author");
            String time = hashmap.get("publishedAt");
            //null check
            if (title.equals("null")) {
                title = " ";
            }
            if (description.equals("null")) {
                description = " ";
            }
            if (author.equals("null")) {
                author = " ";
            }
            if (time.equals("null")) {
                time = " ";
            } else {
                time = time.replace("T", " ");
                time = time.replace("Z", "");
            }
            titleArray[i] = title;
            imgUrlArray[i] = imgUrl;
            descriptionArray[i] = description;
            authorArray[i] = author;
            timeArray[i] = time;

        }

        convertView = LayoutInflater.from(activity).inflate(
                R.layout.custom_news, parent, false);

        //ui reference
        ImageView imgNews = (ImageView) convertView.findViewById(R.id.imgNews);
        TextView txtNewsTitle = (TextView) convertView.findViewById(R.id.txtNewsTitle);
        TextView txtNewsDescription = (TextView) convertView.findViewById(R.id.txtNewsDescription);
        TextView txtNewsAuthor = (TextView) convertView.findViewById(R.id.txtNewsAuthor);
        TextView txtNewsTime = (TextView) convertView.findViewById(R.id.txtNewsTime);

        //setting default image if there is no url for image
        if (imgUrlArray[position].equals("null")) {
            imgNews.setImageResource(R.drawable.imageicon);
        } else {
            Picasso.with(activity).load(imgUrlArray[position]).resize(350, 300).into(imgNews);
        }

        //setting User Interface components
        txtNewsTitle.setText(titleArray[position]);
        txtNewsDescription.setText(descriptionArray[position]);
        txtNewsAuthor.setText(authorArray[position]);
        txtNewsTime.setText(timeArray[position]);

        return convertView;
    }
}//end of adapter