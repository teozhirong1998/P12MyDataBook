package com.example.a16022635.p12_mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VaccinationFragment extends Fragment {

    TextView tvContent;
    Button btnEdit;

    public VaccinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_bio, container, false);
        tvContent = (TextView) v.findViewById(R.id.tvContent);
        btnEdit = (Button) v.findViewById(R.id.btnEdit);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String vaccination = preferences.getString("vaccination", "Vaccination");
        tvContent.setText(vaccination);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vacDialog();
            }
        });

        return v;
    }

    private void vacDialog() {
        LayoutInflater inflater = (LayoutInflater)
                getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout vaccination =
                (LinearLayout) inflater.inflate(R.layout.bio, null);
        final EditText etVaccination = (EditText) vaccination
                .findViewById(R.id.editText);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Edit Bio")
                .setView(vaccination)
                .setCancelable(false)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String vaccination = etVaccination.getText().toString();
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("vaccination", vaccination);
                        editor.commit();
                        tvContent.setText(vaccination);

                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
