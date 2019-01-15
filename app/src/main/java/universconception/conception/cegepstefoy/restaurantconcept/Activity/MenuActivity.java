package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import universconception.conception.cegepstefoy.restaurantconcept.Data.DataBase;
import universconception.conception.cegepstefoy.restaurantconcept.Model.CustomerAdapter;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Mets;
import universconception.conception.cegepstefoy.restaurantconcept.R;

public class MenuActivity extends AppCompatActivity {

    List<Mets> mMets = new ArrayList<>();

    String[] mets_names;
    TypedArray profile_pics;
    String[] price;

    ListView mylistview;
    private FloatingActionButton addToMenuButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        this.addToMenuButton = findViewById(R.id.AddToMenuButton);

        if (DataBase.getInstance().isAdminModeEnabled()) {
            // OK
        }
        else {
            //Fonctionne malgre l'erreur
            this.addToMenuButton.setVisibility(View.INVISIBLE);
        }

        mMets.add(new Mets(1, "Poulet", 1, 5.88f, 0));
        mMets.add(new Mets(2, "Boueuf", 1, 3.13f, 1));
        mMets.add(new Mets(3, "Boissons", 1, 1.20f, 2));
        mMets.add(new Mets(4, "Salades", 1, 2.50f, 3));
        mMets.add(new Mets(5, "Desserts", 1, 5.50f, 4));


        mets_names = getResources().getStringArray(R.array.mets_names);
        profile_pics = getResources().obtainTypedArray(R.array.profile_pics);
        price = getResources().getStringArray(R.array.contactType);


        for (int i = 0; i < mets_names.length; i++) {
            Mets rest = null;
            rest = mMets.get(i);
            rest.setProfile_pic_id(profile_pics.getResourceId(i, -1));
        }


        mylistview = findViewById(R.id.list);
        CustomerAdapter adapter = new CustomerAdapter(this, mMets);
        mylistview.setAdapter(adapter);

        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String member_name = mMets.get(position).getNomMet();
                int imageNumber = mMets.get(position).getProfile_pic_id();
                Intent intent = new Intent(MenuActivity.this, CommanderMetsActivity.class);
                intent.putExtra("member_name", member_name);
                intent.putExtra("imageNumber", imageNumber);

                startActivity(intent);

            }
        });

    }
}