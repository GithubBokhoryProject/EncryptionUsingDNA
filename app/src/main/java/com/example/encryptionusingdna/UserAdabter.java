package com.example.encryptionusingdna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UserAdabter extends ArrayAdapter<User> {
    Context context;
    public UserAdabter(Context context, List<User> objects) {
        super(context, 0, objects);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.raw_images,parent,false);
        ImageView imageView=convertView.findViewById(R.id.imgs_dna);
        User convertuser=getItem(position);
        Picasso.get().load(convertuser.getImagedna()).into(imageView);
        return convertView;
    }
}
