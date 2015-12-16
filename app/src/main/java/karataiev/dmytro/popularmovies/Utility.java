package karataiev.dmytro.popularmovies;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

/**
 * Class with additional helper functions
 * Created by karataev on 12/15/15.
 */
class Utility {

    /**
     * Method to provide correct path to image, depending on the dpi metrics of the phone screen
     * @param context to get metrics data
     * @return String name which should be used in path to image
     */
    public static String[] posterSize(Context context) {

        DisplayMetrics metrics = context.getResources().getDisplayMetrics();

        String POSTER_SIZE;
        String POSTER_SIZE_DETAIL;

        switch (metrics.densityDpi) {
            case 120:
                POSTER_SIZE = "w92";
                POSTER_SIZE_DETAIL = "w154";
                break;
            case 160:
                POSTER_SIZE = "w154";
                POSTER_SIZE_DETAIL = "w185";
                break;
            case 213:
            case 240:
            case 320:
                POSTER_SIZE = "w185";
                POSTER_SIZE_DETAIL = "w342";
                break;
            case 480:
                POSTER_SIZE = "w342";
                POSTER_SIZE_DETAIL = "w500";
                break;
            case 640:
                POSTER_SIZE = "w500";
                POSTER_SIZE_DETAIL = "w780";
                break;
            default:
                POSTER_SIZE = "w185";
                POSTER_SIZE_DETAIL = "w342";
                break;
        }

        return new String[] { POSTER_SIZE, POSTER_SIZE_DETAIL };
    }

    /**
     * Method to get sort settings from SharedPreferences
     * @param context from which call was made
     * @return current sort preference
     */
    public static String getSort(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(context.getString(R.string.pref_sort_key),
                context.getString(R.string.pref_sort_default));
    }

    /**
     * Formats date (cuts everything except the year)
     * @param date with month and day
     * @return year only
     */
    public static String formatDate(String date) {

        if (date.length() > 3) {
            return date.substring(0, 4);
        }
        else {
            return date;
        }
    }

    /**
     * Adds "/10" to the end of the fetched rating
     * @param rating from JSON
     * @return String rating + "/10"
     */
    public static String formatRating(String rating) {

        if (rating.length() > 2) {
            return rating.substring(0, 3) + "/10";
        }
        else {
            return rating + "/10";
        }
    }

    /**
     * Formats votes -> adds "," thousands separator
     * @param votes as a String
     * @return formatted String with thousands separator
     */
    public static String formatVotes(String votes) {

        int votesInt = Integer.parseInt(votes);

        return String.format("%,d", votesInt);
    }
}