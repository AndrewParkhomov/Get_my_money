package parkhomov.andrew.getmymoney.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import parkhomov.andrew.getmymoney.interactor.MainActivityInteractor
import parkhomov.andrew.getmymoney.R
import parkhomov.andrew.getmymoney.utils.AppPreferencesHelper
import parkhomov.andrew.getmymoney.utils.PreferencesHelper
import parkhomov.andrew.getmymoney.utils.subnavigation.LocalCiceroneHolder
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Singleton


@Suppress("unused")
@Module
class ApplicationModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = context

    @Provides
    @Singleton
    fun providesSharedPreferences(context: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper =
            appPreferencesHelper

    @Provides
    @Singleton
    internal fun provideLocalNavigationHolder(): LocalCiceroneHolder = LocalCiceroneHolder()

    @Provides
    @Singleton
    fun provideCalligraphyDefaultConfig(): CalligraphyConfig =
            CalligraphyConfig.Builder()
                    .setDefaultFontPath("font/droid_sans.ttf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()

    // Interactors
    @Provides
    @Singleton
    fun provideInitialInteractor(
            preferencesHelper: PreferencesHelper
    ): MainActivityInteractor = MainActivityInteractor(
            preferencesHelper
    )

}
