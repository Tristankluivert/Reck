package ng.com.hybrid.reck;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    EditText edusername,edpass;
    CardView loguser;
    TextView loguse;
    FirebaseAuth mAuth;
    ProgressDialog mDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
      mAuth = FirebaseAuth.getInstance();
        edusername = findViewById(R.id.edusername);
        edpass = findViewById(R.id.edpass);
        loguser = findViewById(R.id.loguser);
        mDialog = new ProgressDialog(this);

       loguser.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               SigUser();
           }
       });

       loguse.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent go = new Intent(getApplicationContext(),Login.class);
               startActivity(go);
           }
       });
    }


    public void SigUser(){

        String name = edusername.getText().toString();
        String password = edpass.getText().toString();
        if (TextUtils.isEmpty(name)){
            edusername.requestFocus();
            Toast.makeText(getApplicationContext(), "Enter email", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(password)){
            edpass.requestFocus();
            Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        mDialog.setMessage("Signing User please wait...");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        mAuth.signInWithEmailAndPassword(name,password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                            Intent open = new Intent(getApplicationContext(),MainActivity.class);
                            open.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(open);
                        }else{
                            Toast.makeText(getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


    }


}
