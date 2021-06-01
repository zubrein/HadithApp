package xit.zubrein.hadith.adapter

import android.content.Context
import android.text.Html
import androidx.navigation.Navigation
import xit.zubrein.hadith.R
import xit.zubrein.hadith.base.BaseRecyclerviewAdapter
import xit.zubrein.hadith.databinding.CollectionItemsBinding
import xit.zubrein.hadith.model.ModelBooks
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.ui.collection.CollectionFragmentDirections

class CollectionAdapter(private val context:Context) : BaseRecyclerviewAdapter<ModelBooks,CollectionItemsBinding>(){

    override fun getLayout() = R.layout.collection_items

    override fun onBindViewHolder(holder: Companion.BaseViewHolder<CollectionItemsBinding>, position: Int) {
        holder.binding.apply {
            val item = items[position]
            nameEng = item.collection?.get(0)?.title
            nameAr = Html.fromHtml(item.collection?.get(1)?.title).toString()
            parent.setOnClickListener {
                val action =  CollectionFragmentDirections.actionColectionFragmentToChapterFragment(item.name)
                Navigation.findNavController(parent).navigate(action)
            }
        }
    }

}