package universconception.conception.cegepstefoy.restaurantconcept.Activity;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import universconception.conception.cegepstefoy.restaurantconcept.Data.DataBase;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Courriel;
import universconception.conception.cegepstefoy.restaurantconcept.Model.Password;
import universconception.conception.cegepstefoy.restaurantconcept.R;

public class LoginActivity extends AppCompatActivity {

    private EditText courrielEditText;
    private EditText passwordEditText;
    private TextView mTextViewClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.courrielEditText = findViewById(R.id.courrielLoginInput);
        this.passwordEditText = findViewById(R.id.passwordLoginInput);
        this.mTextViewClicked = findViewById(R.id.registerText);

    }

    public void onRegisterTextClicked(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public boolean validations() {
        //TODO ?

        return true;
    }

    public boolean loginCheck() {
        return DataBase.getInstance().checkLoginInfo(new Courriel(this.courrielEditText.getText().toString()), new Password(this.passwordEditText.getText().toString()));
    }

    public void onConnectButtonClicked(View view) {
        if (validations()) {
            if (loginCheck()) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                this.courrielEditText.setError(null);
                this.setCurrentUser();
                startActivity(intent);
            }
            else {
                this.courrielEditText.setError("Cette combinaison courriel/mot de passe n'existe pas!");
            }
        }
    }

    private void setCurrentUser() {
        DataBase.getInstance().setCurrentUser(DataBase.getInstance().getUser(new Courriel(this.courrielEditText.getText().toString())));
    }

}
