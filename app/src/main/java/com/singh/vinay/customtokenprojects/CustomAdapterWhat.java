package com.singh.vinay.customtokenprojects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by kmidev on 28/3/16.
 */
public class CustomAdapterWhat extends ArrayAdapter<String> {

    int main_int = 0;

    LayoutInflater inflater;
    private Context _context;
    private ArrayList<String> data;

    public CustomAdapterWhat(Context context, int resource, ArrayList<String> objects) {
        super(context, resource, objects);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this._context = context;
        this.data = objects;
        this.main_int = resource;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        //return super.getView(position, convertView, parent);
        View row = convertView;
        if (row == null) {
            try {
                row = inflater.inflate(R.layout.spinner_rows, parent, false);
                final TextView label = (TextView) row.findViewById(R.id.whatSpinner);
                label.setText(getItem(position));
                label.setTag(position);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return row;
    }
}
