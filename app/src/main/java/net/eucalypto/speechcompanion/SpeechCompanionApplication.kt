package net.eucalypto.speechcompanion

import android.app.Application
import timber.log.Timber

class SpeechCompanionApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}