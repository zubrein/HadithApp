package xit.zubrein.hadith.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import xit.zubrein.hadith.Utils.LoadingBar
import javax.inject.Inject


abstract class BaseActivity <T : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var binding: T


    @Inject
    lateinit var loadingBar: LoadingBar

    protected val TAG: String  by lazy {
        this.javaClass.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,getView())
        onViewReady(savedInstanceState, intent)

    }

    abstract fun getView() : Int
    abstract fun onViewReady(savedInstanceState: Bundle?, intent: Intent)


}