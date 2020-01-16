package com.farouk.exomindproject.presenter.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.farouk.exomindproject.R
import com.farouk.exomindproject.data.model.user.UserResponse
import com.farouk.exomindproject.presenter.factory.UserViewModelFactory
import com.farouk.exomindproject.presenter.ui.adapter.UsersAdapter
import com.farouk.exomindproject.presenter.ui.listener.UsersClickListener
import com.farouk.exomindproject.presenter.viewmodel.UsersViewModel
import kotlinx.android.synthetic.main.fragment_users.*



class UsersFragment : BaseFragment(), UsersClickListener{

    private lateinit var userViewModel: UsersViewModel
    private lateinit var userAdapter: UsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setRepo()
        setHasOptionsMenu(true)
    }

    private fun setRepo() {
        val factory = UserViewModelFactory()
        userViewModel = ViewModelProviders.of(this, factory).get(UsersViewModel::class.java)
        userViewModel.getUsers()

        userViewModel.userLiveData.observe(viewLifecycleOwner, Observer { users ->
            recycleview_user.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                userAdapter = UsersAdapter(users, this)
                it.adapter = userAdapter
                //searchLaboratory()
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, labo: UserResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    private fun searchLaboratory() {
//        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextChange(newText: String): Boolean {
//                laboAdapter.filter.filter(newText)
//                return false
//            }
//
//            override fun onQueryTextSubmit(query: String): Boolean {
//                laboAdapter.filter.filter(query)
//                return false
//            }
//        })
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu, menu)
//        searchView = menu.findItem(R.id.search_view).actionView as SearchView
//        searchView.queryHint = getString(R.string.search_hint)
//        super.onCreateOptionsMenu(menu, inflater)
//    }



}

