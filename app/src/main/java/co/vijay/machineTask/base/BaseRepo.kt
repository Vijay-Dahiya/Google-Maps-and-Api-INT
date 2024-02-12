package co.vijay.machineTask.base

import co.vijay.machineTask.network.ApiClient
import co.vijay.machineTask.network.PostmanModule
import retrofit2.Response

abstract class BaseRepo {

    private val apiService by lazy { PostmanModule.getAuthService() }

    suspend fun <T> makeApiCall(
        call: suspend (apiClient: ApiClient) -> Response<T>
    ): Response<T> {
        return call.invoke(apiService)
    }
}