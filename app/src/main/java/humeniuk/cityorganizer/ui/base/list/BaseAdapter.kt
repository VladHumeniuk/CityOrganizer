package humeniuk.cityorganizer.ui.base.list

import android.content.Context
import android.support.annotation.LayoutRes
import android.view.ViewGroup
import android.view.LayoutInflater
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseAdapter<E>(context: Context) : RecyclerView.Adapter<BaseViewHolder<E>>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    private var entities: List<E> = ArrayList()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<E> {
        val itemView = inflater.inflate(getItemLayout(viewType), parent, false)

        return createViewHolder(itemView, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<E>, position: Int) {
        holder.bind(entities[position])
    }

    override fun getItemCount(): Int {
        return entities.size
    }

    fun setData(data: List<E>) {
        entities = data
        notifyDataSetChanged()
    }

    @LayoutRes
    protected abstract fun getItemLayout(viewType: Int): Int

    protected abstract fun createViewHolder(itemView: View, viewType: Int): BaseViewHolder<E>
}