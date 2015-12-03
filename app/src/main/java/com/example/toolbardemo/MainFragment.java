package com.example.toolbardemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment
        implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView linkFragment1, linkFragment2, linkFragment3;

    public MainFragment() {}

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar_fragment_main);
        linkFragment1 = (TextView) view.findViewById(R.id.link_fragment1);
        linkFragment2 = (TextView) view.findViewById(R.id.link_fragment2);
        linkFragment3 = (TextView) view.findViewById(R.id.link_fragment3);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linkFragment1.setOnClickListener(this);
        linkFragment2.setOnClickListener(this);
        linkFragment3.setOnClickListener(this);
        toolbar.setTitle(R.string.app_name);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.link_fragment1:
                Demo1Fragment fragment1 = Demo1Fragment.newInstance();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main, fragment1, Demo1Fragment.class.toString())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.link_fragment2:
                Demo2Fragment fragment2= Demo2Fragment.newInstance();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main, fragment2, Demo2Fragment.class.toString())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.link_fragment3:
                Demo3Fragment fragment3 = Demo3Fragment.newInstance();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_main, fragment3, Demo3Fragment.class.toString())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
