package humeniuk.cityorganizer.ui.base

import io.reactivex.disposables.Disposable

class RxPresenter {

    private val subscriptions = HashMap<Int, Disposable>()

    protected fun subscribe(id: Int, observable: Disposable) {
        if (subscriptions.containsKey(id)) {
            subscriptions.remove(id)
        }
        subscriptions.put(id, observable)
    }

    protected fun unsubscribe(id: Int) {
        subscriptions.remove(id)
    }
}