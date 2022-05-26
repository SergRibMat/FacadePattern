# FacadePattern

This is a small project i did to practice the implementation of the FacadePatters and to apply the 
Single Responsibility Principle, the first Rule of SOLID principles.

Here, you have 2 different Main Kotlin files.

- Main -> First try
- PaymentMainClass -> Real world solution

for this real world solution, I applied this pattern and principle solid to design a scalable way to keep adding different
implementations for bank android applications (but it can be applied for any kind of request/response communication between Android Applications, 
although there is no android objects here).

After i read a captcher of a book named "Clean Architecture", i realized that we could improve the design we had to handle the stringyfied
responses that we recieve and the URIs with json data that we send to 3rd party bank apps, so i created this little piece of training to
see how it would look like (just an aproach).

Good things about using this design

- the use of 1 of the well-known Object Oriented Design Patterns (Facade Pattern)
- It makes it scalable and easy to maintain. You only need to create a new class, implement from the response interface and add a new case to the when statement
- It respects the Single Responsibility Principle, because the actions are clearly separated, so different "actors" (different apps in this particular case) can use its implementation and will never have a conflict with each other in case of updates

Thanks for reading my post :D





