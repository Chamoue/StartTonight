package universconception.conception.cegepstefoy.restaurantconcept.Model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import universconception.conception.cegepstefoy.restaurantconcept.R;

public class CustomerAdapter extends BaseAdapter {

    Context context;
    List<Mets> rowItems;


    public CustomerAdapter(Context pContext, List<Mets> pRowItems) {
        context = pContext;
        rowItems = pRowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    private class ViewHolder{
        ImageView profile_pic;
        TextView member_name;
        TextView quantity;
        TextView contactType;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.liste_item, null);
            holder = new ViewHolder();

            holder.member_name = convertView.findViewById(R.id.member_name);
            holder.profile_pic = convertView.findViewById(R.id.profile_pic);
            holder.quantity = convertView.findViewById(R.id.quantity);
            holder.contactType = convertView.findViewById(R.id.contact_type);

            Mets row_pos = rowItems.get(position);

            holder.profile_pic.setImageResource(row_pos.getProfile_pic_id());
            holder.member_name.setText(row_pos.getNomMet());
            holder.quantity.setText(Integer.toString(row_pos.getQuantity()));
            holder.contactType.setText(" " + row_pos.getPrice().toString() + " \n$CAD");


            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }
}
