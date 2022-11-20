package com.artemiod.pokeapi.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artemiod.pokeapi.R
import com.artemiod.pokeapi.domain.SelectedListener
import com.artemiod.pokeapi.ui.viewmodel.DetailsViewModel


class MainActivity : AppCompatActivity(), SelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onSelected(id: Int) {
        val bundle = Bundle()
        bundle.putInt("id", id)

        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, detailFragment)
            .addToBackStack(null) // agragar al stack para volver con back
            .commit()
    }

}