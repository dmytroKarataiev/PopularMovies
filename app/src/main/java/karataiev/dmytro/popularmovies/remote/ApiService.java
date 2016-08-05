/*
 *  The MIT License (MIT)
 *
 *  Copyright (c) 2016. Dmytro Karataiev
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package karataiev.dmytro.popularmovies.remote;

import karataiev.dmytro.popularmovies.BuildConfig;
import karataiev.dmytro.popularmovies.model.Actor;
import karataiev.dmytro.popularmovies.model.ActorCredits;
import karataiev.dmytro.popularmovies.model.ActorImage;
import karataiev.dmytro.popularmovies.model.ActorTagged;
import karataiev.dmytro.popularmovies.model.Backdrops;
import karataiev.dmytro.popularmovies.model.MovieCredits;
import karataiev.dmytro.popularmovies.model.MovieObject;
import karataiev.dmytro.popularmovies.model.MovieResults;
import karataiev.dmytro.popularmovies.model.MovieReviews;
import karataiev.dmytro.popularmovies.model.MovieTrailers;
import karataiev.dmytro.popularmovies.model.TvObject;
import karataiev.dmytro.popularmovies.model.TvResults;
import karataiev.dmytro.popularmovies.model.person.PersonPopular;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Movies DB API Service
 * Created by karataev on 5/8/16.
 */
public interface ApiService {

    String API_KEY = "?api_key=" + BuildConfig.MOVIE_DB_API_KEY;

    @GET("movie/{sort}" + API_KEY)
    Observable<MovieResults> getMoviesSort(@Path("sort") String sort);

    @GET("movie/{id}" + API_KEY)
    Observable<MovieObject> getMovie(@Path("id") String movieId);

    @GET("movie/{id}/credits" + API_KEY)
    Observable<MovieCredits> getMovieCredits(@Path("id") String movieId);

    @GET("movie/{id}/images" + API_KEY)
    Observable<Backdrops> getMovieImages(@Path("id") String movieId);

    @GET("movie/{id}/videos" + API_KEY)
    Observable<MovieTrailers> getMovieVideos(@Path("id") String movieId);

    @GET("movie/{id}/reviews" + API_KEY)
    Observable<MovieReviews> getMovieReviews(@Path("id") String movieId);

    // Actor related APIs
    @GET("person/popular" + API_KEY)
    Observable<PersonPopular> getActorPopular(@Query("page") int page);

    @GET("person/{id}" + API_KEY)
    Observable<Actor> getActor(@Path("id") String actorId);

    @GET("person/{id}/images" + API_KEY)
    Observable<ActorImage> getActorImages(@Path("id") String actorId);

    @GET("person/{id}/tagged_images" + API_KEY)
    Observable<ActorTagged> getActorTagged(@Path("id") String actorId);

    @GET("person/{id}/movie_credits" + API_KEY)
    Observable<ActorCredits> getActorCredits(@Path("id") String actorId);

    // Tv related APIs

    @GET("tv/popular" + API_KEY)
    Observable<TvResults> getTvPopular(@Query("page") int page);

    @GET("tv/{id}" + API_KEY)
    Observable<TvObject> getTvId(@Path("id") String tvId);

    @GET("tv/{id}/images" + API_KEY)
    Observable<Backdrops> getTvImages(@Path("id") String movieId);

    @GET("tv/{id}/credits" + API_KEY)
    Observable<ActorCredits> getTvCredits(@Path("id") String tvId);
}
