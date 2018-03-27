package emse.mobisocial.goalz

import android.app.Application
import emse.mobisocial.goalz.dal.repositories.UserRepository
import emse.mobisocial.goalz.dal.db.AppDatabase
import emse.mobisocial.goalz.dal.repositories.ResourceRepository

/**
 * Created by MobiSocial EMSE Team on 3/27/2018.
 *
 * Android Application class. Used for accessing singletons.
 */
class GoalzApp : Application() {

    private lateinit var appExecutors: AppExecutors

    override fun onCreate() {
        super.onCreate()

        appExecutors = AppExecutors()
    }

    private val database: AppDatabase
        get() = AppDatabase.getInstance(this, appExecutors)

    val userRepository: UserRepository
        get() = UserRepository.getInstance(appExecutors.diskIO(), database.userDao())

    val resourceRepository: ResourceRepository
        get() = ResourceRepository.getInstance(appExecutors.diskIO(), database.resourceDao())
}