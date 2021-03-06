package emse.mobisocial.goalz.ui.viewModels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import emse.mobisocial.goalz.GoalzApp
import emse.mobisocial.goalz.dal.DalResponse
import emse.mobisocial.goalz.dal.IGoalRepository
import emse.mobisocial.goalz.dal.IResourceRepository
import emse.mobisocial.goalz.dal.IUserRepository
import emse.mobisocial.goalz.model.*


class CreateGoalViewModel(application: Application) : AndroidViewModel(application){

    var userId: String? = null
    private val goalRepository : IGoalRepository = (application as GoalzApp).goalRepository
    lateinit var userGoalsList: LiveData<List<Goal>>

    fun setUser(userId: String){
        this.userId = userId
        userGoalsList = goalRepository.getGoalsForUser(userId)
    }

    fun addGoal(newGoal:GoalTemplate) : LiveData<DalResponse> {
        return goalRepository.addGoal(newGoal)
    }

}