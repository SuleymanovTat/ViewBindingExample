package ru.suleymanovtat.viewbindingapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.suleymanovtat.viewbindingapplication.databinding.ItemCityBinding
import ru.suleymanovtat.viewbindingapplication.model.City

class CityAdapter(private val listener: OnClickItem) :
    RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    private var cities: List<City>? = null

    interface OnClickItem {
        fun clickItem(name: String)
    }

    fun setList(list: List<City>) {
        cities = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bing(cities?.get(position)?.name ?: "", listener)
    }

    override fun getItemCount() = cities?.size ?: 0

    class ViewHolder(val binding: ItemCityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bing(name: String, listener: OnClickItem) {
            binding.textViewName.text = name
            binding.root.setOnClickListener {
                listener.clickItem(name)
            }
        }
    }
}