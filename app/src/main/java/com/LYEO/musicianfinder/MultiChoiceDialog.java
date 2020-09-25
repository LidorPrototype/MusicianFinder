package com.LYEO.musicianfinder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.cardview.widget.CardView;

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
    private List<Instruments> instrumentsList;
    boolean isSelected = false;

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

        GridViewAdapter adapter = new GridViewAdapter(getActivity(), names, numbers);
        gridViewDialog.setAdapter(adapter);

        gridViewDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CardView cardView = (CardView) gridViewDialog.getChildAt(position);
                if (!isSelected) {
                    //Change background color
                    cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                    listOfItems.add(instrumentsList.get(position));

                }else {
                    //Change background color
                    cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                    listOfItems.remove(instrumentsList.get(position));
                }
                isSelected = (!isSelected);
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
                        StringBuilder tmp = new StringBuilder();
                        for (int k = 0; k < listOfItems.size(); k++){
                            tmp.append(listOfItems.get(k).toString());
                            tmp.append(", ");
                        }
                        Toast.makeText(getActivity(), "" + tmp.toString(), Toast.LENGTH_SHORT).show();
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

}






































