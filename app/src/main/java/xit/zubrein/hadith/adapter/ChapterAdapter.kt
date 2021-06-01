package xit.zubrein.hadith.adapter

import android.content.Context
import android.text.Html
import xit.zubrein.hadith.R
import xit.zubrein.hadith.base.BaseRecyclerviewAdapter
import xit.zubrein.hadith.databinding.ChapterItemsBinding
import xit.zubrein.hadith.model.ModelChapter

class ChapterAdapter(private val context:Context) : BaseRecyclerviewAdapter<ModelChapter.Data,ChapterItemsBinding>(){

    override fun getLayout() = R.layout.chapter_items

    override fun onBindViewHolder(holder: Companion.BaseViewHolder<ChapterItemsBinding>, position: Int) {
        holder.binding.apply {
            val item = items[position]
            nameEng = item.book.get(0).name!!
            nameAr = Html.fromHtml(item.book.get(1).name!!).toString()
        }
    }

}