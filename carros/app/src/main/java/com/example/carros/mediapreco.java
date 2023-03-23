package com.example.carros;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link mediapreco#newInstance} factory method to
 * create an instance of this fragment.
 */
public class mediapreco extends Fragment {
    RecyclerView rvmedia;
    ImageView logomedia;
    static DatabaseReference reference;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public mediapreco() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment mediapreco.
     */
    // TODO: Rename and change types and number of parameters
    public static mediapreco newInstance(String param1, String param2) {
        mediapreco fragment = new mediapreco();
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
        View v = inflater.inflate(R.layout.fragment_mediapreco, container, false);
        rvmedia = v.findViewById(R.id.rvmedia);
        logomedia = v.findViewById(R.id.logomedia);
        logomedia.setOnClickListener(view -> {
            carrega();
        });
        return v;
    }
    public void carrega(){

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<carros> lista = new ArrayList<>();
                for (DataSnapshot dn : snapshot.getChildren()) {
                    carros c = (carros) dn.getValue(carros.class);
                    lista.add(c);
                }
                Recycleradaptermedia adapter = new Recycleradaptermedia(getContext(),lista,c -> {
                    AlertDialog.Builder alerta = new AlertDialog.Builder(getContext());
                    alerta.setTitle(c.getPlaca());
                    String mensagem = "Placa: "+c.getPlaca()+"\nMarca: "+c.getmarca()+"\nModelo: "+c.getModelo()+"\nAno: "+c.getAno()+"\nPreço: "+c.getpreco();
                    alerta.setMessage(mensagem);
                    alerta.show();
                });
                rvmedia.setAdapter(adapter);
                rvmedia.setHasFixedSize(true);
                rvmedia.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}