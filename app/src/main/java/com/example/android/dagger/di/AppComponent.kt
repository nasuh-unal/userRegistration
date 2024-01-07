package com.example.android.dagger.di

import android.content.Context
import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.main.MainActivity
import com.example.android.dagger.registration.RegistrationActivity
import com.example.android.dagger.registration.RegistrationComponent
import com.example.android.dagger.registration.enterdetails.EnterDetailsFragment
import com.example.android.dagger.registration.termsandconditions.TermsAndConditionsFragment
import com.example.android.dagger.settings.SettingsActivity
import com.example.android.dagger.user.UserManager
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class, AppSubcomponents::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    //RegistrationComponent'e erişmek için burada bir fonksiyon oluşturuyoruz.
    fun registrationComponent(): RegistrationComponent.Factory
    fun loginComponent(): LoginComponent.Factory

    fun userManager(): UserManager

    //fun inject(activity: MainActivity)
    //fun inject(activity:SettingsActivity)
    /*
    MainActivity ve RegistrationActicity farklı userManager kullanıyor birisi dagger tarafınfan oluşturanı kullanıyor bu
    nedenle aynı userManager kullanması için MainActivity de dagger yapıcaz
     */

    /*
    Dagger grafiği ile etkileşim kurmanın iki farklı yolu vardır:
    Unit döndüren ve parametre olarak bir sınıf alan bir fonksiyonun bildirilmesi, o sınıfa alan enjeksiyonu yapılmasını
    sağlar (örn. fun inject(activity: MainActivity)).
    Tür döndüren bir fonksiyonun bildirilmesi, grafikten türlerin alınmasını sağlar
    (örn. fun registrationComponent(): RegistrationComponent.Factory).
     */
}