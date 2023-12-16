import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

class News(
    //val paragraphs: MutableList<String>,
    @DrawableRes
    val IDImageCV: Int,
    val title: String,
    val text: String,
    val description: String,
    //val IDImages: MutableList<String>,
    //val ImageAfterParagraphs: MutableList<Boolean>
)
