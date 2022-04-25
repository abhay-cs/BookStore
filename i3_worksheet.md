What technical debt has been cleaned up
========================================
Commits:
https://code.cs.umanitoba.ca/winter-2022-a01/group-7/book-ordering-system/-/commit/2181f3907547aa873afbf3bbb502b80a97817e93
https://code.cs.umanitoba.ca/winter-2022-a01/group-7/book-ordering-system/-/commit/0242566de2a5fb953553acaf14d4a16919fa9e85
User Story:
https://code.cs.umanitoba.ca/winter-2022-a01/group-7/book-ordering-system/-/issues/14

Originally we tried to implement the search feature in iteration 2 but we were having trouble with our database so it never got fully implemented and had to be pushed into iteration 3. We didn't want to release an unfinished feature or a fake search bar so it was for the best that we moved it and giving us more time to work on it. The type of debt we took was deliberately prudent because in interation 2 we didn't have enough time to complete it so we pushed it all to the next iteration and dealt with it now.


What technical debt did you leave?
==================================
One item that I would like to fix but can't was our book product page. We would've liked to have real pictures of each book being sold but we couldn't get it to work so we ended up just going with a default book icon for all the books in the store.
The debt is reckless and inadverdent because we spent a lot of time trying to figure it out but had to fall back on an alternative plan and if there was an iteration 4 it would've been finished then.



Discuss a Feature or User Story that was cut/re-prioritized
============================================

A feature/user story that was cut during our project was being able to write reviews on books and give a "star" rating. It was dropped because we realized that we didn't have enough time to complete it and it was not one of our highest priority features compared to other user stories.
https://code.cs.umanitoba.ca/winter-2022-a01/group-7/book-ordering-system/-/issues/4


Acceptance test/end-to-end
==========================
So for one of the end to end tests we tested the account creation feature where they would click to sign up then enter a user name and password. Once they have created the account we would sign out by exiting the application and then check if the account creation was stored and working by resigning into the app with the new account.
It isn't flaky because our login/sign up will always have the same steps to complete and the database will always have a record of all accounts made from the very beginning till now and we aren't deleting accounts so the tests should always work.

Link: src/app/src/androidTest/java/com/uom/thebookstore/ui/AcceptanceTestLoginRegister.java

Acceptance test, untestable
===============

It was easy to start with but had issues with the device while performing actions on the app, like back button issue, soft keyboard open issue on a text field.


Velocity/teamwork
=================
Our velocity got better throughout the course because the start was difficult because we didn't have a foundation yet, but after we got our footing we started to get used to working on our project and got a better understanding of what we wanted.

Search feature: https://code.cs.umanitoba.ca/winter-2022-a01/group-7/book-ordering-system/-/issues/14

Descriptions for books: https://code.cs.umanitoba.ca/winter-2022-a01/group-7/book-ordering-system/-/issues/30

These features 2 features in our iteration 3 were delivered almost around the estimated time which is much better than our previous iterations.
 
While in Iteration 1 we underestimated how much time it would take to set up the database and all the objects needed.