package com.example.myapplication.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.databinding.library.baseAdapters.BR;
import com.example.myapplication.R;
import com.example.myapplication.databinding.ItemPostBinding;
import com.example.myapplication.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.MyViewHolder> {

    private List<Post> postList;
    private LayoutInflater layoutInflater;
    private PostsAdapterListener listener;

    public PostAdapter(List<Post> postList, PostsAdapterListener listener) {
       /* System.out.println("2222222222222222   adapter list size==="+postList.size());
        System.out.println("2222222222222222   adapter list ==="+postList);*/
        this.postList = postList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        //layoutInflater = LayoutInflater.from(parent.getContext());
        ItemPostBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.item_post, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.binding.setPost(postList.get(position));

        holder.binding.imvPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener!=null){
                    listener.onPostClicked(postList.get(position),position);
                }
            }
        });
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final ItemPostBinding binding;

        public MyViewHolder(final ItemPostBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }

        /*public void bind(Object object){
            binding.setVariable(BR.post,object);
            binding.executePendingBindings();
        }*/
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public interface PostsAdapterListener {
        void onPostClicked(Post post,int position);
    }

}
