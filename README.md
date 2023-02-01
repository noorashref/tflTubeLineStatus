# tflTubeLineStatus

App Shows the TFL Tube line status

The Android project uses Kotlin Flow and Coroutines for managing asynchronous data streams and performing background operations, 
Jetpack Compose for building UI, MVVM Clean Code Architecture for separating UI logic from business logic, Navigation Component for managing 
navigation between screens, Material Component for following material design guidelines, Retrofit for making network requests, 
Hilt Dagger for dependency injection, and Junit for writing unit tests.

# Technologies 
JetPack Compose
Hilt Dagger (Dependency Injection)
Material Design
MVVM Clean Code Architecture
Coroutines
Kotlin Flow
JUnit 

<img src="https://user-images.githubusercontent.com/49866308/216130432-2dd2dac1-2551-49b1-8e3c-0bedce91d702.png" width="350" height="680">


# Architecture
A well planned architecture is extremely important for an app to scale and all architectures have one common goal- to manage complexity of your app. This isn't something to be worried about in smaller apps however it may prove very useful when working on apps with longer development lifecycle and a bigger team.

# Why Clean Architecture?
Loose coupling between the code - The code can easily be modified without affecting any or a large part of the app's codebase thus easier to scale the application later on. Easier to test code. Separation of Concern - Different modules have specific responsibilities making it easier for modification and maintenance.

Android Clean Architecture in this app is a sample project that presents modern, approach to Android application development using Kotlin and latest tech-stack.

The goal of the this project is to demonstrate best practices, provide a set of guidelines, and present modern Android application architecture that is modular, scalable, maintainable and testable. This application may look simple, but it has all of these small details that will set the rock-solid foundation of the larger app suitable for bigger teams and long application lifecycle management.

# Tech Stacks
This project uses many of the popular libraries, plugins and tools of the android ecosystem.

# Compose

Material - Build Jetpack Compose UIs with ready to use Material Design Components.
Foundation - Write Jetpack Compose applications with ready to use building blocks and extend foundation to build your own design system pieces.
UI - Fundamental components of compose UI needed to interact with the device, including layout, drawing, and input.
Lifecycle-ViewModel - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
Navigation - Navigation in compose 
Jetpack

Android KTX - Provide concise, idiomatic Kotlin to Jetpack and Android platform APIs.
AndroidX - Major improvement to the original Android Support Library, which is no longer maintained.
Lifecycle - Perform actions in response to a change in the lifecycle status of another component, such as activities and fragments.
ViewModel - Designed to store and manage UI-related data in a lifecycle conscious way. The ViewModel class allows data to survive configuration changes such as screen rotations
# Dagger Hilt - Dependency Injection library.

#Google-KSP - Kotlin Symbol Processing API

#Retrofit - Type-safe http client and supports coroutines out of the box.

#OkHttp-Logging-Interceptor - Logs HTTP request and response data.

#Coroutines - Library Support for coroutines.

#Flow - Flows are built on top of coroutines and can provide multiple values. A flow is conceptually a stream of data that can be computed asynchronously.

#Material Design - Build awesome beautiful UIs.

Coroutines - Library Support for coroutines,provides runBlocking coroutine builder used in tests.

# Test

Mockk - A modern Mockk library for UnitTest.
Coroutine-Test - Provides testing utilities for effectively testing coroutines.

