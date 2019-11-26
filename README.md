# partytime
A project which aims to model a party scenario

Semester One Project: Party Time

For this lab you will work as a group.  Your goal is to write a program to simulate a party.  In a party, many people interact and talk with each other.  Each person at the party interacts with other people by being assigned a partner with each change of the music.  At the end of the party, the program should give a rating of each person’s opinion about the other people. 

To practice what it will be like to work in a team environment, all coders will work on the different classes and methods simultaneously. How the other coders implement these classes will be up to them, providing they make available the public fields and methods listed.

The party program will use the following classes:

Party – a class which handles all aspects of the party and keeps track of guests and conversations, starting and ending times and when the music will change.  It will match up people and put them into conversations, so that everyone at the party gets a chance to meet others and get to know them.
Person – class for a person attending the party.  The person will have a number of different likes, dislikes and attributes, such as listening skill, sense of humor and attractiveness, which will influence how others like or dislike them.  They will also keep a record of the people they meet and their opinion on them.  The person is able to talk and listen so they can communicate their interests and feelings with others in a conversation.  The person’s own attributes may affect their conversation too.
Conversation – A class to track a conversation between two people at the party and how long it runs for.  The conversation will also ask each person to say something on a topic which the other person can listen to and this is how people can get to know each other and form their opinions.  If a person doesn’t have any prior interest in a topic, then a random interest level can be generated.
Impression – A class which holds the impression one person has about another person.  It will contain that person’s ID and scores for how interesting, how much chemistry they have.  If any of these scores is higher than that person’s friend level score, then that person is considered a friend. 
Chemistry – is a class that can take two people and use their attributes, star signs or some random (but repeatable) calculation to come up with that pair’s chemistry.

For the first class, discuss the plan for the party program and the methods and fields needed to achieve a good interaction.  Also consider what attributes people should have and whether you can survey real people and use their results to test the program with.  A sample output might go something like:

Party Begins…
There are 6 guests.
Song 1 starts.
Mike and Bernice are having a conversation.
Mike finds Bernice quite attractive.
Bernice has a little chemistry with Mike.
Mike says he likes basketball.
Bernice yawns.
Bernice talks about kittens for a while.
Mike pretends to listen but got distracted by something.
Chelsea and Christine are having a conversation.
Chelsea has good chemistry with Christine.
Christine finds Chelsea attractive.
Chelsea mentions that she likes animals.
Christine says she likes animals too.
Christine talks a lot about piano.
Chelsea tries to talk about something else.
…
Music changes to Song 2
Mike and Chelsea are having a conversation.
Mike fell in love with Chelsea.
Chelsea has a good feeling about Mike
Chelsea talks about books.
Mike says he likes books too.
Mike tells Chelsea he thinks she’s attractive.
Chelsea blushes.
…
Party Ends…
Mike and Chelsea are friends.
Christine and Chelsea are friends.
Bernice likes Sarah.
Sarah really hates Bernice.
…

The various interactions above will be created by having various responses for each person to different topics.  There can also be some random variation in how a person responds.  The output above is only an example of how two people might interact, however you may adjust this.  Responses to conversations will vary depending on interest.  If someone has very little interest, they may respond poorly, but if they are very interested their answer may be quite enthusiastic.  Chemistry itself may be a static method, which is just used to create an initial impression and influence the other aspects of that person’s impression.

Remember, it’s not necessary to have complex code.  The complexity comes from the interactions of all the parts of the system, their ability to update and change, and some random elements which keep the party fresh.

We will tackle this project in the following order:

Part 1 – Program Outline and Design			
Part 2 – Coding and Collaboration
Part 3 – Integration and Output Testing		
Part 4 – Reflection and Improvement

