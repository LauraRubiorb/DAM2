package com.example.recetas.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recetas.databinding.FragmentMainBinding
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.recetas.model.category
import com.example.recetas.ui.adapter.AdapterCategories
import com.google.android.material.snackbar.Snackbar


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var binding: FragmentMainBinding? = null
    private lateinit var adater_categories: AdapterCategories

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adater_categories = AdapterCategories(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.recyclerComidas?.adapter = adater_categories
        binding?.recyclerComidas?.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        getCategorias()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    // https://www.themealdb.com/api/json/v1/1/categories.php

    private fun getCategorias(): Unit {
        val peticion = JsonObjectRequest("https://www.themealdb.com/api/json/v1/1/categories.php",
            {
                val category = it.getJSONArray("categories")
                for (i in 0 until category.length()) {
                    val item = category.getJSONObject(i)
                    val itemCategory = category(
                        item.getString("strCategory"),
                        item.getString("strCategoryThumb"),
                        item.getString("strCategoryDescription")
                    )
                    adater_categories.addCategory(itemCategory)
                }

            },
            {
                Snackbar.make(binding!!.root,"Error",Snackbar.LENGTH_LONG).show()
            })
        Volley.newRequestQueue(context).add(peticion)
    }
}