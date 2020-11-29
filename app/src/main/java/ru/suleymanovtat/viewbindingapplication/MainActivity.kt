package ru.suleymanovtat.viewbindingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.suleymanovtat.viewbindingapplication.adapter.CityAdapter
import ru.suleymanovtat.viewbindingapplication.databinding.ActivityMainBinding
import ru.suleymanovtat.viewbindingapplication.model.City

class MainActivity : AppCompatActivity(), CityAdapter.OnClickItem {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val cityAdapter = CityAdapter(this)
        val cities = arrayListOf<City>()
        cities.add(City("Kazan"))
        cities.add(City("Chelny"))
        cities.add(City("Omsk"))
        cities.add(City("Elabuga"))
        cities.add(City("Kirov"))
        cityAdapter.setList(cities)
        binding.recyclerView.adapter = cityAdapter
    }

    override fun clickItem(name: String) {
        startActivity(Intent(this, OtherActivity::class.java))
    }
}