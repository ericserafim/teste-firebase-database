package firebaseapp.ericserafim.com.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = databaseReference.child("usuarios");
    private DatabaseReference produtoReferencia = databaseReference.child("produtos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //usuarioReferencia.child("001").child("nome").setValue("Eric Serafim");

//        Usuario usuario = new Usuario();
//        usuario.setNome("Maria");
//        usuario.setSobreNome("Da Silva");
//        usuario.setIdade(24);
//        usuario.setSexo("Feminino");
//
//        usuarioReferencia.child("002").setValue(usuario);

//        Produto produto = new Produto();
//        produto.setDescricao("Iphone");
//        produto.setCor("Azul");
//        produto.setFabricante("Apple");

//        produtoReferencia.child("001").setValue(produto);
//        produtoReferencia.child("001").removeValue();

//        produto = new Produto();
//        produto.setDescricao("S6");
//        produto.setCor("Preto");
//        produto.setFabricante("Samsumg");
//
//        produtoReferencia.child("002").setValue(produto);

        //Permite adicionar listener para todo o nodo ou para um registro específico
          produtoReferencia.child("001").addValueEventListener(new ValueEventListener() {
//            produtoReferencia.addValueEventListener(new ValueEventListener() {
              @Override
              public void onDataChange(DataSnapshot dataSnapshot) {
                  Log.i("FIREBASE", dataSnapshot.getValue().toString());
              }

              @Override
              public void onCancelled(DatabaseError databaseError) {

              }
          });


        usuarioReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
