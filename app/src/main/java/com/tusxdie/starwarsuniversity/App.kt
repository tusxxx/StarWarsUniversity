package com.tusxdie.starwarsuniversity

import android.app.Application
import com.tusxdie.starwarsuniversity.di.databaseModule
import com.tusxdie.starwarsuniversity.di.networkModule
import com.tusxdie.starwarsuniversity.di.repositoryModule
import com.tusxdie.starwarsuniversity.di.useCaseModule
import com.tusxdie.starwarsuniversity.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                networkModule,
                databaseModule,
                repositoryModule,
                viewModelModule,
                useCaseModule
            )
        }
    }
}