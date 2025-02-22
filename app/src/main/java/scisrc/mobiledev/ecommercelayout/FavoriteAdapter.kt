package scisrc.mobiledev.ecommercelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import scisrc.mobiledev.ecommercelayout.ui.Item

class FavoriteAdapter(private val favoriteItems: List<Item>) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val favoriteItemImageView: ImageView = itemView.findViewById(R.id.favoriteItemImageView)
        val favoriteItemNameTextView: TextView = itemView.findViewById(R.id.favoriteItemNameTextView)
        val favoriteItemPriceTextView: TextView = itemView.findViewById(R.id.favoriteItemPriceTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favoriteItem = favoriteItems[position]
        holder.favoriteItemNameTextView.text = favoriteItem.name
        holder.favoriteItemPriceTextView.text = "฿${favoriteItem.price}"

        val imageResId = holder.favoriteItemImageView.context.resources.getIdentifier(favoriteItem.imageResId, "drawable", holder.favoriteItemImageView.context.packageName)
        if (imageResId != 0) {
            holder.favoriteItemImageView.setImageResource(imageResId)
        }
    }

    override fun getItemCount() = favoriteItems.size
}