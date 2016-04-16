package vivabem.com.br.vivabem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Victor on 05/04/2016.
 */
public class DetalhesActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textViewTitulo;
    private TextView textViewConteudo_1;
    private TextView textViewConteudo_2;
    private int conteudo;
    private String tema = "";
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

        //Recebe qual conteúdo será apresentado para o usuário.
        conteudo = getIntent().getIntExtra("conteudo", 11);

        setUI();
        setDados();
    }

    private void setUI(){
        imageView = (ImageView) findViewById(R.id.iv_detelahe);
        textViewTitulo = (TextView) findViewById(R.id.tv_det_titulo);
        textViewConteudo_1 = (TextView) findViewById(R.id.tv_det_conteudo_1);
        textViewConteudo_2 = (TextView) findViewById(R.id.tv_det_conteudo_2);
    }

    private void setDados(){
        String titulo = "";
        String conteudo_1 = "";
        String conteudo_2 = "";
        int imageId = 0;

        /* O switch tem como finalidade preencher o conteúdo conforme a opção que o usuário selecionou.
        * Iniciados com 1 (11, 12, 13, 14, 15) serão sempre sobre o Coração, selecionados a partir
        * de um CardView.
        * Iniciados com 2 (21, 22, 23, 24, 25) serão sempre sobre Câncer, selecionados a partir de
        * um CardView.
        * Iniciados com 3 (31, 32, 33) são assuntos específicos selecionados a partir do Menu. */
        switch (conteudo){
            case 11:
                imageId = R.mipmap.arritmia;
                titulo = getString(R.string.coracao_1_titulo);
                conteudo_1 = getString(R.string.coracao_1_conteudo_1);
                conteudo_2 = getString(R.string.coracao_1_conteudo_2);
                break;
            case 12:
                imageId = R.mipmap.parada;
                titulo = getString(R.string.coracao_2_titulo);
                conteudo_1 = getString(R.string.coracao_2_conteudo_1);
                conteudo_2 = getString(R.string.coracao_2_conteudo_2);
                break;
            case 13:
                imageId = R.mipmap.pericardite;
                titulo = getString(R.string.coracao_3_titulo);
                conteudo_1 = getString(R.string.coracao_3_conteudo_1);
                conteudo_2 = getString(R.string.coracao_3_conteudo_2);
                break;
            case 14:
                imageId = R.mipmap.cardiopatia;
                titulo = getString(R.string.coracao_4_titulo);
                conteudo_1 = getString(R.string.coracao_4_conteudo_1);
                conteudo_2 = getString(R.string.coracao_4_conteudo_2);
                break;
            case 15:
                imageId = R.mipmap.sopro;
                titulo = getString(R.string.coracao_5_titulo);
                conteudo_1 = getString(R.string.coracao_5_conteudo_1);
                conteudo_2 = getString(R.string.coracao_5_conteudo_2);
                break;
            case 21:
                imageId = R.mipmap.mama;
                titulo = getString(R.string.cancer_1_titulo);
                conteudo_1 = getString(R.string.cancer_1_conteudo_1);
                conteudo_2 = getString(R.string.cancer_1_conteudo_2);
                break;
            case 22:
                imageId = R.mipmap.leucemia;
                titulo = getString(R.string.cancer_2_titulo);
                conteudo_1 = getString(R.string.cancer_2_conteudo_1);
                conteudo_2 = getString(R.string.cancer_2_conteudo_1);
                break;
            case 23:
                imageId = R.mipmap.pulmao;
                titulo = getString(R.string.cancer_3_titulo);
                conteudo_1 = getString(R.string.cancer_3_conteudo_1);
                conteudo_2 = getString(R.string.cancer_3_conteudo_1);
                break;
            case 24:
                imageId = R.mipmap.estomago;
                titulo = getString(R.string.cancer_4_titulo);
                conteudo_1 = getString(R.string.cancer_4_conteudo_1);
                conteudo_2 = getString(R.string.cancer_4_conteudo_1);
                break;
            case 25:
                imageId = R.mipmap.laringe;
                titulo = getString(R.string.cancer_5_titulo);
                conteudo_1 = getString(R.string.cancer_5_conteudo_1);
                conteudo_2 = getString(R.string.cancer_5_conteudo_1);
                break;
            case 31:
                imageId = R.mipmap.dengue;
                titulo = getString(R.string.dengue_1_titulo);
                conteudo_1 = getString(R.string.dengue_1_conteudo_1);
                conteudo_2 = getString(R.string.dengue_1_conteudo_2);
                break;
            case 32:
                imageId = R.mipmap.depressao;
                titulo = getString(R.string.depressao_1_titulo);
                conteudo_1 = getString(R.string.depressao_1_conteudo_1);
                conteudo_2 = getString(R.string.depressao_1_conteudo_2);
                break;
            case 33:
                imageId = R.mipmap.zika;
                titulo = getString(R.string.zika_1_titulo);
                conteudo_1 = getString(R.string.zika_1_conteudo_1);
                conteudo_2 = getString(R.string.zika_1_conteudo_2);
                break;
            default: break;
        }

        /* Seta a imagem, o título e os conteúdos conforme a selação do usuário. */
        imageView.setImageResource(imageId);
        textViewTitulo.setText(titulo);
        textViewConteudo_1.setText(conteudo_1);
        textViewConteudo_2.setText(conteudo_2);
    }
}
