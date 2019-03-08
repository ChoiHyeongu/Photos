package songpatechnicalhighschool.motivation.albumui

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_searcbar.*
import songpatechnicalhighschool.motivation.photos.R

class MainActivity : AppCompatActivity() {

    private lateinit var galleryAdapter: GalleryAdapter
    private var imageList = ArrayList<Image>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            main_gallery.isNestedScrollingEnabled = true
        }

        for(i in 1..100){
            imageList.add(Image(20190306, R.mipmap.sample, "place"))
        }
        galleryAdapter = GalleryAdapter(imageList, this)
        main_gallery.adapter = galleryAdapter
    }
}
