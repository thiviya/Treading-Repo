package lifecycle


import com.example.viewModel.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


/**
 * List of services - our repositories
 */
val servicesModule = module {


}

/**
 * List of view-models available for dependency injection
 */
val viewModelModule = module {
    viewModel {MainViewModel()}
    viewModel {DetailsViewModel() }
}

/**
 * The Application class in Android is the base class within an Android app that contains all
 * other components such as activities and services.  The Application class, or any subclass of
 * the Application class, is instantiated before any other class when the process for your
 * application or package is created.
 */
class Application : android.app.Application() {
    /**
     * Called when the application is starting, before any activity, service, or receiver
     * object (excluding content providers) have been created.
     *
     * Implementations should be as quick as possible (for example, using lazy initialization
     * of state) since the time spent in this function directly impacts the performance of starting
     * the first activity, service, or receiver in a process.
     */
    override fun onCreate() {
        super.onCreate()

        // Initialize Koin dependency injection
        startKoin {
            androidLogger()
            androidContext(this@Application)
            modules(listOf(servicesModule, viewModelModule))
        }
    }
}
