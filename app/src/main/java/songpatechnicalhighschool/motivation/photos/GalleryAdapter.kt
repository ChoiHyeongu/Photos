package songpatechnicalhighschool.motivation.photos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.row_main_gallery.view.*
import kotlinx.android.synthetic.main.row_memorial_gallery.view.*
import java.util.*


class GalleryAdapter : BaseAdapter {

    var imageList = ArrayList<Image>()
    var context: Context? = null
    var opt: Int = 0

    constructor(imageList: ArrayList<Image>, context: Context?, opt: Int) : super() {
        this.imageList = imageList
        this.context = context
        this.opt = opt
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val image = this.imageList[position]

        when (opt) {
            0 -> {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var galleryCell = inflator.inflate(R.layout.row_main_gallery, null)
                galleryCell.imageView.setImageBitmap(image.image)

                return galleryCell
            }
            1 -> {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var galleryCell = inflator.inflate(R.layout.row_memorial_gallery, null)
                galleryCell.thum_square_image.setImageBitmap(image.image)

                return galleryCell
            }

            else -> {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var galleryCell = inflator.inflate(R.layout.row_main_gallery, null)
                galleryCell.imageView.setImageBitmap(image.image)

                return galleryCell
            }
        }
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


}