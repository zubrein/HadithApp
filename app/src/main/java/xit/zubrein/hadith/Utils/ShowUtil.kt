package xit.zubrein.hadith.Utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import xit.zubrein.hadith.R

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
fun Fragment.toast(message: String) {
    requireContext().toast(message)
}

@BindingAdapter("loadImage")
fun loadImage(view:ImageView,url:String){
    Glide.with(view.context)
        .load(url)
        .placeholder(R.mipmap.ic_launcher) // change this
        .into(view)

}