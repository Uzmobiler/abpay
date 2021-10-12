package uz.mobiler.data.datasource.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.await
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

object FlowCallAdapterFactory : CallAdapter.Factory() {

    override fun get(
        returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit
    ): CallAdapter<*, *>? {

        if (Flow::class.java != getRawType(returnType)) return null

        check(returnType is ParameterizedType) {
            "Flow return type must be parameterized as Flow <Foo> or Flow <? extends Foo>"
        }

        return object : CallAdapter<Any, Any> {
            override fun adapt(call: Call<Any>): Flow<Any> {
                return flow {
                    try {
                        emit(call.await())
                    } catch (e: KotlinNullPointerException) { // https://github.com/square/retrofit/issues/3075
                        emit(Unit)
                    }
                }
            }

            override fun responseType(): Type = getParameterUpperBound(0, returnType)
        }
    }
}