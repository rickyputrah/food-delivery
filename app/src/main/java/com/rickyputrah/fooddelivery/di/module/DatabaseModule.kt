package com.rickyputrah.fooddelivery.di.module

import android.content.Context
import androidx.room.Room
import com.rickyputrah.fooddelivery.BuildConfig
import com.rickyputrah.fooddelivery.data.database.FoodDeliveryDatabase
import com.rickyputrah.fooddelivery.data.repository.cart.CartDao
import dagger.Module
import dagger.Provides
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory

@Module
open class DatabaseModule {

    @Provides
    open fun provideDatabase(context: Context): FoodDeliveryDatabase {
        val builder = Room.databaseBuilder(
            context,
            FoodDeliveryDatabase::class.java,
            "foodDeliveryDatabase"
        )
        val factory =
            SupportFactory(SQLiteDatabase.getBytes(BuildConfig.DATABASE_PASS_PHRASE.toCharArray()))
        builder.openHelperFactory(factory)
        return builder.build()
    }

    @Provides
    open fun provideCartDao(database: FoodDeliveryDatabase): CartDao {
        return database.cartDao()
    }
}