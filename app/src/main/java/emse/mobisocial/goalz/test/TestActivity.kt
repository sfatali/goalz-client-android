package emse.mobisocial.goalz.test

import android.support.v7.app.AppCompatActivity

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth

import emse.mobisocial.goalz.R
import emse.mobisocial.goalz.test.fragments.TestGoalFragment
import emse.mobisocial.goalz.test.fragments.TestRecommendationFragment
import emse.mobisocial.goalz.test.fragments.TestResourceFragment
import emse.mobisocial.goalz.test.fragments.TestUserFragment
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null
    private lateinit var mFirebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        setSupportActionBar(toolbar1)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        container1.adapter = mSectionsPagerAdapter

        mFirebaseAuth = FirebaseAuth.getInstance()
        mFirebaseAuth.signInWithEmailAndPassword("dtoniuc@gmail.com", "dtoniucpass").addOnCompleteListener {
            task ->
            if(task.isSuccessful){
                Log.d("SIGNIN","login success")
            }
            else {
                Log.d("SIGNIN","login fail")
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_test, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            when(position){
                0 -> return TestUserFragment()
                1 -> return TestResourceFragment()
                2 -> return TestGoalFragment()
                3 -> return TestRecommendationFragment()
            }

            return TestResourceFragment()
        }

        override fun getCount(): Int {
            return 4
        }
    }
}
