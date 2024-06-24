package com.example.exercise03;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

public class RatingFragment extends Fragment {

    // The radio button choice has 3 states: 0 = yes, 1 = no,
    // 2 = default (no choice). Using all 3 states.
    private static final int YES = 0;
    private static final int NO = 1;
    private static final int NONE = 2;

    // Initialize the choice to the default (no choice)
    private int mRadioButtonChoice = NONE;

    // The "choice" key for the bundle.
    private static final String CHOICE = "choice";

    // The listener interface.
    OnFragmentInteractionListener mListener;

    public RatingFragment() {
        // Required empty public constructor
    }

    interface OnFragmentInteractionListener {
        void onRadioButtonChoice(int choice);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + getResources().getString(R.string.exception_message));
        }
    }

    public static RatingFragment newInstance(String param1, String param2) {
        RatingFragment fragment = new RatingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_rating,
                container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        // If user reopens the fragment after making a choice, the bundle
        // contains "choice".
        if (getArguments().containsKey(CHOICE)) {
            // A choice was made, so get the choice.
            mRadioButtonChoice = getArguments().getInt(CHOICE);
            // Check the radio button choice.
            if (mRadioButtonChoice != NONE) {
                radioGroup.check
                        (radioGroup.getChildAt(mRadioButtonChoice).getId());
            }
        }
        // Set the radioGroup onCheckedChanged listener.
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        View radioButton = radioGroup.findViewById(checkedId);
                        int index = radioGroup.indexOfChild(radioButton);
                        TextView textView =
                                rootView.findViewById(R.id.fragment_header);
                        switch (index) {
                            case YES: // User chose "Yes".
                                textView.setText(R.string.yes_message);
                                mRadioButtonChoice = YES;
                                mListener.onRadioButtonChoice(YES);
                                break;
                            case NO: // User chose "No".
                                textView.setText(R.string.no_message);
                                mRadioButtonChoice = NO;
                                mListener.onRadioButtonChoice(NO);
                                break;
                            default: // No choice made.
                                mRadioButtonChoice = NONE;
                                mListener.onRadioButtonChoice(NONE);
                                break;
                        }
                    }
                });

        // Return the View for the fragment's UI.
        return rootView;
    }

    public static RatingFragment newInstance(int choice) {
        RatingFragment fragment = new RatingFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(CHOICE, choice);
        fragment.setArguments(arguments);
        return fragment;
    }
}