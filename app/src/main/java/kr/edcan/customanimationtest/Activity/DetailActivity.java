package kr.edcan.customanimationtest.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import kr.edcan.customanimationtest.Model.User;
import kr.edcan.customanimationtest.databinding.ActivityDetailBinding;
import kr.edcan.customanimationtest.R;
import android.content.Intent;
/**
 * Created by mac on 2017. 9. 12..
 */

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        binding.setUser((User) getIntent().getSerializableExtra("user"));
    }
}
