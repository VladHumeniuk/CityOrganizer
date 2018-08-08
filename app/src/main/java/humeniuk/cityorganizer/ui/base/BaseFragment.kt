package humeniuk.cityorganizer.ui.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import butterknife.Unbinder
import android.support.annotation.StringRes
import dagger.android.support.DaggerFragment


abstract class BaseFragment: DaggerFragment() {

    private lateinit var unbinder: Unbinder;

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayoutId(), container, false)
        unbinder = ButterKnife.bind(this, view)
        setupActionBar()
        setHasOptionsMenu(showOptionsMenu());
        initViews()
        return view
    }

    protected fun initViews() {}

    private fun setupActionBar() {
        val actionBar = getBaseActivity().getSupportActionBar() ?: return

        if (getTitle() != 0) {
            actionBar.setTitle(getTitle())
        }
        if (showActionBar()) {
            actionBar.show()
        } else {
            actionBar.hide()
        }
    }

    protected fun showOptionsMenu(): Boolean {
        return false
    }

    @StringRes
    protected fun getTitle(): Int {
        return 0
    }

    protected fun showActionBar(): Boolean {
        return true
    }

    protected fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
    }

    @LayoutRes
    abstract fun getLayoutId(): Int
}