package xit.zubrein.hadith.ui.singlehadith

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import xit.zubrein.hadith.R
import xit.zubrein.hadith.Utils.cacheutils.Resource
import xit.zubrein.hadith.Utils.toast
import xit.zubrein.hadith.base.BaseFragment
import xit.zubrein.hadith.databinding.FragmentSingleHadithBinding
import xit.zubrein.hadith.model.SingleHadith
import xit.zubrein.hadith.ui.singlehadith.listener.SingleHadithListener


class SingleHadithFragment : BaseFragment<FragmentSingleHadithBinding, SingleHadithViewModel>(),
    SingleHadithListener {

    private val args: SingleHadithFragmentArgs by navArgs()

    override fun getLayout() = R.layout.fragment_single_hadith

    override fun getViewModel() = SingleHadithViewModel::class.java

    override fun onViewReady() {
        viewModel.listener = this
        viewModel.getHadith(args.collectionName,args.hadithNumber)
    }

    override fun OnStart() {

    }

    override fun onReceived(hadith: LiveData<Resource<SingleHadith>>) {
        hadith.observe(this, Observer {
            val data = it.data
            if(data != null) {
                binding.hadithAr = Html.fromHtml(data.hadith.get(1).body).toString()
                binding.hadithEn = Html.fromHtml(data.hadith.get(0).body).toString()
            }
        })
    }

    override fun failed(message: String) {
        toast(message)
    }


}