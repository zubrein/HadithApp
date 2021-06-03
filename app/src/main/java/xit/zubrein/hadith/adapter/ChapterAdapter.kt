package xit.zubrein.hadith.adapter

import android.content.Context
import android.text.Html
import androidx.navigation.Navigation
import xit.zubrein.hadith.R
import xit.zubrein.hadith.base.BaseRecyclerviewAdapter
import xit.zubrein.hadith.databinding.ChapterItemsBinding
import xit.zubrein.hadith.model.Chapter
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.ui.chapter.ChapterFragmentDirections
import xit.zubrein.hadith.ui.collection.CollectionFragmentDirections

class ChapterAdapter(private val context:Context,private val ref : String) : BaseRecyclerviewAdapter<Chapter,ChapterItemsBinding>(){

    override fun getLayout() = R.layout.chapter_items

    override fun onBindViewHolder(holder: Companion.BaseViewHolder<ChapterItemsBinding>, position: Int) {
        holder.binding.apply {
            val item = items[position]
            nameEng = item.book.get(0).name!!
            nameAr = Html.fromHtml(item.book.get(1).name!!).toString()
            parent.setOnClickListener {
                val action =  ChapterFragmentDirections.actionChapterFragmentToHadithListFragment(ref,item.bookNumber)
                Navigation.findNavController(parent).navigate(action)
            }
        }
    }

}