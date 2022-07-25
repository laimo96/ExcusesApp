package com.example.excusesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.excusesapp.databinding.ActivityMainBinding
import com.example.excusesapp.ui.fragments.*
import dagger.hilt.android.AndroidEntryPoint
import com.example.excusesapp.ui.fragments.AllExcusesFragment as AllExcusesFragment1

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.allExcusesButton.setOnClickListener{
            changeFragment(AllExcusesFragment1())
        }
        binding.familyExcusesButton.setOnClickListener {
            changeFragment(FamilyExcusesFragment())
        }
        binding.officeExcusesButton.setOnClickListener {
            changeFragment(OfficeExcusesFragment())
        }
        binding.childrenExcusesButton.setOnClickListener {
            changeFragment(ChildrenExcusesFragment())
        }
        binding.collegeExcusesButton.setOnClickListener {
            changeFragment(CollegeExcusesFragment())
        }
        binding.partyExcusesButton.setOnClickListener {
            changeFragment(PartyExcusesFragment())
        }
    }

    private fun changeFragment(fragment: Fragment) {
        val fragmentManager= supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}