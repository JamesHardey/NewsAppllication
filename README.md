# NY Times News App

This is an Android app that uses the New York Times API to display news articles. The app uses Retrofit to fetch data from the API, ViewModel to manage data, and SwipeRefreshLayout to enable users to refresh the content.



## Features

- Fetches the latest news articles from the New York Times API
- Displays a list of news articles with headlines, images, and publish dates
- Allows users to pull down the list to refresh the content
- Tapping on a news article opens a detailed view of the article with a title, image, description, and link to the full article on the New York Times website


## Installation
To install the app, simply download the APK file from the [release page](https://google.com) and install it on your Android device.

## Usage

1. Launch the app on your Android device.
The app will automatically fetch the latest news articles from the New York Times API and display them in a list.
Pull down the list to refresh the content.
Tap on a news article to view its details.
To return to the list view, use the back button on your device.


## Configuration

To configure the app, you will need to obtain an API key from the New York Times API website. Once you have an API key, open the ApiService interface and replace the value of the API_KEY variable with your own API key.

`````
public interface ApiService {

    // ...

    String API_KEY = "your-api-key-here";

    // ...

}
`````


## Dependencies

The app uses the following dependencies:

- Retrofit for networking
- Glide for image loading and caching
- ViewModel for managing data
- SwipeRefreshLayout for enabling pull-to-refresh functionality


## Contributing

If you have any suggestions or would like to contribute to the project, feel free to open an issue or pull request on the [GitHub repository](https://github.com/JamesHardey/NewsAppllication).




