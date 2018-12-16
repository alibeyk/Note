package com.example.alibeyk.noteprofesional;

import android.content.Context;
import android.graphics.Color;
import android.renderscript.Sampler;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static android.widget.GridLayout.HORIZONTAL;
import static android.widget.GridLayout.VERTICAL;
import static java.util.Optional.of;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerMain;
    private AdapterMain adapterMain;
    Button btnNew;
    ConstraintLayout constrainAddNote;
    EditText edtSubject;
    EditText edtDescribe;
    Button btnAdd;
    List<ModelNote> modelNoteList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_main);
        adapterMain = new AdapterMain(this);
        edtSubject = findViewById(R.id.edt_Subject);
        edtDescribe = findViewById(R.id.edt_Describe);
        recyclerMain = findViewById(R.id.RecyclerMain);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2, VERTICAL, false);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, VERTICAL);
        recyclerMain.setLayoutManager(staggeredGridLayoutManager);
        recyclerMain.setAdapter(adapterMain);
        btnNew = findViewById(R.id.btnNew);
        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constrainAddNote = findViewById(R.id.Constrain_Add_Note);
                constrainAddNote.setVisibility(View.VISIBLE);
            }
        });
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                constrainAddNote.setVisibility(View.GONE);
                ModelNote newmodelnote = new ModelNote();
                newmodelnote.setSubject(edtSubject.getText().toString());
                newmodelnote.setDescribe(edtDescribe.getText().toString());
                switch (ModelNote.colorCounter) {
                    case 0:
                        newmodelnote.setColor("#FF1B80D8");
                        ModelNote.colorCounter++;
                        break;
                    case 1:
                        newmodelnote.setColor("#FF6DD81B");
                        ModelNote.colorCounter++;
                        break;
                    case 2:
                        newmodelnote.setColor("#FFFF0095");
                        ModelNote.colorCounter++;
                        break;
                    case 3:
                        newmodelnote.setColor("#FF1BD8D8");
                        ModelNote.colorCounter++;
                        break;
                    case 4:
                        newmodelnote.setColor("#FFD81B60");
                        ModelNote.colorCounter = 0;
                        break;

                }
                adapterMain.addNote(newmodelnote);


            }


        });


    }

}
