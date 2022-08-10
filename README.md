Vulpe Andrei - Tema 6 - 05.08.2022
-------------------------------------------------------------------------------
The goal of this homework is to implement a small API for handling patients in 
a small hospital. In the app you can store doctors, each one of them having 
a specialty and a list of patients assigned to them. Each patient have assigned
visits.
-------------------------------------------------------------------------------
Requirements:
• Method to get all doctors
• Method to assign a patient to a doctor (throw an error if the doctor does not 
exist)
• Method to get all doctors of one specialty (throw an error if the specialty
does not have any doctors)
• Method to get all patients 
• Method to get a patient by his CNP
• Method to display all visits of a patient
• Method to display all visits of a certain specialty
-------------------------------------------------------------------------------
Implementation:
The project contains the packages:
- Application
- Controllers
- DTO
- Exception
- Mapper
- Model
- Repository
- Service

Each package contains Java Spring Classes for each table found in the database:
- Doctor 
- Patient 
- Visit

 
