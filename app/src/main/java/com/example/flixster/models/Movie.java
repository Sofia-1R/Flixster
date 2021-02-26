package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;
@Parcel
public class Movie {
    int movieId;
    String posterPath;
    String backDropPath;
    String title;
    String overview;
    double rating;
    double popular;

    public Movie() {
        //empty constructor needed by Parcel
    }
    public Movie(JSONObject jsonObject) throws JSONException {
        backDropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview= jsonObject.getString("overview");
        rating= jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
        popular = jsonObject.getDouble("popularity");
    }
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException{
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i <movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }
    public String getBackDropPath(){
        return String.format("https://image.tmdb.org/t/p/w342/%s", backDropPath);
    }
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating(){
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getPopular() {
        return Double.toString(popular);
    }
}
