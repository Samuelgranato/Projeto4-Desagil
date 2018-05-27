//package com.fablab.insper.fablabinsper;
//
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.HashMap;
//
//public class HomeAddingData extends AppCompatActivity {
//
//    private DatabaseReference mDatabase;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//        mDatabase = FirebaseDatabase.getInstance().getReference();
//
//        mNameField = (EditText) findViewById(R.id.name_field);
//        mTituloField = (EditText) findViewById(R.id.titulo_field);
//
//        mFirebaseBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String name = mNameField.getText().toString().trim();
//                String titulo = mTituloField.getText().toString().trim();
//
//                HashMap<String , String> dataMap = new HashMap<String, String>();
//
//                dataMap.put("Name",name);
//                dataMap.put("Titulo", titulo);
//
//                mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful()){
//
//                            Toast.makeText(HomeAddingData.this, "Stored..",Toast.LENGTH_LONG).show();
//                        }else {
//                            Toast.makeText(HomeAddingData.this, "Error..",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//
//
//            }
//        });
//
//    }
//}
