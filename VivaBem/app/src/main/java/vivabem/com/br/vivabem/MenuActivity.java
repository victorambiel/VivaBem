package vivabem.com.br.vivabem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Victor on 11/04/2016.
 */
public class MenuActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewDengue;
    private TextView textViewDepressao;
    private TextView textViewDoencasCoracao;
    private TextView textViewCancer;
    private TextView textViewZikaVirus;
    private TextView textViewSobre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setOpcoes();
        setActions();
    }

    private void setOpcoes(){
        imageView = (ImageView) findViewById(R.id.iv_menu);
        textViewDengue = (TextView) findViewById(R.id.tv_item_dengue);
        textViewDepressao = (TextView) findViewById(R.id.tv_item_depressao);
        textViewDoencasCoracao = (TextView) findViewById(R.id.tv_item_coracao);
        textViewCancer = (TextView) findViewById(R.id.tv_item_cancer);
        textViewZikaVirus = (TextView) findViewById(R.id.tv_item_zika);
        textViewSobre = (TextView) findViewById(R.id.tv_menu_sobre);
    }

    private void setActions(){
        textViewDengue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetalhes(31);
            }
        });

        textViewDepressao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetalhes(32);
            }
        });

        textViewDoencasCoracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToConteudo(1);
            }
        });

        textViewCancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToConteudo(2);
            }
        });

        textViewZikaVirus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetalhes(33);
            }
        });

        textViewSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSobre();
            }
        });
    }

    /* Se o usuário selecionar uma doença que não tenha subseções, como Dengue, Depressão e Zika vírus. */
    private void goToDetalhes(int num){
        Intent intent = new Intent(MenuActivity.this, DetalhesActivity.class);
        intent.putExtra("conteudo", num);
        startActivity(intent);
    }

    /* Se o usuário selecionar uma opção que contenha conteúdos específicos, como Coração e Câncer,
     * que contém subseções de doenças desses temas. */
    private void goToConteudo(int num){
        Intent intent = new Intent(MenuActivity.this, MainActivity.class);
        intent.putExtra("tema", num);
        startActivity(intent);
    }

    /* Se o usuário selecionar a opção Sobre. */
    private void goToSobre(){
        Intent intent = new Intent(MenuActivity.this, SobreActivity.class);
        startActivity(intent);
    }
}
