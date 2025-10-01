package com.wil.dealarticleskmp.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.wil.dealarticleskmp.articles.ArticlesDb

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver = AndroidSqliteDriver(
        schema = ArticlesDb.Schema,
        context = context,
        name = "articles.db",
    )
}