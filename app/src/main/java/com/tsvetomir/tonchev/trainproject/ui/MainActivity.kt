package com.tsvetomir.tonchev.trainproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tsvetomir.tonchev.trainproject.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mViewModel: MainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }
    private lateinit var mAdapterOne: TrainAdapter
    private lateinit var mAdapterTwo: TrainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handleRecyclerView()

        mViewModel.arklowLiveData.observe(this, Observer {
            mAdapterOne.loadData("Arklow",it)
        })
        mViewModel.shankillLiveData.observe(this, Observer {
            mAdapterTwo.loadData("Shankill",it)
        })
        mViewModel.getAllTrains()
    }

    private fun handleRecyclerView() {
        recycler_view_one.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            mAdapterOne = TrainAdapter()
            adapter = mAdapterOne
        }
        recycler_view_two.apply {
            layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
            mAdapterTwo = TrainAdapter()
            adapter = mAdapterTwo
        }
    }
}
