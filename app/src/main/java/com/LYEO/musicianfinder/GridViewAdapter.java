package com.LYEO.musicianfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Lidor on 9/25/2020.
 * Website: www.buckystudents.com
 *  _        _   _____     ____    ______
 * | |      |_| |  __ \   / __ \  |  O   |
 * | |      | | | |  | | | |  | | |   ___/
 * | |____  | | | |__| | | |__| | | | \
 * |______| |_| |_____/   \____/  |_|__\
 *  ____         ____
 * |  __|       |  __|
 * |  __|   _   |__  |
 * |____|  |_|  |____|
 */
public class GridViewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private String[] names;
    private int[] numbers;

    public GridViewAdapter(Context c, String[] _names, int[] _numbers){
        this.context = c;
        this.names = _names;
        this.numbers = _numbers;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item_instrument, null);
        }

        ImageView imageView = convertView.findViewById(R.id.image_instrument_icon);
        TextView textView = convertView.findViewById(R.id.text_instrument_name);

        imageView.setImageResource(numbers[position]);
        imageView.setClickable(false);
        textView.setText(names[position]);

        return convertView;
    }
}




































