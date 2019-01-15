package universconception.conception.cegepstefoy.restaurantconcept.Model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import universconception.conception.cegepstefoy.restaurantconcept.R;

public class CustomAdapterFacture extends BaseAdapter {

    private List<Mets> order;
    private Context context;

    public CustomAdapterFacture(List<Mets> order, Context context) {
        this.order = order;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.order.size();
    }

    @Override
    public Object getItem(int position) {
        return this.order.get(position);
    }

    @Override
    public long getItemId(int position) {
        return order.indexOf(getItem(position));
    }

    private class ViewHolder{
        TextView item;
        TextView quantity;
        TextView prix;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.facture, null);
            holder = new ViewHolder();

            holder.item = convertView.findViewById(R.id.itemNameTag);
            holder.quantity = convertView.findViewById(R.id.QuantityTag);
            holder.prix = convertView.findViewById(R.id.priceTag);

            Mets item = order.get(position);

            holder.item.setText(item.getNomMet());
            holder.quantity.setText(Integer.toString(item.getQuantity()));
            holder.prix.setText(Float.toString(item.getPrice()));


            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
