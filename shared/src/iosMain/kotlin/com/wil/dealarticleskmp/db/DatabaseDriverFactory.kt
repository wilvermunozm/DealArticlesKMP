package com.wil.dealarticleskmp.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.wil.dealarticleskmp.articles.ArticlesDb

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver = NativeSqliteDriver(
        schema = ArticlesDb.Schema,
        name = "articles.db",
    )
}