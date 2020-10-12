package com.LYEO.musicianfinder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Objects;

/**
 * Created by Lidor on 10/11/2020.
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
public class TOU_PP_Dialog extends AppCompatDialogFragment {

    /**
     * type = 0     -->     TermOfUse + PrivacyPolicy
     * type = 1     -->     Generated Password For User
     * */
    private int type = 0;
    private TextView textViewTOU_Heading, textViewTOU_Body, textViewPP_Heading, textViewPP_Body;
    private LinearLayout linearLayout_high, linearLayout_low;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Objects.requireNonNull(getActivity()), R.style.InfoDialog);
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        final View view = layoutInflater.inflate(R.layout.tof_pp_dialog_layout, null);
        builder.setView(view);

        textViewTOU_Body = view.findViewById(R.id.textView_termOfUse_Body);
        textViewPP_Body = view.findViewById(R.id.textView_privacyPolicy_Body);
        Configuration configurationObj = new Configuration();

        textViewTOU_Body.setText(Html.fromHtml(configurationObj.getAndInitTOU()));
        textViewPP_Body.setText(Html.fromHtml(configurationObj.getAndInitPP()));

        Dialog dialog = builder.create();

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        return dialog;
    }

    private void setType(int _type){
        this.type = _type;
    }

    TOU_PP_Dialog newInstance(int _type){
        TOU_PP_Dialog fragment = new TOU_PP_Dialog();
        fragment.setType(_type);
        return fragment;
    }

}












































