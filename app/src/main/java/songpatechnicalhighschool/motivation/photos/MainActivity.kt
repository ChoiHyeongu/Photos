package songpatechnicalhighschool.motivation.photos

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.Transformation
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_searcbar.*
import kotlinx.android.synthetic.main.horizontal_thumbnail.*
import kotlinx.android.synthetic.main.square_thumbnail.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var galleryAdapter: GalleryAdapter
    private var imageList = ArrayList<Image>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            main_gallery.isNestedScrollingEnabled = true
        }

        val image = BitmapFactory.decodeResource(resources, R.mipmap.sample)
        //val imageHelper = ImageHelper()
        //imageHelper.getRoundedCornerBitmap(image, 6)

        for (i in 1..100) {
            imageList.add(Image(20190306, image, "place"))
        }
        galleryAdapter = GalleryAdapter(imageList, this)
        main_gallery.adapter = galleryAdapter

        setImageRoundCorner(image)
    }

    fun setImageRoundCorner(bitmapImg: Bitmap) {
        Glide.with(this)
                .load(bitmapImg)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(10)))
                .into(thum_horizontal)

        Glide.with(this)
                .load(bitmapImg)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(10)))
                .into(thum_square_image)
    }
}
