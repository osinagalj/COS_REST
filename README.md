# REST- Condition management system cow body

Rest API developed in Java using the SpringBoot framework

# General
The body condition score is a numerical value between 1 and 9 that is assigned to a cow by an expert vet while the cows are milked or passed through a chute. The score of body condition is an indicator that estimates stored body fat and balance accumulated energy from cows. This indicator influences milk production, reproduction and health of cows destined for dairy production or meat production. In In this sense, ISISTAN has developed, through a doctoral scholarship, a system of estimation of body condition using images of the back of a cow that is passed through an estimation process. This “estimation process” uses a recognized technique of Image-based prediction called deep learning. The objective of this work is to use the concepts of Web Services, both SOAP (partial of the subject) and REST (end of the subject), and the technological knowledge acquired in the chair to generate a system that allows you to manage the values ​​predicted by the body condition estimation system.


# URL Example

cows
- https://restappcows.herokuapp.com/api/v0/cows

herds
- https://restappcows.herokuapp.com/api/v0/herds

# Services
- A user to register an animal. [Link](https://restappcows.herokuapp.com/api/v0/cows/1)
- A user associates an animal with a herd. [Link](https://restappcows.herokuapp.com/api/v0/herds)
- A user gets all the information about an animal, including the last bcs. [Link](https://restappcows.herokuapp.com/api/v0/cows/extra)
- A user obtains all the information of a herd, including the average bsc [Link](https://restappcows.herokuapp.com/api/v0/herds/extra)
- A user sets an alert for a specific animal. [Link](https://restappcows.herokuapp.com/api/v0/cowAlerts)
- A user sets an alert for a specific herd. [Link](https://restappcows.herokuapp.com/api/v0/herdAlerts)