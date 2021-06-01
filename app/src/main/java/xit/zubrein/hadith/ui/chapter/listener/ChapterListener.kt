package xit.zubrein.hadith.ui.chapter.listener

import androidx.lifecycle.LiveData
import xit.zubrein.hadith.Utils.cacheutils.Resource
import xit.zubrein.hadith.model.ModelChapter
import xit.zubrein.hadith.model.ModelCollections

interface ChapterListener {

    fun chapterOnStart()

    fun chapterOnReceived(chapters : LiveData<Resource<ModelChapter>>)

    fun chapterDidFailed(message : String)

}