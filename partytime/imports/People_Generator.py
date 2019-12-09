from faker import Faker
import random

f = open("people.txt", "w")
fake = Faker(['en_US', 'en_AU', 'en_CA', 'en_GB', 'en_NZ', 'es_ES', 'fr_FR'])
f.write('ID,Name,Age,Humor,Empathy,Attractiveness,Intelligence,Charisma\n')

c = int(input("how many profiles do you want? "))
for _ in range(c):
    f.write(str(_ + 1) + ',' + fake.name() + ',')
    f.write(str(random.randint(18, 65)) + ',')
    for __ in range(4):
        str1 = str(round(random.random() * 2, 2))
        f.write(str1 + ',')
    f.write(str(round(random.random() * 2, 2)) + '\n')
