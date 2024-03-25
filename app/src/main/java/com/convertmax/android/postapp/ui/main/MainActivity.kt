package com.convertmax.android.postapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.convertmax.android.postapp.PostApplication
import com.convertmax.android.postapp.R
import com.convertmax.android.postapp.data.post.remote.Status
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as PostApplication).component.inject(this)

        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        lifecycleScope.launch {
            viewModel.postState.collect {
                when (it.status) {
                    Status.LOADING -> Log.d(TAG, "Loading")
                    Status.SUCCESS -> it.data?.toString()?.let { it1 -> Log.d(TAG, it1) }
                    Status.ERROR -> Log.d(TAG, it.message.toString())
                }
            }
        }
    }
}