package com.LYEO.musicianfinder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.ArrayList;
import java.util.List;

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
public class MultiChoiceDialog extends AppCompatDialogFragment {

    private GridView gridViewDialog;
    private Configuration configuration;
    private String[] names = new String[79];
    private int[] numbers = new int[79];
    private ArrayList<Instruments> listOfItems = new ArrayList<>();
    private ArrayList<CardViewItem> itemInstrumentList;
    private List<Instruments> instrumentsList;
    private GridViewAdapter adapter;
    private MultiChoiceDialogListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (MultiChoiceDialogListener) context;
        } catch (ClassCastException e) {
            throw  new ClassCastException(context.toString() +
                    " must implement MultiChoiceDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.multi_choice_dialog, null);

        configuration = new Configuration();
        instrumentsList = configuration.getInstruments();
        initLists();

        gridViewDialog = view.findViewById(R.id.GridViewDialog);

        itemInstrumentList = new ArrayList<>();
        for (int f = 0; f < names.length; f++){
            itemInstrumentList.add(new CardViewItem(names[f], numbers[f], Color.TRANSPARENT));
        }

        adapter = new GridViewAdapter(getActivity(), names, numbers, itemInstrumentList);
        gridViewDialog.setAdapter(adapter);

        gridViewDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (!(itemInstrumentList.get(position).isSelected())) {
                    itemInstrumentList.get(position).setSelected(true);
                    itemInstrumentList.get(position).setmColorResource(Color.CYAN);
                    listOfItems.add(instrumentsList.get(position));

                }else {
                    itemInstrumentList.get(position).setSelected(false);
                    itemInstrumentList.get(position).setmColorResource(Color.TRANSPARENT);
                    listOfItems.remove(instrumentsList.get(position));
                }
                adapter.notifyDataSetChanged();
            }
        });

        builder.setView(view)
                .setTitle("Choose!!!")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(listOfItems.isEmpty()){
                            listener.applyData(listOfItems, 0);
                        }else{
                            listener.applyData(listOfItems, 1);
                        }
                    }
                });

        return  builder.create();
    }

    private void initLists(){
        for (int c = 0; c < instrumentsList.size(); c++){
            names[c] = instrumentsList.get(c).getInstrument();
            numbers[c] = instrumentsList.get(c).getID();
        }
    }

    public interface MultiChoiceDialogListener{
        void applyData(ArrayList<Instruments> _listOfItems, int flag);// 0 - Empty, 1 - Full
    }

}






































