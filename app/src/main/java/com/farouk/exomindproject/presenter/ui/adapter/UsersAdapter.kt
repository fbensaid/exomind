package com.farouk.exomindproject.presenter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.farouk.exomindproject.R
import com.farouk.exomindproject.data.model.user.UserResponse
import com.farouk.exomindproject.databinding.RecycleviewUserBinding
import com.farouk.exomindproject.presenter.ui.listener.UsersClickListener

class UsersAdapter(
    private val listofUser: List<UserResponse>,
    private val listner: UsersClickListener

) : RecyclerView.Adapter<UsersAdapter.LaboratoryViewHolder>(), Filterable {
    private var filtredListofUser = listofUser
    private var resultListOfSearch = arrayListOf<UserResponse>()

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                filtredListofUser = if (p0.isNullOrEmpty())
                    listofUser
                else {
                    resultListOfSearch.clear()
                    listofUser.forEach {
                        if (it.name.toLowerCase().contains(p0.toString()))
                            resultListOfSearch.add(it)
                    }
                    resultListOfSearch
                }
                var filtredResult = FilterResults()
                filtredResult.values = filtredListofUser
                return filtredResult
            }

            override fun publishResults(p0: CharSequence?, filtredResult: FilterResults?) {
                filtredListofUser = listOf()
                filtredListofUser = filtredResult!!.values as List<UserResponse>
                notifyDataSetChanged()
            }
        }
    }


    override fun getItemCount(): Int {
        return filtredListofUser.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LaboratoryViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycleview_user,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: LaboratoryViewHolder, position: Int) {
        holder.recycleviewLaboratoryBinding.userListResponseData =
            filtredListofUser[position]

        holder.recycleviewLaboratoryBinding.cardViewLabo.setOnClickListener {
            listner.onRecyclerViewItemClick(
                holder.recycleviewLaboratoryBinding.cardViewLabo,
                filtredListofUser[position]
            )
        }

    }


    inner class LaboratoryViewHolder(
        val recycleviewLaboratoryBinding: RecycleviewUserBinding
    ) : RecyclerView.ViewHolder(recycleviewLaboratoryBinding.root)
}


