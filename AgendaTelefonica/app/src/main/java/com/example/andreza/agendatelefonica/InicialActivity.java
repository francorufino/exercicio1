package com.example.andreza.agendatelefonica;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.andreza.agendatelefonica.adapter.RecyclerViewContatoAdapter;
import com.example.andreza.agendatelefonica.model.Produto;

public class InicialActivity extends AppCompatActivity implements FragmentCriarProduto.CriarProdutoActions{

    private RecyclerViewContatoAdapter adapter;
    private FragmentCriarProduto fragmentCriarProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        setupRecyclerView();

        FloatingActionButton fab = findViewById(R.id.fab_id);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                fragmentCriarProduto = new FragmentCriarProduto();
//              TODO  PQ REPLACE SE ELE NAO ESTA REPLACING NADA? SOH ESTA ADDING!
                transaction.replace(R.id.container_to_be_replaced_id, fragmentCriarProduto);
                transaction.commit();
            }
        });
    }

//
////      aqui eh onde eu faco a ponte de comunicacao entre o xml e o java no recycler view:
//        RecyclerView rv = findViewById(R.id.recycler_produtos_id);
//        RecyclerViewContatoAdapter adapter = new RecyclerViewContatoAdapter();
//        rv.setAdapter(adapter);


    private void setupRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recycler_produtos_id);
        RecyclerViewContatoAdapter adapter = new RecyclerViewContatoAdapter();
        recyclerView.setAdapter(adapter);
//        TODO o porque dessa classe linearlayoutmanager?como ela faz esse gerenciamento?->
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void criarProduto(Produto produto) {
        adapter.addProduto(produto);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.remove(fragmentCriarProduto);

        transaction.commit();
    }
}
