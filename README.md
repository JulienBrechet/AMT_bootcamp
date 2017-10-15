# AMT BOOTCAMP

This is our first multi-tiered application,
allowing the user to manage a large
list of random people. People are
stored in a database.

## Getting Started

Clone the whole project or just the "images" and "topology-amt" folders if you don't need the sources.

### Prerequisites

You first have to install docker to run the images


## Deployment

Open the docker terminal and go to the "topology-amt" folder. There is a file called "docker-compose.yml". 

Enter the line command : docker-compose up --build.

It will build and run all the images with the good configuration (glassfish, phpmyadmin and mysql).
Then open your web browser and and go to the following url: <http://192.168.99.100:8080/Bootcamp-1.0-SNAPSHOT/>.

You are supposed to land on the login page where the default login is "admin" and the default password is "admin". Sign in and then you can visit the app.


Note: if the redirection goes to "pages/home" but the web browser is still displaying the login page, then try with a private navigation.

## Authors
Julien Brêchet and Adrien Marco


## Acknowledgments

Starting template: Olivier Liechti

