package co.vijay.machineTask.repo

import co.vijay.machineTask.base.BaseRepo
import javax.inject.Inject

class AppRepo @Inject constructor() : BaseRepo() {

    suspend fun getData() = makeApiCall {
        it.getData()
    }
}