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

public class WalkFragment extends Fragment {
    private String title;

    public WalkFragment() {
    }

    public static WalkFragment init(String title, String text, int image) {
        WalkFragment fragment = new WalkFragment();
        Bundle args = new Bundle();
        args.putInt("imageId", image);
        args.putString("TitleText", title);
        args.putString("MessageText", text);
        fragment.setArguments(args);
        return fragment;
    }

    public static WalkFragment newInstance() {
        WalkFragment fragment = new WalkFragment();
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
        if (title.equalsIgnoreCase("1")) {
            v = inflater.inflate(R.layout.walk1_fragment, container, false);
        }
        else if (title.equalsIgnoreCase("2")) {
            v = inflater.inflate(R.layout.walk2_fragment, container, false);
        }
        else if (title.equalsIgnoreCase("3")) {
            v = inflater.inflate(R.layout.walk3_fragment, container, false);
        }
        else {
            v = inflater.inflate(R.layout.walk4_fragment, container, false);
        }
        return v;
    }
}
