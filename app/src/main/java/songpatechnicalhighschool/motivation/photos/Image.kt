package songpatechnicalhighschool.motivation.photos

import android.content.Context
import android.database.Cursor
import android.graphics.Bitmap
import android.provider.MediaStore
import android.provider.MediaStore.MediaColumns
import android.text.TextUtils
import android.util.Log


class Image{

    var date: Int? = null
    lateinit var image: Bitmap
    var place: String = ""

    constructor()

    constructor(date: Int?, image: Bitmap, place: String) {
        this.date = date
        this.image = image
        this.place = place
    }

    fun getAllImages(context: Context): ArrayList<String>{
        val result = arrayListOf<String>()
        val uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.MediaColumns.DATA, MediaStore.MediaColumns.DISPLAY_NAME)

        val cursor: Cursor? = context.contentResolver.query(uri, projection, null, null, MediaColumns.DATE_ADDED + " desc")

        val columnIndex = cursor!!.getColumnIndexOrThrow(MediaColumns.DATA)
        val columnDisplayname= cursor.getColumnIndexOrThrow(MediaColumns.DISPLAY_NAME)

        var lastIndex = 0

        while(cursor.moveToNext()){
            val absolutePathOfImage = cursor.getString(columnIndex)
            val nameofFile = cursor.getString(columnDisplayname)
            lastIndex = absolutePathOfImage.lastIndexOf(nameofFile)
            lastIndex = if(lastIndex >= 0) lastIndex else nameofFile.length - 1

            if(!TextUtils.isEmpty(absolutePathOfImage))
                result.add(absolutePathOfImage)
        }


        for(string in result)
            Log.d("Image | getAllImages", "| ${string} |")

        return result
    }
}