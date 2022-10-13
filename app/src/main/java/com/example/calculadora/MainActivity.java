package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.BreakIterator;
import java.text.CollationElementIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,numeroNove,ponto,soma,subtracao,multiplicacao,divisao,igual,botao_limpar;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

    }

    private void IniciarComponentes(){
        numeroZero      = findViewById(R.id.bt_zero);
        numeroUm        = findViewById(R.id.bt_1);
        numeroDois      = findViewById(R.id.bt_2);
        numeroTres      = findViewById(R.id.bt_3);
        numeroQuatro    = findViewById(R.id.bt_4);
        numeroCinco     = findViewById(R.id.bt_5);
        numeroSeis      = findViewById(R.id.bt_6);
        numeroSete      = findViewById(R.id.bt_7);
        numeroOito      = findViewById(R.id.bt_8);
        numeroNove      = findViewById(R.id.bt_9);
        ponto           = findViewById(R.id.bt_ponto);
        soma            = findViewById(R.id.bt_soma);
        subtracao       = findViewById(R.id.bt_sub);
        multiplicacao   = findViewById(R.id.bt_mult);
        divisao         = findViewById(R.id.bt_dividir);
        igual           = findViewById(R.id.bt_igual);
        botao_limpar    = findViewById(R.id.bt_limpar);
        txtExpressao    = findViewById(R.id.txt_expressao);
        txtResultado    = findViewById(R.id.txt_resultado);
        backspace       = findViewById(R.id.bt_apagar);

        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();
                if (!string.isEmpty()){
                    byte var0 = 0;
                    int var1 = string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText(" ");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double)longResult) {
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }

                }catch (Exception e){

                }
            }
        });
    }
    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){
        if(txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if(limpar_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_zero:
                AcrescentarUmaExpressao("0",true);
                break;
            case R.id.bt_1:
                AcrescentarUmaExpressao("1",true);
                break;
            case R.id.bt_2:
                AcrescentarUmaExpressao("2",true);
                break;
            case R.id.bt_3:
                AcrescentarUmaExpressao("3",true);
                break;
            case R.id.bt_4:
                AcrescentarUmaExpressao("4",true);
                break;
            case R.id.bt_5:
                AcrescentarUmaExpressao("5",true);
                break;
            case R.id.bt_6:
                AcrescentarUmaExpressao("6",true);
                break;
            case R.id.bt_7:
                AcrescentarUmaExpressao("7",true);
                break;
            case R.id.bt_8:
                AcrescentarUmaExpressao("8",true);
                break;
            case R.id.bt_9:
                AcrescentarUmaExpressao("9",true);
                break;
            case R.id.bt_ponto:
                AcrescentarUmaExpressao(".",true);
                break;

            case R.id.bt_soma:
                AcrescentarUmaExpressao("+",false);
                break;
            case R.id.bt_sub:
                AcrescentarUmaExpressao("-",false);
                break;
            case R.id.bt_mult:
                AcrescentarUmaExpressao("*",false);
                break;
            case R.id.bt_dividir:
                AcrescentarUmaExpressao("/",false);
                break;
        }
    }
}