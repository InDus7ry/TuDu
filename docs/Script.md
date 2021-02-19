This is a video demonstration of my task management application, TuDu, designed to improve the client's, my, task management system.

***start up***

On start up, the user is prompted with a login screen. If they click ***yes*** without typing the correct username and password they well be re-prompted. If they click ***no*** the program will exit. When the correct username and password are typed in, the program encrypts that data and compares it to stored, encrypted passwords. This user system is easily extendable: I could add an "add users" button into the JOptionPane and create user-specific tasks.

***log in***

Next, the program opens the main screen. Here we can see tasks, see events, open settings, add items, and view completed tasks. As you can see the proportion of Events and Tasks can be changed to the users liking, meeting *success criteria 6*

***add task***

Users can add tasks and events in this screen with ease: the first half of *success criteria 1* 

***Type name, add members, add reminder***

Both the name and members fields take in and store raw strings

Users can add due dates to tasks by setting reminders when they want one; this meets *success criteria 2*. These reminders ensure proper dates and times with the use of regular expressions

They can also add due dates to tasks and events, meeting *success criteria 3*

Here, *success criteria 4* is also met with this priority slider

***Set priority and save***

***add event***

As you can see the user can also add events with ease, meeting *success criteria 1*

I will now add some tasks and events to showcase the sorting of tasks.

***create 3 more tasks***

***create 2 more events***

As you can see tasks are color coded and sorted by priority and events are sorted by date.

***complete a task***

Now that I have completed a task it will  show up in the completed window, meeting success criteria 5

***open settings***

Here in the settings window I can change the color of the background, meeting *success criteria 7*

***change color***

There are three buttons here, Quit, Confirm and Cancel

Confirm will change the color, Cancel disposes of the window and Quit exits the program

***cancel***

***confirm***

***quit***

***restart***

we now see that the tasks are still here despite the application's closing.

This program could be expanded in the future by allowing the user to see task and event metadata. This would be easily implemented because the methods for retrieving such data are mostly implemented.

I could also add functional notifications by letting the program run in the background or by using  something like the java mail API. This is easily implemented because reminders stored converted to LocalTime and LocalDate already.

I hope to port this application to Android and add some form of cloud storage. This could be accomplished with relative ease because Android works well with java and my file system could probably be adapted to cloud storage.