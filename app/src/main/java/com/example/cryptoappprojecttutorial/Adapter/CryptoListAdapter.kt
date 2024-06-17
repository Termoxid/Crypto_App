package com.example.cryptoappprojecttutorial.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptoappprojecttutorial.Model.CryptoModel
import com.example.cryptoappprojecttutorial.R
import com.example.cryptoappprojecttutorial.databinding.VievholderWalletBinding

class CryptoListAdapter(private val items:MutableList<CryptoModel>):RecyclerView.Adapter<CryptoListAdapter.Viewholder>() {
    class Viewholder(val binding:VievholderWalletBinding):RecyclerView.ViewHolder(binding.root)

    private lateinit var context:Context
    var formatter:DecimalFormat?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context     = parent.context
        formatter   = DecimalFormat("###,###,###,###")
        val binding = VievholderWalletBinding.inflate(LayoutInflater.from(context), parent, false)

        return Viewholder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CryptoListAdapter.Viewholder, position: Int) {
        val item = items[position]
        holder.binding.cryptoNameTxt.text       = item.symbol
        holder.binding.cryptoPriceTxt.text      = "$" + formatter?.format(item.price)
        holder.binding.changePercentTxt.text    = item.changePercent.toString() + "%"
        holder.binding.propertySizeTxt.text     = item.amountNumber.toString() + item.shortSymbol.replace("/USDT","")
        holder.binding.propertyAmountTxt.text   = "$" + formatter?.format(item.amountDollar)

        if(item.changePercent<0) holder.binding.changePercentTxt.setTextColor(context.resources.getColor(R.color.red))

        val drawableResourceId   = holder.itemView.resources.getIdentifier(item.symbolLogo,"drawable", holder.itemView.context.packageName)

        Glide.with(context).load(drawableResourceId).into(holder.binding.logoImg)
    }

    override fun getItemCount(): Int = items.size
}