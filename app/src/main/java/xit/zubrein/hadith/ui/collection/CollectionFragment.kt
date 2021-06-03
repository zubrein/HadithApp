package xit.zubrein.hadith.ui.collection

import android.util.Log
import android.view.View
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import xit.zubrein.hadith.R
import xit.zubrein.hadith.Utils.cacheutils.Resource
import xit.zubrein.hadith.adapter.CollectionAdapter
import xit.zubrein.hadith.base.BaseFragment
import xit.zubrein.hadith.databinding.FragmentCollectionBinding
import xit.zubrein.hadith.model.ModelCollections
import xit.zubrein.hadith.ui.collection.listener.CollectionListener

class CollectionFragment : BaseFragment<FragmentCollectionBinding, CollectionViewModel>(),
    CollectionListener {

    private val collectionAdapter by lazy { CollectionAdapter(requireContext()) }

    override fun getLayout() = R.layout.fragment_collection

    override fun getViewModel() = CollectionViewModel::class.java

    override fun onViewReady() {

        binding.collectionRV.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = collectionAdapter
        }

        viewModel.collectionListener = this
        viewModel.getCollections()

    }

    override fun collectionOnStart() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun collectionOnReceived(collections: LiveData<Resource<ModelCollections>>) {
        collections.observe(this, Observer { result ->
            Log.d(TAG, "collectionOnReceived: ${result.data?.data?.size}")

            binding.errorMessage.isVisible = result is Resource.Error && result.data?.data.isNullOrEmpty()
            binding.progressBar.isInvisible = result is Resource.Error && result.data?.data.isNullOrEmpty()
            binding.errorMessage.text = result.error?.localizedMessage

            val collectionList = result.data?.data
            if(collectionList != null) {
                collectionAdapter.addItems(collectionList)
                binding.progressBar.visibility = View.GONE
            }
        })

    }

    override fun collectionDidFailed(message: String) {
        Log.d(TAG, "collectionDidFailed: $message")
        binding.progressBar.visibility = View.GONE
    }

}