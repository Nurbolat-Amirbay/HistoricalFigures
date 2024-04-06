package kz.ayala.historicalfiguresapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kz.ayala.historicalfiguresapi.databinding.HistoricalFigureBinding

class HistAdapter : ListAdapter<HistFigure, HistAdapter.HistoricalFigureViewHolder>(HistoricalFigureDiffCallback()) {


    class HistoricalFigureDiffCallback:DiffUtil.ItemCallback<HistFigure>(){
        override fun areItemsTheSame(oldItem: HistFigure, newItem: HistFigure): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: HistFigure, newItem: HistFigure): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoricalFigureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HistoricalFigureBinding.inflate(layoutInflater, parent, false)
        return HistoricalFigureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoricalFigureViewHolder, position: Int) {
        val historicalFigure = getItem(position)
        holder.bind(historicalFigure)
    }

    class HistoricalFigureViewHolder(private val binding: HistoricalFigureBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(historicalFigure: HistFigure) {
            with(binding) {
                tvName.text = historicalFigure.name
                tvTitle.text = historicalFigure.title
                tvBornDied.text = "Born: ${historicalFigure.info.born} - Died: ${historicalFigure.info.died}"
                tvOffice.text = "Office: ${historicalFigure.info.office.joinToString()}"
                tvNotableWork.text = "Notable Work: ${historicalFigure.info.notableWork.joinToString()}"
            }
        }
    }
}