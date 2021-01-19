package com.goubierarnaud.github.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import com.goubierarnaud.github.R
import com.goubierarnaud.github.presentation.repos.RepoFragment
import com.goubierarnaud.github.presentation.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private var container2: FragmentContainerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        container2 = findViewById(R.id.fragment_container2)

        supportFragmentManager.commit {
            add(R.id.fragment_container, SearchFragment())
        }
    }

    fun displayUserRepos(login: String) {

        if (container2 != null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container2, RepoFragment.newInstance(login))
            }
        } else {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, RepoFragment.newInstance(login))
                addToBackStack(null)
            }
        }
    }
}