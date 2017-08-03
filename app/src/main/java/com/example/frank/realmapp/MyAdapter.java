package com.example.frank.realmapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.frank.realmapp.Model.Usuario;

import java.util.List;

/**
 * Created by Frank on 29/07/2017.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Usuario> usuarios;

    public MyAdapter(Context context, int layout, List<Usuario> usuarios) {
        this.context = context;
        this.layout = layout;
        this.usuarios = usuarios ;
    }

    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int position) {
        return this.usuarios.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        ViewHolder holder;


        if (convertView == null) {
            // Inflamos la vista que nos ha llegado con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            // Referenciamos el elemento a modificar y lo rellenamos
            holder.userTextView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Nos traemos el valor actual dependiente de la posición
        Usuario currentUser = usuarios.get(position);
        //currentName = (String) getItem(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        holder.userTextView.setText(currentUser.getNombre());

        // devolvemos la vista inflada y modificada con nuestros datos


        return  convertView;

    }

    static class ViewHolder {
        private TextView userTextView;
    }
}
