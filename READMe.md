# Spring MVC Film C.R.U.D.

## Authors

* Rachel Richardson
* Matthew Lee

## About this Project

* This Project showcases a Film Database Website using Spring MVC C.R.U.D
* This Website is connected to an SQL Database that stores a Film's Information
* Users of this Website are able to retrieve a Film's:
  * Unique ID Number
  * Title
  * Year released
  * Description
  * Actors starred

## Site Navigation

* The Website is easy to Navigate
* Its layout is comprised of:
  * A Home Page where Users can search for a Film by its ID or by search query on the Film Title or Description
  * The Home Page additionally provides a link to 'Add' a new Film to the Database itself
* If a User looks up a Film by ID Number and if found, they will be able to view the Film's Info and the Actors starred in the Film
  * Links are provided to Edit Film Info or Delete the Film from the Database
* If a User searches by search query, they will be redirected to the Search Results
  * Only the Film's Title, Year Released, and Description are listed to ensure an easy-to-view list
  * Search Results will be listed numerically at the bottom as well
* If a User chooses to Delete a Film, they must first view the Film's Info using the ID or query search and then select the link to do so
  * Once the delete option is selected, the User may enter the ID Number of the Film or the Title or Description
  * A deletion confirmation is provided and the Film is removed from the Database
* To Update a Film's information, the User will select the link to do so once the results for an ID or query search are successful
  * The User will then be redirected to a Form to update a Film's Information
* To Add a Film, a User may select the Option on the Home Page
  * When selected, the User is redirected to a form to fill out the New Film's Information: Title, Year Released, and Description

## Technologies Used
* Java
* Spring MVC
* SQL
* XML
* HTML/CSS
