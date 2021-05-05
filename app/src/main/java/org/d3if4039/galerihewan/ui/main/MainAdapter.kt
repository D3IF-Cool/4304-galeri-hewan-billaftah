package org.d3if4039.galerihewan.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if4039.galerihewan.R
import org.d3if4039.galerihewan.model.Hewan
import org.d3if4039.galerihewan.databinding.ListItemBinding
import org.d3if4039.galerihewan.network.HewanApi

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val data = mutableListOf<Hewan>()

    fun updateData(newData: List<Hewan>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(hewan: Hewan) {
            with(binding) {
                tvNama.text = hewan.nama
                tvNamaLatin.text = hewan.namaLatin
                Glide.with(gambar.context)
                    .load(HewanApi.getHewanUrl(hewan.imageId))
                    .error(R.drawable.broken_img)
                    .into(gambar)
            }
        }
    }
}