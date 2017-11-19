package com.awad.noor.noorshoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddItem extends AppCompatActivity {
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

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataHandler();
            }
        });
    }
    public void dataHandler()
    {
        String stname= etName.getText().toString();
        String stamount= etAmount.getText().toString();
        String stPrice= etPrice.getText().toString();
        String stunits= etUnits.getText().toString();
        double amount=Double.parseDouble(stamount);
        double price=Double.parseDouble(stPrice);

        DatabaseReference reference;
        //** TODO לקבלת קישור למסד הנתונים שלנו
        //** // // TODO קישור הינו לשורש של המסד הנתונים
        reference= FirebaseDatabase.getInstance().getReference();

        reference.child("list").setValue("lolo");
    }
}
