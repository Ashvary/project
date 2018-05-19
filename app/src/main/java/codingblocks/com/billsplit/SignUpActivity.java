package codingblocks.com.billsplit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;
import codingblocks.com.billsplit.model.User;
import codingblocks.com.billsplit.util.Preferences;
import codingblocks.com.billsplit.util.Services;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    @BindView(R.id.name) EditText name;
    @BindView(R.id.phone) EditText phone;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.email) EditText email;

    @BindView(R.id.button_signup) Button signup;
    @BindView(R.id.button_login) Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        if(Preferences.of(getApplicationContext()).username().isSet()){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        ButterKnife.bind(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String user_id = phone.getText().toString();
                final String user_name = name.getText().toString();
                final String user_email = email.getText().toString();

                User user = new User(user_id, user_name);

                Services.getInstance().getUserService().createUser(user).enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(response.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                            Preferences.of(getApplicationContext()).username().set(user_id);
                            Preferences.of(getApplicationContext()).name().set(user_name);
                            Preferences.of(getApplicationContext()).email().set(user_email);

                            finish();

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "some error", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }
}
