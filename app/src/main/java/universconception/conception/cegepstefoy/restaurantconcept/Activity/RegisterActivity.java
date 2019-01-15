package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import universconception.conception.cegepstefoy.restaurantconcept.Data.DataBase;
import universconception.conception.cegepstefoy.restaurantconcept.Model.CompteUsager;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Courriel;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Password;
import universconception.conception.cegepstefoy.restaurantconcept.R;

public class RegisterActivity extends AppCompatActivity {

    private EditText courrielInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;
    private CheckBox checkBoxConditionTrue;
    private EditText nameRegisterInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.courrielInput = findViewById(R.id.courrielRegisterInput);
        this.passwordInput = findViewById(R.id.passwordRegisterInput);
        this.confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        this.checkBoxConditionTrue = findViewById(R.id.checkBoxConditionTrue);
        this.nameRegisterInput = findViewById(R.id.NameRegisterInput);

        this.checkBoxConditionTrue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checkBoxConditionTrue.setError(null);
            }
        });
    }


    public void onNextPageButtonClicked(View view) {
        if (validations()) {
            if (this.checkBoxConditionTrue.isChecked()) {
                Intent intent = new Intent(RegisterActivity.this, SecondRegisterActivity.class);
                intent.putExtra("nom", this.nameRegisterInput.getText().toString());
                intent.putExtra("courriel", this.courrielInput.getText().toString());
                intent.putExtra("password", this.passwordInput.getText().toString());
                startActivity(intent);
            } else {
                this.checkBoxConditionTrue.setError("Vous devez accepter les conditions d'utilisation!");
            }
        }
    }

    public boolean validations() {
        if (this.fieldsAreEmpty()) {
            if (DataBase.getInstance().checkIfMailIsInDatabase(new Courriel(this.courrielInput.getText().toString()))) {
                this.courrielInput.setError("Cet utilisateur existe deja!");
                return false;
            }
            if (this.passwordDoNotMatch()) {
                this.passwordInput.setError("Les mots de passe doivent etre identique!");
                return false;
            }

            this.resetErrors();
            return true;
        }
        return false;
    }

    public void resetErrors() {
        this.courrielInput.setError(null);
        this.nameRegisterInput.setError(null);
        this.passwordInput.setError(null);
        this.confirmPasswordInput.setError(null);

    }

    public boolean passwordDoNotMatch() {
        if (this.passwordInput.getText().toString().equals(this.confirmPasswordInput.getText().toString())) {
            return false;
        } else {
            return true;
        }
    }

    public boolean fieldsAreEmpty() {
        if (this.nameRegisterInput.getText().toString().length() == 0) {
            this.nameRegisterInput.setError("Ce champs ne peut pas etre vide!");
            return false;
        }
        if (this.courrielInput.getText().toString().length() == 0) {
            this.courrielInput.setError("Ce champs ne peut pas etre vide!");
            return false;
        }
        if (this.passwordInput.getText().toString().length() == 0) {
            this.passwordInput.setError("Ce champs ne peut pas etre vide!");
            return false;
        }
        if (this.confirmPasswordInput.getText().toString().length() == 0) {
            this.confirmPasswordInput.setError("Ce champs ne peut pas etre vide!");
            return false;
        }
        return true;
    }
}
