package kr.edcan.customanimationtest.Activity;

import android.app.ActivityOptions;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import kr.edcan.customanimationtest.Model.User;
import kr.edcan.customanimationtest.R;
import kr.edcan.customanimationtest.databinding.ActivityMainBinding;
import kr.edcan.customanimationtest.databinding.ItemUserBinding;
import android.util.Pair;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private UserRecyclerAdapter adapter;
    private LinearLayoutManager verticalLinearLayoutManager;
    private ArrayList<User> users = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        verticalLinearLayoutManager = new LinearLayoutManager(this);
        verticalLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        users.add(new User("Ted", 32, "http://cfile25.uf.tistory.com/image/251F6B4C558E627E26807B"));
        users.add(new User("Jane", 20, "http://image.celebtide.com/celeb/new/ve/279_ve_1452259300.jpg"));
        users.add(new User("Paul", 40, "http://res.heraldm.com/content/image/2013/12/01/20131201000224_0.jpg"));
        users.add(new User("Ailee", 25, "http://cfile8.uf.tistory.com/image/194599374F7049A9010251"));
        binding.recyclerView.setAdapter(new UserRecyclerAdapter());
        binding.recyclerView.setLayoutManager(verticalLinearLayoutManager);
    }

    public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.UserViewHolder> {

        @Override
        public int getItemCount() {
            return users.size();
        }

        @Override
        public UserViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            final ItemUserBinding binding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new UserViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(UserViewHolder holder, int i) {
            final User user = users.get(i);
            holder.binding.setUser(user);

        }

        public class UserViewHolder extends RecyclerView.ViewHolder{
            private ItemUserBinding binding;

            public UserViewHolder(ItemUserBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
                this.binding.getRoot().setOnClickListener(e -> {
                        final ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                                MainActivity.this,
                                Pair.create(binding.profileImage, "profileImage"),
                                Pair.create(binding.nameText, "nameText"),
                                Pair.create(binding.ageText, "ageText")
                        );

                        final Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                        intent.putExtra("user", binding.getUser());
                        startActivity(intent, options.toBundle());
                });
            }
        }
    }
}
