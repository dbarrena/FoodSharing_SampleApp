package diegob.foodsharing.api

import diegob.foodsharing.utils.BASE_URL
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceInterface {

    /* @GET("login/{user}")
    fun login(@Path("user") user: String): Observable<Login> */

    companion object Factory {
        fun create(): ApiServiceInterface {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)

            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .build()

            return retrofit.create(ApiServiceInterface::class.java)
        }
    }
}