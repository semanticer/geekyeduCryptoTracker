# CryptoTracker

This app is meant for education purposes

## Step - 1

In this part, our goal is to edit xml layout and show new pieces of information in it.

TODOs:
* [Add day and week percentage labels and value TextViews](https://github.com/semanticer/geekyeduCryptoTracker/blob/1ef3eb480b8db1a4bf0ffdea3f66581a911eafff/app/src/main/res/layout/activity_main.xml#L79)
* [Add percentChange24h and percentChange7d Doubles to CryptoCurrency data class](https://github.com/semanticer/geekyeduCryptoTracker/blob/1ef3eb480b8db1a4bf0ffdea3f66581a911eafff/app/src/main/java/cz/geekyedu/geekyedu/data/model/CryptoCurrency.kt#L4)
* [Bind dummy data model to views](https://github.com/semanticer/geekyeduCryptoTracker/blob/1ef3eb480b8db1a4bf0ffdea3f66581a911eafff/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainActivity.kt#L27)
* [Uncommend new color resources](https://github.com/semanticer/geekyeduCryptoTracker/blob/step-1/app/src/main/res/values/colors.xml)


Resources:
* [Android Layouts](https://developer.android.com/guide/topics/ui/declaring-layout.html)
* [ConstaintLayout](https://constraintlayout.com/)
* [Glide - The library for displaying network images](https://bumptech.github.io/glide/doc/generatedapi.html#using-the-generated-api)
* [Koltin data classes](https://kotlinlang.org/docs/reference/data-classes.html)
* [Android resources](https://developer.android.com/guide/topics/resources/providing-resources.html)
* [Android colors](https://developer.android.com/reference/android/graphics/Color.html)

## Step - 2

Now we will get rid of all dummy data and load real stuff from the API. We will load and parse JSON
data and display it the same way we did in Step 1.

Resources:
* [Retrofit - type-safe HTTP client](http://square.github.io/retrofit/)
* [Moshi - JSON parsing library](https://github.com/square/moshi)

## Step - 3
We don't want to check just one crypto currency, we want more! And for that purpose we need to learn
how to display data in a list(RecyclerView).

Resources:
* [Create a List with RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview.html)
* [ListAdapter better subclass of RecyclerView.Adapter](https://developer.android.com/reference/android/support/v7/recyclerview/extensions/ListAdapter.html)

## Step - 4
Now rotate the app and check how it loads up the data wastefully again. Our activity dies during configuration change
so we need to find a safe space to survive and we can also learn how to correctly architecture the app
along the way.

Resources:
* [Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle.html)
* [About configuration change problem, and basic ways to handle it](https://developer.android.com/guide/topics/resources/runtime-changes.html)
* [Guide to App Architecture](https://developer.android.com/topic/libraries/architecture/guide.html)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel.html)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html)

## Step - 5
This step is basically a UI preparation for the next one, the grand finale. We provide click listeners
for our RecyclerView items, and show edit dialogs for future values to be edited!

Resources:
* [Material dialogs](https://github.com/afollestad/material-dialogs)

## Step - 6
Finnaly, we are ready to save our crypto currency values and see how rich we are. But first we
need to find some Room for our data.

Resources:
* [Room - SQL persistence library](https://developer.android.com/training/data-storage/room/index.html)
* [Map function](http://rxmarbles.com/#map)
* [Zip function](http://rxmarbles.com/#zip)

