package com.RCOS.runningtally;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


/**
 * Created by steve on 7/14/13.
 */
public class ListAdapter extends ArrayAdapter {

    private final Context context;
    private final List athleteList;

    public ListAdapter(Context context, List athleteList) {
        super(context, R.layout.activity_res_athletes, athleteList);
        this.context = context;
        this.athleteList = athleteList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_res_athletes, parent, false);
        TextView athleteText = (TextView)rowView.findViewById(R.id.athleteText);
        athleteText.setText(athleteList.get(position).toString());
        return rowView;
    }

}
