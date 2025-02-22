package scisrc.mobiledev.ecommercelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import scisrc.mobiledev.ecommercelayout.ui.Item

class ProductAdapter(private val items: List<Item>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.product_name)
        val priceTextView: TextView = itemView.findViewById(R.id.product_price)
        val itemImageView: ImageView = itemView.findViewById(R.id.product_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.priceTextView.text = "฿${item.price}"
        Glide.with(holder.itemView.context).load(item.imageUrl).into(holder.itemImageView)
    }

    override fun getItemCount() = items.size
}