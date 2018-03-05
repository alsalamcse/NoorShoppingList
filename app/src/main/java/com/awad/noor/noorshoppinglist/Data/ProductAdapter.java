package com.awad.noor.noorshoppinglist.Data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.awad.noor.noorshoppinglist.R;

/**
 * Created by user on 14/12/2017.
 */

public class ProductAdapter extends ArrayAdapter<Product>
{
    /**
     * *
     * @param context
     * @param resource the item xml file ex. R.layout.Prooduct item
     */
    public ProductAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    /**
     * todo מספר סידורי של הנתון ממקור הניתונים
     * @param position the index of one data item(object) from the data source. starting from zero
     * @param convertView
     * todo הממשק שיכול להציג ניתונים לדוגמא listView
     * @param parent
     * @return
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.product_item, parent,false);

        TextView tvName= (TextView) view.findViewById(R.id.itmTvName);
        TextView tvPrice= (TextView) view.findViewById(R.id.itmTvPrice);
        TextView tvAmount= (TextView) view.findViewById(R.id.itmTvAmount);
        ImageView ivImage= (ImageView) view.findViewById(R.id.itmImage);
        CheckBox chxCompleted= (CheckBox) view.findViewById(R.id.itmChblsCompleted);
        Product p=getItem(position);
        tvName.setText(p.getName());
        tvPrice.setText(p.getPrice()+"");
        tvAmount.setText(p.getAmount()+"");
        chxCompleted.setChecked(p.isCompleted());

        return  view;
    }

}

