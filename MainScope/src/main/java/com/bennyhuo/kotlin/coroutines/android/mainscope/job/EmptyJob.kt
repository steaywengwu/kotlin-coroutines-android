package com.bennyhuo.kotlin.coroutines.android.mainscope.job

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CompletionHandler
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.selects.SelectClause0
import kotlinx.coroutines.selects.SelectInstance
import kotlin.coroutines.CoroutineContext.Key

internal class EmptyJob : JobCompat(), SelectClause0 {
    override val children: Sequence<Job> = emptySequence()

    override val isActive: Boolean = false

    override val isCancelled: Boolean = false

    override val isCompleted: Boolean = true

    override val key: Key<*> = Job

    override val onJoin: SelectClause0 = this

    @InternalCoroutinesApi
    override fun <R> registerSelectClause0(select: SelectInstance<R>, block: suspend () -> R) = Unit

    override fun cancel(cause: Throwable?) = false

    override fun cancel(cause: CancellationException?) = Unit

    @InternalCoroutinesApi
    override fun getCancellationException(): CancellationException {
        throw IllegalStateException()
    }

    @InternalCoroutinesApi
    override fun invokeOnCompletion(onCancelling: Boolean, invokeImmediately: Boolean, handler: CompletionHandler) = EmptyDisposableHandle

    override fun invokeOnCompletion(handler: CompletionHandler) = EmptyDisposableHandle

    override suspend fun join() = Unit

    override fun start() = false
}