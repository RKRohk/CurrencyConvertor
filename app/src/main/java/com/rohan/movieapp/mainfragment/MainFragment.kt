package com.rohan.movieapp.mainfragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.rohan.movieapp.R
import com.rohan.movieapp.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MainFragmentBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = this.viewModel

        val spinner = binding.currencySpinner1
        spinner.onItemSelectedListener = SpinnerTools(viewModel.curr1)
        val spinner2 = binding.currencySpinner2
        spinner2.onItemSelectedListener = SpinnerTools(viewModel.curr2)
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.currency,
            android.R.layout.simple_spinner_item
        )
            .also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner.adapter = adapter
                spinner2.adapter = adapter
            }

        viewModel.input.observe(this, Observer {
            Log.i("MainFragment",it)
        })

        binding.convertButton.setOnClickListener {
            Log.i("MainFragment",viewModel.input.value.toString())
        }
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


}

class SpinnerTools(val ldata: MutableLiveData<String>) : AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
        ldata.value = parent!!.getItemAtPosition(0).toString()
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        ldata.value = parent!!.getItemAtPosition(position).toString()
    }

}