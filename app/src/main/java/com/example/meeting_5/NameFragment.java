package com.example.meeting_5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.meeting_5.Entities.NameEntity;
import com.example.meeting_5.Entities.NamesList;

import org.w3c.dom.NameList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NameFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";

    private String name;

    public NameFragment() { }

    public static NameFragment newInstance(String name) {
        NameFragment fragment = new NameFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);

        NameEntity nameEntity = new NamesList().findName(name);
        ((TextView)view.findViewById(R.id.nameText)).setText(nameEntity.getName());
        ((TextView)view.findViewById(R.id.dateText)).setText(nameEntity.getDate());
        ((TextView)view.findViewById(R.id.descriptionText)).setText(nameEntity.getDescription());

        return view;
    }
}