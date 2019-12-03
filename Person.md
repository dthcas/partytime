# Person.java
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

### Methods:
- [x] public int getAge()
- [x] public void setAge(int a)
- [x] public String getName()
- [x] public void setName(String n)
- [x] public double getInterestLevel(String name)
  - takes the name of a topic and returns how interested that person is from 0 to 2
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
- [ ] public Impression getImpression(int i)
  - takes an ID of a person and returns the impression of that person

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
public static int binarySearch(Person_Topic arr[], int l, int r, String x) { 
    if (r >= l) { 
        int mid = l + (r - l) / 2; 
        if (arr[mid].getName().compareTo(x) == 0) return mid; 
        if (arr[mid].getName().compareTo(x) > 0) {
            return binarySearch(arr, l, mid - 1, x); 
        }
        return binarySearch(arr, mid + 1, r, x); 
    }
    
    return -1; 
} 
```
## Contact
Please [mail me](mailto:16064@hcas.com.tw) if you have any concerns regarding any file under my name.

Do ~~spam~~ ***not*** spam into my inbox as this is a _school server_ and it's comparable to a windows xp machine :skull_and_crossbones::shit:

> Sometimes it is the people no one imagines anything of who do the things that no one can imagine - Alan Turing
