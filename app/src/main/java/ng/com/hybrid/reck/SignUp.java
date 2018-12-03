package ng.com.hybrid.reck;

import android.app.AlertDialog;
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
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {

    CardView signin;
    EditText edusername,edpass,edpass2;
  ProgressDialog mDialog;
    FirebaseAuth mAuth;
    TextView gotlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();
        signin = findViewById(R.id.signin);
        edusername = findViewById(R.id.edusername);
        edpass = findViewById(R.id.edpass);
        edpass2 = findViewById(R.id.edpass2);
        gotlogin = findViewById(R.id.gotlogin);
        mDialog = new ProgressDialog(this);
        signin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        RegUser();
                    }
                }
        );

        gotlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(),Login.class);
                startActivity(go);
            }
        });

    }

    public void RegUser(){

        String name = edusername.getText().toString();
        String password = edpass.getText().toString();
        String password2 = edpass2.getText().toString();
        if (TextUtils.isEmpty(name)){
            Toast.makeText(getApplicationContext(), "Enter Name", Toast.LENGTH_SHORT).show();
            edusername.requestFocus();
            return;
        }else if (TextUtils.isEmpty(password)){
            edpass.requestFocus();
            Toast.makeText(getApplicationContext(), "Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }else if (TextUtils.isEmpty(password2)){
            edpass2.requestFocus();
            Toast.makeText(getApplicationContext(), "Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!password2.equals(password)){
            edpass2.requestFocus();
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
        }


        mDialog.setMessage("Creating User please wait...");
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        mAuth.createUserWithEmailAndPassword(name,password).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                            Intent open = new Intent(getApplicationContext(),UserDetails.class);
                            open.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(open);
                        }else{
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }
}
