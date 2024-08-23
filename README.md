# Protest Tracker App

## Overview
The **Protest Tracker** is an Android app built with **Kotlin**, **Jetpack Compose**, and **Room Database**. The app is designed to help users track protests by pasting Twitter links related to specific protests. It offers a user-friendly interface for managing and viewing protests and their statuses.

## Features
- **Add Protests**: Users can add new protests by entering a protest name, status, and a related Twitter link.
- **View Protest List**: The app displays a list of all tracked protests, each with its name, status, and a clickable Twitter link.
- **Edit and Delete Protests**: Users can edit the details of existing protests or delete them from the list.
- **Search Protests**: Users can search for protests by name to quickly find specific entries.

## Technologies Used
- **Kotlin**: The programming language used to develop the app. [Learn more](https://kotlinlang.org/docs/home.html)
- **Jetpack Compose**: A modern toolkit for building native Android UI. [Learn more](https://developer.android.com/jetpack/compose)
- **Room Database**: A persistence library that provides an abstraction layer over SQLite for local data storage. [Learn more](https://developer.android.com/training/data-storage/room)
- **Android Jetpack**: A suite of libraries to help developers follow best practices and reduce boilerplate code. [Learn more](https://developer.android.com/jetpack)

## App Architecture
The app follows the MVVM (Model-View-ViewModel) architecture pattern, utilizing the following components:
- **ViewModel**: Manages UI-related data in a lifecycle-conscious way.
- **Repository**: Abstracts access to data sources, including the Room database.
- **Room Database**: Stores protest data locally, ensuring persistence.

## Screenshots
![Protest List Screen](https://via.placeholder.com/150)  
*Protest List Screen*

![Add Protest Screen](https://via.placeholder.com/150)  
*Add Protest Screen*

## Installation

### Prerequisites
- Android Studio 4.2 or later
- Kotlin 1.5.0 or later

### Clone the Repository
To get started, clone the repository:

```bash
git clone https://github.com/yourusername/ProtestTracker.git
