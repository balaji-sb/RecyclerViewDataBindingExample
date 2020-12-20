package com.pb.pbdatabinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.pb.pbdatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var mainAdapter: MainActivityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainAdapter = MainActivityAdapter()
        binding.recycler.adapter = mainAdapter
        mainAdapter.data = dummyData()
    }

    private fun dummyData(): ArrayList<User> {
        val userList = arrayListOf<User>()
        userList.add(User("Android"))
        userList.add(User("iOS"))
        userList.add(User("Macbook"))
        userList.add(User("Air"))
        userList.add(User("Pro"))
        userList.add(User("Smart Watch"))
        userList.add(User("Fridge"))
        userList.add(User("TV"))
        userList.add(User("Mixi"))
        return userList
    }
}