package com.sf.dcd.compose.core.util

interface Mapper<in T, out O> {
    fun map(input: T): O
}