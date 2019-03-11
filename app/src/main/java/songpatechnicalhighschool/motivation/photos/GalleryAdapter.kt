package songpatechnicalhighschool.motivation.photos

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_gallery.view.*
import java.util.*
import android.R.attr.radius
import com.bumptech.glide.request.RequestOptions.bitmapTransform



class GalleryAdapter : BaseAdapter {

    var imageList = ArrayList<Image>()
    var context: Context? = null

    constructor(imageList: ArrayList<Image>, context: Context?) : super() {
        this.imageList = imageList
        this.context = context
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val image = this.imageList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var galleryCell = inflator.inflate(R.layout.row_gallery, null)
        galleryCell.imageView.setImageBitmap(image.image)

        return galleryCell
    }

    override fun getItem(position: Int): Any {
        return imageList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return imageList.size
    }

    fun getImageInfo() {

    }
}