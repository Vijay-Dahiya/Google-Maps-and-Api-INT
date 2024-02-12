package co.vijay.machineTask.network

import co.vijay.machineTask.utility.Constants
import co.vijay.machineTask.utility.Constants.TIMEOUT_TIME
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PostmanModule {

    @Singleton
    @Provides
    fun getAuthService(): ApiClient {
        val defaultRetrofitClient = createRetrofitClient(
            Constants.BASE_URL
        )
        return defaultRetrofitClient.create(ApiClient::class.java)
    }

    private fun createRetrofitClient(
        url: String,
    ): Retrofit {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addNetworkInterceptor(Interceptor { chain ->
            val requestBuilder: Request.Builder = chain.request().newBuilder()
            chain.proceed(requestBuilder.build())
        })
        val loggingInterceptor = HttpLoggingInterceptor()
        val gson = GsonBuilder()
            .setLenient()
            .create()

        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        with(okHttpClientBuilder) {
            connectTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
            readTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
            writeTimeout(TIMEOUT_TIME, TimeUnit.SECONDS)
            addInterceptor(loggingInterceptor)
        }

        return Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClientBuilder.build())
            .build()
    }

}