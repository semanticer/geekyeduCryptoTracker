package cz.geekyedu.geekyedu.presentation

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import cz.geekyedu.geekyedu.data.model.CryptoCurrency
import kotlinx.android.extensions.LayoutContainer

class CryptoAdapter : ListAdapter<CryptoCurrency, CryptoAdapter.ViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // TODO create new layout for one row, inflate it here and create new view holder with it
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // TODO bind current item to holder
    }

    class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer {
        // TODO add way to bind CryptoCurrency to this view holder
    }

    object DiffCallback : DiffUtil.ItemCallback<CryptoCurrency>() {
        override fun areItemsTheSame(oldItem: CryptoCurrency, newItem: CryptoCurrency) = TODO("How to check that these two Cryptos are the same")
        override fun areContentsTheSame(oldItem: CryptoCurrency, newItem: CryptoCurrency) = TODO("How to check that their contents are the same")
    }
}
