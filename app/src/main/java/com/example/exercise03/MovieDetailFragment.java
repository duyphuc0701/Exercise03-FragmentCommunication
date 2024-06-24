package com.example.exercise03;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exercise03.content.MovieUtils;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieDetailFragment extends Fragment {
    public MovieUtils.Movie mMovie;

    public MovieDetailFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MovieDetailFragment newInstance (int selectedMovie) {
        MovieDetailFragment fragment = new MovieDetailFragment();
        // Set the bundle arguments for the fragment.
        Bundle arguments = new Bundle();
        arguments.putInt(MovieUtils.MOVIE_ID_KEY, selectedMovie);
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(MovieUtils.MOVIE_ID_KEY)) {
            // Load the content specified by the fragment arguments.
            mMovie = MovieUtils.MOVIE_ITEMS.get(getArguments()
                    .getInt(MovieUtils.MOVIE_ID_KEY));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =
                inflater.inflate(R.layout.movie_detail, container, false);
        // Show the detail information in a TextView.
        if (mMovie != null) {
            ((ImageView)rootView.findViewById(R.id.movie_poster))
                    .setImageResource(mMovie.posterResId);
            ((TextView)rootView.findViewById(R.id.movie_descriptions))
                    .setText(mMovie.details);
        }
        return rootView;
    }
}