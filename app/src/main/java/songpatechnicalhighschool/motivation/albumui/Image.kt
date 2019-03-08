package songpatechnicalhighschool.motivation.albumui

class Image{

    var date: Int? = null
    var image: Int = 0
    var place: String = ""

    constructor(date: Int?, image: Int, place: String) {
        this.date = date
        this.image = image
        this.place = place
    }
}