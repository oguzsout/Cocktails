package com.oguzdogdu.cocktails.domain.use_case

import com.oguzdogdu.cocktails.data.model.Drink
import com.oguzdogdu.cocktails.data.model.DrinkList
import com.oguzdogdu.cocktails.domain.repository.CocktailsRepoInterface
import com.oguzdogdu.cocktails.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CocktailUseCase @Inject constructor(private val repository: CocktailsRepoInterface) {
    operator fun invoke(): Flow<Resource<List<Drink>>> = flow {
        try {
            emit(Resource.Loading())
            val data = repository.getCocktails()
            val response = data.drinks
            emit(Resource.Success(data = response))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An Unknown error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Check Connectivity"))
        } catch (e: Exception) {

        }
    }
}