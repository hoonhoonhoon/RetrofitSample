package com.example.woowahan.retrofitsample.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.woowahan.retrofitsample.R;
import com.example.woowahan.retrofitsample.network.model.Blog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jihoon on 2016. 12. 31..
 */

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppViewHolder> {


    List<Blog> list = new ArrayList<>();

    @Override
    public AppViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_app, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AppViewHolder holder, int position) {
        holder.bindData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<Blog> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    class AppViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.icon)
        ImageView icon;
        @BindView(R.id.description)
        TextView description;

        public AppViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(Blog blog) {
            name.setText(blog.getTitle());
            description.setText(blog.getDescription());
        }
    }
}
