package com.awad.noor.noorshoppinglist;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.awad.noor.noorshoppinglist.Data.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItem extends AppCompatActivity implements View.OnClickListener {
    private EditText etAmount;
    private EditText etName;
    private EditText etPrice;
    private EditText etUnits;
    private ImageButton ibtnImge;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        etAmount = (EditText) findViewById(R.id.etAmount);
        etName = (EditText) findViewById(R.id.etName);
        etPrice = (EditText) findViewById(R.id.etPrice);
        etUnits = (EditText) findViewById(R.id.etUnits);
        ibtnImge = (ImageButton) findViewById(R.id.ibtnImage);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

    }
    public void dataHandler()
    {
        //1. get data fro the feilds
        String stname= etName.getText().toString();
        String stamount= etAmount.getText().toString();
        String stPrice= etPrice.getText().toString();
        String stunits= etUnits.getText().toString();
        //2. TODO Validate fields input
        //isok=true,..;

        //3. data manipolation

        double amount=Double.parseDouble(stamount);
        double price=Double.parseDouble(stPrice);

        //4. building data object
        Product p= new Product();
        p.setName(stname);
        p.setAmount(amount);
        p.setPrice(price);
        p.setCompleted(false);


        //5. to get user email ... user info
        FirebaseAuth auth= FirebaseAuth.getInstance();
        FirebaseUser user= auth.getCurrentUser();
        String email =user.getEmail();
        email=email.replace('.','*');

        //6.building data refernce=data path=data adress
        DatabaseReference reference;
        // TODO לקבלת קישור למסד הנתונים שלנו
        // TODO קישור הינו לשורש של המסד הנתונים
        reference= FirebaseDatabase.getInstance().getReference();
        //7. saving data on the firebase database
        reference.child(email).child("myList").push().setValue(p).
                //8.add completeListener to check if the insertion done
                addOnCompleteListener(this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                {
                    Toast.makeText(AddItem.this, "Add Product Successful", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(AddItem.this, "Add Product Faild", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // TODO Testing
        //reference.child("list").setValue("lolo");
    }

    @Override
    public void onClick(View view) {
        dataHandler();
    }
}

