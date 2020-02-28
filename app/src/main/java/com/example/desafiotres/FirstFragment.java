package com.example.desafiotres;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView pregunta,categoria,dificultad;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button button;


    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_first, container, false);
            iniciarVistas(view);

            pregunta.setText(mParam1);
            categoria.setText(mParam2);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(getContext(),"HOLAAAAAA",Toast.LENGTH_SHORT).show();
                    pasarAlOtro();

                    shareWithWhatsApp(v);

                }
            });


            return view;
    }



    private void iniciarVistas(View view){

        pregunta=view.findViewById(R.id.textViewDos);
        categoria=view.findViewById(R.id.textViewCuatro);
        dificultad =view.findViewById(R.id.textViewSeis);
        button = view.findViewById(R.id.botonUno);
    }

    private void pasarAlOtro(){

        SecondFragment secondFragment=SecondFragment.newInstance("","");
        getActivity()
        .getSupportFragmentManager()
                .beginTransaction()
                //.add(R.id.frameLayout,secondFragment,"SEGUNDO_FRAGMENTO")
                .replace(R.id.frameLayout,secondFragment,"SEGUNDO FRAGMENTO")
                .addToBackStack("SEGUNDO_FRAGMENTO")
                .commit();


    }

    public void shareWithWhatsApp(View v){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "¡Hola! te comparto mi niota obtenida hoy: " +
                pregunta.getText().toString());
        sendIntent.setType("text/plain");
        //sendIntent.setPackage("com.whatsapp");
        //startActivity(sendIntent);

        //setResult(Activity.RESULT_OK,sendIntent);
        //startActivityForResult(sendIntent, 2);



    }









}//class
