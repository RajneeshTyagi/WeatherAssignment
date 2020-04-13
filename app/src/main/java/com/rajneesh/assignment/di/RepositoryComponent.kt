package com.rajneesh.assignment.di


import com.rajneesh.assignment.viewModel.WhetherViewModel
import dagger.Component

@Component(modules = [RepositoryModule::class])
interface RepositoryComponent {
    fun inject(mWhetherViewModel: WhetherViewModel)
}