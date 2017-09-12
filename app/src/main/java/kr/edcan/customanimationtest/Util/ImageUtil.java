package kr.edcan.customanimationtest.Util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import android.util.Log;
/**
 * Created by mac on 2017. 9. 12..
 */

public class ImageUtil {

    @BindingAdapter("url")
    public static void loadImage(ImageView imageView, String url){
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
