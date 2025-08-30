# Amazon UI Automation with Java & Selenide

This repository contains a set of automated UI tests for the Amazon online store, built with Java, Selenide and TestNG. The project demonstrates best practices for UI automation, including the Page Object Model, reusable components, and stable locators for dynamic content.

## UI Automation Testing Checklist – Amazon.com

| #  | Test Case | Status | Java Test Method                                      |
|----|-----------|--------|-------------------------------------------------------|
| **1. Homepage** ||        |                                                       |
| 1.1 | Logo visibility – Amazon logo is displayed and clickable (redirects to homepage) | [X]    | `testLogoVisibilityAndClick`                          |
| 1.2 | Search bar – Placeholder text correct, accepts input, triggers search | [X]    | `testSearchBarFunctionality`                          |
| 1.3 | Category dropdown – Options present and selectable | [X]    | `testCategoryDropdown`                                |
| 1.4 | Language & region selector – Opens and allows selection | [ ]    | `testLanguageRegionSelector` *(to be implemented)*    |
| 1.5 | Sign-in button – Visible, clickable, redirects to login page | [X]    | `testSignInButton`                                |
| 1.6 | Cart icon – Visible, correct item count | [ ]    | `testCartIcon`  *(to be implemented)*                 |
| **2. Search Results Page** ||        |                                                       |
| 2.1 | Results list loading – Product tiles appear after search | [ ]    | `testSearchResultsLoaded`  *(to be implemented)*  |
| 2.2 | Product title – Visible, clickable, opens detail page | [ ]    | `testProductTitleClickable`   *(to be implemented)*   |
| 2.3 | Price display – Correct format (currency + amount) | [ ]    | `testPriceDisplay`  *(to be implemented)*               |
| 2.4 | Ratings & reviews – Stars and review count visible | [ ]    | `testRatingsAndReviews` *(to be implemented)*         |
| 2.5 | Sorting options – Changes product order | [ ]    | `testSortingOptions` *(to be implemented)*            |
| 2.6 | Pagination – “Next” and page numbers work | [ ]    | `testPagination` *(to be implemented)*                |
| **3. Product Detail Page** ||        |                                                       |
| 3.1 | Image carousel – Loads and navigates | [ ]    | `testImageCarousel`      *(to be implemented)*          |
| 3.2 | Product title – Matches search results | [ ]    | `testProductTitleMatch` *(to be implemented)*         |
| 3.3 | Price & availability – Visible, stock shown | [ ]    | `testPriceAndAvailability` *(to be implemented)*      |
| 3.4 | Add to Cart button – Clickable, adds item | [ ]    | `testAddToCart`      *(to be implemented)*            |
| 3.5 | Buy Now button – Redirects to checkout | [ ]    | `testBuyNowRedirect` *(to be implemented)*            |
| 3.6 | Product description & details – Visible, complete | [ ]    | `testProductDescriptionDetails` *(to be implemented)* |
| 3.7 | Reviews section – Loads, paginates | [ ]    | `testReviewsSection` *(to be implemented)*            |
| **4. Cart Page** ||        |                                                       |
| 4.1 | Item listing – Name, quantity, price, image correct | [ ]    | `testCartPageItem`                                    |
| 4.2 | Quantity selector – Updates total price | [ ]    | `testQuantitySelector` *(to be implemented)*          |
| 4.3 | Remove item – Updates count and total | [ ]    | `testRemoveItemFromCart` *(to be implemented)*        |
| 4.4 | Proceed to Checkout – Leads to checkout flow | [ ]    | `testProceedToCheckout` *(to be implemented)*         |
| **5. User Account (Requires Login)** ||        |                                                       |
| 5.1 | Sign-in form – Validates inputs | [ ]    | `testLoginFormValidation` *(to be implemented)*             |
| 5.2 | Error messages – Show for wrong credentials | [ ]    | `testLoginErrorMessages` *(to be implemented)*        |
| 5.3 | Profile page – Name, email, links visible | [ ]    | `testProfilePageVisibility` *(to be implemented)*     |
| 5.4 | Order history – Correctly listed | [ ]    | `testOrderHistory` *(to be implemented)*              |
| **6. Checkout Flow** ||        |                                                       |
| 6.1 | Address selection – Adding/selecting works | [ ]    | `testAddressSelection` *(to be implemented)*          |
| 6.2 | Payment method selection – Options visible/selectable | [ ]    | `testPaymentMethodSelection` *(to be implemented)*    |
| 6.3 | Order summary – Details, prices, taxes correct | [ ]    | `testOrderSummary` *(to be implemented)*              |
| 6.4 | Place your order – Leads to confirmation | [ ]    | `testPlaceYourOrder` *(to be implemented)*            |
| **7. Footer & Navigation** ||        |                                                       |
| 7.1 | Footer links – Open correct pages | [ ]    | `testFooterLinks` *(to be implemented)*               |
| 7.2 | Back to top button – Scrolls page to top | [ ]    | `testBackToTopButton` *(to be implemented)*           |
| **8. Cross-Browser & Responsiveness** ||        |                                                       |
| 8.1 | Layout on Chrome, Firefox, Edge, Safari | [ ]    | `testCrossBrowserLayout` *(to be implemented)*        |
| 8.2 | Responsiveness – Desktop, tablet, mobile | [ ]    | `testResponsiveLayout` *(to be implemented)*          |
| **9. Performance & Load Indicators** ||        |                                                       |
| 9.1 | Loading spinners – Appear/disappear correctly | [ ]    | `testLoadingSpinners` *(to be implemented)*           |
| 9.2 | Lazy-loaded images – Appear on scroll | [ ]    | `testLazyLoadedImages` *(to be implemented)*          |
