package com.example.excusesapp.di

import com.example.excusesapp.repository.ExcusesRepository
import com.example.excusesapp.repository.ExcusesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideExcusesRepository(excusesRepositoryImpl: ExcusesRepositoryImpl): ExcusesRepository
}