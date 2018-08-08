package humeniuk.cityorganizer.dagger.modules

import dagger.Module
import dagger.Provides
import humeniuk.cityorganizer.BuildConfig
import humeniuk.cityorganizer.api.WeatherApi
import humeniuk.cityorganizer.api.interceptors.QueryInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule() {

    @Provides
    fun provideQueryInterceptor() : QueryInterceptor {
        return QueryInterceptor()
    }

    @Provides
    fun provideHttpClient(queryInterceptor: QueryInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor())
                .addInterceptor(queryInterceptor)
                .build()
    }

    @Provides
    fun provideWeatherApi(okHttpClient: OkHttpClient) : WeatherApi {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApi::class.java)
    }
}