package humeniuk.cityorganizer.ui.base

import android.content.Intent
import android.support.v4.app.FragmentManager

abstract class BaseRouter( private val activityContext: BaseActivity, private val containerId: Int) {

    protected fun showFragment(fragment: BaseFragment, addToBackStack: Boolean) {
        val transaction = getFragmentManager().beginTransaction()
        transaction.replace(containerId, fragment)
        if (addToBackStack) {
            transaction.addToBackStack(fragment.javaClass.name)
        }
        transaction.commit()
    }

    protected fun clearBackStack() {
        getFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    protected fun startActivity(intent: Intent) {
        activityContext.startActivity(intent)
    }

    protected fun startActivityForResult(intent: Intent, requestCode: Int) {
        activityContext.startActivityForResult(intent, requestCode)
    }

    protected fun getActivityContext(): BaseActivity {
        return activityContext
    }

    protected fun getFragmentManager(): FragmentManager {
        return activityContext.getSupportFragmentManager()
    }

    protected fun getContainerId(): Int {
        return containerId
    }
}