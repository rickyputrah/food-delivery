package com.rickyputrah.fooddelivery.data.repository.banner

import com.rickyputrah.fooddelivery.data.model.BannerResponse
import com.rickyputrah.fooddelivery.data.repository.ResultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeBannerRepository : IBannerRepository {

    override suspend fun getBanner(): ResultRepository<BannerResponse> {
        return withContext(Dispatchers.IO) {
            delay(2000)
            ResultRepository.Success(
                BannerResponse(
                    listOf(
                        "https://b.zmtcdn.com/data/pictures/chains/2/18941862/c4881afca04894507866ad58e346bdef.jpg?output-format=webp",
                        "https://b.zmtcdn.com/data/pictures/chains/5/18530405/60f96a36e1f86f5098316f48d24f3ba1.jpg?output-format=webp",
                        "https://b.zmtcdn.com/data/pictures/chains/9/7400809/cb7dc745c208d923be6f44f40b578354.jpg?output-format=webp",
                        "https://b.zmtcdn.com/data/pictures/6/18875696/c98a7d61c788e8b023f49b6753c10d20.jpg"
                    )
                )
            )
        }
    }
}