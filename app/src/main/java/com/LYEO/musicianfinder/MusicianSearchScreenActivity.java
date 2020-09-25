package com.LYEO.musicianfinder;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MusicianSearchScreenActivity extends AppCompatActivity implements SearchView.OnQueryTextListener  {

    // Declare Variables
    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    Configuration configuration = new Configuration();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_search_screen);
        list = (ListView) findViewById(R.id.listview);


        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, configuration.getInstruments());

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.simpleSearchView);
        editsearch.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}


class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private List<Instruments> InstrumentsNameList = null;
    private ArrayList<Instruments> arraylist;

    public ListViewAdapter(Context context, List<Instruments> InsturmnetsNamesList) {
        mContext = context;
        this.InstrumentsNameList = InsturmnetsNamesList;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<Instruments>();
        this.arraylist.addAll(InsturmnetsNamesList);
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return InstrumentsNameList.size();
    }

    @Override
    public Instruments getItem(int position) {
        return InstrumentsNameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.instrument_item_container, null);
            // Locate the TextViews in listview_item.xml
//            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(InstrumentsNameList.get(position).getInstrument());
        return view;
    }

    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        InstrumentsNameList.clear();
        if (charText.length() == 0) {
            InstrumentsNameList.addAll(arraylist);
        } else {
            for (Instruments wp : arraylist) {
                if (wp.getInstrument().toLowerCase(Locale.getDefault()).contains(charText)) {
                    InstrumentsNameList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}