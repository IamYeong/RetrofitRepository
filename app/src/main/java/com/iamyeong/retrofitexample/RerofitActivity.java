package com.iamyeong.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
    private List<Post> postList;
    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rerofit);

        btn_request = findViewById(R.id.btn_request);

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

                            postList = response.body();

                            System.out.println("posts size is " + postList.size());

                            for (Post post : postList) {

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

    private void setRecyclerView(List<Post> list) {




    }

}