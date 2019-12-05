# Person.java
#### Hint: Some syntax, like the tables and the checklist, are Github-specific
@crimsonpython24
### Variables:
* `int age`
* `String name`
* `private final int id`
* `private final double empathy`
* `private final double attractiveness`
* `private final double intelligence`
* `private final double charisma`
* `private Person_Impression [] impressions`
* `Person_Topic [] topics`
* `Party.guests: Person[] guests`

### Methods:
- [x] public int getAge()
- [x] public void setAge(int a)
- [x] public String getName()
- [x] public void setName(String n)
- [x] *public double getInterestLevel(String name)*
- [x] *public double updateInterestLevel(String name, double tk*
  1. this function and the function above are not merged into the getImpression and updateImpression methods (respectively) as not to overcomplicate the code
- [ ] public double listen(Person p, Topic t)
  - takes a person speaking and the topic they are speaking about
  - returns a score based on their interest and empathy settings from 0 to 2.
- [ ] private void judge(Person p, Topic t)
  - forms an internal Impression about that person from the topic they are talking about and their non-verbal attributes.
- [ ] private void updateInterestLevel(String name, double factor)
  - if someone is very interesting or compelling, then it's possible that a person may update their own interest
  - a factor from 0.7 to 1.3 (+/- 30%).
  - by the same token, if someone really is negative, then they may decrease a person’s enjoyment of that topic.
- [ ] public Topic speak()
  - return a topic to talk about in a conversation.
- [x] public double getAttractiveness()
- [x] public Impression getImpression(int id, String topic)
  - takes an ID of a person and returns the impression of a specific topic
- [x] public void updateImpression(int id, String name, double tk)
  - takes an ID of a person and updates his or her impression of a specific topic
  1. The original method was to return the impression one has on another person, but this feature will be added later as the impressions variable is linked to topic.
  2. the interest level and impressions are interlinked. InterestLevel functions worked for a specific item while Impressions change a user


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
```
## Contact
Please [mail me](mailto:16064@hcas.com.tw) if you have any concerns regarding any file under my name.

Do ~~spam~~ ***not*** spam into my inbox as this is a _school server_ and it's comparable to a windows xp machine :skull_and_crossbones::shit:

> Sometimes it is the people no one imagines anything of who do the things that no one can imagine - Alan Turing
