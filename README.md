# Customer List Animation

This project demonstrates a composable function in Jetpack Compose that animates a list of customers within a `LazyColumn`, ensuring headers and other non-list items do not interfere with the animation.

## Overview

The main component of this project is the `CustomerListScreen` composable function. It displays a list of customers with animated list items, using Jetpack Compose's `LazyColumn`. Each item animates its position when it becomes visible.

### Features

- **LazyColumn**: Displays a list of customer items.
- **Animated Items**: Smooth animations for list items when they appear on screen.
- **Header Management**: Ensures headers and other non-list items do not interfere with the animations.
- **Custom Components**: Includes reusable components like `SearchBarComponent`, `FilterItemsBarComponent`, and `ItemCustomerComponent`.
## Implementation Details

### CustomerListScreen Composable

The `CustomerListScreen` composable sets up the screen with a top bar, a search bar, filter options, and an animated list of customers using Jetpack Compose's `LazyColumn`. Each list item animates smoothly as it becomes visible on the screen.

### AnimatedItemListComponent Composable

The `AnimatedItemListComponent` handles the animation logic for each customer item, ensuring smooth transitions based on visibility and scroll position within the list.

### ItemCustomerComponent Composable

The `ItemCustomerComponent` composable displays detailed information about each customer in a structured layout, including an image and personalized details.

### FilterItemsBarComponent Composable

The `FilterItemsBarComponent` provides a horizontal list of filter options for further interaction with the customer list.

This section summarizes how these components work together to create an animated and interactive customer list experience within the application.

## Video and Animated GIF

### Video Demo

[Watch video on Google Drive](https://drive.google.com/file/d/1PK02zdPFqsw3jKSifB7DK3K12qAKX3fJ/view?usp=sharing)

### Animated GIF

![Animated List](https://github.com/MelanieBenavente/Android-Compose-Animated-List/blob/master/AnimatedListCompose-ezgif.com-video-to-gif-converter.gif?raw=true)
