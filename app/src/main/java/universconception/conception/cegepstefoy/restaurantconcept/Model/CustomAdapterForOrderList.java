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


public class CustomAdapterForOrderList extends BaseAdapter {

    private Context context;
    private List<Commande> items;

    public CustomAdapterForOrderList(Context pContext, List<Commande> orders) {
        context = pContext;
        items = orders;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.indexOf(getItem(position));
    }

    private class ViewHolder{
        TextView nomDuClient;
        TextView adresseDuClient;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.order_list, null);
            holder = new ViewHolder();

            holder.nomDuClient = convertView.findViewById(R.id.nomDuClient);
            holder.adresseDuClient = convertView.findViewById(R.id.adresseLivraison);

            Commande item = items.get(position);

            holder.nomDuClient.setText(item.getClient().getCourriel().getCourriel());
            holder.adresseDuClient.setText(item.getClient().getAdresse());


            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
