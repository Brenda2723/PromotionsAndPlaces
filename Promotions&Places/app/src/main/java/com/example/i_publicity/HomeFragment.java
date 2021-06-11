package com.example.i_publicity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    ImageButton btn_face, btn_whats, btn_email;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);



        ImageButton btn_wa = (ImageButton) view.findViewById(R.id.btn_wapp);
        ImageButton btn_face = (ImageButton) view.findViewById(R.id.btn_face);
        ImageButton btn_insta = (ImageButton) view.findViewById(R.id.imageButton_insta);

        btn_wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:449 15 11 514"));
                in.putExtra("some", "some data");
                startActivity(in);
            }

        });
        btn_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), redesSociales.class);
                in.putExtra("direccion","www.facebook.com/DejaVuRestauranteKaraokeBar");
                startActivity(in);
            }

        });

        btn_insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getActivity(), redesSociales.class);
                in.putExtra("direccion","www.instagram.com/explore/locations/304811213537472/deja-vu/");
                startActivity(in);
            }

        });
        return view;
    }


}
