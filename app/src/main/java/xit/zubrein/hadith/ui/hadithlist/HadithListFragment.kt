package xit.zubrein.hadith.ui.hadithlist

import android.util.Log
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import xit.zubrein.hadith.R
import xit.zubrein.hadith.Utils.cacheutils.Resource
import xit.zubrein.hadith.Utils.toast
import xit.zubrein.hadith.adapter.ChapterAdapter
import xit.zubrein.hadith.adapter.HadithAdapter
import xit.zubrein.hadith.base.BaseFragment
import xit.zubrein.hadith.databinding.FragmentHadithListBinding
import xit.zubrein.hadith.model.ModelHadith
import xit.zubrein.hadith.ui.hadithlist.listener.HadithListListener


class HadithListFragment : BaseFragment<FragmentHadithListBinding,HadithListViewModel>(),HadithListListener{

    private val args:HadithListFragmentArgs by navArgs()

    private val hadithAdapter by lazy { HadithAdapter(requireContext()) }

    override fun getLayout() = R.layout.fragment_hadith_list

    override fun getViewModel() = HadithListViewModel::class.java

    override fun onViewReady() {
        binding.hadithRV.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = hadithAdapter
        }
        viewModel.listListener = this
        viewModel.getHadithList(args.collectionName,args.bookNumber)
    }

    override fun HadithListOnStart() {
    }

    override fun HadithListOnReceived(list: LiveData<Resource<ModelHadith>>) {
        list.observe(this, Observer { result ->
            Log.d(TAG, "hadithListOnReceived: ${result.data?.data?.size}")

            binding.progressBar.isInvisible = result is Resource.Error && result.data?.data.isNullOrEmpty()
            binding.errorMessage.isVisible = result is Resource.Error && result.data?.data.isNullOrEmpty()
            binding.errorMessage.text = result.error?.localizedMessage

            val hadithList = result.data?.data
            if (hadithList != null) {
                hadithAdapter.addItems(hadithList)
                binding.progressBar.visibility = View.GONE
            }
        })
    }

    override fun HadithListDidFailed(message: String) {
        toast(message)
    }

}