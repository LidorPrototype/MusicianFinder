package com.LYEO.musicianfinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import java.util.ArrayList;

/**
 * Created by Lidor on 9/25/2020.
 * Developer name: L-ES
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
    private ArrayList<CardViewItem> mCardViewItems;

    public GridViewAdapter(Context c, String[] _names, int[] _numbers, ArrayList<CardViewItem> cardViewItems){
        this.context = c;
        this.names = _names;
        this.numbers = _numbers;
        this.mCardViewItems = cardViewItems;
    }

    @Override
    public int getCount() {
        return mCardViewItems.size();
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
            convertView = inflater.inflate(R.layout.instrument_item_container, null);
        }

        CardViewItem currentItem = mCardViewItems.get(position);
        CardView cardView = convertView.findViewById(R.id.ItemCardView);
        ImageView imageView = convertView.findViewById(R.id.image_instrument_icon);
        TextView textView = convertView.findViewById(R.id.text_instrument_name);

        cardView.setCardBackgroundColor(currentItem.getmColorResource());
        imageView.setImageResource(currentItem.getImageResource());
        textView.setText(currentItem.getName());

        return convertView;
    }
}




































