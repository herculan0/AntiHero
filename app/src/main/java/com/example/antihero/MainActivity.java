package com.example.antihero;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView fotoDoCamarada;
    ImageView herois;
    LinearLayout inicio;
    LinearLayout resultado;
    Button botao;
    TextView textView;
    ArrayList<String> fotos = new ArrayList<String>();
    int CAMERA_REQUEST = 1888;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        herois = findViewById(R.id.heroi);
        fotos.add("baco");
        fotos.add("coringa");
        fotos.add("deadpool");
        fotos.add("gracehopper");
        fotos.add("jaspion");
        fotos.add("mrrobot");
        fotos.add("mulhermaravilha");
        fotos.add("neo");
        fotos.add("rochelle");
        fotos.add("samueljackson");
        fotos.add("superchoque");
        fotos.add("terrycrews");
        fotos.add("trinity");
        fotos.add("watchmen");

        inicio = findViewById(R.id.inicio);
        resultado = findViewById(R.id.resultado);
        botao = findViewById(R.id.botao);
        fotoDoCamarada = findViewById(R.id.foto);
        textView = findViewById(R.id.textView);
        // exibirSorteado();
        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    private String sortear() {
        Random sortiador = new Random();
        int sorteado = sortiador.nextInt(fotos.size());
        return fotos.get(sorteado);
    }

    private void exibirSorteado() {
        String fotoSorteado = sortear();
        textView.setText("Você se parece com " + fotoSorteado);
        herois.setImageResource(getResources().getIdentifier(fotoSorteado,"drawable", "com.example.antihero"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            inicio.setVisibility(View.GONE);
            resultado.setVisibility(View.VISIBLE);
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            fotoDoCamarada.setImageBitmap(photo);
            exibirSorteado();
        }
    }
}

// Biblioteca de permissão


// array_list && inicializar
