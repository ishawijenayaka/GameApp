package com.example.gameapp.di


import com.example.apptask.data.remote.ApiService
import com.example.gameapp.core.Constants
import com.example.gameapp.data.repository.GamesRepositoryImpl
import com.example.gameapp.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): ApiService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGameRepository(api: ApiService): GameRepository {
        return GamesRepositoryImpl(api)
    }


}

//    @Provides
//    @Singleton
//    fun provideNetworkConnectionCheck(@ApplicationContext appContext: Context): ConnectivityObserver =
//        NetworkConnectivityObserver(appContext)

