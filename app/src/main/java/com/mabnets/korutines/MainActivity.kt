package com.mabnets.korutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mabnets.korutines.adapters.Quotesadapter
import com.mabnets.korutines.databinding.ActivityMainBinding
import com.mabnets.korutines.viewmodel.Quotesviewmodel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding:ActivityMainBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       lateinit var viewModel: Quotesviewmodel
        viewModel = ViewModelProvider(this).get(Quotesviewmodel::class.java)
        viewModel.Quotez.observe(this, Observer {Quote->
            binding.rv.also {
                it.layoutManager= LinearLayoutManager(this)
                it.setHasFixedSize(true)
                it.adapter= Quote?.let { it1 -> Quotesadapter(it1) }
            }
        })
    }
}