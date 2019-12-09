from faker import Faker
import random

f = open("people.txt", "w")
fake = Faker('en_US')
f.write('ID,Name,Age,Humor,Empathy,Attractiveness,Intelligence,Charisma\n')

for _ in range(200):
    f.write(str(_ + 1) + ',' + fake.name() + ',')
    f.write(str(random.randint(18, 65)) + ',')
    for __ in range(4):
        f.write(str(round(random.random() * 2, 2)) + ',')
    f.write(str(round(random.random(), 2)) + '\n')
