package com.arish1999.chatfire.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arish1999.chatfire.Activities.ChatActivity;
import com.arish1999.chatfire.R;
import com.arish1999.chatfire.Models.User;
import com.arish1999.chatfire.databinding.RowConverstaionBinding;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UsersViewHolder> {
    Context context;
    ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }


    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_converstaion, parent, false);

        return new UsersViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {

        User user = users.get(position);
        holder.binding.username.setText(user.getName());
        Glide.with(context).load(user.getProfileImage())
                .placeholder(R.drawable.avatar)
                .into(holder.binding.profile);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("name", user.getName());
                intent.putExtra("uid", user.getUid());
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder
    {

        RowConverstaionBinding binding;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = RowConverstaionBinding.bind(itemView);
        }
    }
}
