package com.iamyeong.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RerofitActivity extends AppCompatActivity {

    private Button btn_request;
    private TextView tv_retrofit;
    private RetrofitManager retrofitManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rerofit);

        btn_request = findViewById(R.id.btn_request);
        tv_retrofit = findViewById(R.id.tv_retrofit);

        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                retrofitManager = new RetrofitManager("https://jsonplaceholder.typicode.com/");

                DataHolder holder = retrofitManager.requestRetrofit();

                Call<List<Post>> call = holder.getPosts();
                call.enqueue(new Callback<List<Post>>() {
                    @Override
                    public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                        if (response.isSuccessful()) {

                            List<Post> posts = response.body();

                            for (Post post : posts) {

                                String content = "";

                                content += "ID : " + post.getId() + "\n";
                                content += "User ID : " + post.getUserId() + "\n";
                                content += "Title : " + post.getTitle() + "\n";
                                content += "Content : " + post.getContents() + "\n";

                                tv_retrofit.append(content);

                            }


                        }

                        //tv_main.setText(response.code());

                    }

                    @Override
                    public void onFailure(Call<List<Post>> call, Throwable t) {

                        tv_retrofit.setText(t.getMessage());
                    }
                });



            }
        });


    }
}