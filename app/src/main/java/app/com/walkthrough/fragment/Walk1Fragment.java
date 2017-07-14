package app.com.walkthrough.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.com.walkthrough.R;

/**
 * Created by Lenovo on 7/13/2017.
 */

public class Walk1Fragment extends Fragment {
    private String title;

    public Walk1Fragment() {
    }

    public static Walk1Fragment init(String title, String text, int image) {
        Walk1Fragment fragment = new Walk1Fragment();
        Bundle args = new Bundle();
        args.putInt("imageId", image);
        args.putString("TitleText", title);
        args.putString("MessageText", text);
        fragment.setArguments(args);
        return fragment;
    }

    public static Walk1Fragment newInstance() {
        Walk1Fragment fragment = new Walk1Fragment();
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
        v = inflater.inflate(R.layout.walk1_fragment, container, false);
        return v;
    }
}
