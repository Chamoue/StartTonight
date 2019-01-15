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

public class CustomOrderForMealList extends BaseAdapter {

    private List<Mets> orderedMeals;
    private Context context;

    public CustomOrderForMealList(Context pContext, List<Mets> mets) {
        context = pContext;
        orderedMeals = mets;
    }

    @Override
    public int getCount() {
        return this.orderedMeals.size();
    }

    @Override
    public Object getItem(int position) {
        return this.orderedMeals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.orderedMeals.indexOf(getItem(position));
    }

    private class ViewHolder{
        TextView itemOrdered;
        TextView quantity;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.liste_commande, null);
            holder = new ViewHolder();

            holder.itemOrdered = convertView.findViewById(R.id.itemOrdered);
            holder.quantity = convertView.findViewById(R.id.quantityOrdered);

            Mets item = orderedMeals.get(position);

            holder.itemOrdered.setText(item.getNomMet());
            holder.quantity.setText(Integer.toString(item.getQuantity()));


            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
