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

TODOs:
* [Add retrofit and Moshi to gradle resources](https://github.com/semanticer/geekyeduCryptoTracker/blob/d47f96e76e70fce7458552f09cce3dce629a464e/app/build.gradle#L56)
* [Create retrofit service for ticker method](https://github.com/semanticer/geekyeduCryptoTracker/blob/step-2/app/src/main/java/cz/geekyedu/geekyedu/data/remote/CryptoService.kt)
* [Use CryptoService instance to load crypto currencies and send the first one to bindTo method](https://github.com/semanticer/geekyeduCryptoTracker/blob/d47f96e76e70fce7458552f09cce3dce629a464e/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainActivity.kt#L24)

Resources:
* [Retrofit - type-safe HTTP client](http://square.github.io/retrofit/)
* [Moshi - JSON parsing library](https://github.com/square/moshi)

## Step - 3
We don't want to check just one crypto currency, we want more! And for that purpose we need to learn
how to display data in a list(RecyclerView).

TODOs:
* [Implement Adapter and ViewHolder](https://github.com/semanticer/geekyeduCryptoTracker/blob/step-3/app/src/main/java/cz/geekyedu/geekyedu/presentation/CryptoAdapter.kt)
* [create and setup all the cryptoAdapter & recyclerView stuff](https://github.com/semanticer/geekyeduCryptoTracker/blob/73fd31725e798a8b84488ebec9da0268f38f8fa6/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainActivity.kt#L25)
* [Update cryptoAdapter with the new data](https://github.com/semanticer/geekyeduCryptoTracker/blob/73fd31725e798a8b84488ebec9da0268f38f8fa6/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainActivity.kt#L36)
* [Move binding logic](https://github.com/semanticer/geekyeduCryptoTracker/blob/73fd31725e798a8b84488ebec9da0268f38f8fa6/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainActivity.kt#L44)
* [Add recyclerView to activity_main layout and extract crypto currency item view](https://github.com/semanticer/geekyeduCryptoTracker/blob/step-3/app/src/main/res/layout/activity_main.xml)

Resources:
* [Create a List with RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview.html)
* [ListAdapter better subclass of RecyclerView.Adapter](https://developer.android.com/reference/android/support/v7/recyclerview/extensions/ListAdapter.html)

## Step - 4
Now rotate the app and check how it loads up the data wastefully again. Our activity dies during configuration change
so we need to find a safe space to survive and we can also learn how to correctly architecture the app
along the way.

TODOs:
* [Extract logic from Activity to ViewModel](https://github.com/semanticer/geekyeduCryptoTracker/blob/step-4/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainActivity.kt)

Resources:
* [Activity Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle.html)
* [About configuration change problem, and basic ways to handle it](https://developer.android.com/guide/topics/resources/runtime-changes.html)
* [Guide to App Architecture](https://developer.android.com/topic/libraries/architecture/guide.html)
* [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel.html)
* [LiveData](https://developer.android.com/topic/libraries/architecture/livedata.html)

## Step - 5
This step is basically a UI preparation for the next one, the grand finale. We provide click listeners
for our RecyclerView items, and show edit dialogs for future values to be edited!

TODOs:
* [Add click listener property to adapter](https://github.com/semanticer/geekyeduCryptoTracker/blob/f3e95a4488753ea0132589575092824a71618f36/app/src/main/java/cz/geekyedu/geekyedu/presentation/CryptoAdapter.kt#L19)
* [Use that listener on holder's containerView](https://github.com/semanticer/geekyeduCryptoTracker/blob/f3e95a4488753ea0132589575092824a71618f36/app/src/main/java/cz/geekyedu/geekyedu/presentation/CryptoAdapter.kt#L29)
* [Set item listener from activity and observe edit dialog observable](https://github.com/semanticer/geekyeduCryptoTracker/blob/ac1cb9390b67551c494a364f011efdc0cd11d162/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainActivity.kt#L38)
* [Build input dialog](https://github.com/semanticer/geekyeduCryptoTracker/blob/ac1cb9390b67551c494a364f011efdc0cd11d162/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainActivity.kt#L50)
* [Add edit dialog LiveData](https://github.com/semanticer/geekyeduCryptoTracker/blob/ac1cb9390b67551c494a364f011efdc0cd11d162/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainViewModel.kt#L18)
* [Change dialog live data to provide this selected Crypto currency](https://github.com/semanticer/geekyeduCryptoTracker/blob/ac1cb9390b67551c494a364f011efdc0cd11d162/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainViewModel.kt#L22)
* [Add dialog related strings](https://github.com/semanticer/geekyeduCryptoTracker/blob/ac1cb9390b67551c494a364f011efdc0cd11d162/app/src/main/res/values/strings.xml#L6)

Resources:
* [Material dialogs](https://github.com/afollestad/material-dialogs)

## Step - 6
Finnaly, we are ready to save our crypto currency values and see how rich we are. But first we
need to find some Room for our data.

TODOs:
* [Implement CryptoCurrencyAmount Entity](https://github.com/semanticer/geekyeduCryptoTracker/blob/step-6/app/src/main/java/cz/geekyedu/geekyedu/data/db/CryptoCurrencyAmount.kt)
* [Declare query and insert functions in Dao interface](https://github.com/semanticer/geekyeduCryptoTracker/blob/step-6/app/src/main/java/cz/geekyedu/geekyedu/data/db/CryptoCurrencyDao.kt)
* [Observe total sum](https://github.com/semanticer/geekyeduCryptoTracker/blob/5b33a27a45785c4540443e88e8ca6dfb8ead30df/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainActivity.kt#L51)
* [Insert data to the database using CryptoCurrencyDao](https://github.com/semanticer/geekyeduCryptoTracker/blob/5b33a27a45785c4540443e88e8ca6dfb8ead30df/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainViewModel.kt#L28)
* [Use zipLiveData to merge info from locally saved values (using CryptoCurrencyDao) with current prices from the server and compute total value of the portfolio](https://github.com/semanticer/geekyeduCryptoTracker/blob/5b33a27a45785c4540443e88e8ca6dfb8ead30df/app/src/main/java/cz/geekyedu/geekyedu/presentation/MainViewModel.kt#L49)
* [Refactor to add total sum layout (maybe in CardView container) right above the RecyclerView, you may need to add new root layout](https://github.com/semanticer/geekyeduCryptoTracker/blob/step-6/app/src/main/res/layout/activity_main.xml)
* BONUS: Show previous value(if there is some) in edit crypto amount dialog
* BONUS: Show different amounts for every saved crypto amounts
* BONUS: Use [MPAndroidChart library](https://github.com/PhilJay/MPAndroidChart) to show charts
* BONUS: Currency settings

Resources:
* [Room - SQL persistence library](https://developer.android.com/training/data-storage/room/index.html)
* [Map function](http://rxmarbles.com/#map)
* [Zip function](http://rxmarbles.com/#zip)

