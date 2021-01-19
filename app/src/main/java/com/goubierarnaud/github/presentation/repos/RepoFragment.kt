package com.goubierarnaud.github.presentation.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.goubierarnaud.github.R
import com.goubierarnaud.github.presentation.MainActivity

class RepoFragment : Fragment() {

    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var language: TextView
    private lateinit var fork: TextView
    private lateinit var watchers: TextView
    private lateinit var license: TextView
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    private val viewModel: RepoViewModel by viewModels()

    private lateinit var adapter: RepoAdapter

    companion object {
        private const val KEY_LOGIN = "key_login"

        fun newInstance(login: String): RepoFragment {
            val bundle = Bundle()
            bundle.putString(KEY_LOGIN, login)

            val fragment = RepoFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_user_repos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progressBar = view.findViewById(R.id.progress_bar)
        recyclerView = view.findViewById(R.id.recycler_view)

        adapter = RepoAdapter(requireContext())
        recyclerView.adapter = adapter

        viewModel.state.observe(viewLifecycleOwner, ::updateState)

        arguments?.getString(KEY_LOGIN)?.let {
            viewModel.getUserRepos(it)
        }
    }

    private fun updateState(state: RepoState) {
        when (state) {
            is RepoState.ErrorState -> {
                progressBar.isVisible = false
                Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                adapter.setData(null)
            }
            is RepoState.LoadingState -> {
                progressBar.isVisible = true
                adapter.setData(null)
            }
            is RepoState.SuccessState -> {
                progressBar.isVisible = false
                adapter.setData(state.repos)
            }
        }
    }
}