package com.example.andreza.agendatelefonica.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.andreza.agendatelefonica.model.Produto;
import com.example.andreza.agendatelefonica.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewContatoAdapter extends RecyclerView.Adapter<RecyclerViewContatoAdapter.ViewHolder> {

//    o recycler view responde a 3 perguntas: qtos serao exibidos, qual xml sera exibido e q conteudo sera exibido:





    private List<Produto> produtoList = new ArrayList<>();


//    qual xml sera exibido
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_item, viewGroup, false);
        return new ViewHolder(view);
    }


//  quantos serao exibidos
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Produto produto = produtoList.get(i);
        viewHolder.bind(produto);
    }

    @Override
    public int getItemCount() {
        return produtoList.size();
    }

    public void addProduto(Produto produto){
        produtoList.add(produto);
        notifyItemChanged(getItemCount());
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textProduto;
        TextView textNomeDaLojaDoProduto;
        TextView textoEnderecoDaLoja;
        TextView textPrecoDoProduto;
        TextView textNotasDoProduto;


//        que conteudo sera exibido:

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textProduto = itemView.findViewById(R.id.text_view_produto_id);
//            textNomeDaLojaDoProduto = itemView.findViewById(R.id.text_view_nome_loja_id);
//            textoEnderecoDaLoja = itemView.findViewById(R.id.text_);
//            textPrecoDoProduto = itemView.findViewById(R.id.text_view_preco_id);
//            textNotasDoProduto = itemView.findViewById(R.id.text_view_Obs__id);

        }

        public void bind(Produto produto) {
//            textNotasDoProduto.setText(produto.getNotasSobreOProduto());
//            textPrecoDoProduto.setText(String.valueOf(produto.getPrecoDoProduto()));
//            textoEnderecoDaLoja.setText(produto.getEnderecoLoja());
            textProduto.setText(produto.getNomeDoProduto());
//            textNomeDaLojaDoProduto.setText(produto.getNomeDaLoja());
//
        }
    }

}
