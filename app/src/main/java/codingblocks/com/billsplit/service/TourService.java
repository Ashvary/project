package codingblocks.com.billsplit.service;

import java.util.List;

import codingblocks.com.billsplit.model.Owe;
import codingblocks.com.billsplit.model.Tour;
import codingblocks.com.billsplit.model.Transaction;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by hp on 5/15/2018.
 */
public interface TourService {

    @GET("/tours/{id}/")
    public Call<Tour> getTour(@Path("id") String id);

    @GET("/tours/{id}/balance/")
    public Call<List<Owe>> getBalances();

    @POST("/tours/")
    public Call<Void> createTour(@Body Tour tour);

    @POST("/tours/{id}/transaction/")
    public Call<Void> createTransaction(@Path("id") String tourId, @Body Transaction transaction);

    @PUT("/tours/{id}/")
    public Call<Void> updateTour(@Path("id") String id, @Body Tour tour);

    @DELETE("/tours/{id}/")
    public Call<Void> removeTour(@Path("id") String id);


}
