package com.basic.viewmodellivedatasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.basic.viewmodellivedatasample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: SampleViewModel

    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewModel = ViewModelProvider(this).get(SampleViewModel::class.java)

        viewBinding.btnAdd.setOnClickListener {
            viewModel.number++
            viewModel.currentCount.value = viewModel.number
            viewModel.currentBoolean.value = (viewModel.number % 2 == 0)
        }

        viewModel.currentCount.observe(this, Observer {
            viewBinding.txtCount.text = it.toString()
        })

        viewModel.currentBoolean.observe(this, Observer {
            viewBinding.txtEven.text = it.toString()
            if(viewModel.currentBoolean.value == true){
                viewBinding.imgMinion.setImageDrawable(getDrawable(R.drawable.minion_even))
            }else{
                viewBinding.imgMinion.setImageDrawable(getDrawable(R.drawable.minion_odd))
            }
        })
    }
}