package fateczl.aps.aula07_mobile;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import fateczl.aps.aula07_mobile.model.ContaEspecial;
import fateczl.aps.aula07_mobile.model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {
    private EditText etCliente;
    private EditText etNumConta;
    private EditText etSaldo;

    private RadioButton rbPoupanca;
    private RadioButton rbEspecial;

    private EditText etValor;

    private TextView tvNomeCliente;
    private TextView tvNumConta;
    private TextView tvSaldoFinal;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etCliente = findViewById(R.id.etCliente);
        etNumConta = findViewById(R.id.etNumConta);
        etSaldo = findViewById(R.id.etSaldo);

        rbPoupanca = findViewById(R.id.rbPoupanca);
        rbEspecial = findViewById(R.id.rbEspecial);

        etValor = findViewById(R.id.etValor);
        Button btnSacar = findViewById(R.id.btnSacar);
        Button btnDepositar = findViewById(R.id.btnDepositar);
        Button btnCalcularRendimento = findViewById(R.id.btnCalcularRendimento);

        tvNomeCliente = findViewById(R.id.tvNomeCliente);
        tvNumConta = findViewById(R.id.tvNumConta);
        tvSaldoFinal = findViewById(R.id.tvSaldoFinal);

        try {
            btnSacar.setOnClickListener(op -> {
                try {
                    sacar();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }

        btnDepositar.setOnClickListener(ope -> depositar());
        btnCalcularRendimento.setOnClickListener(opera -> calcularRendimento());
    }

    private void calcularRendimento() {
        if (rbPoupanca.isChecked()) {
            ContaPoupanca poup = new ContaPoupanca();
            poup.setCliente(etCliente.getText().toString());
            poup.setNum_conta(Integer.parseInt(etNumConta.getText().toString()));
            poup.setSaldo(Float.parseFloat(etSaldo.getText().toString()));

            Float novoSaldo = poup.calcularNovoSaldo();

            String resSaldo = getString(R.string.tvSaldo) + novoSaldo;
            String resCliente = getString(R.string.tvNomeCliente) + etCliente.getText().toString();
            String resNumConta = getString(R.string.tvNumConta) + etNumConta.getText().toString();

            tvSaldoFinal.setText(resSaldo);
            tvNomeCliente.setText(resCliente);
            tvNumConta.setText(resNumConta);

            etCliente.setText("");
            etNumConta.setText("");
            etSaldo.setText("");
            etValor.setText("");
        }
    }

    private void depositar() {
        if (rbPoupanca.isChecked()) {
            ContaPoupanca poup = new ContaPoupanca();
            poup.setCliente(etCliente.getText().toString());
            poup.setNum_conta(Integer.parseInt(etNumConta.getText().toString()));
            poup.setSaldo(Float.parseFloat(etSaldo.getText().toString()));

            Float novoSaldo = poup.deposito(Float.parseFloat(etValor.getText().toString()));

            String resSaldo = getString(R.string.tvSaldo) + novoSaldo;
            String resCliente = getString(R.string.tvNomeCliente) + etCliente.getText().toString();
            String resNumConta = getString(R.string.tvNumConta) + etNumConta.getText().toString();

            tvSaldoFinal.setText(resSaldo);
            tvNomeCliente.setText(resCliente);
            tvNumConta.setText(resNumConta);

            etCliente.setText("");
            etNumConta.setText("");
            etSaldo.setText("");
            etValor.setText("");
        } else if (rbEspecial.isChecked()) {
            ContaEspecial esp = new ContaEspecial();
            esp.setCliente(etCliente.getText().toString());
            esp.setNum_conta(Integer.parseInt(etNumConta.getText().toString()));
            esp.setSaldo(Float.parseFloat(etSaldo.getText().toString()));

            Float novoSaldo = esp.deposito(Float.parseFloat(etValor.getText().toString()));

            String resSaldo = getString(R.string.tvSaldo) + novoSaldo;
            String resCliente = getString(R.string.tvNomeCliente) + etCliente.getText().toString();
            String resNumConta = getString(R.string.tvNumConta) + etNumConta.getText().toString();

            tvSaldoFinal.setText(resSaldo);
            tvNomeCliente.setText(resCliente);
            tvNumConta.setText(resNumConta);

            etCliente.setText("");
            etNumConta.setText("");
            etSaldo.setText("");
            etValor.setText("");
        }

    }

    private void sacar() throws Exception {
        if (rbPoupanca.isChecked()) {
            ContaPoupanca poup = new ContaPoupanca();
            poup.setCliente(etCliente.getText().toString());
            poup.setNum_conta(Integer.parseInt(etNumConta.getText().toString()));
            poup.setSaldo(Float.parseFloat(etSaldo.getText().toString()));

            Float novoSaldo = poup.sacar(Float.parseFloat(etValor.getText().toString()));

            String resSaldo = getString(R.string.tvSaldo) + novoSaldo;
            String resCliente = getString(R.string.tvNomeCliente) + etCliente.getText().toString();
            String resNumConta = getString(R.string.tvNumConta) + etNumConta.getText().toString();

            tvSaldoFinal.setText(resSaldo);
            tvNomeCliente.setText(resCliente);
            tvNumConta.setText(resNumConta);

            etCliente.setText("");
            etNumConta.setText("");
            etSaldo.setText("");
            etValor.setText("");
        } else if (rbEspecial.isChecked()) {
            ContaEspecial esp = new ContaEspecial();
            esp.setCliente(etCliente.getText().toString());
            esp.setNum_conta(Integer.parseInt(etNumConta.getText().toString()));
            esp.setSaldo(Float.parseFloat(etSaldo.getText().toString()));

            Float novoSaldo = esp.sacar(Float.parseFloat(etValor.getText().toString()));

            String resSaldo = getString(R.string.tvSaldo) + novoSaldo;
            String resCliente = getString(R.string.tvNomeCliente) + etCliente.getText().toString();
            String resNumConta = getString(R.string.tvNumConta) + etNumConta.getText().toString();

            tvSaldoFinal.setText(resSaldo);
            tvNomeCliente.setText(resCliente);
            tvNumConta.setText(resNumConta);

            etCliente.setText("");
            etNumConta.setText("");
            etSaldo.setText("");
            etValor.setText("");
        }

    }
}