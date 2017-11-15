package com.awad.noor.noorshoppinglist.MainListFragment;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.ImageButton;
        import android.widget.ListView;
        import android.widget.TextView;

        import com.awad.noor.noorshoppinglist.R;

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



    public CurrentListFragment() {
        // Required empty public constructor
    }

    //2.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //3.
        View view= inflater.inflate(R.layout.fragment_current_list, container, false);
        tvTotal=(TextView) view.findViewById(R.id.tvTotal);
        tvTotalValue=(TextView) view.findViewById(R.id.tvTotalValue);
        tvCount=(TextView) view.findViewById(R.id.tvCount);
        tvCountValue=(TextView) view.findViewById(R.id.tvCountValue);
        imbSave=(ImageButton) view.findViewById(R.id.imbSave);
        lstvCurrent=(ListView) view.findViewById(R.id.lstvCurrent);


        String[] ar={"noor","rimaa","teya","muhammed","shada"};
        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>()


        return view;
    }

}
