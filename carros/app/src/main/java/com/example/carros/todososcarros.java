package com.example.carros;

import static com.example.carros.mediapreco.reference;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link todososcarros#newInstance} factory method to
 * create an instance of this fragment.
 */
public class todososcarros extends Fragment {
    RecyclerView rvtodos;
    ImageView logotodos;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public todososcarros() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment todososcarros.
     */
    // TODO: Rename and change types and number of parameters
    public static todososcarros newInstance(String param1, String param2) {
        todososcarros fragment = new todososcarros();
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
        View v = inflater.inflate(R.layout.fragment_todososcarros, container, false);
        rvtodos = v.findViewById(R.id.rvtodos);
        logotodos = v.findViewById(R.id.logotodos);
        carrega();
        return v;
    }

    public void carrega() {

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Carro> lista = new ArrayList<>();
                for (DataSnapshot dn : snapshot.getChildren()) {
                    Carro c = (Carro) dn.getValue(Carro.class);
                    lista.add(c);
                }
                Recycleraptertodos adapter = new Recycleraptertodos(getContext(), lista, c -> {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
                    alerta.setTitle("Excluir");
                    String mensagem = "Marca: " + c.getmarca() + "\nModelo: " + c.getModelo() + "\nPlaca: " + c.getPlaca() + "\nAno: " + c.getAno() + "\nPreço  : " + c.getpreco();
                    alerta.setMessage(mensagem);
                    alerta.setPositiveButton("Remover", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //dn.getRef().removeValue(); //remove um item do firebase
                        }
                    });
                    alerta.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    alerta.show();
                });
                rvtodos.setAdapter(adapter);
                rvtodos.setHasFixedSize(true);
                rvtodos.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}