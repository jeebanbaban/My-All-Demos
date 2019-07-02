package com.example.myapplication.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.PostAdapter;
import com.example.myapplication.databinding.ActivityRecycleViewBinding;
import com.example.myapplication.interfaces.ClickListner;
import com.example.myapplication.model.Post;
import com.example.myapplication.model.User;
import com.example.myapplication.utils.AllMethods;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity implements PostAdapter.PostsAdapterListener , ClickListner {

    private ActivityRecycleViewBinding binding;
    private List<Post> postImageList=new ArrayList<>();
    private RecyclerView recyclerView;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_recycle_view);

        setUserDetails();
        setPostList();
    }

    private void setUserDetails() {

        User user=new User();
        user.setName("Williamson Bagdi");
        user.setImage(AllMethods.profileImage);
        user.setAbout("I am a Software Engineer");

        user.salary.set("10L");
        user.expense.set("4L");
        user.savings.set("6L");

        binding.setUser(user);
    }

    private void setPostList() {
        /*recyclerView = binding.content.rvPost;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        postAdapter = new PostAdapter(getPostImageList(), this);
        recyclerView.setAdapter(postAdapter);*/

        binding.content.rvPost.setAdapter(new PostAdapter(getPostImageList(),this));
    }

    @Override
    public void onPostClicked(Post post, int position) {
        Toast.makeText(this, "position= "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSalaryClick(View view) {
        Toast.makeText(this, "Salary clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onExpenseClick(View view) {
        Toast.makeText(this, "Expense clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSavingsClick(View view) {
        Toast.makeText(this, "Savings clicked", Toast.LENGTH_SHORT).show();
    }

    private List<Post> getPostImageList(){
        for (int i=1 ; i<=6 ; i++){
            Post post=new Post();

            switch (i){

                case 1:
                    post.setImageUrl(AllMethods.imageUrl1);
                    postImageList.add(post);
                    break;

                case 2:
                    post.setImageUrl(AllMethods.imageUrl2);
                    postImageList.add(post);
                    break;

                case 3:
                    post.setImageUrl(AllMethods.imageUrl1);
                    postImageList.add(post);
                    break;

                case 4:
                    post.setImageUrl(AllMethods.imageUrl2);
                    postImageList.add(post);
                    break;

                case 5:
                    post.setImageUrl(AllMethods.imageUrl1);
                    postImageList.add(post);
                    break;

                case 6:
                    post.setImageUrl(AllMethods.imageUrl2);
                    postImageList.add(post);
                    break;
            }

        }
        return postImageList;
    }
}
