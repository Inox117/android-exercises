package fr.android.androidexercises;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;

public interface HenriPotierService {

    @GET("books")
    Call<List<Book>> listBooks();

}
