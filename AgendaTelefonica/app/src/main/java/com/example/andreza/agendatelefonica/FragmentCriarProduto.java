package com.example.andreza.agendatelefonica;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.andreza.agendatelefonica.model.Produto;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentCriarProduto extends Fragment {

    CriarProdutoActions listener;


    public FragmentCriarProduto() {
        // Required empty public constructor
    }

    public interface CriarProdutoActions{
        void criarProduto(Produto produto);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof CriarProdutoActions){
            listener = (CriarProdutoActions) context;
        }else{
            throw new ClassCastException("Activity não implementa CriarContatoActions");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_criar_produto, container, false);


//        todo: pq mesmo tem q ser final?
        Button buttonCriar = view.findViewById(R.id.btn_criar_produto_id);
        final TextInputEditText editTextNomeProduto = view.findViewById(R.id.edit_text_nome_produto_id);
        final TextInputEditText editTextNomeLoja = view.findViewById(R.id.edit_text_nome_loja_id);
        final TextInputEditText editTextEnderecoLoja = view.findViewById(R.id.edit_text_endereco_loja_id);
        final TextInputEditText editTextPrecoProduto = view.findViewById(R.id.edit_text_preco_produto_id);
        final TextInputEditText editTextObservacoes = view.findViewById(R.id.edit_text_anotacoes_produto_id);


        buttonCriar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                criarProduto (editTextNomeProduto, editTextNomeLoja, editTextEnderecoLoja, editTextPrecoProduto, editTextObservacoes);
            }
        });

        return view;
    }

    private void criarProduto(TextInputEditText editTextNomeProduto, TextInputEditText editTextNomeLoja, TextInputEditText editTextEnderecoLoja, TextInputEditText editTextPrecoProduto, TextInputEditText editTextObservacoes) {

        Produto produto = new Produto();
        produto.setNomeDoProduto(editTextNomeProduto.getEditableText().toString());
        produto.setNomeDaLoja(editTextNomeLoja.getEditableText().toString());
        produto.setEnderecoLoja(editTextEnderecoLoja.getEditableText().toString());

//        TODO: ENTENDER PQ TA VERMELHO TEM A VER COM DOUBLE: o q fazer pra corrigir esse erro?
// todo: depois daqui pra onde ele ta indo? onde estou usando esse double?
        produto.setPrecoDoProduto(editTextPrecoProduto.getEditableText().toString());
        produto.setNotasSobreOProduto(editTextObservacoes.getEditableText().toString());


        listener.criarProduto(produto);

//        todo: se os produtos forem nulos deixar criar mesmo assim e mostrar o campo em branco.

    }
}


//todo: fazer uma outra activity que seja acionada qdo o usuario clicar na celula do item e q mostre os detalhes completos
// do produto com botato trash e checkbox
//todo: fazer a logica do botao trash => qdo ela clicar, o produto eh apagado
//todo fazer a logica do checkbox => qdo ela clicar, significa q ela ja comprou o produto, entao esse produto vai pro fim da lista.
//todo fazer o firebase do criar produto
//todo como muda a cor do nome do app?
//todo cor de fundo na inicial.. vejo 2 cores, queria soh um branco e nao 2. como corrige isso?

//todo habilitar no endereco da loja o google maps com opcao full.
//todo habilitar o search para buscar os produtos por nome, buscar a cada letra digitada
//todo habilitar o comando de voz do search para busca dos produtos cadastrados (????)