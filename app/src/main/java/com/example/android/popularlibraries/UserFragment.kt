package com.example.android.popularlibraries

//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.popularlibraries.databinding.FragmentUserBinding
import com.example.android.popularlibraries.model.GithubUser
import com.example.android.popularlibraries.presenter.BackButtonListener
import com.example.android.popularlibraries.presenter.UserPresenter
import com.example.android.popularlibraries.view.UserView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

//class UserFragment : MvpAppCompatFragment(), UserView, BackButtonListener {
    class UserFragment : MvpAppCompatFragment(R.layout.fragment_user), UserView, BackButtonListener {

    private val vb: FragmentUserBinding by viewBinding()
   // private var vb: FragmentUserBinding? = null
    private val presenter: UserPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER) as GithubUser
        UserPresenter(App.instance.router, user)
    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ) = FragmentUserBinding.inflate(inflater, container, false).also {
//        vb = it
//    }.root

    override fun setLogin(text: String) {
        //vb?.userLoginText?.text = text
        vb.userLoginText.text = text
    }

    override fun backPressed() = presenter.backPressed()

    companion object {
        private const val USER = "USER"
       // fun newInstance(user: GithubUser) =
       fun newInstance(user: GithubUser): Fragment =
            UserFragment().apply {
                //arguments = Bundle().apply {
                arguments = bundleOf().apply {
                    putParcelable(USER, user)
                }
            }
    }
}