package xit.zubrein.hadith.adapter

import android.content.Context
import android.text.Html
import androidx.navigation.Navigation
import xit.zubrein.hadith.R
import xit.zubrein.hadith.base.BaseRecyclerviewAdapter
import xit.zubrein.hadith.databinding.ChapterItemsBinding
import xit.zubrein.hadith.databinding.HadithItemsBinding
import xit.zubrein.hadith.model.Chapter
import xit.zubrein.hadith.model.Content
import xit.zubrein.hadith.model.Hadith
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.ui.chapter.ChapterFragmentDirections
import xit.zubrein.hadith.ui.hadithlist.HadithListFragmentDirections

class HadithAdapter(private val context:Context) : BaseRecyclerviewAdapter<Content,HadithItemsBinding>(){

    override fun getLayout() = R.layout.hadith_items

    override fun onBindViewHolder(holder: Companion.BaseViewHolder<HadithItemsBinding>, position: Int) {
        holder.binding.apply {
            val item = items[position]
            nameEng = item.hadith.get(0).chapterTitle
            nameAr = Html.fromHtml(item.hadith.get(1).chapterTitle).toString()
            grade = item.hadith.get(0).grades.get(0).grade
            parent.setOnClickListener {
                val action =  HadithListFragmentDirections.actionHadithListFragmentToSingleHadithFragment(item.collection,item.hadithNumber.toString())
                Navigation.findNavController(parent).navigate(action)
            }
        }
    }

}