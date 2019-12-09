# Person.md

![imgur](https://i.imgur.com/wpcmfKB.png)
#### Hint: Some syntax, like the tables and the checklist, are Github-specific
@crimsonpython24

## Debug to-do
***fix unsorted `array` bug in binary search methods***

### Variables:
* `int age`
* `String name`
* `private final int id`
* `private final double empathy, attractiveness, intelligence, charisma`
* `private Person_Impression [] impressions`
* `Person_Topic [] topics`
* `Party.guests: Person[] guests`

### Methods:
- [x] Basic `get` and `set` methods ![imgur](https://i.imgur.com/3xFwsqo.png)
- [x] public double getInterestLevel(int id, String name)
  - passes in a user's ID as an argument and returns its interest level
  - the interest level is specific to a topic named `name`
- [x] public double updateInterestLevelManual(int id, String name, double tk)
  - same changes as above, made function specific for a topic matching `name`
- [x] public double listen(Person p, Topic t)
  - takes a person speaking and the topic they are speaking about
  - returns a score based on their interest and empathy settings from 0 to 2.
- [ ] private void judge(Person p, Topic t)
  - forms an internal Impression about that person from the topic they are talking about and their non-verbal attributes.
- [x] private void updateInterestLevel(String name, double tk, boolean upOrDown)
  - if someone is very interesting or compelling, then it's possible that a person may update their own interest
  - a factor from 0.7 to 1.3 (+/- 30%). the boolean upOrDown determines to increase or decrease the factor
  - by the same token, if someone really is negative, then they may decrease a person’s enjoyment of that topic.
- [x] public Topic speak()
  - return a topic to talk about in a conversation.
- [x] public double getAttribute(String arg)
  - returns a `final` variable of a person given the argument `arg` to simplify code. Includes:
    ![Imgur](https://i.imgur.com/VNn2cub.png)
- [x] public Impression getImpression(int id)
  - takes an ID of a person and returns the impression between this user and the given user with ID `id`
#### *Note that all italicized functions are dealing with `final` variables*


### Dummy classes
#### Person_Impressions
Variables | Methods | Accessbility | Type
------------ | ------------- | ------------ | -------------
id | `get` | private | int
interesting | `set` | private | double
attractive | `set` | private | double
kind | `set` | private | double
chemistry | `set` | private | double

#### Person_Topic
Variables | Methods | Accessbility | Type
------------ | ------------- | ------------ | -------------
name | `get` | private | String
interest | `get, set` | private | double
importance | `get, set` | private | double

### Utility Classes
#### Dependencies
1. `java.util.Random` -- generate tokens to change an impression
#### BinarySearch
A more effective algorithm to search through an array; remember to change the input types before running another program.
```java
// String x is the name of a person and int x is a person's ID
public static int binarySearchTopic(Person_Topic arr[], int l, int r, String x)
public static int binarySearchImpression(Person arr[], int l, int r, int x)

public static boolean verifyAttributes(double hm, double em, double at, double in, double ch)
public static boolean verifyPercentage(double pt)
```
## Contact
Please [mail me](mailto:16064@hcas.com.tw) if you have any concerns regarding any file under my name.

Do ~~spam~~ ***not*** spam into my inbox as this is a _school server_ and it's comparable to a windows xp machine :skull_and_crossbones::shit:

> Sometimes it is the people no one imagines anything of who do the things that no one can imagine - Alan Turing
