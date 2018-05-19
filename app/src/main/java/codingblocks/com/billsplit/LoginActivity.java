package codingblocks.com.billsplit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import codingblocks.com.billsplit.model.User;
import codingblocks.com.billsplit.util.Preferences;
import codingblocks.com.billsplit.util.Services;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.phone) EditText phone;
    @BindView(R.id.password) EditText password;

    @BindView(R.id.button_signup) Button signup;
    @BindView(R.id.button_login) Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(Preferences.of(getApplicationContext()).username().isSet()){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }

        ButterKnife.bind(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Services.getInstance().getUserService().getUser(phone.getText().toString()).enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.isSuccessful()){
                            User user = response.body();
                            Preferences.of(getApplicationContext()).username().set(user.id);
                            Preferences.of(getApplicationContext()).name().set(user.name);
                            Preferences.of(getApplicationContext()).email().set("random@email.com");

                            finish();

                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });
    }
}
