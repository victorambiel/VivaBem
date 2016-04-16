package vivabem.com.br.vivabem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private CardView primeiroCardView;
    private CardView segundoCardView;
    private CardView terceiroCardView;
    private CardView quartoCardView;
    private CardView quintoCardView;

    private ImageView primeiroImageView;
    private ImageView segundoImageView;
    private ImageView terceiroImageView;
    private ImageView quartoImageView;
    private ImageView quintoImageView;

    private TextView primeiroTextView;
    private TextView segundoTextView;
    private TextView terceiroTextView;
    private TextView quartoTextView;
    private TextView quintoTextView;

    private int tema = 1;
    private int mapa[] = new int[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo);

        tema = getIntent().getIntExtra("tema", 1);

        setCardView();
        setConteudo();
        setActions();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_icon, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.item_menu){
            startActivity(new Intent(this, MenuActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    /* O vetor mapa faz o mapeamente dos conteúdos apresentados na activity_conteúdo.
    * Se o tema for igual a 1, então o conteúdo mapeado será sobre Coração.
    * Se o tema for ogual a 2, então o conteúdo mapeado será sobre Câncer.
    * Quando o usuário seleciona um CardView, é chamado o método goToDetalhes e é passado como
    * parametro o número do CardView, esse número é usado para buscar o conteúdo mapeado no vetor.
    * Exemplo: o conteúdo que está sendo apresentado para o usuário é sobre o Coração, ele clica no
    * terceiro CardView, o método goToDetalhes é chamado e passado o 3 como parametro, esse 3 é usado
    * como index do vetor (mapa[3] é igual a 13), e setado esse valor na intent, para poder preencher
    * com o conteúdo correto no DetalhesActivity.
    */
    private void setConteudo(){
        if(tema == 1) {
            mapa[1] = 11;
            mapa[2] = 12;
            mapa[3] = 13;
            mapa[4] = 14;
            mapa[5] = 15;
            setConteudoCoracao();
        } else if(tema == 2){
            mapa[1] = 21;
            mapa[2] = 22;
            mapa[3] = 23;
            mapa[4] = 24;
            mapa[5] = 25;
            setConteudoCancer();
        }
    }

    private void setConteudoCoracao(){
        primeiroImageView.setImageResource(R.mipmap.arritmia);
        segundoImageView.setImageResource(R.mipmap.parada);
        terceiroImageView.setImageResource(R.mipmap.pericardite);
        quartoImageView.setImageResource(R.mipmap.cardiopatia);
        quintoImageView.setImageResource(R.mipmap.sopro);

        primeiroTextView.setText(R.string.coracao_1_titulo);
        segundoTextView.setText(R.string.coracao_2_titulo);
        terceiroTextView.setText(R.string.coracao_3_titulo);
        quartoTextView.setText(R.string.coracao_4_titulo);
        quintoTextView.setText(R.string.coracao_5_titulo);
    }

    private void setConteudoCancer(){
        primeiroImageView.setImageResource(R.mipmap.mama);
        segundoImageView.setImageResource(R.mipmap.leucemia);
        terceiroImageView.setImageResource(R.mipmap.pulmao);
        quartoImageView.setImageResource(R.mipmap.estomago);
        quintoImageView.setImageResource(R.mipmap.laringe);

        primeiroTextView.setText(R.string.cancer_1_titulo);
        segundoTextView.setText(R.string.cancer_2_titulo);
        terceiroTextView.setText(R.string.cancer_3_titulo);
        quartoTextView.setText(R.string.cancer_4_titulo);
        quintoTextView.setText(R.string.cancer_5_titulo);
    }

    private void setCardView(){
        primeiroCardView = (CardView) findViewById(R.id.cv_primeiro);
        segundoCardView = (CardView) findViewById(R.id.cv_segundo);
        terceiroCardView = (CardView) findViewById(R.id.cv_terceiro);
        quartoCardView = (CardView) findViewById(R.id.cv_quarto);
        quintoCardView = (CardView) findViewById(R.id.cv_quinto);

        primeiroImageView = (ImageView) findViewById(R.id.iv_cont_1);
        segundoImageView = (ImageView) findViewById(R.id.iv_cont_2);
        terceiroImageView = (ImageView) findViewById(R.id.iv_cont_3);
        quartoImageView = (ImageView) findViewById(R.id.iv_cont_4);
        quintoImageView = (ImageView) findViewById(R.id.iv_cont_5);

        primeiroTextView = (TextView) findViewById(R.id.tv_cont_1);
        segundoTextView = (TextView) findViewById(R.id.tv_cont_2);
        terceiroTextView = (TextView) findViewById(R.id.tv_cont_3);
        quartoTextView = (TextView) findViewById(R.id.tv_cont_4);
        quintoTextView = (TextView) findViewById(R.id.tv_cont_5);
    }

    private void setActions(){
        primeiroCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetalhes(1);
            }
        });

        segundoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetalhes(2);
            }
        });

        terceiroCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetalhes(3);
            }
        });

        quartoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetalhes(4);
            }
        });

        quintoCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToDetalhes(5);
            }
        });

    }

    /* Inicia a DetalhesActivity passando como parâmetro qual o conteúdo que será preenchido. */
    private void goToDetalhes(int numCard){
        Intent intent = new Intent(MainActivity.this, DetalhesActivity.class);
        intent.putExtra("conteudo", mapa[numCard]);
        startActivity(intent);
    }

}
