package com.vr.mecali

import android.app.Application
import androidx.lifecycle.LifecycleObserver
import com.vr.data.di.dataModule
import com.vr.data.di.networkModule
import com.vr.mecali.di.domainModule
import com.vr.mecali.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MecaliApplication : Application(), LifecycleObserver {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MecaliApplication)
            androidLogger()
            modules(listOf(viewModelModule, domainModule, dataModule, networkModule))
        }
    }
}