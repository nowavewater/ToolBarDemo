package com.example.toolbardemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Demo1Fragment extends Fragment {

    private Toolbar toolbar;

    public Demo1Fragment() {}

    public static Demo1Fragment newInstance() {
        return new Demo1Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo1, container, false);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar_fragment1);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar.setTitle(R.string.link_fragment1_text);   // Set toolbar title
        toolbar.setNavigationIcon(R.drawable.ic_back);  // Set navigation icon
        toolbar.inflateMenu(R.menu.menu_fragment1);    // Set toolbar menu
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // Set navigation listener
                FragmentManager fm = getFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                }
            }
        });
        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {  // Set toolbar menu listener
                switch (menuItem.getItemId()) {
                    case R.id.fragment1_send:
                        Toast.makeText(getActivity(), "Send", Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
    }
}
