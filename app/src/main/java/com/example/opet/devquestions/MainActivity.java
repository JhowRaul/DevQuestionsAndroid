package com.example.opet.devquestions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public class ViewHolder {
        private TextView textResultado;
        private EditText editNome;
        private CheckBox checkNews;
        private Spinner spinnerFrutas;
        private RadioGroup grupoSelecao;
    }

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Insere o layout na activity
        setContentView(R.layout.activity_main);

        this.mViewHolder.textResultado = (EditText) this.findViewById(R.id.textResultado);
        this.mViewHolder.editNome = (EditText) this.findViewById(R.id.editNome);
        this.mViewHolder.checkNews = (CheckBox) this.findViewById(R.id.checkNews);
        this.mViewHolder.spinnerFrutas = (Spinner) this.findViewById(R.id.spinnerFrutas);
        this.mViewHolder.grupoSelecao = (RadioGroup) this.findViewById(R.id.grupoSelecao);
    }

    public void Click(View v) {
        String data = mViewHolder.editNome.getText().toString();
        if(mViewHolder.checkNews.isChecked()) {
            data += "\nAssinado!";
        }
        else{
            data += "\nNão assinado";
        }

        int selecionado = mViewHolder.grupoSelecao.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selecionado);

        data += "\n"+mViewHolder.spinnerFrutas.getSelectedItem().toString();

        data += "\n" + radioButton.getText().toString();

        mViewHolder.textResultado.setText(data);
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }
}
