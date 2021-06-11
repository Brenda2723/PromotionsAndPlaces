package com.example.i_publicity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilFragment extends Fragment {

    @Nullable
    //
    private FirebaseAuth mAuth;
     TextView mTextViewName;
     TextView mTextViewNac;
     TextView mTextViewCP;
    //
    Button mButtonSingOut;
    private DatabaseReference mDatabase;

    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.perfil_fragment, container, false);

        mAuth = FirebaseAuth.getInstance();
        //
        mButtonSingOut = (Button)view.findViewById(R.id.btn_edi3);
        mButtonSingOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                Intent in = new Intent(getActivity(), LoginEntrarActivity.class);
                in.putExtra("some", "some data");
                startActivity(in);
            }
        });
       // mButtonSingOut = (Button) findViewById(R.id.user);

        mTextViewCP=(TextView)view.findViewById(R.id.textViewCP);
        mTextViewNac=(TextView)view.findViewById(R.id.textViewNac);
        mTextViewName=(TextView)view.findViewById(R.id.textViewName);
        mDatabase = FirebaseDatabase.getInstance().getReference();
       /* Button btn_edi = (Button) view.findViewById(R.id.btn_edi);
        btn_edi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), EditarDatos.class);
                in.putExtra("some", "some data");
                startActivity(in);


            }
        });
        */
       // getUserInfo();
       // return view;
        getUserInfo();
        return  view;


    }
    private void getUserInfo() {
        String id = mAuth.getCurrentUser().getUid();

        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String name = dataSnapshot.child("name").getValue().toString();
                    String nacimiento = dataSnapshot.child("nacimiento").getValue().toString();
                    String cp = dataSnapshot.child("cp").getValue().toString();

                    mTextViewName.setText(name);
                    mTextViewNac.setText(nacimiento);
                    mTextViewCP.setText(cp);
                }
            }

            @Override
            public void onCancelled (@NonNull DatabaseError error){
            }
        });
    }




}