package xit.zubrein.hadith.ui.chapter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import xit.zubrein.hadith.R
import xit.zubrein.hadith.adapter.ChapterAdapter
import xit.zubrein.hadith.base.BaseFragment
import xit.zubrein.hadith.databinding.FragmentChapterBinding
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.ui.chapter.listener.ChapterListener

class ChapterFragment : BaseFragment<FragmentChapterBinding, ChapterViewModel>(),ChapterListener {

    private val args : ChapterFragmentArgs by navArgs()

    private val chapterAdapter by lazy { ChapterAdapter(requireContext()) }

    override fun getLayout() = R.layout.fragment_chapter

    override fun getViewModel() = ChapterViewModel::class.java

    override fun onViewReady() {
        viewModel.chapterListener = this
        viewModel.getChapters(args.collectionName)
    }

    override fun chapterOnStart() {

    }

    override fun chapterOnReceived(chapters: LiveData<ModelChapter>) {
        chapters.observe(this, Observer {
            binding.chapterRV.layoutManager = GridLayoutManager(requireContext(),2)
            binding.chapterRV.adapter = chapterAdapter
            chapterAdapter.addItems(it.data)
        })
    }

    override fun chapterDidFailed(message: String) {
        Log.d(TAG, "chapterDidFailed: $message")
    }

}