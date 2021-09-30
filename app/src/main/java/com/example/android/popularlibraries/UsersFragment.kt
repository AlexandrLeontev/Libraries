package com.example.android.popularlibraries

//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.ViewGroup
import android.annotation.SuppressLint
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android.popularlibraries.adapters.UsersRVAdapter
import com.example.android.popularlibraries.databinding.FragmentUsersBinding
import com.example.android.popularlibraries.model.GithubUsersRepo
import com.example.android.popularlibraries.presenter.BackButtonListener
import com.example.android.popularlibraries.presenter.UsersPresenter
import com.example.android.popularlibraries.view.UsersView
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

//class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    class UsersFragment : MvpAppCompatFragment(R.layout.fragment_users), UsersView, BackButtonListener {

    companion object {
       // fun newInstance() = UsersFragment()
        fun newInstance(): Fragment = UsersFragment()
    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(GithubUsersRepo(), App.instance.router, AndroidScreens())
    }
    private var adapter: UsersRVAdapter? = null

//    private var vb: FragmentUsersBinding? = null
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ) =
//        FragmentUsersBinding.inflate(inflater, container, false).also {
//            vb = it
//        }.root
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        vb = null
//    }

    private val vb: FragmentUsersBinding by viewBinding()

    override fun init() {
  //      vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        vb.rvUsers.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
  //      vb?.rvUsers?.adapter = adapter
        vb.rvUsers.adapter = adapter
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}