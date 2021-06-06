numList = list(input("Enter the numbers for a list: ").split(','))
sum = 0
for number in numList:
    sum += int(number)
print(sum)