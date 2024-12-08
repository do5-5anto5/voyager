package com.voyager.dependency_injection

import org.koin.dsl.module

val appModules = module {
    includes(
        apiServiceModule
    )
}