package com.example.a16022635.p12_mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawerArrayAdapter extends android.widget.ArrayAdapter<Title> {

    Context context;
    ArrayList<Title> titles;
    int resource;
    TextView tv;
    ImageView iv;

    public DrawerArrayAdapter(Context context, int resource, ArrayList<Title> titles) {
        super(context, resource, titles);
        this.context = context;
        this.titles = titles;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        //Match the UI components with Java variables
        tv = rowView.findViewById(R.id.tv);

        iv = rowView.findViewById(R.id.iv);

        Title title = titles.get(position);

        //Check if the property for starts >= 5, if so, "light" up the stars
        if (title.getTitle().equals("Bio")) {
            iv.setImageResource(android.R.drawable.ic_menu_info_details);

        } else if (title.getTitle().equals("Vaccination")) {
            iv.setImageResource(android.R.drawable.ic_menu_edit);

        } else if (title.getTitle().equals("Anniversary")) {
            iv.setImageResource(android.R.drawable.ic_menu_my_calendar);

        } else if (title.getTitle().equals("About Us")) {
            iv.setImageResource(android.R.drawable.star_on);
        }

        tv.setText(title.getTitle());

        return rowView;
    }

}
