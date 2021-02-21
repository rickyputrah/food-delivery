package com.rickyputrah.fooddelivery.data.repository.food

import com.rickyputrah.fooddelivery.data.model.MenuListResponse
import com.rickyputrah.fooddelivery.data.repository.ResultRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class FakeFoodRepository : IFoodRepository {

    override suspend fun getFoodList(): ResultRepository<MenuListResponse> {
        return withContext(Dispatchers.IO) {
            delay(2000)
            ResultRepository.Success(
                MenuListResponse(
                    listOf(
                        MenuListResponse.MenuCollectionResponse(
                            collectionName = "Pizza",
                            menus = listOf(
                                MenuListResponse.Menu(
                                    id = "123",
                                    name = "Lorem Ipsum",
                                    price = 10,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/2/18941862/c4881afca04894507866ad58e346bdef.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "13131",
                                    name = "Lorem Ipsum",
                                    price = 12,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/2/18941862/35725cef00f2958d28fc2f6df305520e.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "3431",
                                    name = "Lorem Ipsum",
                                    price = 132,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/2/18941862/c4881afca04894507866ad58e346bdef.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "5454",
                                    name = "Lorem Ipsum",
                                    price = 412,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/2/18941862/35725cef00f2958d28fc2f6df305520e.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "1235454",
                                    name = "Lorem Ipsum",
                                    price = 10,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/2/18941862/c4881afca04894507866ad58e346bdef.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "13131131",
                                    name = "Lorem Ipsum",
                                    price = 12,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/2/18941862/35725cef00f2958d28fc2f6df305520e.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "1231436",
                                    name = "Lorem Ipsum",
                                    price = 132,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/2/18941862/c4881afca04894507866ad58e346bdef.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "067345",
                                    name = "Lorem Ipsum",
                                    price = 412,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/2/18941862/35725cef00f2958d28fc2f6df305520e.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                )
                            )
                        ),
                        MenuListResponse.MenuCollectionResponse(
                            collectionName = "Sushi",
                            menus = listOf(
                                MenuListResponse.Menu(
                                    id = "123",
                                    name = "Lorem Ipsum",
                                    price = 10,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/5/18530405/60f96a36e1f86f5098316f48d24f3ba1.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "13131",
                                    name = "Lorem Ipsum",
                                    price = 12,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/6/18875696/c98a7d61c788e8b023f49b6753c10d20.jpg",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "3431",
                                    name = "Lorem Ipsum",
                                    price = 132,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/5/18530405/60f96a36e1f86f5098316f48d24f3ba1.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "5454",
                                    name = "Lorem Ipsum",
                                    price = 412,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/6/18875696/c98a7d61c788e8b023f49b6753c10d20.jpg",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "1235454",
                                    name = "Lorem Ipsum",
                                    price = 10,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/6/18875696/c98a7d61c788e8b023f49b6753c10d20.jpg",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "13131131",
                                    name = "Lorem Ipsum",
                                    price = 12,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/5/18530405/60f96a36e1f86f5098316f48d24f3ba1.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                )
                            )
                        ),
                        MenuListResponse.MenuCollectionResponse(
                            collectionName = "Ramen",
                            menus = listOf(
                                MenuListResponse.Menu(
                                    id = "123",
                                    name = "Lorem Ipsum",
                                    price = 10,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/9/7400809/cb7dc745c208d923be6f44f40b578354.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "13131",
                                    name = "Lorem Ipsum",
                                    price = 12,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/9/7400809/de509895b03cc98680f94ad975fa7b21.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "3431",
                                    name = "Lorem Ipsum",
                                    price = 132,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/9/7400809/cb7dc745c208d923be6f44f40b578354.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "5454",
                                    name = "Lorem Ipsum",
                                    price = 412,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/9/7400809/de509895b03cc98680f94ad975fa7b21.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "1235454",
                                    name = "Lorem Ipsum",
                                    price = 10,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/9/7400809/cb7dc745c208d923be6f44f40b578354.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "13131131",
                                    name = "Lorem Ipsum",
                                    price = 12,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/9/7400809/de509895b03cc98680f94ad975fa7b21.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "1231436",
                                    name = "Lorem Ipsum",
                                    price = 132,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/9/7400809/cb7dc745c208d923be6f44f40b578354.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "067345",
                                    name = "Lorem Ipsum",
                                    price = 412,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/9/7400809/cb7dc745c208d923be6f44f40b578354.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                )
                            )
                        ),
                        MenuListResponse.MenuCollectionResponse(
                            collectionName = "Pasta",
                            menus = listOf(
                                MenuListResponse.Menu(
                                    id = "123",
                                    name = "Lorem Ipsum",
                                    price = 10,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/7/7402207/790844f57db82c9cee1c9a8ab26f94e8.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "13131",
                                    name = "Lorem Ipsum",
                                    price = 12,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/reviews_photos/0bd/079bce9d8ecf136d4ff3bfb5e9b6d0bd_1574612355.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "3431",
                                    name = "Lorem Ipsum",
                                    price = 132,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/7/7402207/790844f57db82c9cee1c9a8ab26f94e8.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "5454",
                                    name = "Lorem Ipsum",
                                    price = 412,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/7/7402207/790844f57db82c9cee1c9a8ab26f94e8.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "1235454",
                                    name = "Lorem Ipsum",
                                    price = 10,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/pictures/chains/7/7402207/790844f57db82c9cee1c9a8ab26f94e8.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "13131131",
                                    name = "Lorem Ipsum",
                                    price = 12,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/reviews_photos/0bd/079bce9d8ecf136d4ff3bfb5e9b6d0bd_1574612355.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "1231436",
                                    name = "Lorem Ipsum",
                                    price = 132,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/reviews_photos/0bd/079bce9d8ecf136d4ff3bfb5e9b6d0bd_1574612355.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                ),
                                MenuListResponse.Menu(
                                    id = "067345",
                                    name = "Lorem Ipsum",
                                    price = 412,
                                    portion = "Lorem ipsum dolor sit amet",
                                    imageUrl = "https://b.zmtcdn.com/data/reviews_photos/0bd/079bce9d8ecf136d4ff3bfb5e9b6d0bd_1574612355.jpg?output-format=webp",
                                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
                                )
                            )
                        )
                    )
                )
            )
        }
    }
}