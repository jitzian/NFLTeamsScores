package org.com.raian.code.reachmobi.model.base

import java.util.logging.Logger

abstract class BaseRepository {
    protected lateinit var TAG: String
    protected lateinit var logger: Logger

    abstract fun closeDB()
}