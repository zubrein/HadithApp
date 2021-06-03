package xit.zubrein.hadith.ui.chapter

import android.util.Log
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import xit.zubrein.hadith.R
import xit.zubrein.hadith.Utils.cacheutils.Resource
import xit.zubrein.hadith.adapter.ChapterAdapter
import xit.zubrein.hadith.base.BaseFragment
import xit.zubrein.hadith.databinding.FragmentChapterBinding
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.ui.chapter.listener.ChapterListener

class ChapterFragment : BaseFragment<FragmentChapterBinding, ChapterViewModel>(), ChapterListener {

    private val args: ChapterFragmentArgs by navArgs()

    private val chapterAdapter by lazy { ChapterAdapter(requireContext(),args.collectionName) }

    override fun getLayout() = R.layout.fragment_chapter

    override fun getViewModel() = ChapterViewModel::class.java

    override fun onViewReady() {
        binding.chapterRV.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = chapterAdapter
        }
        viewModel.chapterListener = this
        viewModel.getChapters(args.collectionName)
    }

    override fun chapterOnStart() {

    }

    override fun chapterOnReceived(chapters: LiveData<Resource<ModelChapter>>) {
        chapters.observe(this, Observer { result ->
            Log.d(TAG, "chapterOnReceived: ${result.data?.data?.size}")

            binding.errorMessage.isVisible = result is Resource.Error && result.data?.data.isNullOrEmpty()
            binding.progressBar.isInvisible = result is Resource.Error && result.data?.data.isNullOrEmpty()
            binding.errorMessage.text = result.error?.localizedMessage

            val chapterList = result.data?.data
            if (chapterList != null) {
                chapterAdapter.addItems(chapterList)
                binding.progressBar.visibility = View.GONE
            }

        })
    }

    override fun chapterDidFailed(message: String) {
        Log.d(TAG, "chapterDidFailed: $message")
    }

}