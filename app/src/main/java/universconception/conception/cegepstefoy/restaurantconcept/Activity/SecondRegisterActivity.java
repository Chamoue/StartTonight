package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import universconception.conception.cegepstefoy.restaurantconcept.Data.DataBase;
import universconception.conception.cegepstefoy.restaurantconcept.Model.CompteUsager;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Courriel;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Password;
import universconception.conception.cegepstefoy.restaurantconcept.R;

public class SecondRegisterActivity extends AppCompatActivity {

    private EditText adresseEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_register);
        this.adresseEditText = findViewById(R.id.adresse);

        Spinner spinner = findViewById(R.id.drop_down_list);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.province_array, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void registerUser() {
        Intent intent = getIntent();

        DataBase.getInstance().addUser(new Courriel(intent.getStringExtra("courriel"))
                , new Password(intent.getStringExtra("password"))
                , this.adresseEditText.getText().toString()
                , intent.getStringExtra("nom"));

    }

    public boolean validations() {
        if (fieldsAreEmpty()) {
            this.adresseEditText.setError(null);
            return true;
        }
        return false;
    }

    public void onRegisterButtonClicked(View view) {
        if (validations()) {
            registerUser();
            setCurrentUser();
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userCreated","Done");
            startActivity(intent);
        }
    }

    private void setCurrentUser() {
        Intent intent = getIntent();
        DataBase.getInstance().setCurrentUser(DataBase.getInstance().getUser(new Courriel(intent.getStringExtra("courriel"))));
    }

    public boolean fieldsAreEmpty() {
        if (this.adresseEditText.getText().toString().length() == 0) {
            this.adresseEditText.setError("Ce champs ne peut pas etre vide!");
            return false;
        }
        return true;
    }
}
