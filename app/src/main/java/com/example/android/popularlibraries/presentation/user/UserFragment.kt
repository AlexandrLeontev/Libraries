package com.example.android.popularlibraries.presentation.user

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.popularlibraries.App.Navigation.router
import com.example.android.popularlibraries.R.layout.view_user
import com.example.android.popularlibraries.data.user.GitHubUserRepositoryFactory
import com.example.android.popularlibraries.databinding.ViewUserBinding
import com.example.android.popularlibraries.ext.arguments
import com.example.android.popularlibraries.ext.setStartDrawableCircleImageFromUri
import com.example.android.popularlibraries.presentation.GitHubUserViewModel
import com.example.android.popularlibraries.scheduler.SchedulersFactory
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment : MvpAppCompatFragment(view_user), UserView {

    private lateinit var userBundle: GitHubUserViewModel

    companion object Factory {

        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            UserFragment()
                .arguments(ARG_USER_LOGIN to userId)

    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    @Suppress("unused")
    private val presenter: UserPresenter by moxyPresenter {
        UserPresenter(
            userLogin = userLogin,
            router = router,
            userRepository = GitHubUserRepositoryFactory.create(),
            schedulers = SchedulersFactory.create()
        )
    }

    private val viewBinding: ViewUserBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.userLogin.setOnClickListener {
            presenter.displayUserRepos(userBundle)
        }

    }

    override fun showUser(user: GitHubUserViewModel) {
        viewBinding.userLogin.setStartDrawableCircleImageFromUri(user.avatar)
        viewBinding.userLogin.text = user.login
        userBundle = user
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), "User Fragment", Toast.LENGTH_LONG).show()
    }
}