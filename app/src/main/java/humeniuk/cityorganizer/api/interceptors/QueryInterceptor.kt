package humeniuk.cityorganizer.api.interceptors

import humeniuk.cityorganizer.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class QueryInterceptor() : Interceptor {

    private val APP_ID : String = "appid"
    private val UNITS_NAME : String = "units"
    private val UNITS : String = "metric"

    override fun intercept(chain: Interceptor.Chain?): Response {
        var request = chain!!.request()
        val url = request.url().newBuilder()
                .addQueryParameter(UNITS_NAME, UNITS)
                .addQueryParameter(APP_ID, BuildConfig.API_KEY)
                .build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}