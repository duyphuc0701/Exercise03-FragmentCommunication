package com.example.exercise03.content;

import com.example.exercise03.R;

import java.util.ArrayList;
import java.util.List;

public class MovieUtils {
    // An ArrayList of Movies
    public static final List<Movie> MOVIE_ITEMS = new ArrayList<>();

    // The ID for the index into movie titles.
    public static final String MOVIE_ID_KEY = "item_id";

    // The number of movies.
    private static final int COUNT = 10;

    /**
     * A Movie item represents a movie title, and movie details.
     */
    public static class Movie {
        public final String movie_title;
        public final String details;
        public final int posterResId;

        private Movie(String content, String details, int posterResId) {
            this.movie_title = content;
            this.details = details;
            this.posterResId = posterResId;
        }
    }

    /**
     * Add an item to the array.
     *
     * @param item Each movie
     */
    private static void addItem(Movie item) {
        MOVIE_ITEMS.add(item);
    }

    static {
        // Fill the array with movies.
        for (int i = 0; i < COUNT; i++) {
            addItem(createMovieAtPosition(i));
        }
    }

    /**
     * Manually creates each movie title and movie detail.
     *
     * @param position Position of the movie in the list.
     * @return
     */
    private static Movie createMovieAtPosition(int position) {
        String newTitle;
        String newDetail;
        int newPosterResId;
        switch (position) {
            case 0:
                newTitle = "The Shawshank Redemption";
                newDetail = "The Shawshank Redemption\n\n Andy Dufresne, a successful banker, is arrested for the murders of his wife and her lover, and is sentenced to life imprisonment at the Shawshank prison. He becomes the most unconventional prisoner.";
                newPosterResId = R.drawable.shawshank_redemption;
                break;
            case 1:
                newTitle = "The Godfather";
                newDetail = "The Godfather\n\nDon Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son, Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.";
                newPosterResId = R.drawable.godfather;
                break;
            case 2:
                newTitle = "The Dark Knight";
                newDetail = "The Dark Knight\n\nBatman has a new foe, the Joker, who is an accomplished criminal hell-bent on decimating Gotham City. Together with Gordon and Harvey Dent, Batman struggles to thwart the Joker before it is too late.";
                newPosterResId = R.drawable.dark_night;
                break;
            case 3:
                newTitle = "The Godfather Part II";
                newDetail = "The Godfather Part II\n\nVito's popularity in the underworld is on the rise, while his son, Michael's career is swinging downwards. In order to redeem himself, Michael must fight his enemies, including his own brother.";
                newPosterResId = R.drawable.godfather_part_2;
                break;
            case 4:
                newTitle = "12 Angry Men";
                newDetail = "12 Angry Men\n\nAn eighteen-year-old Latino is accused of having stabbed his father to death. He is presented in a courtroom before a twelve-man jury. Eleven out of the twelve men vote guilty, except for Mr. Davis.";
                newPosterResId = R.drawable.twelve_angry_men;
                break;
            case 5:
                newTitle = "Schindler's List";
                newDetail = "Schindler's List\n\nOscar Schindler, a successful and narcissistic German businessman, slowly starts worrying about the safety of his Jewish workforce after witnessing their persecution in Poland during World War II.";
                newPosterResId = R.drawable.schindler_list;
                break;
            case 6:
                newTitle = "The Lord of the Rings: The Return of the King";
                newDetail = "The Lord of the Rings: The Return of the King\n\nThe former Fellowship of the Ring prepares for the final battle. While Frodo and Sam approach Mount Doom to destroy the One Ring, they follow Gollum, unaware of the path he is leading them on.";
                newPosterResId = R.drawable.lord_of_rings;
                break;
            case 7:
                newTitle = "Pulp Fiction";
                newDetail = "Pulp Fiction\n\nIn the realm of underworld, a series of incidents intertwines the lives of two Los Angeles mobsters, a gangster's wife, a boxer and two small-time criminals.";
                newPosterResId = R.drawable.pulp_fiction;
                break;
            case 8:
                newTitle = "The Lord of the Rings: The Fellowship of the Ring";
                newDetail = "The Lord of the Rings: The Fellowship of the Ring\n\nA ring with mysterious powers lands in the hands of a young hobbit, Frodo. Under the guidance of Gandalf, a wizard, he and his three friends set out on a journey and land in the Elvish kingdom.";
                newPosterResId = R.drawable.lord_of_rings_fellowship;
                break;
            default:
                newTitle = "The Good, the Bad and the Ugly";
                newDetail = "The Good, the Bad and the Ugly\n\nA bounty hunting expedition brings two men together in an uncomfortable alliance while looking for buried treasure. They also battle with a wanted outlaw who wants to settle an old score with them.";
                newPosterResId = R.drawable.good_bad_ugly;
                break;
        }
        return new Movie(newTitle, newDetail, newPosterResId);
    }
}
