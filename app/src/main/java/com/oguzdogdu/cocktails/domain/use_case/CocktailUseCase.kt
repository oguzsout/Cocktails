package com.oguzdogdu.cocktails.domain.use_case

import android.util.Log
import com.oguzdogdu.cocktails.data.model.toDomainCocktail
import com.oguzdogdu.cocktails.domain.model.Cocktails
import com.oguzdogdu.cocktails.domain.repository.CocktailsRepoInterface
import com.oguzdogdu.cocktails.util.Resource
import com.oguzdogdu.cocktails.util.TAG
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CocktailUseCase @Inject constructor(private val repository: CocktailsRepoInterface) {
    operator fun invoke(cocktailName: String): Flow<Resource<List<Cocktails>>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getCocktailByName(cocktailName)
            Log.d(TAG, "invoke: $response")
            emit(Resource.Success(data = response.drink.toDomainCocktail()))
        } catch (e: HttpException) {
            e.printStackTrace()
            emit(
                Resource.Error(
                    message = e.localizedMessage ?: "An unexpected error occured"
                )
            )
        } catch (e: IOException) {
            e.printStackTrace()
            emit(Resource.Error(message = "Check your Internet Connection"))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error(message = "Check your Internet Connection"))
        }
    }
}