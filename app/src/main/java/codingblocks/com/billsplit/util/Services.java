package codingblocks.com.billsplit.util;

import codingblocks.com.billsplit.service.TourService;
import codingblocks.com.billsplit.service.UserService;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by hp on 5/16/2018.
 */
public class Services {

    private static Services services;

    private Retrofit retrofit;

    private UserService userService;

    private TourService tourService;

    private Services(){

        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://sleepy-hollows-48639.herokuapp.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build();

        this.userService = this.retrofit.create(UserService.class);

        this.tourService = this.retrofit.create(TourService.class);
    }

    public static Services getInstance(){
        if (services == null){
            services = new Services();
        }

        return services;
    }


    public UserService getUserService() {
        return userService;
    }

    public TourService getTourService() {
        return tourService;
    }
}
