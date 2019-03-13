package songpatechnicalhighschool.motivation.photos

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.horizontal_thumbnail.*
import kotlinx.android.synthetic.main.row_memorial_gallery.*
import kotlinx.android.synthetic.main.view_memorial.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainGalleryAdapter: GalleryAdapter
    private lateinit var memorialGalleryAdapter: GalleryAdapter
    private var mainImageList = ArrayList<Image>()
    private var memorialImageList = ArrayList<Image>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            main_album.isNestedScrollingEnabled = true
        }

        initGalleries()
    }

    fun setImageRoundCorner(bitmapImg: Bitmap) {

        val squareImageView = findViewById<ImageView>(R.id.thum_square_image)

//        Glide.with(this)
//                .load(bitmapImg)
//                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(10)))
//                .into(thum_horizontal)

        Glide.with(this)
                .load(bitmapImg)
                .apply(RequestOptions().transform(CenterCrop(), RoundedCorners(10)))
                .into(squareImageView)
    }

    fun initGalleries(){
        initMainImageList()
        initMemorialImageList()
    }

    fun initMainImageList(){

        val image = BitmapFactory.decodeResource(resources, R.mipmap.sample)

        for (i in 1..50) {
            mainImageList.add(Image(20190306, image, "place"))
        }
        mainGalleryAdapter = GalleryAdapter(mainImageList, this, 0)
        main_album.adapter = mainGalleryAdapter
    }

    fun initMemorialImageList(){

        val image = BitmapFactory.decodeResource(resources, R.mipmap.sample)
        //setImageRoundCorner(image)

        for (i in 1..30) {
            memorialImageList.add(Image(20190306, image, "place"))
        }

        memorialGalleryAdapter = GalleryAdapter(memorialImageList, this, 1)
        memorial_album.adapter = memorialGalleryAdapter
    }
}
