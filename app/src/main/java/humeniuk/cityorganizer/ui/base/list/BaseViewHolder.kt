package humeniuk.cityorganizer.ui.base.list

import butterknife.ButterKnife
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View


class BaseViewHolder<E>(itemView: View) : ViewHolder(itemView) {

    protected var entity: E? = null
        private set

    init {
        ButterKnife.bind(this, itemView)
    }

    fun bind(entity: E) {
        this.entity = entity
    }
}