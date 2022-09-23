package victorbisquert.a01_introduccionaandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import victorbisquert.a01_introduccionaandroid.modelos.Usuario;

public class MainActivity extends AppCompatActivity {

    //variables de tipo vista
    private TextView lblcontador;
    private Button btnClick;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnRegistro;

    //variables para la logica
    private int contador;
    private ArrayList<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contador = 0;
        listaUsuarios = new ArrayList<>();
        inicializaVistas();
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Has pulsado el boton", Toast.LENGTH_LONG).show();
                contador++;
                lblcontador.setText(contador+" veces");
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = txtEmail.getText().toString();
                String password = txtPassword.getText().toString();
                Usuario user = new Usuario(email,password);
                listaUsuarios.add(user);
                Toast.makeText(MainActivity.this, user.toString() , Toast.LENGTH_LONG).show();
                txtPassword.setText("");
                txtEmail.setText("");
            }
        });


    }

    private void inicializaVistas() {
        lblcontador = findViewById(R.id.lblContadormain);
        btnClick = findViewById(R.id.btnclickMain);
        txtEmail = findViewById(R.id.txtemailMain);
        txtPassword = findViewById(R.id.txtpasswordMain);
        btnRegistro = findViewById(R.id.btnregistroMain);
    }
    public void btnClickContador(View vista){
        contador++;
        lblcontador.setText(contador+" veces");
    }

}