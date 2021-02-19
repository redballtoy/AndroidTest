
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.redballtoy.recyclerviewanimate_touristtour.R
import com.example.redballtoy.recyclerviewanimate_touristtour.model.Places
import com.flaviofaria.kenburnsview.KenBurnsView
import com.squareup.picasso.Picasso

class TourAdapter(val context: Context,
                  private val places: ArrayList<Places>)
    : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val tv_image = holder.itemView.findViewById<KenBurnsView>(R.id.kbv_tourImage)
        tv_image.clipToOutline=true
        Picasso.get().load(places[position].url).into(tv_image)

        val tv_title = holder.itemView.findViewById<TextView>(R.id.tv_title)
        val tv_description = holder.itemView.findViewById<TextView>(R.id.tv_description)
        val tv_rating = holder.itemView.findViewById<RatingBar>(R.id.rb_tour_rating)

        //animation kensburn
        tv_image.resume()
        tv_title.text = places[position].title
        tv_description.text = places[position].description
        tv_rating.rating=places[position].rating!!

    }

    override fun getItemCount(): Int {
        return places.size
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {

        }

    }
}