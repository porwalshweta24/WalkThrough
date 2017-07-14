package app.com.walkthrough.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import app.com.walkthrough.R;
import app.com.walkthrough.adapter.MyBounceInterpolator;

/**
 * Created by Lenovo on 7/13/2017.
 */

public class Walk4Fragment extends Fragment {
    private String title;
    ImageView image1, image2;

    public Walk4Fragment() {
    }

    public static Walk4Fragment init(String title, String text, int image) {
        Walk4Fragment fragment = new Walk4Fragment();
        Bundle args = new Bundle();
        args.putInt("imageId", image);
        args.putString("TitleText", title);
        args.putString("MessageText", text);
        fragment.setArguments(args);
        return fragment;
    }

    public static Walk4Fragment newInstance() {
        Walk4Fragment fragment = new Walk4Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("TitleText");

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v;
        v = inflater.inflate(R.layout.walk4_fragment, container, false);
        image1 = (ImageView) v.findViewById(R.id.image_1);
        image2 = (ImageView) v.findViewById(R.id.image_2);
        return v;
    }

    public void walkChange() {

        Animation slideAnimation = AnimationUtils.loadAnimation(getActivity(),
                R.anim.slidep_up);
        image2.startAnimation(slideAnimation);

    }
}
