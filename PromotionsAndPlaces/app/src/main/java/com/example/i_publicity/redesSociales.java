package com.example.i_publicity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class redesSociales extends AppCompatActivity {
    int contador = 0;
    WebView WB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redes_sociales);


        WB = (WebView)findViewById(R.id.webView);
        WB.getSettings().setJavaScriptEnabled(true);
        WB.getSettings().setBuiltInZoomControls(true);
        Bundle bundle = getIntent().getExtras();
        String dato = bundle.getString("direccion");
        WB.loadUrl("http://"+dato);

        WB.setWebViewClient(new WebViewClient(){
            public boolean shoudOverriceUrlLoading(WebView v, String url){
                return false;
            }
        });
    }
    @Override
    public void onBackPressed() {
        if(contador==0){
            Toast.makeText(getApplicationContext(),"Presione de nuevo para salir", Toast.LENGTH_SHORT).show();
            contador++;
        }else{
            super.onBackPressed();
        }
        new CountDownTimer(3000,1000){
            @Override
            public void onTick(long l) {
            }
            @Override
            public void onFinish() {
                contador=0;
            }
        }.start();
    }
}