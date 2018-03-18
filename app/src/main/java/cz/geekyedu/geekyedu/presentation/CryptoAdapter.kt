package cz.geekyedu.geekyedu.presentation

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cz.geekyedu.geekyedu.R
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import cz.geekyedu.geekyedu.presentation.utils.CryptoIconHelper
import cz.geekyedu.geekyedu.presentation.utils.GlideApp
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_crypto.*

class CryptoAdapter : ListAdapter<CryptoCurrency, CryptoAdapter.ViewHolder>(DiffCallback) {

    var onItemListener: (CryptoCurrency) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_crypto, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(getItem(position))
        holder.containerView.setOnClickListener {
            onItemListener(getItem(holder.adapterPosition))
        }
    }

    class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindTo(model: CryptoCurrency) {
            val nameText = "${model.symbol} | ${model.name}"
            val priceText = "$ ${model.priceUsd}"
            nameView.text = nameText
            priceView.text = priceText
            setPercentValue(model.percentChange24h, dayPercent)
            setPercentValue(model.percentChange7d, weekPercent)
            val iconUrl = CryptoIconHelper.getIconUrl(model.id)
            GlideApp
                    .with(containerView)
                    .load(iconUrl)
                    .into(iconView)
        }

        private fun setPercentValue(percent: Double, valueView: TextView) {
            val percentText = "$percent%"
            valueView.text = percentText
            val textColor = if (percent >= 0 ) R.color.plus else R.color.minus
            valueView.setTextColor(containerView.context.resources.getColor(textColor, null))
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<CryptoCurrency>() {
        override fun areItemsTheSame(oldItem: CryptoCurrency, newItem: CryptoCurrency) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: CryptoCurrency, newItem: CryptoCurrency) = oldItem == newItem
    }
}
