package com.example.android.dagger.di

import com.example.android.dagger.login.LoginComponent
import com.example.android.dagger.registration.RegistrationComponent
import com.example.android.dagger.user.UserComponent
import dagger.Module

@Module(subcomponents = [RegistrationComponent::class, LoginComponent::class, UserComponent::class])
class AppSubcomponents {
    //AppSubcomponents sınıfını AppComponent sınıfının bir alt sınıfı olduğunu bildirmek için oluşturduk
    //RegistrationComponent sınıfını buraya veriyoruz
}
    /*
    RegistrationViewModel UserRepository'e bağlı olduğu için bir RegistrationComponent, AppComponent'teki nesnelere
    erişebilmelidir. Dagger'a yeni bir Component'in başka bir Component'in bir parçasını kullanmasını istediğimizi
    söylemenin yolu Dagger Subcomponents'tır.

    Alt komponentler, bir ana komponentin nesne grafiğini miras alan ve genişleten komponentlerdir.
     Böylece, ana bileşende sağlanan tüm nesneler alt bileşende de sağlanacaktır.
      Bu şekilde, bir alt bileşendeki bir nesne ana bileşen tarafından sağlanan bir nesneye bağlı olabilir.
    */