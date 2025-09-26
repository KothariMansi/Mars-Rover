package com.kotharimansi.marsrover.di

import com.kotharimansi.marsrover.service.MarsRoverManifestService
import com.kotharimansi.marsrover.service.MarsRoverPhotoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideMarsHoverManifestService(): MarsRoverManifestService =
        MarsRoverManifestService.create()

    @Provides
    fun provideMarsRoverPhotoService(): MarsRoverPhotoService =
        MarsRoverPhotoService.create()

}