package codingblocks.com.billsplit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import codingblocks.com.billsplit.model.User;
import codingblocks.com.billsplit.util.Services;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserDetailActivity extends AppCompatActivity {

    EditText idEdit, nameEdit;
    Button submitButton;
    Boolean update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        idEdit = findViewById(R.id.idet);
        nameEdit = findViewById(R.id.nameet);
        submitButton = findViewById(R.id.submit);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        if (id != null){
            update = true;
            fillDetail(id);
            submitButton.setText("update");
        }else {
            update = false;
            submitButton.setText("Create");
        }
    }

    private void fillDetail(String id) {
        idEdit.setText(id);

        Services.getInstance().getUserService().getUser(id).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    nameEdit.setText(response.body().name);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }
}
