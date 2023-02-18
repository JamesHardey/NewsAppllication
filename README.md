# NY Times News App

This is an Android app that uses the New York Times API to display news articles. The app uses Retrofit to fetch data from the API, ViewModel to manage data, and SwipeRefreshLayout to enable users to refresh the content.


## Screenshots
<p float="left">
<img src="https://user-images.githubusercontent.com/60360836/219853252-9a4f7f06-3cd9-46d4-964d-a329ab4eb0c3.png" width="150px"/>
<img src="https://user-images.githubusercontent.com/60360836/219853257-ce45b5aa-85c9-4472-8b1f-4e62228ef8d7.png" width="150px"/>
<img src="https://user-images.githubusercontent.com/60360836/219853259-b9c9caa9-be81-4272-a7dc-713185220541.png" width="150px"/>
<img src="https://user-images.githubusercontent.com/60360836/219853261-1601c734-d0bc-42bf-bec8-c9211f671043.png" width="150px"/>
</p>

<div></div>
    
<p float="left">
<img src="https://user-images.githubusercontent.com/60360836/219853262-93036fbe-6aa3-473f-9441-ab0f331b3073.png" width="150px"/>
<img src="https://user-images.githubusercontent.com/60360836/219853264-90f776f6-dc39-4ed3-bdbf-4bca4628f8b8.png" width="150px"/>
<img src="https://user-images.githubusercontent.com/60360836/219853267-274f618d-d73b-4a00-98fa-8f723f44fc4b.png" width="150px"/>
<img src="https://user-images.githubusercontent.com/60360836/219853269-4657d93a-7b7e-4ded-b7fb-1c128a1611db.png" width="150px"/>
</p>

## App Testing

You can test this application using an online emulator [Appetize](https://appetize.io/app/xxnvv2urjrlwdud55y63vxssia)

## Features

- Fetches the latest news articles from the New York Times API
- Displays a list of news articles with headlines, images, and publish dates
- Allows users to pull down the list to refresh the content
- Tapping on a news article opens a detailed view of the article with a title, image, description, and link to the full article on the New York Times website


## Installation
To install the app, simply download the APK file from the [release page](https://github.com/JamesHardey/NewsAppllication) and install it on your Android device.

## Usage

1. Launch the app on your Android device.
2. The app will automatically fetch the latest news articles from the New York Times API and display them in a list.
3. Pull down the list to refresh the content.
4. Tap on a news article to view its details.
5. To return to the list view, use the back button on your device.


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
- Navigation Component
- SwipeRefreshLayout for enabling pull-to-refresh functionality


## Contributing

If you have any suggestions or would like to contribute to the project, feel free to open an issue or pull request on the [GitHub repository](https://github.com/JamesHardey/NewsAppllication/issues).




