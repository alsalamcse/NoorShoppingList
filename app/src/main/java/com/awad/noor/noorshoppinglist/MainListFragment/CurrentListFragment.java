package com.awad.noor.noorshoppinglist.MainListFragment;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.util.Log;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageButton;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.awad.noor.noorshoppinglist.Data.Product;
        import com.awad.noor.noorshoppinglist.Data.ProductAdapter;
        import com.awad.noor.noorshoppinglist.R;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
//1.
public class CurrentListFragment extends Fragment
{
    private ImageButton imbSave;
    private TextView tvTotal;
    private TextView tvTotalValue;
    private TextView tvCount;
    private TextView tvCountValue;
    private ListView lstvCurrent;
    //8.
    ProductAdapter productAdapter;

    public CurrentListFragment() {
        // Required empty public constructor
    }

    //2.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //3.
        View view = inflater.inflate(R.layout.fragment_current_list, container, false);
        tvTotal = (TextView) view.findViewById(R.id.tvTotal);
        tvTotalValue = (TextView) view.findViewById(R.id.tvTotalValue);
        tvCount = (TextView) view.findViewById(R.id.tvCount);
        tvCountValue = (TextView) view.findViewById(R.id.tvCountValue);
        imbSave = (ImageButton) view.findViewById(R.id.imbSave);
        lstvCurrent = (ListView) view.findViewById(R.id.lstvCurrent);
//9.
         productAdapter = new ProductAdapter(getContext(), R.layout.product_item);
        //10. todo קביעת המתאםנלרשימה
        lstvCurrent.setAdapter (productAdapter);

        //ArrayAdapter<String> Arrayadapter
        readAndListen();
        //4.
        return view;
    }

    private void readAndListen()
    {
        //5.
        FirebaseAuth auth= FirebaseAuth.getInstance();
        FirebaseUser user= auth.getCurrentUser();
        String email=user.getEmail();
        email=email.replace('.','*');
        //6.
        DatabaseReference reference;
        //* // todo לקבלת קישור למסד הניתונים שלנו
        //* todo קישור הינו לשורש של המסד הנתונים
        reference= FirebaseDatabase.getInstance().getReference();
        //7.
        reference.child(email).child("myList").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                //11.
                productAdapter.clear();
                for (DataSnapshot ds: dataSnapshot.getChildren())
                {
                    Product p=ds.getValue(Product.class);
                    Log.d("SL", p.toString());
                    productAdapter.add(p);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }








}
