package songpatechnicalhighschool.motivation.photos

import android.graphics.Bitmap

class Image{

    var date: Int? = null
    var image: Bitmap
    var place: String = ""

    constructor(date: Int?, image: Bitmap, place: String) {
        this.date = date
        this.image = image
        this.place = place
    }
}