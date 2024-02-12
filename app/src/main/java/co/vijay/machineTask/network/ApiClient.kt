package co.vijay.machineTask.network

import co.vijay.machineTask.network.data.ResponseModel
import retrofit2.Response
import retrofit2.http.POST

interface ApiClient {

    @POST("v3/12d83631-fb1b-4e82-8171-ed568949f158")
    suspend fun getData(): Response<ResponseModel>

}