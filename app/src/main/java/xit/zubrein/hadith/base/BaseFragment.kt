package xit.zubrein.hadith.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.Exception

abstract class BaseFragment<T : ViewDataBinding, VM : ViewModel> : Fragment() {

    protected lateinit var binding: T
    protected lateinit var viewModel: VM

    protected val TAG: String by lazy {
        this.javaClass.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            getLayout(),
            container,
            false
        )

        viewModel = activity?.run {
            ViewModelProvider(this)[getViewModel()]
        } ?: throw Exception("Invalid Activity")
        onViewReady()

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }


    abstract fun getLayout(): Int
    abstract fun getViewModel(): Class<VM>
    abstract fun onViewReady()

}