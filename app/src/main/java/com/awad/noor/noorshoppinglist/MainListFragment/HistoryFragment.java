package com.awad.noor.noorshoppinglist.MainListFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.awad.noor.noorshoppinglist.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment
{
    private ListView lstHistory;


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_history2, container, false);
        lstHistory = (ListView) view.findViewById(R.id.lstHistory);
        return view;

    }

}
