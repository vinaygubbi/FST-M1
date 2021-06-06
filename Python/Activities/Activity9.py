# Given lists
listOne = [10, 23, 22, 11, 17]
listTwo = [13, 42, 23, 36, 12]

# Print the lists
print("First List ", listOne)
print("Second List ", listTwo)

# Declare a third list that will contain the result
thirdList = []

# Iterate through first list to get odd elements
for num in listOne:
    if (num % 2 != 0):
        thirdList.append(num)
        
# Iterate through first list to get even elements
for num in listTwo:
    if (num % 2 == 0):
        thirdList.append(num)

# Print result
print("result List is:")
print(thirdList)